package com.superheropug;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    // Replace with something that gets the version
    String version = "0.1";
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("requestScreen"), 1900, 1000);
        
        stage.setScene(scene);
        //stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.setTitle("Haircurler v" + version);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}