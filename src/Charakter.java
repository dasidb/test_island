import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.Map;

public class Charakter {
    private PImage charakterImage;
    private float posiX;
    private float posiY;
    private String name;
    private int health;
    private float velocity;
    private boolean isSand;
    private boolean isGrass;
    private boolean isWater;
    private boolean isGrassTree;
    private boolean moveDown;
    private boolean moveUp;
    private boolean moveLeft;
    private boolean moveRigt;
    private int canMove = 0;
    private int absoluteX;
    private int absoluteY;
    private Game game;
    private PVector mapPosi = new PVector(20,20);
    private Map<PVector, Buildable> buildableMap;

    public boolean isGrassTree() {
        return isGrassTree;
    }

    public void setGrassTree(boolean grassTree) {
        isGrassTree = grassTree;
    }

    public int getAbsoluteX() {
        return absoluteX;
    }

    public void setAbsoluteX(int absoluteX) {
        this.absoluteX = absoluteX;
    }

    public int getAbsoluteY() {
        return absoluteY;
    }

    public void setAbsoluteY(int absoluteY) {
        this.absoluteY = absoluteY;
    }

    public int getCanMove() {
        return canMove;
    }

    public void setCanMove(int canMove) {
        this.canMove = canMove;
    }

    public boolean isMoveDown() {
        return moveDown;
    }

    public void setMoveDown(boolean moveDown) {
        this.moveDown = moveDown;
    }

    public boolean isMoveUp() {
        return moveUp;
    }

    public void setMoveUp(boolean moveUp) {
        this.moveUp = moveUp;
    }

    public boolean isMoveLeft() {
        return moveLeft;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public boolean isMoveRigt() {
        return moveRigt;
    }

    public void setMoveRigt(boolean moveRigt) {
        this.moveRigt = moveRigt;
    }

    public boolean isSand() {
        return isSand;
    }


    public void setSand(boolean sand) {
        isSand = sand;
    }

    public boolean isGrass() {
        return isGrass;
    }

    public void setGrass(boolean grass) {
        isGrass = grass;
    }

    public boolean isWater() {
        return isWater;
    }

    public void setWater(boolean water) {
        isWater = water;
    }

    public PImage getCharakterImage() {
        return charakterImage;
    }

    public void setCharakterImage(PImage charakterImage) {
        this.charakterImage = charakterImage;
    }

    public float getPosiX() {
        return posiX;
    }

    public void setPosiX(float posiX) {
        this.posiX = posiX;
    }

    public float getPosiY() {
        return posiY;
    }

    public void setPosiY(float posiY) {
        this.posiY = posiY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public PVector getMapPosi() {
        return mapPosi;
    }

    public void setMapPosi(PVector mapPosi) {
        this.mapPosi = mapPosi;
    }

    public Charakter(int posiX, int posiY, Game game, Map<PVector,Buildable> buildableMap) {
    this.posiX = posiX;
    this.posiY = posiY;
    absoluteX = 19;
    absoluteY = 19;
    this.game = game;
    this.buildableMap = buildableMap;
    }




    public boolean charakterMove() {


        if (moveUp && canMove >50) {

            setPosiY(getPosiY() - 20);
            canMove = 0;
            absoluteY -=1;
            mapPosi.y -= 1;

        }
        if (moveDown && canMove >50) {

            setPosiY(getPosiY() + 20);
            canMove = 0;
            absoluteY += 1;
            mapPosi.y += 1;
        }
        if (moveLeft && canMove >50) {

            setPosiX(getPosiX() - 20);
            canMove = 0;
            absoluteX -= 1;
            mapPosi.x -= 1;
        }
        if (moveRigt && canMove >50) {

            setPosiX(getPosiX() + 20);
            canMove = 0;
            absoluteX += 1;
            mapPosi.x += 1;


            }
        return true;
        }

        public void chopTree(PImage grasImg){
        game.getGameMap().getTileMap().put(mapPosi, new GrassTile(mapPosi.x *20,mapPosi.y * 20, mapPosi.x*20, mapPosi.y * 20));

        game.setDrawNewMap(true);
        game.setDrawNew(true);
        }
    }



