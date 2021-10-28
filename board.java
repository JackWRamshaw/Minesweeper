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
        this.setSize(800,800);
        this.setLayout(layout);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public int checkNeighbours(int tilenum){
        int i = 0;

        for (int k = (tilenum - 11); k < (tilenum + 10); k++){
            if (k != tilenum){
                if (tiles[k].checkBomb() == true){
                    i++;
                }
            }
        }

        return i;

    }
}
