package com.jenjetson.dig;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.*;
import java.net.MalformedURLException;

import static com.jenjetson.dig.GameInfoBoardControl.*;

public class GameLogic {
    private static int numClicks;
     Button button;


    public void setButton(Button button) {
        this.button = button;
    }

    public static int getNumClicks() {
        return numClicks;
    }

    public Button getButton() {
        return button;
    }

    public GameLogic(Button button, int numClicks) {
        this.button = button;
        this.numClicks = numClicks = 0;
    }

    public static void checkSquare(Button button, int buttonState) throws IOException {
            if (buttonState == 1) {
            button.getStyleClass().clear(); //remove the background
            button.getStyleClass().add("grassMiss");  //change the CSS ID
            button.setText("");  //clear the text
            GameRoot.startSound();
            numClicks++;
            //GameInfoBoardControl.updateTotalDigs();


        } else if (buttonState == 2){
            button.getStyleClass().add("virginGrass");
        }  else {
            button.getStyleClass().add("grassHit");
        }
    }



}
