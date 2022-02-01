package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.QMPathManager;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class SettingCacheClearActivity$7
  implements Runnable
{
  SettingCacheClearActivity$7(SettingCacheClearActivity paramSettingCacheClearActivity) {}
  
  public void run()
  {
    long l1 = FileUtil.getProtocolMailCacheSize();
    long l2 = FileUtil.getDirectorySize(QMPathManager.sharedInstance().getQQMailEmailIconDir());
    long l3 = FileUtil.getDirectorySize(QMPathManager.sharedInstance().getQQMailNickIconDir());
    long l4 = FileUtil.getDirectorySize(QMPathManager.sharedInstance().getQQMailLogDir());
    String str = SettingCacheClearActivity.access$800(this.this$0, StringExtention.getHumanReadableSizeString(0L + l1 + l2 + l3 + l4));
    SettingCacheClearActivity.access$1200(this.this$0, new SettingCacheClearActivity.7.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCacheClearActivity.7
 * JD-Core Version:    0.7.0.1
 */