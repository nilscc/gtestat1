package myarchive;

import wsiarchive.*;


// Kurzbeschreibung
public class LimitedArchive implements IArchive {

    private int size = 0; // Größe in MB
    private int used = 0; // Belegter Speicher in MB
    private IArchive archive; // Das eigentliche Archiv
    
    LimitedArchive (IArchive archive, int size) {
        this.size = size;
        this.archive = archive;
    }
    
    // Name des Archivs liefern
    public String getName() {
        return this.archive.getName();
    }

    // Item ins Archiv schreiben
    // Effekt: used vergrößern
    public IPutResult put(Item item) {
        int i = item.getSize();
        if (this.getFree() >= i) {
            this.used += i;
            return this.archive.put(item);
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
        return this.archive.get(id);
    }
    
    // Freien Speicherplatz ausgeben
    public int getFree () {
        return this.size - this.used;
    }
    

}
