import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

// To fetch a specific data from database
public class FetchingSpecificData {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        int id, salary;
        String name, department;
        String q = "SELECT * FROM employee WHERE employee_id = ?";

        System.out.println("Enter the ID :");
        id = scan.nextInt();
        try {
            con = MyConnect.connect();
            pstmt = con.prepareStatement(q);
            pstmt.setInt(1, id);
            result = pstmt.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
                name = result.getString(2);
                department = result.getString(3);
                salary = result.getInt(4);
                System.out.printf("%d  %s  %s  %d", id, name, department, salary);
            } else {
                System.out.println("No employee found with the given ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyConnect.close(result, pstmt, con);
        }
        scan.close();
    }
}
