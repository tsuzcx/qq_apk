package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMMailProtocolManager$7$1
  implements IListCallback
{
  QMMailProtocolManager$7$1(QMMailProtocolManager.7 param7) {}
  
  public void error(QMNetworkError paramQMNetworkError)
  {
    QMLog.log(5, "QMMailProtocolManager", "syncFolder updateList onError, error: " + paramQMNetworkError + ", folder: " + this.this$1.val$folder);
  }
  
  public void process()
  {
    QMWatcherCenter.triggerLoadListProcess(this.this$1.val$folderId, true);
  }
  
  public void success(long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramArrayOfLong != null) {}
    for (int i = paramArrayOfLong.length;; i = 0)
    {
      QMLog.log(4, "QMMailProtocolManager", "syncFolder updateList onSuccess, newMailCount: " + i + ", folder: " + this.this$1.val$folder);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.7.1
 * JD-Core Version:    0.7.0.1
 */