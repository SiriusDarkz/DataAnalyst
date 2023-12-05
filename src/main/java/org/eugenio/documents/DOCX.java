package org.eugenio.documents;

import java.nio.file.Path;

public record DOCX(Path fileLocation, String fileContent) implements IDocumentType {
}
