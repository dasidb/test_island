import java.math.BigDecimal;

public class SandTile extends Tile {

    public SandTile(float positionX, float positionY){

        super(positionX,positionY);
        this.setImageLink("Ressources/sandTile.png");

    }
    public SandTile(float positionX, float positionY,float CORDX, float CORDY){

        super(positionX,positionY,CORDX,CORDY);
        this.setImageLink("Ressources/sandTile.png");

    }

}
