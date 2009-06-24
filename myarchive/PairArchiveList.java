package myarchive;

import wsiarchive.*;

// nichtleere Liste von Archiven

public class PairArchiveList implements IArchiveList {
    private IArchive first;
    private IArchiveList rest;
    
    public PairArchiveList(IArchive first, IArchiveList rest) {
        this.first = first;
        this.rest = rest;
    }
    
    // Gets
    public IArchive getFirst () { return this.first; }
    public IArchiveList getRest () { return this.rest; }
    
    
    // Methode für Overflow: put
    // Rückgabewert: Aktualisiertes Journal oder NoJournalResult
    public IJournalResult overflowPut (Item item) {
        IPutResult put = this.first.put(item);
        
        // Rekursion
        if (put instanceof FullPutResult && this.rest instanceof PairArchiveList) {
            return ((PairArchiveList) this.rest).overflowPut(item);
            
        // Neues Journal zurückgeben
        } else if (put instanceof OKPutResult) {
            Journal newJournal = new Journal( ((OKPutResult) put).getId(), this.first);
            return new NewJournalResult(newJournal);
           
        // Versagt!
        } else {
            return new NoJournalResult();
        }
    }
}
