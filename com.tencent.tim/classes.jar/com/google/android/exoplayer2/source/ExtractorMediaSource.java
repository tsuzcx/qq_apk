package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public final class ExtractorMediaSource
  implements ExtractorMediaPeriod.Listener, MediaSource
{
  public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 1048576;
  public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_LIVE = 6;
  public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_ON_DEMAND = 3;
  public static final int MIN_RETRY_COUNT_DEFAULT_FOR_MEDIA = -1;
  private final int continueLoadingCheckIntervalBytes;
  private final String customCacheKey;
  private final DataSource.Factory dataSourceFactory;
  private final MediaSourceEventListener.EventDispatcher eventDispatcher;
  private final ExtractorsFactory extractorsFactory;
  private final int minLoadableRetryCount;
  private MediaSource.Listener sourceListener;
  private long timelineDurationUs;
  private boolean timelineIsSeekable;
  private final Uri uri;
  
  @Deprecated
  public ExtractorMediaSource(Uri paramUri, DataSource.Factory paramFactory, ExtractorsFactory paramExtractorsFactory, int paramInt1, Handler paramHandler, EventListener paramEventListener, String paramString, int paramInt2) {}
  
  private ExtractorMediaSource(Uri paramUri, DataSource.Factory paramFactory, ExtractorsFactory paramExtractorsFactory, int paramInt1, @Nullable Handler paramHandler, @Nullable MediaSourceEventListener paramMediaSourceEventListener, @Nullable String paramString, int paramInt2)
  {
    this.uri = paramUri;
    this.dataSourceFactory = paramFactory;
    this.extractorsFactory = paramExtractorsFactory;
    this.minLoadableRetryCount = paramInt1;
    this.eventDispatcher = new MediaSourceEventListener.EventDispatcher(paramHandler, paramMediaSourceEventListener);
    this.customCacheKey = paramString;
    this.continueLoadingCheckIntervalBytes = paramInt2;
  }
  
  @Deprecated
  public ExtractorMediaSource(Uri paramUri, DataSource.Factory paramFactory, ExtractorsFactory paramExtractorsFactory, Handler paramHandler, EventListener paramEventListener)
  {
    this(paramUri, paramFactory, paramExtractorsFactory, paramHandler, paramEventListener, null);
  }
  
  @Deprecated
  public ExtractorMediaSource(Uri paramUri, DataSource.Factory paramFactory, ExtractorsFactory paramExtractorsFactory, Handler paramHandler, EventListener paramEventListener, String paramString)
  {
    this(paramUri, paramFactory, paramExtractorsFactory, -1, paramHandler, paramEventListener, paramString, 1048576);
  }
  
  private void notifySourceInfoRefreshed(long paramLong, boolean paramBoolean)
  {
    this.timelineDurationUs = paramLong;
    this.timelineIsSeekable = paramBoolean;
    this.sourceListener.onSourceInfoRefreshed(this, new SinglePeriodTimeline(this.timelineDurationUs, this.timelineIsSeekable, false), null);
  }
  
  public MediaPeriod createPeriod(MediaSource.MediaPeriodId paramMediaPeriodId, Allocator paramAllocator)
  {
    if (paramMediaPeriodId.periodIndex == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      return new ExtractorMediaPeriod(this.uri, this.dataSourceFactory.createDataSource(), this.extractorsFactory.createExtractors(), this.minLoadableRetryCount, this.eventDispatcher, this, paramAllocator, this.customCacheKey, this.continueLoadingCheckIntervalBytes);
    }
  }
  
  public void maybeThrowSourceInfoRefreshError()
    throws IOException
  {}
  
  public void onSourceInfoRefreshed(long paramLong, boolean paramBoolean)
  {
    long l = paramLong;
    if (paramLong == -9223372036854775807L) {
      l = this.timelineDurationUs;
    }
    if ((this.timelineDurationUs == l) && (this.timelineIsSeekable == paramBoolean)) {
      return;
    }
    notifySourceInfoRefreshed(l, paramBoolean);
  }
  
  public void prepareSource(ExoPlayer paramExoPlayer, boolean paramBoolean, MediaSource.Listener paramListener)
  {
    this.sourceListener = paramListener;
    notifySourceInfoRefreshed(-9223372036854775807L, false);
  }
  
  public void releasePeriod(MediaPeriod paramMediaPeriod)
  {
    ((ExtractorMediaPeriod)paramMediaPeriod).release();
  }
  
  public void releaseSource()
  {
    this.sourceListener = null;
  }
  
  @Deprecated
  public static abstract interface EventListener
  {
    public abstract void onLoadError(IOException paramIOException);
  }
  
  static final class EventListenerWrapper
    implements MediaSourceEventListener
  {
    private final ExtractorMediaSource.EventListener eventListener;
    
    public EventListenerWrapper(ExtractorMediaSource.EventListener paramEventListener)
    {
      this.eventListener = ((ExtractorMediaSource.EventListener)Assertions.checkNotNull(paramEventListener));
    }
    
    public void onDownstreamFormatChanged(int paramInt1, Format paramFormat, int paramInt2, Object paramObject, long paramLong) {}
    
    public void onLoadCanceled(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {}
    
    public void onLoadCompleted(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {}
    
    public void onLoadError(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      this.eventListener.onLoadError(paramIOException);
    }
    
    public void onLoadStarted(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3) {}
    
    public void onUpstreamDiscarded(int paramInt, long paramLong1, long paramLong2) {}
  }
  
  public static final class Factory
    implements AdsMediaSource.MediaSourceFactory
  {
    private int continueLoadingCheckIntervalBytes;
    @Nullable
    private String customCacheKey;
    private final DataSource.Factory dataSourceFactory;
    @Nullable
    private ExtractorsFactory extractorsFactory;
    private boolean isCreateCalled;
    private int minLoadableRetryCount;
    
    public Factory(DataSource.Factory paramFactory)
    {
      this.dataSourceFactory = paramFactory;
      this.minLoadableRetryCount = -1;
      this.continueLoadingCheckIntervalBytes = 1048576;
    }
    
    public ExtractorMediaSource createMediaSource(Uri paramUri)
    {
      return createMediaSource(paramUri, null, null);
    }
    
    public ExtractorMediaSource createMediaSource(Uri paramUri, @Nullable Handler paramHandler, @Nullable MediaSourceEventListener paramMediaSourceEventListener)
    {
      this.isCreateCalled = true;
      if (this.extractorsFactory == null) {
        this.extractorsFactory = new DefaultExtractorsFactory();
      }
      return new ExtractorMediaSource(paramUri, this.dataSourceFactory, this.extractorsFactory, this.minLoadableRetryCount, paramHandler, paramMediaSourceEventListener, this.customCacheKey, this.continueLoadingCheckIntervalBytes, null);
    }
    
    public int[] getSupportedTypes()
    {
      return new int[] { 3 };
    }
    
    public Factory setContinueLoadingCheckIntervalBytes(int paramInt)
    {
      if (!this.isCreateCalled) {}
      for (boolean bool = true;; bool = false)
      {
        Assertions.checkState(bool);
        this.continueLoadingCheckIntervalBytes = paramInt;
        return this;
      }
    }
    
    public Factory setCustomCacheKey(String paramString)
    {
      if (!this.isCreateCalled) {}
      for (boolean bool = true;; bool = false)
      {
        Assertions.checkState(bool);
        this.customCacheKey = paramString;
        return this;
      }
    }
    
    public Factory setExtractorsFactory(ExtractorsFactory paramExtractorsFactory)
    {
      if (!this.isCreateCalled) {}
      for (boolean bool = true;; bool = false)
      {
        Assertions.checkState(bool);
        this.extractorsFactory = paramExtractorsFactory;
        return this;
      }
    }
    
    public Factory setMinLoadableRetryCount(int paramInt)
    {
      if (!this.isCreateCalled) {}
      for (boolean bool = true;; bool = false)
      {
        Assertions.checkState(bool);
        this.minLoadableRetryCount = paramInt;
        return this;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ExtractorMediaSource
 * JD-Core Version:    0.7.0.1
 */