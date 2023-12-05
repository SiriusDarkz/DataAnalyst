package org.eugenio.analytics;

public final class DotsCounter {

    private DotsCounter(){}

    public static long countDots(String fileContent) {
        return fileContent.chars().filter(c -> c == '.').count();
    }

}
