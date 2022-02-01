package com.tencent.thumbplayer.api.richmedia;

import com.tencent.thumbplayer.api.TPTimeRange;

public abstract interface ITPRichMediaAsyncRequester
{
  public abstract void cancelRequest(int paramInt);
  
  public abstract TPRichMediaFeature[] getFeatures()
    throws IllegalStateException;
  
  public abstract void prepareAsync()
    throws IllegalStateException;
  
  public abstract void release();
  
  public abstract int requestFeatureDataAsyncAtTimeMs(int paramInt, long paramLong)
    throws IllegalStateException, IllegalArgumentException;
  
  public abstract int requestFeatureDataAsyncAtTimeMsArray(int paramInt, long[] paramArrayOfLong)
    throws IllegalStateException, IllegalArgumentException;
  
  public abstract int requestFeatureDataAsyncAtTimeRange(int paramInt, TPTimeRange paramTPTimeRange)
    throws IllegalStateException, IllegalArgumentException;
  
  public abstract int requestFeatureDataAsyncAtTimeRanges(int paramInt, TPTimeRange[] paramArrayOfTPTimeRange)
    throws IllegalStateException, IllegalArgumentException;
  
  public abstract void setRequesterListener(ITPRichMediaAsyncRequesterListener paramITPRichMediaAsyncRequesterListener);
  
  public abstract void setRichMediaSource(String paramString)
    throws IllegalStateException, IllegalArgumentException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
 * JD-Core Version:    0.7.0.1
 */