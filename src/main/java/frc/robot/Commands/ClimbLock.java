package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class ClimbLock extends Command {

    boolean flag = false;

    public ClimbLock() {
        requires(Robot.climber);
        setInterruptible(false);
    }

    public void execute() {
        Robot.climber.lockPiston();
        flag = true;
    }

    public boolean isFinished() {
        return flag;
    }
}