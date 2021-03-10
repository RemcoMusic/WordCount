package com.rvg.WordCount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordFrequencyTest {

    private WordFrequency wordFrequency;
    private String unprocessedText = "This is a test String";

    @BeforeEach
    public void setUp() throws Exception {
        wordFrequency = new WordFrequency(unprocessedText);
    }

    @Test
    @DisplayName("Test for the output of text processor")
    public void testTextProcessor() {
        List<String> words = new ArrayList<>();
        words.add("a");
        words.add("test");
        words.add("This");
        words.add("is");
        words.add("String");
        List<Integer> frequency = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            frequency.add(1);
        }
        assertEquals(words, wordFrequency.getWord());
        assertEquals(frequency, wordFrequency.getFrequency());
    }
}
