package myarchive;

import wsiarchive.*;


// Kurzbeschreibung
public class LimitedArchive implements IArchive {

    private int size = 0; // Größe in MB
    private int used = 0; // Belegter Speicher in MB
    private WORM worm; // Der eigentliche WORM-Speicher
    
    LimitedArchive (String name, int size) {
        this.size = size;
        this.worm = new WORM(name);
    }
    
    // Name des Archivs liefern
    public String getName() {
        return this.worm.getName();
    }

    // Item ins Archiv schreiben
    // Effekt: used vergrößern
    public IPutResult put(Item item) {
        int i = item.getSize();
        if (this.getFree() >= i) {
            this.used += i;
            return this.worm.put(item);
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
        return this.worm.get(id);
    }
    
    // Freien Speicherplatz ausgeben
    public int getFree () {
        return this.size - this.used;
    }
    

}
