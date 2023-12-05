package org.eugenio.watchers;

public sealed interface IWatcher permits LocalWatcherService{

    void watch();
}
