package myarchive;

import wsiarchive.*;
import org.junit.*;

public class LimitedArchiveTest extends de.tuebingen.informatik.Test {

    IArchive sda1 = new LimitedArchive("SDA2", 5000);
    
    // Ein paar schöne Items
    Item mp3s = new Item("MP3s", 1800);
    Item bilder = new Item("Bilder", 62);
    Item videos = new Item("Videos", 4320);
    // Gesamtgröße: 6182
    
    @Test
    public void limited() {
        
        // Items hinzufügen, bei Videos sollte die Platte voll sein!
        IPutResult put;
        
        // Prüfen ob items auch hinzugefügt wurden
        IGetResult get;
        
        put = sda1.put(mp3s);
        checkExpect(put instanceof OKPutResult, true);
        get = sda1.get(((OKPutResult) put).getId());
        checkExpect(get instanceof ItemResult, true);
        
        put = sda1.put(bilder);
        checkExpect(put instanceof OKPutResult, true);
        get = sda1.get(((OKPutResult) put).getId());
        checkExpect(get instanceof ItemResult, true);
        
        put = sda1.put(videos);
        checkExpect(put instanceof FullPutResult, true);
    }
        

}
