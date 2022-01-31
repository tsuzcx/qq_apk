package com.tencent.token.ui.base;

import android.view.animation.Interpolator;

class ay
  implements Interpolator
{
  private ay(GameLoginSndConfirmView paramGameLoginSndConfirmView) {}
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat < 0.3D) {
      return 0.0F;
    }
    paramFloat = (paramFloat - 0.3F) / 0.7F;
    return paramFloat * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ay
 * JD-Core Version:    0.7.0.1
 */