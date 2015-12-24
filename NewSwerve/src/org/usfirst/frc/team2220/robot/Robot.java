
package org.usfirst.frc.team2220.robot;


import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends SampleRobot {
    
	
	
	CANTalon aTalon_fr;
	CANTalon sTalon_fr;
	AnalogInput ai_fr;
	Encoder encoder_fr;
	wAngle angle_fr;
	wSpeed speed_fr;
	
	CANTalon aTalon_fl;
	CANTalon sTalon_fl;
	AnalogInput ai_fl;
	Encoder encoder_fl;
	wAngle angle_fl;
	wSpeed speed_fl;
	
	CANTalon aTalon_bl;
	CANTalon sTalon_bl;
	AnalogInput ai_bl;
	Encoder encoder_bl;
	wAngle angle_bl;
	wSpeed speed_bl;
	
	CANTalon aTalon_br;
	CANTalon sTalon_br;
	AnalogInput ai_br;
	Encoder encoder_br;
	wAngle angle_br;
	wSpeed speed_br;
	
	Joystick stick;
	SmartDashboard board;
	
    public Robot() {
    	stick = new Joystick(0);
    	board = new SmartDashboard();
    	
        aTalon_fr = new CANTalon(9);
        sTalon_fr = new CANTalon(7);
        ai_fr = new AnalogInput(2);
        encoder_fr = new Encoder(0, 1, true, EncodingType.k4X);
        angle_fr = new wAngle(0.01, aTalon_fr, ai_fr);
        angle_fr.reverse();
        angle_fr.setOffset(1.1);
        speed_fr = new wSpeed(0.05, sTalon_fr, encoder_fr);
        
        aTalon_fl = new CANTalon(11);
        sTalon_fl = new CANTalon(3);
        ai_fl = new AnalogInput(3);
        encoder_fl = new Encoder(2, 3, true, EncodingType.k4X);
        angle_fl = new wAngle(0.01, aTalon_fl, ai_fl);
        angle_fl.setOffset(1.4);
        speed_fl = new wSpeed(0.05, sTalon_fl, encoder_fl);
        //speed_fl.reverseInput();
        
        aTalon_bl = new CANTalon(8);
        sTalon_bl = new CANTalon(2);
        ai_bl = new AnalogInput(0);
        encoder_bl = new Encoder(4, 5, true, EncodingType.k4X);
        angle_bl = new wAngle(0.01, aTalon_bl, ai_bl);
        angle_bl.setOffset(1.1);
        speed_bl = new wSpeed(0.05, sTalon_bl, encoder_bl);
        speed_bl.reverseInput();
        
        aTalon_br = new CANTalon(10);
        sTalon_br = new CANTalon(6);
        ai_br = new AnalogInput(1);
        encoder_br = new Encoder(6, 7, true, EncodingType.k4X);
        angle_br = new wAngle(0.01, aTalon_br, ai_br);
        angle_br.setOffset(-1.6);
        speed_br = new wSpeed(0.05, sTalon_br, encoder_br);
        speed_br.reverseInput();
        
        }
    
    public void dashboardBR()
    {
    	board.putNumber("BR_aError", angle_br.getError());
    	board.putNumber("BR_aTalon", angle_br.getTalonSpeed());
    	board.putNumber("BR_sError", speed_br.getError());
    	board.putNumber("BR_sTalonRPS", speed_br.getRPS());
    	board.putNumber("BR_sTalon", speed_br.getTalonSpeed());
    }
    
    public void dashboardBL()
    {
    	board.putNumber("BL_aError", angle_bl.getError());
    	board.putNumber("BL_aTalon", angle_bl.getTalonSpeed());
    	board.putNumber("BL_sError", speed_bl.getError());
    	board.putNumber("BL_sTalonRPS", speed_bl.getRPS());
    	board.putNumber("BL_sTalon", speed_bl.getTalonSpeed());
    }

    public void dashboardFL()
    {
    	board.putNumber("FL_aError", angle_fl.getError());
    	board.putNumber("FL_aTalon", angle_fl.getTalonSpeed());
    	board.putNumber("FL_sError", speed_fl.getError());
    	board.putNumber("FL_sTalonRPS", speed_fl.getRPS());
    	board.putNumber("FL_sTalon", speed_fl.getTalonSpeed());
    }
    
    public void dashboardFR()
    {
    	board.putNumber("FR_aError", angle_fr.getError());
    	board.putNumber("FR_aTalon", angle_fr.getTalonSpeed());
    	board.putNumber("FR_sError", speed_fr.getError());
    	board.putNumber("FR_sTalonRPS", speed_fr.getRPS());
    	board.putNumber("FR_sTalon", speed_fr.getTalonSpeed());
    }

   
    /**
     * Drive left & right motors for 2 seconds then stop
     */
    public void autonomous() {
        
    }

    //public Encoder test = new Encoder(0, 1, true, EncodingType.k4X);
    
    
   
    double tempScale, tempScale2;
    
    /**
     * Runs the motors with arcade steering.
     */
    public void operatorControl() {
    	
        while (isOperatorControl() && isEnabled()) {
        	dashboardFL();
        	
        	tempScale = stick.getRawAxis(5);
        	tempScale *= 180;
            angle_fr.setSetpoint(tempScale);
            angle_fr.calculate();
            
        	tempScale2 = stick.getRawAxis(1);
        	tempScale2 *= 3;
        	speed_fr.setRPS(tempScale2);
        	speed_fr.calculate();
        	board.putNumber("Potatoe", ai_fr.getAverageVoltage());
            Timer.delay(0.005);		// wait for a motor update time
        }
    }

    /**
     * Runs during test mode
     */
    public void test() {
    }
}
