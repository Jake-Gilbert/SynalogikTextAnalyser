package com.synalogik;

public class Main {

    public static void main(String[] args) throws Exception {
        String fileDir = "C:\\Users\\Jake\\Documents\\bible.txt";
        TextFile file = new TextFile(fileDir);
        TextFileReader reader = new TextFileReader(file);
        reader.printLines();
        TextFileAnalyser analyser = new TextFileAnalyser(reader.getLinesOfText());
        System.out.println();
        analyser.printResults();

    }


}