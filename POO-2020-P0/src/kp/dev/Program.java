/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.dev;

import java.util.LinkedList;

/**
 *
 * @author Marc
 */
public class Program
{
    private final String programName;
    private final LinkedList<Instruction> instructions;
    private int currentLine;
    private int loopIteration;
    
    public Program(String name)
    {
        this.programName = name;
        this.instructions = new LinkedList<>();
        this.currentLine = 0;
        this.loopIteration = 0;
    }
    
    public final String getName() { return programName; }
    
    public final boolean addInstruction(String code, double param)
    {
        return instructions.add(new Instruction(code, param));
    }
    
    public final void restart()
    {
        currentLine = 0;
        loopIteration = 0;
    }
    
    public final boolean hasFinished() { return currentLine >= instructions.size(); }
    
    public final Instruction getNextInstruction()
    {
        if(hasFinished())
            return null;
        
        Instruction inst = instructions.get(currentLine++);
        if(inst.getCode().equals("REP"))
        {
            loopIteration = (int) inst.getParam();
            return getNextInstruction();
        }
        
        if(!hasFinished() && instructions.get(currentLine).getCode().equals("END"))
        {
            if(loopIteration > 0)
            {
                goToStartLoop();
                loopIteration--;
            }
            else currentLine++;
        }
        
        return inst;
    }
    
    public final boolean isCorrect()
    {
        for(Instruction inst : instructions)
            if(!inst.isCorrect())
                return false;
        return true;
    }
    
    public final void printErrors()
    {
        for(Instruction inst : instructions)
        {
            switch(inst.errorCode())
            {
                case Instruction.INVALID_CODE:
                    System.err.println(inst.info() + ": INVALID CODE");
                    break;
                    
                case Instruction.INVALID_FWD_INTERVAL:
                    System.err.println(inst.info() + ": INVALID FWD PARAM RANGE");
                    break;
                    
                case Instruction.INVALID_PEN_PARAM:
                    System.err.println(inst.info() + ": INVALID PEN PARAM VALUES (Only 0 or 1 are valids)");
                    break;
                    
                case Instruction.INVALID_REP_INTERVAL:
                    System.err.println(inst.info() + ": INVALID REP PARAM RANGE");
                    break;
                    
                case Instruction.INVALID_ROT_INTERVAL:
                    System.err.println(inst.info() + ": INVALID ROT PARAM RANGE");
                    break;
            }
        }
    }
    
    private void goToStartLoop()
    {
        for(; currentLine > 0; --currentLine)
            if(instructions.get(currentLine - 1).isRepInstruction())
                break;
    }
}
