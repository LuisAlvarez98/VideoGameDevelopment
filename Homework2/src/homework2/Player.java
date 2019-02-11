package homework2;

import java.awt.Graphics;
/**
 *  Player class
 * @author Luis Felipe Alvarez Sanchez A01194173
 *  10 Feb 2019
 */
public class Player extends Item{
    //Instance variables
    private int direction;
    private int width;
    private int height;
    private Game game;
    private int speed;
    private int movement;
    
    public static int lives;
    
    private boolean collided;    
    private int counter;
    
    private boolean playerPressed;
    private boolean playerReleased;
    
    private int mouseX;
    private int mouseY;
    
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
        this.playerReleased = false;
    }
    /**
     * setPlayerReleased method
     * @param playerReleased 
     */
    public void setPlayerReleased(boolean playerReleased) {
        this.playerReleased = playerReleased;
    }
    /**
     * isPlayerReleased method
     * @return playerReleased 
     */
    public boolean isPlayerReleased() {
        return playerReleased;
    }
    /**
     * decreaseLives method
     * Decreses the lives by one to the player
     */
    public void decreaseLives(){
        this.lives--;
    }
    /**
     * getLives method
     * @return lives
     */
    public int getLives(){
        return this.lives;
    }
    /**
     * setSpeed of the player method
     * @param speed 
     */
      public void setSpeed(int speed) {
        this.speed = speed;
    }
    /**
     * gets the speed of the player
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }
    /**
     * gets the movement of the player
     * @return movement
     */
    public int getMovement() {
        return movement;
    }
    /**
     * sets the movement of the player
     * @param movement 
     */
    public void setMovement(int movement) {
        this.movement = movement;
    }
    /**
     * sets if the player has collided with a wall
     * @param collided 
     */
    public void setCollided(boolean collided) {
        this.collided = collided;
    }
    /**
     * gets the direction of the player
     * @return direction 
     */
    public int getDirection() {
        return direction;
    }
    /**
     * sets the direction of the player
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
     * playerSetNewPos method
     * changes the position of the player
     * @param x
     * @param y 
     */
    public void playerSetNewPos(int x, int y){
        this.x = x;
        this.y = y;
    }
     /**
      * tick method
     * The overall movement of the player
     */
    @Override
    public void tick() {  
        //Checks if the mouse is being clicked inside the player [Fix]
    if ((game.getMouseManager().getX() >= getX() &&
         game.getMouseManager().getX() <= getX()+80) && 
         game.getMouseManager().getY() >= getY() && 
         game.getMouseManager().getY() <= getY()+80) {
          playerPressed = true;
          //First time player pressed
         if(!isPlayerReleased()){
                mouseX = game.getMouseManager().getX() - getX();
                mouseY = game.getMouseManager().getY() - getY();
         }
         setPlayerReleased(true);
        }
        if (!game.getMouseManager().isDragged()){
            playerPressed = false;
            setPlayerReleased(false);
        }
        
        if (game.getMouseManager().isDragged() && playerPressed) {
            //Set position of mouse where it was clicked
            setX(game.getMouseManager().getX() - mouseX);
            setY(game.getMouseManager().getY() - mouseY);
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
