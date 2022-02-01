package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;

public class QQAVImageToonFilter
  extends QQAVImage3x3TextureSamplingFilter
{
  float mQuantizationLevels;
  int mQuantizationLevelsLocation;
  float mThreshold;
  int mThresholdLocation;
  
  public QQAVImageToonFilter()
  {
    this(0.2F, 10.0F);
    super.setQQAVEffectType(4);
  }
  
  public QQAVImageToonFilter(float paramFloat1, float paramFloat2)
  {
    super(String.valueOf(19));
    this.mThreshold = paramFloat1;
    this.mQuantizationLevels = paramFloat2;
    super.setQQAVEffectType(4);
  }
  
  public void onInit()
  {
    super.onInit();
    this.mThresholdLocation = GLES20.glGetUniformLocation(getProgram(), "threshold");
    this.mQuantizationLevelsLocation = GLES20.glGetUniformLocation(getProgram(), "quantizationLevels");
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    setThreshold(this.mThreshold);
    setQuantizationLevels(this.mQuantizationLevels);
  }
  
  public void setQuantizationLevels(float paramFloat)
  {
    this.mQuantizationLevels = paramFloat;
    setFloat(this.mQuantizationLevelsLocation, paramFloat);
  }
  
  public void setThreshold(float paramFloat)
  {
    this.mThreshold = paramFloat;
    setFloat(this.mThresholdLocation, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageToonFilter
 * JD-Core Version:    0.7.0.1
 */