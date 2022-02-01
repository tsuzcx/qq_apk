package com.tencent.qqmail.scroller;

import android.view.animation.Interpolator;

public class ViscousFluidInterpolater
  implements Interpolator
{
  static final float MidValue = 0.3678795F;
  static float mViscousFluidNormalize = 1.0F / viscousFluid(1.0F);
  static final float mViscousFluidScale = 8.0F;
  
  public static float viscousFluid(float paramFloat)
  {
    paramFloat = 8.0F * paramFloat;
    if (paramFloat < 1.0F) {}
    for (paramFloat -= 1.0F - (float)Math.exp(-paramFloat);; paramFloat = (1.0F - (float)Math.exp(1.0F - paramFloat)) * 0.6321206F + 0.3678795F) {
      return paramFloat * mViscousFluidNormalize;
    }
  }
  
  public float getInterpolation(float paramFloat)
  {
    return viscousFluid(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.scroller.ViscousFluidInterpolater
 * JD-Core Version:    0.7.0.1
 */