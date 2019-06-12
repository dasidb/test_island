import processing.core.PApplet;

import java.util.ArrayList;

public class Game extends PApplet {
    private Map map;
    private Tile tile;
    private Tile tileTest;
    private ArrayList<Tile> tileArrayList;
    private boolean continueMap = true;
    private ArrayList<Tile> tileRemoveArrayList = new ArrayList<>();
    float[][] testfloat;

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
       map.createTiles();
     /*  for(int y = 0 ; y < 40; y++){
           for( int x = 0; x < 800 ; x++){

               line(testfloat[y][x],testfloat[y][x],testfloat[y][x],testfloat[y][x]);
               stroke(214);
               System.out.println(testfloat[39][0] + " start ");
               System.out.println(testfloat[39][799] + " ende ");
           }
       } */
       tilesImage();
       for(Tile tile : tileArrayList){
           tile.tileMove();
           image(tile.getpImage(),tile.getPositionX(),tile.getPositionY());
           if(tile.getPositionY() <0){
               // System.out.println(tile.getPositionY() +"posi Y");
               tileRemoveArrayList.add(tile);
              // System.out.println(tileRemoveArrayList.size());

           }


       }
       removeTile();


    }
    public void removeTile(){
        System.out.println(tileArrayList.size() + " davor");

        for(Tile tile : tileRemoveArrayList){
            tileArrayList.remove(tile);

        }
        System.out.println(tileArrayList.size() + " danach");

        tileRemoveArrayList= new ArrayList<>();
    }

    public void tilesImage(){
        for(Tile tile : tileArrayList){
            tile.setpImage(loadImage(tile.getImageLink()));

        }

    }
    public void keyPressed(){
        if(keyPressed){
            if(key == 'w'){
                continueMap = true;
            }
            if(key == 's'){
                continueMap = false;
            }
        }

    }
}
