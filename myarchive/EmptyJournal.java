package myarchive;

import wsiarchive.*;

// Leeres Journal
public class EmptyJournal implements IJournalList {

    EmptyJournal () {}
    
    public IJournalResult getArchiveById (IItemId id) {
        return new NoJournalResult();
    }
    
    // Item hinzufügen
    public IJournalList add (IItemId id, IArchive archive) {
        IArchiveList archives = new PairArchiveList(archive, new EmptyArchiveList());
        
        return new JournalList(new Journal(id, archives), this);
    }

}
