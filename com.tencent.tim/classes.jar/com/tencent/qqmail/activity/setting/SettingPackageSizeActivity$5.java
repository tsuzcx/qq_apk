package com.tencent.qqmail.activity.setting;

import android.content.pm.PackageInfo;
import com.tencent.qqmail.utilities.QMPackageSizeManager;

class SettingPackageSizeActivity$5
  implements Runnable
{
  SettingPackageSizeActivity$5(SettingPackageSizeActivity paramSettingPackageSizeActivity, PackageInfo paramPackageInfo, int paramInt) {}
  
  public void run()
  {
    QMPackageSizeManager.getPackageSize(this.val$info.packageName, new SettingPackageSizeActivity.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingPackageSizeActivity.5
 * JD-Core Version:    0.7.0.1
 */