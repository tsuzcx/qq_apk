package com.tencent.aekit.api.standard.filter;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.RealTimeSmoothFilterV3;

public class AESmoothPrev3
  extends AEChainI
{
  private int frameIndex = 0;
  private boolean isDenoise = false;
  private boolean isInited = false;
  private Frame[] mBeforeDenoiseFrame = new Frame[2];
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private int mFaceDetHeight;
  private int mFaceDetWidth;
  private PTFaceAttr mPTFaceAttr;
  private RealTimeSmoothFilterV3 mRealTimeSmoothFilter = new RealTimeSmoothFilterV3();
  private int mRotation;
  private float sharpenFactor;
  private int smoothLevel;
  private int smoothSharpenHeight;
  private int smoothSharpenWidth;
  
  public void apply()
  {
    if (this.isInited) {
      return;
    }
    this.mRealTimeSmoothFilter.initial();
    this.mCopyFilter.applyFilterChain(true, 0.0F, 0.0F);
    int i = 0;
    while (i < this.mBeforeDenoiseFrame.length)
    {
      this.mBeforeDenoiseFrame[i] = new Frame();
      i += 1;
    }
    this.isInited = true;
  }
  
  public void clear()
  {
    if (this.mRealTimeSmoothFilter != null)
    {
      this.mRealTimeSmoothFilter.clear();
      this.mRealTimeSmoothFilter = null;
    }
    if (this.mCopyFilter != null)
    {
      this.mCopyFilter.ClearGLSL();
      this.mCopyFilter = null;
    }
    Frame[] arrayOfFrame = this.mBeforeDenoiseFrame;
    int j = arrayOfFrame.length;
    int i = 0;
    while (i < j)
    {
      arrayOfFrame[i].clear();
      i += 1;
    }
    this.frameIndex = 0;
    this.isDenoise = false;
    this.isInited = false;
  }
  
  public void enableDenoise(boolean paramBoolean)
  {
    if (this.isDenoise != paramBoolean)
    {
      this.isDenoise = paramBoolean;
      this.frameIndex = 0;
    }
  }
  
  public String printParamInfo()
  {
    return "AESmoothPrev2 {smoothLevel=" + this.smoothLevel + ", smoothSharpenWidth=" + this.smoothSharpenWidth + ", smoothSharpenHeight=" + this.smoothSharpenHeight + ", isDenoise=" + this.isDenoise + ", sharpenFactor=" + this.sharpenFactor + '}';
  }
  
  public Frame render(Frame paramFrame)
  {
    if (this.mRealTimeSmoothFilter == null) {
      return null;
    }
    this.frameIndex += 1;
    if ((this.isDenoise) && (this.frameIndex > 10))
    {
      this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mBeforeDenoiseFrame[(this.frameIndex % 2)]);
      this.mRealTimeSmoothFilter.updateLastFrameForDenoise(this.mBeforeDenoiseFrame[((this.frameIndex + 1) % 2)]);
    }
    return this.mRealTimeSmoothFilter.updateAndRender(paramFrame, this.mPTFaceAttr, this.mFaceDetWidth, this.mFaceDetHeight, this.mRotation);
  }
  
  public void setFaceStatus(PTFaceAttr paramPTFaceAttr, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mPTFaceAttr = paramPTFaceAttr;
    this.mFaceDetWidth = paramInt1;
    this.mFaceDetHeight = paramInt2;
    this.mRotation = paramInt3;
  }
  
  public void setGenderCoefficient(int paramInt1, int paramInt2)
  {
    if (this.mRealTimeSmoothFilter != null)
    {
      this.mRealTimeSmoothFilter.updateFemalePercent(paramInt2 / 100.0F);
      this.mRealTimeSmoothFilter.updateMalePercent(paramInt1 / 100.0F);
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    if (this.mRealTimeSmoothFilter != null) {
      this.mRealTimeSmoothFilter.setRenderMode(paramInt);
    }
  }
  
  public void setSharpenFactor(float paramFloat)
  {
    this.sharpenFactor = paramFloat;
    this.mRealTimeSmoothFilter.setSharpenFactor(paramFloat);
  }
  
  public void setSharpenSize(int paramInt1, int paramInt2)
  {
    this.smoothSharpenWidth = paramInt1;
    this.smoothSharpenHeight = paramInt2;
    this.mRealTimeSmoothFilter.setSharpenSize(paramInt1, paramInt2);
  }
  
  public void setSmoothLevel(int paramInt)
  {
    this.smoothLevel = paramInt;
    if (this.mRealTimeSmoothFilter != null)
    {
      paramInt = Math.max(Math.min(paramInt, 100), 0);
      this.mRealTimeSmoothFilter.updateBlurAlpha(paramInt / 100.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AESmoothPrev3
 * JD-Core Version:    0.7.0.1
 */