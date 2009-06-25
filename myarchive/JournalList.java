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
    public IJournalList add (IItemId id, IArchive archive) {
        if (this.rest instanceof EmptyJournal) {
            return new JournalList(this.first, new JournalList(new Journal(id, archive), this.rest));
        } else {
            return new JournalList(this.first, this.rest.add(id, archive));
        }
    }

}
