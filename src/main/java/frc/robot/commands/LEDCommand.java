package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import javax.swing.text.html.HTMLDocument.BlockElement;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
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
    System.out.println("hi:)");
    BlueLight = ShoulderButtons.GetBlueButtonPressed();
    RedLight = ShoulderButtons.GetRedButtonPressed();



//WHILES SHOULD BE IF FIX LATER
    //if (BlueLight && RedLight)
      //  s_LEDS.SetToWhite();
    //temp = 0;

    //{
       
                if (!BlueLight && !RedLight) {
                s_LEDS.SetToPurple();
            // break; 
        }
      
        if (!RedLight) {
            s_LEDS.SetToBlue();
            System.out.println("SET TO RED");
          
        //break;
            }
        if (!BlueLight) {
            s_LEDS.SetToRed();
            System.out.println("SET TO Blue");
           
            //s_LEDS.SetToWhite();
            //break;    
        }
        
    }

    }


 //   if (RedLight & BlueLight) {
   //   s_LEDS.SetToWhite();
    //}


    //for some reason s_LEDS SetToBlue and SetToRed are reversed so i just swaped them.

    
    
  
    
  

