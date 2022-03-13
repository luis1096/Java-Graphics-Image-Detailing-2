package Assignment2;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import javax.imageio.ImageIO;
/*
 * AUTHOR: Luis Oliveros
 * PID: 6131616
 */
public class GraphDisplay extends JPanel implements MouseMotionListener, MouseListener
{
    GeometricObject[] gArray; //geometric objects
    private BufferedImage image; //background image
    String description; //description of map element
    Point begin; //initial point of the selection rectangle
    Rectangle selectionRectangle; //rectangle that the user draws dynamically

    /**
     * Parameterized constructor.
     */
    public GraphDisplay(int width, int height, GeometricObject[] g)
    {
        this.gArray = g;
        begin = null;
        selectionRectangle = null;
        addMouseMotionListener(this);
        addMouseListener(this); 
        
        try
        {
            image = ImageIO.read(new File("disney.PNG"));
        } 
        catch (IOException ex)
        {
            System.out.println("Image file not found!");
        }        
        
        description = "";
        Dimension d = new Dimension(width, height);
        setPreferredSize(d);
    }
    

    /**
     * Continuously redefines the second corner of the selection rectangle 
     * as the user drags the mouse.
     * 
     * @param e 
     */
    public void mouseDragged(MouseEvent e)
    {	
    	Point end = new Point(e.getX(), e.getY());
        selectionRectangle = new Rectangle(begin, end);
        repaint();
    }
   
    /**
     * Captures mouse movement events.
     * 
     * @param e contains current location of mouse
     */
    public void mouseMoved(MouseEvent e)
    {
    	 
    }
    
    
    /**
     * Paints this panel; the system invokes it every time
     * it deems necessary to redraw the panel.
     */
    @Override
    public void paint(Graphics g)
    {        
        super.paint(g); //clears window
        
        //draws background image
        Dimension d = getSize();
        g.drawImage(image, 0, 0, d.width, d.height, this);
        
       /* 
        //outputs description
        g.setColor(new Color(64, 64, 64, 128));
        g.fillRoundRect(29, 75, 150, 30, 5, 5);
        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.BOLD, 12));
        g.drawString(description, 35, 96);
        */
      
 
        //draws geometric objects
        if (selectionRectangle != null)
            selectionRectangle.draw(g);
        
        for (GeometricObject e:gArray)
        {
            e.draw(g); //invokes object's draw method through polymorphism
        }

    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

    /**
     * The first corner of the selection rectangle is set in this method.
     * 
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e)
    {
        begin = new Point(e.getX(), e.getY());
    }


    /**
     * The final value of the second corner of the selection rectangle is set
     * in this method (the first corner was set in mousePressed); range search
     * is then performed.
     * 
     * @param e 
     */
    @Override
    public void mouseReleased(MouseEvent e)
    { 
        Point end = new Point(e.getX(), e.getY());
        selectionRectangle = new Rectangle(begin, end);
        begin = null;
        
        Point[] pArray = Algorithms.inRectangle(gArray, selectionRectangle);
        
        for(int i=0; i<pArray.length; i++)
        {
            pArray[i].setInteriorColor(Color.green);
        }        
        
        repaint();
        
     //getting data for each rec polygon object
   	 int data[] = new int[pArray.length];
   	 
   	 if(data.length == 0)
   	 {
    	JOptionPane.showMessageDialog(null, "No information Selected" , "Output", JOptionPane.PLAIN_MESSAGE);
   	 }
   	 else
   	 {
	   	 for(int i = 0; i <pArray.length; i++)
         {
              data[i] = ((RecPolygon)gArray[i]).getRecPolygonData();
         }
   	 
	   	 //get minimum data
	   	 int min = data[0]; 
	   	 for(int i = 0; i <pArray.length; i++)
         {
             if(data[i] < min) 
             {
            	 min = data[i];   	 
             }
         }
	   	 
	   	 //get max data
	   	 int max = data[0];
	   	 for(int i = 0; i <pArray.length; i++)
         {
             if(data[i] > max) 
             {
            	 max = data[i];   	 
             }
         }
   	 
	   	 //get average data and sum of total data
	   	 int avg = 0;
	   	 int sum = 0;
	   	 for(int i = 0; i <pArray.length; i++) 
         {
            sum += sum + data[i];
         }
	   	 avg = sum / pArray.length;
   	 
        
        String str = "SUMMARY" + 
        "\nNum of Attractions Picked: " + pArray.length +
        "\nMin People In Line: " + min +
        "\nAverage People In Line: " + avg +
        "\nMax People In Line: " + max +
        "\nTotal People In Line: " + sum;
        
        
        JOptionPane.showMessageDialog(null, str, "Output", JOptionPane.PLAIN_MESSAGE);
   	 }
  }
    

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
