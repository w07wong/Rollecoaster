import javax.swing.*;
/**
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoasterPath extends JComponent
{
    private int distance; //distance from last critical point;
    private int height;
    private int radius;
    
    public CoasterPath(int d, int h, int r)
    {
       distance = d;
       height = h;
       radius = r;
    }
}
