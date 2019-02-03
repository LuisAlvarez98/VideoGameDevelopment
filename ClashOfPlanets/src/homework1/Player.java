/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;

import java.awt.Graphics;

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
    
    private int control;
    
    private boolean collided;
    private boolean still;
    
    private int counter;
    

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
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
        this.still = true;
        this.control = 3;
    }

    public int getControl() {
        return control;
    }

    public void setControl(int control) {
        this.control = control;
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
        if(getControl() == 1){
            setX(getX() + getSpeed());
        }else if(getControl() == 2){
            setX(getX() - getSpeed() );
        }else if(getControl() == 3){
             setY(getY() - getSpeed() );
        }else if(getControl() == 4){
             setY(getY() + getSpeed() );
        }
      //collisions
      // reset x position and y position if colision
      if(getX() + 60 >= game.getWidth()){
          setX(game.getWidth() - 60);
          setControl(2);
          setCollided(true);
      }
      else if(getX() <= -30){
           setX(-30);
           setControl(1);
           setCollided(true);
      }
      if(getY() + 80 >= game.getHeight()){
          setY(game.getHeight() - 80);
             setControl(3);
           setCollided(true);
      }
      else if(getY() <= -30){
            setY(-30);
            setControl(4);
          setCollided(true);
      }
    }

    @Override
    public void render(Graphics g) {
        counter++;
        
        if(collided){
            g.drawImage(Assets.planetTwo,getX(), getY(), getWidth(), getHeight(), null);
        }else{
            g.drawImage(Assets.planetOne,getX(), getY(), getWidth(), getHeight(), null);
        }
        if(counter > 200 && collided){
            setCollided(false);
            counter=0;
        }
    }
}
