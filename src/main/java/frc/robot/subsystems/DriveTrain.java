// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;

public class DriveTrain extends SubsystemBase {
    private WPI_VictorSPX m_leftDriveMotor;
    private WPI_VictorSPX m_rightDriveMotor;

    private final DifferentialDrive m_drive;

    /** Creates a new DriveTrain. */
    public DriveTrain() {
        m_leftDriveMotor = new WPI_VictorSPX(DriveTrainConstants.kLeftDriveMotorID);
        m_leftDriveMotor.configFactoryDefault();
        m_leftDriveMotor.setInverted(true);
        m_rightDriveMotor = new WPI_VictorSPX(DriveTrainConstants.kRightDriveMotorID);
        m_rightDriveMotor.configFactoryDefault();
        m_rightDriveMotor.setInverted(false);

        m_drive = new DifferentialDrive(m_leftDriveMotor, m_rightDriveMotor);
        m_drive.setSafetyEnabled(true);
        m_drive.setExpiration(0.1);
        m_drive.setMaxOutput(1.0);
    }

    public void drive(double left, double right) {
        m_drive.feed();
        m_leftDriveMotor.set(left);
        m_rightDriveMotor.set(right);
    }

    public double normalizeJoystickWithDeadband(double val, double deadband) {
        val = (Math.abs(val) > Math.abs(deadband)) ? val : 0.0;

        if (val != 0)
            val = Math.signum(val) * ((Math.abs(val) - deadband) / (1.0 - deadband));

        return (Math.abs(val) > Math.abs(deadband)) ? val : 0.0;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
