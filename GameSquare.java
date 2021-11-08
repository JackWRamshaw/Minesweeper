import javax.swing.*;
import java.awt.Color;

/**
 * This class provides a representation of a single game square.
 * The class is abstract, and should be extended to provide domain 
 * specific functionality.
 * @author Jack Ramshaw
 */
public abstract class GameSquare extends JButton
{

	/** The x co-ordinate of this square. **/
	private int xLocation;

	/** The y co-ordinate of this square. **/
	private int yLocation;

    private boolean isBomb;

	/**
	 * Create a new GameSquare, which can be placed on a GameBoard.
	 * 
	 * @param x the x co-ordinate of this square on the game board.
	 * @param y the y co-ordinate of this square on the game board.
	 */
	public GameSquare(int x, int y)
	{
		this.xLocation = x;
		this.yLocation = y;
        this.setBorder(null);

	}

	/**
	 * Changes the image displayed by this square to match the status of the
	 * wallLeft, wallRight, WallUp, WallDown and highlighted variables.
	 */	
	private void updateImage()
	{

	}

    /**
     * Determines the location of this square on the board
     * @return the x coordinate of this square.
     */
    public int getXLocation()
    {
        return xLocation;
    }

    /**
     * Determines the location of this square on the board
     * @return the x coordinate of this square.
     */
    public int getYLocation()
    {
        return yLocation;
    }

    public void setBomb(Boolean n)
    {
        if(n){
            this.isBomb = true;
            return;
        }
        this.isBomb = false;
    }

    public boolean getBomb()
    {
        if(isBomb){
            return true;
        }
        return false;
    }

	/**
	 * A method that is invoked when a user clicks on this square.
	 * 
	 */	
    public abstract void leftClicked();
    
    /**
	 * A method that is invoked when a user clicks on this square.
	 * 
	 */	
	public abstract void rightClicked();

	/**
	 * A method that is invoked when a reset() method is called on GameBoard.
	 * 
	 * @param n An unspecified value that matches that provided in the call to GameBoard reset()
	 */
	public abstract void reset(int n);
}
