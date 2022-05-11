import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.Player;

public class WordleSystem {

	private Player player = new Player();
	
	// Initialize colors for coloring terminal version
	private static final String TEXT_YELLOW = "\u001B[33m";
	private static final String TEXT_GREEN = "\u001B[32m";
	private static final String TEXT_WHITE = "\u001b[0m";
	// is black, there is no grey for ANSI
	private static final String TEXT_GREY = "\u001B[30m";

	// Initialize dictionary
	private ArrayList<String> dictionaryList = new ArrayList<>();

	// Initialize guess attempts
	private int currentGuessedWords = 0;

	// Initialize word of the day
	private String wordOfDay = "";

	// Initialize default win/lose variable to lose (false)
	private boolean wonLost = false;

	// TO DO word of day can only happen once a day

	// load the dictionary list from the dictionary list txt file
	public void loadDictionaryList() {
		ArrayList<String> wordPerLine = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream("DictionaryList.txt");
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
		// if is the Letter amount, e.g. 5 letters or not
		else if (playersGuess.length() != 5)
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
	public void assignColors(String playersGuess) {
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
				// TODO actually assign colors to them
				System.out.print(TEXT_GREY + guessedWordLetters[i] + TEXT_GREY);
			// if locations has the same num of i then the guessedWordLetters[i] is in
			// correct sport
			// - meaning guessedWordLetters[i] is correct and in right location
			else if (locations.contains(i))
				// TODO actually assign colors to them
				System.out.print(TEXT_GREEN + guessedWordLetters[i] + TEXT_GREEN);
			// else i is not in location but guessedWordLetters[i] is in correct sport
			// - meaning guessedWordLetters[i] is correct and in wrong location
			else
				// TODO actually assign colors to them
				System.out.print(TEXT_YELLOW + guessedWordLetters[i]  + TEXT_YELLOW);

		}
		System.out.println(TEXT_WHITE);
	}

	public void setCurrentGuessedWords(int guesses) {
		this.currentGuessedWords = guesses;
	}
	
	// if the player's guessed word is equal to the word of the day
	// - has the player won
	public boolean isWordOfDay(String playersGuess) throws IOException {
		// if the word of the day is not equal to the player's word guess
		if (!wordOfDay.equalsIgnoreCase(playersGuess)) {
			// sets their current guess, since player didn't guess word of day
			// they use up one of their guesses
			this.currentGuessedWords += 1;
			// now if their current guesses used is max guesses they can guess
			// return false to end game
			if (this.currentGuessedWords == 6) {
				// lost the game
				System.out.println("Word of the Day: " + wordOfDay);
				wonLost = false;
				gameStats(wonLost);
				return false;
			}
			return true;
		}
		// won the game
		System.out.println("Congrats you have guessed the word of the day");
		wonLost = true;
		gameStats(wonLost);
		return false;
	}

	// get player's stats from the game
	public void gameStats(boolean wonLost) throws IOException {
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
		updatePlayerStatFile();
		printStats();
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

		// Close the file
		output.close();
	}
	
	// prints out the player's stats in text
	public void printStats() {
		System.out.println("--------------------------------------------------------------------------------------------------------");
		System.out.printf("%20s%20s%23s%20s%n", "Played", "Win %", "Current Streak", "Max Streak");
		System.out.printf("%18d%20d%18d%23d%n", player.getNumOfPlayedGames(), player.getPertengeOfWins(), player.getCurrentStreak(), player.getMaxStreak());
		System.out.println("--------------------------------------------------------------------------------------------------------");
		}
}
