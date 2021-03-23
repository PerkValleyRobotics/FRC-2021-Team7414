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
        else if(flag == 0) {
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(1311030.000000)) { // fowards 1
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
       else if(flag == 1) { 
            Robot.Gavin.standardDrive(.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(154710.000000)) { //right 1
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 2) { 
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(534600.000000)) { // foward cone 1
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 3) {  
            Robot.Gavin.standardDrive(.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(179460.000000)) { //right 1
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 4) { 
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(554940.000000)) { // forward cone 1 2
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 5) { 
            Robot.Gavin.standardDrive(.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(155250.000000)) {// turn right cone 1 2
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 6) {
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(512100.000000)) { //I give up on comments  good luck Joe
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 7) { 
            Robot.Gavin.standardDrive(.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(165510.000000)) { //156240.000000
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 8) {  //drive slightly forward to corner 3
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(1351710.000000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 9) { //turn left into corner 3
            Robot.Gavin.standardDrive(-.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(-165600.000000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 10) { //drive through corner 3
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(-469260.000000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 11) {  //turn left out of corner 3
            Robot.Gavin.standardDrive(-.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(-148950.000000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 12) {// drive to corner 4
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(-471690.000000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 13) { //turn left into corner 4
            Robot.Gavin.standardDrive(-.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(702450.000000 - 32490.000000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 14) { //drive through corner 4
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(1032210.000000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 15) { //drive through corner 4
            Robot.Gavin.standardDrive(-.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(164970.000000)) { //582930
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 16) { //turn right out of corner 4
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(-1053270.000000)) { //146430
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 17) { //drive forward to corner 5
            Robot.Gavin.standardDrive(-0.35, 0);

            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(-165870.000000)) {//1678410.000000
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 18) { //turn right into corner 5
            Robot.Gavin.standardDrive(0, 0.4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(-636660.000000)) { //make turn less
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 19) {  //drive through corner 5
            Robot.Gavin.standardDrive(-0.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(202500.00000 - 33210.000000 )) { //573840.000000
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 20) { //turn for finish
            Robot.Gavin.standardDrive(-.35, 0);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(2447100.000000)) {
                flag += 1;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
            }
        }
        else if(flag == 21) {// drive to finish
            Robot.Gavin.standardDrive(0, .4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(150)) {
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
