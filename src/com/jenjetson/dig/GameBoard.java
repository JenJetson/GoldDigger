package com.jenjetson.dig;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.net.MalformedURLException;

public class GameBoard {
    //Create a gridPane to hold cells of the game board

    GridPane gridPaneMain;
    StackPane stackPane = new StackPane();

    public GameBoard(GridPane gridPaneMain) throws MalformedURLException {
        this.gridPaneMain = gridPaneMain;

        //assign file values to File object and assign to stylesheet on 2nd line
        File fileDetails = new File("C:\\Users\\Kari\\IdeaProjects\\GoldDig\\src\\com\\jenjetson\\dig\\view\\goldDig.css");
        gridPaneMain.getStylesheets().add(fileDetails.toURI().toURL().toExternalForm()); //add css file assigned 'f' from line above

        //don't confuse this with line above, it assigns a CSS ID value
        gridPaneMain.getStyleClass().add("gridPaneMain"); //add CSS ID for styling in CSS usage: .gridPaneMain{}
        gridPaneMain.setGridLinesVisible(false);  //turn on/off gridlines

        //use an iteration to assign an 'xy' variable where x is row and why is column
        //create 64 buttons (8 x 8) and initialize states

        for (int x = 0; x < 9; ++x) {  //create 8 columns
            for (int y = 0; y < 9; ++y) {  //create 8 rows
                //create stackPane to hold both buttons
                //create Button
                StackPane stackPane = new StackPane();
                stackPane.getStyleClass().add("stackPane");

                Button button = new Button();
                //set Button text based on iterated value
                button.setText(Integer.toString(x) + Integer.toString(y));
                //set Button on/off
                button.setDisable(false); //initialize off because will show when picked
                //assigned a general CSS ID for missed hit if you do on/off hit or not
                button.getStyleClass().add("grassBottom");
                //if you want to give each button it's own CSS ID
                //button.getStyleClass().add(Integer.toString(x) + Integer.toString(y)); //get actually assigns
                gridPaneMain.add(stackPane, y, x, 1, 1);

                Button button2 = new Button();
                button2.setText(Integer.toString(x) + Integer.toString(y));
                button2.setDisable(false); //change to false when want to show hit/miss,etc
                button2.getStyleClass().add("grassVirgin");
                //if you want to give each button it's own CSS ID
                //button2.getStyleClass().add(Integer.toString(x) + Integer.toString(y)); //get actually assigns
                gridPaneMain.add(button2, y, x, 1, 1);
                stackPane.getChildren().addAll(button, button2);
            }
        }
    }
}



