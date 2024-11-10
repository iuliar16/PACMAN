package GAME.Tiles;


import GAME.Graphics.Assets;

import java.awt.*;

public class DotTile extends Tile {
    private boolean eaten;
    public   DotTile(int idd) {
        super(Assets.dot, idd);
    }

    @Override
    public boolean IsSolid()
    {
        return false;
    }
    public int getId()
    {
        return id;
    }
    public void Update()
    {

    }
    public void Draw(Graphics g,int x,int y)
    {
        g.drawImage(img,x,y,TILE_WIDTH,TILE_HEIGHT,null);
    }

}