package com.tencent.tavkit.composition.video;

import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.ciimage.CIImage;

public abstract interface TAVVideoTransition
{
  @RenderThread
  public abstract Filter createFilter();
  
  @Nullable
  public abstract String effectId();
  
  public abstract CMTime getDuration();
  
  public static abstract interface Filter
  {
    @RenderThread
    public abstract CIImage apply(TAVVideoTransition paramTAVVideoTransition, CIImage paramCIImage1, CIImage paramCIImage2, float paramFloat, RenderInfo paramRenderInfo);
    
    @RenderThread
    public abstract void release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoTransition
 * JD-Core Version:    0.7.0.1
 */