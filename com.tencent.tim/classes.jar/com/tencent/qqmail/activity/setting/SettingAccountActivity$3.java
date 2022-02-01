package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.watcher.SetPhotoWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

class SettingAccountActivity$3
  implements SetPhotoWatcher
{
  SettingAccountActivity$3(SettingAccountActivity paramSettingAccountActivity) {}
  
  public void onError(int paramInt)
  {
    QMLog.log(6, "SettingAccountActivity", "setPhotoWatcher err:" + paramInt);
    if (paramInt == SettingAccountActivity.access$300(this.this$0)) {
      Threads.runOnMainThread(new SettingAccountActivity.3.2(this));
    }
  }
  
  public void onSuccess(int paramInt)
  {
    QMLog.log(4, "SettingAccountActivity", "setPhotoWatcher:" + paramInt);
    if (paramInt == SettingAccountActivity.access$300(this.this$0)) {
      Threads.runOnMainThread(new SettingAccountActivity.3.1(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.3
 * JD-Core Version:    0.7.0.1
 */