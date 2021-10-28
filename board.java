import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class board extends JFrame {
    private tile[] tiles = new tile[100];
    private GridLayout layout = new GridLayout(10, 10);
    private Random rand = new Random();
    private int upperbound = 100;

    public board(){

        for (int i = 0; i < 100; i++){
            tiles[i] = new tile(this, i);
        }
        for (int j = 0; j < 30; j++){
            int int_random = rand.nextInt(upperbound);
            tiles[int_random].addBomb();
        }
        this.setSize(1920, 1080);
        this.setLayout(layout);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public int checkNeighbours(int tilenum){
        int i = 0;
        if(tilenum % 10 == 0 || tilenum == 0){
            if (checkTile(tilenum-10) == true) i++; // top
            if (checkTile(tilenum-9) == true) i++; // top right
            if (checkTile(tilenum+1) == true) i++; // right
            if (checkTile(tilenum+10) == true) i++; // bot
            if (checkTile(tilenum+11) == true) i++; // bot right
            return i;
        }

        else if ((tilenum+1) % 10 == 0){
            if (checkTile(tilenum-11) == true) i++; // top left
            if (checkTile(tilenum-10) == true) i++; // top
            if (checkTile(tilenum-1) == true) i++; // left
            if (checkTile(tilenum+9) == true) i++; // bot left
            if (checkTile(tilenum+10) == true) i++; // bot
            return i;
        }

        if (checkTile(tilenum-11) == true) i++; // top left
        if (checkTile(tilenum-10) == true) i++; // top
        if (checkTile(tilenum-9) == true) i++; // top right
        if (checkTile(tilenum-1) == true) i++; // left
        if (checkTile(tilenum+1) == true) i++; // right
        if (checkTile(tilenum+9) == true) i++; // bot left
        if (checkTile(tilenum+10) == true) i++; // bot
        if (checkTile(tilenum+11) == true) i++; // bot right
        return i;
    }

    public boolean checkTile(int tilenum){
        if (tilenum < 100 && tilenum >= 0){
            if (tiles[tilenum].checkBomb() == true){
                return true;
            }
            else return false;
        }
        else return false;
    }
}
