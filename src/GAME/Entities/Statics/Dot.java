package GAME.Entities.Statics;

import GAME.Graphics.Assets;
import GAME.Handler;
import GAME.Tiles.Tile;

import java.awt.*;

public class Dot extends StaticEntity{
    protected int count;
    public Dot(Handler handler, double x, double y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
        count=1;
        solidArea.x = 10;
        solidArea.y = (int) ( height / 1.5f );
        solidArea.width = width - 20;
        solidArea.height = (int) ( height - height / 1.5f);
    }

    @Override
    public void Update() {

    }

    @Override
    public void die(){

    }
    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.dot,(int)x,(int)y,width,height,null);
    }
}
