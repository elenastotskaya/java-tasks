package com.jdbc;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WindowDelete {
    private static String title;

    public static void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Delete entry");
        Label text = new Label("Enter product name");
        TextField inputTitle = new TextField();
        Button submit = new Button("Submit");
        VBox vb = new VBox();
        vb.getChildren().addAll(text, inputTitle, submit);
        submit.setOnAction(entry -> {
            title = inputTitle.getText();
            Main.commands.deleteEntry(title);
            window.close();
        });
        Scene scene = new Scene(vb);
        window.setScene(scene);
        window.showAndWait();
    }
}
