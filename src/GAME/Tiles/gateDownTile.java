package GAME.Tiles;


import GAME.Graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class gateDownTile extends Tile {

    public gateDownTile(int idd) {
        super(Assets.gateDown, idd);
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
    public void Draw(Graphics g,int x,int y)
    {
        g.drawImage(img,x,y,TILE_WIDTH,TILE_HEIGHT,null);
    }
}