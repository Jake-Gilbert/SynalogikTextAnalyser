package com.synalogik;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextFileReader {

    private ArrayList<String> linesOfText;

    public TextFileReader(TextFile textFile) throws Exception {
        linesOfText = ReadAllLines(textFile);
    }

    public ArrayList<String> getLinesOfText() {
        return linesOfText;
    }

    private ArrayList<String> ReadAllLines(TextFile file) throws Exception {
        FileReader fileReader;
        ArrayList<String> tempLinesOfText = new ArrayList<>();

        try {
            fileReader = new FileReader(file.getTextFile());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                tempLinesOfText.add((line));
            }
        } catch (FileNotFoundException e) {
            throw new Exception("File not found");
        } catch (IOException e) {
            throw new Exception("I/O error occurred");
        }
        return tempLinesOfText;
    }

}
