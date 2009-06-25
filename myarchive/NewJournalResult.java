package myarchive;



// Kurzbeschreibung
public class NewJournalResult implements IJournalResult {

    private Journal journal; // Aktualisierte Liste von Journals
    
    NewJournalResult (Journal journal) {
        this.journal = journal;
    }
    
    public Journal getJournal () { return this.journal; }

}
