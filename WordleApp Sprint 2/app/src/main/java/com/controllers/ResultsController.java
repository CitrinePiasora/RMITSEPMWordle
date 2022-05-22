package com.controllers;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

import com.application.WordleSystem;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.StringConverter;

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

    public void initA(WordleSystem wordleSystem) {
        wordleSystem.loadPlayerStats();
        played.setText(String.valueOf(wordleSystem.getPlayed()));

        winPercentage.setText(String.valueOf(wordleSystem.getPlayed()));
        currentStreak.setText(String.valueOf(wordleSystem.getCurrentStreak()));
        maxStreak.setText(String.valueOf(wordleSystem.getMaxStreak()));

        Stage stage = new Stage();
        stage.setTitle("Guess Distribution");

        final NumberAxis xAxis = new NumberAxis(0, Collections.max(wordleSystem.getGuessDistribution().values()), 1);
        final CategoryAxis yAxis = new CategoryAxis();
        final BarChart<Number, String> bc = new BarChart<Number, String>(xAxis, yAxis);
        bc.setTitle("Guess Distribution");
        xAxis.setTickLabelRotation(90);

        xAxis.setTickLabelFormatter(new StringConverter<Number>() {

			@Override
            public Number fromString(String string) {
				return Integer.parseInt(string);
			}

			@Override
            public String toString(Number object) {
				return Integer.toString(object.intValue());
			}
        	
        });
        
        XYChart.Series series1 = new XYChart.Series();
        series1.getData().add(new XYChart.Data(wordleSystem.getGuessDistribution().get(5), "6"));
        series1.getData().add(new XYChart.Data(wordleSystem.getGuessDistribution().get(4), "5"));
        series1.getData().add(new XYChart.Data(wordleSystem.getGuessDistribution().get(3), "4"));
        series1.getData().add(new XYChart.Data(wordleSystem.getGuessDistribution().get(2), "3"));
        series1.getData().add(new XYChart.Data(wordleSystem.getGuessDistribution().get(1), "2"));
        series1.getData().add(new XYChart.Data(wordleSystem.getGuessDistribution().get(0), "1"));

        Scene scene = new Scene(bc, 800, 600);
        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }
}