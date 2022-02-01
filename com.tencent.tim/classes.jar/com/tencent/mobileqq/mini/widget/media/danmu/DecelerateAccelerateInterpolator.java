package com.tencent.mobileqq.mini.widget.media.danmu;

import android.view.animation.Interpolator;

public class DecelerateAccelerateInterpolator
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    return (float)Math.tan((paramFloat * 2.0F - 1.0F) / 4.0F * 3.141592653589793D) / 2.0F + 0.5F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.danmu.DecelerateAccelerateInterpolator
 * JD-Core Version:    0.7.0.1
 */