package com.jenjetson.dig;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class GameInfoBoardControl {

    @FXML
    private Label numDigs;
    @FXML
    private Label score;

    @FXML
    private void initialize(){
        numDigs.setText("0");
        score.setText("0");
    }

}
