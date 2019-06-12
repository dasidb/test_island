import processing.core.PApplet;
import processing.core.PImage;

import java.util.Random;

public class Tile {
    private PApplet pApplet;
    private PImage pImage;
    private float positionX;
    private float positionY;
    private String imageLink;

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public PImage getpImage() {
        return pImage;
    }


    public void setpImage(PImage pImage) {
        this.pImage = pImage;
    }

    public float getPositionX() {
        return positionX;
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    public Tile(){

    }

    public Tile(float positionX, float positionY){
        this.positionX = positionX;
        this.positionY = positionY;
        this.pImage = new PImage();
    }

    public Tile(PApplet pApplet, PImage pImage, float positionX, float positionY){
        this.pApplet = pApplet;
        this.pImage = pImage;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void createTile(){


    }
    public void tileMove(){
        this.positionY -= 20;
    }
}
