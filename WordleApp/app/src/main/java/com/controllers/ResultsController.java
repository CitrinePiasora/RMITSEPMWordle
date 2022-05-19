package com.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.application.WordleSystem;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ResultsController implements Initializable {

    @FXML
    private Label played;

    @FXML
    private Label winPercentage;

    @FXML
    private Label currentStreak;

    @FXML
    private Label maxStreak;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

    public void initA(WordleSystem wordleSystem){
        System.out.println("hi1: ");
        wordleSystem.loadPlayerStats();
        System.out.println("hi2: ");
        played.setText( String.valueOf(wordleSystem.getPlayed()));
        
        winPercentage.setText( String.valueOf(wordleSystem.getPlayed()));
        currentStreak.setText( String.valueOf(wordleSystem.getCurrentStreak()));
        maxStreak.setText( String.valueOf(wordleSystem.getMaxStreak()));
    }

}
