import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        String q = "INSERT INTO employee(employee_id,employee_name,department,salary) VALUES (6,'Chaitanya','Tester',26000)";

        try {
            con = MyConnect.connect();
            stmt = con.createStatement();
            int n = stmt.executeUpdate(q);
            System.out.println(n);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            MyConnect.close(null, stmt, con);
        }
    }
}
