import java.sql.Connection;
import java.sql.Statement;

public class DeleteData {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        String q = "DELETE FROM `employee` where `employee_id` = 7";

        try {
            con = MyConnect.connect();
            stmt = con.createStatement();
            int x = stmt.executeUpdate(q);
            System.out.println(x);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyConnect.close(null, stmt, con);
        }

    }
}
