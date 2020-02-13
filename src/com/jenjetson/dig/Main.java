package com.jenjetson.dig;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    //Create the primaryStage
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Initialize the primaryStage
        this.primaryStage = primaryStage;

        //pass the primaryStage and initialize the game & board settings
        GameRoot gameRoot = new GameRoot(primaryStage);

    }

    public static void main(String[] args) {
        launch(args);
    }
}