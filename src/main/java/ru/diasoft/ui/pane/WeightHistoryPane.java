package ru.diasoft.ui.pane;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WeightHistoryPane {
    private Label weightHistoryLabel;

    private final Stage currentStage;

    public WeightHistoryPane(Stage stage) {
        currentStage = stage;
    }

    public VBox createWeightHistoryPane() {

        weightHistoryLabel = new Label();
        weightHistoryLabel.setText("Ваша история изменений");

        VBox vBox = new VBox(10, weightHistoryLabel);
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }
}
