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
    Charakter charakter;
    ArrayList<Buildable> buildableArrayList;
    int absolutX = 0;
    int absoluteY = 0;
    private boolean drawMove;


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



    public Map(PApplet pApplet, ArrayList<Tile> tileArrayList, Charakter charakter, ArrayList<Buildable> buildableArrayList, boolean drawMove){
        this.pApplet = pApplet;
        this.tileArrayList = tileArrayList;
        cordsArrayList.add(cordXList);
        cordsArrayList.add(cordYList);
        this.charakter= charakter;
        this.buildableArrayList = buildableArrayList;
        this.drawMove = drawMove;

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


        for (int y = 0; y < pushedY; y++) {

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




                int value = 2;
if(pushedX == 40) {

    mx = (float) x / 40F;

    my = (float) y / 1F + (float) positionY / 40;

    }

    if(pushedX == 1){

        mx = (float) x / 40 ;
     my = (float) y / 40F;
    }


                e = pApplet.noise((mx * value), (my * value))
                        + 0.5F * pApplet.noise(2 * mx, 2 * my)
                        + 0.25F * pApplet.noise(3 * mx, 3 * my);

                testFloat[y][x] = (float) Math.pow((e), 4.43F);
                if(x == 1){

                }

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


                    if (e < 0.76) {

                        if (key == 'w' || key == 's') {

                            tileArrayList.add(new WaterTile(testX, (testY)));
                        } else if(key == 'a') {
                            tileArrayList.add(new WaterTile(testX, (testY )));
                        }else if(key == 'd') {
                            tileArrayList.add(new WaterTile(testX+ 780, (testY )));
                        }

                    } else if (e < 0.8) {


                        if (key == 'w' || key == 's') {
                            tileArrayList.add(new SandTile(testX, (testY)));
                        } else if(key == 'a') {
                            tileArrayList.add(new SandTile(testX, (testY )));

                        }else if(key == 'd') {
                            tileArrayList.add(new SandTile(testX+ 780, (testY )));
                        }
                    } else {
                        if (key == 'w' || key == 's') {

                            tileArrayList.add(new GrassTile(testX, (testY)));

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












                public ArrayList<Tile> createTiles2() {

                    tileArrayList = new ArrayList<>();

                    for (int y = 0; y < 40; y++) {

                            for (int x = 0; x < 40; x++) {

                                // TODO: 22.07.2019  ggf fehler hier big
                                float noiseInputX = (cordX + (float) x / 40F) ; //*noisescale ;
                                float noiseInputY = (cordY + (float) y / 40F) ; //*noisescale ;
                                float noise = pApplet.noise((noiseInputX * 2F), (noiseInputY * 2F))
                                        + 0.5F * pApplet.noise(2F * noiseInputX, 2F * noiseInputY)
                                        + 0.25F * pApplet.noise(3F * noiseInputX, 3F * noiseInputY);

                                int tempCordX = x + absolutX;
                                int tempCordY = y + absoluteY;



                                if (noise < 0.76F) {
                                        tileArrayList.add(new WaterTile(x * 20F, y * 20F, cordX+x, cordY+y,tempCordX,tempCordY));


                                    } else if (noise < 0.8F) {

                                        tileArrayList.add(new SandTile(x * 20F, y * 20F, cordX+x, cordY+y,tempCordX,tempCordY));
                                    } else if(noise >= 0.8F && noise < 1.1F ){

                                        tileArrayList.add(new GrassTile(x * 20F, y * 20F, cordX+x, cordY+y,tempCordX,tempCordY));
                                    }

                                    else {
                                        tileArrayList.add(new GrassTreeTile(x *20F, y* 20F, cordX+x, cordY+y,tempCordX,tempCordY));

                                }


                       //     }

                                cordXList.add(cordX+x);
                                cordYList.add(cordY+y);

                        }

                    }

                    return tileArrayList;
                }

                public boolean autoscroll(){

                    if(charakter.getPosiX() == 600){
                        moveRight();
                        return true;

                    }
                    if(charakter.getPosiX() == 200){
                        moveLeft();
                        return true;
                    }
                    if(charakter.getPosiY() == 600){
                        moveDown();
                        return true;
                    }
                    if(charakter.getPosiY() == 200){
                        moveUp();
                        return true;
                    }

                return false;
                }
    public void moveRight(){


        setCordX(getCordX() +0.1F);
        drawMove = true;
        absolutX += 4;
        charakter.setPosiX(charakter.getPosiX() - 80);
        for (Buildable buildable : buildableArrayList) {
            buildable.setCordX(buildable.getCordX() - 80);
        }

    }
    public void moveLeft(){


        setCordX(getCordX() -0.1F);
        drawMove = true;
        absolutX -= 4;
        charakter.setPosiX(charakter.getPosiX() + 80);
        for (Buildable buildable : buildableArrayList) {
            buildable.setCordX(buildable.getCordX() + 80);
        }
    }
    public void moveUp(){


        setCordY(getCordY() -0.1F);
        drawMove = true;
        absoluteY -= 4;
        charakter.setPosiY(charakter.getPosiY() + 80);
        for (Buildable buildable : buildableArrayList) {
            buildable.setCordY(buildable.getCordY() + 80);
        }
    }
    public void moveDown(){


        setCordY(getCordY() +0.1F);
        drawMove = true;
        absoluteY += 4;
        charakter.setPosiY(charakter.getPosiY() - 80);
        for (Buildable buildable : buildableArrayList) {
            buildable.setCordY(buildable.getCordY() - 80);
        }
    }

                }






