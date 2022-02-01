package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.ui.QMTips;

class SettingNoteActivity$1$2
  implements Runnable
{
  SettingNoteActivity$1$2(SettingNoteActivity.1 param1, QMCGIError paramQMCGIError) {}
  
  public void run()
  {
    String str2 = this.this$1.this$0.getString(2131696417);
    String str1 = str2;
    if (this.val$error != null)
    {
      str1 = str2;
      if (this.val$error.appCode == -117) {
        str1 = this.this$1.this$0.getString(2131696418);
      }
    }
    SettingNoteActivity.access$200(this.this$1.this$0).showError(str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingNoteActivity.1.2
 * JD-Core Version:    0.7.0.1
 */