package com.tencent.qqmail.calendar.view;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class TranslateValueAnimation
  extends Animation
{
  private float mCurrentXValue = 0.0F;
  private float mCurrentYValue = 0.0F;
  private long mDuration = 0L;
  private float mFirstXDelta;
  private float mFirstYDelta;
  private float mInterpolatedTime;
  private float mToXDelta;
  private float mToYDelta;
  
  public TranslateValueAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong)
  {
    this.mFirstXDelta = paramFloat1;
    this.mToXDelta = paramFloat2;
    this.mFirstYDelta = paramFloat3;
    this.mToYDelta = paramFloat4;
    this.mDuration = paramLong;
  }
  
  private void resetValue(float paramFloat1, float paramFloat2)
  {
    this.mToXDelta = paramFloat1;
    this.mToYDelta = paramFloat2;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    this.mInterpolatedTime = paramFloat;
    float f1 = this.mToXDelta - (this.mFirstXDelta + this.mCurrentXValue);
    float f2 = this.mToYDelta - (this.mFirstYDelta + this.mCurrentYValue);
    if (Math.abs(this.mFirstXDelta + this.mCurrentXValue - this.mToXDelta) > 1.0E-007D) {
      f1 = this.mCurrentXValue + (this.mToXDelta - (this.mFirstXDelta + this.mCurrentXValue)) * paramFloat;
    }
    if (Math.abs(this.mFirstYDelta + this.mCurrentYValue - this.mToYDelta) > 1.0E-007D) {
      f2 = this.mCurrentYValue + (this.mToYDelta - (this.mFirstYDelta + this.mCurrentYValue)) * paramFloat;
    }
    paramTransformation.getMatrix().setTranslate(f1, f2);
  }
  
  public void continueValueAnimation(float paramFloat1, float paramFloat2)
  {
    float f1 = 1.0F;
    long l;
    if (this.mInterpolatedTime > 1.0F) {
      l = this.mDuration;
    }
    for (;;)
    {
      this.mCurrentXValue += (this.mToXDelta - (this.mFirstXDelta + this.mCurrentXValue)) * f1;
      float f2 = this.mCurrentYValue;
      this.mCurrentYValue = (f1 * (this.mToYDelta - (this.mFirstYDelta + this.mCurrentYValue)) + f2);
      this.mDuration = l;
      setDuration(l);
      resetValue(paramFloat1, paramFloat2);
      return;
      l = ((1.0F - this.mInterpolatedTime) * (float)this.mDuration);
      f1 = this.mInterpolatedTime;
    }
  }
  
  public float getToDeltaX()
  {
    return this.mToXDelta;
  }
  
  public float getToDeltaY()
  {
    return this.mToYDelta;
  }
  
  public void reStartValueAnimation(float paramFloat1, float paramFloat2)
  {
    float f1 = 1.0F;
    if (this.mInterpolatedTime >= 1.0F) {}
    for (long l = this.mDuration;; l = (this.mInterpolatedTime * (float)this.mDuration))
    {
      this.mCurrentXValue += (this.mToXDelta - (this.mFirstXDelta + this.mCurrentXValue)) * f1;
      float f2 = this.mCurrentYValue;
      this.mCurrentYValue = (f1 * (this.mToYDelta - (this.mFirstYDelta + this.mCurrentYValue)) + f2);
      setDuration(l);
      resetValue(paramFloat1, paramFloat2);
      return;
      f1 = this.mInterpolatedTime;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.TranslateValueAnimation
 * JD-Core Version:    0.7.0.1
 */