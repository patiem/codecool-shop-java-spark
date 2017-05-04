import com.codecool.shop.controller.ProductController;
import com.codecool.shop.dao.SqliteJDBCConnector;
import com.codecool.shop.view.UserInput;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    static ProductController productController = new ProductController();

    public static void main(String[] args) {
        if(args.length > 0 && args[0].equals("--create-tables")){
            System.out.println("Test");
            try{
                SqliteJDBCConnector.createTables();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        System.out.println("1. List all products");
        System.out.println("2. List products by category");
        System.out.println("Select option");
        Integer option = UserInput.getUserInput();
        switch (option){
            case 1:
                productController.displayList();
                break;
            case 2:
                productController.listProductByCategory();
                break;
            default:
                System.out.println("Wrong option");
        }
    }


}
