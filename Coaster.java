import javax.swing.*;
import java.util.*;
/**
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coaster extends JComponent
{
    private int numArcs;
    private int numLoops;
    private int numCorks;
    //1 arc = 1, 1 loop = 1, 1 corkscrew (3 3D loops) = 1;

    public static ArrayList<Integer> trackOrder = new ArrayList<>();

    public Coaster(int nArcs, int nLoops, int nCorks)
    {
        numArcs = nArcs;
        numLoops = nLoops;
        numCorks = nCorks;

        genOrder();
        System.out.println("Number of Tracks: " + trackOrder.size());
        for(int i = 0; i < trackOrder.size(); i++) System.out.println(i + ": " + trackOrder.get(i));
    }

    private void genOrder() //randomizes the order of the tracks
    {
        int totalPieces = numArcs + numLoops + numCorks;
        Random gen = new Random();

        trackOrder.add(0);
        numArcs--;
        totalPieces--;

        while(totalPieces > 0) //randomly arrange the coaster, default starts with one arc down
        {
            if(numArcs > 0 && numLoops > 0 && numCorks > 0) //all three options available
            {
                int num = gen.nextInt(3);
                trackOrder.add(num);
                switch(num)
                {
                    case 0: numArcs--; break;
                    case 1: numLoops--; break;
                    case 2: numCorks--; break;
                }
                totalPieces--;
            } else if (numArcs > 0 && numLoops > 0) //two options not used up
            {
                int num = gen.nextInt(2);
                trackOrder.add(num);
                switch(num)
                {
                    case 0: numArcs--; break;
                    case 1: numLoops--; break;
                }
                totalPieces--;
            } else if (numArcs > 0 && numCorks > 0) //two options not used up
            {
                int num = gen.nextInt(2);
                trackOrder.add(num);
                switch(num)
                {
                    case 0: numArcs--; trackOrder.add(0); break;
                    case 1: numCorks--; trackOrder.add(2); break;
                }
                totalPieces--;
            } else if (numLoops > 0 && numCorks > 0) //two options not used up
            {
                int num = gen.nextInt(2)+1;
                trackOrder.add(num);
                switch(num)
                {
                    case 1: numLoops--; break;
                    case 2: numCorks--; break;
                }
                totalPieces--;
            } else if(numArcs > 0) //one option left
            {
                for(int i = 0; i < numArcs; i++) 
                {
                    trackOrder.add(0);
                    numArcs--;
                }
                totalPieces--;
            }  else if(numLoops > 0) //one option left
            {
                for(int i = 0; i < numLoops; i++) 
                {
                    trackOrder.add(1);
                    numLoops--;
                }
                totalPieces--;
            }  else if(numCorks > 0) //one option left
            {
                for(int i = 0; i < numCorks; i++) 
                {
                    trackOrder.add(2);
                    numCorks--;
                }
                totalPieces--;
            }
        }
    }
}
