package com.synalogik;

import java.io.File;

public class TextFile {

    private File textFile;

    public TextFile(String fileName) {
        textFile = new File(fileName);
    }

    public File getTextFile() {
        return textFile;
    }

    public void setTextFile(String fileName) {
        this.textFile = new File(fileName);
    }

}
