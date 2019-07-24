import processing.core.PImage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Buildable {

    PImage image;
    float cordX;
    float cordY;
    boolean isPlacable;
    Map map;
    Charakter charakter;
    ArrayList<Buildable> buildableArrayList;
    public PImage getImage() {
        return image;
    }

    public void setImage(PImage image) {
        this.image = image;
    }

    public float getCordX() {
        return cordX;
    }

    public void setCordX(float cordX) {
        this.cordX = cordX;
    }

    public float getCordY() {
        return cordY;
    }

    public void setCordY(float cordY) {
        this.cordY = cordY;
    }

    public boolean isPlacable() {
        return isPlacable;
    }

    public void setPlacable(boolean placable) {
        isPlacable = placable;
    }

    public Buildable(){

    }
    public Buildable(Map map, Charakter charakter, ArrayList<Buildable> buildableArrayList){
        this.map = map;
        this.charakter = charakter;
        this.buildableArrayList = buildableArrayList;
    }

    public void create(int counter){
        if(counter == 1){
            buildableArrayList.add(new House(charakter.getPosiX(),charakter.getPosiY() -40));
        }

    }

}
