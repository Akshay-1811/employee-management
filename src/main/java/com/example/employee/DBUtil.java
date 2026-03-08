package com.example.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    // read values from environment variables with defaults for development
    private static final String URL = System.getenv().getOrDefault("DB_URL",
            "jdbc:mysql://employee.cl8usi6825h1.us-east-2.rds.amazonaws.com:3306/employee");
    private static final String USER = System.getenv().getOrDefault("DB_USER", "Akshay");
    private static final String PASSWORD = System.getenv().getOrDefault("DB_PASS", "Akshay2002");

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // driver not found – this is fatal in practice so rethrow as unchecked
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
