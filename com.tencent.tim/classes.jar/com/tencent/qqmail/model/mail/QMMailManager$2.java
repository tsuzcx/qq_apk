package com.tencent.qqmail.model.mail;

import android.os.SystemClock;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.badge.BadgeUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class QMMailManager$2
  implements Runnable
{
  QMMailManager$2(QMMailManager paramQMMailManager, CountDownLatch paramCountDownLatch, int[] paramArrayOfInt, long paramLong, Set paramSet) {}
  
  public void run()
  {
    try
    {
      this.val$cdl.await(30L, TimeUnit.SECONDS);
      label14:
      QMLog.log(4, "QMMailManager", "sync done, accounts: " + Arrays.toString(this.val$accountsToSync) + ", elapsed: " + (SystemClock.elapsedRealtime() - this.val$begin) + ", unfinished: " + this.val$cdl.getCount());
      if (this.val$cdl.getCount() > 0L) {
        QMLog.log(5, "QMMailManager", "some sync tasks may not be finished, finished: " + this.val$finished);
      }
      QMWatcherCenter.triggerSyncSuccess(0);
      BadgeUtil.getInstance().setBadgeAccordingQMAccount();
      QMNotification.postNotification("BROADCAST_UPDATE_INBOX_WIDGET_DATA", null);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label14;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.2
 * JD-Core Version:    0.7.0.1
 */