package GAME.Entities.MovingCreatures;

import GAME.Entities.Entity;
import GAME.Handler;
import GAME.Tiles.Tile;


public abstract class Creature extends Entity {

    public static final int defaultWidth = 48;
    public static final int defaultHeight = 48;
    public static final int defaultSpeed = 6;
    protected double X,Y;// la x si y (coordonatele personajului). atunci cand se misca, adauga X SI Y;
    protected int Speed;

    public Creature(Handler handler, double x, double y, int width, int height) {
        super(handler, x, y, width, height);
        this.Speed = defaultSpeed;
        X = Y = 0;

    }

    public void move() {
        Movement_X();
        Movement_Y();
    }

    public boolean collision(int x, int y) {
        return handler.getMap().getTile(x, y).IsSolid();
    }

    public void Movement_X() {
        if (X > 0) // jucatorul se misca la dreapta
        {
            int tx = (int) (x + X + solidArea.x + solidArea.width) / Tile.TILE_WIDTH;
            // la pozitia actuala x adaug X= unde vrem sa miscam personajul si apoi trebuie sa ajungem la marginea zonei solide din
            //interiorul personajului -> rezultatul e in pixeli deci il impart la dimensiuna unui tile
            if (!collision(tx, (int) (y + solidArea.y) / Tile.TILE_HEIGHT) //la coordonata actuala y adaugam solidArea.y si obtinem
                   // partea din dreapta sus a regiunii solide
                    && !collision(tx, (int) (y + solidArea.y +solidArea.height) / Tile.TILE_HEIGHT)) { //aici obtinem partea din dreapta
                //jos a regiunii solide
                x += X;
            }
        } else
            if (X < 0) //la stanga
            {
            int tx = (int) (x + X + solidArea.x) / Tile.TILE_WIDTH;
            if (!collision(tx, (int) (y + solidArea.y) / Tile.TILE_HEIGHT) &&//coltul din stanga sus a regiunii solide
                    !collision(tx, (int) (y +solidArea.y + solidArea.height) / Tile.TILE_HEIGHT))//coltul din stanga jos
                x += X;
        }
    }

    public void Movement_Y()
    {
        if(Y < 0)
        {//Up
            int ty = (int) (y + Y + solidArea.y) / Tile.TILE_HEIGHT;
            if(!collision((int) (x + solidArea.x) / Tile.TILE_WIDTH, ty) &&
                    !collision((int) (x +solidArea.x + solidArea.width) / Tile.TILE_WIDTH, ty)){
                y += Y;
            }
        }else if(Y > 0){//Down
            int ty = (int) (y + Y + solidArea.y + solidArea.height) / Tile.TILE_HEIGHT;

            if(!collision((int) (x + solidArea.x) / Tile.TILE_WIDTH, ty) &&
                    !collision((int) (x + solidArea.x + solidArea.width) / Tile.TILE_WIDTH, ty)){
                y +=Y;
            }
        }
    }


    public double getX() {
        return X;
    }

    public void setX(double X) {
        this.X =X;
    }

    public double getY() {
        return Y;
    }

    public void setY(double Y) {
        this.Y = Y;
    }


}
