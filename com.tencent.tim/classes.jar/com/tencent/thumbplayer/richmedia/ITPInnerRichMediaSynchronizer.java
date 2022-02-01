package com.tencent.thumbplayer.richmedia;

import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFeatureData;

public abstract interface ITPInnerRichMediaSynchronizer
  extends ITPRichMediaSynchronizer
{
  public abstract TPRichMediaFeatureData getCurrentPositionMsFeatureData(long paramLong, int[] paramArrayOfInt)
    throws IllegalStateException, IllegalArgumentException;
  
  public abstract void seek(long paramLong)
    throws IllegalStateException, IllegalArgumentException;
  
  public abstract void setInnerListener(ITPRichMediaInnerSynchronizerListener paramITPRichMediaInnerSynchronizerListener);
  
  public abstract void setPlaybackRate(float paramFloat)
    throws IllegalStateException, IllegalArgumentException;
  
  public static abstract interface ITPRichMediaInnerSynchronizerListener
  {
    public abstract long onGetCurrentPositionMs(ITPRichMediaSynchronizer paramITPRichMediaSynchronizer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.richmedia.ITPInnerRichMediaSynchronizer
 * JD-Core Version:    0.7.0.1
 */