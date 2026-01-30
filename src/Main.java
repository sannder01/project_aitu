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
        Scanner cin = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== СИСТЕМА УПРАВЛЕНИЯ ТОВАРАМИ ===");

        while (running) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить новый товар");
            System.out.println("2. Удалить товар по номеру");
            System.out.println("3. Показать товары");
            System.out.println("4. Выход");
            System.out.print("Введите номер пункта: ");

            String choice = cin.nextLine();
            ProductDAO dao = new ProductDAO();

            switch (choice) {
                case "1":
                    System.out.print("Введите номер: ");
                    int num = Integer.parseInt(cin.nextLine());
                    System.out.print("Введите название: ");
                    String name = cin.nextLine();
                    System.out.print("Введите задачу/описание: ");
                    String task = cin.nextLine();

                    Product newProduct = new Product(name, num, task);
                    dao.addProduct(newProduct);
                    System.out.println("Товар успешно добавлен.");
                    break;

                case "2":
                    System.out.print("Введите номер товара для удаления: ");
                    int idToDelete = Integer.parseInt(cin.nextLine());
                    dao.delProduct(idToDelete);
                    System.out.println("Команда на удаление отправлена.");
                    break;

                case "3":
                    dao.showAllProducts();
                    break;

                case "4":
                    System.out.println("Завершение работы...");
                    running = false;
                    break;

                default:
                    System.out.println("Неверный ввод, попробуйте снова.");
            }
        }
        cin.close();
    }
}


