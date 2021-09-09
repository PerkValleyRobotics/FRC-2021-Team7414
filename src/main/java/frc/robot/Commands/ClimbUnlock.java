package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class ClimbUnlock extends Command {

    boolean flag = false;

    public ClimbUnlock() {
        requires(Robot.climber);
        setInterruptible(false);
    }

    public void execute() {
        Robot.climber.releasePiston();
        flag = true;
    }

    public boolean isFinished() {
        return flag;
    }
}