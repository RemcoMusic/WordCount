package com.rvg.WordCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {
    private String unprocessedText;
    private List<String> words;
    private List<Integer> frequency;

    public WordFrequency(String text){
        unprocessedText = text;
        processText();
    }

    public void processText() {
        String[] rawWordsList;
        if(unprocessedText == null || unprocessedText.isEmpty()){
            rawWordsList = new String[0];
        } else {
            rawWordsList = unprocessedText.split("\\s+");
        }
        Map<String, Integer> frequencyWords = new HashMap<>();

        for (String word : rawWordsList) {
            frequencyWords.compute(word, (k, v) -> v == null ? 1 : v + 1);
        }
        words = new ArrayList<String>(frequencyWords.keySet());
        frequency = new ArrayList<Integer>(frequencyWords.values());
    }

    public List<String> getWord() {
        return words;
    }

    public List<Integer> getFrequency() {
        return frequency;
    }
}
