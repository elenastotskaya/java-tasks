package com.jdbc;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WindowAdd {
    private static String title;
    private static long price;
    public static void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add new entry");
        Label text1 = new Label("Enter product name");
        TextField inputTitle = new TextField();
        Label text2 = new Label("Enter price");
        TextField inputPrice = new TextField();
        Button submit = new Button("Submit");
        VBox vb = new VBox();
        vb.getChildren().addAll(text1, inputTitle, text2, inputPrice, submit);
        submit.setOnAction(event -> {
            try {
                title = inputTitle.getText();
                price = Long.parseLong(inputPrice.getText());
                if (price <= 0) {
                    inputPrice.setText("Incorrect price");
                } else if (title.equals("")) {
                    inputTitle.setText("Empty title");
                } else {
                    Main.commands.addEntry(title, price);
                    window.close();
                }
            } catch (NumberFormatException e) {
                inputPrice.setText("Incorrect price");
            }
        });
        Scene scene = new Scene(vb);
        window.setScene(scene);
        window.showAndWait();
    }
}
