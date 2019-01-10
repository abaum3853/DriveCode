/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase;
import edu.wpi.first.wpilibj.SendableBase;
import frc.robot.*;
import frc.robot.commands.driveTeleop;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
/**
 * Add your docs here.
 */
public class Drive extends Subsystem {
  private final SpeedController leftDriveMotor = RobotMap.driveleftDriveMotor;
  private final SpeedController rightDriveMotor = RobotMap.driverightDriveMotor;
  public final DifferentialDrive robotDrive = RobotMap.driverobotDrive;
  private Joystick stick;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new driveTeleop());
  }
  public void doTeleop(Joystick stick, boolean driveType){
    double rightValue;
    double leftValue;
    rightValue = stick.getRawAxis(5);
    leftValue = stick.getRawAxis(1);
    if(driveType){
    robotDrive.arcadeDrive(leftValue, 0);
  } else {
    robotDrive.tankDrive(leftValue, rightValue);
  }
  }
}
