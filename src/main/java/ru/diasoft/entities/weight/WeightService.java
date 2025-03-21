package ru.diasoft.entities.weight;

import javafx.scene.control.Label;
import ru.diasoft.db.DataBase;
import ru.diasoft.utils.PasswordUtils;
import ru.diasoft.utils.Session;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WeightService {
    public static boolean addWeight(String weight, Label label) {
        try (Connection connection = DataBase.getConnection()) {
            Long userId = Session.getInstance().getUserId();
            if (userId == null) {
                System.err.println("Ошибка: userId не установлен в сессии!");
                return false;
            }
            if (weight == null || weight.trim().isEmpty()) {
                System.err.println("Ошибка: вес не может быть пустым!");
                return false;
            }
            double weightValue;
            try {
                weightValue = Double.parseDouble(weight);
            } catch (NumberFormatException e) {
                System.err.println("Ошибка: вес должен быть числом!");
                return false;
            }
            String query = "INSERT INTO weights (weight, user_id, date) VALUES (?, ?, ?)";
            LocalDate currentDate = LocalDate.now();
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setDouble(1, weightValue);
                stmt.setLong(2, userId);
                stmt.setDate(3, Date.valueOf(currentDate));
                int rowsAffected = stmt.executeUpdate();
                if(rowsAffected > 0) {
                    label.setText("Вес добавлен");
                    return true;
                } else {
                    return false;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<String> getWeights() {
        Long userId = Session.getInstance().getUserId();
        if (userId == null) {
            System.err.println("Ошибка: userId не установлен в сессии!");
            return new ArrayList<>();
        }

        List<String> weights = new ArrayList<>();
        String query = "SELECT weight FROM weights WHERE user_id = ? ORDER BY id DESC";

        try (Connection connection = DataBase.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    weights.add(rs.getString("weight"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weights;
    }
}
