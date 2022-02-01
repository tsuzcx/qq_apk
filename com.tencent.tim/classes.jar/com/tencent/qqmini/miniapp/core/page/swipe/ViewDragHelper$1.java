package com.tencent.qqmini.miniapp.core.page.swipe;

import android.view.animation.Interpolator;

final class ViewDragHelper$1
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.swipe.ViewDragHelper.1
 * JD-Core Version:    0.7.0.1
 */