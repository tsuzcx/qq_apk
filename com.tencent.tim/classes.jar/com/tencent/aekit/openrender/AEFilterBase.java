package com.tencent.aekit.openrender;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;

public abstract class AEFilterBase
  extends AEChainI
{
  private VideoFilterBase mVideoFilterBase;
  
  public AEFilterBase(String paramString1, String paramString2)
  {
    this.mVideoFilterBase = new VideoFilterBase(paramString1, paramString2);
  }
  
  public void addAttribParam(String paramString, float[] paramArrayOfFloat)
  {
    this.mVideoFilterBase.addAttribParam(paramString, paramArrayOfFloat);
  }
  
  public void addUniformParam(UniformParam paramUniformParam)
  {
    this.mVideoFilterBase.addParam(paramUniformParam);
  }
  
  public void apply()
  {
    this.mVideoFilterBase.initParams();
    this.mVideoFilterBase.ApplyGLSLFilter();
  }
  
  public void clear()
  {
    this.mVideoFilterBase.clearGLSLSelf();
  }
  
  public boolean isValid()
  {
    return this.mVideoFilterBase.isValid();
  }
  
  public Frame render(Frame paramFrame)
  {
    return this.mVideoFilterBase.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aekit.openrender.AEFilterBase
 * JD-Core Version:    0.7.0.1
 */