package org.eugenio;

import org.eugenio.sources.LocalSource;
import org.eugenio.watchers.IWatcher;
import org.eugenio.watchers.LocalWatcherService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            System.out.println("Please provide a directory path as an argument.");
            return;
        }

        LocalSource localSource = new LocalSource(args[0]);
        Files.createDirectories(Paths.get(localSource.directoryPath().toString()+ "/processed"));

        IWatcher watcher = new LocalWatcherService(localSource);
        watcher.watch();

    }
}