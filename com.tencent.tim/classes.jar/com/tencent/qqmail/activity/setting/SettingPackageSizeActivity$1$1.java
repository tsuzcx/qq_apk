package com.tencent.qqmail.activity.setting;

import android.annotation.SuppressLint;
import android.content.pm.PackageStats;
import com.tencent.qqmail.utilities.QMPackageSizeManager.Callback;

class SettingPackageSizeActivity$1$1
  implements QMPackageSizeManager.Callback
{
  SettingPackageSizeActivity$1$1(SettingPackageSizeActivity.1 param1) {}
  
  @SuppressLint({"NewApi"})
  public void onGetStatsCompleted(PackageStats paramPackageStats, boolean paramBoolean)
  {
    SettingPackageSizeActivity.access$1200(this.this$1.this$0, new SettingPackageSizeActivity.1.1.1(this, paramPackageStats));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingPackageSizeActivity.1.1
 * JD-Core Version:    0.7.0.1
 */