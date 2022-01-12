package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args)  {
        User user1 = new User("Ivan","Pupkin", (byte) 29);
        User user2 = new User("Irina","Pupkina", (byte) 31);
        User user3 = new User("Hoon", "Byeon", (byte) 31);
        User user4 = new User("Vasilisa", "Socolova", (byte) 28);
        UserDaoJDBCImpl uss = new UserDaoJDBCImpl();

        UserServiceImpl user = new UserServiceImpl();
        user.createUsersTable();




    }
}
