package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.network.filter.RequestFilter;

class QMMailProtocolManager$3
  implements Runnable
{
  QMMailProtocolManager$3(QMMailProtocolManager paramQMMailProtocolManager, int paramInt, Runnable paramRunnable, String paramString) {}
  
  public void run()
  {
    QMWatcherCenter.triggerSyncEnd(this.val$accountId, true);
    if (this.val$onComplete != null) {
      this.val$onComplete.run();
    }
    RequestFilter.resetRequestRunningState(this.val$req);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.3
 * JD-Core Version:    0.7.0.1
 */