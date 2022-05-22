package com.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.model.Player;

public class WordleSystem {

	private Player player = new Player();

	// Initialize dictionary
	private ArrayList<String> dictionaryList = new ArrayList<>();

	// Initialize word of the day
	private String wordOfDay = "";

	private LinkedHashMap<Integer, Integer> guessDistribution = new LinkedHashMap<>();

	public WordleSystem() {
	}

	public void loadDictionaryList() {
		ArrayList<String> wordPerLine = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream(new File("DictionaryList.txt").getAbsolutePath());
			BufferedReader br = new BufferedReader(new InputStreamReader(file));
			String wordLine;
			while ((wordLine = br.readLine()) != null) {
				wordPerLine.add(wordLine);
			}
			file.close();
			// call dictionaryList from wordle
			this.dictionaryList = wordPerLine;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// sets the word of the day
	public void setWordOfDay(String word) {
		this.wordOfDay = word;

		// TODO delete later or maybe not idk
		System.out.println(wordOfDay);
	}

	// loads the a random word of the day
	public void loadWordOfDay() {
		int randomIndexNum = (int) Math
				.floor(Math.random() * 12947);

		// sets the word of the day by a random index
		setWordOfDay(this.dictionaryList.get(randomIndexNum));
	}

	// checks if the player's input is valid
	public boolean isValidInput(String playersGuess) {
		// if player input is empty
		if (playersGuess.isEmpty())
			return false;
		// if player input is not a letter
		else if (!playersGuess.matches("^[a-zA-Z]*$"))
			return false;
		return true;
	}

	public boolean isALetter(String one, String two, String three, String four, String five) {
		if (one.length() != 1 || two.length() != 1 || three.length() != 1 || four.length() != 1 || five.length() != 1)
			return false;
		return true;
	}

	// checks if the word the player used is in the dictionary list
	public boolean isInDictionaryList(String playersGuess) {
		if (!this.dictionaryList.contains(playersGuess))
			return false;
		return true;
	}

	// assign the colors to the letters
	public ArrayList<String> assignColors(String playersGuess) {
		ArrayList<String> assignedColours = new ArrayList<>();
		// changing the string of players guess and word of day to char array
		char[] guessedWordLetters = new char[playersGuess.length()];
		char[] wordOfDayLetters = new char[wordOfDay.length()];
		for (int i = 0; i < 5; i++) {
			guessedWordLetters[i] = playersGuess.charAt(i);
			wordOfDayLetters[i] = wordOfDay.charAt(i);
		}
		// loops through the letters of the player's guess
		for (int i = 0; i < guessedWordLetters.length; i++) {
			ArrayList<Integer> locations = new ArrayList<>();
			// loops through the letters of the word of day
			for (int j = 0; j < wordOfDayLetters.length; j++) {
				// if guessed letter i is in word of the day
				// - meaning guessedWordLetters[i] is correct
				if (guessedWordLetters[i] == wordOfDayLetters[j])
					// adds the location of that letter from the word of the day
					locations.add(j);
			}
			// if locations is empty means there were none of that letter in the word of day
			// - meaning guessedWordLetters[i] is incorrect
			if (locations.isEmpty())
				// add colour to assignedColours
				assignedColours.add("incorrect");
			// if locations has the same num of i then the guessedWordLetters[i] is in
			// correct sport
			// - meaning guessedWordLetters[i] is correct and in right location
			else if (locations.contains(i))
				assignedColours.add("correct");
			// else i is not in location but guessedWordLetters[i] is in correct sport
			// - meaning guessedWordLetters[i] is correct and in wrong location
			else
				assignedColours.add("semiCorrect");

		}
		return assignedColours;
	}

	// if the player's guessed word is equal to the word of the day
	// - has the player won
	public boolean isWordOfDay(String playersGuess) {
		// if the word of the day is not equal to the player's word guess
		if (!wordOfDay.equalsIgnoreCase(playersGuess)) {
			return false;
		}
		// won the game
		return true;
	}

	// get player's stats from the game
	public void getGameStats(boolean wonLost) {
		// if player won the game
		if (wonLost == true) {
			// add the new total of wins
			player.setTotalWins(player.getTotalWins() + 1);
			// add their win to their current win streak
			player.setCurrentStreak(player.getCurrentStreak() + 1);


			// if their now current streak is bigger than their max streak
			if (player.getCurrentStreak() > player.getMaxStreak())
				// set their max streak as their current streak
				player.setMaxStreak(player.getCurrentStreak());
		}
		// if player lost the game
		else
			// reset their win streak
			player.setCurrentStreak(0);
		// sets the number of games player has played
		player.setNumOfPlayedGames(player.getNumOfPlayedGames() + 1);
		// sets percentage of wins
		player.setPercentageOfWins((player.getTotalWins() * 100) / player.getNumOfPlayedGames());
	}

	// gets the play stats from PlayerStats.txt
	public void loadPlayerStats() {
		ArrayList<String> dataPerLine = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream("PlayerStats.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(file));
			String wordLine;
			while ((wordLine = br.readLine()) != null) {
				dataPerLine.add(wordLine);
			}
			file.close();
			// call dictionaryList from wordle
			// sets Number of Games played
			player.setNumOfPlayedGames(Integer.parseInt(dataPerLine.get(0)));
			// sets the percentage of wins
			player.setPercentageOfWins(Integer.parseInt(dataPerLine.get(1)));
			// sets the current streak the player has
			player.setCurrentStreak(Integer.parseInt(dataPerLine.get(2)));
			// sets the max strak that the player has
			player.setMaxStreak(Integer.parseInt(dataPerLine.get(3)));
			// sets the total of win the player has
			player.setTotalWins(Integer.parseInt(dataPerLine.get(4)));

			String[] data = dataPerLine.get(5).split(",");
			for (int i = 0; i < data.length; i++){
				guessDistribution.put(i, Integer.parseInt(data[i]));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// adds the new player stats into PlayerStats.txt
	public void updatePlayerStatFile() throws IOException {
		// Create a File instance
		java.io.File file = new java.io.File("PlayerStats.txt");
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		// Write formatted output to the file
		// writes to file
		output.println(String.valueOf(player.getNumOfPlayedGames()));
		output.println(String.valueOf(player.getPertengeOfWins()));
		output.println(String.valueOf(player.getCurrentStreak()));
		output.println(String.valueOf(player.getMaxStreak()));
		output.println(String.valueOf(player.getTotalWins()));
		
		output.println(guessDistribution.get(0) + "," + guessDistribution.get(1) + "," +guessDistribution.get(2) + ","+guessDistribution.get(3) + "," + guessDistribution.get(4) + "," +guessDistribution.get(5));

		// Close the file
		output.close();
	}

	public int getPlayed(){
		return player.getNumOfPlayedGames();
	}

	public int getWin(){
		return player.getPertengeOfWins();
	}

	public int getCurrentStreak(){
		return player.getCurrentStreak();
	}

	public int getMaxStreak(){
		return player.getMaxStreak();
	}

	public String getWordOfDay(){
		return this.wordOfDay;
	}

	public void setGuessDistribution(int rowWon){

		for ( int key : guessDistribution.keySet() ) {
			if (key == rowWon) {
				guessDistribution.put(key, guessDistribution.get(key) + 1);
			}
		}
	}

	public LinkedHashMap<Integer, Integer> getGuessDistribution(){
		return guessDistribution;
	}
}
