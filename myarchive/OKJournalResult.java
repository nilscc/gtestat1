package myarchive;

import wsiarchive.*;

// Rückgabewert für Journalzugriffe
public class OKJournalResult implements IJournalResult {

    Journal journal; // Journal das gefunden wurde
    
    OKJournalResult (Journal journal) {
        this.journal = journal;
    }
    
    // Journal
    public Journal getJournal() { return this.journal; }

}
