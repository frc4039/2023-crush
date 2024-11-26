package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import frc.robot.subsystems.ShoulderButtons;


public class LEDs extends SubsystemBase {
    private AddressableLEDBuffer m_ledBuffer = new AddressableLEDBuffer(48);
   // PWM port 9
    // Must be a PWM header, not MXP or DIO
    private AddressableLED m_led = new AddressableLED(9);

    public LEDs () {

    // Reuse buffer
    // Default to a length of 60, start empty output
    // Length is expensive to set, so only set it once, then just update data
    m_led.setLength(m_ledBuffer.getLength());
    
    // Set the data
    m_led.setData(m_ledBuffer);
    m_led.start();

    for (int i = 0; i < m_ledBuffer.getLength(); i++) {
      // Sets the specified LED to the RGB values for red
      m_ledBuffer.setRGB(i, 255, 255, 255); 
    }
    m_led.setData(m_ledBuffer);

 
}

public void SetToRed()
{
  for (int i = 0; i < m_ledBuffer.getLength(); i++) {
        m_ledBuffer.setRGB(i, 0, 255, 0); 
      }
      m_led.setData(m_ledBuffer);
}

public void SetToBlue()
{
  for (int i = 0; i < m_ledBuffer.getLength(); i++) {
        m_ledBuffer.setRGB(i, 255, 0, 0); 
      }
      m_led.setData(m_ledBuffer);
}
public void SetToWhite()
{
  for (int i = 0; i < m_ledBuffer.getLength(); i++) {
      m_ledBuffer.setRGB(i ,255, 255, 255);
  }
  m_led.setData(m_ledBuffer);

  }


public void SetToPurple()
{
  for (int i = 0; i < m_ledBuffer.getLength(); i++) {
      m_ledBuffer.setRGB(i ,255, 0, 255);
      
  }
  m_led.setData(m_ledBuffer);

}

}




    
/* 
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
      // Sets the specified LED to the HSV values for red
      m_ledBuffer.setHSV(i, 0, 100, 100);
   }
   
   m_led.setData(m_ledBuffer);

*/


  

  
  
    






    