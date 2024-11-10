package GAME.Entities;

import GAME.Handler;
import GAME.InvalidFileException;

import java.awt.*;


public abstract class Entity {

    protected double x,y;
    public String direction="right";
    protected Handler handler;
    protected int width, height;
    protected Rectangle solidArea;
    protected boolean active=true;



    public Entity(Handler handler,double x, double y, int width, int height) {
        this.handler=handler;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        solidArea=new Rectangle(0,0,width,height);

    }

    public void sety(double y)
    {
       this.y=y;
    }
    public void setx(double x)
    {
        this.x=x;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public abstract void Update() throws InvalidFileException;
    public abstract void Draw(Graphics g);
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    public abstract void die();


    public Rectangle getCollisionBounds(float xOffset , float yOffset){
        return new Rectangle( (int)( x + solidArea.x + xOffset ) , (int) ( y + solidArea.y + yOffset) ,solidArea.width , solidArea.height);
    }

}