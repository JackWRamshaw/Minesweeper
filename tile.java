import java.awt.event.*;
import javax.swing.*;

public class tile implements ActionListener{

    private JButton button;
    private int location;
    private boolean bomb;


    public tile(JFrame board, int tilenum){
        this.button = new JButton();
        this.location = tilenum;
        this.bomb = false;
        button.addActionListener(this);
        button.setText(Integer.toString(tilenum));
        board.add(button);
    }

    public void addBomb(){
        bomb = true;
    }
    public void revealBomb(){
        button.setText("Bomb");
    }

    public boolean checkBomb(){
        return bomb;
    }

    public int getLocation(){
        return location;
    }

    public void actionPerformed(ActionEvent e){
        
    }
}