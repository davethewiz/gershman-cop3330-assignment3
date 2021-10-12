package ex46;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Dave Gershman
 */
import CustomUtils.FileScanner;

import java.util.*;

public class WordsProcessor {
    public List<String> words;
    public String longestWord = "";

    public WordsProcessor(List<String> words) {
        this.words = words;
    }

    // Pesuedocode:
    // Create WordProcessor using filePath
    // SET lines array to all lines in the file
    // SET words array to empty array
    // FOR each line in file lines
    //      FOR each word in line
    //          ADD word to words list
    //          ADD longest word if its longest
    public WordsProcessor(String filePath) {
        FileScanner fileScanner = new FileScanner(filePath);
        String[] lines = fileScanner.GetAllLines();

        words = new ArrayList<>();
        for (String line : lines) {
            String[] wordsInLine = line.split(" ");

            for (String word : wordsInLine) {
                words.add(word);
                if (word.length() > longestWord.length())
                    longestWord = word;
            }
        }
    }

    // Pesuedocode:
    // SET dictionary reference to populate
    // FOR each word in words
    //      IF dictionary contains word
    //          add an occurence to the dictionary
    //      ELSE
    //          add word for the first time (with occurence of 1)
    // SORT dictionary
    // RETURN dictionary
    public Map<String, Integer> CreateOccurencesDictionary() {
        Map<String, Integer> dict = new Hashtable<>();

        for (String word : words) {
            if (dict.containsKey(word))
                dict.put(word, dict.get(word) + 1);
            else
                dict.put(word, 1);
        }

        dict = SortTable(dict);

        return dict;
    }

    // Pesuedocode:
    // SET string bar as empty string
    // FOR the length given
    //      add given char to bar string
    // RETURN bar string
    public String GetRepeatedCharString(char character, int length) {
        String bar = "";
        for (int i = 0; i < length; i++) {
            bar += character;
        }

        return bar;
    }

    // Pesuedocode:
    // GET ccurences dictionary
    // FOR each string (key) in occurences dictionary
    //      calculate spaces needed for table
    //      calculate length of bar based on word occurence
    //      Print word occurence
    public void PrintOccurencesTable() {
        Map<String, Integer> occurencesDict = CreateOccurencesDictionary();

        for (String key : occurencesDict.keySet()) {
            String spaces = GetRepeatedCharString(' ', longestWord.length() - key.length());
            String bar = GetRepeatedCharString('*', occurencesDict.get(key));

            System.out.println(key + ": " + spaces + bar);
        }
    }

    // Pesuedocode:
    // newHashmap (stores reversed map)
    // reverse each value in given map
    // store into newHashmap
    // return newHashmap
    public static Map<String, Integer> SortTable(Map<String, Integer> t) {
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();

        //Use Comparator.reverseOrder() for reverse ordering
        t.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        return reverseSortedMap;
    }
}
