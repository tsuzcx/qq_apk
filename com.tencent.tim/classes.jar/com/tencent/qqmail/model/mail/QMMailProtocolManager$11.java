package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMMailProtocolManager$11
  implements IListCallback
{
  QMMailProtocolManager$11(QMMailProtocolManager paramQMMailProtocolManager, int paramInt) {}
  
  public void error(QMNetworkError paramQMNetworkError) {}
  
  public void process()
  {
    QMWatcherCenter.triggerLoadListProcess(this.val$folderId, true);
  }
  
  public void success(long[] paramArrayOfLong, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.11
 * JD-Core Version:    0.7.0.1
 */