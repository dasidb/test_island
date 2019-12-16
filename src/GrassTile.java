import processing.core.PImage;

import java.math.BigDecimal;

public class GrassTile extends Tile {


    public GrassTile(float positionX, float positionY) {

        super(positionX, positionY);
        this.setImageLink("Ressources/grassTile.png");


    }
    public GrassTile(){

    }
    public GrassTile(float positionX, float positionY,float CORDX, float CORDY, int absoluteX, int absoluteY){

        super(positionX,positionY,CORDX,CORDY,absoluteX ,absoluteY );
        this.setImageLink("Ressources/grassTile.png");


    }

}
