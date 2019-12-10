import java.math.BigDecimal;

public class SandTile extends Tile {

    public SandTile(float positionX, float positionY){

        super(positionX,positionY);
        this.setImageLink("Ressources/sandTile.png");

    }
    public SandTile(float positionX, float positionY,float CORDX, float CORDY, int absoluteX, int absoluteY){

        super(positionX,positionY,CORDX,CORDY,absoluteX ,absoluteY );
        this.setImageLink("Ressources/sandTile.png");

    }

}
