import processing.core.PApplet;

public class Game extends PApplet {

    public static void main(String[] args){
        PApplet.main(Game.class args);
    }
    @Override
    public void settings(){
        super.settings();

        size(800, 800);
    }
    @Override
    public void setup(){
        super.setup();
        frameRate(30);
        loop();
    }
   @Override
    public void draw(){


    }
}
