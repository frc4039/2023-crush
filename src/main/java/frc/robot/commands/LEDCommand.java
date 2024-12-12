package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.LEDs;
import frc.robot.subsystems.ShoulderButtons; 
import java.util.Timer; 

public class LEDCommand extends InstantCommand {

    ShoulderButtons m_ShoulderButton;
    LEDs s_LEDS;
   
    boolean BlueLight = false;
    boolean RedLight = false;

    boolean test = true;

    Timer name = new Timer();
    int temp = 1;

    public LEDCommand(ShoulderButtons ShoulderButtons, LEDs leds) {
    m_ShoulderButton = ShoulderButtons;
    s_LEDS = leds;
    addRequirements(m_ShoulderButton);
    addRequirements(s_LEDS);
    }

@Override
public void initialize() {
}

@Override
public void execute() {
    BlueLight = ShoulderButtons.GetBlueButtonPressed();
    RedLight = ShoulderButtons.GetRedButtonPressed();
       
    if (!BlueLight && !RedLight) s_LEDS.SetToPurple();
    else if (!RedLight) s_LEDS.SetToBlue();
    else if (!BlueLight) s_LEDS.SetToRed();
    }
}
    
    
  
    
  

