package frc.robot.Commands.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.AutonConstants;
import frc.robot.Robot;

public class AutonCourseBarrel extends Command {

    long startTime = 0;
    int flag = 0;
    double leftStart;
    double rightStart;
    double length;




public AutonCourseBarrel() {
        requires(Robot.conveyor);
        requires(Robot.shooter);
        //requires(Robot.intake);
        requires(Robot.Gavin);
        Robot.Gavin.resetEncoders();
        leftStart = Robot.Gavin.getLeftDegrees();
        rightStart = Robot.Gavin.getRightDegrees();
        length = AutonConstants.everyThingDriveLeft;

    } 



// standardDrive(power for x, power for y)
// y for forward
//400,000 = 42 inches positive is forward negative is backward
//each encoder number is 0.000105 inches
// x or turning positive is right negative is left
// 170,000 = 90 degrees
// each encoder number is 0.000529411765 degrees

// .4 for y is what was used for testing
// .35 for x is what was used for testing
// These can likely be higher but need to be tested first

public void execute() {
        if(flag == 0) {
            Robot.Gavin.standardDrive(0, .4);
            if (Robot.Gavin.getRightDegrees() > 100000) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
       else if(flag == 1) {
            Robot.Gavin.standardDrive(0, .4);
            if (Robot.Gavin.getRightDegrees() > 100000) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 2) {
            Robot.Gavin.standardDrive(0, .4);
            if (Robot.Gavin.getRightDegrees() > 100000) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 3) {
            Robot.Gavin.standardDrive(0, .4);
            if (Robot.Gavin.getRightDegrees() > 100000) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 4) {
            Robot.Gavin.standardDrive(0, .4);
            if (Robot.Gavin.getRightDegrees() > 100000) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 5) {
            Robot.Gavin.standardDrive(0, .4);
            if (Robot.Gavin.getRightDegrees() > 100000) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 6) {
            Robot.Gavin.standardDrive(0, .4);
            if (Robot.Gavin.getRightDegrees() > 100000) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 7) {
            Robot.Gavin.standardDrive(0, .4);
            if (Robot.Gavin.getRightDegrees() > 100000) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 8) {
            Robot.Gavin.standardDrive(0, .4);
            if (Robot.Gavin.getRightDegrees() > 100000) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 9) {
            Robot.Gavin.standardDrive(0, .4);
            if (Robot.Gavin.getRightDegrees() > 100000) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 10) {
            Robot.Gavin.standardDrive(0, .4);
            if (Robot.Gavin.getRightDegrees() > 100000) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
    }

public boolean isFinished() {
    return flag == 10;
}

public void end() {
    Robot.conveyor.conveyorOff();
    Robot.Gavin.stop();
    Robot.shooter.stopSpin();
    Robot.limelight.driverSight();
}
}
