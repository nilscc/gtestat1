package myarchive;

import wsiarchive.*;

// Kurzbeschreibung
public class JournalList implements IJournalList {

    private Journal first;
    private IJournalList rest;
    
    JournalList (Journal first, IJournalList rest) {
        this.first = first;
        this.rest = rest;
    }
    
    // Archiv des Items
    public IJournalResult getArchiveById (IItemId id) {
        if (this.first.getItemId() == id) {
            return new OKJournalResult(this.first);
        } else {
            return this.rest.getArchiveById(id);
        }
    }
    
    // Item hinzufügen
    public void add (IItemId id, IArchive archive) {
        IJournalResult result = this.getArchiveById(id);
        
        IArchiveList archives = new PairArchiveList(archive, new EmptyArchiveList());
        
        if (result instanceof OKJournalResult) {
            ((OKJournalResult) result).getJournal().add(archive);
        } else if (this.rest instanceof EmptyJournal) {
            this.rest = new JournalList(new Journal(id, archives), new EmptyJournal());
            
        } else if (this.rest instanceof JournalList) {
            ((JournalList) this.rest).add(id, archive);
        }
    }

}
