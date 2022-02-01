package com.tencent.mobileqq.vashealth;

import android.content.Context;
import android.hardware.SensorManager;
import aqtz;
import com.tencent.common.app.BaseApplicationImpl;

public class SportManager$1
  implements Runnable
{
  public SportManager$1(aqtz paramaqtz) {}
  
  public void run()
  {
    if (aqtz.e == null) {
      aqtz.e = (SensorManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("sensor");
    }
    aqtz.C();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.SportManager.1
 * JD-Core Version:    0.7.0.1
 */