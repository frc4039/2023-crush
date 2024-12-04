// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Sounds;

public class PlaySoundCMD extends InstantCommand {

  private final Sounds m_Sound;
  private String m_SoundName;

  /** Creates a new PlaySoundCMD. */
  public PlaySoundCMD(Sounds Sounds, String SoundName) {
    m_Sound = Sounds;
    m_SoundName = SoundName;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() { 
    m_Sound.PlaySound(m_SoundName);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
