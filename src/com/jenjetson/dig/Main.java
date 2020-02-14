package com.jenjetson.dig;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.imageio.IIOParam;

public class Main extends Application {
    //Create the primaryStage
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Initialize the primaryStage
        this.primaryStage = primaryStage;

        //pass the primaryStage and initialize the game & board settings
        GameRoot gameRoot = new GameRoot(primaryStage);

        //Create FXML loader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/gameInfoBoard.fxml"));
        HBox infoBoard = (HBox) loader.load();

    }

    public static void main(String[] args) {
        launch(args);
    }
}