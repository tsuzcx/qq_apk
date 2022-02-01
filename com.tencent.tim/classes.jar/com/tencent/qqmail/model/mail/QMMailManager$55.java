package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.SyncUpdateCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.badge.BadgeUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class QMMailManager$55
  implements Runnable
{
  QMMailManager$55(QMMailManager paramQMMailManager, CountDownLatch paramCountDownLatch, Account paramAccount, Map paramMap, AtomicInteger paramAtomicInteger, int paramInt, String paramString, SyncUpdateCallback paramSyncUpdateCallback) {}
  
  public void run()
  {
    try
    {
      this.val$cdl.await(120L, TimeUnit.SECONDS);
      label14:
      QMLog.log(4, "QMMailManager", "syncUpdateWithNotification done, account: " + this.val$account.getEmail() + ", folders: " + this.val$map.size() + ", " + this.val$map.keySet() + ", err: " + this.val$errorCount + ", unfinished: " + this.val$cdl.getCount());
      int i = QMMailManager.access$1500(this.this$0, this.val$accountId, this.val$map, this.val$type);
      if (this.val$errorCount.get() + this.val$cdl.getCount() == this.val$map.size()) {
        if (this.val$syncUpdateCallback != null) {
          this.val$syncUpdateCallback.onError(null);
        }
      }
      for (;;)
      {
        QMWatcherCenter.triggerSyncEnd(this.val$accountId, false);
        return;
        BadgeUtil.getInstance().setBadgeAccordingQMAccount();
        QMNotification.postNotification("BROADCAST_UPDATE_INBOX_WIDGET_DATA", null);
        if (this.val$syncUpdateCallback != null) {
          this.val$syncUpdateCallback.onSuccess(i);
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label14;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.55
 * JD-Core Version:    0.7.0.1
 */