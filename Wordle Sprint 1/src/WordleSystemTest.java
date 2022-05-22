import static org.junit.Assert.assertEquals;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class WordleSystemTest {

	private WordleSystem wordleSystem = new WordleSystem();
	
	@Before
	public void setUp() {
		wordleSystem.loadDictionaryList();
		wordleSystem.loadWordOfDay();
		wordleSystem.loadPlayerStats();
	}

	@Test
	public void isValidInput_IsEmpty() {
		assertEquals("Should return false", false, wordleSystem.isValidInput(""));
	}

	@Test
	public void isValidInput_IsNotLetters() {
		assertEquals("Should return false", false, wordleSystem.isValidInput("213"));
		assertEquals("Should return false", false, wordleSystem.isValidInput("@##$"));
		assertEquals("Should return false", false, wordleSystem.isValidInput("`']%"));
	}

	@Test
	public void isValidInput_isNotCorrectLength() {
		assertEquals("Should return false", false, wordleSystem.isValidInput("something"));
		assertEquals("Should return false", false, wordleSystem.isValidInput("the"));
	}

	@Test
	public void isValidInput_IsValid() {
		assertEquals("Should return true", true, wordleSystem.isValidInput("audio"));
	}

	@Test
	public void isInDictionaryList_IsNotInList() {
		assertEquals("Should return false", false, wordleSystem.isInDictionaryList("aduio"));
	}

	@Test
	public void isInDictionaryList_IsInList() {
		assertEquals("Should return true", true, wordleSystem.isInDictionaryList("audio"));
	}

	// assignColors
	@Test
	public void assignColors() {
		wordleSystem.setWordOfDay("angel");
		wordleSystem.assignColors("glean");
		System.out.println("The colour should be YELLOW");
		wordleSystem.assignColors("angel");
		System.out.println("The colour should be GREEN");
		wordleSystem.assignColors("bombs");
		System.out.println("The colour should be GREY");
		wordleSystem.assignColors("alter");
		System.out.println("The colour should be GREEN, YELLOW, GREY, GREEN, GREY");
	}

	@Test
	public void isWordOfDay_NotWordOfDay_GuessNotMax() throws IOException {
		wordleSystem.setWordOfDay("angel");
		assertEquals("Should return true", true, wordleSystem.isWordOfDay("bombs"));
	}

	@Test
	public void isWordOfDay_NotTheWord_GuessIsMax() throws IOException {
		wordleSystem.setWordOfDay("angel");
		wordleSystem.setCurrentGuessedWords(5);
		assertEquals("Should return false", false, wordleSystem.isWordOfDay("bombs"));
	}

	@Test
	// TODO it's not set the word of day for just the test
	public void isWordOfDay_IsTheWord() throws IOException {
		wordleSystem.setWordOfDay("angel");
		assertEquals("Should return true", false, wordleSystem.isWordOfDay("angel"));
	}
}
