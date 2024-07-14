import java.sql.Connection;
import java.sql.Statement;

public class UpdatingData {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        String q = "UPDATE `employee` SET `salary` = `salary` - 5000 WHERE `department` = 'Tester'";

        try {
            con = MyConnect.connect();
            stmt = con.createStatement();
            int x = stmt.executeUpdate(q);
            if (x != 0) {
                System.out.println("Update Successfull");
            } else {
                System.out.println("Update Unsuccessfull");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyConnect.close(null, stmt, con);
        }
    }
}
