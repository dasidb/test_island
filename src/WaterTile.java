import java.math.BigDecimal;

public class WaterTile extends Tile {

    public WaterTile(float positionX, float positionY){

        super(positionX,positionY);
        this.setImageLink("Ressources/waterTile.png");

    }
    public WaterTile(float positionX, float positionY,float CORDX, float CORDY){

        super(positionX,positionY,CORDX,CORDY);
        this.setImageLink("Ressources/waterTile.png");

    }

}
