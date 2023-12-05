package org.eugenio.watchers;

import org.eugenio.documents.DocumentTypeFactory;
import org.eugenio.documents.UnSupportedIDocument;
import org.eugenio.processors.FileProcessorManager;
import org.eugenio.documents.IDocumentType;
import org.eugenio.sources.LocalSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

public final class LocalWatcherService implements IWatcher {
    private final LocalSource localSource;
    private final WatchService watchService;

    public LocalWatcherService(LocalSource localSource) throws IOException {
        this.localSource = localSource;
        this.watchService = FileSystems.getDefault().newWatchService();
        this.localSource.directoryPath().register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY);
        processExistingFiles();

    }

    public void watch() {
        WatchKey key;
        while ((key = tryWatchKey()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent<Path> pathEvent = (WatchEvent<Path>) event;
                String fileExtension = pathEvent
                        .context()
                        .toString()
                        .substring(pathEvent.context().toString().lastIndexOf(".") + 1);
                Path fileLocation = localSource.directoryPath().resolve(pathEvent.context());
                if(isSubFolder(fileLocation)) {
                    IDocumentType IDocumentType = tryDocumentType(fileExtension, fileLocation);
                    FileProcessorManager.processDocument(IDocumentType);
                }
            }
            key.reset();
        }
    }

    public void processExistingFiles() {
        Arrays.stream(new File(localSource.directoryPath().toString())
                .listFiles())
                .filter(f -> f.isFile())
                .forEach(f -> {
                    FileProcessorManager.processDocument(tryDocumentType(
                            f.getPath().toString().substring(f.toString().lastIndexOf(".") + 1)
                    ,Paths.get(f.getAbsolutePath())));
                });
    }

    private WatchKey tryWatchKey() {
        try {
            return watchService.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private IDocumentType tryDocumentType(String fileExtension, Path fileLocation) {
        IDocumentType IDocumentType = null;
        try {
            IDocumentType =  DocumentTypeFactory
                    .createDocumentType(fileExtension, fileLocation, Files.readString(fileLocation));
        } catch (IOException e) {
            System.out.println("Issue trying to fetch the content of this document:" +fileLocation);
            IDocumentType = new UnSupportedIDocument(fileLocation);
        }
        return IDocumentType;
    }

    private boolean isSubFolder(Path fileLocation) {
        return fileLocation.toString().contains("processed");
    }
}
