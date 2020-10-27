/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.dev;

/**
 *
 * @author Marc
 */
public class Instruction
{
    public static final int NO_ERROR = 0;
    public static final int INVALID_CODE = 1;
    public static final int INVALID_FWD_INTERVAL = 2;
    public static final int INVALID_PEN_PARAM = 3;
    public static final int INVALID_ROT_INTERVAL = 4;
    public static final int INVALID_REP_INTERVAL = 5;
    
    private final String code;
    private final double param;
    
    public Instruction(String code, double param)
    {
        this.code = code;
        this.param = param;
    }
    
    public final String getCode() { return code; }
    public final double getParam() { return param; }
    
    public final boolean isRepInstruction() { return code.equals("REP") || code.equals("END"); }
    
    public final boolean isCorrect() { return errorCode() == NO_ERROR; }
    
    public final int errorCode()
    {
        switch(code)
        {
            case "PEN":
                if(param != 0 && param != 1)
                    return INVALID_PEN_PARAM;
                break;
                
            case "FWD":
                if(param <= -1000 || param >= 1000)
                    return INVALID_FWD_INTERVAL;
                break;
                
            case "ROT":
                if(param < -360 || param >= 360)
                    return INVALID_ROT_INTERVAL;
                break;
                
            case "REP":
                if(param <= 0 || param >= 1000)
                    return INVALID_REP_INTERVAL;
                break;
                
            case "END":
                break;
                
            default: return INVALID_CODE;
        }
        
        return NO_ERROR;
    }
    
    public final String info()
    {
        if(code.equals("END"))
            return "END";
        
        return code + " " + param;
    }
}
