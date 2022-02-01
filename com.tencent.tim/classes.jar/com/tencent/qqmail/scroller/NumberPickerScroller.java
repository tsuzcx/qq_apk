package com.tencent.qqmail.scroller;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class NumberPickerScroller
{
  private static float ALPHA = 0.0F;
  private static float DECELERATION_RATE = (float)(Math.log(0.75D) / Math.log(0.9D));
  private static final int DEFAULT_DURATION = 250;
  private static float END_TENSION = 0.0F;
  private static final int FLING_MODE = 1;
  private static final int NB_SAMPLES = 100;
  private static final int SCROLL_MODE = 0;
  private static final float[] SPLINE;
  private static float START_TENSION;
  private static float sViscousFluidNormalize = 1.0F / viscousFluid(1.0F);
  private static float sViscousFluidScale;
  private int mCurrX;
  private int mCurrY;
  private float mDeceleration;
  private float mDeltaX;
  private float mDeltaY;
  private int mDuration;
  private float mDurationReciprocal;
  private int mFinalX;
  private int mFinalY;
  private boolean mFinished = true;
  private boolean mFlywheel;
  private Interpolator mInterpolator;
  private int mMaxX;
  private int mMaxY;
  private int mMinX;
  private int mMinY;
  private int mMode;
  private final float mPpi;
  private long mStartTime;
  private int mStartX;
  private int mStartY;
  private float mVelocity;
  
  static
  {
    ALPHA = 800.0F;
    START_TENSION = 0.4F;
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
  
  public NumberPickerScroller(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NumberPickerScroller(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public NumberPickerScroller(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.mInterpolator = paramInterpolator;
    this.mPpi = (paramContext.getResources().getDisplayMetrics().density * 160.0F);
    this.mDeceleration = computeDeceleration(ViewConfiguration.getScrollFriction());
    this.mFlywheel = paramBoolean;
  }
  
  private float computeDeceleration(float paramFloat)
  {
    return 386.0878F * this.mPpi * paramFloat;
  }
  
  static float viscousFluid(float paramFloat)
  {
    paramFloat = sViscousFluidScale * paramFloat;
    if (paramFloat < 1.0F) {}
    for (paramFloat -= 1.0F - (float)Math.exp(-paramFloat);; paramFloat = (1.0F - (float)Math.exp(1.0F - paramFloat)) * (1.0F - 0.3678795F) + 0.3678795F) {
      return paramFloat * sViscousFluidNormalize;
    }
  }
  
  public void abortAnimation()
  {
    this.mCurrX = this.mFinalX;
    this.mCurrY = this.mFinalY;
    this.mFinished = true;
  }
  
  public boolean computeScrollOffset()
  {
    if (this.mFinished) {
      return false;
    }
    int i = (int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
    if (i < this.mDuration) {
      switch (this.mMode)
      {
      }
    }
    for (;;)
    {
      return true;
      float f1 = i * this.mDurationReciprocal;
      if (this.mInterpolator == null) {}
      for (f1 = viscousFluid(f1);; f1 = this.mInterpolator.getInterpolation(f1))
      {
        this.mCurrX = (this.mStartX + Math.round(this.mDeltaX * f1));
        i = this.mStartY;
        this.mCurrY = (Math.round(f1 * this.mDeltaY) + i);
        break;
      }
      f1 = i / this.mDuration;
      i = (int)(100.0F * f1);
      float f2 = i / 100.0F;
      float f3 = (i + 1) / 100.0F;
      float f4 = SPLINE[i];
      float f5 = SPLINE[(i + 1)];
      f1 = (f1 - f2) / (f3 - f2) * (f5 - f4) + f4;
      this.mCurrX = (this.mStartX + Math.round((this.mFinalX - this.mStartX) * f1));
      this.mCurrX = Math.min(this.mCurrX, this.mMaxX);
      this.mCurrX = Math.max(this.mCurrX, this.mMinX);
      i = this.mStartY;
      this.mCurrY = (Math.round(f1 * (this.mFinalY - this.mStartY)) + i);
      this.mCurrY = Math.min(this.mCurrY, this.mMaxY);
      this.mCurrY = Math.max(this.mCurrY, this.mMinY);
      if ((this.mCurrX == this.mFinalX) && (this.mCurrY == this.mFinalY))
      {
        this.mFinished = true;
        continue;
        this.mCurrX = this.mFinalX;
        this.mCurrY = this.mFinalY;
        this.mFinished = true;
      }
    }
  }
  
  public void extendDuration(int paramInt)
  {
    this.mDuration = (timePassed() + paramInt);
    this.mDurationReciprocal = (1.0F / this.mDuration);
    this.mFinished = false;
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int j = paramInt3;
    int i = paramInt4;
    float f1;
    if (this.mFlywheel)
    {
      j = paramInt3;
      i = paramInt4;
      if (!this.mFinished)
      {
        f1 = getCurrVelocity();
        float f4 = this.mFinalX - this.mStartX;
        f2 = this.mFinalY - this.mStartY;
        float f3 = (float)Math.sqrt(f4 * f4 + f2 * f2);
        f4 /= f3;
        f2 /= f3;
        f3 = f4 * f1;
        f1 *= f2;
        j = paramInt3;
        i = paramInt4;
        if (Math.signum(paramInt3) == Math.signum(f3))
        {
          j = paramInt3;
          i = paramInt4;
          if (Math.signum(paramInt4) == Math.signum(f1))
          {
            j = (int)(f3 + paramInt3);
            i = (int)(f1 + paramInt4);
          }
        }
      }
    }
    this.mMode = 1;
    this.mFinished = false;
    float f2 = (float)Math.sqrt(j * j + i * i);
    this.mVelocity = f2;
    double d = Math.log(START_TENSION * f2 / ALPHA);
    this.mDuration = ((int)(1000.0D * Math.exp(d / (DECELERATION_RATE - 1.0D))));
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mStartX = paramInt1;
    this.mStartY = paramInt2;
    if (f2 == 0.0F)
    {
      f1 = 1.0F;
      if (f2 != 0.0F) {
        break label420;
      }
    }
    label420:
    for (f2 = 1.0F;; f2 = i / f2)
    {
      paramInt3 = (int)(ALPHA * Math.exp(d * (DECELERATION_RATE / (DECELERATION_RATE - 1.0D))));
      this.mMinX = paramInt5;
      this.mMaxX = paramInt6;
      this.mMinY = paramInt7;
      this.mMaxY = paramInt8;
      this.mFinalX = (Math.round(f1 * paramInt3) + paramInt1);
      this.mFinalX = Math.min(this.mFinalX, this.mMaxX);
      this.mFinalX = Math.max(this.mFinalX, this.mMinX);
      this.mFinalY = (Math.round(f2 * paramInt3) + paramInt2);
      this.mFinalY = Math.min(this.mFinalY, this.mMaxY);
      this.mFinalY = Math.max(this.mFinalY, this.mMinY);
      return;
      f1 = j / f2;
      break;
    }
  }
  
  public final void forceFinished(boolean paramBoolean)
  {
    this.mFinished = paramBoolean;
  }
  
  public float getCurrVelocity()
  {
    return this.mVelocity - this.mDeceleration * timePassed() / 2000.0F;
  }
  
  public final int getCurrX()
  {
    return this.mCurrX;
  }
  
  public final int getCurrY()
  {
    return this.mCurrY;
  }
  
  public final int getDuration()
  {
    return this.mDuration;
  }
  
  public final int getFinalX()
  {
    return this.mFinalX;
  }
  
  public final int getFinalY()
  {
    return this.mFinalY;
  }
  
  public final int getStartX()
  {
    return this.mStartX;
  }
  
  public final int getStartY()
  {
    return this.mStartY;
  }
  
  public final boolean isFinished()
  {
    return this.mFinished;
  }
  
  public boolean isScrollingInDirection(float paramFloat1, float paramFloat2)
  {
    return (!this.mFinished) && (Math.signum(paramFloat1) == Math.signum(this.mFinalX - this.mStartX)) && (Math.signum(paramFloat2) == Math.signum(this.mFinalY - this.mStartY));
  }
  
  public void setFinalX(int paramInt)
  {
    this.mFinalX = paramInt;
    this.mDeltaX = (this.mFinalX - this.mStartX);
    this.mFinished = false;
  }
  
  public void setFinalY(int paramInt)
  {
    this.mFinalY = paramInt;
    this.mDeltaY = (this.mFinalY - this.mStartY);
    this.mFinished = false;
  }
  
  public final void setFriction(float paramFloat)
  {
    this.mDeceleration = computeDeceleration(paramFloat);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    startScroll(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mMode = 0;
    this.mFinished = false;
    this.mDuration = paramInt5;
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mStartX = paramInt1;
    this.mStartY = paramInt2;
    this.mFinalX = (paramInt1 + paramInt3);
    this.mFinalY = (paramInt2 + paramInt4);
    this.mDeltaX = paramInt3;
    this.mDeltaY = paramInt4;
    this.mDurationReciprocal = (1.0F / this.mDuration);
  }
  
  public int timePassed()
  {
    return (int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.scroller.NumberPickerScroller
 * JD-Core Version:    0.7.0.1
 */