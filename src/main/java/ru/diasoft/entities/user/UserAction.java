package ru.diasoft.entities.user;

import javafx.scene.control.Label;
import javafx.stage.Stage;
import ru.diasoft.ui.MainUi;
import ru.diasoft.utils.Session;

public class UserAction {
    public static void registerUser(String login, String password, Label label, Stage stage) {
        if (login.isEmpty() || password.isEmpty()) {
            label.setText("Заполните все поля!");
            return;
        }

        boolean success = UserService.registerUser(login, password);
        if (success) {
            label.setText("Регистрация успешна!");
            MainUi.showMainPage(stage, login);
        } else {
            label.setText("Ошибка: логин уже используется.");
        }
    }

    public static void loginUser(String login, String password, Label label, Stage stage) {

        if (login.isEmpty() || password.isEmpty()) {
            label.setText("Заполните все поля!");
            return;
        }

        Long userId = UserService.authenticateUser(login, password);
        System.out.println(userId);
        if(userId != null) {
            label.setText("Добро пожаловать, " + login + "!");
            Session.getInstance().setUserId(userId);
            Session.getInstance().setLogin(login);
            MainUi.showMainPage(stage, login);
        } else {
            label.setText("Неверные данные.");
        }
    }
}
