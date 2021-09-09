package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.PortMap;

public class ClimbRetract extends Command {

    boolean flag = false;

    public ClimbRetract() {
        requires(Robot.climber);
        setInterruptible(false);
    }

    public void execute() {
        Robot.climber.windMotors();   
        if(!Robot.oi.getButtonPressedXbox(PortMap.XBOX_climbMotorRetract)) {
            Robot.climber.stopMotors();
            flag = true;
        }
    }

    public boolean isFinished() {
        return flag;
    }
}