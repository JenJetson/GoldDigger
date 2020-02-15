package com.jenjetson.dig;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.*;

public class MainApp extends Application {

    Stage primaryStage = new Stage();  //create main stage
    BorderPane gameBorderPane = new BorderPane();  //create the main border pane

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gold Digger App!");

        initRootLayout();

    }

    public void initRootLayout() throws IOException {
            //play intro sound
            startSound();

            //set the main program icon
            primaryStage.getIcons().add(new Image(
                    "file:/C:\\Users\\Kari\\IdeaProjects\\Dig for Gold\\src\\com\\jenjetson\\view\\media\\soil.jpg"));

            //Create FXML loader for main window menu
            FXMLLoader loader = new FXMLLoader();  //create new fxml loader
            loader.setLocation(MainApp.class.getResource("view/topMenu.fxml"));//top menu for the border pane
            gameBorderPane = (BorderPane) loader.load();

            //Create FXML loader for scoreboard
            loader = new FXMLLoader();  //NOTE: syntax when it's used a second time!
            loader.setLocation(MainApp.class.getResource("view/scoreBoard.fxml"));
            HBox scoreBoard = (HBox) loader.load();

            //put the MainGameBoard gridPane in the center of the BorderPane
            GridPane gridPaneMain = new GridPane();

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
                    FXMLLoader finalLoader = loader;
                    button.setOnAction(e -> {  //button action lambda
                        //button state means if it is a hit, miss or untried state.
                        ScoreBoardController controller = finalLoader.getController();
                        controller.checkSquare(button, 1);

                    });
                    gridPaneMain.add(button, y, x, 1, 1);
                }
            }

            gameBorderPane.setCenter(gridPaneMain);
            //put the infoBard on the top of window
            gameBorderPane.setTop(scoreBoard);


            //Create a Scene called mainScene and put the rootLayout in it.
            Scene mainScene = new Scene(gameBorderPane);

            //Put scene in the PrimaryStage
            primaryStage.setScene(mainScene);

            primaryStage.setTitle("Gold Dig");

            //mainScene.getStylesheets().add("/view/goldDig.css");  //attach style sheet for main scene
            primaryStage.show();

    }


    public void startSound() throws IOException {
        String absolutePath = "C:\\Users\\Kari\\IdeaProjects\\Dig for Gold\\src\\com\\jenjetson\\view\\media\\BIP.WAV";
        InputStream is = new FileInputStream(absolutePath);

        // create an audiostream from the inputstream
        AudioStream audioStream = new AudioStream(is);

        // play the audio clip with the audioplayer class
        AudioPlayer.player.start(audioStream);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

}