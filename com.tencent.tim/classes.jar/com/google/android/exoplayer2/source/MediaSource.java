package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import java.io.IOException;

public abstract interface MediaSource
{
  public static final String MEDIA_SOURCE_REUSED_ERROR_MESSAGE = "MediaSource instances are not allowed to be reused.";
  
  public abstract MediaPeriod createPeriod(MediaPeriodId paramMediaPeriodId, Allocator paramAllocator);
  
  public abstract void maybeThrowSourceInfoRefreshError()
    throws IOException;
  
  public abstract void prepareSource(ExoPlayer paramExoPlayer, boolean paramBoolean, Listener paramListener);
  
  public abstract void releasePeriod(MediaPeriod paramMediaPeriod);
  
  public abstract void releaseSource();
  
  public static abstract interface Listener
  {
    public abstract void onSourceInfoRefreshed(MediaSource paramMediaSource, Timeline paramTimeline, @Nullable Object paramObject);
  }
  
  public static final class MediaPeriodId
  {
    public final int adGroupIndex;
    public final int adIndexInAdGroup;
    public final int periodIndex;
    public final long windowSequenceNumber;
    
    public MediaPeriodId(int paramInt)
    {
      this(paramInt, -1L);
    }
    
    public MediaPeriodId(int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      this.periodIndex = paramInt1;
      this.adGroupIndex = paramInt2;
      this.adIndexInAdGroup = paramInt3;
      this.windowSequenceNumber = paramLong;
    }
    
    public MediaPeriodId(int paramInt, long paramLong)
    {
      this(paramInt, -1, -1, paramLong);
    }
    
    public MediaPeriodId copyWithPeriodIndex(int paramInt)
    {
      if (this.periodIndex == paramInt) {
        return this;
      }
      return new MediaPeriodId(paramInt, this.adGroupIndex, this.adIndexInAdGroup, this.windowSequenceNumber);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (MediaPeriodId)paramObject;
      } while ((this.periodIndex == paramObject.periodIndex) && (this.adGroupIndex == paramObject.adGroupIndex) && (this.adIndexInAdGroup == paramObject.adIndexInAdGroup) && (this.windowSequenceNumber == paramObject.windowSequenceNumber));
      return false;
    }
    
    public int hashCode()
    {
      return (((this.periodIndex + 527) * 31 + this.adGroupIndex) * 31 + this.adIndexInAdGroup) * 31 + (int)this.windowSequenceNumber;
    }
    
    public boolean isAd()
    {
      return this.adGroupIndex != -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.MediaSource
 * JD-Core Version:    0.7.0.1
 */