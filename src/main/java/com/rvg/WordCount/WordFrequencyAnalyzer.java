package com.rvg.WordCount;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/analyzer")
public class WordFrequencyAnalyzer {

    @GET
    @Path("/{text}")
    public int calculateHighestFrequency(@PathParam("text") String text) {
        WordFrequency words = new WordFrequency(text);

        int maxSoFar = words.getFrequency().get(0);
        int maxSoFarIndex = 0;
        int wordIndex = 0;
        for (int frequency: words.getFrequency()) {
            if (frequency > maxSoFar){
                maxSoFar = frequency;
                wordIndex = maxSoFarIndex;
            }
            maxSoFarIndex++;
        }
        System.out.println("The word with highest frequency is: " + words.getWord().get(wordIndex) + " with a frequency of: " + maxSoFar);
        return maxSoFar;
    }

    @GET
    @Path("/{text}/{word}")
    public int calculateFrequencyForWord(String text, String word) {
        WordFrequency words = new WordFrequency(text);
        if(words.getWord().contains(word)){
            int indexOfWord = words.getWord().indexOf(word);
            return words.getFrequency().get(indexOfWord);
        } else {
            return 0;
        }
    }

    @GET
    @Path("/{text}/{number}")
    public Map calculateMostFrequentNWords(String text, int n) {
        String[] rawWordsList;
        if(text == null || text.isEmpty()){
            rawWordsList = new String[0];
        } else {
            rawWordsList = text.split("\\s+");
        }
        Map<String, Integer> frequencyWords = new HashMap<>();

        for (String word : rawWordsList) {
            frequencyWords.compute(word.toLowerCase(), (k, v) -> v == null ? 1 : v + 1);
        }

        Map<String, Integer> result = frequencyWords.entrySet()
                .stream()
                .sorted(Map.Entry
                        .<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(n)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return result;
    }
}