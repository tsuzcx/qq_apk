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
    int j = (int)Math.ceil(1.0F / paramFloat);
    int i = j;
    if (j > 64) {
      i = 64;
    }
    j = 64;
    while (j != 0)
    {
      int k = i & j;
      if (k != 0)
      {
        j = k;
        if ((i - 1 & i) != 0) {
          j = k << 1;
        }
        return j;
      }
      j >>= 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.image.RegionDrawableData
 * JD-Core Version:    0.7.0.1
 */