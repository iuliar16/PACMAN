package GAME.Tiles;

import GAME.Graphics.Assets;

import java.awt.*;

public class right_up_cornerTile extends Tile {

    public right_up_cornerTile(int id)
    {
        super(Assets.right_up_corner, id);
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

