package wsiarchive;



// Item bei geändertem Schlüssel
public class ItemIdResult extends ItemResult {

    private IItemId newId;
    
    public ItemIdResult(Item item, IItemId newId) {
        super(item);
        this.newId = newId;
    }
}
