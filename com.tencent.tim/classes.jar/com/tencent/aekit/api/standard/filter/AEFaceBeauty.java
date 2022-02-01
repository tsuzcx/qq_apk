package com.tencent.aekit.api.standard.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.FaceFeatureParam;
import com.tencent.ttpic.openapi.filter.TTBeautyV5BeautyFaceList;

public class AEFaceBeauty
  extends AEFaceBeautyBase
{
  private static final String TAG = "AEFaceBeautyV5";
  private int beautyLevel;
  private int colorToneLevel;
  private int contrastRatioLevel;
  private int eyeLightenLevel;
  private float faceFeatureMultiplyAlpha;
  private float faceFeatureNormalAlpha;
  private FaceFeatureParam faceFeatureParam;
  private float faceFeatureSoftlightAlpha;
  private boolean isLoadSo = false;
  private boolean isSkipBeautyRender = false;
  private boolean isSkipRenderEnabled = false;
  private boolean isVeryLowDevice = false;
  private int lipsLutAlpha;
  private String lipsLutPath;
  private TTBeautyV5BeautyFaceList mBeautyFaceList = new TTBeautyV5BeautyFaceList();
  private PTFaceAttr mFaceAttr;
  private double mFaceScale = 1.0D;
  private int mVideoHeight = 1280;
  private int mVideoWidth = 720;
  private float normalAlphaFactor;
  private int removePounchLevel;
  private int removeWrinkles2Level;
  private int removeWrinklesLevel;
  private int renderMode;
  private boolean showFaceFeatureFilter;
  private int toothWhitenLevel;
  
  private void configFilter() {}
  
  private boolean isAllZeroLevel()
  {
    return (this.colorToneLevel == 50) && (this.beautyLevel + this.eyeLightenLevel + this.toothWhitenLevel + this.removePounchLevel + this.removeWrinklesLevel + this.removeWrinkles2Level + this.contrastRatioLevel == 0);
  }
  
  public void apply()
  {
    if (!this.mIsApplied)
    {
      this.mBeautyFaceList.initial();
      this.mIsApplied = true;
    }
  }
  
  public void clear()
  {
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.clear();
    }
    this.mIsApplied = false;
  }
  
  public String getVersion()
  {
    return "V5";
  }
  
  public boolean isValid()
  {
    return this.mIsApplied;
  }
  
  public String printParamInfo()
  {
    return "AESmoothPrev2 {beautyLevel=" + this.beautyLevel + ", eyeLightenLevel=" + this.eyeLightenLevel + ", toothWhitenLevel=" + this.toothWhitenLevel + ", removePounchLevel=" + this.removePounchLevel + ", removeWrinklesLevel=" + this.removeWrinklesLevel + ", colorToneLevel=" + this.colorToneLevel + ", contrastRatioLevel=" + this.contrastRatioLevel + ", isVeryLowDevice=" + this.isVeryLowDevice + ", normalAlphaFactor=" + this.normalAlphaFactor + ", faceFeatureNormalAlpha=" + this.faceFeatureNormalAlpha + ", faceFeatureMultiplyAlpha=" + this.faceFeatureMultiplyAlpha + ", faceFeatureSoftlightAlpha=" + this.faceFeatureSoftlightAlpha + ", showFaceFeatureFilter=" + this.showFaceFeatureFilter + ", lipsLutAlpha=" + this.lipsLutAlpha + ", lipsLutPath=" + this.lipsLutPath + ", renderMode=" + this.renderMode + '}';
  }
  
  public Frame render(Frame paramFrame)
  {
    if (this.isSkipBeautyRender) {}
    do
    {
      return paramFrame;
      configFilter();
    } while ((this.mBeautyFaceList == null) || (this.mFaceAttr == null) || (this.mFaceAttr.getFaceCount() <= 0));
    this.mBeautyFaceList.updateVideoSize(this.mVideoWidth, this.mVideoHeight, this.mFaceScale);
    return this.mBeautyFaceList.render2(paramFrame, this.mFaceAttr.getAllFacePoints(), this.mFaceAttr.getPointsVis(), this.mFaceAttr.getFaceStatusList(), this.isVeryLowDevice, this.isLoadSo);
  }
  
  public void setFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    this.mFaceAttr = paramPTFaceAttr;
  }
  
  public void setFaceBeautyLevel(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    switch (AEFaceBeauty.1.$SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[paramTYPE.ordinal()])
    {
    }
    while (((this.isSkipRenderEnabled) && (isAllZeroLevel()) && ((this.lipsLutPath == null) || (this.lipsLutPath.isEmpty()))) || ("None/null".equals(this.lipsLutPath)))
    {
      this.isSkipBeautyRender = true;
      return;
      this.beautyLevel = paramInt;
      this.mBeautyFaceList.setBeautyLevel(this.beautyLevel / 100.0F);
      continue;
      this.eyeLightenLevel = paramInt;
      this.mBeautyFaceList.setEyeOpacity(this.eyeLightenLevel / 100.0F);
      continue;
      this.toothWhitenLevel = paramInt;
      this.mBeautyFaceList.setToothWhitenAlpha(this.toothWhitenLevel / 80.0F);
      continue;
      this.removePounchLevel = paramInt;
      this.mBeautyFaceList.setEyePouchOpacity(this.removePounchLevel / 100.0F);
      continue;
      this.removeWrinklesLevel = paramInt;
      this.mBeautyFaceList.setSmoothOpacity(this.removeWrinklesLevel / 100.0F);
      continue;
      this.removeWrinkles2Level = paramInt;
      this.mBeautyFaceList.setSmoothOpacity2(this.removeWrinkles2Level / 100.0F);
      continue;
      this.colorToneLevel = paramInt;
      this.mBeautyFaceList.setSkinColorAlpha((this.colorToneLevel - 50) / 50.0F);
      continue;
      this.contrastRatioLevel = paramInt;
      this.mBeautyFaceList.setContrastLevel(this.contrastRatioLevel);
    }
    this.isSkipBeautyRender = false;
  }
  
  public void setFaceFeatureMultiplyAlpha(float paramFloat)
  {
    this.faceFeatureMultiplyAlpha = paramFloat;
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.setFaceFeatureMultiplyAlpha(paramFloat);
    }
  }
  
  public void setFaceFeatureNormalAlpha(float paramFloat)
  {
    this.faceFeatureNormalAlpha = paramFloat;
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.setFaceFeatureNormalAlpha(paramFloat);
    }
  }
  
  public void setFaceFeatureParam(FaceFeatureParam paramFaceFeatureParam)
  {
    this.faceFeatureParam = paramFaceFeatureParam;
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.setFaceFeatureParam(paramFaceFeatureParam);
    }
  }
  
  public void setFaceFeatureSoftlightAlpha(float paramFloat)
  {
    this.faceFeatureSoftlightAlpha = paramFloat;
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.setFaceFeatureSoftlightAlpha(paramFloat);
    }
  }
  
  public void setLipsLut(String paramString)
  {
    this.lipsLutPath = paramString;
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.setLipsLut(paramString);
    }
    if (((paramString == null) || (paramString.isEmpty()) || (paramString.equals("None/null"))) && (isAllZeroLevel()) && (this.isSkipRenderEnabled))
    {
      this.isSkipBeautyRender = true;
      return;
    }
    this.isSkipBeautyRender = false;
  }
  
  public void setLipsLutAlpha(int paramInt)
  {
    this.lipsLutAlpha = paramInt;
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.setLipsLutAlpha(paramInt);
    }
  }
  
  public void setLipsStyleMaskPath(String paramString)
  {
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.setLipsStyleMaskPath(paramString);
    }
  }
  
  public void setLoadSo(boolean paramBoolean)
  {
    this.isLoadSo = paramBoolean;
  }
  
  public void setNormalAlphaFactor(float paramFloat)
  {
    this.normalAlphaFactor = paramFloat;
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.setNormalAlphaFactor(paramFloat);
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    this.renderMode = paramInt;
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.setRenderMode(paramInt);
    }
  }
  
  public void setShowFaceFeatureFilter(boolean paramBoolean)
  {
    this.showFaceFeatureFilter = paramBoolean;
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.setShowFaceFeatureFilter(paramBoolean);
    }
  }
  
  public void setSkipRenderEnabled(boolean paramBoolean)
  {
    this.isSkipRenderEnabled = paramBoolean;
  }
  
  public void setVeryLowDevice(boolean paramBoolean)
  {
    this.isVeryLowDevice = paramBoolean;
  }
  
  public void setVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
    this.mFaceScale = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFaceBeauty
 * JD-Core Version:    0.7.0.1
 */