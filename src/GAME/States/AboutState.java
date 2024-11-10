package GAME.States;

import GAME.DatabaseHandler;
import GAME.Graphics.Assets;
import GAME.Handler;
import GAME.InvalidFileException;
import GAME.Sound;

import java.awt.*;

public class AboutState extends State{
    public AboutState(Handler handler) {
        super(handler);
    }

    @Override
    public void Update() throws InvalidFileException {
        DatabaseHandler app=new DatabaseHandler();
        Rectangle level1 = new Rectangle(56,300, 240, 96);
        Rectangle level2 = new Rectangle(56,400, 240, 96);
        Rectangle level3 = new Rectangle(570,250, 240, 96);
        Rectangle level4 = new Rectangle(570,400, 240, 96);
        Rectangle start_menu = new Rectangle(313,500, 240, 96);
        if(handler.getMouse().apasat_stanga() && level1.contains(handler.getMouse().getX(), handler.getMouse().getY())) {

            app.insert(1,5,0);
            handler.getGame().setLevel(1);
            handler.getGame().setScore(-handler.getGame().getScore());
            State.setState(new GameState(handler,1));
            if(Sound.sound1.isActive())
                Sound.sound1.stop();
            Sound.sound2.loop();
        }
        if(handler.getMouse().apasat_stanga() && level2.contains(handler.getMouse().getX(), handler.getMouse().getY())) {
            app.insert(2,5,0);
            handler.getGame().setLevel(2);
            handler.getGame().setScore(-handler.getGame().getScore());
            State.setState(new GameState(handler,2));
            if(Sound.sound1.isActive())
                Sound.sound1.stop();
            Sound.sound2.loop();
        }
        if(handler.getMouse().apasat_stanga() && level3.contains(handler.getMouse().getX(), handler.getMouse().getY())) {
            app.insert(3,5,0);
            handler.getGame().setLevel(3);
            handler.getGame().setScore(-handler.getGame().getScore());
            State.setState(new GameState(handler,3));
            if(Sound.sound1.isActive())
                Sound.sound1.stop();
            Sound.sound2.loop();
        }
        if(handler.getMouse().apasat_stanga() && level4.contains(handler.getMouse().getX(), handler.getMouse().getY())) {
            app.insert(4,5,0);
            handler.getGame().setLevel(4);
            handler.getGame().setScore(-handler.getGame().getScore());
            State.setState(new GameState(handler,4));
            if(Sound.sound1.isActive())
                Sound.sound1.stop();
            Sound.sound2.loop();
        }
        if(handler.getMouse().apasat_stanga() && start_menu.contains(handler.getMouse().getX(), handler.getMouse().getY())) {
            State.setState(handler.getGame().menuState);
        }
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.levels, 0, 0, handler.getGame().getWidth(), handler.getGame().getHeight(), null);
        g.drawImage(Assets.level1, 56 , 250 , null);
        g.drawImage(Assets.level2, 56 , 400 , null);
        g.drawImage(Assets.level3, 570 , 250 , null);
        g.drawImage(Assets.level4, 570 , 400 , null);
        g.drawImage(Assets.start_menu_button, 313 , 500 , null);
    }
}
