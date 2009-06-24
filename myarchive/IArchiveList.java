package myarchive;

import wsiarchive.*;

// Liste von Archiven
public interface IArchiveList {

    // Methode für Overflow: put
    // Rückgabewert: Aktualisiertes Journal oder NoJournalResult
    public IJournalResult overflowPut (Item item);
    
}
