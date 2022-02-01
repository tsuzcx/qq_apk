package com.tencent.thumbplayer.api.richmedia;

public abstract interface ITPRichMediaSynchronizer
{
  public abstract void deselectFeatureAsync(int paramInt)
    throws IllegalStateException, IllegalArgumentException;
  
  public abstract TPRichMediaFeature[] getFeatures()
    throws IllegalStateException;
  
  public abstract void prepareAsync()
    throws IllegalStateException;
  
  public abstract void release();
  
  public abstract void reset()
    throws IllegalStateException;
  
  public abstract void selectFeatureAsync(int paramInt, TPRichMediaRequestExtraInfo paramTPRichMediaRequestExtraInfo)
    throws IllegalStateException, IllegalArgumentException;
  
  public abstract void setListener(ITPRichMediaSynchronizerListener paramITPRichMediaSynchronizerListener);
  
  public abstract void setRichMediaSource(String paramString)
    throws IllegalStateException, IllegalArgumentException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
 * JD-Core Version:    0.7.0.1
 */