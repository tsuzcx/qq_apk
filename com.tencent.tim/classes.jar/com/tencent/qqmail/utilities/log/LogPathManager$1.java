package com.tencent.qqmail.utilities.log;

import android.content.Context;
import android.util.Log;
import com.tencent.qqmail.permission.PermissionChangedWatcher;

class LogPathManager$1
  implements PermissionChangedWatcher
{
  LogPathManager$1(LogPathManager paramLogPathManager) {}
  
  public void onPermssionChanged(String[] paramArrayOfString)
  {
    paramArrayOfString = this.this$0;
    if (LogPathManager.access$100(this.this$0).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {}
    for (boolean bool = true;; bool = false)
    {
      LogPathManager.access$002(paramArrayOfString, bool);
      Log.i("LogPathManager", "onPermssionChanged: " + LogPathManager.access$000(this.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.LogPathManager.1
 * JD-Core Version:    0.7.0.1
 */