import processing.core.PImage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Buildable {

    private PImage image;
   private float cordX;
    private float cordY;
    private boolean isPlacable;
    private Map map;
    private Charakter charakter;
    private ArrayList<Buildable> buildableArrayList = new ArrayList<>();


    public Charakter getCharakter() {
        return charakter;
    }

    public void setCharakter(Charakter charakter) {
        this.charakter = charakter;
    }

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
        System.out.println(charakter + " im buildable construktor");

    }

    public Buildable(float cordX, float cordY){
        this.cordX = cordX;
        this.cordY = cordY;
    }
    public Buildable(float cordX, float cordY, PImage image){
        this.cordX = cordX;
        this.cordY = cordY;
        this.image = image;
    }

    public void create(int counter){
        if(counter == 1){
            System.out.println(charakter);
           System.out.println(buildableArrayList.size());
            System.out.println(charakter.getPosiX());
           System.out.println(charakter.getPosiY());

           // buildableArrayList.add(new House(charakter.getPosiX(),charakter.getPosiY() -40));
        }

    }

}
