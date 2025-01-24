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
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("src/main/resources/db.properties"));

                String url = properties.getProperty("db.url");
                String user = properties.getProperty("db.user");
                String password = properties.getProperty("db.password");

                return DriverManager.getConnection(url, user, password);
            } catch (IOException | SQLException e) {
            e.printStackTrace();
            return null;
            }
        }

        public static void main(String[] args) {
        try (Connection conn =  DBConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Database connection is working!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            }
        }
    }




// remember the db properties isn't on laptop, configure later