import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchingData {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/employee_database";
        String username = "root";
        String password = "Chetan@2002";
        Connection con = null;
        Statement stmt = null;
        ResultSet result = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 1. Load the driver
            con = DriverManager.getConnection(url, username, password); // 2. Connect to the database
            System.out.println("Driver loaded and connected to the database" + con);

            stmt = con.createStatement(); // 3. Create a SQL statement
            result = stmt.executeQuery("SELECT * FROM employee"); // 4. Execute the SQL statement
            // System.out.println(result); prints the address of the result object

            // 5. Process the query
            while (result.next()) {
                System.out.println(
                        result.getInt(1) + "     " + result.getString(2) + "     " + result.getString(3) + "     "
                                + result.getInt(4));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
                stmt.close();
                con.close();
                System.out.println("Everything closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
