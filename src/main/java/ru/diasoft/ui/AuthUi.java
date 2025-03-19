package ru.diasoft.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ru.diasoft.ui.pane.LoginPane;
import ru.diasoft.ui.pane.RegisterPane;

public class AuthUi extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Вход и Регистрация");
        RegisterPane registerPane = new RegisterPane(stage);
        LoginPane loginPane = new LoginPane(stage);

        TabPane tabPane = new TabPane();

        Tab loginTab = new Tab("Вход", loginPane.createLoginPane());
        loginTab.setClosable(false);

        Tab registerTab = new Tab("Регистрация", registerPane.createRegisterPane());
        registerTab.setClosable(false);

        tabPane.getTabs().addAll(loginTab, registerTab);

        Scene scene = new Scene(tabPane);
        stage.setScene(scene);
        stage.show();
    }
}
