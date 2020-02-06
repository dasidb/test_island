public class GrassTreeTile extends GrassTile {
    public GrassTreeTile(float positionX, float positionY,float CORDX, float CORDY, int absoluteX, int absoluteY){

        super(positionX,positionY,CORDX,CORDY,absoluteX ,absoluteY );
        this.setImageLink("Ressources/grassTreeTile.png");

    }

    public GrassTreeTile(float positionX, float positionY, float absoluteX, float absoluteY){

        super(positionX,positionY, absoluteX,absoluteY);
        this.setImageLink("Ressources/grassTreeTile.png");

    }

    public void chopTree(){
        //setpImage();
    }
}
