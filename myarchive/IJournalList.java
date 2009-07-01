package myarchive;

import wsiarchive.*;

// Kurzbeschreibung
public interface IJournalList {

    // Archiv eines Items zurückgeben
    public IJournalResult getArchiveById (IItemId id);
    
}
