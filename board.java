import javax.swing.*;
import java.awt.*;

public class board extends JFrame {
    private tile[] tiles = new tile[100];
    private GridLayout layout = new GridLayout(10, 10);

    board(){

        for (int i = 0; i < 100; i++){
            tiles[i] = new tile(this, i);
        }
        this.setSize(800,800);
        this.setLayout(layout);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
