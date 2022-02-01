package com.tencent.av.video.effect.core.qqavimage.denoise;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFourInputFilter;

public class QQAVImageDenoiseVDCalAndPredFilter
  extends QQAVImageFourInputFilter
{
  private float mUpdateRateGlobal;
  private int mUpdateRateGlobalLocation;
  private float mUpdateRateLocal;
  private int mUpdateRateLocalLocation;
  
  public QQAVImageDenoiseVDCalAndPredFilter()
  {
    this(0.02F, 15.0F);
  }
  
  public QQAVImageDenoiseVDCalAndPredFilter(float paramFloat1, float paramFloat2)
  {
    super(String.valueOf(27));
    setUpdateRateGlobal(paramFloat1);
    setUpdateRateLocal(paramFloat2);
  }
  
  public void onInit()
  {
    super.onInit();
    this.mUpdateRateGlobalLocation = GLES20.glGetUniformLocation(getProgram(), "updaterateglobal");
    this.mUpdateRateLocalLocation = GLES20.glGetUniformLocation(getProgram(), "updateratelocal");
  }
  
  public void setUpdateRateGlobal(float paramFloat)
  {
    this.mUpdateRateGlobal = paramFloat;
    setFloat(this.mUpdateRateGlobalLocation, this.mUpdateRateGlobal);
  }
  
  public void setUpdateRateLocal(float paramFloat)
  {
    this.mUpdateRateLocal = (paramFloat / 100.0F);
    setFloat(this.mUpdateRateLocalLocation, this.mUpdateRateLocal);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.denoise.QQAVImageDenoiseVDCalAndPredFilter
 * JD-Core Version:    0.7.0.1
 */