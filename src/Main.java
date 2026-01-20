import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;


class Product{
    String name;
    int price;

    Product(String name,int price){
        this.name=name;
        this.price=price;
    }
    void showTowar(){
        System.out.println(name + " - " + price);
    }

    public String getName(){return name;}
    public int getPrice(){return price;}

}
public class Main{
    public static void main(String[] args) {
        if(Database.connect()!=null){
            System.out.println("database connected");
        }
        Scanner cin = new  Scanner(System.in);
        String name = cin.nextLine();
        int price = Integer.parseInt(cin.nextLine());
        Product pro =  new Product(name, price);
        ProductDAO dao = new ProductDAO();
        dao.addProduct(pro);
    }
}
