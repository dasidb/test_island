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
        charakter= new Charakter();

        charakter.setPosiY(400);
        charakter.setPosiX(400);
        System.out.println(charakter);
        map = new Map(this, tileArrayList, charakter, buildableArrayList);
        HOUSE_IMAGE = loadImage("ressources/house.png");
        tileTest = new GrassTile(20,20);
        buildable = new Buildable(map,charakter, buildableArrayList,HOUSE_IMAGE);


        pg = createGraphics(800,800);


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
    public void draw() {
       // clear();

       if (canMove > 29) {
           moveTile();
       }
     //  if (keyPressed){ //&& canMove > 29) {
           //  map.createTiles(key);
           tileArrayList = map.createTiles2();
           //canMove = 30;

     //  }
     /*  for(int y = 0 ; y < 40; y++){
           for( int x = 0; x < 800 ; x++){

               line(testfloat[y][x],testfloat[y][x],testfloat[y][x],testfloat[y][x]);
               stroke(214);
               System.out.println(testfloat[39][0] + " start ");
               System.out.println(testfloat[39][799] + " ende ");
           }
       } */


       for (Tile tile : tileArrayList) {
           // tile.tileMove();

           PImage useImage = GRAS_TILE;
           if (tile instanceof SandTile) {
               useImage = SAND_TILE;
           } else if (tile instanceof WaterTile) {
               useImage = WATER_TILE;
           } else if (tile instanceof GrassTreeTile){
               useImage = GRASS_TREE_TILE;
           }

           //  System.out.println(tileArrayList.get(2).getCOORDINATEX());
           //  if(tile.getCOORDINATEX() >= map.getCordX() && tile.getCOORDINATEX() < map.getCordX() + 5 && tile.getCOORDINATEY() > map.getCordY() && tile.getCOORDINATEY() < map.getCordY() + 0.1F) {


           image(useImage, tile.getPositionX(), tile.getPositionY());
           //if(tile == tileArrayList.get(820)){
           //    image(HERO_IMAGE,tile.getPositionX(),tile.getPositionY());
           // }

           // }
           if (tile.getPositionY() > 800) {
               // System.out.println(tile.getPositionY() +"posi Y");
               tileRemoveArrayList.add(tile);
               // System.out.println(tileRemoveArrayList.size());

           }

           //System.out.println("display methode durchlaufen");
       }
       image(HERO_IMAGE, charakter.getPosiX(), charakter.getPosiY());

       // TODO: 24.07.2019 klappt nicht bild bleibt stehen
       // TODO: 01.08.2019 buildable wird überschrieben muss in arraylist üverführt werden ZONK 
       // if(!buildableArrayList.isEmpty()) {
           // pg.beginDraw();

       for(Buildable buildable : buildableArrayList){

     //      pg.clear();
       //    pg.image(buildable.getImage(),buildable.getCordX() + zähler ,buildable.getCordY() + zähler);
       //    pg.endDraw();
           if(buildable.getCordX() >0 && buildable.getCordX() < 600) {
              // image(pg, buildable.getCordX(), buildable.getCordY());
               // TODO: 09.08.2019 test image pg weg
           }

       }


           // pg.endDraw();



          //  buildableArrayList.add(new House(HOUSE_IMAGE,300,5));




           // buildable = new House(5,5);
           // buildable.setImage(HOUSE_IMAGE);
      //  pg.background(0, 100);
           // pg.image(HOUSE_IMAGE, charakter.getPosiX(), charakter.getPosiY());
           // System.out.println("posiX: " + charakter.getPosiX()+ "\n" + "posiY :" + charakter.getPosiY());


          //  pg.endDraw();
           // buildableArrayList.get(0).setCordY(200);
          //  image(pg, , 0);
       // }


// TODO: 19.07.2019 er liegt immer auf tile 820 also die cords übernehmen und prüfen ob auf welchem er liegt
       // TODO: 19.07.2019 also ob es instance of x,y,z ist  
       removeTile();
       if (canMove < 30) {
           canMove += 1;
       }
        if(!tileArrayList.isEmpty()){
            updateCharakter();

        }
        if(!buildableArrayList.isEmpty()) {
            displayBuildable();
        }
        charakter.charakterMove();
        if(!tileArrayList.isEmpty()) {

            map.autoscroll();
        }

        charakter.setCanMove(charakter.getCanMove() + 10);
        collisionCheckTile();


   }
    public void displayTile(){
        for(Tile tile : tileArrayList){
            if(tile.getCOORDINATEX() > map.getCordX() && tile.getCOORDINATEX() < map.getCordX() + 30){
                image(tile.getpImage(),tile.getPositionX(),tile.getPositionY());
            }

        }
    }

    public void setImageBuildable(){
        for(Buildable buildable : buildableArrayList){
            if(buildable instanceof House){
                buildable.setImage(HOUSE_IMAGE);

            }
        }
    }


    public void displayBuildable(){
        for(Buildable buildable : buildableArrayList){
            if(buildable.getCordX() > charakter.getPosiX() - gameSizeX && buildable.getCordX() < charakter.getPosiX() + gameSizeX && buildable.getCordY()> charakter.getPosiY() - gameSizeY && buildable.getCordY() < charakter.getPosiY() + gameSizeY) {
                image(buildable.getImage(), buildable.getCordX(), buildable.getCordY());

            }
        }
    }
    public void updateCharakter() {
       // charakter.setPosiX(tileArrayList.get(820).getCOORDINATEX());
        //charakter.setPosiY(tileArrayList.get(820).getCOORDINATEY());
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
    //    System.out.println("Grass: " +charakter.isGrass());
  //      System.out.println("Sand: " + charakter.isSand());
      //  System.out.println("Water: " +charakter.isWater());
    }
    public void moveTile(){

        if(canMoveUp) {
            print("bdwadwiadjiwadjiawiojdjiowajdjwajoid");
                //tile.tileMoveUP();
                map.setCordY(map.getCordY() -0.025F);
            for (Buildable buildable : buildableArrayList){
                buildable.setCordY(buildable.getCordY() +20);

            }
               // absoluteCordsY -= 20;
            }


        if(canMoveDown) {

                map.setCordY(map.getCordY() +0.025F);
                for (Buildable buildable : buildableArrayList){
                    buildable.setCordY(buildable.getCordY() -20);
                }
           // absoluteCordsY += 20;


        } if(canMoveLeft) {
        map.setCordX(map.getCordX() -0.025F);
            for (Buildable buildable : buildableArrayList){
                buildable.setCordX(buildable.getCordX() +20);
            }
           // absoluteCordsX += 20;

        } if(canMoveRight) {
          //  map.setCordX(map.getCordX() +0.025F);
            map.setCordX(map.getCordX() +0.1F);

            for (Buildable buildable : buildableArrayList){
                buildable.setCordX(buildable.getCordX() -20);
            }
           // absoluteCordsX -= 20;

        }
    }

    public void moveRight(){

            //  map.setCordX(map.getCordX() +0.025F);
            map.setCordX(map.getCordX() +0.1F);


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
        GRASS_TREE_TILE = loadImage("Ressources/grassTreeTile.png");

    }
    public void heroImage(){
        HERO_IMAGE = loadImage("ressources/held_survival.png");
    }
    public void buildableImage(){
   // HOUSE_IMAGE =  loadImage("ressources/house.png");
    }
    public void keyPressed(){
        if(keyPressed){
            if(key == 'w') {
            charakter.setMoveUp(true);
            /*    charakter.setMoveUp(false);
                System.out.println(charakter.isMoveUp() + "outside");
                System.out.println(canMove);
                if(canMove >700){
                    charakter.setMoveUp(true);

                    System.out.println(charakter.isMoveUp() + "inside");
                    canMove = 1;
                } */

             //   canMoveUp = true;
              //  charakter.movement(key);
            //    charakter.setPosiY( charakter.getPosiY() - 20);
            }
            if(key == 's') {
                charakter.setMoveDown(true);
             //  canMoveDown = true;
            //    charakter.setPosiY( charakter.getPosiY() + 20);

            }
            if(key == 'a'){
                charakter.setMoveLeft(true);
               // canMoveLeft = true;
            //    charakter.setPosiX( charakter.getPosiX() - 20);
            }
            if(key == 'd'){
                charakter.setMoveRigt(true);
              // canMoveRight = true;
              //  if(charakter.getPosiX() < 600 && canMove > 40) {
                //    charakter.setPosiX(charakter.getPosiX() + 20);

               // }
           //     else if(canMove > 40){
                   // canMoveRight = true;

               //     System.out.println("dwdwa");
               //     charakter.setPosiX(charakter.getPosiX() - 60);
                //     moveRight();

              //  }
                canMove = 0;
            }
            if(key == 'e'){
                buildCounter --;
            }
            if(key == 'r'){
                buildCounter ++;
            }

            if(key == 'q') {

                buildable.create(buildCounter);
                setImageBuildable();

                buildableArrayList.add(new House(HOUSE_IMAGE, charakter.getPosiX()-40  , charakter.getPosiY() - 80));


                for (Buildable buildable : buildableArrayList) {
                    pg.beginDraw();
                   // pg.image(buildable.getImage(),map.getCordX(), map.getCordY());

                    pg.endDraw();
                    zähler += 5;
                }

            }

        }

    }
    public void keyReleased(){
        if(key == 'w'){
            //canMoveUp = false;
            charakter.setMoveUp(false);
        }
        if(key == 's') {
           // canMoveDown = false;
            charakter.setMoveDown(false);
        }
        if(key == 'a'){
            charakter.setMoveLeft(false);
            //canMoveLeft = false;
        }
        if(key == 'd'){
            charakter.setMoveRigt(false);
            //canMoveRight = false;
        }

    }
    public void collisionCheckTile(){
        int relativX = (int) charakter.getPosiX();
        int relativY = (int) charakter.getPosiY();
       // System.out.println( (relativX * relativY ));
        // TODO: 30.08.2019 ergibt die rechnung sinn? ich will die in 1er schritten fortführen und so die nebenliegenden "instance of" tracken z.B. nicht durch bäume laufen
        System.out.println((charakter.getPosiX()/20) + ((charakter.getPosiY()/20)*40) );
      //  System.out.println((charakter.getPosiX()/20) + ((charakter.getPosiY()/2)*40) );
     //   tileArrayList.get((relativX * relativY) + 1).setpImage(HERO_IMAGE);
        line((charakter.getPosiX()/20),(charakter.getPosiY()/20)*40, (charakter.getPosiX()/20)*40 +20,(charakter.getPosiY()/20)*40)  ;
     //   if(tileArrayList.get( (int) (charakter.getPosiX()/20F) + (int) ((charakter.getPosiY()/20F)*40F) ) instanceof WaterTile){
     //      System.out.println("yatta");
     //   }

    }
}
