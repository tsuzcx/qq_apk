package com.tencent.av.video.effect.core.qqavimage.beauty;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.av.video.effect.utils.Log;

public class QQAVImageBeautyFilter
  extends QQAVImageFilter
{
  private static final String TAG = "QQAVImageBeautyFilter";
  private float mAmount = 0.3F;
  private float mExposure = 0.0F;
  private QQAVImageBeautyExposureAndOverlayFilter mExposureAndOverlayFilter = new QQAVImageBeautyExposureAndOverlayFilter();
  private int[] mFrameBufferTextures = new int[4];
  private int[] mFrameBuffers = new int[4];
  private QQAVImageBeautyHighPassFilter mHighPassFilter = new QQAVImageBeautyHighPassFilter();
  private boolean mIsNeedSkinColor = true;
  private boolean mIsUseMultiParams = false;
  private float mMixPercent = 0.0F;
  private QQAVImageBeautySharpenAndExposureFilter mSharpenAndExposureFilter = new QQAVImageBeautySharpenAndExposureFilter();
  private float mSharpness = 0.0F;
  private QQAVImageFilter mSkinColorFilter;
  private QQAVImageBeautySkinCurveAndComposeFilter mSkinCurveAndComposeFilter = new QQAVImageBeautySkinCurveAndComposeFilter();
  
  public QQAVImageBeautyFilter()
  {
    this(0.3F);
  }
  
  public QQAVImageBeautyFilter(float paramFloat)
  {
    this(paramFloat, null);
  }
  
  public QQAVImageBeautyFilter(float paramFloat, QQAVImageFilter paramQQAVImageFilter)
  {
    this.mSkinColorFilter = paramQQAVImageFilter;
    this.mIsNeedSkinColor = true;
    super.setQQAVEffectType(5);
    setAmount(paramFloat);
  }
  
  public float getAmount()
  {
    return this.mAmount;
  }
  
  public float getExposure()
  {
    return this.mExposure;
  }
  
  public float getMixPercent()
  {
    return this.mMixPercent;
  }
  
  public float getSharpness()
  {
    return this.mSharpness;
  }
  
  public boolean isUseMultiParams()
  {
    return this.mIsUseMultiParams;
  }
  
  public void onDestroy()
  {
    if (this.mFrameBuffers != null)
    {
      GLES20.glDeleteFramebuffers(this.mFrameBuffers.length, this.mFrameBuffers, 0);
      GLES20.glDeleteTextures(this.mFrameBufferTextures.length, this.mFrameBufferTextures, 0);
    }
    this.mExposureAndOverlayFilter.destroy();
    this.mHighPassFilter.destroy();
    this.mSkinCurveAndComposeFilter.destroy();
    this.mSharpenAndExposureFilter.destroy();
    if (this.mSkinColorFilter != null) {
      this.mSkinColorFilter.destroy();
    }
    super.onDestroy();
  }
  
  public void onDraw2(int paramInt1, int paramInt2)
  {
    runPendingOnDrawTasks();
    if ((!isInitialized()) || (this.mFrameBuffers == null) || (this.mFrameBufferTextures == null)) {
      return;
    }
    if (this.mIsUseMultiParams) {
      Log.d("QQAVImageBeautyFilter", "BeautyFilter onDraw current mixPercent:" + this.mMixPercent + ",sharpness:" + this.mSharpness + ",exposure:" + this.mExposure + ",mIsNeedSkinColor:" + this.mIsNeedSkinColor);
    }
    for (;;)
    {
      this.mExposureAndOverlayFilter.onDraw2(paramInt1, this.mFrameBuffers[0]);
      this.mHighPassFilter.onDraw2(this.mFrameBufferTextures[0], this.mFrameBuffers[1]);
      this.mSkinCurveAndComposeFilter.mFilterSourceTexture2 = this.mFrameBufferTextures[1];
      this.mSkinCurveAndComposeFilter.onDraw2(paramInt1, this.mFrameBuffers[2]);
      if ((!this.mIsNeedSkinColor) || (this.mSkinColorFilter == null)) {
        break;
      }
      this.mSharpenAndExposureFilter.onDraw2(this.mFrameBufferTextures[2], this.mFrameBuffers[3]);
      this.mSkinColorFilter.onDraw2(this.mFrameBufferTextures[3], paramInt2);
      return;
      Log.d("QQAVImageBeautyFilter", "BeautyFilter onDraw current amount:" + this.mAmount + ",mIsNeedSkinColor:" + this.mIsNeedSkinColor);
    }
    this.mSharpenAndExposureFilter.onDraw2(this.mFrameBufferTextures[2], paramInt2);
  }
  
  public void onInit()
  {
    super.onInit();
    this.mExposureAndOverlayFilter.onInit();
    this.mExposureAndOverlayFilter.setExposure(-1.0F);
    this.mHighPassFilter.onInit();
    this.mSkinCurveAndComposeFilter.onInit();
    this.mSharpenAndExposureFilter.onInit();
    if (this.mSkinColorFilter != null) {
      this.mSkinColorFilter.onInit();
    }
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    this.mExposureAndOverlayFilter.onInitialized();
    this.mHighPassFilter.onInitialized();
    this.mSkinCurveAndComposeFilter.onInitialized();
    this.mSharpenAndExposureFilter.onInitialized();
    if (this.mSkinColorFilter != null) {
      this.mSkinColorFilter.onInitialized();
    }
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    int i;
    float f;
    if ((this.mOutputWidth != paramInt1) || (this.mOutputHeight != paramInt2))
    {
      i = 1;
      super.onOutputSizeChanged(paramInt1, paramInt2);
      if (i == 0) {
        break label356;
      }
      if (this.mFrameBuffers != null)
      {
        GLES20.glDeleteFramebuffers(this.mFrameBuffers.length, this.mFrameBuffers, 0);
        GLES20.glDeleteTextures(this.mFrameBufferTextures.length, this.mFrameBufferTextures, 0);
      }
      this.mExposureAndOverlayFilter.onOutputSizeChanged(paramInt1, paramInt2);
      this.mHighPassFilter.onOutputSizeChanged(paramInt1, paramInt2);
      this.mSkinCurveAndComposeFilter.onOutputSizeChanged(paramInt1, paramInt2);
      this.mSharpenAndExposureFilter.onOutputSizeChanged(paramInt1, paramInt2);
      if (this.mSkinColorFilter != null) {
        this.mSkinColorFilter.onOutputSizeChanged(paramInt1, paramInt2);
      }
      if (paramInt1 <= 720) {
        break label305;
      }
      f = 5.0F;
    }
    for (;;)
    {
      label125:
      this.mHighPassFilter.setRadiusInPixels(f);
      int j = this.mFrameBufferTextures.length;
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          GLES20.glGenFramebuffers(1, this.mFrameBuffers, i);
          GLES20.glGenTextures(1, this.mFrameBufferTextures, i);
          GLES20.glBindTexture(3553, this.mFrameBufferTextures[i]);
          GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
          GLES20.glTexParameterf(3553, 10240, 9729.0F);
          GLES20.glTexParameterf(3553, 10241, 9729.0F);
          GLES20.glTexParameterf(3553, 10242, 33071.0F);
          GLES20.glTexParameterf(3553, 10243, 33071.0F);
          GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i]);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mFrameBufferTextures[i], 0);
          GLES20.glBindTexture(3553, 0);
          GLES20.glBindFramebuffer(36160, 0);
          i += 1;
          continue;
          i = 0;
          break;
          label305:
          if ((paramInt1 >= 540) && (paramInt1 <= 720))
          {
            f = 3.0F;
            break label125;
          }
          if ((paramInt1 >= 480) && (paramInt1 < 540))
          {
            f = 2.0F;
            break label125;
          }
          if (paramInt1 >= 480) {
            break label357;
          }
          f = 1.0F;
          break label125;
        }
      }
      label356:
      return;
      label357:
      f = 2.0F;
    }
  }
  
  public void setAmount(float paramFloat)
  {
    if (paramFloat < 0.0D) {
      this.mAmount = 0.0F;
    }
    for (;;)
    {
      paramFloat = this.mAmount * 1.25F;
      if (this.mSkinCurveAndComposeFilter != null) {
        this.mSkinCurveAndComposeFilter.setMixPercent(paramFloat * 10.0F * 0.14F);
      }
      if (this.mSharpenAndExposureFilter != null)
      {
        this.mSharpenAndExposureFilter.setSharpness(paramFloat * 10.0F * 0.03F);
        this.mSharpenAndExposureFilter.setExposure(0.0F);
      }
      this.mIsUseMultiParams = false;
      return;
      if (paramFloat > 1.0D) {
        this.mAmount = 1.0F;
      } else {
        this.mAmount = paramFloat;
      }
    }
  }
  
  public void setBeauty(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < 0.0D)
    {
      this.mMixPercent = 0.0F;
      if (paramFloat2 >= -1.0D) {
        break label121;
      }
      this.mSharpness = -1.0F;
      label27:
      if (paramFloat3 >= -1.0D) {
        break label147;
      }
      this.mExposure = -1.0F;
    }
    for (;;)
    {
      if (this.mSkinCurveAndComposeFilter != null) {
        this.mSkinCurveAndComposeFilter.setMixPercent(this.mMixPercent);
      }
      if (this.mSharpenAndExposureFilter != null)
      {
        this.mSharpenAndExposureFilter.setSharpness(this.mSharpness);
        this.mSharpenAndExposureFilter.setExposure(this.mExposure);
      }
      this.mIsUseMultiParams = true;
      return;
      if (paramFloat1 > 1.75D)
      {
        this.mMixPercent = 1.75F;
        break;
      }
      this.mMixPercent = paramFloat1;
      break;
      label121:
      if (paramFloat2 > 1.5D)
      {
        this.mSharpness = 1.5F;
        break label27;
      }
      this.mSharpness = paramFloat2;
      break label27;
      label147:
      if (paramFloat3 > 1.0D) {
        this.mExposure = 1.0F;
      } else {
        this.mExposure = paramFloat3;
      }
    }
  }
  
  public void setNeedSkinColor(boolean paramBoolean)
  {
    this.mIsNeedSkinColor = paramBoolean;
  }
  
  public void setSkinColorFilter(QQAVImageFilter paramQQAVImageFilter)
  {
    this.mSkinColorFilter = paramQQAVImageFilter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.beauty.QQAVImageBeautyFilter
 * JD-Core Version:    0.7.0.1
 */