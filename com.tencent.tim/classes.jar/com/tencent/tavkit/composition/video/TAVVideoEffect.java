package com.tencent.tavkit.composition.video;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tavkit.ciimage.CIImage;

public abstract interface TAVVideoEffect
{
  @RenderThread
  public abstract Filter createFilter();
  
  @Nullable
  public abstract String effectId();
  
  public static abstract interface Filter
  {
    @RenderThread
    @NonNull
    public abstract CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo);
    
    @RenderThread
    public abstract void release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoEffect
 * JD-Core Version:    0.7.0.1
 */