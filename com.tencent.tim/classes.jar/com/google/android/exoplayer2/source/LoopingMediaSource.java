package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;

public final class LoopingMediaSource
  extends CompositeMediaSource<Void>
{
  private int childPeriodCount;
  private final MediaSource childSource;
  private MediaSource.Listener listener;
  private final int loopCount;
  
  public LoopingMediaSource(MediaSource paramMediaSource)
  {
    this(paramMediaSource, 2147483647);
  }
  
  public LoopingMediaSource(MediaSource paramMediaSource, int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      this.childSource = paramMediaSource;
      this.loopCount = paramInt;
      return;
    }
  }
  
  public MediaPeriod createPeriod(MediaSource.MediaPeriodId paramMediaPeriodId, Allocator paramAllocator)
  {
    if (this.loopCount != 2147483647) {
      return this.childSource.createPeriod(paramMediaPeriodId.copyWithPeriodIndex(paramMediaPeriodId.periodIndex % this.childPeriodCount), paramAllocator);
    }
    return this.childSource.createPeriod(paramMediaPeriodId, paramAllocator);
  }
  
  protected void onChildSourceInfoRefreshed(Void paramVoid, MediaSource paramMediaSource, Timeline paramTimeline, @Nullable Object paramObject)
  {
    this.childPeriodCount = paramTimeline.getPeriodCount();
    if (this.loopCount != 2147483647) {}
    for (paramVoid = new LoopingTimeline(paramTimeline, this.loopCount);; paramVoid = new InfinitelyLoopingTimeline(paramTimeline))
    {
      this.listener.onSourceInfoRefreshed(this, paramVoid, paramObject);
      return;
    }
  }
  
  public void prepareSource(ExoPlayer paramExoPlayer, boolean paramBoolean, MediaSource.Listener paramListener)
  {
    super.prepareSource(paramExoPlayer, paramBoolean, paramListener);
    this.listener = paramListener;
    prepareChildSource(null, this.childSource);
  }
  
  public void releasePeriod(MediaPeriod paramMediaPeriod)
  {
    this.childSource.releasePeriod(paramMediaPeriod);
  }
  
  public void releaseSource()
  {
    super.releaseSource();
    this.listener = null;
    this.childPeriodCount = 0;
  }
  
  static final class InfinitelyLoopingTimeline
    extends ForwardingTimeline
  {
    public InfinitelyLoopingTimeline(Timeline paramTimeline)
    {
      super();
    }
    
    public int getNextWindowIndex(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      paramInt2 = this.timeline.getNextWindowIndex(paramInt1, paramInt2, paramBoolean);
      paramInt1 = paramInt2;
      if (paramInt2 == -1) {
        paramInt1 = getFirstWindowIndex(paramBoolean);
      }
      return paramInt1;
    }
    
    public int getPreviousWindowIndex(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      paramInt2 = this.timeline.getPreviousWindowIndex(paramInt1, paramInt2, paramBoolean);
      paramInt1 = paramInt2;
      if (paramInt2 == -1) {
        paramInt1 = getLastWindowIndex(paramBoolean);
      }
      return paramInt1;
    }
  }
  
  static final class LoopingTimeline
    extends AbstractConcatenatedTimeline
  {
    private final int childPeriodCount;
    private final Timeline childTimeline;
    private final int childWindowCount;
    private final int loopCount;
    
    public LoopingTimeline(Timeline paramTimeline, int paramInt)
    {
      super(new ShuffleOrder.UnshuffledShuffleOrder(paramInt));
      this.childTimeline = paramTimeline;
      this.childPeriodCount = paramTimeline.getPeriodCount();
      this.childWindowCount = paramTimeline.getWindowCount();
      this.loopCount = paramInt;
      if (this.childPeriodCount > 0)
      {
        if (paramInt <= 2147483647 / this.childPeriodCount) {
          bool = true;
        }
        Assertions.checkState(bool, "LoopingMediaSource contains too many periods");
      }
    }
    
    protected int getChildIndexByChildUid(Object paramObject)
    {
      if (!(paramObject instanceof Integer)) {
        return -1;
      }
      return ((Integer)paramObject).intValue();
    }
    
    protected int getChildIndexByPeriodIndex(int paramInt)
    {
      return paramInt / this.childPeriodCount;
    }
    
    protected int getChildIndexByWindowIndex(int paramInt)
    {
      return paramInt / this.childWindowCount;
    }
    
    protected Object getChildUidByChildIndex(int paramInt)
    {
      return Integer.valueOf(paramInt);
    }
    
    protected int getFirstPeriodIndexByChildIndex(int paramInt)
    {
      return this.childPeriodCount * paramInt;
    }
    
    protected int getFirstWindowIndexByChildIndex(int paramInt)
    {
      return this.childWindowCount * paramInt;
    }
    
    public int getPeriodCount()
    {
      return this.childPeriodCount * this.loopCount;
    }
    
    protected Timeline getTimelineByChildIndex(int paramInt)
    {
      return this.childTimeline;
    }
    
    public int getWindowCount()
    {
      return this.childWindowCount * this.loopCount;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.LoopingMediaSource
 * JD-Core Version:    0.7.0.1
 */