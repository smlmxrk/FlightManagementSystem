package mark.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("src/main/resources/db.properties"));

                String url = properties.getProperty("db.url");
                String user = properties.getProperty("db.user");
                String password = properties.getProperty("db.password");

                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Database connection successful!");
            } catch (IOException | SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to connect to database!");
            }
        }
        return connection;
    }



}
