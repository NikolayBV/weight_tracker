package ru.diasoft.ui.pane;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.diasoft.entities.user.UserAction;

public class RegisterPane {
    private TextField registerLoginField;
    private PasswordField registerPasswordField;
    private Label registerStatusLabel;
    private final Stage primaryStage;

    public RegisterPane(Stage stage) {
        this.primaryStage = stage;
    }

    public VBox createRegisterPane() {
        registerLoginField = new TextField();
        registerLoginField.setPromptText("Введите логин");

        registerPasswordField = new PasswordField();
        registerPasswordField.setPromptText("Введите пароль");

        registerStatusLabel = new Label();

        Button registerButton = new Button("Зарегистрироваться");
        registerButton.setOnAction(event -> UserAction.registerUser(registerLoginField.getText(), registerPasswordField.getText(), registerStatusLabel, primaryStage));

        VBox root = new VBox(10, registerLoginField, registerPasswordField, registerStatusLabel, registerButton);
        root.setAlignment(Pos.CENTER);
        return root;
    }
}
