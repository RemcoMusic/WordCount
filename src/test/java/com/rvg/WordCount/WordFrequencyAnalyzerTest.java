package com.rvg.WordCount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordFrequencyAnalyzerTest {

    private WordFrequencyAnalyzer wordFrequencyAnalyzer;
    private String text = "This is a a test String";
    @BeforeEach
    public void setUp() throws Exception {
        wordFrequencyAnalyzer = new WordFrequencyAnalyzer();
    }

    @Test
    @DisplayName("Test highest frequency calculator")
    public void testCalculateHighestFrequency() {
        assertEquals(2, wordFrequencyAnalyzer.calculateHighestFrequency(text), "Calculation works");
    }

    @Test
    @DisplayName("Test frequency of specific word")
    public void testCalculateFrequencyForWord() {
        assertEquals(1, wordFrequencyAnalyzer.calculateFrequencyForWord(text, "is"), "Calculation for specific word works");
    }

    @Test
    @DisplayName("Test return of n items")
    public void testCalculateMostFrequentNWords() {
        assertEquals(3, wordFrequencyAnalyzer.calculateMostFrequentNWords(text, 3).size());
    }
}
