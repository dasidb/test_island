import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

import java.util.ArrayList;

public class Game extends PApplet {
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
    private int canMove = 0;
    boolean canMoveUp;
    boolean canMoveDown;
    boolean canMoveLeft;
    boolean canMoveRight;
    Buildable buildable;
    ArrayList<Buildable> buildableArrayList = new ArrayList<>();
    PGraphics pg;



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
        heroImage();
        buildableImage();
        tileArrayList = new ArrayList<>();
        map = new Map(this, tileArrayList);
        tile = new Tile();
        charakter= new Charakter();
        tileTest = new GrassTile(20,20);
        buildable = new Buildable(map,charakter, buildableArrayList);

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
       if (keyPressed && canMove > 29) {
           //  map.createTiles(key);
           tileArrayList = map.createTiles2();
           canMove = 30;

       }
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
       image(HERO_IMAGE, width / 2, height / 2);

       // TODO: 24.07.2019 klappt nicht bild bleibt stehen 
       // if(!buildableArrayList.isEmpty()) {
            pg.beginDraw();
            buildable = new House(5,5);
            buildable.setImage(HOUSE_IMAGE);
      //  pg.background(0, 100);
            pg.image(HOUSE_IMAGE, charakter.getPosiX(), charakter.getPosiY());
            System.out.println("posiX: " + charakter.getPosiX()+ "\n" + "posiY :" + charakter.getPosiY());


            pg.endDraw();
            image(pg, 0, 0);
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
            image(buildable.getImage(),buildable.getCordX(),buildable.getCordY());
        }
    }
    public void updateCharakter() {
        charakter.setPosiX(tileArrayList.get(820).getCOORDINATEX());
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
    public void heroImage(){
        HERO_IMAGE = loadImage("ressources/held_survival.png");
    }
    public void buildableImage(){
    HOUSE_IMAGE =  loadImage("ressources/house.png");
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
            if(key == 'q'){
             //    buildable.create(1);
               //  setImageBuildable();
               //  System.out.println(buildableArrayList.size());
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
