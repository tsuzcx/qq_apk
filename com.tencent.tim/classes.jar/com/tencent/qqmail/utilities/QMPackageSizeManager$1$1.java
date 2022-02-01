package com.tencent.qqmail.utilities;

import android.content.pm.PackageStats;
import java.util.Comparator;
import java.util.Map.Entry;

class QMPackageSizeManager$1$1
  implements Comparator<Map.Entry<PackageStats, Long>>
{
  QMPackageSizeManager$1$1(QMPackageSizeManager.1 param1) {}
  
  public int compare(Map.Entry<PackageStats, Long> paramEntry1, Map.Entry<PackageStats, Long> paramEntry2)
  {
    if (((Long)paramEntry1.getValue()).equals(paramEntry2.getValue())) {
      return 0;
    }
    if (((Long)paramEntry2.getValue()).longValue() > ((Long)paramEntry1.getValue()).longValue()) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMPackageSizeManager.1.1
 * JD-Core Version:    0.7.0.1
 */