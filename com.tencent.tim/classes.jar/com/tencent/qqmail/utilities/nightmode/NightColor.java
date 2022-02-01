package com.tencent.qqmail.utilities.nightmode;

import android.graphics.Color;

public class NightColor
  extends Color
{
  private float colorTemp;
  private int darkness;
  
  private int limit(int paramInt)
  {
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt <= 255);
    return 255;
  }
  
  protected int calculateDarkenedColor(int paramInt)
  {
    return (int)((1.0F - this.darkness / 100.0F) * paramInt);
  }
  
  public int getBlue()
  {
    return calculateDarkenedColor(getBlueFromKelvin());
  }
  
  protected int getBlueFromKelvin()
  {
    float f = this.colorTemp / 100.0F;
    if (f >= 66.0F) {
      return 255;
    }
    if (f <= 19.0F) {
      return 0;
    }
    return limit((int)(Math.log(f - 10.0F) * 138.51773122309999D - 305.04479273070001D));
  }
  
  public float getColorTemp()
  {
    return this.colorTemp;
  }
  
  public int getDarkness()
  {
    return this.darkness;
  }
  
  public int getGreen()
  {
    return calculateDarkenedColor(getGreenFromKelvin());
  }
  
  protected int getGreenFromKelvin()
  {
    float f = this.colorTemp / 100.0F;
    if (f <= 66.0F) {}
    for (int i = (int)(Math.log(f) * 99.470802586100007D - 161.11956816610001D);; i = (int)(Math.pow(f - 60.0F, -0.0755148492D) * 288.12216952829999D)) {
      return limit(i);
    }
  }
  
  public int getRed()
  {
    return calculateDarkenedColor(getRedFromKelvin());
  }
  
  protected int getRedFromKelvin()
  {
    float f = this.colorTemp / 100.0F;
    if (f <= 66.0F) {
      return 255;
    }
    return limit((int)(Math.pow(f - 60.0F, -0.1332047592D) * 329.69872744600002D));
  }
  
  public NightColor setColorTemp(float paramFloat)
  {
    float f1 = 40000.0F;
    float f2 = 1000.0F;
    if (paramFloat < 1000.0F) {
      paramFloat = f2;
    }
    for (;;)
    {
      if (paramFloat > 40000.0F) {
        paramFloat = f1;
      }
      for (;;)
      {
        this.colorTemp = paramFloat;
        return this;
      }
    }
  }
  
  public NightColor setDarkness(int paramInt)
  {
    this.darkness = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.nightmode.NightColor
 * JD-Core Version:    0.7.0.1
 */