import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BatchUpdate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int employee_id, salary;
        String employee_name, department, ch;
        String url = "jdbc:mysql://localhost:3306/employee_database";
        String username = "root";
        String password = "Chetan@2002";
        String q = "INSERT INTO `employee`(`employee_id`,`employee_name`,`department`,`salary`) VALUES (?,?,?,?)";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            pstmt = con.prepareStatement(q);

            while (true) {
                System.out.println("Enter the employee id");
                employee_id = scan.nextInt();

                scan.nextLine();

                System.out.println("Enter the employee name");
                employee_name = scan.nextLine();

                System.out.println("Enter the department");
                department = scan.nextLine();

                System.out.println("Enter the salary");
                salary = scan.nextInt();

                pstmt.setInt(1, employee_id);
                pstmt.setString(2, employee_name);
                pstmt.setString(3, department);
                pstmt.setInt(4, salary);

                pstmt.addBatch();

                System.out.println("Do you want to add more (y/n)?");
                ch = scan.next();

                if (ch.equals("n")) {
                    break;
                }
            }
            int arr[] = pstmt.executeBatch();
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyConnect.close(null, pstmt, con);
        }
        scan.close();
    }
}
