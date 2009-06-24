package myarchive;

import wsiarchive.*;

// leere Archivliste
public class EmptyArchiveList implements IArchiveList {
    public EmptyArchiveList() {
    }
    
    // Methode für Overflow: put
    // Rückgabewert: Aktualisiertes Journal oder NoJournalResult
    public IJournalResult overflowPut (Item item) {
        return new NoJournalResult();
    }
}
