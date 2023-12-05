package org.eugenio.sources;

import java.nio.file.Path;
import java.nio.file.Paths;

public record LocalSource(Path directoryPath) implements ISource {
    public LocalSource(String directoryPath) {
       this(Paths.get(directoryPath));

    }
}
