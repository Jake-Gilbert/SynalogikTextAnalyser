package com.synalogik.proj;

public class Main {

    public static void main(String[] args) throws Exception {
        String fileDir = "C:\\Users\\Jake\\Documents\\bible.txt";
        TextFile file = new TextFile(fileDir);
        TextFileReader reader = new TextFileReader(file);
        TextFileAnalyser analyser = new TextFileAnalyser(reader.getLinesOfText());
        analyser.printResults();

    }


}
