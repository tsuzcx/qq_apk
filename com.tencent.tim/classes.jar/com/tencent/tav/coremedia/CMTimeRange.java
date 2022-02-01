package com.tencent.tav.coremedia;

import android.support.annotation.NonNull;

public class CMTimeRange
  implements Cloneable
{
  public static CMTimeRange CMTimeRangeInvalid = new CMTimeRange(CMTime.CMTimeZero, CMTime.CMTimeZero);
  @NonNull
  private CMTime duration;
  private CMTime end;
  @NonNull
  private CMTime start;
  
  public CMTimeRange(@NonNull CMTime paramCMTime1, @NonNull CMTime paramCMTime2)
  {
    this.start = paramCMTime1;
    this.duration = paramCMTime2;
    this.end = paramCMTime1.add(paramCMTime2);
  }
  
  public static CMTimeRange fromMs(long paramLong1, long paramLong2)
  {
    return new CMTimeRange(CMTime.fromMs(paramLong1), CMTime.fromMs(paramLong2));
  }
  
  public static CMTimeRange fromSeconds(float paramFloat1, float paramFloat2)
  {
    return new CMTimeRange(CMTime.fromSeconds(paramFloat1), CMTime.fromSeconds(paramFloat2));
  }
  
  public static CMTimeRange fromUs(long paramLong1, long paramLong2)
  {
    return new CMTimeRange(CMTime.fromUs(paramLong1), CMTime.fromUs(paramLong2));
  }
  
  public static CMTimeRange getIntersection(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    if ((paramCMTimeRange1 == null) || (paramCMTimeRange2 == null))
    {
      localCMTimeRange = CMTimeRangeInvalid;
      return localCMTimeRange;
    }
    paramCMTimeRange1 = paramCMTimeRange1.clone();
    CMTimeRange localCMTimeRange = paramCMTimeRange2.clone();
    if (paramCMTimeRange1.getStartUs() > localCMTimeRange.getStartUs()) {
      paramCMTimeRange2 = localCMTimeRange;
    }
    for (;;)
    {
      if ((paramCMTimeRange2.getEndUs() > paramCMTimeRange1.getStartUs()) && (paramCMTimeRange2.getEndUs() < paramCMTimeRange1.getEndUs())) {
        return new CMTimeRange(paramCMTimeRange1.getStart(), paramCMTimeRange2.getEnd().sub(paramCMTimeRange1.getStart()));
      }
      localCMTimeRange = paramCMTimeRange1;
      if (paramCMTimeRange2.getEndUs() >= paramCMTimeRange1.getEndUs()) {
        break;
      }
      if (paramCMTimeRange2.getEndUs() < paramCMTimeRange1.getStartUs()) {
        return CMTimeRangeInvalid;
      }
      return CMTimeRangeInvalid;
      paramCMTimeRange2 = paramCMTimeRange1;
      paramCMTimeRange1 = localCMTimeRange;
    }
  }
  
  public static CMTimeRange[] getUnions(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    CMTimeRange[] arrayOfCMTimeRange = new CMTimeRange[2];
    if (paramCMTimeRange1 == null)
    {
      arrayOfCMTimeRange[0] = paramCMTimeRange2;
      return arrayOfCMTimeRange;
    }
    if (paramCMTimeRange2 == null)
    {
      arrayOfCMTimeRange[0] = paramCMTimeRange1;
      return arrayOfCMTimeRange;
    }
    paramCMTimeRange1 = paramCMTimeRange1.clone();
    paramCMTimeRange2 = paramCMTimeRange2.clone();
    CMTimeRange localCMTimeRange;
    if (paramCMTimeRange1.getStartUs() > paramCMTimeRange2.getStartUs())
    {
      localCMTimeRange = paramCMTimeRange2;
      paramCMTimeRange2 = paramCMTimeRange1;
    }
    for (;;)
    {
      arrayOfCMTimeRange[0] = localCMTimeRange;
      if ((localCMTimeRange.getEndUs() >= paramCMTimeRange2.getStartUs()) && (localCMTimeRange.getEndUs() < paramCMTimeRange2.getEndUs()))
      {
        arrayOfCMTimeRange[1] = new CMTimeRange(localCMTimeRange.getEnd(), paramCMTimeRange2.getEnd().sub(localCMTimeRange.getEnd()));
        return arrayOfCMTimeRange;
      }
      if (localCMTimeRange.getEndUs() >= paramCMTimeRange2.getEndUs())
      {
        arrayOfCMTimeRange[1] = null;
        return arrayOfCMTimeRange;
      }
      if (localCMTimeRange.getEndUs() >= paramCMTimeRange2.getStartUs()) {
        break;
      }
      arrayOfCMTimeRange[1] = paramCMTimeRange2;
      return arrayOfCMTimeRange;
      localCMTimeRange = paramCMTimeRange1;
    }
  }
  
  public CMTimeRange clone()
  {
    return new CMTimeRange(this.start, this.duration);
  }
  
  public boolean containsTime(@NonNull CMTime paramCMTime)
  {
    return (getStartUs() <= paramCMTime.getTimeUs()) && (getEndUs() > paramCMTime.getTimeUs());
  }
  
  public boolean containsTimeRange(@NonNull CMTimeRange paramCMTimeRange)
  {
    return (getStartUs() <= paramCMTimeRange.getStartUs()) && (getEndUs() >= paramCMTimeRange.getEndUs());
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CMTimeRange)) {
      return false;
    }
    if ((this.start.equals(((CMTimeRange)paramObject).start)) && (this.duration.equals(((CMTimeRange)paramObject).duration))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  @NonNull
  public CMTime getDuration()
  {
    return this.duration;
  }
  
  public long getDurationUs()
  {
    return this.duration.getTimeUs();
  }
  
  public CMTime getEnd()
  {
    return this.end;
  }
  
  public long getEndUs()
  {
    return getStartUs() + getDurationUs();
  }
  
  @NonNull
  public CMTime getStart()
  {
    return this.start;
  }
  
  public long getStartUs()
  {
    return this.start.getTimeUs();
  }
  
  public boolean isLegal()
  {
    return (getStartUs() >= 0L) && (getDurationUs() > 0L);
  }
  
  public void setDuration(@NonNull CMTime paramCMTime)
  {
    this.duration = paramCMTime;
    this.end = this.start.add(this.duration);
  }
  
  public void setStart(@NonNull CMTime paramCMTime)
  {
    this.start = paramCMTime;
    this.end = this.start.add(this.duration);
  }
  
  public CMTimeRange[] split(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F))
    {
      CMTimeRange localCMTimeRange = new CMTimeRange(this.start, getDuration().multi(paramFloat));
      return new CMTimeRange[] { localCMTimeRange, new CMTimeRange(localCMTimeRange.getEnd(), getDuration().multi(1.0F - paramFloat)) };
    }
    return null;
  }
  
  public String toSimpleString()
  {
    return "CMTimeRange{startUs=" + this.start.getTimeUs() + ", durationUs=" + this.duration.getTimeUs() + '}';
  }
  
  public String toString()
  {
    return "CMTimeRange{start=" + this.start + ", duration=" + this.duration + ", end=" + this.end + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMTimeRange
 * JD-Core Version:    0.7.0.1
 */