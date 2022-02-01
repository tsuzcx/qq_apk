package com.tencent.qqmail.activity.setting;

import android.annotation.SuppressLint;
import android.content.pm.PackageStats;
import com.tencent.qqmail.utilities.QMPackageSizeManager.Callback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

class SettingPackageSizeActivity$5$1
  implements QMPackageSizeManager.Callback
{
  SettingPackageSizeActivity$5$1(SettingPackageSizeActivity.5 param5) {}
  
  @SuppressLint({"NewApi"})
  public void onGetStatsCompleted(PackageStats paramPackageStats, boolean paramBoolean)
  {
    synchronized (SettingPackageSizeActivity.access$1600(this.this$1.this$0))
    {
      SettingPackageSizeActivity.access$1600(this.this$1.this$0).put(paramPackageStats, Long.valueOf(SettingPackageSizeActivity.access$1000(this.this$1.this$0, paramPackageStats)));
      if (this.this$1.val$size == SettingPackageSizeActivity.access$1600(this.this$1.this$0).size())
      {
        SettingPackageSizeActivity.access$1702(this.this$1.this$0, new ArrayList(SettingPackageSizeActivity.access$1600(this.this$1.this$0).entrySet()));
        Collections.sort(SettingPackageSizeActivity.access$1700(this.this$1.this$0), new SettingPackageSizeActivity.5.1.1(this));
        SettingPackageSizeActivity.access$1600(this.this$1.this$0).clear();
        SettingPackageSizeActivity.access$2000(this.this$1.this$0, new SettingPackageSizeActivity.5.1.2(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingPackageSizeActivity.5.1
 * JD-Core Version:    0.7.0.1
 */