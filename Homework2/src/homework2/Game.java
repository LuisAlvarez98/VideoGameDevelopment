package homework2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * Game Class
 * @author Luis Felipe Alvarez Sanchez A01194173
 * 4 Feb 2019
 */
public class Game implements Runnable{
    private BufferStrategy bs;
    private Graphics g;
    private Display display;
    String title;
    private int width;
    private int height;
    private Thread thread;
    private boolean running;
    
    private int x;
    private int direction;
    private Player player;
    private Enemy enemy;
    private KeyManager keyManager;
    private MouseManager mouseManager;
    
    private boolean gameover;
    /**
     * 
     * @param title
     * @param width
     * @param height 
     */
    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        running = false;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
        this.gameover = false;
    }

    public boolean isGameover() {
        return gameover;
    }
    public void setGameOver(boolean gameover){
        this.gameover = gameover;
    }
    /**
     * 
     * @return mouseManager
     */
     public MouseManager getMouseManager() {
        return mouseManager;
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
     * inits the game with the display and player
     */
    public void init(){
        display = new Display(title, getWidth(), getHeight());
        Assets.init();
        //Random positons for both entities
        Random randx1 = new Random();
        Random randy1 = new Random();
        
        Random randx2 = new Random();
        Random randy2 = new Random();
        
        player = new Player(randx1.nextInt(getWidth()+ 30),randy1.nextInt(getHeight()+1), 1, 100, 100, this,3);
        enemy = new Enemy(randx2.nextInt(getWidth()+ 30),randy2.nextInt(getHeight()+1), 1, 100, 100, this,player);
        display.getJframe().addKeyListener(keyManager);
        display.getJframe().addMouseListener(mouseManager);
        display.getJframe().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
    }
    /**
     * run method
     */
    @Override
    public void run() {
        init();
        int fps = 50;
        double timeTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        while(running){
            //Metodo statico
            now = System.nanoTime();
            delta += (now - lastTime) / timeTick;
            lastTime = now;
            
            if(delta >= 1){
                tick();
                render();
                delta--; 
            }
        }
        stop();
    }
    /**
     * 
     * @return keyManager
     */
     public KeyManager getKeyManager() {
        return keyManager;
    }
    /**
     * tick method
     */
    private void tick(){
        
        if(!isGameover()){
            keyManager.tick();
            player.tick();
            enemy.tick();  
            Rectangle r = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
            Rectangle p = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
            if (r.intersects(p))
            {                
                int counter = 0;
                if(counter == 0){
                    player.decreaseLives();
                    counter++;
                }
                Random randx1 = new Random();
                Random randy1 = new Random();

                Random randx2 = new Random();
                Random randy2 = new Random();
                player.playerSetNewPos(randx1.nextInt(getWidth()+ 30),randy1.nextInt(getHeight()+1));
                enemy.enemySetNewPos(randx2.nextInt(getWidth()+ 30),randy2.nextInt(getHeight()+1));
                counter = 0;
                if(player.getLives() <=0){
                    setGameOver(true);
                    System.out.println("GAME OVER");
                }
                //Tan solo lo toca
                //Resetea el juego
                //-1 vida
                //si vidas == 0 == end game
                //Aumenta velocidad
                System.out.println("f");
            }
        }
   
       
    }
    /**
     * render method
     */
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
        }else{
            g = bs.getDrawGraphics();
            g.drawImage(Assets.background,0,0,width,height,null);
            player.render(g);
            enemy.render(g);
            bs.show();
            g.dispose();
        }
    }
    /**
     * start method
     */
    public synchronized void start(){
        if(!running){
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }
    /**
     * stop method
     */
    public synchronized void stop(){
        if(running){
            running = false;
            try{
                thread.join();
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
}
