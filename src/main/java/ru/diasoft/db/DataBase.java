package ru.diasoft.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private static final String URL = "jdbc:postgresql://postgres.weight-tracker.orb.local:5432/weight_tracker";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    public static void initializeDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            String createUsersTable = "CREATE TABLE IF NOT EXISTS users ("
                    + "id SERIAL PRIMARY KEY, "
                    + "login VARCHAR(50) UNIQUE NOT NULL, "
                    + "password_hash VARCHAR(255) NOT NULL)";

            String createWeightsTable = "CREATE TABLE IF NOT EXISTS weights ("
                    + "id SERIAL PRIMARY KEY, "
                    + "user_id INTEGER REFERENCES users(id), "
                    + "date DATE NOT NULL, "
                    + "weight DECIMAL(5,2) NOT NULL)";

            stmt.executeUpdate(createUsersTable);
            stmt.executeUpdate(createWeightsTable);

            System.out.println("Таблицы проверены и созданы (если их не было)");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}