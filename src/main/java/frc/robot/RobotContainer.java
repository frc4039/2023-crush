// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.DriverConstants;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private final DriveTrain s_driveTrain = new DriveTrain();

    private final XboxController m_driverController = new XboxController(DriverConstants.kDriverControllerPort);

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        s_driveTrain.setDefaultCommand(new InstantCommand(
                () -> s_driveTrain.drive(-m_driverController.getLeftY(), -m_driverController.getRightY())));

        // Configure the trigger bindings
        configureButtonBindings();
    }

    private void configureButtonBindings() {

    }

    public DriveTrain getDriveTrain() {
        return s_driveTrain;
    }

}
