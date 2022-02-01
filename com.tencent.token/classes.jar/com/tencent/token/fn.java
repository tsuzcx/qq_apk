package com.tencent.token;

import android.view.animation.Interpolator;

abstract class fn
  implements Interpolator
{
  private final float[] a;
  private final float b;
  
  protected fn(float[] paramArrayOfFloat)
  {
    this.a = paramArrayOfFloat;
    this.b = (1.0F / (this.a.length - 1));
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    float[] arrayOfFloat = this.a;
    int i = Math.min((int)((arrayOfFloat.length - 1) * paramFloat), arrayOfFloat.length - 2);
    float f1 = i;
    float f2 = this.b;
    paramFloat = (paramFloat - f1 * f2) / f2;
    arrayOfFloat = this.a;
    return arrayOfFloat[i] + paramFloat * (arrayOfFloat[(i + 1)] - arrayOfFloat[i]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fn
 * JD-Core Version:    0.7.0.1
 */