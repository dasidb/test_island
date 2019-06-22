import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Game extends PApplet {
    private Map map;
    private Tile tile;
    private Tile tileTest;
    private ArrayList<Tile> tileArrayList;
    private boolean continueMap = true;
    private ArrayList<Tile> tileRemoveArrayList = new ArrayList<>();
    float[][] testfloat;
    private PImage WATER_TILE;
    private PImage GRAS_TILE;
    private PImage SAND_TILE;
    private int canMove = 0;
    boolean canMoveUp;
    boolean canMoveDown;
    boolean canMoveLeft;
    boolean canMoveRight;


    public static void main(String[] args){
        PApplet.main(Game.class, args);
    }
    @Override
    public void settings(){
        super.settings();

        size(800, 800);

    }
    @Override
    public void setup(){
        super.setup();
        tilesImage();

        tileArrayList = new ArrayList<>();
        map = new Map(this, tileArrayList);
        tile = new Tile();
         tileTest = new GrassTile(20,20);
       // tileArrayList.add(tileTest);
     //   map.createTiles();
        if(continueMap) {
          //  map.createTiles();
        }
         testfloat = map.getTestFloat();



        frameRate(30);
        background(0);
        loop();
    }
   @Override
    public void draw(){
       // clear();

           if(canMove > 29){
           moveTile();
           }
       if(keyPressed && canMove >29){
           //  map.createTiles(key);
           tileArrayList = map.createTiles2();
           canMove = 30;
        System.out.println("create durchlaufen");
       }
     /*  for(int y = 0 ; y < 40; y++){
           for( int x = 0; x < 800 ; x++){

               line(testfloat[y][x],testfloat[y][x],testfloat[y][x],testfloat[y][x]);
               stroke(214);
               System.out.println(testfloat[39][0] + " start ");
               System.out.println(testfloat[39][799] + " ende ");
           }
       } */


       for(Tile tile : tileArrayList){
          // tile.tileMove();
           PImage useImage = GRAS_TILE;
           if (tile instanceof SandTile) {
               useImage = SAND_TILE;
           } else if (tile instanceof WaterTile) {
               useImage = WATER_TILE;
           }
           image(useImage,tile.getPositionX(),tile.getPositionY());
           if(tile.getPositionY() >800){
               // System.out.println(tile.getPositionY() +"posi Y");
               tileRemoveArrayList.add(tile);
              // System.out.println(tileRemoveArrayList.size());

           }

        //System.out.println("display methode durchlaufen");
       }
       removeTile();
       if(canMove <30) {
           canMove += 1;
       }
    }

    public void moveTile(){
        if(canMoveUp) {

                //tile.tileMoveUP();
                map.setCordY(map.getCordY() -0.025F);
            }


        if(canMoveDown) {

                map.setCordY(map.getCordY() +0.025F);


        } if(canMoveLeft) {
        map.setCordX(map.getCordX() -0.025F);
        } if(canMoveRight) {
            map.setCordX(map.getCordX() +0.025F);

        }
    }
    public void removeTile(){
     //   System.out.println(tileArrayList.size() + " davor");

        for(Tile tile : tileRemoveArrayList){
            tileArrayList.remove(tile);

        }
     //   System.out.println(tileArrayList.size() + " danach");

        tileRemoveArrayList= new ArrayList<>();
    }

    public void tilesImage(){
        WATER_TILE = loadImage("Ressources/waterTile.png");
        GRAS_TILE = loadImage("Ressources/grassTile.png");
        SAND_TILE = loadImage("Ressources/sandTile.png");

    }
    public void keyPressed(){
        if(keyPressed && canMove >29){
            if(key == 'w') {
                canMoveUp = true;
         /*       for (Tile tile : tileArrayList) {
                    //tileArrayList.remove(tile);
                    tile.tileMoveUP();

                } */
               // System.out.println("move durchlaufen");
            }
            if(key == 's') {
               canMoveDown = true;
            }
            if(key == 'a'){
                canMoveLeft = true;
            }
            if(key == 'd'){
               canMoveRight = true;
            }
        }

    }
    public void keyReleased(){
        if(key == 'w'){
            canMoveUp = false;
        }
        if(key == 's') {
            canMoveDown = false;
        }
        if(key == 'a'){
            canMoveLeft = false;
        }
        if(key == 'd'){
            canMoveRight = false;
        }
    }
}
