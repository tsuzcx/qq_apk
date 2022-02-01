package com.tencent.qqmail.scroller;

import android.view.MotionEvent;

public class FastVelocityTracker
{
  static final int LONGEST_PAST_TIME = 200;
  static final int NUM_PAST = 10;
  int mLastTouch;
  final long[] mPastTime = new long[10];
  final float[] mPastX = new float[10];
  final float[] mPastY = new float[10];
  float mXVelocity;
  float mYVelocity;
  
  public void addMovement(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getHistorySize();
    int i = this.mLastTouch + 1;
    this.mLastTouch = i;
    if (i >= 10) {
      this.mLastTouch = 0;
    }
    i = 0;
    while (i < j)
    {
      this.mPastX[this.mLastTouch] = paramMotionEvent.getHistoricalX(i);
      this.mPastY[this.mLastTouch] = paramMotionEvent.getHistoricalY(i);
      this.mPastTime[this.mLastTouch] = paramMotionEvent.getHistoricalEventTime(i);
      int k = this.mLastTouch + 1;
      this.mLastTouch = k;
      if (k >= 10) {
        this.mLastTouch = 0;
      }
      i += 1;
    }
    this.mPastX[this.mLastTouch] = paramMotionEvent.getX();
    this.mPastY[this.mLastTouch] = paramMotionEvent.getY();
    this.mPastTime[this.mLastTouch] = paramMotionEvent.getEventTime();
  }
  
  public void clear()
  {
    long[] arrayOfLong = this.mPastTime;
    int i = 0;
    while (i < 10)
    {
      arrayOfLong[i] = -9223372036854775808L;
      i += 1;
    }
  }
  
  public void computeCurrentVelocity(int paramInt)
  {
    computeCurrentVelocity(paramInt, 3.4028235E+38F);
  }
  
  public void computeCurrentVelocity(int paramInt, float paramFloat)
  {
    float[] arrayOfFloat1 = this.mPastX;
    float[] arrayOfFloat2 = this.mPastY;
    long[] arrayOfLong = this.mPastTime;
    int m = this.mLastTouch;
    if (arrayOfLong[m] != -9223372036854775808L)
    {
      f1 = (float)(arrayOfLong[m] - 200L);
      i = (m + 10 - 1) % 10;
      j = m;
      for (;;)
      {
        k = j;
        if ((float)arrayOfLong[i] < f1) {
          break;
        }
        k = j;
        if (i == m) {
          break;
        }
        j = i;
        i = (i + 10 - 1) % 10;
      }
    }
    int k = m;
    float f6 = arrayOfFloat1[k];
    float f7 = arrayOfFloat2[k];
    long l = arrayOfLong[k];
    float f1 = 0.0F;
    float f2 = 0.0F;
    int j = (m - k + 10) % 10 + 1;
    int i = j;
    if (j > 3) {
      i = j - 1;
    }
    j = 1;
    while (j < i)
    {
      m = (k + j) % 10;
      int n = (int)(arrayOfLong[m] - l);
      float f3;
      if (n == 0)
      {
        f3 = f1;
        f1 = f2;
        j += 1;
        f2 = f1;
        f1 = f3;
      }
      else
      {
        float f4 = (arrayOfFloat1[m] - f6) / n * paramInt;
        if (f1 == 0.0F) {}
        for (;;)
        {
          float f5 = (arrayOfFloat2[m] - f7) / n * paramInt;
          f3 = f4;
          f1 = f5;
          if (f2 == 0.0F) {
            break;
          }
          f1 = (f5 + f2) * 0.5F;
          f3 = f4;
          break;
          f4 = (f4 + f1) * 0.5F;
        }
      }
    }
    if (f1 < 0.0F)
    {
      f1 = Math.max(f1, -paramFloat);
      this.mXVelocity = f1;
      if (f2 >= 0.0F) {
        break label356;
      }
    }
    label356:
    for (paramFloat = Math.max(f2, -paramFloat);; paramFloat = Math.min(f2, paramFloat))
    {
      this.mYVelocity = paramFloat;
      return;
      f1 = Math.min(f1, paramFloat);
      break;
    }
  }
  
  public float getXVelocity()
  {
    return this.mXVelocity;
  }
  
  public float getYVelocity()
  {
    return this.mYVelocity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.scroller.FastVelocityTracker
 * JD-Core Version:    0.7.0.1
 */