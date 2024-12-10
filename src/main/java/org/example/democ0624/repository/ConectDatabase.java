package org.example.democ0624.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectDatabase {
    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/pharmacydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    public ConectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Kết nối thành công");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}