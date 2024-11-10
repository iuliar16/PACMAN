package GAME.Entities.MovingCreatures;
import GAME.DatabaseHandler;
import GAME.Entities.Entity;
import GAME.Entities.Statics.Dot;
import GAME.Graphics.Assets;
import GAME.Handler;
import GAME.InvalidFileException;
import GAME.Sound;
import GAME.States.GameState;
import GAME.States.State;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    private GameState gameState;
    public int level;
   private int lives=5;
   private int k=37;
    public boolean winner;
    public boolean dead = false;
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.defaultWidth, Creature.defaultHeight);
        solidArea.x = 8;
        solidArea.y = 8;
        solidArea.width = 32;
        solidArea.height = 32;
    }

    @Override
    public void Draw(Graphics g) {

        BufferedImage image = null;
        switch (direction) {
            case "up":
                image = Assets.playerUp;
                break;
            case "down":
                image = Assets.playerDown;
                break;
            case "left":
                image = Assets.playerLeft;
                break;
            case "right":
                image = Assets.playerRight;
                break;
        }
        g.drawImage(image, (int) x, (int) y, null);


        g.setFont(new Font("Sergiue", Font.BOLD, 22));
        g.drawString("Score : " + handler.getGame().getScore() , 700 , 40 );
        g.drawString("Level : " + handler.getGame().getLevel() , 400 , 40 );
        g.drawString("Start Menu" , 530 , 40 );
        g.drawImage(Assets.sound_icon, 300 , 10,null );
        Rectangle sound = new Rectangle(300,10, 48, 39);
        Rectangle menu = new Rectangle(500,30, 150, 40);
        if(handler.getMouse().apasat_stanga() && menu.contains(handler.getMouse().getX(), handler.getMouse().getY())){
            State.setState(handler.getGame().menuState);
            Sound.sound2.stop();
        }
        if(handler.getMouse().apasat_stanga() && sound.contains(handler.getMouse().getX(), handler.getMouse().getY())){
           Sound.sound2.stop();
        }
        for (int i = 0; i < lives; i++) {
            g.drawImage(Assets.Life, i*48, 0, null);
        }

    }

    @Override
    public void die() {
        lives--;
        if(lives<=0) {
            dead = true;
            Sound.sound2.stop();
            Sound.sound3.play();
        }
    }

    @Override
    public void Update() throws InvalidFileException {


        X = 0;
        Y = 0;
        if (handler.getKeyManager().up) {
            direction = "up";
            Y -= Speed;
        }
        if (handler.getKeyManager().down) {
            direction = "down";
            Y += Speed;
        }
        if (handler.getKeyManager().left) {
            direction = "left";
            X -= Speed;
        }
        if (handler.getKeyManager().right) {
            direction = "right";
            X += Speed;

        }
        move();
        EatDots();
        checkLevel();

    }

    public void EatDots() {

        DatabaseHandler app=new DatabaseHandler();
        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 30;
        ar.width = arSize;
        ar.height = arSize;

        if (handler.getKeyManager().up) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize / 2 + 30;
        } else if (handler.getKeyManager().down) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height - 40;
        } else if (handler.getKeyManager().left) {
            ar.x = cb.x - arSize + 60;
            ar.y = cb.y + cb.height / 2 - arSize / 2 + 20;
        } else if (handler.getKeyManager().right) {
            ar.x = cb.x + cb.width - 40;
            ar.y = cb.y + cb.height / 2 - arSize / 2 + 20;
        } else {
            ar.x = cb.x - arSize + 40;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }


        for (Entity e : handler.getMap().getEntityManager().getEntities()) {
            if (e.equals(this)) {
                continue;
            }

            if (e.getCollisionBounds(0, 0).intersects(ar)) {
                if (e instanceof Dot) {
                    e.setActive(false);
                    handler.getGame().setScore(10); // la scorul actual se adauga 10 puncte
                    return;

                }
            if(e instanceof BlueGhost || e instanceof RedGhost || e instanceof OrangeGhost || e instanceof PinkGhost)
            {
                k--;
                if(k%10==0) {
                    if(handler.getGame().getScore()-50>=0)
                        handler.getGame().setScore(-50);
                    else
                        handler.getGame().setScore(-handler.getGame().getScore());
                    die();
                    app.insert(handler.getGame().getLevel(),lives,handler.getGame().getScore());

                }
                if(dead==true) {
                    State.setState(handler.getGame().menuState);
                    app.insert(handler.getGame().getLevel(),lives,handler.getGame().getScore());
                }
            }


            }
        }
    }

    private void checkLevel() throws InvalidFileException {
        DatabaseHandler app=new DatabaseHandler();
        int count = 0;
        for(Entity e : handler.getMap().getEntityManager().getEntities()){
            if(e instanceof Dot)
                count++; // numar punctele ramase de pe tabla
        }

        if(count == 0) // daca nu mai sunt puncte, inseamna ca nivelul a fost castigat si verific la ce nivel ma aflu ca sa trec la urmatorul
        {
            level = handler.getGame().getLevel();

            if(level== 1)
            {

                handler.getGame().setLevel(2);
                level = 2;
                gameState = new GameState(handler , level);
                State.setState(gameState);
                app.insert(2,5,handler.getGame().getScore());

            }
            else
                if(level==2)
                {

                    handler.getGame().setLevel(3);
                    level = 3;
                    gameState = new GameState(handler , level);
                    State.setState(gameState);
                    app.insert(3,5,handler.getGame().getScore());
                }
                else
                    if(level==3)
                    {
                        handler.getGame().setLevel(4);
                        level = 4;
                        gameState = new GameState(handler , level);
                        State.setState(gameState);
                        app.insert(4,5,handler.getGame().getScore());
                    }
            else
            {
                winner = true;
                handler.getGame().setLevel(1);
                app.insert(1,5,handler.getGame().getScore());
                State.setState(handler.getGame().menuState);
            }
        }
    }


}