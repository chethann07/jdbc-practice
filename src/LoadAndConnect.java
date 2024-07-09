import java.sql.DriverManager;
import java.sql.SQLException;

// This program loads the driver and connects to the database with the following db_name 
public class LoadAndConnect {
    public static void main(String[] args) throws Exception {
        // String url = api:vendor://ip-address:port-num/db_name
        String url = "jdbc:mysql://localhost:3306/employee_database";
        String username = "root";
        String pass = "Chetan@2002";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // This is to load the driver
            DriverManager.getConnection(url, username, pass); // This is to connect to the database
            System.out.println("Driver loaded and connected");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
