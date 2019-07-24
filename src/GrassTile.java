import processing.core.PImage;

import java.math.BigDecimal;

public class GrassTile extends Tile {
    // private String imageLink = "Ressources/grassTile.png";

    public GrassTile(float positionX, float positionY) {

        super(positionX, positionY);
        this.setImageLink("Ressources/grassTile.png");


    }
    public GrassTile(float positionX, float positionY,float CORDX, float CORDY) {

        super(positionX, positionY,CORDX,CORDY);
        this.setImageLink("Ressources/grassTile.png");


    }

}
