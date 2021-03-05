package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;

import frc.robot.PortMap;
import frc.robot.StateTrackers.ClimbPistonState;

public class Climb extends Subsystem {

    public PWMVictorSPX hookDeploy;
    CANSparkMax liftLeft;
    CANSparkMax liftRight;
    CANEncoder liftLeftEncoder;
    CANEncoder liftRightEncoder;
    DoubleSolenoid climbLock;
    public ClimbPistonState pistonState;

    final double k_LEFT_SPEED = -0.55;
    final double k_RIGHT_SPEED = 0.55;
    final double k_HOOK_SPEED = 0.215;

    public Climb() {
        hookDeploy = new PWMVictorSPX(PortMap.PWM_climberHook);
        //liftLeft = new CANSparkMax(PortMap.CAN_climbLeft, MotorType.kBrushless);
        //liftRight = new CANSparkMax(PortMap.CAN_climbRight, MotorType.kBrushless);
        //liftLeftEncoder = liftLeft.getEncoder();
        //liftRightEncoder = liftRight.getEncoder();
        climbLock = new DoubleSolenoid(PortMap.PCM_climbLock1, PortMap.PCM_climbLock2);
        hookDeploy.set(0);
        //liftLeft.set(0);
        //liftRight.set(0);
        pistonState = ClimbPistonState.UNLOCKED;
        climbLock.set(Value.kReverse); //try kOff?
        //also try mounting horizontally
    }

    public void putLock() {
        SmartDashboard.putString("Lock Solenoid: ", pistonState.toString());
        
    }

    public void actuateLocks() {
        if (pistonState.equals(ClimbPistonState.LOCKED)) {
            releasePiston();
        } else if (pistonState.equals(ClimbPistonState.UNLOCKED)) {
            lockPiston();
        }
    }

    public void lockPiston() {
        climbLock.set(Value.kForward);
        pistonState = ClimbPistonState.LOCKED;
    }

    public void releasePiston() {
        climbLock.set(Value.kReverse);
        pistonState = ClimbPistonState.UNLOCKED;
    }

    public double getRightEncoder() {
        return 0;
        //return liftRightEncoder.getPosition();
    }

    public double getLeftEncoder() {
        return 0;
        //return liftLeftEncoder.getPosition();
    }

    public void lockHook() {
        hookDeploy.set(0.2);
    }

    public void deployHook() {
        hookDeploy.set(-k_HOOK_SPEED);
    }

    public void retractHook() {
        hookDeploy.set(-0.15);
    }

    public void stopHook() {
        hookDeploy.set(0);
    }

    public void reverseClimb() {
        //liftLeft.set(-k_LEFT_SPEED);
        //liftRight.set(-k_RIGHT_SPEED);
    }

    public void climbLeft() {
        //liftLeft.set(k_LEFT_SPEED);
    }
    
    public void reverseClimbLeft() {
        //liftLeft.set(-k_LEFT_SPEED);
    }

    public void climbRight() {
        //liftRight.set(k_RIGHT_SPEED);
    }

    public void reverseClimbRight() {
        //liftRight.set(-k_RIGHT_SPEED);
    }

    public void climbLeftStop() {
        //liftLeft.set(0);
    }

    public void climbRightStop() {
        //liftRight.set(0);
    }
    
    public void climb() {
        climbLeft();
        climbRight();
    }

    public void stopClimb() {
        //liftLeft.set(0);
        //liftRight.set(0);
        hookDeploy.set(0);
    }

    protected void initDefaultCommand() {
        
    }
}