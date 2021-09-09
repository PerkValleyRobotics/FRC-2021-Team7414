package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.PortMap;

public class ClimbExtend extends Command {

    boolean flag = false;

    public ClimbExtend() {
        requires(Robot.climber);
        setInterruptible(false);
    }

    public void execute() {
        Robot.climber.unwindMotors();   
        if(!Robot.oi.getButtonPressedXbox(PortMap.XBOX_climbMotorExtend)) {
            Robot.climber.stopMotors();
            flag = true;
        }
    }

    public boolean isFinished() {
        return flag;
    }
}