package ru.diasoft.ui.pane;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.diasoft.entities.user.UserAction;

public class LoginPane {
    private TextField loginField;
    private PasswordField passwordField;
    private Label statusLabel;
    private final Stage primaryStage;

    public LoginPane(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public VBox createLoginPane() {
        loginField = new TextField();
        loginField.setPromptText("Введите логин");

        passwordField = new PasswordField();
        passwordField.setPromptText("Введите пароль");

        statusLabel = new Label();

        Button loginButton = new Button("Войти");
        loginButton.setOnAction(event -> UserAction.loginUser(loginField.getText(), passwordField.getText(), statusLabel, primaryStage));

        VBox vbox = new VBox(10, loginField, passwordField, statusLabel, loginButton);
        vbox.setAlignment(Pos.CENTER);
        return vbox;
    }
}
