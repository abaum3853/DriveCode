/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
  public static SpeedController driveleftDriveMotor;
  public static SpeedController driverightDriveMotor;
  public static DifferentialDrive driverobotDrive;
  public static Encoder driveleftDriveEncoder;
  public static Encoder driverightDriveEncoder;
  public static void init(){
    driveleftDriveMotor = new Spark(0);

    driverightDriveMotor = new Spark(1);

    driverobotDrive = new DifferentialDrive(driveleftDriveMotor, driverightDriveMotor);
    driverobotDrive.setSafetyEnabled(true);
    driverobotDrive.setExpiration(0.1);
    driverobotDrive.setMaxOutput(1.0);

    driveleftDriveEncoder = new Encoder(7, 6, false, EncodingType.k1X);
    driveleftDriveEncoder.setDistancePerPulse((6 * Math.PI) / 360);
    driveleftDriveEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
    driveleftDriveEncoder.setReverseDirection(true);

    driverightDriveEncoder = new Encoder(9, 8, false, EncodingType.k1X);
    driverightDriveEncoder.setDistancePerPulse((6 * Math.PI) / 360);
    driverightDriveEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
    driverightDriveEncoder.setReverseDirection(false);
  }
}
