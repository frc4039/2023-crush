// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Crusher;

public class ReverseState extends InstantCommand {

    Crusher m_Crusher;

    public ReverseState(Crusher crusher) {
        // Use addRequirements() here to declare subsystem dependencies.
        m_Crusher = crusher;
        addRequirements(m_Crusher);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_Crusher.reverseState();
    }
}
