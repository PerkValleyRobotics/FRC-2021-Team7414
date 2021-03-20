package frc.robot.Commands.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.AutonConstants;
import frc.robot.Robot;

public class AutonCourseBarrel extends Command {

    long startTime = 0;
    int flag = -1;
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
        if(flag == -1) {
            Robot.Gavin.stop();
            Robot.Gavin.resetEncoders();
            flag += 1;
        }
        else if(flag == 0) { //Forward start
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(471060.000000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
       else if(flag == 1) { //turn left 1
            Robot.Gavin.standardDrive(-.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(170000)) { //161280.000000
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 2) { //Forward through corner 1
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(711180.000000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 3) {  //turn right 1
            Robot.Gavin.standardDrive(.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(130000.000000)) { //140000
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 4) { //Forwards corner 2
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(1450000.000000)) { //1600000
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 5) { //turn right into corner 2
            Robot.Gavin.standardDrive(.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(130000.000000)) {//142650
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 6) {// drive through corner 2
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(650000.000000)) { //626940
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 7) {  //turn left out of corner 2
            Robot.Gavin.standardDrive(-.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(160000.000000)) { //156240.000000
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 8) {  //drive slightly forward to corner 3
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(530730.000000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 9) { //turn left into corner 3
            Robot.Gavin.standardDrive(-.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(190280.000000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 10) { //drive through corner 3
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(582930.000000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 11) {  //turn left out of corner 3
            Robot.Gavin.standardDrive(-.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(190210.000000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 12) {// drive to corner 4
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(522630.000000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 13) { //turn left into corner 4
            Robot.Gavin.standardDrive(-.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(-171630.000000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 14) { //drive through corner 4
            flag += 1;
            /*
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(697770.000000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }*/
        }
        else if(flag == 15) { //drive through corner 4
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(582930.000000)) { //582930
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 16) { //turn right out of corner 4
            Robot.Gavin.standardDrive(.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(126430.000000)) { //146430
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 17) { //drive forward to corner 5
            Robot.Gavin.standardDrive(0, .4);

            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(1778410.000000)) {//1678410.000000
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 18) { //turn right into corner 5
            Robot.Gavin.standardDrive(.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(172080.000000)) { //make turn less
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 19) {  //drive through corner 5
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(573840.000000)) { //573840.000000
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 20) { //turn for finish
            Robot.Gavin.standardDrive(-.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(200000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 21) {// drive to finish
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(421560.000000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
    }

public boolean isFinished() {
    return flag == 22;
}

public void end() {
    Robot.conveyor.conveyorOff();
    Robot.Gavin.stop();
    Robot.shooter.stopSpin();
    Robot.limelight.driverSight();
}
}
