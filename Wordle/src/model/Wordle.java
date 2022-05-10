package model;

import java.util.ArrayList;

public class Wordle {

	// the maximum amount of guesses the player can guess for
	public static final int MAX_GUESSES = 6;
	// the minimum amount of words in the dictionary list
	public static final int MIN_DICTIONARY_WORDS = 0;
	// the maximum amount of words in the dictionary list
	public static final int MAX_DICTIONARY_WORDS = 12946;
	public static final int LETTER_AMOUNT = 5;
	// would need to init at very at of game
	// the word that the player needs to guess
	public String wordOfDay = "";
	// the current amount of Guessed Words the player has made
	public int currentGuessedWords = 0;
	// the list of valid words for either the word of the day or the player's guess
	public ArrayList<String> dictionaryList = new ArrayList<>();

//	public Wordle(String wordOfDay, int currentGuessedWords, ArrayList<String> dictionaryList) {
//		this.wordOfDay = wordOfDay;
//		this.currentGuessedWords = currentGuessedWords;
//		this.dictionaryList = dictionaryList;
//	}

	public Wordle() {

	}

	public String getWordOfDay() {
		return wordOfDay;
	}

	public void setWordOfDay(String wordOfDay) {
		this.wordOfDay = wordOfDay;
	}

	public int getCurrentGuessedWords() {
		return currentGuessedWords;
	}

	public void setCurrentGuessedWords(int currentGuessedWords) {
		this.currentGuessedWords = currentGuessedWords;
	}

	public ArrayList<String> getDictionaryList() {
		return dictionaryList;
	}

	public void setDictionaryList(ArrayList<String> dictionaryList) {
		this.dictionaryList = dictionaryList;
	}

}
