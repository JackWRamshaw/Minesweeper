import java.util.Random;

public class Driver
{
    public static void main(String args[])
    {
        int width = 10;
        int height = 10;

        GameBoard b = new GameBoard("MineSweeper", width, height, "tile");

        int level = 1;

        try{
            level = Integer.parseInt(args[0]);
        }catch (Exception e) {}

        Random generator = new Random(level);
        int bombCount = 30 + ((int)level / 10);

        for (int i=0; i<bombCount; i++)
        {
            int x = generator.nextInt(width);
            int y = generator.nextInt(height);

            GameSquare s;
            s = b.getSquareAt(x,y);
            if (s != null)
                s.setBomb(true);
        }

    }
}