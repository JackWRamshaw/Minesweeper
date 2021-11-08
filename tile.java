import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

public class tile extends GameSquare
{

    private GameBoard board;
    private boolean flag;
    private int surroundingBombs;
    private boolean isOpen;


    public tile(int x, int y, GameBoard board)
    {
        super(x, y);
        this.board = board;
        this.isOpen = false;
    }

    public void revealBomb()
    {
        this.setText("Bomb");
    }

    public void leftClicked()
    {
        if (flag) return;
        this.isOpen = true;
        if (getBomb())
        {
            this.setText("BOMB");
            this.setBackground(Color.red);
        }
        else
        {
        surroundingBombs = checkNeighbours(getXLocation(), getYLocation());
        this.setText(Integer.toString(surroundingBombs));
        switch (surroundingBombs)
        {
            case 0:
            this.setBackground(Color.black);
                break;
            case 1:
                this.setBackground(Color.blue);
                break;
            case 2:
                this.setBackground(Color.cyan);
                break;
            case 3:
                this.setBackground(Color.darkGray);
                break;
            case 4:
                this.setBackground(Color.gray);
                break;
            case 5:
                this.setBackground(Color.green);
                break;
            case 6:
                this.setBackground(Color.lightGray);
                break;
            case 7:
                this.setBackground(Color.magenta);
                break;
            case 8:
                this.setBackground(Color.orange);
                break;
            }
        }
    }

    public void rightClicked()
    {
        if(flag){
            flag = false; 
            this.setText("");
        } 
        else{
            flag = true;
            this.setText("Flag");
        } 
    }

    public int checkNeighbours(int x, int y)
    {
        int i = 0;
        
        for (int k = x-1; k < x+2; k++)
        {
            if (k < 0) break;
            for (int n = y-1; n < y+2; n++)
            {
                if (n < 0) break;
                if (board.getSquareAt(k, n).getBomb())
                {
                    i++;
                }
            }
        }
        return i;
    }

    public void reset(int n)
    {

    }
}