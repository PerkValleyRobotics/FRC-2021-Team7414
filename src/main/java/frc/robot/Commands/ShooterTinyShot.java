package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.PortMap;
import frc.robot.OIHandler;
import frc.robot.Robot;

public class ShooterTinyShot extends Command {

    public ShooterTinyShot() {
        requires(Robot.shooter);
        setInterruptible(false);
        Robot.conveyor.setShooterOn();
    }

    public void execute() {
        Robot.shooter.tinyShot(1460);
    }

    public void interrupted() {
        //Robot.shooter.stopSpin();
    }

    public void end() {
        //Robot.shooter.stopSpin();
        Robot.conveyor.setShooterOff();
    }
    
    public boolean isFinished() {
        return !Robot.oi.getButtonPressedXbox(PortMap.JOYSTICK_tinyShot);
        //return !Robot.oi.getButtonStateJoystick(PortMap.JOYSTICK_shoot);
    }
}