package com.jenjetson.dig;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GameRoot {

    public GameRoot(Stage stage){
        Stage primaryStage = new Stage();
        BorderPane rootLayout = new BorderPane();
        try{
            //play intro sound
            startSound();

            //set the main program icon
            primaryStage.getIcons().add(new Image(
                    "file:/C:\\Users\\Kari\\IdeaProjects\\Dig for Gold\\src\\com\\jenjetson\\view\\media\\soil.jpg"));

            //Create FXML loader
            FXMLLoader loader = new FXMLLoader();  //create new fxml loader
            //set/get fxml file
            loader.setLocation(Main.class.getResource("view/topMenu.fxml"));

            rootLayout = (BorderPane) loader.load();

            //create a gridPane to pass to board class
            GridPane gridPane = new GridPane();

            //Pass gridPane to create board object
            GameBoard board = new GameBoard(gridPane);

            //put the gridPane in the center of the BorderPane
            rootLayout.setCenter(gridPane);

            //Create a Scene called mainScene and put the rootLayout in it.
            Scene mainScene = new Scene(rootLayout);

            //Put scene in the PrimaryStage
            primaryStage.setScene(mainScene);

            primaryStage.setTitle("Gold Dig");

            //mainScene.getStylesheets().add("/view/goldDig.css");  //attach style sheet for main scene
            primaryStage.show();
        }   catch (IOException e){
            e.printStackTrace();
        }

    }

    public void startSound() throws IOException { //this requires an absolute path
        String absolutePath = "C:\\Users\\Kari\\IdeaProjects\\Dig for Gold\\src\\com\\jenjetson\\view\\media\\BIP.WAV";
        InputStream is = new FileInputStream(absolutePath);

        // create an audiostream from the inputstream
        AudioStream audioStream = new AudioStream(is);

        // play the audio clip with the audioplayer class
        AudioPlayer.player.start(audioStream);
    }
}
