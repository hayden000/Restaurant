package com.example.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class createTables {
    public static Connection connectToDatabase(String user, String password, String database) {
        System.out.println("------ Testing PostgreSQL JDBC Connection ------");
        Connection connection = null;
        try {
            String protocol = "jdbc:postgresql://";
            String dbName = "/restaurant/";
            String fullURL = "jdbc:postgresql://138.68.147.184:5432/restaurant";
            connection = DriverManager.getConnection(fullURL, user, password);
        } catch (SQLException e) {
            String errorMsg = e.getMessage();
            if (errorMsg.contains("authentication failed")) {
                System.out.println("ERROR: \tDatabase password is incorrect.");
            } else {
                System.out.println("Connection failed!");
                e.printStackTrace();
            }
        }
        return connection;
    }

    static String login = "account_id int constraint login_pk primary key, username varchar not null, password varchar not null";

    public static void drop(Connection connection, String tableName) {
        System.out.println("Dropping table ... " + tableName);
        try {
            char symbol = '"';
            String command = "DROP TABLE IF EXISTS " + symbol + tableName + symbol + "CASCADE";
            Statement statement = connection.createStatement();
            statement.execute(command);
            statement.close();
            System.out.println("Sucess!");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Drop operation Failed");
        }
    }

    public static void createTable(Connection connection, String tableName, String rows) {
        System.out.println("Creating table ... " + tableName);
        try {
            String command = "create table \"" + tableName + "\"\n" + "(\n" + rows + ")";
            Statement statement = connection.createStatement();
            statement.execute(command);
            statement.close();
            System.out.println("Sucess!");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Create operation Failed");
        }
    }


    public static ResultSet query(Connection connection, String query) {
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] argv) throws SQLException {
        String username = "restaurant";
        String password = "D!!CpSx7uWNj2Sol^B3L6^udHUsmeYejRv$ZRJoW$x6#O1Owl3";
        String database = "138.68.147.184:5432";
        Connection connection = connectToDatabase(username, password, database);
        if (connection != null) {
            System.out.println("SUCCESS: You made it!" + "\n\t You can now take control of your database!\n");

            createTable(connection, "login", login);


        } else {
            System.out.println("ERROR: \tFailed to make connection!");
            System.exit(1);
        }
    }
}
