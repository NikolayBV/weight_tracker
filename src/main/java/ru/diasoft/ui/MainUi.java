package ru.diasoft.ui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainUi {
    public static void showMainPage(Stage stage, String username) {
        Label welcomeLabel = new Label("Добро пожаловать, " + username + "!");
        VBox root = new VBox(10, welcomeLabel);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Главная страница");
    }
}
