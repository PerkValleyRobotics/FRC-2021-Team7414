package frc.robot.Commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;



public class TeleopPOV extends Command {
    
    boolean finished = false;
    boolean start = true;

    public TeleopPOV() {
        requires(Robot.Gavin);
        setInterruptible(false);
    }

    public void execute() {
        
		if (Robot.oi.getJoystickPOV() == 0) { //Forwards
			Robot.Gavin.standardDrive(0.0, 0.4);
		} else if (Robot.oi.getJoystickPOV() == 180) { //Backwards
			Robot.Gavin.standardDrive(0.0, -0.4);
		} else if (Robot.oi.getJoystickPOV() == 90) { //Right
			Robot.Gavin.standardDrive(0.35, 0);
		} else if (Robot.oi.getJoystickPOV() == 270) { //Left
			Robot.Gavin.standardDrive(-.35, 0);
		} else {
            Robot.Gavin.standardDrive(0,0);
        }

        if (Robot.oi.getButtonStateJoystick(4)) {
            Robot.Gavin.resetEncoders();
        }
        if(Robot.oi.getButtonStateJoystick(6)) {
            finished = true;
        }

    }

    public boolean isFinished() {
        return finished;
    }
}