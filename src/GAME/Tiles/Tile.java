package GAME.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    public BufferedImage image;
    private static final int NO_TILES   = 300;
    public static Tile[] tiles          = new Tile[NO_TILES];
    public static final int TILE_WIDTH  = 48;
    public static final int TILE_HEIGHT = 48;

    protected BufferedImage img;
    protected final int id;
    public static Tile gateUpTile=new gateUpTile(0);
    public static Tile gateDownTile=new gateDownTile(1);
    public static Tile gateLeftTile=new gateLeftTile(2);
    public static Tile gateRightTile=new gateRightTile(3);
    public static Tile left_down_cornerTile=new  left_down_cornerTile(4);
    public static Tile left_up_cornerTile=new left_up_cornerTile(5);
    public static Tile right_down_cornerTile=new  right_down_cornerTile(6);
    public static Tile right_up_cornerTile=new right_up_cornerTile(7);
    public static Tile halfLeftTile=new halfLeftTile(8);
    public static Tile halfRightTile=new  halfRightTile(9);
    public static Tile  dot=new DotTile(10);

    public static Tile  squareUpTile=new squareUpTile(11);
    public static Tile  squareLeftTile=new squareLeftTile(12);
    public static Tile  squareRightTile=new  squareRightTile(13);
    public static Tile  squareDownTile=new squareDownTile(14);
    public static Tile  backgroundTile=new backgroundTile(15);
    public static Tile  PowerDot=new PowerDotTile(16);

    public static Tile right_up_corner2=new right_up_corner2(17);
    public static Tile right_down_corner2=new right_down_corner2(18);
    public static Tile left_down_corner2=new left_down_corner2(19);
    public static Tile left_up_corner2=new left_up_corner2(20);
    public static Tile up=new Up(21);
    public static Tile down=new Down(22);
    public static Tile left=new Left(23);
    public static Tile right=new Right(24);
    public static Tile block=new Block(25);




    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;
        tiles[id] = this;

    }

    public void Update()
    {

    }

    public void Draw(Graphics g, int x, int y)
    {

        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }


    public boolean IsSolid()
    {
        return false;
    }

    public int GetId()
    {
        return id;
    }
}

