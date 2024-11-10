package GAME.Entities.MovingCreatures;

import GAME.Graphics.Assets;
import GAME.Handler;
import GAME.Tiles.Tile;

import java.awt.*;

public class RedGhost extends Creature {

    private int speed;
    public RedGhost(Handler handler, double x, double y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
        if(handler.getGame().getLevel()==1)
            speed=2;
        else
        if(handler.getGame().getLevel()==2)
            speed=2;
        else
        if(handler.getGame().getLevel()==3)
            speed=3;
        else
            speed=4;
    }

    @Override
    public void Update() {
        if(speed < 0){ //merg la stanga
            int ty = (int) (y + solidArea.y) / Tile.TILE_HEIGHT;
            if(!collision((int) (x + solidArea.x )/Tile.TILE_WIDTH ,ty ) &&
                    !collision( (int) (x + solidArea.x + solidArea.width - 1)/Tile.TILE_WIDTH , ty)){
                speed = speed;
            }else{
                speed = -speed;
            }
        }else if (speed > 0){
            int ty = (int) (y + solidArea.height + solidArea.y) / Tile.TILE_HEIGHT;
            if(!collision((int) (x + solidArea.x )/Tile.TILE_WIDTH , ty ) &&
                    !collision((int) (x + solidArea.x + solidArea.width - 1)/Tile.TILE_WIDTH,ty )){
                speed = speed;
            }else{
                speed = -speed;
            }
        }

            y += speed;
            x -= speed;


    }



    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.RedGhost,(int) x , (int) y , width , height , null);
    }

    @Override
    public void die() {

    }
}
