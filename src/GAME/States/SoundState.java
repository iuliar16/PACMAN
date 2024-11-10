package GAME.States;

import GAME.Graphics.Assets;
import GAME.Handler;
import GAME.Sound;

import java.awt.*;

public class SoundState extends State{
    public SoundState(Handler handler) {
        super(handler);
    }

    @Override
    public void Update() {
        Rectangle yes = new Rectangle(56,550, 240, 96);
        Rectangle no = new Rectangle(570,550, 240, 96);
        if(handler.getMouse().apasat_stanga() && no.contains(handler.getMouse().getX(), handler.getMouse().getY())){
            State.setState(handler.getGame().menuState);
        }
        if(handler.getMouse().apasat_stanga() && yes.contains(handler.getMouse().getX(), handler.getMouse().getY())){
            Sound.sound1.Sound_off=1;
            Sound.sound2.Sound_off=1;
            Sound.sound3.Sound_off=1;
            Sound.sound1.stop();
            State.setState(handler.getGame().menuState);
        }
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.startMenu, 0, 0, handler.getGame().getWidth(), handler.getGame().getHeight(), null);
        g.setColor(Color.black);
        g.setFont(new Font("Sergiue", Font.BOLD, 45));
        g.drawString("Do you want to turn off the sound?", 60, 450);
        g.drawImage(Assets.yes, 56 , 550 , null);
        g.drawImage(Assets.no, 570 , 550 , null);
    }
}
