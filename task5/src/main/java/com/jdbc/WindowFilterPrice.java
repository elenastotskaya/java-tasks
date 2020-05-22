package com.jdbc;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WindowFilterPrice {
    private static long priceMin;
    private static long priceMax;
    public static void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Filter by price");
        Label text1 = new Label("Enter minimum price");
        TextField inputMin = new TextField();
        Label text2 = new Label("Enter maximum price");
        TextField inputMax = new TextField();
        Button submit = new Button("Submit");
        VBox vb = new VBox();
        vb.getChildren().addAll(text1, inputMin, text2, inputMax, submit);
        submit.setOnAction(event -> {
            try {
                priceMin = Long.parseLong(inputMin.getText());
                if (priceMin <= 0) {
                    inputMin.setText("Incorrect price");
                }
            } catch (NumberFormatException e) {
                inputMin.setText("Incorrect price");
            }
            try {
                priceMax = Long.parseLong(inputMax.getText());
                if (priceMax < priceMin) {
                    inputMax.setText("Incorrect price");
                } else {
                    WindowShowFiltered.display(priceMin, priceMax);
                    window.close();
                }
            } catch (NumberFormatException e) {
                inputMin.setText("Incorrect price");
            }
        });
        Scene scene = new Scene(vb);
        window.setScene(scene);
        window.showAndWait();
    }
}
