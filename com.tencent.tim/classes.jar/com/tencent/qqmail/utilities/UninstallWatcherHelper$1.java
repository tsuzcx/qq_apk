package com.tencent.qqmail.utilities;

import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import java.util.Date;

final class UninstallWatcherHelper$1
  implements Runnable
{
  UninstallWatcherHelper$1(boolean paramBoolean) {}
  
  public void run()
  {
    if (UninstallWatcherHelper.initUninstallWatcher(this.val$foreceToCreate)) {
      SharedPreferenceUtil.setInitUninstallWatchProcessTime(new Date().getTime());
    }
    UninstallWatcherHelper.access$002(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.UninstallWatcherHelper.1
 * JD-Core Version:    0.7.0.1
 */