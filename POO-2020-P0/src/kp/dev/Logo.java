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
public class Logo
{
    private final int width;
    private final int height;
    private final Turtle t;
    
    public Logo(int w, int h)
    {
        this.width = w;
        this.height = h;
        this.t = new Turtle(0, 0, 1, 0);
    }
    
    public final int getWidth() { return width; }
    public final int getHeight() { return height; }
    
    public final void resetTurtle()
    {
        t.setCoord(0, 0);
        t.setDir(1, 0);
        t.setPen(false);
    }
    
    public final void execute(Program p, Graphics g)
    {
        resetTurtle();
        p.restart();
        while(!p.hasFinished())
        {
            Instruction inst = p.getNextInstruction();
            switch(inst.getCode())
            {
                case "FWD":
                    t.forward(inst.getParam(), g);
                    break;
                    
                case "ROT":
                    t.turn(inst.getParam());
                    break;
                    
                case "PEN":
                    t.setPen(inst.getParam() != 0);
                    break;
            }
            
            t.draw(g);
        }
    }
}
