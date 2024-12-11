package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Timer;

//import frc.robot.subsystems.ShoulderButtons;


public class LEDs extends SubsystemBase {
    private AddressableLEDBuffer m_ledBuffer = new AddressableLEDBuffer(48);
   // PWM port 9
    // Must be a PWM header, not MXP or DIO
    private AddressableLED m_led = new AddressableLED(9);
    private Boolean RainbowMode = false;
    private Timer ScrollTimer = new Timer();

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

@Override
public void periodic() {
  // This method will be called once per scheduler run
  if (RainbowMode == true) this.ScrollRainbow();
  
}

public void SetToRed()
{
  RainbowMode = false;
  for (int i = 0; i < m_ledBuffer.getLength(); i++) {
        m_ledBuffer.setRGB(i, 0, 0, 255); 
      }
      m_led.setData(m_ledBuffer);
}

public void SetToBlue()
{
  RainbowMode = false;
  for (int i = 0; i < m_ledBuffer.getLength(); i++) {
        m_ledBuffer.setRGB(i, 255, 0, 0); 
      }
      m_led.setData(m_ledBuffer);
}
public void SetToWhite()
{
  RainbowMode = false;
  for (int i = 0; i < m_ledBuffer.getLength(); i++) {
      m_ledBuffer.setRGB(i ,255, 255, 255);
  }
  m_led.setData(m_ledBuffer);

}


public void SetToPurple()
{
  RainbowMode = false;
  for (int i = 0; i < m_ledBuffer.getLength(); i++) {
      m_ledBuffer.setRGB(i ,255, 0, 255);
      
  }
  m_led.setData(m_ledBuffer);

}

public void SetToRainbow()
{
  RainbowMode = true;
  for (int i = 0; i < m_ledBuffer.getLength(); i++) {
      if (i % 7 == 0) m_ledBuffer.setRGB(i ,255, 0, 0);  // Red
      if (i % 7 == 1) m_ledBuffer.setRGB(i ,255, 127, 0);  // Orange
      if (i % 7 == 2) m_ledBuffer.setRGB(i ,255, 255, 0);  // Yellow
      if (i % 7 == 3) m_ledBuffer.setRGB(i ,0, 255, 0);  // Green
      if (i % 7 == 4) m_ledBuffer.setRGB(i ,0, 0, 255);  // Blue
      if (i % 7 == 5) m_ledBuffer.setRGB(i ,75, 0, 130);  // Indego
      if (i % 7 == 6) m_ledBuffer.setRGB(i ,148, 0, 211);  // Violet
  }
  m_led.setData(m_ledBuffer);

  ScrollTimer.reset();
  ScrollTimer.start();

}
public void ScrollRainbow()
{
  for (int i = 0; i < m_ledBuffer.getLength(); i++) {
      switch ((i + (int) ScrollTimer.get()) % 7){  //should cause colours to scoll every second.
      case 0: 
        m_ledBuffer.setRGB(i ,255, 0, 0);  // Red
        break;
      case 1: 
        m_ledBuffer.setRGB(i ,255, 127, 0);  // Orange
        break;
      case 2: 
        m_ledBuffer.setRGB(i ,255, 255, 0);  // Yellow
        break;
      case 3: 
        m_ledBuffer.setRGB(i ,0, 255, 0);  // Green
        break;
      case 4: 
        m_ledBuffer.setRGB(i ,0, 0, 255);  // Blue
        break;
      case 5: 
        m_ledBuffer.setRGB(i ,75, 0, 130);  // Indego
        break;
      case 6: 
        m_ledBuffer.setRGB(i ,148, 0, 211);  // Violet
        break;
      }
    }
    m_led.setData(m_ledBuffer);

  }
}
   


  

  
  
    






    