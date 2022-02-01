package com.tencent.thumbplayer.core.richmedia;

public abstract interface ITPNativeRichMediaProcessor
{
  public abstract void deselectFeatureAsync(int paramInt)
    throws IllegalStateException, IllegalArgumentException;
  
  public abstract TPNativeRichMediaFeatureData getCurrentPositionMsFeatureData(long paramLong, int[] paramArrayOfInt)
    throws IllegalStateException, IllegalArgumentException;
  
  public abstract TPNativeRichMediaFeature[] getFeatures()
    throws IllegalStateException;
  
  public abstract void prepareAsync()
    throws IllegalStateException;
  
  public abstract void release();
  
  public abstract void reset()
    throws IllegalStateException;
  
  public abstract void seek(long paramLong)
    throws IllegalStateException, IllegalArgumentException;
  
  public abstract void selectFeatureAsync(int paramInt, TPNativeRichMediaRequestExtraInfo paramTPNativeRichMediaRequestExtraInfo)
    throws IllegalStateException, IllegalArgumentException;
  
  public abstract void setInnerProcessorCallback(ITPNativeRichMediaInnerProcessorCallback paramITPNativeRichMediaInnerProcessorCallback);
  
  public abstract void setPlaybackRate(float paramFloat)
    throws IllegalStateException, IllegalArgumentException;
  
  public abstract void setProcessorCallback(ITPNativeRichMediaProcessorCallback paramITPNativeRichMediaProcessorCallback);
  
  public abstract void setRichMediaSource(String paramString)
    throws IllegalStateException, IllegalArgumentException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaProcessor
 * JD-Core Version:    0.7.0.1
 */