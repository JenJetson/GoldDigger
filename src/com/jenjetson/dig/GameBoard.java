package com.jenjetson.dig;

import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import static com.jenjetson.dig.GameLogic.*;

public class GameBoard {
    //Create a gridPane to hold cells of the game board
    GridPane gridPaneMain;

    public GameBoard(GridPane gridPaneMain) throws MalformedURLException {
        this.gridPaneMain = gridPaneMain;

        //create a pick axe cursor for over the game board
        Image image = new Image("file:/C:\\Users\\Kari\\IdeaProjects\\GoldDig\\src\\com\\jenjetson\\dig\\view\\media\\pickaxe-med.png");
        gridPaneMain.setCursor(new ImageCursor(image));

        //assign stylesheet
        File fileDetails = new File("C:\\Users\\Kari\\IdeaProjects\\GoldDig\\src\\com\\jenjetson\\dig\\view\\goldDig.css");
        gridPaneMain.getStylesheets().add(fileDetails.toURI().toURL().toExternalForm()); //add css file assigned 'f' from line above

        //don't confuse this with line above, it assigns a CSS ID value
        gridPaneMain.getStyleClass().add("gridPaneMain"); //add CSS ID for styling in CSS usage: .gridPaneMain{}
        gridPaneMain.setGridLinesVisible(false);  //turn on/off gridlines

        //use an iteration to assign an 'xy' variable where x is row and why is column
        //create 81 buttons (9 x 9) and initialize (each one is assigned it's own CSS ID for manipulation)
        for (int x = 0; x < 9; ++x) {  //create 8 columns
            for (int y = 0; y < 9; ++y) {  //create 8 rows
                Button button = new Button(); //create a new button each iteration
                button.setMinWidth(60);  //initialize width
                button.setMinHeight(45);  //initialize height
                button.setText(Integer.toString(x) + Integer.toString(y));
                button.setDisable(false); //change to false when want to show hit/miss,etc
                //button.getStyleClass().add(Integer.toString(x) + Integer.toString(y));
                button.getStyleClass().add("grassVirgin");  //initial css ID  setting
                button.setOnAction(e ->{  //button action lambda
                    try {  //button state means if it is a hit, miss or untried state.
                        GameLogic.checkSquare(button, 1);

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });


                gridPaneMain.add(button, y, x, 1, 1);

            }
        }
    }
}



