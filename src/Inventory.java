// https://scottlilly.com/how-to-build-stackable-inventory-for-a-game-in-c/
// https://scottlilly.com/build-a-cwpf-rpg/lesson-06-1-creating-the-quest-factory/

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

//https://www.gamedev.net/forums/topic/654197-small-inventory-system-java-novice/
//https://www.gamedev.net/articles/programming/general-and-gameplay-programming/item-management-systems-r2163/
public class Inventory {
    private int inventorySlots = 10;
    private List<PlayerItem> playerItemList;;

    public int getInventorySlots() {
        return inventorySlots;
    }

    public void setInventorySlots(int inventorySlots) {
        this.inventorySlots = inventorySlots;
    }

    public List<PlayerItem> getPlayerItemList() {
        return playerItemList;
    }

    public void setPlayerItemList(List<PlayerItem> playerItemList) {
        this.playerItemList = playerItemList;
    }

    // adds an item to the Player inventory
    public void addItem(Item item, int amount){
        if(playerItemList == null){
            playerItemList = new ArrayList<>();
        }
        if(playerItemList.contains(item.name)){
            int index = playerItemList.indexOf(item.name);
            playerItemList.get(index).setCount(playerItemList.get(index).getCount() + amount);


        }else{
            playerItemList.add(new PlayerItem(item,amount));

        }
    }

    // Removes an item from the Players inventory
    // Returns false if the item cound is lower than the amount to remove
    public boolean removeItem(Item item, int amount){
        if(playerItemList == null){
            playerItemList = new ArrayList<>();
        }
        if(playerItemList.contains(item.name)){
            int index = playerItemList.indexOf(item.name);
            if(playerItemList.get(index).setCount(playerItemList.get(index).getCount() - amount))
            return true;
            else
                return false;

        }else
            return false;
    }
}
