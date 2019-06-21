package com.codecool.filepartreaderpatrick;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {

        this.filePartReader = filePartReader;
    }


    public FilePartReader getFilePartReader() {
        return filePartReader;
    }

    public List getWordsOrderedAlphabetically () throws IOException {

        String text = filePartReader.readLines();
        List<String> words = new ArrayList<>(Arrays.asList(text.split("\\r?\\n?\\s+")));
        Collections.sort(words);
        return words;
    }

    public List getWordsContainingSubstring (String subString) throws IOException {

        String text = filePartReader.readLines();
        List<String> words = new ArrayList<>(Arrays.asList(text.split("\\r?\\n?\\s+")));
        return words.stream().filter(word -> word.contains(subString)).collect(Collectors.toList());
    }

    public List getStringsWhichPalindromes () throws IOException {

        String text = filePartReader.readLines();
        List<String> words = new ArrayList<>(Arrays.asList(text.split("\\r?\\n?\\s+")));
        return words.stream().filter(word -> isPalindrome(word)).collect(Collectors.toList());
    }

    private boolean isPalindrome(String word) {
        int headI = 0;
        int tailI = word.length() - 1;
        while (headI < tailI) {
            if (word.toLowerCase().charAt(headI) != word.toLowerCase().charAt(tailI)) return false;
            headI++;
            tailI--;
        }
        return true;
    }
}
