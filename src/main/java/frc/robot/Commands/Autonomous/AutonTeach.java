package frc.robot.Commands.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.AutonConstants;
import frc.robot.Robot;

public class AutonTeach extends Command {

    double leftStart;
    double rightStart;
    double length;

    double startTime;

    int flag = 0;

    public AutonTeach() {
        requires(Robot.Gavin);
        requires(Robot.shooter);
        requires(Robot.conveyor);
        Robot.Gavin.resetEncoders();
        leftStart = Robot.Gavin.getLeftDegrees();
        rightStart = Robot.Gavin.getRightDegrees();
        length = AutonConstants.offLineLength;
    }
    
    public void execute() {
        if(flag == 0){
            Robot.Gavin.standardDrive(.5, 0);
            if(Math.abs(Robot.Gavin.getLeftDegrees()) >= 800000){
                flag = 1;
                Robot.Gavin.resetEncoders();
            }
        } else if (flag == 1){
            Robot.Gavin.standardDrive(-.5, 0);
            if(Math.abs(Robot.Gavin.getLeftDegrees()) >= 800000) {
                flag = 2;
            }
        }
        
    }

    public boolean isFinished() {
        return flag == 2;
        //return false;
    }

    public void end() {
        Robot.Gavin.stop();
    }
}