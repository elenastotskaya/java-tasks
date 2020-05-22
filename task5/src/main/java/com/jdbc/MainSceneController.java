package com.jdbc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainSceneController {
    public MainSceneController() {
    }

    public void clickedInit() {
        InitWindow.display();
    }

    public void clickedAdd() {
        WindowAdd.display();
    }

    public void clickedDelete() {
        WindowDelete.display();
    }

    public void clickedShow() {
        WindowShowAll.display();
    }

    public void clickedPrice() {
        WindowPrice.display();
    }

    public void clickedChange() {
        WindowChangePrice.display();
    }

    public void clickedFilter() {
        WindowFilterPrice.display();
    }
}
