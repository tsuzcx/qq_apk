package com.tencent.mobileqq.activity.recent;

import android.view.animation.Interpolator;

public class DrawerFrame$SmoothInterpolator
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    return (float)(Math.pow(paramFloat - 1.0D, 5.0D) + 1.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.DrawerFrame.SmoothInterpolator
 * JD-Core Version:    0.7.0.1
 */