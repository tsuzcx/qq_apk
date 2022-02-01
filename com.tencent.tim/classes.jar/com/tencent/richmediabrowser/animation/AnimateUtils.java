package com.tencent.richmediabrowser.animation;

import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.graphics.PointF;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public final class AnimateUtils
{
  private static float END_TENSION = 0.0F;
  private static final int NB_SAMPLES = 100;
  private static final float[] SPLINE;
  private static float START_TENSION = 0.4F;
  private static float sViscousFluidNormalize = 1.0F / viscousFluid(1.0F);
  private static float sViscousFluidScale;
  
  static
  {
    END_TENSION = 1.0F - START_TENSION;
    SPLINE = new float[101];
    float f1 = 0.0F;
    int i = 0;
    if (i <= 100)
    {
      float f4 = i / 100.0F;
      float f2 = 1.0F;
      for (;;)
      {
        float f3 = (f2 - f1) / 2.0F + f1;
        float f5 = 3.0F * f3 * (1.0F - f3);
        float f6 = ((1.0F - f3) * START_TENSION + END_TENSION * f3) * f5 + f3 * f3 * f3;
        if (Math.abs(f6 - f4) < 1.E-005D)
        {
          SPLINE[i] = (f3 * f3 * f3 + f5);
          i += 1;
          break;
        }
        if (f6 > f4) {
          f2 = f3;
        } else {
          f1 = f3;
        }
      }
    }
    SPLINE[100] = 1.0F;
    sViscousFluidScale = 8.0F;
    sViscousFluidNormalize = 1.0F;
  }
  
  public static float viscousFluid(float paramFloat)
  {
    paramFloat = sViscousFluidScale * paramFloat;
    if (paramFloat < 1.0F) {}
    for (paramFloat -= 1.0F - (float)Math.exp(-paramFloat);; paramFloat = (1.0F - (float)Math.exp(1.0F - paramFloat)) * (1.0F - 0.3678795F) + 0.3678795F) {
      return paramFloat * sViscousFluidNormalize;
    }
  }
  
  public static class AnimationAdapter
    implements Animation.AnimationListener
  {
    public void onAnimationEnd(Animation paramAnimation) {}
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  @TargetApi(11)
  public static class BezierEvaluator
    implements TypeEvaluator<PointF>
  {
    private PointF mPointF;
    
    public BezierEvaluator(PointF paramPointF)
    {
      this.mPointF = paramPointF;
    }
    
    private PointF calculateBezierPointForQuadratic(float paramFloat, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
    {
      PointF localPointF = new PointF();
      float f1 = 1.0F - paramFloat;
      localPointF.x = (f1 * f1 * paramPointF1.x + 2.0F * paramFloat * f1 * paramPointF2.x + paramFloat * paramFloat * paramPointF3.x);
      float f2 = paramPointF1.y;
      localPointF.y = (f1 * (2.0F * paramFloat) * paramPointF2.y + f1 * f1 * f2 + paramFloat * paramFloat * paramPointF3.y);
      return localPointF;
    }
    
    public PointF evaluate(float paramFloat, PointF paramPointF1, PointF paramPointF2)
    {
      return calculateBezierPointForQuadratic(paramFloat, paramPointF1, this.mPointF, paramPointF2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.animation.AnimateUtils
 * JD-Core Version:    0.7.0.1
 */