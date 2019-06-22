import processing.core.PImage;

public class Charakter {
    private PImage charakterImage;
    private float posiX;
    private float posiY;
    private String name;
    private int health;
    private float velocity;

    public PImage getCharakterImage() {
        return charakterImage;
    }

    public void setCharakterImage(PImage charakterImage) {
        this.charakterImage = charakterImage;
    }

    public float getPosiX() {
        return posiX;
    }

    public void setPosiX(float posiX) {
        this.posiX = posiX;
    }

    public float getPosiY() {
        return posiY;
    }

    public void setPosiY(float posiY) {
        this.posiY = posiY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public void movement(char key){
        if(key == 'w'){
        this.setPosiY( this.getPosiY() - 20);
        }
        if(key == 's'){

        }
        if(key == 'a'){

        }if(key == 'd'){

        }


    }
}
