package frc.robot.Commands.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.AutonConstants;
import frc.robot.Robot;

public class AutonBetter extends Command {

    double leftStart;
    double rightStart;
    double length;

    double startTime;

    int flag = 0;

    public AutonBetter() {
        requires(Robot.Gavin);
        Robot.Gavin.resetEncoders();
        leftStart = Robot.Gavin.getLeftDegrees();
        rightStart = Robot.Gavin.getRightDegrees();
        length = AutonConstants.offLineLength;
        Robot.limelight.targetingSight();
    }
    
    public void execute() {
        if(flag == 0){
            Robot.Gavin.standardDrive(0, -0.5);
            Robot.limelight.getTx();
            if(Math.abs(Robot.Gavin.getLeftDegrees()) >= 500000){
                flag = 1;
                Robot.Gavin.stop();
            }
        } else if (flag == 1){
            Robot.limelight.updateLimelight();
            Robot.Gavin.aimButWithPID(Robot.limelight.getTx());
            if(Math.abs(Robot.limelight.getTx())<2) {
                flag = 2;
                startTime =System.currentTimeMillis();
                Robot.limelight.driverSight();
                Robot.conveyor.conveyorForwards();
                Robot.shooter.changePower(0.455);
            }
        } else if (flag ==2){
            Robot.shooter.spinVel(7700);
            
            if ((System.currentTimeMillis() - startTime)/1000.0 > 5){
                flag = 3;
                Robot.shooter.stopSpin();
                Robot.conveyor.conveyorOff();
            }
            
        }
        
    }

    public boolean isFinished() {
        return flag == 3;
        //return false;
    }

    public void end() {
        Robot.Gavin.stop();
    }
}