package com.example.demo;

import java.sql.*;

public class DataBaseManager {
    private final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private final String DATABASE_NAME = "backend1";
    private final String URL = "jdbc:mysql://localhost/" + DATABASE_NAME;
    private final String USER_NAME = "root";
    private final String PASSWORD = "spliyvi123";
    private final String TABLE_NAME = "users";
        public boolean loginUser(User user) {
            try {
                // Connect to the database and check if the username and password are correct
                Class.forName(CLASS_NAME);
                Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                String query = "select * from " + TABLE_NAME + " where USERNAME = ? and PASSWORD = ?";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, user.getUsername());
                pst.setString(2, user.getPassword());
                ResultSet rs = pst.executeQuery();

                // If the query returned at least one result, then the login was successful
                if (rs.next()) {
                    return true;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // If the code reaches this point, then the login was not successful
            return false;
        }
        public boolean containsUser(User user) {
        try {
            Class.forName(CLASS_NAME);
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String query = "select * from " + TABLE_NAME + " where USERNAME = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, user.getUsername());
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return false;
    }

    public String register(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost/backend1", "root", "spliyvi123");

            // Create a prepared statement with placeholders for the user's name, email, and password
            statement = connection.prepareStatement("INSERT INTO users (username, name, lastname, password, proffesion) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getName());
            statement.setString(3, user.getLastname());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getProfession());
            // Execute the prepared statement to insert the user into the database
            statement.executeUpdate();
            return "User registered successfully!";
        } catch (SQLException e) {
            // Log the exception or display an error message
            e.printStackTrace();
            return "Oops.. Something went wrong there..!";
        } finally {
            // Close the statement and connection if they are not null
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // Log the exception
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Log the exception
                    e.printStackTrace();
                }
            }
        }
    }
}
