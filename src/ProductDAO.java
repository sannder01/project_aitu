import java.sql.*;

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
    public void showAllProducts() {
        String sql = "SELECT number, name, zadacha FROM public.tasks ORDER BY number";

        try (Connection connect = Database.connect();
             PreparedStatement stmt = connect.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n===== СПИСОК ТОВАРОВ =====");

            boolean empty = true;
            while (rs.next()) {
                empty = false;

                int number = rs.getInt("number");
                String name = rs.getString("name");
                String zadacha = rs.getString("zadacha");

                System.out.println(number + " | " + name + " | " + zadacha);
            }

            if (empty) {
                System.out.println("Список пуст.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}