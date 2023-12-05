package org.eugenio.documents;

import java.nio.file.Path;

public record PDF(Path fileLocation, String fileContent) implements IDocumentType {
}
