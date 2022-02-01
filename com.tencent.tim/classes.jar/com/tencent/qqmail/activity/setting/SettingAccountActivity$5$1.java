package com.tencent.qqmail.activity.setting;

import android.util.Log;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.thread.Threads;

class SettingAccountActivity$5$1
  implements ICallBack
{
  SettingAccountActivity$5$1(SettingAccountActivity.5 param5) {}
  
  public void callback(Object paramObject)
  {
    if ((SettingAccountActivity.access$900(this.this$1.this$0)) || (this.this$1.this$0.isFinishing()))
    {
      Log.d("ahang", "accountDeleted or activity finish");
      return;
    }
    Threads.runOnMainThread(SettingAccountActivity.access$1000(this.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.5.1
 * JD-Core Version:    0.7.0.1
 */