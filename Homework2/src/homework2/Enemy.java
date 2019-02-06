package homework2;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *  Player class
 * @author Luis Felipe Alvarez Sanchez A01194173
 *  4 Feb 2019
 */
public class Enemy extends Item{
    private int direction;
    private int width;
    private int height;
    private Game game;
    private Player player;
    private int speed;
    private int movement;
    
    private int dirX;
    private int dirY;
    
    
    /**
     * Player constructor
     * @param x
     * @param y
     * @param direction
     * @param width
     * @param height
     * @param game 
     */
    public Enemy(int x, int y, int direction, int width, int height, Game game, Player player) {
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.speed = 1;
        this.movement = 1;
        this.player = player;
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
    public void enemySetNewPos(int x, int y){
        this.x = x;
        this.y = y;
    }
    /**
     * The overall movement of the player
     */
    @Override
    public void tick() {  
       
        if(getX() != player.getX()){
           dirX =(getX() - player.getX())/ (Math.abs(getX()-player.getX())) ;
        }
        if(getY() != player.getY()){
            dirY =(getY() - player.getY())/ (Math.abs(getY()-player.getY())) ;
        }
       
        if(dirX > 0){
            if(getX() != player.getX()){
                     setX(getX() - getSpeed());
            }
        }  else{
            if(getX() != player.getX()){
               setX(getX() + getSpeed() );
            }
        }
         if(dirY > 0){
            if(getY() != player.getY()){
                     setY(getY() - getSpeed());
            }
        }  else{
            if(getY() != player.getY()){
               setY(getY() + getSpeed() );
            }
        }
     
      //Colissions
      if(getX() + 60 >= game.getWidth()){
          setX(game.getWidth() - 60);
      }
      else if(getX() <= -30){
           setX(-30);
      }
      if(getY() + 100 >= game.getHeight()){
          setY(game.getHeight() - 100);
      }
      else if(getY() <= -30){
          setY(-30);
      }
    }
    /**
     * Renders the player
     * @param g 
     */
    @Override
    public void render(Graphics g) {
         g.drawImage(Assets.planetTwo,getX(), getY(), getWidth(), getHeight(), null);
    }
}
