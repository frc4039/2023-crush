// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.HeadConstants;

import com.revrobotics.CANSparkMax;

public class Head extends SubsystemBase {

    private CANSparkMax m_headMotor;

    /** Creates a new Head. */
    public Head() {
        m_headMotor = new CANSparkMax(HeadConstants.kHeadMotorDeviceID, MotorType.kBrushless);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    public void spinCW() {
        m_headMotor.set(HeadConstants.kCWSpeed);
    }

    public void spinCCW() {
        m_headMotor.set(HeadConstants.kCCWSpeed);
    }

    public void stop() {
        m_headMotor.set(0);
    }

}
