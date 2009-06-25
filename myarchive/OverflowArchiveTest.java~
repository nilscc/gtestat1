package myarchive;

import wsiarchive.*;
import org.junit.*;

public class OverflowArchiveTest extends de.tuebingen.informatik.Test {

    // Ein paar Festplatten
    IArchive sda1 = new LimitedArchive("SDA1", 500);
    IArchive sda2 = new LimitedArchive("SDA2", 1500);
    IArchive sda3 = new LimitedArchive("SDA3", 3000);
    
    // Noch mehr...
    IArchive hda1 = new LimitedArchive("HDA1", 500);
    IArchive hda2 = new LimitedArchive("HDA2", 1500);
    IArchive hda3 = new LimitedArchive("HDA3", 3000);
    
    // Als Liste:
    IArchiveList sda = new PairArchiveList(sda1, new PairArchiveList(sda2, new PairArchiveList(sda3, new EmptyArchiveList())));
    IArchiveList hda = new PairArchiveList(hda1, new PairArchiveList(hda2, new PairArchiveList(hda3, new EmptyArchiveList())));
    
    // Als Platte
    IArchive overflow = new OverflowArchive("SDA", sda);
    
    // Ein paar schöne Items
    // Gesamtgröße: 6182
    Item mp3s = new Item("MP3s", 1800);
    Item bilder = new Item("Bilder", 62);
    Item videos = new Item("Videos", 4320);
    
    // Als Liste:
    wsiarchive.IItemList items1 = new wsiarchive.PairItemList(mp3s, new wsiarchive.PairItemList(bilder, new wsiarchive.EmptyItemList()));
    wsiarchive.IItemList items2 = new wsiarchive.PairItemList(mp3s, new wsiarchive.PairItemList(bilder, new wsiarchive.PairItemList(videos, new wsiarchive.EmptyItemList())));
    
    @Test
    public void overflow () {
        // Items hinzufügen, bei Videos sollte die Platte voll sein!
        IPutResult put;
        wsiarchive.IPutResultList puts;
        
        // Prüfen ob items auch hinzugefügt wurden
        IGetResult get;
        
        // Für die Videos sollten *alle* Platten zu klein sein:
        put = overflow.put(videos);
        checkExpect(put instanceof FullPutResult, true);
        
        // Der Rest sollte klappen
        put = overflow.put(mp3s);
        checkExpect(put instanceof OKPutResult, true);
        get = overflow.get(((OKPutResult) put).getId());
        checkExpect(get instanceof ItemResult, true);
        
        put = overflow.put(bilder);
        checkExpect(put instanceof OKPutResult, true);
        get = overflow.get(((OKPutResult) put).getId());
        checkExpect(get instanceof ItemResult, true);
        
        // Listen hinzufügen TODO!
        puts = overflow.putMultiple(items1);
        //checkExpect(puts instanceof OKPutResult, true);
    }
}
