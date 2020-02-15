/* package com.jenjetson.dig;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.File;
import java.net.MalformedURLException;

public class ScoreBoard{

    int score = 0;
    int numDigs = 0;
    private Label scoreText = new Label("Score: ");
    private Label scoreField = new Label("0");
    private Label numDigsText = new Label("Number of digs left ");
    private Label numDigsField = new Label("0");

    public ScoreBoard(HBox) throws MalformedURLException {
        this.score = score;
        this.numDigs = numDigs;
        this.scoreText = scoreText;
        this.scoreField = scoreField;
        this.numDigsText = numDigsText;
        this.numDigsField = numDigsField;

        HBox scores = new HBox();
        scores.getChildren().addAll(scoreText,scoreField,numDigsText, numDigsField);

        //assign stylesheet
        File fileDetails = new File("C:\\Users\\Kari\\IdeaProjects\\GoldDig\\src\\com\\jenjetson\\dig\\view\\goldDig.css");
        scores.getStylesheets().add(fileDetails.toURI().toURL().toExternalForm()); //add css file assigned 'f' from line above
        scores.setMinHeight(50);

        //don't confuse this with line above, it assigns a CSS ID value
        scores.getStyleClass().add("scoreBoard"); //add CSS ID for styling in CSS usage: .gridPaneMain{}


    }
}
*/