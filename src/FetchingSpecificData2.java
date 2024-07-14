import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchingSpecificData2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int id, salary;
        String name, department;
        String q = "SELECT * FROM employee WHERE salary > ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;

        System.out.println("Enter the salary");
        salary = scan.nextInt();

        try {
            con = MyConnect.connect();
            pstmt = con.prepareStatement(q);
            pstmt.setInt(1, salary);
            result = pstmt.executeQuery();

            boolean hasResult = false;

            while (result.next()) {
                hasResult = true;
                id = result.getInt(1);
                name = result.getString(2);
                department = result.getString(3);
                salary = result.getInt(4);
                System.out.printf("%d  %-9s  %-10s  %d \n", id, name, department, salary);
            }

            if (!hasResult) {
                System.out.println("No employee found with the given ID.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            MyConnect.close(result, pstmt, con);
        }

        scan.close();
    }
}