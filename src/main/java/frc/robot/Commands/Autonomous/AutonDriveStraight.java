package frc.robot.Commands.Autonomous;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class AutonDriveStraight extends Command {
    
    double leftEncoderStart;
    double rightEncoderStart;
    double length;

    public AutonDriveStraight(double degreesForward) {
        requires(Robot.Gavin);
        leftEncoderStart = Robot.Gavin.getLeftDegrees();
        rightEncoderStart = Robot.Gavin.getRightDegrees();
        length = degreesForward;
    }

    //public void start() {
        //leftEncoderStart = Robot.Gavin.getLeftDegrees();
        //rightEncoderStart = Robot.Gavin.getRightDegrees();
    //}

    public void execute() {
        if (length < 0) {
            Robot.Gavin.standardDrive(0.0, -0.4);
        } else {
            Robot.Gavin.standardDrive(0.0, 0.4);
        }
    }
    
    public boolean isFinished() {
        if (length > 0) {
            return Robot.Gavin.getLeftDegrees()<leftEncoderStart-length;
        } else {
            return Robot.Gavin.getLeftDegrees()>leftEncoderStart+length;// && Robot.Gavin.getRightDegrees()>rightEncoderStart+length;    
        }
        //return false;
    }

    public void end() {
        Robot.Gavin.stop();
    }
}