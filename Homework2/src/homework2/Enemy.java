package homework2;

import java.awt.Graphics;

/**
 *  Enemy class
 * @author Luis Felipe Alvarez Sanchez A01194173
 *  10 Feb 2019
 */
public class Enemy extends Item{
    //Instance Variables
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
     * Enemy constructor
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
     * setSpeed method
     * @param speed 
     */
      public void setSpeed(int speed) {
        this.speed = speed;
    }
    /**
     * getSpeed method
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }
    /**
     * getMovement method
     * @return movement
     */
    public int getMovement() {
        return movement;
    }
    /**
     * setMovement method
     * @param movement 
     */
    public void setMovement(int movement) {
        this.movement = movement;
    }
    /**
     * getDirection method
     * @return direction 
     */
    public int getDirection() {
        return direction;
    }
    /**
     * setDirection method
     * @param direction 
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }
    /**
     * getHeight method
     * @return height
     */
    public int getHeight() {
        return height;
    }
    /**
     * getWidth method
     * @return width
     */
    public int getWidth() {
        return width;
    }
    /**
     * setHeight method
     * @param height 
     */
    public void setHeight(int height) {
        this.height = height;
    }
    /**
     * setWidth method
     * @param width 
     */
    public void setWidth(int width) {
        this.width = width;
    }
     /**
     * enemySetNewPos method
     * @param x
     * @param y 
     */
    public void enemySetNewPos(int x, int y){
        this.x = x;
        this.y = y;
    }
    /**
     * tick method
     * The overall movement of the enemy
     */
    @Override
    public void tick() {  
       
        //Enemy movement algorithm
        if(getX() != player.getX()){
            //Moves in x direction towards the player
           dirX =(getX() - player.getX())/ (Math.abs(getX()-player.getX())) ;
        }
        if(getY() != player.getY()){
            //Moves in y direction towards the player
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
     * Renders the enemy
     * @param g 
     */
    @Override
    public void render(Graphics g) {
         g.drawImage(Assets.planetTwo,getX(), getY(), getWidth(), getHeight(), null);
    }
}
