package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private final Connection connection = Util.getConnection();

    public void createUsersTable() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE User( id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, name VARCHAR(255), lasytName VARCHAR(255), age INT ); ");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE User");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERTE INTO(name, lastName, age) User VALUES(?)");
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        try {
            assert connection != null;
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM User WHERE id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        try {
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User");
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                byte age = resultSet.getByte("age");
                List<User> userList = new ArrayList<User>((Collection<? extends User>) resultSet);
                return userList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public void cleanUsersTable() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM User");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}