package com.jdbc;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InitWindow {
    private static int num;
    public static void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Initialization");
        Label text = new Label("Enter number of products");
        TextField inputNumber = new TextField();
        Button generate = new Button("Generate");
        VBox vb = new VBox();
        vb.getChildren().addAll(text, inputNumber, generate);
        generate.setOnAction(event -> {
            try {
                num = Integer.parseInt(inputNumber.getText());
                if (num < 0) {
                    inputNumber.setText("Incorrect number");
                } else {
                    Main.commands.generateEntries(num);
                    window.close();
                }
            } catch (NumberFormatException e) {
                inputNumber.setText("Incorrect number");
            }
        });
        Scene scene = new Scene(vb);
        window.setScene(scene);
        window.showAndWait();
    }
}
