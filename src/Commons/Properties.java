package Commons;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Created by jhgonzalez on 7/22/17.
 */
public class Properties {

    java.util.Properties properties = new java.util.Properties();
    private String path = "/Users/jhgonzalez/Desktop/MyApp/ME/Java/InventarioApp/src/Commons/Config.properties";

    private String dbUser;
    private String dbPassword;
    private String dbName;
    private String dbUrl;


    public Properties loadAllProperties(){
        try {
            File configFile = new File(path);
            FileReader reader = new FileReader(configFile);
            properties.load(reader);//Load File

            this.setDbUser(properties.getProperty("dbUser"));
            this.setDbName(properties.getProperty("dbName"));
            this.setDbPassword(properties.getProperty("dbPassword"));
            this.setDbUrl(properties.getProperty("dbUrl"));

            reader.close();
            return this;
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            return null;
        }

    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }
}
