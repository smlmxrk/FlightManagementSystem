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
                try (FileInputStream fis = new FileInputStream(DBConnection.class.getClassLoader().getResource("db.properties").getFile())) {
                    properties.load(fis);
                }

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

    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Connection is valid: " + conn.isValid(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            }
        }
    }



// remember the db properties isn't on laptop, configure later