package org.eugenio.documents;

import java.nio.file.Path;

public record TXT(Path fileLocation, String fileContent) implements IDocumentType {
}
