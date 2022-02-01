package com.tencent.ttpic.openapi.filterwrapper;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.TTBeautyV5PrefixFilterGroup;

public class TTBeautyV5PrefixFilterGroupWrapper
{
  private TTBeautyV5PrefixFilterGroup ttBeautyV5PrefixFilterGroup = new TTBeautyV5PrefixFilterGroup();
  
  public void apply()
  {
    this.ttBeautyV5PrefixFilterGroup.apply();
  }
  
  public void clear()
  {
    this.ttBeautyV5PrefixFilterGroup.clear();
  }
  
  public Frame render(Frame paramFrame, PTFaceAttr paramPTFaceAttr)
  {
    return this.ttBeautyV5PrefixFilterGroup.render(paramFrame, paramPTFaceAttr);
  }
  
  public void resetToneCurveTexture()
  {
    this.ttBeautyV5PrefixFilterGroup.resetToneCurveTexture();
  }
  
  public void setLookUpLeftIntensity(float paramFloat)
  {
    this.ttBeautyV5PrefixFilterGroup.setLookUpLeftIntensity(paramFloat);
  }
  
  public void setLookUpLeftPath(String paramString)
  {
    this.ttBeautyV5PrefixFilterGroup.setLookUpLeftPath(paramString);
  }
  
  public void setLookUpRightIntensity(float paramFloat)
  {
    this.ttBeautyV5PrefixFilterGroup.setLookUpRightIntensity(paramFloat);
  }
  
  public void setSmoothBlurAlpha(float paramFloat)
  {
    this.ttBeautyV5PrefixFilterGroup.setSmoothBlurAlpha(paramFloat);
  }
  
  public void setSmoothSharpenSize(float paramFloat1, float paramFloat2)
  {
    this.ttBeautyV5PrefixFilterGroup.setSmoothSharpenSize(paramFloat1, paramFloat2);
  }
  
  public void updateBlurAndSharpenStrength(boolean paramBoolean)
  {
    this.ttBeautyV5PrefixFilterGroup.updateBlurAndSharpenStrength(paramBoolean);
  }
  
  public void updateToneCurveTexture(int[] paramArrayOfInt, boolean paramBoolean)
  {
    this.ttBeautyV5PrefixFilterGroup.updateToneCurveTexture(paramArrayOfInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filterwrapper.TTBeautyV5PrefixFilterGroupWrapper
 * JD-Core Version:    0.7.0.1
 */