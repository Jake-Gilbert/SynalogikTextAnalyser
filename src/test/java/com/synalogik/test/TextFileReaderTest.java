package com.synalogik.test;

import com.synalogik.proj.TextFile;
import com.synalogik.proj.TextFileReader;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TextFileReaderTest {

    @Test
    void getLinesOfText() throws Exception {
        ArrayList<String> expectedLines = new ArrayList<>();
        expectedLines.add("Hello world");
        expectedLines.add("Hello world haha");
        expectedLines.add("Hello world haha ok");

        TextFile testFile = new TextFile("C:\\Users\\Jake\\Documents\\test.txt");
        TextFileReader testReader = new TextFileReader(testFile);
        assertEquals(testReader.getLinesOfText(), expectedLines);
    }

    @Test
    void readAllLines() throws Exception {
        ArrayList<String> expectedLines = new ArrayList<>();
        expectedLines.add("Hello world");
        expectedLines.add("Hello world haha");
        expectedLines.add("Hello world haha ok");

        TextFile testFile = new TextFile("C:\\Users\\Jake\\Documents\\test.txt");
        TextFileReader testReader = new TextFileReader(testFile);
        assertEquals(expectedLines, testReader.ReadAllLines(testFile));
    }
}