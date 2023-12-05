package org.eugenio.documents;

import java.nio.file.Path;

public final class DocumentTypeFactory {

    private DocumentTypeFactory() {}
    public static IDocumentType createDocumentType(String fileExtension,
                                                   Path fileLocation, String fileContent) {
       IDocumentType IDocumentType =  switch (fileExtension.toUpperCase()) {
            case "DOCX" -> new DOCX(fileLocation, fileContent);
            case  "PDF" -> new PDF(fileLocation,fileContent);
            case "TXT" -> new TXT(fileLocation, fileContent);
            default -> new UnSupportedIDocument(fileLocation);
        };
        return IDocumentType;
    }
}
