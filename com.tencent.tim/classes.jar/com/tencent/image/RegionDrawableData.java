package com.tencent.image;

import android.graphics.Rect;

public class RegionDrawableData
{
  public static final int REGION_STATE_NONE = 0;
  public static final int REGION_STATE_SAMPLE = 1;
  public static final int SCROLL_DIRECTION_NO = 0;
  public static final int SCROLL_DIRECTION_TOLEFT = 1;
  public static final int SCROLL_DIRECTION_TORIGHT = 2;
  public float mDefaultScale;
  public Rect mImageArea;
  int mSample;
  public float mScale;
  public int mScrollDirection;
  public Rect mShowArea;
  public boolean mShowRegion;
  int mSourceDensity;
  public int mState;
  int mTargetDensity;
  public long mTaskTime;
  
  private int scaleToSampleRoundDown(float paramFloat)
  {
    int j = (int)Math.floor(1.0F / paramFloat);
    int i = j;
    if (j > 64) {
      i = 64;
    }
    j = 64;
    while (j != 0)
    {
      int k = i & j;
      if (k != 0) {
        return k;
      }
      j >>= 1;
    }
    return 1;
  }
  
  private int scaleToSampleRoundup(float paramFloat)
  {
    int j = (int)Math.round(1.0D / paramFloat);
    int i = j;
    if (j < 1) {
      i = 1;
    }
    j = i;
    if (i > 64) {
      j = 64;
    }
    i = 64;
    while (i != 0)
    {
      int k = j & i;
      if (k != 0)
      {
        if (((i >> 1 & j) == 0) || ((j & i - 1) == 0)) {
          return k;
        }
        return k << 1;
      }
      i >>= 1;
    }
    return 1;
  }
  
  public int calcSample()
  {
    if (this.mScale == 0.0F) {}
    for (int i = 1;; i = scaleToSampleRoundup(this.mScale * (this.mTargetDensity / this.mSourceDensity)))
    {
      this.mSample = i;
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.RegionDrawableData
 * JD-Core Version:    0.7.0.1
 */