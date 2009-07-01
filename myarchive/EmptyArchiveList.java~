package myarchive;

import wsiarchive.*;

// leere Archivliste
public class EmptyArchiveList implements IArchiveList {
    public EmptyArchiveList() {
    }
    
    // Methode für Overflow: put
    public IPutResult overflowPut (Item item, IArchive current) {
        return new FullPutResult();
    }
}
