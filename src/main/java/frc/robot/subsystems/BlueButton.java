package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.BlueButtonConstants;

public class BlueButton extends SubsystemBase {
    
    private static DigitalInput m_kBlueButtonDIO = new DigitalInput(BlueButtonConstants.kBlueButtonDIO);
    
//If BUTTON PRSEED????? = ButtonPreased True
//if ButtonPressed = true 
//system.out.println ("Button Works");

@Override
public void periodic() {
System.out.println ("no");
System.out.println (m_kBlueButtonDIO.get());


}



}
