import java.math.BigDecimal;

public class WaterTile extends Tile {

    public WaterTile(float positionX, float positionY){

        super(positionX,positionY);
        this.setImageLink("Ressources/waterTile.png");

    }
    public WaterTile(float positionX, float positionY,float CORDX, float CORDY, int absoluteX, int absoluteY){

        super(positionX,positionY,CORDX,CORDY,absoluteX ,absoluteY );
        this.setImageLink("Ressources/waterTile.png");

    }

}
