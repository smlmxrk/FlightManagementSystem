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

        UserDAO userDAO = new UserDAO();

        userDAO.registerUser("smlmxrk", "password1", "admin");

    }

}

// todo: figure out test methods/program logic
