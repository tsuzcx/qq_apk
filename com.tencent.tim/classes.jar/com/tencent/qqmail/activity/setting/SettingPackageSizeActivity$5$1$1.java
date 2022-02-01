package com.tencent.qqmail.activity.setting;

import android.content.pm.PackageStats;
import java.util.Comparator;
import java.util.Map.Entry;

class SettingPackageSizeActivity$5$1$1
  implements Comparator<Map.Entry<PackageStats, Long>>
{
  SettingPackageSizeActivity$5$1$1(SettingPackageSizeActivity.5.1 param1) {}
  
  public int compare(Map.Entry<PackageStats, Long> paramEntry1, Map.Entry<PackageStats, Long> paramEntry2)
  {
    if (paramEntry1.getValue() == paramEntry2.getValue()) {
      return 0;
    }
    if (((Long)paramEntry2.getValue()).longValue() > ((Long)paramEntry1.getValue()).longValue()) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingPackageSizeActivity.5.1.1
 * JD-Core Version:    0.7.0.1
 */