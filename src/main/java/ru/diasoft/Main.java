package ru.diasoft;

import javafx.application.Application;
import ru.diasoft.db.DataBase;
import ru.diasoft.ui.AuthUi;

public class Main {
    public static void main(String[] args) {
        DataBase.initializeDatabase();
        Application.launch(AuthUi.class, args);
    }
}