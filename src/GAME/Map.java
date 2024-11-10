package GAME;

import GAME.Entities.MovingCreatures.Player;
import GAME.Entities.EntityManager;
import GAME.Tiles.Tile;

import java.awt.*;


public class Map {
    private Handler handler;
    private int width, height;
    private int X,Y;
    private int [][]map; // in map o sa am cate un element intreg care reprezinta id-ul tile-ului care se afla pe tabla in acea pozitie

    private EntityManager entityManager;
    public Map(Handler handler,String path) throws InvalidFileException {
        this.handler=handler;
        entityManager=new EntityManager(handler,new Player(handler,100,100));
        loadMap(path);

        entityManager.getPlayer().setx(X);
        entityManager.getPlayer().sety(Y);

    }
    private void loadMap(String path) throws InvalidFileException {
        String file=ReadMap.loadFile(path);
        String[] elemente=file.split("\\s+");
        width=ReadMap.ToInt(elemente[0]); // in elemente pe pozitia 0 am primul numar din map1=width
        height=ReadMap.ToInt(elemente[1]); //height
        X=ReadMap.ToInt(elemente[2]); // pozitia initiala a jucatorului
        Y=ReadMap.ToInt(elemente[3]);

        map=new int[width][height];

        for(int i=0;i<width;i++)
            for(int j=0;j<height;j++)
                map[i][j]=ReadMap.ToInt(elemente[(i+j*width)+4]);
    }
    public void Update() throws InvalidFileException {
        entityManager.Update();
    }

    public Tile getTile(int i, int j)
    {
        Tile t=Tile.tiles[map[i][j]]; //in vectorul tiles din clasa Tile am id-urile fiecarui tile, daca x si y (coordonatele unui tile
        //cu care se apeleaza functia exista pe harta, atunci se cauda id-ul tile-ului cu acele coordonate si se pune in map[i][j]
        if(t==null) // daca primesc niste coordonate care nu sunt valabile in harta atunci returnez by default un tile oarecare
            return Tile.gateLeftTile;
        return t;
    }
    public void Draw(Graphics g)
    {
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                getTile(i,j).Draw(g,i*Tile.TILE_WIDTH,j*Tile.TILE_HEIGHT);

            }
        }
        entityManager.Draw(g);

    }

    public EntityManager getEntityManager() {
        return entityManager;
    }


}
