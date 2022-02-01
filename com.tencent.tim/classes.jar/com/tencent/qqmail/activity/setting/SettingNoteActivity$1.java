package com.tencent.qqmail.activity.setting;

import android.util.Log;
import com.tencent.qqmail.model.mail.watcher.ChangeNoteDefaultCategoryWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;

class SettingNoteActivity$1
  implements ChangeNoteDefaultCategoryWatcher
{
  SettingNoteActivity$1(SettingNoteActivity paramSettingNoteActivity) {}
  
  public void onError(QMCGIError paramQMCGIError)
  {
    Log.d("SettingNoteActivity", "ChangeNoteDefaultCategoryWatcher: " + paramQMCGIError.toString());
    SettingNoteActivity.access$300(this.this$0, new SettingNoteActivity.1.2(this, paramQMCGIError));
  }
  
  public void onSuccess(String paramString)
  {
    SettingNoteActivity.access$100(this.this$0, new SettingNoteActivity.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingNoteActivity.1
 * JD-Core Version:    0.7.0.1
 */