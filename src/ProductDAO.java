import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAO {
    public void addProduct(Product pro) {
        String sql = "INSERT INTO public.tasks (number,name, zadacha) VALUES (?,?,?)";

        try (Connection connect = Database.connect();
             PreparedStatement stmt = connect.prepareStatement(sql)) {

            stmt.setInt(1, pro.getNumber());
            stmt.setString(2, pro.getName());
            stmt.setString(3, pro.getZadacha());

            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("inserted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delProduct(int taskNumber) {
        String sql = "DELETE FROM public.tasks WHERE number = ?";

        try (Connection connect = Database.connect();
             PreparedStatement stmt = connect.prepareStatement(sql)) {

            stmt.setInt(1, taskNumber);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Task deleted");
            } else {
                System.out.println("Task not found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}