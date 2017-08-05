package DataBase;

import Commons.Properties;
import Model.Product;

import java.sql.*;

/**
 * Created by jhgonzalez on 7/15/17.
 */
public class ConnectDB {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Properties pro;


    public Connection connectToDB() {

        try {

            this.loadProperties();
            //Cargamos el driver para conectarnos a MySQL
            Class.forName("com.mysql.jdbc.Driver");

            //Load Properties
            if (pro != null) {
                connect = DriverManager.getConnection(pro.getDbUrl() + pro.getDbName() + "?autoReconnect=true&useSSL=false", pro.getDbUser(), pro.getDbPassword());
            }
            //connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?autoReconnect=true&useSSL=false","admin","1234");

            return connect;


            // Este Catch lo que permite atajar un posible error que puede ocurrir durante la coneccion a la BD
        } catch (Exception e) {

            //Si durante la coneccion a la base de datos se produce algun error este codigo se ejecutara.
            System.out.println("Error to try connect your database");
            System.out.println("This is the error: " + e.getMessage());
            return null;
        }

    }

    private void loadProperties(){
        Properties properties = new Properties();
        pro = properties.loadAllProperties();
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            resultSet.getInt("idProducto");
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("description"));
            System.out.println(resultSet.getInt("price"));
            resultSet.getString("category");
        }
    }

    // You need to close the resultSet
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            System.out.println("This is the error: " + e.getMessage());
        }
    }


    public ResultSet getAllDataPersons(){

        try {
            statement = connect.createStatement();
            return statement.executeQuery("select * from person");

        } catch (Exception e){
            System.out.println("Error when you try update...");
            System.out.println("This is the error... " + e.getMessage());
            return null;
        }

    }

    public void updateData(int valueToUpdate){
        try {
            statement = connect.createStatement();
            statement.executeUpdate("update person set per_credit = " + valueToUpdate + " where per_id = 2");

        } catch (Exception e){

            System.out.println("Error when you try update...");
            System.out.println("This is the error... " + e.getMessage());
        }
    }

    public boolean insertProduct(Product product){
        try {
            String sql = "INSERT into product (name, description, price, category) VALUES ('" + product.getName() +"','" + product.getDescription() +"'," + product.getPrice() +",'"+product.getCategory() +"')";
            System.out.println(sql);
            statement = connect.createStatement();
            return statement.execute(sql);

        }catch (Exception e){
            System.out.println("Error to try insert a Product");
            System.out.println("The error is " + e.getMessage());
            return false;
        }
    }
}
