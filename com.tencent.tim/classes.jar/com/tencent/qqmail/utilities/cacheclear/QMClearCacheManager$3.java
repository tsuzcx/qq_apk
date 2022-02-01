package com.tencent.qqmail.utilities.cacheclear;

import java.util.Comparator;

final class QMClearCacheManager$3
  implements Comparator<long[]>
{
  public int compare(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (paramArrayOfLong1[1] > paramArrayOfLong2[1]) {
      return 1;
    }
    if (paramArrayOfLong1[1] < paramArrayOfLong2[1]) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.cacheclear.QMClearCacheManager.3
 * JD-Core Version:    0.7.0.1
 */