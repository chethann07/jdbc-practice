import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// This program accepts the input given by user using preparedstatment class 
public class InsertAcceptingData {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Connection con = null;
        PreparedStatement pstmt = null;
        int id, salary;
        String name, department;
        String q = "INSERT INTO employee(employee_id,employee_name,department,salary) VALUES (?,?,?,?)";

        System.out.println("Enter the ID");
        id = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the Name");
        name = scan.nextLine();
        System.out.println("Enter the Department");
        department = scan.nextLine();
        System.out.println("Enter the Salary");
        salary = scan.nextInt();

        try {
            con = MyConnect.connect();
            pstmt = con.prepareStatement(q);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, department);
            pstmt.setInt(4, salary);
            int x = pstmt.executeUpdate();
            if (x > 0) {
                System.out.println("Successfull");
            } else {
                System.out.println("Unsuccessfull");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            MyConnect.close(null, pstmt, con);
        }
        scan.close();

    }
}
