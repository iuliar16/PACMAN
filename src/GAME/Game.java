package GAME;

import GAME.Graphics.Assets;
import GAME.Graphics.ImageNotFoundException;
import GAME.Keys.KeyManager;
import GAME.Keys.Mouse;
import GAME.States.GameState;
import GAME.States.MenuState;
import GAME.States.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.sql.SQLException;


public class Game implements Runnable{

    private GameWindow wnd;
    private int width, height;
    public String title;
    private int score;

    private boolean runState;
    private Thread gameThread;

    private BufferStrategy bs;
    private Graphics g;

    public State gameState;

    private KeyManager key;
    private Mouse mouse;

    private Handler handler;
    public State menuState;

    private int level=1;


    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        key=new KeyManager();
        mouse = new Mouse();
    }

    @Override
    public void run() {
        try {
            InitGame();
        } catch (ImageNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFileException e) {
            e.printStackTrace();
        }
        long oldTime = System.nanoTime();
        long curentTime;
        final int framesPerSecond   = 60;
        final double timeFrame      = 1000000000 / framesPerSecond;

        while (runState == true)
        {
            curentTime = System.nanoTime();
            if((curentTime - oldTime) > timeFrame)
            {
                try {
                    Update();
                } catch (InvalidFileException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Draw();
                oldTime = curentTime;
            }
        }
        StopGame();
    }

    private void Draw() {
        bs = wnd.GetCanvas().getBufferStrategy();
        if(bs == null)
        {
            try
            {
                wnd.GetCanvas().createBufferStrategy(3);
                return;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0,width,height);
        if(State.getState()!=null)
            State.getState().Draw(g);

        bs.show();
        g.dispose();
    }

    private void Update() throws SQLException, InvalidFileException {
        key.Update();

        if(State.getState()!=null)
            State.getState().Update();
    }

    private void InitGame() throws ImageNotFoundException, InvalidFileException {
        wnd = new GameWindow(title, width, height);
        wnd.getFrame().addKeyListener(key);
        wnd.getFrame().addMouseListener(mouse);
        wnd.getFrame().addMouseMotionListener(mouse);
        wnd.getCanvas().addMouseListener(mouse);
        wnd.getCanvas().addMouseMotionListener(mouse);
        Assets.Init();
        handler=new Handler(this);

        gameState=new GameState(handler,level);
        menuState = new MenuState(handler);
        State.setState(menuState);
    }
    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public Graphics getGraphics() {
        return g;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = this.score + score;
    }
    public synchronized void StartGame()
    {
        if(runState == false)
        {

            runState = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
        else
        {

            return;
        }
    }

    public synchronized void StopGame()
    {
        if(runState == true)
        {
            runState = false;
            try
            {
                gameThread.join();
            }
            catch(InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
        else
        {
            return;
        }
    }
    public KeyManager getKey()
    {
        return key;
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
    public Mouse getMouse() {
        return mouse;
    }
}