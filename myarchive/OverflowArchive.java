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
        return this.archives.overflowPut(item, this);
    }
    
    // Mehrere Items ins Archiv schreiben (wsiarchive)
    public wsiarchive.IPutResultList putMultiple(wsiarchive.IItemList items) {
        return items.putAll(this);
    }
    
    // Mehrere Items ins Archiv schreiben (myarchive)
    public IPutResultList putMultiple(IItemList items) {
        wsiarchive.IItemList wsiList = items.toWSIItemList();
        return (this.putMultiple(wsiList)).toMyPutResultList();
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
    
    // Neues ItemID-Archiv-Paar zum Journal hinzufügen
    public void addJournal (IItemId id, IArchive archive) {
        this.journal = this.journal.add(id, archive);
    }

}
