package GAME.Tiles;

import GAME.Graphics.Assets;

import java.awt.*;

public class left_down_cornerTile extends Tile {

    public left_down_cornerTile(int id)
    {
        super(Assets.left_down_corner, id);
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

