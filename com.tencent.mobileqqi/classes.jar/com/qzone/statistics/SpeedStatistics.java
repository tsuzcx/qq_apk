package com.qzone.statistics;

import com.qzone.statistics.common.SortedFixedLinkedList;
import java.util.Comparator;

public class SpeedStatistics
{
  private static final int UPDATE_AVERAGE_SPEED_INTERVAL = 2;
  private static final Comparator<StatisticsUnit> sUnitComparator = new Comparator()
  {
    public int compare(SpeedStatistics.StatisticsUnit paramAnonymousStatisticsUnit1, SpeedStatistics.StatisticsUnit paramAnonymousStatisticsUnit2)
    {
      if (paramAnonymousStatisticsUnit1.startTime > paramAnonymousStatisticsUnit2.startTime) {
        return -1;
      }
      if (paramAnonymousStatisticsUnit1.startTime < paramAnonymousStatisticsUnit2.startTime) {
        return 1;
      }
      return 0;
    }
  };
  private float mAverageSpeed;
  private int mAverageSpeedCount = 0;
  private final SortedFixedLinkedList<StatisticsUnit> mStatisticList = new SortedFixedLinkedList(100, sUnitComparator, false);
  private int mStatisticsCount;
  
  private static long gapBetween(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong3 > paramLong2) {
      return paramLong3 - paramLong2;
    }
    if (paramLong1 > paramLong4) {
      return paramLong1 - paramLong4;
    }
    return 0L;
  }
  
  public static SpeedStatistics getInstance()
  {
    return InstanceHolder.INSTANCE;
  }
  
  private static long max(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2) {
      return paramLong1;
    }
    return paramLong2;
  }
  
  private static int min(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  private static long min(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return paramLong1;
    }
    return paramLong2;
  }
  
  private boolean shouldUpdateAverageSpeed()
  {
    int i = this.mAverageSpeedCount;
    this.mAverageSpeedCount = (i + 1);
    if (i < 2) {
      return false;
    }
    this.mAverageSpeedCount = 0;
    return true;
  }
  
  private void updateAverageSpeed(int paramInt)
  {
    long l4 = 0L;
    int i = this.mStatisticList.size();
    if (paramInt > 0)
    {
      paramInt = min(i, paramInt);
      if (paramInt > 0) {
        break label34;
      }
    }
    label34:
    StatisticsUnit localStatisticsUnit;
    long l2;
    long l1;
    long l3;
    do
    {
      return;
      paramInt = i;
      break;
      localStatisticsUnit = (StatisticsUnit)this.mStatisticList.get(paramInt - 1);
      l2 = localStatisticsUnit.startTime;
      l1 = localStatisticsUnit.endTime;
      l3 = 0L;
      paramInt -= 1;
      if (paramInt >= 0) {
        break label135;
      }
      l1 = l1 - l2 - l3;
    } while (l1 <= 0L);
    double d1 = l4 / 1024.0D;
    double d2 = l1 / 1000.0D;
    if ((d1 > 0.0D) && (d2 > 0.0D)) {}
    for (float f = (float)(d1 / d2);; f = 0.0F)
    {
      this.mAverageSpeed = f;
      return;
      label135:
      localStatisticsUnit = (StatisticsUnit)this.mStatisticList.get(paramInt);
      l4 += localStatisticsUnit.bytesSize;
      long l6 = localStatisticsUnit.startTime;
      long l5 = localStatisticsUnit.endTime;
      l3 += gapBetween(l2, l1, l6, l5);
      l2 = min(l2, l6);
      l1 = max(l1, l5);
      paramInt -= 1;
      break;
    }
  }
  
  public float getAverageSpeed()
  {
    return this.mAverageSpeed;
  }
  
  public int getStatisticsCount()
  {
    return this.mStatisticsCount;
  }
  
  public void report(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 < 51200L) {
      return;
    }
    StatisticsUnit localStatisticsUnit = new StatisticsUnit();
    localStatisticsUnit.bytesSize = paramLong1;
    localStatisticsUnit.startTime = min(paramLong2, paramLong3);
    localStatisticsUnit.endTime = max(paramLong2, paramLong3);
    synchronized (this.mStatisticList)
    {
      this.mStatisticList.add(localStatisticsUnit);
      this.mStatisticsCount += 1;
      if (shouldUpdateAverageSpeed()) {
        updateAverageSpeed(5);
      }
      return;
    }
  }
  
  static class InstanceHolder
  {
    static final SpeedStatistics INSTANCE = new SpeedStatistics(null);
  }
  
  static class StatisticsUnit
  {
    long bytesSize;
    long endTime;
    long startTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.statistics.SpeedStatistics
 * JD-Core Version:    0.7.0.1
 */