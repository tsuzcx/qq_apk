package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.QMPackageSizeManager;

class SettingPackageSizeActivity$1
  implements Runnable
{
  SettingPackageSizeActivity$1(SettingPackageSizeActivity paramSettingPackageSizeActivity) {}
  
  public void run()
  {
    QMPackageSizeManager.getPackageSize(this.this$0.getPackageName(), new SettingPackageSizeActivity.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingPackageSizeActivity.1
 * JD-Core Version:    0.7.0.1
 */