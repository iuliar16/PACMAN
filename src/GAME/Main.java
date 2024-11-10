package GAME;

import java.sql.*;
import java.sql.Statement;

public class Main {
    public static void createDb() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:joc.db");
            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS GAME " +
                    "(LEVEL INT , "+
                    "LIVES INT, "+
                    "CURRENT_SCORE INT) ";

            stmt.execute(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    public static void main(String[] args){

        DatabaseHandler app=new DatabaseHandler();
        createDb();
        Game game=new Game("Game", 864, 672);
        game.StartGame();
        Sound.sound1.play();
        app.insert(1,5,0);

    }

}
