package org.eugenio.documents;

import java.nio.file.Path;

public record UnSupportedIDocument(Path filePath) implements IDocumentType {
}
