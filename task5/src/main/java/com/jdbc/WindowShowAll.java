package com.jdbc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WindowShowAll {
    private static TableView<Product> table;
    public static void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Show products");
        table = new TableView<>();
        TableColumn<Product, Integer> column1 = new TableColumn<>("id");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Product, Integer> column2 = new TableColumn<>("prodid");
        column2.setCellValueFactory(new PropertyValueFactory<>("prodid"));
        TableColumn<Product, String> column3 = new TableColumn<>("title");
        column3.setCellValueFactory(new PropertyValueFactory<>("title"));
        TableColumn<Product, Long> column4 = new TableColumn<>("cost");
        column4.setCellValueFactory(new PropertyValueFactory<>("cost"));
        table.getColumns().addAll(column1, column2, column3, column4);
        ObservableList<Product> observableList = FXCollections.observableList(Main.commands.getList());
        table.setItems(observableList);
        table.setLayoutY(0);
        Button close = new Button("Close");
        VBox vb = new VBox();
        vb.getChildren().addAll(table, close);
        close.setOnAction(event -> window.close());
        Scene scene = new Scene(vb);
        window.setScene(scene);
        window.showAndWait();
    }
}
