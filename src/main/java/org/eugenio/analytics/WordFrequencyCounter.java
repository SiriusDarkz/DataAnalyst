package org.eugenio.analytics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyCounter {

    public static List<Map.Entry<String,Long>> frequencyCount(String fileContent) {
        List<String> words = Arrays.asList(fileContent.split("\\s+"));
        Map<String, Long> wordFrequencies = words.stream()
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        return    wordFrequencies.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList());

    }
}
