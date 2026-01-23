import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;


class Product{
    String name;
    int number;
    String zadacha;

    Product(String name,int number, String zadacha){
        this.name=name;
        this.number=number;
        this.zadacha=zadacha;
    }
    void showTowar(){
        System.out.println(name + " - " + number + " - " + zadacha);
    }

    public String getName(){return name;}
    public int getNumber(){return number;}
    public String getZadacha(){return zadacha;}

}
public class Main{
    public static void main(String[] args) {
        if(Database.connect()!=null){
            System.out.println("database connected");
        }
        Scanner cin = new  Scanner(System.in);
        int number = Integer.parseInt(cin.nextLine());
        String name = cin.nextLine();
        String zadacha = cin.nextLine();
        Product pro =  new Product(name, number, zadacha);
        ProductDAO dao = new ProductDAO();
        dao.addProduct(pro);
        System.out.print("Enter task number to delete: ");
        int num = cin.nextInt();
        dao.delProduct(num);
    }
}