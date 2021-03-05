package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import frc.robot.PortMap;

public class Vision {

NetworkTableEntry tv;
NetworkTableEntry ta;
NetworkTableEntry tx;
NetworkTableEntry ty;
boolean inRange;

public Vision() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");
    tv = table.getEntry("tv");
    lightOff();
}

public void updateLimelight() {
    //read values periodically
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double v = tv.getDouble(0.0);
    double area = ta.getDouble(0.0);
        if (v < 1.0) {
        inRange = false;
        } else {
        inRange = true;
        }

    //post to smart dashboard periodically
    SmartDashboard.putNumber("LimelightX: ", x);
    SmartDashboard.putNumber("LimelightY: ", y);
    SmartDashboard.putNumber("In Frame? ", v);
    SmartDashboard.putBoolean("Detected? ", inRange);
    SmartDashboard.putNumber("LimelightArea: ", area);
    }
    
    public double getTx() {
        double x = tx.getDouble(0.0);
        return x;
    }

    public double getTy() {
        double y = ty.getDouble(0.0);
        return y;
    }

    public boolean getTv() {
        boolean tv = inRange;
        return tv;
    }

    public double getRange() {
        double range = ta.getDouble(0.0);
        return range;
    }

    public void targetingSight() {
        lightOn();
        setPipeline(PortMap.LIMELIGHT_targetingPipeline);
    }

    public void driverSight() {
        lightOff();
        setPipeline(PortMap.LIMELIGHT_defaultPipeline);
    }

    public void lightOn() {
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(PortMap.LIMELIGHT_lightOn);
    }

    public void lightOff() {
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(PortMap.LIMELIGHT_lightOff);
    }

    public void setPipeline(int pipeline) {
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(pipeline);
    }
}