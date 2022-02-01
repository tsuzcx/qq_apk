package com.tencent.qqmail.utilities;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.utilities.log.QMLog;

class CrashGuard$1
  implements Runnable
{
  CrashGuard$1(CrashGuard paramCrashGuard) {}
  
  public void run()
  {
    QMLog.log(4, "CrashGuard", "process successfully, close delay key: " + CrashGuard.access$000(this.this$0));
    CrashGuard.access$200().edit().remove(CrashGuard.access$100(this.this$0)).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.CrashGuard.1
 * JD-Core Version:    0.7.0.1
 */