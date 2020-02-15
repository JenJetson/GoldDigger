package com.jenjetson.dig;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ScoreBoardController {
    //HBOX variables
    @FXML
    private Label score;
    @FXML
    private Label scoreText;
    @FXML
    private Label numDigs;
    @FXML
    private Label numDigsText;
    @FXML
    private Button newGame;
    @FXML
    private int numDigsLeft = 0;

    //variables for methods
    @FXML
    private int digsLeft = 0;


    public ScoreBoardController() {

    }

    @FXML
    public void checkSquare(Button button, int buttonState){

        if (buttonState == 1) {
            button.getStyleClass().clear(); //remove the background
            button.getStyleClass().add("grassMiss");  //change the CSS ID
            button.setText("");  //clear the text
            numDigsLeft++;
            numDigs.setText(Integer.toString(numDigsLeft));


        } else if (buttonState == 2) {
            button.getStyleClass().add("virginGrass");
        } else {
            button.getStyleClass().add("grassHit");
        }

    }


    @FXML
    private void initialize(){
        numDigs.setText("sdf");
        score.setText("0");
    }
}