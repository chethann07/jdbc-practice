import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdatingDataAcceptingInput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int salary;
        String department;
        String q = "UPDATE `employee` SET `salary` = `salary` + ? WHERE `department` = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;

        System.out.println("Enter the salary");
        salary = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the salary");
        department = scan.nextLine();

        try {
            con = MyConnect.connect();
            pstmt = con.prepareStatement(q);
            pstmt.setInt(1, salary);
            pstmt.setString(2, department);
            int x = pstmt.executeUpdate();
            System.out.println(x);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyConnect.close(result, pstmt, con);
        }
        scan.close();
    }
}
