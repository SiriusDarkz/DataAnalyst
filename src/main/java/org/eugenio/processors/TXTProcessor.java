package org.eugenio.processors;

import org.eugenio.analytics.DotsCounter;
import org.eugenio.analytics.SpacesCounter;
import org.eugenio.analytics.WordFrequencyCounter;
import org.eugenio.analytics.WordsCounter;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

final class TXTProcessor {

    private TXTProcessor() {}

    public static void process(Path fileLocation, String fileContent) {
        var frequentWords = WordFrequencyCounter.frequencyCount(fileContent);

        System.out.println("Archivo procesado: " +  fileLocation.getFileName());
        System.out.println("Número de espacios: " + SpacesCounter.countSpaces(fileContent));
        System.out.println("Número de puntos: " + DotsCounter.countDots(fileContent));
        System.out.println("Número de Palabras: " + WordsCounter.countWords(fileContent));
        System.out.println("Palabras más repetidas:");
        for (int i = 0; i < 5 && i < frequentWords.size(); i++) {
            Map.Entry<String, Long> entry = frequentWords.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        String processedDirectoryPath = fileLocation.getParent().toString() + "/processed";
        String processedFilePath = processedDirectoryPath + "/" + fileLocation
                .getFileName().toString();

        FileProcessorHelper.tryMoveFile(fileLocation,processedFilePath);
    }

}
