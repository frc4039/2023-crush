// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.Constants.*;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Drivebase extends SubsystemBase {
    private DifferentialDrive m_crush;
    private XboxController driver;
   // private final int leftStick;
    //private final int rightStick;
    private WPI_VictorSPX m_leftDriveMotor;
    private WPI_VictorSPX m_rightDriveMotor;

  /** Creates a new Subsystem. */
  public Drivebase() {
    m_leftDriveMotor = new WPI_VictorSPX(DrivebaseConstants.kLeftDriveMotorID);
    m_rightDriveMotor = new WPI_VictorSPX(DrivebaseConstants.kRightDriveMotorID);

    m_leftDriveMotor.configFactoryDefault();
    m_rightDriveMotor.configFactoryDefault();

    driver = new XboxController(DrivebaseConstants.kDriverControllerPort);

    //leftStick = XboxController.Axis.kLeftY.value;
    //rightStick = XboxController.Axis.kRightY.value;

    m_crush = new DifferentialDrive(m_leftDriveMotor, m_rightDriveMotor);

    }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    m_crush.tankDrive(driver.getLeftY(), driver.getRightY());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
