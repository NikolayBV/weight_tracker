package ru.diasoft.ui.pane;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.diasoft.entities.weight.WeightService;

public class WeightAddPane {
    private TextField weightAddField;
    private Label weightAddLabel;

    private final Stage currentStage;

    public WeightAddPane(Stage stage) {
        currentStage = stage;
    }

    public VBox createWeightAddPane() {
        weightAddField = new TextField();
        weightAddField.setPromptText("Введите вес");

        weightAddLabel = new Label();
        weightAddLabel.setText("Укажите свой вес");

        Button weightAddButton = new Button("Добавить вес");
        weightAddButton.setOnAction(e -> WeightService.addWeight(weightAddField.getText(), weightAddLabel));

        VBox vBox = new VBox(10, weightAddField, weightAddLabel, weightAddButton);
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }
}
