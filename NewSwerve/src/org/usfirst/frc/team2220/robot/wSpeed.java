package org.usfirst.frc.team2220.robot;

import edu.wpi.first.wpilibj.*;

/*
 * PID Motor control for speed of a module
 */
public class wSpeed {
	
	private final double kP;
	private double plusM, desiredRPS, currentRPS;
	private CANTalon talon;
	private Encoder encoder;
	private boolean reversed = false;
	private double cap = 1.0;
	private Timer time = new Timer();
	
	/*
	 * Initialize stuff
	 */
	public wSpeed(double p, CANTalon tal, Encoder ai)
	{
		kP = p;
		talon = tal;
		encoder = ai;
	}
	
	public double getError()
	{
		return desiredRPS - currentRPS;
	}
	
	public void calculate()
	{
		plusM = getError() * kP;
		runWheel(talon.get() + plusM);
	}
	
	public void runWheel(double val)
	{
		if(val > cap)
			val = cap; 
		if(!reversed)
			talon.set(val);
		else
			talon.set(-val);
	}
	
	public void setRPS(double in)
	{
		desiredRPS = in;
	}
	
	
	
	public void startRPS()
	{
		encoder.reset();
		time.reset();
		time.start();
	}
	
	public void endRPS()
	{
		currentRPS = (encoder.getDistance() / 256) / time.get();
	}
}
