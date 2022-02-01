package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingCacheClearActivity$2
  implements Runnable
{
  SettingCacheClearActivity$2(SettingCacheClearActivity paramSettingCacheClearActivity) {}
  
  public void run()
  {
    int j = 0;
    if (SettingCacheClearActivity.access$100(this.this$0).isChecked())
    {
      j = 3;
      DataCollector.logEvent("Event_Click_Mail_Attach_Cache");
    }
    int i = j;
    if (SettingCacheClearActivity.access$200(this.this$0).isChecked())
    {
      DataCollector.logEvent("Event_Click_Mail_Content_Cache");
      i = j + 4;
    }
    j = i;
    if (SettingCacheClearActivity.access$300(this.this$0).isChecked())
    {
      j = i + 8;
      DataCollector.logEvent("Event_Click_Mail_Image_Cache");
    }
    i = j;
    if (SettingCacheClearActivity.access$400(this.this$0).isChecked())
    {
      i = j + 16;
      DataCollector.logEvent("Event_Click_Temp_Cache");
    }
    FileUtil.clearCache(i);
    SettingCacheClearActivity.access$500(this.this$0);
    this.this$0.runOnUiThread(new SettingCacheClearActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCacheClearActivity.2
 * JD-Core Version:    0.7.0.1
 */