package com.tencent.tavcut.timeline;

public class TimelineBuilder
{
  private boolean mLockMode = false;
  private String mMaxDurationTps;
  private long mMaxSelectDurationMs = -1L;
  private long mMinSelectDurationMs = -1L;
  private boolean mShowDuration = true;
  private boolean mShowMask = true;
  private boolean mSliderBarMode = true;
  
  public String getMaxDurationTps()
  {
    return this.mMaxDurationTps;
  }
  
  public long getMaxSelectDurationMs()
  {
    return this.mMaxSelectDurationMs;
  }
  
  public long getMinSelectDurationMs()
  {
    return this.mMinSelectDurationMs;
  }
  
  public boolean isLockMode()
  {
    return this.mLockMode;
  }
  
  public boolean isShowDuration()
  {
    return this.mShowDuration;
  }
  
  public boolean isShowMask()
  {
    return this.mShowMask;
  }
  
  public boolean isSliderBarMode()
  {
    return this.mSliderBarMode;
  }
  
  public TimelineBuilder setLockMode(boolean paramBoolean)
  {
    this.mLockMode = paramBoolean;
    return this;
  }
  
  public TimelineBuilder setMaxDurationTps(String paramString)
  {
    this.mMaxDurationTps = paramString;
    return this;
  }
  
  public TimelineBuilder setMaxSelectDurationMs(long paramLong)
  {
    this.mMaxSelectDurationMs = paramLong;
    return this;
  }
  
  public TimelineBuilder setMinSelectDurationMs(long paramLong)
  {
    this.mMinSelectDurationMs = paramLong;
    return this;
  }
  
  public TimelineBuilder setShowDuration(boolean paramBoolean)
  {
    this.mShowDuration = paramBoolean;
    return this;
  }
  
  public TimelineBuilder setShowMask(boolean paramBoolean)
  {
    this.mShowMask = paramBoolean;
    return this;
  }
  
  public TimelineBuilder setSliderBarMode(boolean paramBoolean)
  {
    this.mSliderBarMode = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.timeline.TimelineBuilder
 * JD-Core Version:    0.7.0.1
 */