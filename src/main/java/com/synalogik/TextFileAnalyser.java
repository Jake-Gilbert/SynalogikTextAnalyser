package com.synalogik;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class TextFileAnalyser {

    ArrayList<String> linesOfText;
    HashMap<Integer, Integer> lengthsAndQuantities;
    private int wordCount;


    public TextFileAnalyser(ArrayList<String> linesOfText) {
        this.linesOfText = linesOfText;
        ArrayList<String> tempList = new ArrayList<>();
        this.linesOfText = removeSpecialCharacters(this.linesOfText);
        wordCount = 0;
        lengthsAndQuantities = calculateLengthsAndQuantities(this.linesOfText);

    }

    public void printResults() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Word count = ").append(wordCount).append("\n").
                append("Average word length = ").append(calculateAverageWordLength(lengthsAndQuantities)).append("\n");

        for (int length : lengthsAndQuantities.keySet()) {
            stringBuilder.append("Number of words of length ").append(length).append(" is ").append(lengthsAndQuantities.get(length)).append("\n");
        }
        int max = Collections.max(lengthsAndQuantities.values());

        stringBuilder.append(("The most frequently occurring word length is ")).append(max).append(" for word lengths of ");
        for (int key : lengthsAndQuantities.keySet()){
            if (lengthsAndQuantities.get(key) == max){
                stringBuilder.append(key).append(" & ");
            }
        }
        stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length() - 1, "");
        System.out.println(stringBuilder);

    }

    private ArrayList<String> removeSpecialCharacters(ArrayList<String> linesOfText){
        ArrayList<String> tempList = new ArrayList<>();
        String tempLine = "";
        for (String line : linesOfText) {
            for (String word : line.split(" ")) {
                tempLine = word.replaceAll("[.,?!]", "");
                tempList.add(tempLine);
            }
        }
        return tempList;
    }

    private  double calculateAverageWordLength(HashMap<Integer, Integer> lengthsAndQuantities){
        double average = 0;

        for (int length : lengthsAndQuantities.keySet()) {
            average += length * lengthsAndQuantities.get(length);
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        return Double.parseDouble(decimalFormat.format(average / lengthsAndQuantities.values().stream().mapToInt(d-> d).sum()));
    }

    public HashMap<Integer, Integer> calculateLengthsAndQuantities(ArrayList<String> linesOfText) {
        HashMap<Integer, Integer> tempMap = new HashMap<>();

        for (String line : linesOfText) {
            for (String word : line.split(" ")) {

                System.out.println(word);
                int length = word.length();

                if (!tempMap.containsKey(length)){
                    tempMap.put(length, 1);
                }
                else {
                    tempMap.put(length, tempMap.get(length) + 1);
                }

                wordCount++;
            }
        }
        return tempMap;
    }
}
