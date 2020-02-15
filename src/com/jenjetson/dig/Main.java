package com.jenjetson.dig;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Start the game setup, create a gameRoot object
        GameRoot gameRoot = new GameRoot();
    }

    public static void main(String[] args) {
        launch(args);
    }
}