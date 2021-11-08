import javax.swing.*;
import java.awt.*;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
import java.lang.reflect.*;

public class GameBoard extends JFrame 
{
    private JPanel boardPanel = new JPanel();

	private int boardHeight;
	private int boardWidth;
    private GameSquare[][] board; 
    private Constructor<?> makeSquare;

    public GameBoard(String title, int width, int height, String squareType)
    {

        super();

        try {
            Class<?> parameters[] = new Class<?>[] {int.class, int.class, GameBoard.class};
            Class<?> c = Class.forName(squareType);
            makeSquare = c.getConstructor(parameters);            
        } catch (Exception e)
        {
            System.out.println("Could not find a valid subclass of GameSquare called " + squareType);
            return;
        }

        this.boardWidth = width;
        this.boardHeight = height;

        this.board = new GameSquare[width][height];

        setTitle(title);
        setSize(1920, 1080);
        setContentPane(boardPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boardPanel.setLayout(new GridLayout(height, width));

        for (int y = 0; y<height; y++)
        {
            for (int x = 0; x<width; x++)
            {
                try
                {
                    board[x][y] = (GameSquare) makeSquare.newInstance(x, y, this);
                }
                catch (Exception e)
                {
                    System.out.println("Could not find a valid constructor" + squareType + "(int, int, GameBoard)");
                }

                board[x][y].addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e){
                        GameSquare s = (GameSquare) e.getSource();

                        if (e.getButton() == MouseEvent.BUTTON1)
                            s.leftClicked();
                        else
                            s.rightClicked();
                    }
                });

                boardPanel.add(board[x][y]);
            }

            setVisible(true);
        }
    }

    /**
	 * Returns the GameSquare instance at a given location. 
	 * @param x the x co-ordinate of the square requested.
	 * @param y the y co-ordinate of the square requested.
	 * @return the GameSquare instance at a given location if the x and y co-ordinates are valid - null otherwise. 
	 */
    public GameSquare getSquareAt(int x, int y)
    {
        if (x < 0 || x >= boardWidth || y < 0 || y >= boardHeight)
            return null;

        return board[x][y];
    }

    /**
	 * Calls the reset() method on all GameSqaures on this board.
	 * 
	 * @param n a value to pass as a parameter to each square.
	 */
    public void reset(int n)
    {
        for (int y = 0; y<boardHeight; y++)
            for (int x =0; x<boardWidth; x++)
                board[x][y].reset(n);
    }
}
