package jm.task.core.jdbc.util;
import java.sql.*;


public class Util {
    final static String URL = "jdbc:mysql://localhost:3306/task?useSSL=false&serverTimeZone=UTC";
    final static String USERNAME = "Root1993";
    final static String PASSWORD = "root1993";
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected");
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            System.out.println(e);
        } catch(ClassNotFoundException a){
            a.printStackTrace();
        }
        return connection;
    }
    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}