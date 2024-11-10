
package GAME.States;


import java.awt.*;

import GAME.Graphics.Assets;
import GAME.Handler;
import GAME.InvalidFileException;
import GAME.Sound;


public class MenuState extends State {


    public MenuState(Handler handler)
    {
        super(handler);
    }


    @Override
    public void Update() throws InvalidFileException {
        Rectangle play = new Rectangle(56,400, 240, 96);
        Rectangle quit = new Rectangle(580,400, 240, 96);
        Rectangle about = new Rectangle(180,530, 240, 96);
        Rectangle sound = new Rectangle(480,530, 240, 96);
        if(handler.getMouse().apasat_stanga() && about.contains(handler.getMouse().getX(), handler.getMouse().getY())){
            State.setState(new AboutState(handler));
        }
        if(handler.getMouse().apasat_stanga() && sound.contains(handler.getMouse().getX(), handler.getMouse().getY())){
            State.setState(new SoundState(handler));
        }

        if(handler.getMouse().apasat_stanga() && play.contains(handler.getMouse().getX(), handler.getMouse().getY())){
            handler.getGame().setLevel(1);
            handler.getGame().setScore(-handler.getGame().getScore());
            State.setState(new GameState(handler,1));
            if(Sound.sound1.isActive())
                Sound.sound1.stop();
            Sound.sound2.loop();

        }
        if(handler.getMouse().apasat_stanga() && quit.contains(handler.getMouse().getX(), handler.getMouse().getY())){
            System.exit(0);
        }
    }
        @Override
        public void Draw (Graphics g)
        {
            g.drawImage(Assets.startMenu, 0, 0, handler.getGame().getWidth(), handler.getGame().getHeight(), null);
            g.drawImage(Assets.play, 56 , 400 , null);
            g.drawImage(Assets.quit, 580 , 400 , null );
            g.drawImage(Assets.about, 180 , 530 , null );
            g.drawImage(Assets.sound, 480 , 530 , null );

            if( handler.getMap().getEntityManager().getPlayer().dead){
                g.setColor(Color.orange);
                g.setFont(new Font("Sergiue", Font.BOLD, 50));
                g.drawImage(Assets.rectangle, 30 , 310 , null);
                g.drawString("You are killed! Your Score : " + handler.getGame().getScore(), 55, 350);
            }

            if( handler.getMap().getEntityManager().getPlayer().winner){
                g.setColor(Color.green);
                g.setFont(new Font("Sergiue", Font.BOLD, 40));
                g.drawImage(Assets.rectangle, 30 , 310 , null);
                g.drawString("You Won the Game! Your Score : " + handler.getGame().getScore(), 55, 350);
            }
        }
    }
