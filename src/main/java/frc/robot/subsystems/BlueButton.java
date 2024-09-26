package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.BlueButtonConstants;

public class BlueButton extends SubsystemBase {
    
        private static DigitalInput m_kBlueButtonDIO = new DigitalInput(BlueButtonConstants.kBlueButtonDIO);
        
        public BlueButton() {
        ShuffleboardTab crushTab = Shuffleboard.getTab("Cameron");
            crushTab.addBoolean("BlueButton", () -> m_kBlueButtonDIO.get());

        }
    @Override
    public void periodic() {
        if (m_kBlueButtonDIO.get()) 
            System.out.println ("yes");
        else 
            System.out.println ("no"); 
    }
}
