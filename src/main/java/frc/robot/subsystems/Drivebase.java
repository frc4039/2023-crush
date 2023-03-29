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
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants.*;

public class Drivebase extends SubsystemBase {
    private DifferentialDrive m_crush;
    private Joystick m_leftStick;
    private Joystick m_rightStick;
    private CANSparkMax m_leftDriveMotor;
    private CANSparkMax m_rightDriveMotor;

  /** Creates a new Subsystem. */
  public Drivebase() {
    m_leftDriveMotor = new CANSparkMax(DrivebaseConstants.kLeftDriveMotorID, MotorType.kBrushed);
    m_rightDriveMotor = new CANSparkMax(DrivebaseConstants.kRightDriveMotorID, MotorType.kBrushed);

    m_leftDriveMotor.restoreFactoryDefaults();
    m_rightDriveMotor.restoreFactoryDefaults();

    m_crush = new DifferentialDrive(m_leftDriveMotor, m_rightDriveMotor);

    m_leftStick = new Joystick(DrivebaseConstants.kLeftJoystickPort);
    m_rightStick = new Joystick(DrivebaseConstants.kRightJoystickPort);
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
    m_crush.tankDrive(m_leftStick.getY(), m_rightStick.getY());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
