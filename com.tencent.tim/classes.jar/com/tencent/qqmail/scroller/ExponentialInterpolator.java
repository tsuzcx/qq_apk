package com.tencent.qqmail.scroller;

import android.view.animation.Interpolator;

public class ExponentialInterpolator
  implements Interpolator
{
  public static final int EASE_IN = 1;
  public static final int EASE_IN_OUT = 2;
  public static final int EASE_OUT = 0;
  int mType;
  
  public ExponentialInterpolator() {}
  
  public ExponentialInterpolator(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public float getInterpolation(float paramFloat)
  {
    switch (this.mType)
    {
    default: 
      return paramFloat;
    case 0: 
      return 1.0F - (float)Math.pow(2.0D, -10.0F * paramFloat);
    case 1: 
      return (float)Math.pow(2.0D, 10.0F * paramFloat - 10.0F);
    }
    paramFloat = 2.0F * paramFloat;
    if (paramFloat < 1.0F) {
      return (float)Math.pow(2.0D, paramFloat * 10.0F - 10.0F) * 0.5F;
    }
    return (float)Math.pow(2.0D, 10.0F - paramFloat * 10.0F) * 0.5F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.scroller.ExponentialInterpolator
 * JD-Core Version:    0.7.0.1
 */