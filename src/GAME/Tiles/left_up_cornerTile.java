package GAME.Tiles;

import GAME.Graphics.Assets;

import java.awt.*;

public class left_up_cornerTile extends Tile {

    public left_up_cornerTile(int id)
    {
        super(Assets.left_up_corner, id);
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

