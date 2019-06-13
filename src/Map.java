import processing.core.PApplet;

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

    int positionX = 0;
    int positionY = 0;

    private final boolean IS_DIAGRAMM = false;

    public Map(PApplet pApplet, ArrayList<Tile> tileArrayList){
        this.pApplet = pApplet;
        this.tileArrayList = tileArrayList;

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
        } else if (key == 's') {
            positionY -= 1;
        } else if (key == 'a') {
            positionX -= 1;
        } else if (key == 'd') {
            positionX += 1;
        }
        testY = -40;
        int xStartPoint = (positionX * 40);
        for(int y = positionY; y < positionY + 1; y++) {
            //    float mx = 0;
            testY = 20;
            testX = -20;
            for (int x = xStartPoint; x < xStartPoint + 40; x++ ){
                mx = 0;
               testX = 20;


                int value = 2;

                 mx = (float) x /40F + positionX /100 ; //+ 0.4F;

                 my = (float) y / 1F + positionY/ 100F;//+ 0.4F + flying;
              //  System.out.println(mx +" mx \n" + my +" my");

                //  testFloat[y][x] = map(noise((mx *  value), noise(my * value)),0,1,-100,100);
                //testFloat[y][x] = (noise((mx *  value),(my * value))
              //  e = Game.map(pApplet.noise((mx * value), (my * value))

               // e = Game.map(pApplet.noise((mx * value), (my * value)
                 //          + 0.5F * pApplet.noise(2 * mx, 2 * my)
                   //      + 0.25F * pApplet.noise(3* mx, 3 * my)
                // ),0F,1F,0F,100F);

              e = pApplet.noise((mx * value), (my * value))
                       + 0.5F * pApplet.noise(2 * mx, 2 * my)
                        + 0.25F * pApplet.noise(27 * mx, 27 * my);

                testFloat[y][x] = (float) Math.pow((e), 2.43F);
              //  System.out.println(e + " eeeeeeee");
             //   System.out.println(testFloat[y][x] + " floaaaaaat");
                if(IS_DIAGRAMM) {
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
                }else{

              //  pApplet.line(x,y,x,e);
                //pApplet.line(x,y,x,testFloat[y][x]);
               //pApplet.line(testFloat[y][x],testFloat[y][x],testFloat[y][x],testFloat[y][x]);
            //    pApplet.line(e,e,e+15,e+15);
                //pApplet.line(10,10,10,50);


             //   pApplet.stroke(120);
              //      System.out.println(e);
                if (e < 0.76) {
                   // System.out.println("wasser");
                    tileArrayList.add(new WaterTile(testX, (testY  )));
                  //  tileArrayList.add(new WaterTile(testX, my));

                   // System.out.println("wasser");
                } else if(e < 0.8) {

                   // System.out.println("kein ");
                   tileArrayList.add(new SandTile(testX, (testY  )));
                 //   tileArrayList.add(new SandTile(testX, my));
                }else{
                  tileArrayList.add(new GrassTile(testX, (testY  )));
                   // tileArrayList.add(new GrassTile(testX, my));
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

            }


