package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.List;

class SettingAccountActivity$1
  implements SyncPhotoWatcher
{
  SettingAccountActivity$1(SettingAccountActivity paramSettingAccountActivity) {}
  
  public void onError(QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "SettingAccountActivity", "sync photo err : " + paramQMNetworkError.toString());
  }
  
  public void onSuccess(List<String> paramList)
  {
    Threads.runOnMainThread(new SettingAccountActivity.1.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.1
 * JD-Core Version:    0.7.0.1
 */