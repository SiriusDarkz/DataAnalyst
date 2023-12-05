package org.eugenio.processors;

import org.eugenio.documents.*;

import java.nio.file.Path;

public final class FileProcessorManager {

    private FileProcessorManager() {}
    public static void processDocument(IDocumentType IDocumentType) {
        switch (IDocumentType) {
            case DOCX(Path fileLocation, String fileContent) -> DOCXProcessor.process(fileLocation,fileContent);
            case PDF(Path fileLocation, String fileContent) ->  PDFProcessor.process(fileLocation, fileContent);
            case TXT(Path fileLocation, String fileContent) ->  TXTProcessor.process(fileLocation,fileContent);
            case UnSupportedIDocument(Path fileName) -> System.out.println("Invalid Document: "
                    + fileName.getFileName());
        }
    }


}
