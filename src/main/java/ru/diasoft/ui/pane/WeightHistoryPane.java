package ru.diasoft.ui.pane;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.diasoft.entities.weight.WeightService;
import ru.diasoft.utils.Session;

import java.util.List;

public class WeightHistoryPane {
    private ListView<String> weightHistoryListView;

    private final Stage currentStage;

    public WeightHistoryPane(Stage stage) {
        currentStage = stage;
    }

    public VBox createWeightHistoryPane() {

        Label weightHistoryLabel = new Label("Ваша история изменений");
        Button weightReloadButton = new Button("Добавить вес");
        weightReloadButton.setOnAction(actionEvent -> loadWeightHistory());
        weightHistoryListView = new ListView<>();
        loadWeightHistory();

        VBox vBox = new VBox(10, weightHistoryLabel, weightHistoryListView, weightReloadButton);
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }

    private void loadWeightHistory() {

        List<String> history = WeightService.getWeights();
        if (history.isEmpty()) {
            weightHistoryListView.getItems().add("История пуста.");
        } else {
            weightHistoryListView.getItems().setAll(history);
        }
    }
}
