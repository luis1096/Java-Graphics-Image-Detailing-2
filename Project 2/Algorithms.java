package Assignment2;
import java.util.ArrayList;
/**
 * This class implements several algorithms.
 */
/*
 * AUTHOR: Luis Oliveros
 * PID: 6131616
 */
public class Algorithms
{
    /**
     * Determines the closest pair of points. Brute-force solution is used.
     * 
     * @param points input points. Array is assumed to be fully populated.
     * @param indices output array containing indices of closest pair
     */
    public static void closestPairOfPoints(Point[] points, int[] indices)
    {
        double minDistance = Double.MAX_VALUE;
        for (int i=0; i<points.length; i++)
        {
            for (int j=i+1; j<points.length; j++)
            {
               double d = points[i].distance(points[j]);
               if (d<minDistance)
               {
                   minDistance = d;
                   indices[0] = i; 
                   indices[1] = j;
               }
            } 
        }
    }

    public static int isPointContainedIn(GeometricObject[] g, Point p)
    {
        RecPolygon[] rArray = (RecPolygon[])g;
        
        for (int i=0; i < g.length; i++)
        {
            if (rArray[i].isPointInRecPolygon(p))
                return i;  
        }
        
        return -1; 
    }
    
    /**
     * For the given list of geometric objects (points) and rectangle, finds 
     * points that are contained in the given rectangle.
     * 
     * @param g list of geometric objects (points)
     * @param r rectangle
     * 
     * @return array of points from g contained in r
     */
    public static Point[] inRectangle(GeometricObject[] g, Rectangle r)
    {
    	int inputLength = g.length; //number of points in input array
    	RecPolygon[] rArray = (RecPolygon[])g;
    	
    	Point [] r1 = rArray[0].getVertexList();
    	Point [] r2 = rArray[1].getVertexList();
     	Point [] r3 = rArray[2].getVertexList();
     	Point [] r4 = rArray[3].getVertexList();
     	Point [] r5 = rArray[4].getVertexList();
     
     
        K2Tree k2Tree = new K2Tree();

        
        for(int i=0; i<1; i++)
        {
            k2Tree.add(r1[i]); 
        } 
        for(int i=0; i<1; i++)
        {
            k2Tree.add(r2[i]); 
        }
        for(int i=0; i<1; i++)
        {
            k2Tree.add(r3[i]);
        }
        for(int i=0; i<1; i++)
        {
            k2Tree.add(r4[i]); 
        }
        for(int i=0; i<1; i++)
        {
            k2Tree.add(r5[i]); 
        }
 
        ArrayList<Point> pList  = k2Tree.pointsInRange(r);
 
        Point[] output = pList.toArray(new Point[pList.size()]);
        return output;

    }

}
