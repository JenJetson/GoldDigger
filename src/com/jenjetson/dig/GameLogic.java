package com.jenjetson.dig;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.*;

public class GameLogic {
    GameInfoBoardControl scores = new GameInfoBoardControl();
    private int numDigs;
    private HBox infoBoard;

    public GameLogic() {
    }

    public void checkSquare(Button button, int buttonState) throws IOException {



        if (buttonState == 1) {
            button.getStyleClass().clear(); //remove the background
            button.getStyleClass().add("grassMiss");  //change the CSS ID
            button.setText("");  //clear the text
            GameRoot.startSound();

            //GameInfoBoardControl.updateTotalDigs();
            numDigs++;

            scores.setNumDigs(numDigs);




        } else if (buttonState == 2){
            button.getStyleClass().add("virginGrass");
        }  else {
            button.getStyleClass().add("grassHit");
        }
    }
}
