public class PlayerItem {
    private Item item;
    private int count;

    public PlayerItem(Item item, int count){
        this.item = item;
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public boolean setCount(int count) {
        if(count >= 0) {
            this.count = count;
            return true;
        }
        else {
            System.out.println("Error count is negativ");
            return false;
        }
    }
}
