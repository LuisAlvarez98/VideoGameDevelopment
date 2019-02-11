package homework2;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.util.Random;
/**
 * Game Class
 * @author Luis Felipe Alvarez Sanchez A01194173
 * 10 Feb 2019
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
    //Entities
    private Player player;
    private Enemy enemy;
    
    private KeyManager keyManager;
    private MouseManager mouseManager;
    
    private boolean gameover;
    /**
     * Game constructor
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
    /**
     * isGameover method
     * @return gameover
     */
    public boolean isGameover() {
        return gameover;
    }
    /**
     * setGameOver method
     * @param gameover 
     */
    public void setGameOver(boolean gameover){
        this.gameover = gameover;
    }
    /**
     * getMouseManager method
     * @return mouseManager
     */
     public MouseManager getMouseManager() {
        return mouseManager;
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
     * init method
     * inits the game with the display, player and enemy
     */
    public void init(){
        display = new Display(title, getWidth(), getHeight());
        Assets.init();
        
        //Random positons for both entities
        Random randx1 = new Random();
        Random randy1 = new Random();
        
        Random randx2 = new Random();
        Random randy2 = new Random();
        //Places the enemy and the player on random positions
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
     * getKeyManager method
     * @return keyManager
     */
     public KeyManager getKeyManager() {
        return keyManager;
    }
    /**
     * tick method
     */
    private void tick(){
        //Checks if isGameOver
        if(!isGameover()){
            keyManager.tick();
            player.tick();
            enemy.tick();  
            Rectangle r = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
            Rectangle p = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
            //Checks collision between enemy and player
            if (r.intersects(p))
            {                
                int counter = 0;
                if(counter == 0){
                    player.decreaseLives();
                    Assets.deathSound.play();
                    counter++;
                }
                //Places the player and the enemy in a new position
                Random randx1 = new Random();
                Random randy1 = new Random();

                Random randx2 = new Random();
                Random randy2 = new Random();
                player.playerSetNewPos(randx1.nextInt(getWidth()+ 30),randy1.nextInt(getHeight()+1));
                enemy.enemySetNewPos(randx2.nextInt(getWidth()+ 30),randy2.nextInt(getHeight()+1));
                //Increases enemy speed
                enemy.setSpeed(enemy.getSpeed() * 2);
                
                counter = 0;
                //if player lives <= 0 {game over}
                if(player.getLives() <=0){
                    setGameOver(true);
                    System.out.println("GAME OVER");
                }
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