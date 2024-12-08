// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Crusher;
import frc.robot.subsystems.Sounds;
import frc.robot.subsystems.Crusher.RobotState;

public class AdvanceState extends InstantCommand {

    Crusher m_Crusher;
    Sounds m_Sounds;

    public AdvanceState(Crusher crusher, Sounds sound) {
        // Use addRequirements() here to declare subsystem dependencies.
        m_Crusher = crusher;
        m_Sounds = sound;
        addRequirements(m_Crusher);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        if(m_Crusher.currentState == RobotState.UNCRUSH ) m_Sounds.PlaySound("thankyou.wav");
        m_Crusher.advanceState();

    }

}
