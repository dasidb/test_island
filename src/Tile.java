import processing.core.PApplet;
import processing.core.PImage;

public class Tile {
    private PApplet pApplet;
    private PImage pImage;
    private float positionX;
    private float positionY;

    public Tile(){

    }

    public Tile(PApplet pApplet, PImage pImage, float positionX, float positionY){
        this.pApplet = pApplet;
        this.pImage = pImage;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void createTile(){


    }
}
