package GAME.Tiles;

import GAME.Graphics.Assets;

import java.awt.*;

public class Block extends Tile{
    public Block(int idd) {
        super(Assets.block, idd);
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
