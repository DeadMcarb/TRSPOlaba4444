package org.example.trspolaba4;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private Connection connection;

    public Database() {
        try {
            String databaseUser = "student";
            String databasePassword = "student";
            String databaseName = "museumdb";
            String url = "jdbc:mariadb://localhost:3306/" + databaseName;
            connection = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public Connection getConnection() {
        return connection;
    }
}
