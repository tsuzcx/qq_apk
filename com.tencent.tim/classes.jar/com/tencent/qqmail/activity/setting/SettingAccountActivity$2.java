package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.watcher.SyncNickWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

class SettingAccountActivity$2
  implements SyncNickWatcher
{
  SettingAccountActivity$2(SettingAccountActivity paramSettingAccountActivity) {}
  
  public void onError(String paramString)
  {
    QMLog.log(6, "SettingAccountActivity", "sync nick err : " + paramString);
  }
  
  public void onSuccess(String paramString)
  {
    Threads.runOnMainThread(new SettingAccountActivity.2.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.2
 * JD-Core Version:    0.7.0.1
 */