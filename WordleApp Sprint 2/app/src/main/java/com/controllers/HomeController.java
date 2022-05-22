package com.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

import com.application.Main;
import com.application.WordleSystem;

public class HomeController {

    private WordleSystem wordleSystem = new WordleSystem();

    @FXML private Label zeroZero;
    @FXML private TextField inputZeroZero;
    @FXML private Label oneZero;
    @FXML private TextField inputOneZero;
    @FXML private Label twoZero;
    @FXML private TextField inputTwoZero;
    @FXML private Label threeZero;
    @FXML private TextField inputThreeZero;
    @FXML private Label fourZero;
    @FXML private TextField inputFourZero;
    @FXML private Label zeroOne;
    @FXML private TextField inputZeroOne;
    @FXML private Label oneOne;
    @FXML private TextField inputOneOne;
    @FXML private Label TwoOne;
    @FXML private TextField inputTwoOne;
    @FXML private Label ThreeOne;
    @FXML private TextField inputThreeOne;
    @FXML private Label FourOne;
    @FXML private TextField inputFourOne;
    @FXML private Label ZeroTwo;
    @FXML private TextField inputZeroTwo;
    @FXML private Label OneTwo;
    @FXML private TextField inputOneTwo;
    @FXML private Label TwoTwo;
    @FXML private TextField inputTwoTwo;
    @FXML private Label ThreeTwo;
    @FXML private TextField inputThreeTwo;
    @FXML private Label FourTwo;
    @FXML private TextField inputFourTwo;
    @FXML private Label ZeroThree;
    @FXML private TextField inputZeroThree;
    @FXML private Label OneThree;
    @FXML private TextField inputOneThree;
    @FXML private Label TwoThree;
    @FXML private TextField inputTwoThree;
    @FXML private Label ThreeThree;
    @FXML private TextField inputThreeThree;
    @FXML private Label FourThree;
    @FXML private TextField inputFourThree;
    @FXML private Label zeroFour;
    @FXML private TextField inputZeroFour;
    @FXML private Label oneFour;
    @FXML private TextField inputOneFour;
    @FXML private Label twoFour;
    @FXML private TextField inputTwoFour;
    @FXML private Label threeFour;
    @FXML private TextField inputThreeFour;
    @FXML private Label fourFour;
    @FXML private TextField inputFourFour;
    @FXML private Label zeroFive;
    @FXML private TextField inputZeroFive;
    @FXML private Label oneFive;
    @FXML private TextField inputOneFive;
    @FXML private Label twoFive;
    @FXML private TextField inputTwoFive;
    @FXML private Label threeFive;
    @FXML private TextField inputThreeFive;
    @FXML private Label fourFive;
    @FXML private TextField inputFourFive;
    @FXML private RadioButton colourBlindRadioButton;
    // ^ changes the boolean

    private boolean colourBlindMode = false;

    //Standard Mode Colors
    private String standardModeCorrect = "#73A961";
    private String standardModeSemiCorrect = "#C7B250";
    private String standardModeIncorrect = "#787C7E";
    
    // Colorblind Mode Colors
    private String blindModeCorrect = "#EC712A";
    private String blindModeSemiCorrect = "#8DC0FC";
    private String blindModeIncorrect = "#787C7E";

    private Label labels[][] = new Label[5][6];
    private TextField textFields[][] = new TextField[5][6];

    private int guessRowNum = -1;

    @FXML
    public void initialize() {
        wordleSystem.loadDictionaryList();
        wordleSystem.loadWordOfDay();
        wordleSystem.loadPlayerStats();

        labels[0][0] = zeroZero;
        labels[1][0] = oneZero;
        labels[2][0] = twoZero;
        labels[3][0] = threeZero;
        labels[4][0] = fourZero;

        labels[0][1] = zeroOne;
        labels[1][1] = oneOne;
        labels[2][1] = TwoOne;
        labels[3][1] = ThreeOne;
        labels[4][1] = FourOne;

        labels[0][2] = ZeroTwo;
        labels[1][2] = OneTwo;
        labels[2][2] = TwoTwo;
        labels[3][2] = ThreeTwo;
        labels[4][2] = FourTwo;

        labels[0][3] = ZeroThree;
        labels[1][3] = OneThree;
        labels[2][3] = TwoThree;
        labels[3][3] = ThreeThree;
        labels[4][3] = FourThree;

        labels[0][4] = zeroFour;
        labels[1][4] = oneFour;
        labels[2][4] = twoFour;
        labels[3][4] = threeFour;
        labels[4][4] = fourFour;

        labels[0][5] = zeroFive;
        labels[1][5] = oneFive;
        labels[2][5] = twoFive;
        labels[3][5] = threeFive;
        labels[4][5] = fourFive;

        textFields[0][0] = inputZeroZero;
        textFields[1][0] = inputOneZero;
        textFields[2][0] = inputTwoZero;
        textFields[3][0] = inputThreeZero;
        textFields[4][0] = inputFourZero;

        textFields[0][1] = inputZeroOne;
        textFields[1][1] = inputOneOne;
        textFields[2][1] = inputTwoOne;
        textFields[3][1] = inputThreeOne;
        textFields[4][1] = inputFourOne;

        textFields[0][2] = inputZeroTwo;
        textFields[1][2] = inputOneTwo;
        textFields[2][2] = inputTwoTwo;
        textFields[3][2] = inputThreeTwo;
        textFields[4][2] = inputFourTwo;

        textFields[0][3] = inputZeroThree;
        textFields[1][3] = inputOneThree;
        textFields[2][3] = inputTwoThree;
        textFields[3][3] = inputThreeThree;
        textFields[4][3] = inputFourThree;

        textFields[0][4] = inputZeroFour;
        textFields[1][4] = inputOneFour;
        textFields[2][4] = inputTwoFour;
        textFields[3][4] = inputThreeFour;
        textFields[4][4] = inputFourFour;

        textFields[0][5] = inputZeroFive;
        textFields[1][5] = inputOneFive;
        textFields[2][5] = inputTwoFive;
        textFields[3][5] = inputThreeFive;
        textFields[4][5] = inputFourFive;
    }

    // sets the tiles to their corresponding colours
    public void getColour(ArrayList<String> assignColours, int j) {

        for (int i = 0; i < assignColours.size(); i++) {
            if (assignColours.get(i).equals("correct")) {
                if (colourBlindMode == false) {
                    labels[i][j].setStyle("-fx-background-color: " + standardModeCorrect);
                    textFields[i][j].setStyle("-fx-background-color: " + standardModeCorrect);
                } else {
                    labels[i][j].setStyle("-fx-background-color: " + blindModeCorrect);
                    textFields[i][j].setStyle("-fx-background-color: " + blindModeCorrect);
                }
            } else if (assignColours.get(i).equals("semiCorrect")) {
                if (colourBlindMode == false) {
                    labels[i][j].setStyle("-fx-background-color: " + standardModeSemiCorrect);
                    textFields[i][j].setStyle("-fx-background-color: " + standardModeSemiCorrect);
                } else {
                    labels[i][j].setStyle("-fx-background-color: " + blindModeSemiCorrect);
                    textFields[i][j].setStyle("-fx-background-color: " + blindModeSemiCorrect);
                }
            } else if (assignColours.get(i).equals("incorrect")) {
                if (colourBlindMode == false) {
                    labels[i][j].setStyle("-fx-background-color: " + standardModeIncorrect);
                    textFields[i][j].setStyle("-fx-background-color: " + standardModeIncorrect);
                } else {
                    labels[i][j].setStyle("-fx-background-color: " + blindModeIncorrect);
                    textFields[i][j].setStyle("-fx-background-color: " + blindModeIncorrect);
                }
            }
        }

    }

    // changes to colour blind more or back to standard
    @FXML
    public void changeMode(ActionEvent event) {
        if (colourBlindMode == false)
            colourBlindMode = true;

        else if (colourBlindMode == true)
            colourBlindMode = false;

        // update screen
        if (guessRowNum != -1){
            for (int i = 0; i < guessRowNum + 1; i++) {
                playerGuessCheck(i);
            }
        }
        
    }

    // assigns colours to player's guess if valid
    // if the guess is word of day update stats & shows results
    // if no mores guess end game & show results
    public void playerGuessCheck(int guessRowNum) {
        String firstLetter = textFields[0][guessRowNum].getText().toString().toLowerCase();
        String secondLetter = textFields[1][guessRowNum].getText().toString().toLowerCase();
        String thirdLetter = textFields[2][guessRowNum].getText().toString().toLowerCase();
        String fourthLetter = textFields[3][guessRowNum].getText().toString().toLowerCase();
        String fithLetter = textFields[4][guessRowNum].getText().toString().toLowerCase();

        Alert a = new Alert(AlertType.NONE);

        if (checkIfValid(firstLetter, secondLetter, thirdLetter, fourthLetter, fithLetter) == true) {

            String playersGuess = firstLetter + secondLetter + thirdLetter + fourthLetter + fithLetter;
            // assign colours
            getColour(wordleSystem.assignColors(playersGuess), guessRowNum);

            textFields[0][guessRowNum].setEditable(false);
            textFields[1][guessRowNum].setEditable(false);
            textFields[2][guessRowNum].setEditable(false);
            textFields[3][guessRowNum].setEditable(false);
            textFields[4][guessRowNum].setEditable(false);

            if (wordleSystem
                    .isWordOfDay(playersGuess) == true) {
                wordleSystem.getGameStats(true);
                // they have won & guess on guessRowNum
                wordleSystem.setGuessDistribution(guessRowNum);
                try {
                    wordleSystem.updatePlayerStatFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // displays new window for results
                results();
                return;
            } else if (guessRowNum != 5) {

                textFields[0][guessRowNum + 1].setEditable(true);
                textFields[1][guessRowNum + 1].setEditable(true);
                textFields[2][guessRowNum + 1].setEditable(true);
                textFields[3][guessRowNum + 1].setEditable(true);
                textFields[4][guessRowNum + 1].setEditable(true);

                textFields[0][guessRowNum + 1].requestFocus();
            } else {
                wordleSystem.getGameStats(false);
                a.setAlertType(AlertType.INFORMATION);
                a.setContentText("The Word of Day is " + wordleSystem.getWordOfDay());
                a.show();
                results();
            }
        }
    }

    // when players enters their guess
    @FXML
    public void enterPressed1stGuess(ActionEvent event) throws IOException {
        guessRowNum = 0;
        playerGuessCheck(guessRowNum);

    }

    // when players enters their guess
    @FXML
    public void enterPressed2ndGuess(ActionEvent event) throws IOException {
        guessRowNum = 1;
        playerGuessCheck(guessRowNum);
    }

    // when players enters their guess
    @FXML
    public void enterPressed3rdGuess(ActionEvent event) throws IOException {
        guessRowNum = 2;
        playerGuessCheck(guessRowNum);
    }

    // when players enters their guess
    @FXML
    public void enterPressed4thGuess(ActionEvent event) throws IOException {
        guessRowNum = 3;
        playerGuessCheck(guessRowNum);
    }

    // when players enters their guess
    @FXML
    public void enterPressed5thGuess(ActionEvent event) throws IOException {
        guessRowNum = 4;
        playerGuessCheck(guessRowNum);
    }

    // when players enters their guess
    @FXML
    public void enterPressed6thGuess(ActionEvent event) throws IOException {
        guessRowNum = 5;
        playerGuessCheck(guessRowNum);
    }

    // displays the results/ changes stage
    public void results() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("ResultView.fxml"));
            Parent root = loader.load();
            ResultsController rc = loader.getController();
            rc.initA(wordleSystem);
            Stage resultsPopUp = new Stage();
            resultsPopUp.initModality(Modality.APPLICATION_MODAL);
            resultsPopUp.setTitle("Results");
            resultsPopUp.setScene(new Scene(root));
            resultsPopUp.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // displays error message if input entered is invalid
    public boolean checkIfValid(String one, String two, String three, String four, String five) {
        Alert a = new Alert(AlertType.NONE);
        // validates if each title has a letter or not
        if (wordleSystem.isALetter(one, two, three, four, five) == false) {
            // error message
            a.setAlertType(AlertType.INFORMATION);
            a.setContentText("Each tile needs only 1 letter, 5 letter word");
            a.show();
            return false;
        }
        // if true check if inputs are letters
        String playersGuess = one + two + three + four + five;
        if (wordleSystem.isValidInput(playersGuess) == false) {
            a.setAlertType(AlertType.INFORMATION);
            a.setContentText("Invalid inputs, needs be letters");
            a.show();
            return false;
        }
        // if true check if player's guess is in Dictionary List
        if (wordleSystem.isInDictionaryList(playersGuess) == false) {
            a.setAlertType(AlertType.INFORMATION);
            a.setContentText("Not in Dictionary List");
            a.show();
            return false;
        }
        return true;
    }

}
