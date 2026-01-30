import java.sql.Connection;
import java.sql.DriverManager;

public class Database{

    static final String URL = "jdbc:postgresql://localhost:5432/group_project_sannder";
    static final String USER  = "postgres";
    static final String PASSWORD = "Smartdrv3";

    public static Connection connect(){
        try{
            return DriverManager.getConnection(URL,USER, PASSWORD);
        }
        catch(Exception e){
            System.out.println("no");
            e.printStackTrace();
            return null;
        }
    }

}