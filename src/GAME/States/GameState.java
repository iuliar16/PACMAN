package GAME.States;

import GAME.Entities.Statics.Dot;
import GAME.Handler;
import GAME.InvalidFileException;
import GAME.Levels;
import GAME.Map;

import java.awt.*;

public class GameState extends State{
    private Map map;
    private Dot dot;
    private Levels harta;
    public GameState(Handler handler,int level) throws InvalidFileException {
        super(handler);
        harta = new Levels(handler ,"res/maps/" , level);
    }

    @Override
    public void Update() throws InvalidFileException {
        harta.Update();

    }

    @Override
    public void Draw(Graphics g) {
       harta.Draw(g);
    }


}
