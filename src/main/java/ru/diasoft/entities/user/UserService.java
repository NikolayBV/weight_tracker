package ru.diasoft.entities.user;

import ru.diasoft.utils.PasswordUtils;
import ru.diasoft.db.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    public static boolean registerUser(String login, String password) {
        String hashedPassword = PasswordUtils.hashPassword(password);
        try (Connection connection = DataBase.getConnection()) {
            String query = "INSERT INTO users (login, password_hash) VALUES (?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, login);
                stmt.setString(2, hashedPassword);
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Long authenticateUser(String login, String password) {
        try (Connection connection = DataBase.getConnection()) {
            String query = "SELECT id, password_hash FROM users WHERE login = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, login);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String storedHash = rs.getString("password_hash");
                    if(PasswordUtils.checkPassword(password, storedHash)) {
                        return rs.getLong("id");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
