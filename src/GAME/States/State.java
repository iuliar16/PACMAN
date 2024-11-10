package GAME.States;

import GAME.Handler;
import GAME.InvalidFileException;

import java.awt.*;

public abstract class State {
    public static State currentState=null;
    protected Handler handler;
    public static void setState(State state)
    {
        State.currentState=state;
    }
    public static State getState()
    {
        return currentState;
    }
    public State(Handler handler){
        this.handler=handler;
    }
    public abstract void Update() throws InvalidFileException;
    public abstract void Draw(Graphics g);

}
