package homework2;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *  Player class
 * @author Luis Felipe Alvarez Sanchez A01194173
 *  4 Feb 2019
 */
public class Player extends Item{
    private int direction;
    private int width;
    private int height;
    private Game game;
    private int speed;
    private int movement;
    
    public static int lives;
    
    private boolean collided;    
    private int counter;
    
    public boolean dir[] ={false,false,false,false};
    /**
     * Player constructor
     * @param x
     * @param y
     * @param direction
     * @param width
     * @param height
     * @param game 
     */
    public Player(int x, int y, int direction, int width, int height, Game game, int lives) {
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.speed = 1;
        this.collided = false;
        this.counter = 0;
        this.movement = 1;
        this.lives = lives;
    }
    /**
     * 
     */
    public void decreaseLives(){
        this.lives--;
    }
    /**
     * 
     * @return lives
     */
    public int getLives(){
        return this.lives;
    }
    /**
     * 
     * @param speed 
     */
      public void setSpeed(int speed) {
        this.speed = speed;
    }
    /**
     * 
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }
    /**
     * 
     * @return movement
     */
    public int getMovement() {
        return movement;
    }
    /**
     * 
     * @param movement 
     */
    public void setMovement(int movement) {
        this.movement = movement;
    }

    /**
     * 
     * @param collided 
     */
    public void setCollided(boolean collided) {
        this.collided = collided;
    }
    /**
     * 
     * @return direction 
     */
    public int getDirection() {
        return direction;
    }
    /**
     * 
     * @param direction 
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }
    /**
     * 
     * @return height
     */
    public int getHeight() {
        return height;
    }
    /**
     * 
     * @return width
     */
    public int getWidth() {
        return width;
    }
    /**
     * 
     * @param height 
     */
    public void setHeight(int height) {
        this.height = height;
    }
    /**
     * 
     * @param width 
     */
    public void setWidth(int width) {
        this.width = width;
    }
    /**
     * 
     * @param x
     * @param y 
     */
    public void playerSetNewPos(int x, int y){
        this.x = x;
        this.y = y;
    }
     /**
     * The overall movement of the player
     */
    @Override
    public void tick() {  
        if(game.getMouseManager().isIzquierdo()){
            setX(game.getMouseManager().getX());
            setY(game.getMouseManager().getY());
        }
           
         //Colissions
      if(getX() + 60 >= game.getWidth()){
          setX(game.getWidth() - 60);
          setMovement(3);
          setCollided(true);
      }
      else if(getX() <= -30){
           setX(-30);
           setMovement(4);
           setCollided(true);
      }
      if(getY() + 100 >= game.getHeight()){
          setY(game.getHeight() - 100);
           setMovement(1);
           setCollided(true);
      }
      else if(getY() <= -30){
          setY(-30);
          setMovement(2);
          setCollided(true);
      }
    }
    /**
     * Renders the player
     * @param g 
     */
    @Override
    public void render(Graphics g) {
         g.drawImage(Assets.planetOne,getX(), getY(), getWidth(), getHeight(), null);
    }
}
