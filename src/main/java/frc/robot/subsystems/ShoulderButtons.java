package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShoulderButtonsConstants;

public class ShoulderButtons extends SubsystemBase {
    
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
       
        if (!m_kBlueButtonDIO.get()) 
            System.out.println ("BlueButton True");
    
        if (!m_kRedButtonDIO.get())
            System.out.println ("RedButton True");
      
    
}
}
