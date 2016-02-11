import javax.swing.*;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
   public static void main(String args[])
   {
       JFrame frame = new JFrame("Rollercoaster");
       frame.setSize(500,500);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       Coaster c = new Coaster(1,1,1);
       
       frame.add(c);
       frame.setVisible(true);
   }
}
