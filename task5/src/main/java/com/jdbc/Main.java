package com.jdbc;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;

public class Main extends Application {
    static DatabaseCommands commands;
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/mainScene.fxml"));
            MainSceneController controller = loader.getController();
            Parent root = loader.load();

            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try(DatabaseConnection databaseConnection = DatabaseConnection.getInstance()) {
            commands = new DatabaseCommands(databaseConnection);
            launch();
        }catch (SQLException e) {
            System.out.println("Cannot connect to database");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Problem with closing connection");
            e.printStackTrace();
        }
    }
}
