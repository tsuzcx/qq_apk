package com.tencent.tavsticker.utils;

import com.tencent.tav.coremedia.CMTimeRange;

public class TimeRangeUtil
{
  public static boolean isInTimeRange(CMTimeRange paramCMTimeRange, long paramLong)
  {
    return (isValidTimeRange(paramCMTimeRange)) && (paramLong >= 0L) && (paramLong * 1000L >= paramCMTimeRange.getStartUs()) && (paramLong * 1000L < paramCMTimeRange.getEndUs());
  }
  
  public static boolean isValidTimeRange(CMTimeRange paramCMTimeRange)
  {
    if (paramCMTimeRange == null) {
      return false;
    }
    return paramCMTimeRange.isLegal();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.utils.TimeRangeUtil
 * JD-Core Version:    0.7.0.1
 */