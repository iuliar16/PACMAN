package GAME.Tiles;

import GAME.Graphics.Assets;

import java.awt.*;

public class Down extends Tile{
    public Down(int id)
    {
        super(Assets.down, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
    public int getId()
    {
        return id;
    }
    public void Update()
    {

    }
    public void Draw(Graphics g, int x, int y)
    {
        g.drawImage(img,x,y,TILE_WIDTH,TILE_HEIGHT,null);
    }

}