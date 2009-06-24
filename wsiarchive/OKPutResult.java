package wsiarchive;



// Resultat einer erfolgreichen Put-Operation
public class OKPutResult implements IPutResult {

    private IItemId id;
    public OKPutResult(IItemId id) {
        this.id = id;
    }
    
    // ItemId extrahieren
    public IItemId getId() {
        return this.id;
    }

}
