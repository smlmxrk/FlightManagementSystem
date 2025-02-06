package mark.test.dao;
import mark.dao.UserDAO;
import mark.model.User;
import mark.util.DBConnection;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAOTest {

    public static void main(String[] args) {

    }

    private static void testRegisterUser(User user) {
        User user1 = new User(001, "testUser1", "password");
        //UserDAO.registerUser(user1);
        // some bullshit
    }
}

// todo: figure out test methods/program logic
