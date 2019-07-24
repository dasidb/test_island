import processing.core.PApplet;

import java.math.BigDecimal;
import java.security.Key;
import java.util.ArrayList;

public class Map {
    PApplet pApplet;
    Tile tile;
    ArrayList<Tile> tileArrayList;
    float[][] testFloat = new float[800][800];
    int testX = -20;
    int testY = -20;
    float flying = 0;
    float mx;
    float my;
    float e;
    int pushedY;
    int pushedX;
    float cordX = 800F;
    float cordY = 800F;
    Buildable buildable;



    int positionX = 0;
    int positionY = 0;
    ArrayList<ArrayList<Float>> cordsArrayList = new ArrayList<>();
    ArrayList<Float> cordXList = new ArrayList<>();
    ArrayList<Float> cordYList = new ArrayList<>();

    private final boolean IS_DIAGRAMM = false;


    public float getCordX() {
        return cordX;
    }

    public void setCordX(float cordX) {
        this.cordX = cordX;
    }

    public float getCordY() {
        return cordY;
    }

    public void setCordY(float cordY) {
        this.cordY = cordY;
    }



    public Map(PApplet pApplet, ArrayList<Tile> tileArrayList){
        this.pApplet = pApplet;
        this.tileArrayList = tileArrayList;
        cordsArrayList.add(cordXList);
        cordsArrayList.add(cordYList);

    }

    public PApplet getpApplet() {
        return pApplet;
    }

    public void setpApplet(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public ArrayList<Tile> getTileArrayList() {
        return tileArrayList;
    }

    public void setTileArrayList(ArrayList<Tile> tileArrayList) {
        this.tileArrayList = tileArrayList;
    }

    public float[][] getTestFloat() {
        return testFloat;
    }

    public void setTestFloat(float[][] testFloat) {
        this.testFloat = testFloat;
    }

    public int getTestX() {
        return testX;
    }

    public void setTestX(int testX) {
        this.testX = testX;
    }

    public int getTestY() {
        return testY;
    }

    public void setTestY(int testY) {
        this.testY = testY;
    }

    public float getFlying() {
        return flying;
    }

    public void setFlying(float flying) {
        this.flying = flying;
    }

    public float getMx() {
        return mx;
    }

    public void setMx(float mx) {
        this.mx = mx;
    }

    public float getMy() {
        return my;
    }

    public void setMy(float my) {
        this.my = my;
    }

    public float getE() {
        return e;
    }

    public void setE(float e) {
        this.e = e;
    }

    public void createTiles(char key) {

        flying += 0.02F;
        // my = flying;
        if (key == 'w') {
            positionY += 1;
            pushedY=1;
            pushedX = 40;

        } else if (key == 's') {
            positionY -= 1;
        } else if (key == 'a') {
            positionX -= 1;
            pushedY=40;
            pushedX = 1;
        } else if (key == 'd') {
            positionX += 1;
            pushedY=40;
            pushedX = 1;
        }
        testY = -40;
        // TODO: 18.06.2019 ggf die schleife anpassen so das ich x + 1 habe und dieses auch bei mx my abziehe
        int xStartPoint = (positionX + 40);
        //  for(int y = positionY; y < positionY + 1; y++) {

        for (int y = 0; y < pushedY; y++) {
            //    float mx = 0;
            if(pushedY == 1) {
                testY = -20;
                testX = -20;
            }else{
                testY +=20;
                testX = 0;
            }

            for (int x = xStartPoint; x < xStartPoint + pushedX ; x++) {
                mx = 0;
                testX += 20;

            /*    for (int y = 0; y < 1; y++) {
                    //    float mx = 0;
                    testY = 0;
                    testX = -20;
                    for (int x = xStartPoint; x < xStartPoint + 40; x++) {
                        mx = 0;
                        testX += 20;
                        */


                int value = 2;
if(pushedX == 40) {

    mx = (float) x / 40F; // + (float) xStartPoint/40; //+ positionX /100 ; //+ 0.4F;

    my = (float) y / 1F + (float) positionY / 40;// + positionY/ 100F;// + positionY/100F;//+ 0.4F + flying;

    }

    if(pushedX == 1){

        mx = (float) x / 40 ; //(float) xStartPoint + positionX /50; /// 40;; // + (float) xStartPoint/40; //+ positionX /100 ; //+ 0.4F;

     my = (float) y / 40F; //+ (float) positionY / 40;// + positionY/ 100F;// + positionY/100F;//+ 0.4F + flying;

    }
                //System.out.println(mx + " mx \n" + my + " my");


                //  testFloat[y][x] = map(noise((mx *  value), noise(my * value)),0,1,-100,100);
                //testFloat[y][x] = (noise((mx *  value),(my * value))
                //  e = Game.map(pApplet.noise((mx * value), (my * value))

                // e = Game.map(pApplet.noise((mx * value), (my * value)
                //          + 0.5F * pApplet.noise(2 * mx, 2 * my)
                //      + 0.25F * pApplet.noise(3* mx, 3 * my)
                // ),0F,1F,0F,100F);

                e = pApplet.noise((mx * value), (my * value))
                        + 0.5F * pApplet.noise(2 * mx, 2 * my)
                        + 0.25F * pApplet.noise(3 * mx, 3 * my);

                testFloat[y][x] = (float) Math.pow((e), 4.43F);
                if(x == 1){
                   // System.out.println(e);
                }
                //  System.out.println(e + " eeeeeeee");
                //   System.out.println(testFloat[y][x] + " floaaaaaat");
                if (IS_DIAGRAMM) {
                    if (e < 0.5) {
                        pApplet.stroke(39, 50, 90);
                        pApplet.line(x, y, x, (e + 1) * 100);

                    } else if (e < 0.57) {
                        pApplet.stroke(204, 153, 0);
                        pApplet.line(x, y, x, (e + 1) * 100);
                    } else {
                        pApplet.stroke(0, 153, 0);
                        pApplet.line(x, y, x, (e + 1) * 100);

                    }
                } else {

                    //  pApplet.line(x,y,x,e);
                    //pApplet.line(x,y,x,testFloat[y][x]);
                    //pApplet.line(testFloat[y][x],testFloat[y][x],testFloat[y][x],testFloat[y][x]);
                    //    pApplet.line(e,e,e+15,e+15);
                    //pApplet.line(10,10,10,50);


                    //   pApplet.stroke(120);
                    //      System.out.println(e);
                    if (e < 0.76) {
                        // System.out.println("wasser");
                        if (key == 'w' || key == 's') {
                          //  System.out.println(testY);
                            tileArrayList.add(new WaterTile(testX, (testY)));
                        } else if(key == 'a') {
                            tileArrayList.add(new WaterTile(testX, (testY )));
                        }else if(key == 'd') {
                            tileArrayList.add(new WaterTile(testX+ 780, (testY )));
                        }
                        //  tileArrayList.add(new WaterTile(testX, my));

                        // System.out.println("wasser");
                    } else if (e < 0.8) {

                        // System.out.println("kein ");
                        if (key == 'w' || key == 's') {
                            tileArrayList.add(new SandTile(testX, (testY)));
                        } else if(key == 'a') {
                            tileArrayList.add(new SandTile(testX, (testY )));
                            //   tileArrayList.add(new SandTile(testX, my));
                        }else if(key == 'd') {
                            tileArrayList.add(new SandTile(testX+ 780, (testY )));
                        }
                    } else {
                        if (key == 'w' || key == 's') {

                            tileArrayList.add(new GrassTile(testX, (testY)));
                            // tileArrayList.add(new GrassTile(testX, my));
                        } else if(key == 'a'){
                            tileArrayList.add(new GrassTile(testX, (testY )));
                        }
                        else if(key == 'd') {
                            tileArrayList.add(new GrassTile(testX+ 780, (testY )));
                        }
                        }
                    }
                }
            }

        }









       /* for(int i = 1; i <799; i += 20){
            for(int v = 1; v < 800; v += 20) {
                double random = Math.random();

                if (random < 0.97 &&  i > 22 && i < 760 && v > 22 && v < 760) {
                    tileArrayList.add(new GrassTile(i,v));
                }
                else if (random > 0.97 && random < 0.98 &&  i > 2 && i < 780 && v > 2 && v < 780) {
                    tileArrayList.add(new SandTile(i,v));
                } else {
                    tileArrayList.add(new WaterTile(i,v));
                }
            }

        }

    } */
                public void draw () {
                    for (Tile tile : tileArrayList) {
                        pApplet.image(tile.getpImage(), tile.getPositionX(), tile.getPositionY());
                    }
                }

                public ArrayList<Tile> createTiles2() {

                    tileArrayList = new ArrayList<>();
                  //  System.out.println(tileArrayList.size() + "array size");
                    for (int x = 0; x < 40; x++) {
                       // for (int y = 0; y < 40; y++) {
                            for (int y = 0; y < 40; y++) {
                                float noisescale = 0.02F;
                                // TODO: 22.07.2019  ggf fehler hier big
                                float noiseInputX = cordX + (float) x / 40F; //*noisescale ;
                                float noiseInputY = cordY + (float) y / 40F; //*noisescale ;
                                float noise = pApplet.noise((noiseInputX * 2F), (noiseInputY * 2F))
                                        + 0.5F * pApplet.noise(2F * noiseInputX, 2F * noiseInputY)
                                        + 0.25F * pApplet.noise(3F * noiseInputX, 3F * noiseInputY);
                                noise= (float) Math.pow((noise), 0.9F);
                                //float noise = pApplet.noise(noiseInputX , noiseInputY );

                                // System.out.println(cordX + " =cord x "+ x + "=x");
                                //System.out.println(cordY + " =cord y " + y +"=y");
                                //     if(!cordXList.contains(cordX+x) && !cordYList.contains(cordY+y)) {
                            //    System.out.println("das ist cord x" + cordX + "\n" + "das ist x " + x);
                                if (noise < 0.76F) {
                                    tileArrayList.add(new WaterTile(x * 20F, y * 20F, cordX+x, cordY+y));


                                } else if (noise < 0.8F) {

                                    tileArrayList.add(new SandTile(x * 20F, y * 20F, cordX+x, cordY+y));
                                } else {

                                    tileArrayList.add(new GrassTile(x * 20F, y * 20F, cordX+x, cordY+y));
                                }


                       //     }

                                cordXList.add(cordX+x);
                                cordYList.add(cordY+y);

                        }

                    }

                    return tileArrayList;
                }

                }






