import processing.core.PImage;

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
    private boolean moveDown;
    private boolean moveUp;
    private boolean moveLeft;
    private boolean moveRigt;
    private int canMove = 0;
    int cordsRelativX = 20;

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

    public Charakter() {


    }


    public void movement(char key) {
        if (key == 'w') {
            this.setPosiY(this.getPosiY() + 20);
        }
        if (key == 's') {
            this.setPosiY(this.getPosiY() - 20);
        }
        if (key == 'a') {
            this.setPosiX(this.getPosiX() - 20);
        }
        if (key == 'd') {
            this.setPosiX(this.getPosiX() + 20);
        }


    }

    public void moveUp(){
        setPosiY(getPosiY() - 20);
    }
    public void moveDown(){
        setPosiY(getPosiY() + 20);
    }
    public void moveLeft(){
        setPosiY(getPosiY() - 20);
    }
    public void moveRight(){
        setPosiY(getPosiY() - 20);
    }

    public void charakterMove() {


        if (moveUp && canMove >50) {
            //   canMoveUp = true;
            //  charakter.movement(key);
            setPosiY(getPosiY() - 20);
            canMove = 0;
        }
        if (moveDown && canMove >50) {
            //  canMoveDown = true;
            setPosiY(getPosiY() + 20);
            canMove = 0;
        }
        if (moveLeft && canMove >50) {
            // canMoveLeft = true;
            setPosiX(getPosiX() - 20);
            canMove = 0;
        }
        if (moveRigt && canMove >50) {
            // canMoveRight = true;
            setPosiX(getPosiX() + 20);

            canMove = 0;



            }

        }
    }



