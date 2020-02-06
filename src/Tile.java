import processing.core.PApplet;
import processing.core.PImage;

import java.math.BigDecimal;
import java.util.Random;

public class Tile {
    private PApplet pApplet;
    private PImage pImage;
    private float positionX;
    private float positionY;
    private String imageLink;
    private  float COORDINATEX;
    private  float COORDINATEY;
    private float NOWREALLYABSOLUTEX;
    private float NOWREALLYABSOLUTEY;

    public float getNOWREALLYABSOLUTEX() {
        return NOWREALLYABSOLUTEX;
    }

    public void setNOWREALLYABSOLUTEX(int NOWREALLYABSOLUTEX) {
        this.NOWREALLYABSOLUTEX = NOWREALLYABSOLUTEX;
    }

    public float getNOWREALLYABSOLUTEY() {
        return NOWREALLYABSOLUTEY;
    }

    public void setNOWREALLYABSOLUTEY(int NOWREALLYABSOLUTEY) {
        this.NOWREALLYABSOLUTEY = NOWREALLYABSOLUTEY;
    }

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
    public Tile(float positionX, float positionY, float COORDINATEX, float COORDINATEY, int NOWREALLYABSOLUTEX, int NOWREALLYABSOLUTEY){
        this.positionX = positionX;
        this.positionY = positionY;
        this.pImage = new PImage();
        this.COORDINATEX = COORDINATEX;
        this.COORDINATEY = COORDINATEY;
        this.NOWREALLYABSOLUTEX = NOWREALLYABSOLUTEX;
        this.NOWREALLYABSOLUTEY = NOWREALLYABSOLUTEY;
    }

    public Tile(float positionX, float positionY, float NOWREALLYABSOLUTEX, float NOWREALLYABSOLUTEY){
        this.positionX = positionX;
        this.positionY = positionY;
        this.NOWREALLYABSOLUTEX = NOWREALLYABSOLUTEX;
        this.NOWREALLYABSOLUTEY = NOWREALLYABSOLUTEY;
    }


    public Tile(PApplet pApplet, PImage pImage, float positionX, float positionY){
        this.pApplet = pApplet;
        this.pImage = pImage;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void createTile(){


    }

   public float getCOORDINATEX() {
        return COORDINATEX;
    }

    public void setCOORDINATEX(float COORDINATEX) {
        this.COORDINATEX = COORDINATEX;
    }

    public float getCOORDINATEY() {
        return COORDINATEY;
    }

    public void setCOORDINATEY(float COORDINATEY) {
        this.COORDINATEY = COORDINATEY;
    }



    public void tileMoveUP(){
        this.positionY += 20;


    }
    public void tileMovedown(){
        this.positionY -= 20;
    }
    public void tileMoveleft(){
        this.positionX += 20;
    }
    public void tileMoveright(){
        this.positionX -= 20;
    }
}
