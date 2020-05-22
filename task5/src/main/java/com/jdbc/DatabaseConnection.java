package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection implements AutoCloseable {
    private Connection connection;
    private static DatabaseConnection instance;
    private static final String USERNAME = "elena";
    private static final String PASSWORD = "elena";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql?serverTimezone=Europe/Moscow";

    private DatabaseConnection() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
