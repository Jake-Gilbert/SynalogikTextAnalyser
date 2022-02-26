package com.synalogik.test;

import com.synalogik.proj.TextFile;
import com.synalogik.proj.TextFileAnalyser;
import com.synalogik.proj.TextFileReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TextFileAnalyserTest {

    @Test
    void printResults() throws Exception {
        StringBuilder testBuilder = new StringBuilder();
        testBuilder.append("Word count = " + 9 + "\n");
        testBuilder.append("Average word length = " + 4.444 + "\n");
        testBuilder.append("Number of words of length " + 2 + " is " + 1 + "\n");
        testBuilder.append("Number of words of length " + 4 + " is " + 2 + "\n");
        testBuilder.append("Number of words of length " + 5 + " is " + 6 + "\n");
        testBuilder.append("The most frequently occurring word length is " + 6 + ", for word lengths of " + 5);

        System.out.println(testBuilder);

        System.out.println("***");
        TextFile testFile = new TextFile("C:\\Users\\Jake\\Documents\\test.txt");
        TextFileReader testReader = new TextFileReader(testFile);
        TextFileAnalyser analyser = new TextFileAnalyser(testReader.getLinesOfText());

        assertEquals(analyser.printResults(), testBuilder);
    }

    @Test
    void removeSpecialCharacters() {
        String testWord = "Morning.?";
        ArrayList<String> words = new ArrayList<>();
        words.add(testWord);

        TextFileAnalyser analyser = new TextFileAnalyser(words);
        words = analyser.removeSpecialCharacters(words);
        assertEquals("Morning", words.get(0));
    }

    @Test
    void calculateAverageWordLength() {
        HashMap<Integer, Integer> testLengthsAndQuantities = new HashMap<>();
        testLengthsAndQuantities.put(2, 1);
        testLengthsAndQuantities.put(4, 2);
        testLengthsAndQuantities.put(5, 6);

        ArrayList<String> empty = new ArrayList<>();
        TextFileAnalyser analyser = new TextFileAnalyser(empty);

        assertEquals(4.444, analyser.calculateAverageWordLength(testLengthsAndQuantities));
    }

    @Test
    void calculateLengthsAndQuantities() {
        ArrayList<String> testWordList = new ArrayList<>();
        testWordList.add("There once was a man");
        testWordList.add("who had a plan");

        TextFileAnalyser analyser = new TextFileAnalyser(testWordList);
        HashMap<Integer, Integer> testLengthsAndQuantities = analyser.calculateLengthsAndQuantities(testWordList);

        HashMap<Integer, Integer> expectedLengthsAndQuantities = new HashMap<>();
        expectedLengthsAndQuantities.put(1, 2);
        expectedLengthsAndQuantities.put(3, 4);
        expectedLengthsAndQuantities.put(4, 2);
        expectedLengthsAndQuantities.put(5, 1);

        assertEquals(expectedLengthsAndQuantities, testLengthsAndQuantities);
    }
}