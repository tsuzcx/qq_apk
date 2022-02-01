package com.tencent.ttpic.baseutils.device;

class CPUYearList
{
  private static final long KHZ = 1000L;
  private static final int[] SCORES_NUM = { 2, 3, 7 };
  private static final long[] SCPU_Freq = { 1520000L, 1620000L, 1780000L, 2000000L, 2200000L, 2600000L };
  private static final int START_CORE_YEAR = 2012;
  private static final int START_YEAR = 2013;
  
  public static int getCPUOclock(long paramLong)
  {
    int i = SCPU_Freq.length - 1;
    while (i >= 0)
    {
      if (SCPU_Freq[i] < paramLong) {
        return i + 2013;
      }
      i -= 1;
    }
    return 2013;
  }
  
  public static int getCoreNumYear(int paramInt)
  {
    int i = SCORES_NUM.length - 1;
    while (i >= 0)
    {
      if (SCORES_NUM[i] < paramInt) {
        return i + 2012;
      }
      i -= 1;
    }
    return 2012;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.device.CPUYearList
 * JD-Core Version:    0.7.0.1
 */