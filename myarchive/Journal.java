package myarchive;

import wsiarchive.*;

// Journal für Dateidaten
public class Journal {

    private IItemId id; // ID des Items
    private IArchive archive; // Archiv auf dem Item gespeichert wurde
    
    Journal (IItemId id, IArchive archive) {
        this.id = id;
        this.archive = archive;
    }
    
    // Gets:
    public IItemId getItemId () {
        return this.id;
    }
    public IArchive getArchive () {
        return this.archive;
    }

}
