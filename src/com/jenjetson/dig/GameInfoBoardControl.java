package com.jenjetson.dig;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;


public class GameInfoBoardControl {

    @FXML
    private Label numDigs;
    @FXML
    private Label score;
    @FXML
    private int digsLeft = 0;

    // Add a public no-args constructor
    public GameInfoBoardControl ()
    {}

    @FXML
    private void initialize(){
        numDigs.setText("sdf");
        score.setText("0");
    }

    @FXML
    public void setNumDigs(int num){
        numDigs.setText("test");

        System.out.println(num);
    }
}
