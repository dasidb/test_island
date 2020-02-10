// an Item contains an unique id a name and a stacksize
public abstract class Item {

    public int itemID;
    public String name;
    public ItemType type;
    public String description;
    public int maximumStackSize;

    protected Item(int itemID, String name, ItemType type, int maximumStackSize){
        this.itemID = itemID;
        this.name = name;
        this.type = type;
        this.maximumStackSize = maximumStackSize;
    }

    protected Item(int itemID, String name){
        this.itemID = itemID;
        this.name = name;
        maximumStackSize = 1;
    }
}


