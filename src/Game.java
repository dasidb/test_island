import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

import java.util.ArrayList;

public class Game extends PApplet {
    int zähler = 50;
    private Map map;
    private Tile tile;
    private Tile tileTest;
    private ArrayList<Tile> tileArrayList;
    private Charakter charakter;
    private boolean continueMap = true;
    private ArrayList<Tile> tileRemoveArrayList = new ArrayList<>();
    float[][] testfloat;
    private PImage WATER_TILE;
    private PImage GRAS_TILE;
    private PImage SAND_TILE;
    private PImage HERO_IMAGE;
    private PImage HOUSE_IMAGE;
    private PImage GRASS_TREE_TILE;
    private int canMove = 0;
    boolean canMoveUp;
    boolean canMoveDown;
    boolean canMoveLeft;
    boolean canMoveRight;
    boolean drawNew = true;
    Buildable buildable;
    ArrayList<Buildable> buildableArrayList = new ArrayList<>();
    PGraphics pg;
    private float absoluteCordsX = 400;
    private float absoluteCordsY = 400;
    private int buildCounter = 0 ;
    private int gameSizeX = 800;
    private int gameSizeY = 800;
    // TODO: 08.08.2019 absoulute cords einbauen diese ummünzen fü
    //  r die up down bewegung das anpassen an die buildables




    public static void main(String[] args){
        PApplet.main(Game.class, args);
    }
    @Override
    public void settings(){
        super.settings();

        size(gameSizeX, gameSizeY);

    }
    @Override
    public void setup(){
        super.setup();
        tilesImage();
        heroImage();
        buildableImage();
        tileArrayList = new ArrayList<>();

        tile = new Tile();
        System.out.println(charakter+ "vor erstellung");
        charakter= new Charakter(400,400);


        System.out.println(charakter);
        map = new Map(this, tileArrayList, charakter, buildableArrayList, drawNew);
        HOUSE_IMAGE = loadImage("ressources/house.png");
        tileTest = new GrassTile(20,20);



        pg = createGraphics(800,800);



        if(continueMap) {

        }
         testfloat = map.getTestFloat();



        frameRate(30);
        background(0);
        loop();
    }
   @Override
    public void draw() {


       if (canMove > 29) {
           moveTile();
       }
       // TODO: 12/12/2019 die sachen müssen einen neuen aufruf bei bewegungen etc haben (draw)
       if(drawNew) {
           System.out.println("test");

           tileArrayList = map.createTiles2();
           for (Tile tile : tileArrayList) {


               PImage useImage = GRAS_TILE;
               if (tile instanceof SandTile) {
                   useImage = SAND_TILE;
               } else if (tile instanceof WaterTile) {
                   useImage = WATER_TILE;
               } else if (tile instanceof GrassTreeTile){
                   useImage = GRASS_TREE_TILE;
               }



               image(useImage, tile.getPositionX(), tile.getPositionY());

               if (tile.getPositionY() > 800) {
                   tileRemoveArrayList.add(tile);

               }



           }
           displayBuildable();
           drawNew = false;
       }



    /*   for (Tile tile : tileArrayList) {


           PImage useImage = GRAS_TILE;
           if (tile instanceof SandTile) {
               useImage = SAND_TILE;
           } else if (tile instanceof WaterTile) {
               useImage = WATER_TILE;
           } else if (tile instanceof GrassTreeTile){
               useImage = GRASS_TREE_TILE;
           }



           image(useImage, tile.getPositionX(), tile.getPositionY());

           if (tile.getPositionY() > 800) {
               tileRemoveArrayList.add(tile);

           }



       } */
       image(HERO_IMAGE, charakter.getPosiX(), charakter.getPosiY());

       // TODO: 24.07.2019 klappt nicht bild bleibt stehen
       // TODO: 01.08.2019 buildable wird überschrieben muss in arraylist üverführt werden ZONK 







// TODO: 19.07.2019 er liegt immer auf tile 820 also die cords übernehmen und prüfen ob auf welchem er liegt
       // TODO: 19.07.2019 also ob es instance of x,y,z ist  
       removeTile();
       if (canMove < 30) {
           canMove += 1;
       }
        //if(!tileArrayList.isEmpty()){
       if(charakter.charakterMove()){
            updateCharakter();

        }

      //  if(!buildableArrayList.isEmpty()) {
      //     displayBuildable();
      //  }

        if(!tileArrayList.isEmpty()) {

            drawNew = map.autoscroll();
        }

        charakter.setCanMove(charakter.getCanMove() + 10);
        collisionCheckTile();


   }



    public void displayBuildable(){
        for(Buildable buildable : buildableArrayList){
            if(buildable.getCordX() > charakter.getPosiX() - gameSizeX && buildable.getCordX() < charakter.getPosiX() + gameSizeX && buildable.getCordY()> charakter.getPosiY() - gameSizeY && buildable.getCordY() < charakter.getPosiY() + gameSizeY) {
                //image(buildable.getImage(), buildable.getCordX(), buildable.getCordY());
                image(buildable.getImage(), buildable.getCordX(), buildable.getCordY());
                //



            }
        }
    }
    public void updateCharakter() {

        Tile groundTile = tileArrayList.get(820);
        if (groundTile instanceof GrassTile) {
            charakter.setGrass(true);
        } else {
            charakter.setGrass(false);
        }
        if (groundTile instanceof SandTile) {
            charakter.setSand(true);
        } else {
            charakter.setSand(false);
        }

        if (groundTile instanceof WaterTile) {
            charakter.setWater(true);
        } else {
            charakter.setWater(false);
        }

    }
    public void moveTile(){

        if(canMoveUp) {

            print("bdwadwiadjiwadjiawiojdjiowajdjwajoid");

                map.setCordY(map.getCordY() -0.025F);
            for (Buildable buildable : buildableArrayList){
                buildable.setCordY(buildable.getCordY() +20);

            }

            }


        if(canMoveDown) {

                map.setCordY(map.getCordY() +0.025F);
                for (Buildable buildable : buildableArrayList){
                    buildable.setCordY(buildable.getCordY() -20);
                }



        } if(canMoveLeft) {
        map.setCordX(map.getCordX() -0.025F);
            for (Buildable buildable : buildableArrayList){
                buildable.setCordX(buildable.getCordX() +20);
            }


        } if(canMoveRight) {
            map.setCordX(map.getCordX() +0.025F);


            for (Buildable buildable : buildableArrayList){
                buildable.setCordX(buildable.getCordX() -20);
            }


        }
    }



    public void removeTile(){


        for(Tile tile : tileRemoveArrayList){
            tileArrayList.remove(tile);

        }


        tileRemoveArrayList= new ArrayList<>();
    }

    public void tilesImage(){
        WATER_TILE = loadImage("Ressources/waterTile.png");
        GRAS_TILE = loadImage("Ressources/grassTile.png");
        SAND_TILE = loadImage("Ressources/sandTile.png");
        GRASS_TREE_TILE = loadImage("Ressources/grassTreeTile.png");

    }
    public void heroImage(){
        HERO_IMAGE = loadImage("ressources/held_survival.png");
    }
    public void buildableImage(){

    }
    public void keyPressed(){
        if(keyPressed){
            if(key == 'w') {
            charakter.setMoveUp(true);

            }
            if(key == 's') {
                charakter.setMoveDown(true);

            }
            if(key == 'a'){
                charakter.setMoveLeft(true);

            }
            if(key == 'd'){
                charakter.setMoveRigt(true);

                canMove = 0;
            }
            if(key == 'e'){
                buildCounter --;
            }
            if(key == 'r'){
                buildCounter ++;
            }

            if(key == 'q') {



                buildableArrayList.add(new House(HOUSE_IMAGE, charakter.getPosiX()-40  , charakter.getPosiY() - 80, charakter.getAbsoluteX(), charakter.getAbsoluteY()));


                for (Buildable buildable : buildableArrayList) {
                    pg.beginDraw();


                    pg.endDraw();
                    zähler += 5;
                }


            }
            if(key == 't'){

            }

        }

    }
    public void keyReleased(){
        if(key == 'w'){

            charakter.setMoveUp(false);
        }
        if(key == 's') {

            charakter.setMoveDown(false);
        }
        if(key == 'a'){
            charakter.setMoveLeft(false);

        }
        if(key == 'd'){
            charakter.setMoveRigt(false);

        }

    }
    public void collisionCheckTile(){
        int relativX = (int) charakter.getPosiX();
        int relativY = (int) charakter.getPosiY();

        // TODO: 30.08.2019 ergibt die rechnung sinn? ich will die in 1er schritten fortführen und so die nebenliegenden "instance of" tracken z.B. nicht durch bäume laufen

        line((charakter.getPosiX()/20),(charakter.getPosiY()/20)*40, (charakter.getPosiX()/20)*40 +20,(charakter.getPosiY()/20)*40)  ;


    }
}
