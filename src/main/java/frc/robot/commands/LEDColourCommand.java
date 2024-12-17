package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;


import frc.robot.subsystems.LEDs;
import frc.robot.subsystems.LEDs.LEDColours;


// SETs LED Colours 
public class LEDColourCommand extends InstantCommand {
    private LEDColours m_colour;
    private LEDs s_LEDS;

  public LEDColourCommand( LEDs leds, LEDColours colour) {
    m_colour = colour;
    s_LEDS = leds;
    addRequirements(s_LEDS);
    }

@Override
public void initialize() {

}

@Override

public void execute() {
    if (m_colour == LEDColours.WHITE) s_LEDS.SetToWhite();
    if (m_colour == LEDColours.SCROLLRAINBOW) s_LEDS.SetToScrollRainbow();
    if (m_colour == LEDColours.FLASHRAINBOW) s_LEDS.SetToFlashRainbow();
    
  }
}


    
    
  
    
  

