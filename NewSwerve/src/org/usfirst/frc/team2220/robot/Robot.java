
package org.usfirst.frc.team2220.robot;


import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends SampleRobot {
    
	Joystick stick;

    public Robot() {
        
    }

   
    /**
     * Drive left & right motors for 2 seconds then stop
     */
    public void autonomous() {
        
    }

    public Encoder test = new Encoder(0, 1, true, EncodingType.k4X);
    SmartDashboard board;
    double rps;
    Timer time = new Timer();
    
    public void resetRPS()
    {
    	time.reset();
    	time.start();
    	test.reset();
    }
    /**
     * Runs the motors with arcade steering.
     */
    public void operatorControl() {
    	resetRPS();
        while (isOperatorControl() && isEnabled()) {
            if(time.get() > 1)
            {
            	rps = (test.getDistance() / 256) / time.get();
            	resetRPS();
            }
        	board.putNumber("Distance", test.getDistance());
        	board.putNumber("RPS", rps);
        	
        	
            Timer.delay(0.005);		// wait for a motor update time
        }
    }

    /**
     * Runs during test mode
     */
    public void test() {
    }
}
