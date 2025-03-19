package ru.diasoft.entities.user;

import javafx.scene.control.Label;
import javafx.stage.Stage;
import ru.diasoft.ui.MainUi;

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

        boolean authenticated = UserService.authenticateUser(login, password);
        System.out.println(authenticated);
        if(authenticated) {
            label.setText("Добро пожаловать, " + login + "!");
            MainUi.showMainPage(stage, login);
        } else {
            label.setText("Неверные данные.");
        }
    }
}
