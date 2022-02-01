package com.tencent.ttpic.openapi.model;

import android.graphics.Bitmap;

public class StarParam
{
  public static final int TYPE_BLUR = 0;
  public static final int TYPE_PARTICLE = 1;
  public String materialId;
  public Bitmap starBlurColorImage;
  public float starBlurMaxScale = 1.0F;
  public float starBlurMinScale = 1.0F;
  public long starBlurScalePeriod = 1000L;
  public float starMaxThreshold = 1.0F;
  public float starMinThreshold = 0.0F;
  public float starStrength = -1.0F;
  public int starType = 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.StarParam
 * JD-Core Version:    0.7.0.1
 */