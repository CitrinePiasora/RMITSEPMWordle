package com;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import com.application.WordleSystem;
import org.junit.Before;
import org.junit.Test;

public class unitTests {
    
    private WordleSystem wordSys = new WordleSystem();

    @Before
    public void init() {
        wordSys.loadDictionaryList();
        wordSys.loadWordOfDay();
        wordSys.loadPlayerStats();
    }

    @Test
    public void multiColor() {
        wordSys.setWordOfDay("angel");

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("correct");
        expected.add("semiCorrect");
        expected.add("incorrect");
        expected.add("correct");
        expected.add("incorrect");

        assertEquals(expected, wordSys.assignColors("alter"));
    }

    @Test
    public void allGreen() {
        wordSys.setWordOfDay("angel");

        ArrayList<String> expected = new ArrayList<String>();
        for(int i = 0; i < 5; i++) {
            expected.add("correct");
        }

        assertEquals(expected, wordSys.assignColors("angel"));
    }

    @Test
    public void allGray() {
        wordSys.setWordOfDay("angel");

        ArrayList<String> expected = new ArrayList<String>();
        for(int i = 0; i < 5; i++) {
            expected.add("incorrect");
        }

        assertEquals(expected, wordSys.assignColors("bombs"));
    }

    @Test
    public void allYellow() {
        wordSys.setWordOfDay("angel");

        ArrayList<String> expected = new ArrayList<String>();
        for(int i = 0; i < 5; i++) {
            expected.add("semiCorrect");
        }

        assertEquals(expected, wordSys.assignColors("glean"));
    }

}
