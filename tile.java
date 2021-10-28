import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

public class tile implements ActionListener{

    private JButton button;
    private int location;
    private boolean bomb;
    private int surroundingBombs;
    private board board;


    public tile(board b, int tilenum){
        this.board = b;
        this.button = new JButton();
        this.location = tilenum;
        this.bomb = false;
        button.addActionListener(this);
        button.setForeground(Color.white);
        //button.setText(Integer.toString(tilenum));
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
        if (bomb == true){
            button.setText("BOMB");
            button.setBackground(Color.red);
        }
        else{
            surroundingBombs = board.checkNeighbours(location);
            button.setText(Integer.toString(surroundingBombs));
            switch (surroundingBombs){
                case 0:
                button.setBackground(Color.black);
                    break;
                case 1:
                    button.setBackground(Color.blue);
                    break;
                case 2:
                    button.setBackground(Color.cyan);
                     break;
                case 3:
                    button.setBackground(Color.darkGray);
                    break;
                case 4:
                    button.setBackground(Color.gray);
                    break;
                case 5:
                    button.setBackground(Color.green);
                    break;
                case 6:
                    button.setBackground(Color.lightGray);
                    break;
                case 7:
                    button.setBackground(Color.magenta);
                    break;
                case 8:
                    button.setBackground(Color.orange);
                    break;
            }
        }
    }
}