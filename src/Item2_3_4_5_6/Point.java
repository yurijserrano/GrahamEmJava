/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Item2_3_4_5_6;



/**
 *
 * @author Serrano
 */
public class Point 
{
    
    private final double x, y;
    
    public Point(double x, double y) 
    {
        this.x = x;
        this.y = y;
    }

    public double getX() 
    {
        return x;
    }

    public double getY() 
    {
        return y;
    }
    
    public double theta() 
    {
        return Math.atan2 (y, x);
    }
    
    public double polarAngle (Point p)
    {
        double dx = x - p.getX();
        double dy = y - p.getY();
        return Math.atan2(dy, dx);
    }
    
   
     
    //Verifica se o ponto esta a esquerda da linha que une os pontos P0 e P1 
    public boolean AEsquerda (Point p0, Point p1) 
    {
        double ccw = (y - p0.getY()) * (p1.getX() - p0.getX()) - (x - p0.getX()) * (p1.getY() - p0.getY());
        
        return (ccw > 0);
    }
    
    public boolean ADireita (Point p0, Point p1) 
    {
        
        double ccw = (y - p0.getY()) * (p1.getX() - p0.getX()) - (x - p0.getX()) * (p1.getY() - p0.getY());
        
        return (ccw <= 0);
    }
    
    @Override
    public String toString() 
    {
        return "[" + x + "," + y + "]";
    }
    
}
