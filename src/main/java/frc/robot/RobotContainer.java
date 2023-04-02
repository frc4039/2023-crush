// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.DriverConstants;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.SpinHeadCCW;
import frc.robot.commands.SpinHeadCW;
import frc.robot.subsystems.Crusher;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Head;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

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
    private final Crusher s_Crusher = new Crusher();
    private final Head s_Head = new Head();

    private final XboxController m_driverController = new XboxController(DriverConstants.kDriverControllerPort);
    private final JoystickButton advanceState = new JoystickButton(m_driverController, XboxController.Button.kB.value);
    private final JoystickButton reverseState = new JoystickButton(m_driverController, XboxController.Button.kX.value);
    private final JoystickButton driverRightBumper = new JoystickButton(m_driverController, XboxController.Button.kRightBumper.value);
    private final JoystickButton driverLeftBumper = new JoystickButton(m_driverController, XboxController.Button.kLeftBumper.value);
    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        s_driveTrain.setDefaultCommand(new ArcadeDrive(
                () -> m_driverController.getLeftY(),
                () -> m_driverController.getLeftX(),
                s_driveTrain));

        // Configure the trigger bindings
        configureButtonBindings();
    }

    private void configureButtonBindings() {

        advanceState.onTrue(new InstantCommand(() -> s_Crusher.advanceState()));
        reverseState.onTrue(new InstantCommand(() -> s_Crusher.reverseState()));
        driverRightBumper.whileTrue(new SpinHeadCW(s_Head));
        driverLeftBumper.whileTrue(new SpinHeadCCW(s_Head));


    }

    public DriveTrain getDriveTrain() {
        return s_driveTrain;
    }

}
