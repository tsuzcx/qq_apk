package com.tencent.qqmail.scroller;

import android.view.animation.Interpolator;

public class SinInterpolater
  implements Interpolator
{
  private static final float AMPLITUDE_MANIPULATE = 1.570796F;
  private static float coefficient = 0.4F;
  
  public static float sinInterpolation(float paramFloat)
  {
    return (float)Math.sin(1.570796370506287D * Math.pow(paramFloat, coefficient));
  }
  
  public float getInterpolation(float paramFloat)
  {
    return sinInterpolation(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.scroller.SinInterpolater
 * JD-Core Version:    0.7.0.1
 */