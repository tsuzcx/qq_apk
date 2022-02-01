package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class SettingCacheClearActivity$6
  implements Runnable
{
  SettingCacheClearActivity$6(SettingCacheClearActivity paramSettingCacheClearActivity) {}
  
  public void run()
  {
    long l = QMMailManager.sharedInstance().getMailContentSize();
    String str = SettingCacheClearActivity.access$800(this.this$0, StringExtention.getHumanReadableSizeString(l));
    SettingCacheClearActivity.access$1100(this.this$0, new SettingCacheClearActivity.6.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCacheClearActivity.6
 * JD-Core Version:    0.7.0.1
 */