package Assignment2;
import javax.swing.*;
import java.awt.Color;
import java.util.*;
/*
 * AUTHOR: Luis Oliveros
 * PID: 6131616
 */

public class Assignment2Framework
{
    public static void main(String[] args)
    {
        new Assignment2Framework();
    }
    
    public Assignment2Framework()
    {          
        //Defining the geometric objects that represent the problem data
        RecPolygon[] rec = new RecPolygon[5];
        
        //frame size
        int frameWidth = 982;
        int frameHeight = 962;
        
        Point p = new Point(449, 532);
        Point p1 = new Point(449, 550);
        Point p2 = new Point(431, 550);
        Point p3 = new Point(431, 651);
        Point p4 = new Point(539, 651);  
        Point p5 = new Point(539, 643);
        Point p6 = new Point(564, 643);
        Point p7 = new Point(564, 637);
        Point p8 = new Point(575, 637);
        Point p9 = new Point(575, 594);
        Point p10 = new Point(567, 594);
        Point p11 = new Point(567, 582);
        Point p12 = new Point(539, 582); 
        Point p13 = new Point(539, 532);
        
        rec[0] = new RecPolygon();
        rec[0].addVertex(p);
        rec[0].addVertex(p1);
        rec[0].addVertex(p2);
        rec[0].addVertex(p3);
        rec[0].addVertex(p4);
        rec[0].addVertex(p5);
        rec[0].addVertex(p6);
        rec[0].addVertex(p7); 
        rec[0].addVertex(p8);
        rec[0].addVertex(p9);
        rec[0].addVertex(p10);
        rec[0].addVertex(p11);
        rec[0].addVertex(p12);
        rec[0].addVertex(p13);
        rec[0].setRecPolygonData(450);
        //The Great Movie Ride
        
        p = new Point(299, 542);
        p1 = new Point(299, 610);
        p2 = new Point(372, 610);
        p3 = new Point(372, 597); 
        p4 = new Point(396, 597);
        p5 = new Point(396, 562); 
        p6 = new Point(372, 562); 
        p7 = new Point(372, 542);
 
        rec[1] = new RecPolygon();
        rec[1].addVertex(p);
        rec[1].addVertex(p1);
        rec[1].addVertex(p2);
        rec[1].addVertex(p3);
        rec[1].addVertex(p4);
        rec[1].addVertex(p5);
        rec[1].addVertex(p6);
        rec[1].addVertex(p7);
        rec[1].setRecPolygonData(225);
        //Toy Story Mania

        p = new Point(551, 791);
        p1 = new Point(551, 827);
        p2 = new Point(566, 827);
        p3 = new Point(566, 847); 
        p4 = new Point(600, 847);
        p5 = new Point(600, 827); 
        p6 = new Point(613, 827); 
        p7 = new Point(613, 791);
        
        rec[2] = new RecPolygon();
        rec[2].addVertex(p);
        rec[2].addVertex(p1);
        rec[2].addVertex(p2);
        rec[2].addVertex(p3);
        rec[2].addVertex(p4);
        rec[2].addVertex(p5);
        rec[2].addVertex(p6);
        rec[2].addVertex(p7);
        rec[2].setRecPolygonData(600);
        //Premier Theater
        
        p = new Point(162, 123);
        p1 = new Point(162, 185);
        p2 = new Point(248, 185);
        p3 = new Point(248, 193); 
        p4 = new Point(350, 193);
        p5 = new Point(350, 215);
        p6 = new Point(439, 215);
        p7 = new Point(439, 148);
        p8 = new Point(375, 148);
        p9 = new Point(375, 172); 
        p10 = new Point(256, 172);
        p11 = new Point(256, 123);
        
        rec[3] = new RecPolygon();
        rec[3].addVertex(p);
        rec[3].addVertex(p1);
        rec[3].addVertex(p2);
        rec[3].addVertex(p3);
        rec[3].addVertex(p4);
        rec[3].addVertex(p5);
        rec[3].addVertex(p6);
        rec[3].addVertex(p7);
        rec[3].addVertex(p8);
        rec[3].addVertex(p9);
        rec[3].addVertex(p10);
        rec[3].addVertex(p11);
        rec[3].setRecPolygonData(387);
        //Rock 'N' Roller Coaster
        
        p = new Point(599, 199);
        p1 = new Point(599, 218);
        p2 = new Point(619, 218);
        p3 = new Point(619, 199); 
        rec[4] = new RecPolygon();
        rec[4].addVertex(p);
        rec[4].addVertex(p1);
        rec[4].addVertex(p2); 
        rec[4].addVertex(p3);
        rec[4].setRecPolygonData(23);
        //Public Bathroom
        
        rec[0].setInteriorColor(Color.green);
        rec[1].setInteriorColor(Color.green);
        rec[2].setInteriorColor(Color.green);
        rec[3].setInteriorColor(Color.green);
        rec[4].setInteriorColor(Color.green);
      
       /* 
        //Defining the geometric objects that represent the problem data
        int pointNumber = 10000;
        Point[] pArray = new Point[pointNumber];
        
        //creating a set of random points
        Random rnd = new Random();
        for(int i=0; i<pointNumber; i++)
        {
            double x = rnd.nextInt(frameWidth);
            double y = rnd.nextInt(frameHeight);
            pArray[i] = new Point(x, y);
            pArray[i].setInteriorColor(Color.red); 
        }
      */  
           
        //graphing
        FrameDisplay frame = new FrameDisplay(frameWidth, frameHeight, rec);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
