import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// This class is written for the purpose for creating a connection and closing the connection
public class MyConnect {
    private static String url = "jdbc:mysql://localhost:3306/employee_database";
    private static String username = "root";
    private static String password = "Chetan@2002";

    static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    }

    static void close(ResultSet result, Statement stmt, Connection con) {
        try {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
            if (con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
