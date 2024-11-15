package org.example.lab3_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database_connection {
    // URL бази даних PostgreSQL
    private static final String URL = "jdbc:postgresql://localhost:5432/Trading_task2_bd";

    // Логін та пароль користувача бази даних
    private static final String USER = "postgres";
    private static final String PASSWORD = "qw12as34";

    // Метод для встановлення з'єднання
    public static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);
        return DriverManager.getConnection(URL, props);
    }
}
