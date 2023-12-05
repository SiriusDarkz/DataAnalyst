package org.eugenio.analytics;

import java.util.Arrays;

public final class WordsCounter {

    private WordsCounter() {}
    public static long countWords(String fileContent) {
        return Arrays.stream(fileContent.split(" ")).count();
    }
}
