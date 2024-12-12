// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.StringPublisher;


/*
 * Sound Subsystem requires a Raspberry PI loaded with the Wpilibpi image,
 * running the CrushPi custom application and connected to the Robots network.
 * 
 * The Pi is used becuase it has a Sound Card, while the Rio doesn't
 * 
 * The Robo Rio and the Pi communicate over the Crush Sounds Network Table
 *    - The Rio Tells the Pi what sound to Play (Playsound Topic)
 *    - The Pi Tells the RIO when the sould is playing (IsSoundPlaying Topic)
 */

public class Sounds extends SubsystemBase {

    private NetworkTable m_piSounds;
    private StringPublisher pubPlaySound;


    /** Creates a new Sounds. */
    public Sounds() {
      m_piSounds = NetworkTableInstance.getDefault().getTable("CrushSounds");
      //set up network table publisher topic
  
      pubPlaySound = m_piSounds.getStringTopic("PlaySound").publish();
      pubPlaySound.set("None");
    }

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
      if (this.m_piSounds.getEntry("IsSoundPlaying").getBoolean(false)){
        pubPlaySound.set("None");
      }
    }

    //
    public boolean PlaySound(String SoundName) {
      if (!this.m_piSounds.getEntry("IsSoundPlaying").getBoolean(false)) {
        pubPlaySound.set(SoundName);
        return true;
      }
      else {
        return false;
      }
    }

    // Checks to see if the Pi Is Playing a sound (NT IsSoundPlaying = True)
    public boolean IsSoundPlaying() {
      if (this.m_piSounds.getEntry("IsSoundPlaying").getBoolean(false)){
         pubPlaySound.set("None");
        return true;
      }
      else {
        return false;
      }
  }

}

