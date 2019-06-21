package com.codecool.filepartreaderpatrick;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.IntStream;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader () {

        this.filePath = "apa";
        this.fromLine = 32;
        this.toLine = 40;
    }

    public void setup (String filePath, Integer fromLine, Integer toLine) {

        if (toLine < fromLine || fromLine < 1) throw new IllegalArgumentException("Wrong arguments");
        else {
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;
        }
    }

    public String read() throws IOException {
        FileReader fileReader = new FileReader(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        int i;
        while ((i=fileReader.read()) != -1) stringBuilder.append((char) i);
        return stringBuilder.toString();
    }

    public String readLines() throws IOException {
        String file = read();
        char[] arrayChar = file.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;

        for (char character: arrayChar) {
            if (toLine >= i) {
                if (fromLine <= i) stringBuilder.append(character);
                if (character == '\n') i++;
            }
            else break;
        }
        return stringBuilder.toString();
    }


}
