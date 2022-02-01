package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.watcher.FtnQueryAccountWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.HashMap;

class SettingFtnActivity$1
  implements FtnQueryAccountWatcher
{
  SettingFtnActivity$1(SettingFtnActivity paramSettingFtnActivity) {}
  
  public void onError()
  {
    QMLog.log(6, "SettingFtnActivity", "query account Error.");
  }
  
  public void onSuccess(HashMap<String, Object> paramHashMap)
  {
    if (SettingFtnActivity.access$000(this.this$0) == SettingFtnActivity.access$000(this.this$0)) {
      Threads.runOnMainThread(new SettingFtnActivity.1.1(this, paramHashMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingFtnActivity.1
 * JD-Core Version:    0.7.0.1
 */