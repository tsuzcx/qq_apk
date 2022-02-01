package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.IListStatusCallback;
import com.tencent.qqmail.utilities.QMSyncErrorManager;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMMailProtocolManager$1
  implements IListStatusCallback
{
  QMMailProtocolManager$1(QMMailProtocolManager paramQMMailProtocolManager, int paramInt) {}
  
  public void error(QMNetworkError paramQMNetworkError)
  {
    QMSyncErrorManager.sharedInstance().handleSyncError(this.val$accountId, paramQMNetworkError, true);
  }
  
  public void process() {}
  
  public void success(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    QMSyncErrorManager.sharedInstance().removeSyncError(this.val$accountId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.1
 * JD-Core Version:    0.7.0.1
 */