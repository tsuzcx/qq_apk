package com.tencent.tavkit.composition.video;

import android.support.annotation.Nullable;
import com.tencent.tavkit.ciimage.CIImage;

public abstract interface TAVVideoMixEffect
{
  @RenderThread
  public abstract Filter createFilter();
  
  @Nullable
  public abstract String effectId();
  
  public static abstract interface Filter
  {
    @RenderThread
    public abstract CIImage apply(TAVVideoMixEffect paramTAVVideoMixEffect, ImageCollection paramImageCollection, RenderInfo paramRenderInfo);
    
    @RenderThread
    public abstract void release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoMixEffect
 * JD-Core Version:    0.7.0.1
 */