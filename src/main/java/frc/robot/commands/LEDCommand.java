package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.LEDs;
import frc.robot.subsystems.ShoulderButtons; 

public class LEDCommand extends InstantCommand {

    ShoulderButtons m_ShoulderButton;
    LEDs s_LEDS;
   
    boolean BlueLight = false;
    boolean RedLight = false;




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
    System.out.println("hi:)");
    BlueLight = ShoulderButtons.GetBlueButtonPressed();
    RedLight = ShoulderButtons.GetRedButtonPressed();
    if (RedLight) {
        s_LEDS.SetToRed();
        }
    if (BlueLight) {
        s_LEDS.SetToBlue();
      }
     
    
    }

}
