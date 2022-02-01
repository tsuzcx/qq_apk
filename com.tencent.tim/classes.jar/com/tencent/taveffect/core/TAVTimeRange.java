package com.tencent.taveffect.core;

import java.util.concurrent.TimeUnit;

public class TAVTimeRange
{
  private long _duration;
  private long _start;
  private TimeUnit _unit = TimeUnit.MILLISECONDS;
  
  public TAVTimeRange() {}
  
  public TAVTimeRange(long paramLong1, long paramLong2)
  {
    this._start = paramLong1;
    this._duration = paramLong2;
  }
  
  public TAVTimeRange clone()
  {
    return new TAVTimeRange(this._start, this._duration);
  }
  
  public boolean contain(long paramLong)
  {
    return (this._duration > 0L) && (this._start < paramLong) && (paramLong < this._start + this._duration);
  }
  
  public long duration()
  {
    return this._duration;
  }
  
  public long end()
  {
    return this._start + this._duration;
  }
  
  public boolean equals(TAVTimeRange paramTAVTimeRange)
  {
    if (paramTAVTimeRange == this) {}
    do
    {
      return true;
      if (paramTAVTimeRange == null) {
        return false;
      }
    } while ((this._start == paramTAVTimeRange._start) && (this._duration == paramTAVTimeRange._duration));
    return false;
  }
  
  public TimeUnit getUnit()
  {
    return this._unit;
  }
  
  public void setUnit(TimeUnit paramTimeUnit)
  {
    this._unit = paramTimeUnit;
  }
  
  public long start()
  {
    return this._start;
  }
  
  public String toString()
  {
    return "TAVTimeRange{_unit=" + this._unit + ", _start=" + this._start + ", _duration=" + this._duration + ", _end=" + (this._start + this._duration) + '}';
  }
  
  public void update(long paramLong1, long paramLong2)
  {
    this._start = paramLong1;
    this._duration = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.taveffect.core.TAVTimeRange
 * JD-Core Version:    0.7.0.1
 */