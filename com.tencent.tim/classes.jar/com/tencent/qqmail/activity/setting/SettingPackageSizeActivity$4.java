package com.tencent.qqmail.activity.setting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

class SettingPackageSizeActivity$4
  implements Runnable
{
  SettingPackageSizeActivity$4(SettingPackageSizeActivity paramSettingPackageSizeActivity) {}
  
  public void run()
  {
    if (SettingPackageSizeActivity.access$1600(this.this$0).size() == 0) {
      return;
    }
    synchronized (SettingPackageSizeActivity.access$1600(this.this$0))
    {
      if (SettingPackageSizeActivity.access$1600(this.this$0).size() == 0) {
        return;
      }
    }
    SettingPackageSizeActivity.access$1702(this.this$0, new ArrayList(SettingPackageSizeActivity.access$1600(this.this$0).entrySet()));
    Collections.sort(SettingPackageSizeActivity.access$1700(this.this$0), new SettingPackageSizeActivity.4.1(this));
    SettingPackageSizeActivity.access$1600(this.this$0).clear();
    SettingPackageSizeActivity.access$1900(this.this$0, new SettingPackageSizeActivity.4.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingPackageSizeActivity.4
 * JD-Core Version:    0.7.0.1
 */