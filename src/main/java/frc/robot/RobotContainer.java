// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.DriverConstants;
import frc.robot.commands.AdvanceState;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.PlaySoundCMD;
import frc.robot.commands.LEDCommand;
import frc.robot.commands.ReverseState;
import frc.robot.commands.SpinHeadCCW;
import frc.robot.commands.SpinHeadCW;
import frc.robot.subsystems.Crusher;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Head;
import frc.robot.subsystems.LEDs;
import frc.robot.subsystems.ShoulderButtons;

import frc.robot.subsystems.Sounds;
import frc.robot.subsystems.LEDs.LEDColours;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.LEDCommand;
import frc.robot.commands.LEDColourCommand;



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
    private final ShoulderButtons s_ShoulderButtons = new ShoulderButtons();
    private final LEDs s_LEDs = new LEDs ();
    private final Sounds s_Sounds = new Sounds();

    private final XboxController m_driverController = new XboxController(DriverConstants.kDriverControllerPort);
    private final JoystickButton driverBButton = new JoystickButton(m_driverController, XboxController.Button.kB.value);
    private final JoystickButton driverXButton = new JoystickButton(m_driverController, XboxController.Button.kX.value);
    private final JoystickButton driverRightBumper = new JoystickButton(m_driverController,
            XboxController.Button.kRightBumper.value);
    private final JoystickButton driverLeftBumper = new JoystickButton(m_driverController,
            XboxController.Button.kLeftBumper.value);

    private final Trigger driverDPadUpTrigger = new Trigger(() -> m_driverController.getPOV() == 0);
    private final Trigger driverDPadDownTrigger = new Trigger(() -> m_driverController.getPOV() == 180);
    private final Trigger driverDPadLeftTrigger = new Trigger(() -> m_driverController.getPOV() == 270);
    private final Trigger driverDPadRightTrigger = new Trigger(() -> m_driverController.getPOV() == 90);

    private final Trigger redButtonTrigger = new Trigger(s_ShoulderButtons.GetRedButton()::get);
    private final Trigger blueButtonTrigger = new Trigger(s_ShoulderButtons.GetBlueBotton()::get);
    private final JoystickButton driverAButton = new JoystickButton(m_driverController, XboxController.Button.kA.value);
    private final JoystickButton driverYButton = new JoystickButton(m_driverController, XboxController.Button.kY.value);

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        s_driveTrain.setDefaultCommand(new ArcadeDrive(
                () -> m_driverController.getLeftY(),
                () -> m_driverController.getLeftX(),
                () -> driverYButton.getAsBoolean(),
                s_driveTrain));

        // Configure the controller bindings
        configureButtonBindings();
    }

    private void configureButtonBindings() {

        driverBButton.onTrue(new AdvanceState(s_Crusher, s_Sounds, s_LEDs));
        driverXButton.onTrue(new ReverseState(s_Crusher));
        driverRightBumper.whileTrue(new SpinHeadCW(s_Head));
        driverLeftBumper.whileTrue(new SpinHeadCCW(s_Head));

        // LED Controls
        driverDPadUpTrigger.onTrue(new LEDColourCommand(s_LEDs, LEDColours.WHITE));
        driverDPadDownTrigger.onTrue(new LEDColourCommand(s_LEDs, LEDColours.SCROLLRAINBOW));
        driverDPadLeftTrigger.onTrue(new LEDColourCommand(s_LEDs, LEDColours.FLASHRAINBOW));
        //driverDPadRightTrigger.onTrue(new LEDColourCommand(s_LEDs, LEDColours.XMAS)); // For Future (Red/Green) for Xmas
        blueButtonTrigger.whileFalse(new LEDCommand(s_ShoulderButtons, s_LEDs));
        redButtonTrigger.whileFalse (new LEDCommand(s_ShoulderButtons, s_LEDs));
        
        driverAButton.onTrue(new PlaySoundCMD(s_Sounds, "mynameiscrush.wav"));
    }

    public DriveTrain getDriveTrain() {
        return s_driveTrain;
    }
  }
   
  
 
 
 
 
 
     
   
