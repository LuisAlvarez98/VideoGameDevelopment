/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author Luis Felipe Alvarez Sanchez A01194173
 */
public class Player extends Item{
    private int direction;
    private int width;
    private int height;
    private Game game;
    private int speed;
    
    private int x;
    private int y;
    private int movement;
    
    private boolean incdec;
    
    private boolean collided;
    
    private int counter;
    
    public boolean mv[] ={false,false,false,false};
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public boolean isIncdec() {
        return incdec;
    }
    
    public void setIncdec(boolean incDec){
        this.incdec = incDec;
    }
    public Player(int x, int y, int direction, int width, int height, Game game) {
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.speed = 1;
        this.collided = false;
        this.counter = 0;
        this.movement = 1;
        this.incdec = true;
    }
    public void setCollided(boolean collided) {
        this.collided = collided;
    }
    
    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
   
  
    @Override
    public void tick() {   
        //Moves to the right each time I click it it must increase speed by 1
            if(game.getKeyManager().up){
                 System.out.println("up");
                 game.getKeyManager().keyCheck(KeyEvent.VK_UP, false);
                 setMovement(1);
               if(!mv[0]){
                     setSpeed(getSpeed()-1);
                      
                      if(getSpeed() == 0){
                        setSpeed(1);
                        mv[0] = true;
                       }
                }else{
                   setSpeed(getSpeed()+1); 
                }
                 mv[1] = false;
                 mv[2] = false;
                 mv[3] = false;
            }
            if(game.getKeyManager().down){
                System.out.println("down");
                game.getKeyManager().keyCheck(KeyEvent.VK_DOWN, false);
                
                setMovement(2);
               if(!mv[1]){
                     setSpeed(getSpeed()-1);
                      
                      if(getSpeed() == 0){
                        setSpeed(1);
                        mv[1] = true;
                       }
                }else{
                   setSpeed(getSpeed()+1); 
                }
                 mv[0] = false;
                 mv[2] = false;
                 mv[3] = false;
            }
            if(game.getKeyManager().left){
                game.getKeyManager().keyCheck(KeyEvent.VK_LEFT, false);
                setMovement(3);
                if(!mv[2]){
                     setSpeed(getSpeed()-1);
                      
                      if(getSpeed() == 0){
                        setSpeed(1);
                        mv[2] = true;
                       }
                }else{
                   setSpeed(getSpeed()+1); 
                }
                 mv[0] = false;
                 mv[1] = false;
                 mv[3] = false;
            }
            if(game.getKeyManager().right){
                game.getKeyManager().keyCheck(KeyEvent.VK_RIGHT, false);
                setMovement(4);
                if(!mv[3]){
                     setSpeed(getSpeed()-1);
                      
                      if(getSpeed() == 0){
                        setSpeed(1);
                        mv[3] = true;
                       }
                }else{
                   setSpeed(getSpeed()+1); 
                }
                 mv[0] = false;
                 mv[1] = false;
                 mv[2] = false;   

            }
           
         setSpeed(getSpeed());
         switch(getMovement()){
             case 1:
                  setY(getY() - getSpeed());
                 break;
             case 2:
                 setY(getY() + getSpeed());
                 break;
             case 3:
                  setX(getX() - getSpeed());
                 break;
             case 4:
                 setX(getX() + getSpeed());
                 break;
         }
      // reset x position and y position if colision
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
      if(getY() + 80 >= game.getHeight()){
          setY(game.getHeight() - 80);
           setMovement(1);
           setCollided(true);
      }
      else if(getY() <= -30){
          setY(-30);
           setMovement(2);
          setCollided(true);
      }
      int speed = getSpeed();
      System.out.println("Current speed:" + speed + mv[0] + mv[1] + mv[2] + mv[3]);
    }
    
    @Override
    public void render(Graphics g) {
        counter++;
        
        //Checks if player has collided
        if(collided){
            g.drawImage(Assets.planetTwo,getX(), getY(), getWidth(), getHeight(), null);
        }else{
            g.drawImage(Assets.planetOne,getX(), getY(), getWidth(), getHeight(), null);
        }
        if(counter > 1000 && collided){
            setCollided(false);
            counter=0;
        }
    }
}
