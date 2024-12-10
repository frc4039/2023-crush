package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShoulderButtonsConstants;



public class ShoulderButtons extends SubsystemBase {

    public static boolean RedButtonPressed = false;
    public static boolean BlueButtonPressed = false;
    

        private DigitalInput m_kBlueButtonDIO;
        private DigitalInput m_kRedButtonDIO;
        
        public ShoulderButtons() {
        m_kBlueButtonDIO = new DigitalInput(ShoulderButtonsConstants.kBlueButtonDIO);
        ShuffleboardTab ShoulderButtonTab = Shuffleboard.getTab("ShoulderButtons");
            ShoulderButtonTab.addBoolean("Blue Button", () -> m_kBlueButtonDIO.get());
           
        m_kRedButtonDIO = new DigitalInput(ShoulderButtonsConstants.kRedButtonDIO);
            ShoulderButtonTab.addBoolean("Red Button", () -> m_kRedButtonDIO.get());
        }

        

    @Override
    public void periodic() {
       
        BlueButtonPressed = m_kBlueButtonDIO.get();
        if (!BlueButtonPressed) {
            System.out.println ("BlueButton True");
        }

        RedButtonPressed = m_kRedButtonDIO.get();
        if (!RedButtonPressed){
            System.out.println ("RedButton True");
        }

         // System.out.println(RedButtonPressed);
          //System.out.println(BlueButtonPressed);


    
}
public static boolean GetRedButtonPressed() {
return RedButtonPressed;

}
public static boolean GetBlueButtonPressed() {
    return BlueButtonPressed;
}

public DigitalInput GetBlueBotton()
{
    return m_kBlueButtonDIO;
}

public DigitalInput GetRedButton()
{
    return m_kRedButtonDIO;
}
}

