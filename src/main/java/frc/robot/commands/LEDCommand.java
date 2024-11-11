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

    boolean test = true;




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




    while (!BlueLight && !RedLight) {
        s_LEDS.SetToPurple();
        break; }

    while (!RedLight) {
        s_LEDS.SetToBlue();
        System.out.println("SET TO RED");
        break;
        }

    while (!BlueLight) {
        s_LEDS.SetToRed();
        System.out.println("SET TO Blue");
        break;
      }

    


    //for some reason s_LEDS SetToBlue and SetToRed are reversed so i just swaped them.

    }
    }
  
    
  

