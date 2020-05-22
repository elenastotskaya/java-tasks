package com.jdbc;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WindowPrice {
    private static String title;
    private static long price;
    public static void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Show product cost");
        Label text1 = new Label("Enter product name");
        TextField inputTitle = new TextField();
        Label text2 = new Label("Price");
        TextField outPrice = new TextField();
        outPrice.setEditable(false);
        Button submit = new Button("Submit");
        Button close = new Button("Close");
        VBox vb = new VBox();
        vb.getChildren().addAll(text1, inputTitle, text2, outPrice, submit, close);
        submit.setOnAction(event -> {
            title = inputTitle.getText();
            price = Main.commands.showPrice(title);
            if (price == 0) {
                outPrice.setText("No such product");
            } else {
                outPrice.setText(String.valueOf(price));
            }
        });
        close.setOnAction(event -> window.close());
        Scene scene = new Scene(vb);
        window.setScene(scene);
        window.showAndWait();
    }
}
