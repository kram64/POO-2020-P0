/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.dev;

import java.awt.Graphics;

/**
 *
 * @author Marc
 */
public class Turtle
{
    private int x;
    private int y;
    
    private double dirX, dirY;
    
    private boolean pen;
    
    public Turtle(int x, int y, double dirX, double dirY)
    {
        this.x = x;
        this.y = y;
        this.dirX = dirX;
        this.dirY = dirY;
        this.pen = false;
    }
    
    public final int getX() { return x; }
    public final int getY() { return y; }
    public final double getDirX() { return dirX; }
    public final double getDirY() { return dirY; }
    
    public final void setX(int x) { this.x = x; }
    public final void setY(int y) { this.y = y; }
    public final void setCoord(int x, int y) { this.x = x; this.y = y; }
    
    public final void setDirX(double dirX) { this.dirX = dirX; }
    public final void setDirY(double dirY) { this.dirY = dirY; }
    public final void setDir(double dirX, double dirY) { this.dirX = dirX; this.dirY = dirY; }
    
    public final void forward(double distance, Graphics g)
    {
        int oldX = x;
        int oldY = y;
        
        x += dirX * distance;
        y += dirY * distance;
        
        if(pen)
            g.drawLine(oldX, oldY, x, y);
    }
    
    public final void turn(double degrees)
    {
        double rad = degrees * Math.PI / 180.0;
        
        double dx = Math.cos(rad) * dirX - Math.sin(rad) * dirY;
        double dy = Math.sin(rad) * dirX + Math.cos(rad) * dirY;
        
        dirX = dx;
        dirY = dy;
    }
    
    public final void setPen(boolean on) { this.pen = on; }
    public final boolean isPenOn() { return pen; }
    
    public final void draw(Graphics g)
    {
        int[] xc = new int[]
        {
            (int) (x + 8 * dirY),
            (int) (x - 8 * dirY),
            (int) (x + 16 * dirX)
        };
        
        int[] yc = new int[]
        {
            (int) (y - 8 * dirX),
            (int) (y + 8 * dirX),
            (int) (y + 16 * dirY)
        };
        
        g.drawPolygon(xc, yc, 3);
    }
}
