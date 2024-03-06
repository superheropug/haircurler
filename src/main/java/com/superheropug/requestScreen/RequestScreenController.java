package com.superheropug.requestScreen;

import java.io.IOException;

import com.superheropug.App;

import javafx.fxml.FXML;

public class RequestScreenController{
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}
