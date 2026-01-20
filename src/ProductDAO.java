import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAO {
    public void addProduct(Product pro){
        String sql = "INSERT INTO public.product (name,price) VALUES (?,?)";

        try (Connection connect = Database.connect();
             PreparedStatement stmt = connect.prepareStatement(sql)) {

            stmt.setString(1, pro.getName());
            stmt.setInt(2, pro.getPrice());

            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("inserted");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
}

