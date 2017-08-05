package Controller;

import DataBase.ConnectDB;
import Model.Product;

import javax.swing.*;
import java.sql.Connection;

/**
 * Created by jhgonzalez on 7/22/17.
 */
public class ProductController {

    ConnectDB connectDB;
    Connection connection;

    public void saveProduct(String name, String description, String category, String price){

        Product product = new Product(name, description, category, Double.parseDouble(price));
        connectDB = new ConnectDB();
        try {
            connection = connectDB.connectToDB();
            if (connection != null){
                boolean result = connectDB.insertProduct(product);
                if (!result){
                    JOptionPane.showMessageDialog(null, "Save", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error", "InfoBox: ", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e){

        }

    }

}
