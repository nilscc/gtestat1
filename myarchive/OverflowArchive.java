package myarchive;

import wsiarchive.*;


// Archiv, bei dem erst ein Archiv vollgeschrieben wird, dann das nächste etc.
public class OverflowArchive implements IArchive {

    private String name; // Name
    private IArchiveList archives; // Archive
    private IJournalList journal = new EmptyJournal(); // Merke, wo welches Item gespeichert wurde

    // Die Archive werden der Reihe nach gefüllt
    public OverflowArchive(String name, IArchiveList archives) {
        this.name = name;
        this.archives = archives;
    }
    
    // Name des Archivs liefern
    public String getName() {
        return this.name;
    }

    // Item ins Archiv schreiben
    public IPutResult put(Item item) {
        IJournalResult j = this.archives.overflowPut(item);

        if (j instanceof NewJournalResult) {
            Journal journalResult = ((NewJournalResult) j).getJournal();
            
            IItemId id = journalResult.getItemId();
            this.journal = this.journal.add(id, journalResult.getArchive());
            
            return new OKPutResult(id);
        } else {
            return new FullPutResult();
        }
    }
    
    // Mehrere Items ins Archiv schreiben
    public wsiarchive.IPutResultList putMultiple(wsiarchive.IItemList items) {
        return items.putAll(this);
    }
    
    // Item aus Archiv auslesen
    public IGetResult get(IItemId id) {
        IJournalResult get = this.journal.getArchiveById(id);
        
        if (get instanceof OKJournalResult) {
            IArchive archive = ((OKJournalResult) get).getJournal().getArchive();
            return archive.get(id);
        } else {
            return new NoItemResult();
        }
    }

}
