package Assignment2;
import javax.swing.*;
/*
 * AUTHOR: Luis Oliveros
 * PID: 6131616
 */

public class FrameDisplay extends JFrame
{   
    private GraphDisplay panel;

    /**
     * Creates an initializes the window frame.
     * 
     * @param width frame width
     * @param height frame height
     * @param g geometric objects to be depicted in this frame
     */
    public FrameDisplay(int width, int height, GeometricObject[] g)
    {
        setTitle("Disney Hollywood Studios Map");
        setSize(width, height);
        //setResizable(false);  
 
        panel = new GraphDisplay(width, height, g);
        add(panel);
        pack(); //sizes the frame so that all its contents (panel in this case) 
        //are at or above their preferred sizes
    }
}
