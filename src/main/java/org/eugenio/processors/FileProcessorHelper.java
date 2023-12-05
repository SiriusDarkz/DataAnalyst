package org.eugenio.processors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileProcessorHelper {

    private FileProcessorHelper() {}
    public static void tryMoveFile(Path fileLocation, String processedFilePath) {
        try {
            Files.move(fileLocation, Paths.get(processedFilePath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Issue trying to move document to  subfolder: " + processedFilePath);
        }
    }

}
