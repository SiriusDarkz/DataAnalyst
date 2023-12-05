package org.eugenio.analytics;

public final class SpacesCounter {

    private SpacesCounter(){}

    public static long countSpaces(String fileContent) {
        return fileContent.chars().filter(c -> c == ' ').count();
    }
}
