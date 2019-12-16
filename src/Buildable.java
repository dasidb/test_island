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
    private PImage HOUSE_IMAGE;
    private int absoluteX;
    private int absoluteY;

    public int getAbsoluteX() {
        return absoluteX;
    }

    public void setAbsoluteX(int absoluteX) {
        this.absoluteX = absoluteX;
    }

    public int getAbsoluteY() {
        return absoluteY;
    }

    public void setAbsoluteY(int absoluteY) {
        this.absoluteY = absoluteY;
    }

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
    public Buildable(Map map, Charakter charakter, ArrayList<Buildable> buildableArrayList, PImage HOUSE_IMAGE, int absoluteX, int absoluteY){
        this.map = map;
        this.charakter = charakter;
        this.buildableArrayList = buildableArrayList;
        System.out.println(charakter + " im buildable construktor");
        this.HOUSE_IMAGE = HOUSE_IMAGE;
        this.absoluteX = absoluteX;
        this.absoluteY = absoluteY;

    }

    public Buildable(float cordX, float cordY){
        this.cordX = cordX;
        this.cordY = cordY;
    }
    public Buildable(float cordX, float cordY, PImage image , int absoluteX, int absoluteY){
        this.cordX = cordX;
        this.cordY = cordY;
        this.image = image;
        this.absoluteX = absoluteX;
        this.absoluteY = absoluteY;
    }



}
