package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.cacheclear.QMClearCacheManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class SettingCacheClearActivity$4
  implements Runnable
{
  SettingCacheClearActivity$4(SettingCacheClearActivity paramSettingCacheClearActivity) {}
  
  public void run()
  {
    long l = QMClearCacheManager.getAttachCache(true);
    String str = SettingCacheClearActivity.access$800(this.this$0, StringExtention.getHumanReadableSizeString(l));
    SettingCacheClearActivity.access$900(this.this$0, new SettingCacheClearActivity.4.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCacheClearActivity.4
 * JD-Core Version:    0.7.0.1
 */