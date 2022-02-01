package com.tencent.mobileqq.shortvideo.dancemachine;

import android.app.Application;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.sveffects.SdkContext;

public class DisplayUtils
{
  private static float DENSITY = 0.0F;
  private static final float DIP = 2.0F;
  
  private static float dip2px(float paramFloat)
  {
    if (DENSITY == 0.0F) {
      DENSITY = SdkContext.getInstance().getApplication().getResources().getDisplayMetrics().density;
    }
    return DENSITY * paramFloat + 0.5F;
  }
  
  public static int pixelToRealPixel(float paramFloat)
  {
    return (int)pixelToRealPixelF(paramFloat);
  }
  
  public static int pixelToRealPixel(float paramFloat1, float paramFloat2)
  {
    return (int)(pixelToRealPixelF(paramFloat1) * paramFloat2);
  }
  
  private static float pixelToRealPixelF(float paramFloat)
  {
    return dip2px(paramFloat / 2.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.DisplayUtils
 * JD-Core Version:    0.7.0.1
 */