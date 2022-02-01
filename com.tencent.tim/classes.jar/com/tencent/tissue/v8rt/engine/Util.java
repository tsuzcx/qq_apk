package com.tencent.tissue.v8rt.engine;

import android.os.Build;
import android.os.Build.VERSION;

public class Util
{
  public static final String DEVICE;
  public static final String MANUFACTURER;
  public static final int SDK_INT;
  
  static
  {
    if ((Build.VERSION.SDK_INT == 25) && (Build.VERSION.CODENAME.charAt(0) == 'O')) {}
    for (int i = 26;; i = Build.VERSION.SDK_INT)
    {
      SDK_INT = i;
      DEVICE = Build.DEVICE;
      MANUFACTURER = Build.MANUFACTURER;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.Util
 * JD-Core Version:    0.7.0.1
 */