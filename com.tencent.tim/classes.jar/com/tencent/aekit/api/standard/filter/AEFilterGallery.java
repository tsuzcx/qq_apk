package com.tencent.aekit.api.standard.filter;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.ttpic.GPUImageLookupFilter;

public class AEFilterGallery
  extends AEChainI
{
  private GPUImageLookupFilter mLookupFilter;
  
  public AEFilterGallery()
  {
    this.mLookupFilter = new GPUImageLookupFilter();
  }
  
  public AEFilterGallery(String paramString)
  {
    this.mLookupFilter = new GPUImageLookupFilter(paramString);
  }
  
  public void apply()
  {
    if (!this.mIsApplied)
    {
      this.mLookupFilter.apply();
      this.mIsApplied = true;
    }
  }
  
  public void clear()
  {
    this.mLookupFilter.clearGLSLSelf();
    this.mIsApplied = false;
  }
  
  public Frame render(Frame paramFrame)
  {
    return this.mLookupFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
  }
  
  public void setAdjustParam(float paramFloat)
  {
    this.mLookupFilter.setAdjustParam(paramFloat);
  }
  
  public void updateLut(String paramString)
  {
    this.mLookupFilter.updateLut(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFilterGallery
 * JD-Core Version:    0.7.0.1
 */