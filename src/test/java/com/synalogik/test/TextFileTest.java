package com.synalogik.test;

import com.synalogik.proj.TextFile;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Text;

import static org.junit.jupiter.api.Assertions.*;

class TextFileTest {



    @Test
    void getTextFile() {
        TextFile file = new TextFile("C:\\Users\\Jake\\Documents\\bible.txt");
        assertNotEquals(null, file.getTextFile());
    }

    @Test
    void setTextFile() {
        TextFile file = new TextFile("C:\\Users\\Jake\\Documents\\bible.txt");
        TextFile testFile = new TextFile("");
        testFile.setTextFile("C:\\Users\\Jake\\Documents\\bible.txt");
        assertEquals(testFile.getTextFile() ,file.getTextFile());
    }
}