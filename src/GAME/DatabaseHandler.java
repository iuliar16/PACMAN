package GAME;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler {

    private static DatabaseHandler dbIsntance;
    private static Connection c ;
    private Connection connect() throws InvalidDatabaseConnection {
        c = null;
        try {
            if(c==null)
            {Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:joc.db");}

        } catch (Exception e) {
            throw new InvalidDatabaseConnection("Invalid Database Connection");

        }
        return c;
    }

    private DatabaseHandler getInstance(){
        if(dbIsntance==null){
            dbIsntance= new DatabaseHandler();
        }
        return dbIsntance;
    }
   public void insert(int level,int lives,int current_score) {
        String sql = "INSERT INTO GAME (LEVEL,LIVES,CURRENT_SCORE) VALUES(?,?,?)";
        try {
            Connection con = this.getInstance().connect();
            PreparedStatement pstmt = c.prepareStatement(sql);
            pstmt.setInt(1, level);
            pstmt.setInt(2, lives);
            pstmt.setInt(3, current_score);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (InvalidDatabaseConnection e) {
            e.printStackTrace();
        }

    }

}