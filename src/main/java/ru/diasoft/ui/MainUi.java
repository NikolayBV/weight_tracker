package ru.diasoft.ui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.diasoft.ui.pane.WeightAddPane;
import ru.diasoft.ui.pane.WeightHistoryPane;

public class MainUi {
    public static void showMainPage(Stage stage, String username) {
        WeightAddPane weightAddPane = new WeightAddPane(stage);
        WeightHistoryPane weightHistoryPane = new WeightHistoryPane(stage);


        TabPane tabPane = new TabPane();
        Tab weightHistoryTab = new Tab("История изменений", weightHistoryPane.createWeightHistoryPane());
        Tab weightAddTab = new Tab("Добавление значения", weightAddPane.createWeightAddPane());

        tabPane.getTabs().addAll(weightAddTab, weightHistoryTab);

        Scene scene = new Scene(tabPane, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
