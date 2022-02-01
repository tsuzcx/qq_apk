package com.tencent.tavkit.report;

import android.support.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FilterChainReportSession
{
  @Nullable
  private static IReporter reporter;
  private Map<String, TimeConsumer> timeConsumerMap = new HashMap();
  
  public static void setReporter(@Nullable IReporter paramIReporter)
  {
    try
    {
      reporter = paramIReporter;
      return;
    }
    finally
    {
      paramIReporter = finally;
      throw paramIReporter;
    }
  }
  
  public void commit()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.timeConsumerMap.values().iterator();
    while (localIterator.hasNext())
    {
      TimeConsumer localTimeConsumer = (TimeConsumer)localIterator.next();
      if (localTimeConsumer != null) {
        localHashMap.put(localTimeConsumer.key, Long.valueOf(localTimeConsumer.getAvgTimeUs()));
      }
    }
    try
    {
      if (reporter != null) {
        reporter.onCommit(localHashMap);
      }
      return;
    }
    finally {}
  }
  
  public void tick(String paramString, long paramLong)
  {
    TimeConsumer localTimeConsumer2 = (TimeConsumer)this.timeConsumerMap.get(paramString);
    TimeConsumer localTimeConsumer1 = localTimeConsumer2;
    if (localTimeConsumer2 == null)
    {
      localTimeConsumer1 = new TimeConsumer(paramString);
      this.timeConsumerMap.put(localTimeConsumer1.key, localTimeConsumer1);
    }
    localTimeConsumer1.tick(paramLong / 1000L);
  }
  
  public static abstract interface IReporter
  {
    public abstract void onCommit(Map<String, Long> paramMap);
  }
  
  static class TimeConsumer
  {
    private long count = 0L;
    private final String key;
    private long totalUs = 0L;
    
    public TimeConsumer(String paramString)
    {
      this.key = paramString;
    }
    
    private long getAvgTimeUs()
    {
      if (this.count == 0L) {
        return 0L;
      }
      return this.totalUs / this.count;
    }
    
    private void tick(long paramLong)
    {
      this.totalUs += paramLong;
      this.count += 1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.report.FilterChainReportSession
 * JD-Core Version:    0.7.0.1
 */