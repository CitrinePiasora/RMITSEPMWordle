import java.io.IOException;
import java.util.Scanner;

public class main {

	private boolean runGame = true;
	private final Scanner scanner = new Scanner(System.in);
	private final WordleSystem wordleSystem = new WordleSystem();

	public void run() throws IOException {
		System.out.println("--------------------------------------------------------------------------------------------------------");
		System.out.println("Welcome to Wordle");
		System.out.println("--------------------------------------------------------------------------------------------------------");
		
		// load start game data
		wordleSystem.loadDictionaryList();
		// loads a random word of day
		wordleSystem.loadWordOfDay();
		// load player stats
		wordleSystem.loadPlayerStats();
		// start game
		System.out.println("Enter 5 letter word:");
		// loops though each player guess until runGame is false
		while (runGame) {
			gameBoard();
		}
		System.out.println("Thank you for playing Wordle");
		System.out.println("--------------------------------------------------------------------------------------------------------");
	}

	public void gameBoard() throws IOException{
		
		// getting player input for their guess
		
		String playersGuess = scanner.nextLine().toLowerCase();
		
		// checks if player's Guess is valid
		if (wordleSystem.isValidInput(playersGuess) == false) {
			System.out.println("Invalid");
			System.out.println("Enter 5 letter word:");
			return;}
		
		// checks if player's Guess is in dictionary
		if(wordleSystem.isInDictionaryList(playersGuess) == false) {
			System.out.println("Word not in dictionary");
			return;
		}
		
		// now player input is valid	
		// print game board with the correct corresponding letter colors		
		wordleSystem.assignColors(playersGuess);

		// ends game if player has guessed word of game, continues game if not
		runGame = wordleSystem.isWordOfDay(playersGuess);
	}

}
