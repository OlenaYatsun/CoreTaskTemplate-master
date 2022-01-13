package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args)  {
        UserDaoJDBCImpl user = new UserDaoJDBCImpl();
        user.createUsersTable();
        user.saveUser("Ivan", "Pupkin", (byte) 29);
        user.saveUser("Irina", "Pupkina", (byte) 31);
        user.saveUser("Hoon", "Byeon", (byte) 31);
        user.saveUser("Vasilisa", "Socolova", (byte) 28);
        user.getAllUsers();
        user.removeUserById(1);
        user.cleanUsersTable();
        user.dropUsersTable();



    }
}
