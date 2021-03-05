package frc.robot.Commands.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.AutonConstants;
import frc.robot.Robot;

// public class AutonEverything extends Command {

//     long startTime = 0;
//     boolean flag = true;
//     double leftStart;
//     double rightStart;
//     double length;
//     boolean flag2 = true;
    
//     public AutonEverything() {
//         requires(Robot.conveyor);
//         requires(Robot.shooter);
//         //requires(Robot.intake);
//         requires(Robot.Gavin);
//         Robot.Gavin.resetEncoders();
//         leftStart = Robot.Gavin.getLeftDegrees();
//         rightStart = Robot.Gavin.getRightDegrees();
//         length = AutonConstants.everyThingDriveLeft;
//         flag2 = true;
//     }

//     public void execute() {
//         if (startTime == 0) {
//             startTime = System.currentTimeMillis();
//             Robot.Gavin.resetEncoders();
//             leftStart = Robot.Gavin.getLeftDegrees();
//             rightStart = Robot.Gavin.getRightDegrees();
//         }
//         if (flag2) {
//             Robot.Gavin.standardDrive(0.7, 0.0);
//             Robot.shooter.spinVel(6000);
//             if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(rightStart) + Math.abs(length)) {
//                 flag2 = false;
//                 Robot.Gavin.stop();
//                 startTime = System.currentTimeMillis();
//                 //Robot.intake.deployClaw();
//             }
//         } else {
//             double time = (System.currentTimeMillis() - startTime)/1000.0;
//             if (time > 0 && time < .5) {
//                 Robot.Gavin.standardDrive(0.35, -0.1);
//                 Robot.limelight.targetingSight();
//             } else if (time > .5 && time < 1.5) {
//                 Robot.Gavin.aimButWithPID(Robot.limelight.getTx());
//             } else if (time > 1.5 && time < 4.7 && Robot.limelight.getTv()) {
//                 Robot.Gavin.stop();
//                 Robot.shooter.changePower(0.455);
//                 //Robot.shooter.spin();
//                 Robot.shooter.spinVel(7700);
//             } else if (time > 4.7 && time < 5.5 && Robot.limelight.getTv()) {
//                 Robot.conveyor.conveyorForwards();
//                 Robot.shooter.spinVel(7700);
//             } else if (time > 5.5 && time < 6.3 && Robot.limelight.getTv()) {
//                 Robot.conveyor.conveyorOff();
//                 Robot.shooter.spinVel(7700);
//             } else if (time > 6.3 && time < 6.9 && Robot.limelight.getTv()) {
//                 Robot.conveyor.conveyorForwards();
//                 Robot.shooter.spinVel(7700);
//             } else if (time > 6.9 && time < 7.7 && Robot.limelight.getTv()) {
//                 Robot.conveyor.conveyorOff();
//                 Robot.shooter.spinVel(7700);
//             } else if (time > 7.7 && time < 8.7 && Robot.limelight.getTv()) {
//                 Robot.conveyor.conveyorForwards();
//                 Robot.shooter.spinVel(7700);
//             }
//         }
//     }

//     public boolean isFinished() {
//         return System.currentTimeMillis() - startTime > 9500;
//     }

//     public void end() {
//         Robot.conveyor.conveyorOff();
//         Robot.Gavin.stop();
//         Robot.shooter.stopSpin();
//         Robot.limelight.driverSight();
//     }
// }
public class AutonEverything extends Command {

    long startTime = 0;
    boolean flag = true;
    double leftStart;
    double rightStart;
    double length;
    boolean flag2 = true;
    boolean flag3 = false;
    boolean flag4 = false;
    boolean flag5 = false;
    boolean flag6 = false;
    boolean flag7 = false;
    boolean flag8 = false;
    boolean flag9 = false;
    boolean flag10 = false;
    boolean flag11 = false;
    boolean flag12 = false;
    boolean flag13 = false;
    boolean flag14 = false;
    boolean flag15 = false;
    boolean flag16 = false;



public AutonEverything() {
        requires(Robot.conveyor);
        requires(Robot.shooter);
        //requires(Robot.intake);
        requires(Robot.Gavin);
        Robot.Gavin.resetEncoders();
        leftStart = Robot.Gavin.getLeftDegrees();
        rightStart = Robot.Gavin.getRightDegrees();
        length = AutonConstants.everyThingDriveLeft;
        flag2 = true;
        flag3 = false;
        flag4 = false;
        flag5 = false;
        flag6 = false;
        flag7 = false;
        flag8 = false;
        flag9 = false;
        flag10 = false;
        flag11 = false;
        flag12 = false;
        flag13 = false;
        flag14 = false;
        flag15 = false;
        flag16 = false;
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
        if (startTime == 0) {
            startTime = System.currentTimeMillis();
            Robot.Gavin.resetEncoders();
            leftStart = Robot.Gavin.getLeftDegrees();
            rightStart = Robot.Gavin.getRightDegrees();
        }
        else if (flag2) {
        // moves forward 30 inches
            Robot.Gavin.standardDrive(0.0, 0.4);
            if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(rightStart) + Math.abs(285714.286)) { // 285714.286
                flag2 = false;
                flag3 = true;
                Robot.Gavin.stop();
                Robot.Gavin.resetEncoders();
                startTime = System.currentTimeMillis();
            }
        } else if(flag3) {
        // turns 20 degrees to the left
          Robot.Gavin.standardDrive(-0.35, 0.0);
          if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(rightStart) + Math.abs(132222.221)) { // 132222.221
            flag3 = false;
            flag4 = true;
            Robot.Gavin.stop();
            Robot.Gavin.resetEncoders();
          }
        } else if(flag4) {
        // drives 50 inches to next flag
          Robot.Gavin.standardDrive(0.0, 0.4);
          if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(rightStart) + Math.abs(400952.381)) { // 380952.381
            flag4 = false;
            flag5 = true;
            Robot.Gavin.stop();
            Robot.Gavin.resetEncoders();
          }
        } else if(flag5) {
        // turn 36 degrees to the left
          Robot.Gavin.standardDrive(-0.35, 0.0);
          if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(rightStart) + Math.abs(100000.99995)) { // 84999.99995
            flag5 = false;
            flag6 = true;
            Robot.Gavin.stop();
            Robot.Gavin.resetEncoders();
          }
        } else if(flag6) {
        // drives about 42 inches backward
          Robot.Gavin.standardDrive(0.0, -0.4);
          if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(rightStart) + Math.abs(904061.018)) { // 404061.018
            flag6 = false;
            flag7 = true;
            Robot.Gavin.stop();
            Robot.Gavin.resetEncoders();
          }
        } //
        else if(flag7) {
        // turn 45 degrees to the right
          Robot.Gavin.standardDrive(-0.35, 0.0);
          if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(rightStart) + Math.abs(105000)) { // 85000
            flag7 = false;
            flag8 = true;
            Robot.Gavin.stop();
            Robot.Gavin.resetEncoders();
            }
        } else if(flag8) {
        // drives about 123 inches forward
          Robot.Gavin.standardDrive(0.0, -0.4);
          if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(rightStart) + Math.abs(574887.32)) { // 1174887.32
            flag8 = false;
            flag9 = true;
            Robot.Gavin.stop();
            Robot.Gavin.resetEncoders();
            }
        }
        else if(flag9) {
        // turn 18 degrees to the left
          Robot.Gavin.standardDrive(-0.35, 0.0);
          if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(rightStart) + Math.abs(142000)) { // 34000
            flag9 = false;
            flag10 = true;
            Robot.Gavin.stop();
            Robot.Gavin.resetEncoders();
          }
        }
        else if(flag10) {
        // drives about 123 inches backwards
          Robot.Gavin.standardDrive(0.0 , -0.4);
          if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(rightStart) + Math.abs(974887.32)) { // 1174887.32
            flag10 = false;
            flag11 = true;
            Robot.Gavin.stop();
            Robot.Gavin.resetEncoders();
          }
        }
        else if(flag11) {
        // turn 69 degrees to the left
          Robot.Gavin.standardDrive(-0.35, 0.0);
          if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(rightStart) + Math.abs(130333.333)) { // 130333.333
            flag11 = false;
            flag12 = true;
            Robot.Gavin.stop();
            Robot.Gavin.resetEncoders();
          }
        }
        else if(flag12) {
        // drives about 30 inches backwards
          Robot.Gavin.standardDrive(0.0 , -0.4);
          if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(rightStart) + Math.abs(285714.286)) { // 285714.286
            flag12 = false;
            flag13 = true;
            Robot.Gavin.stop();
            Robot.Gavin.resetEncoders();
          }
        }
        else if(flag13) {
        // turn 75 degrees to the left
          Robot.Gavin.standardDrive(-0.35, 0.0);
          if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(rightStart) + Math.abs(141666.667)) { // 141666.667
            flag13 = false;
            flag14 = true;
            Robot.Gavin.stop();
            Robot.Gavin.resetEncoders();
          }
        }
        else if(flag14) {
        // drives about 123 inches backwards
          Robot.Gavin.standardDrive(0.0 , -0.4);
          if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(rightStart) + Math.abs(1174887.32)) { // 1174887.32
            flag14 = false;
            flag15 = true;
            Robot.Gavin.stop();
            Robot.Gavin.resetEncoders();
          }
        }
        else if(flag15) {
        // turn 50 degrees to the left
          Robot.Gavin.standardDrive(-0.35, 0.0);
          if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(rightStart) + Math.abs(94444.4444)) { // 94444.4444
            flag15 = false;
            flag16 = true;
            Robot.Gavin.stop();
            Robot.Gavin.resetEncoders();
          }
        }
        else if(flag16) {
        // drives about 60 inches forward
          Robot.Gavin.standardDrive(0.0 , 0.4);
          if (Math.abs(Robot.Gavin.getRightDegrees()) > Math.abs(rightStart) + Math.abs(571428.571)) { // 571428.571
            flag16 = false;
            Robot.Gavin.stop();
            Robot.Gavin.resetEncoders();
          }
        }


    }

public boolean isFinished() {
    return false;
}

public void end() {
    Robot.conveyor.conveyorOff();
    Robot.Gavin.stop();
    Robot.shooter.stopSpin();
    Robot.limelight.driverSight();
}
}
