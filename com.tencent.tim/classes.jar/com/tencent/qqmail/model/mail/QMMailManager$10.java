package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.mail.callback.IListStatusCallback;
import com.tencent.qqmail.model.protocol.QMSyncManager;
import com.tencent.qqmail.utilities.QMSyncErrorManager;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMMailManager$10
  implements IListCallback
{
  QMMailManager$10(QMMailManager paramQMMailManager, IListStatusCallback paramIListStatusCallback, int paramInt1, int paramInt2, Account paramAccount) {}
  
  public void error(QMNetworkError paramQMNetworkError)
  {
    boolean bool = true;
    if (this.val$statusCallback != null) {
      this.val$statusCallback.error(paramQMNetworkError);
    }
    QMSyncErrorManager localQMSyncErrorManager = QMSyncErrorManager.sharedInstance();
    int i = this.val$accountId;
    if ((this.val$account.getProtocol() != 1) && (this.val$account.getProtocol() != 2)) {}
    for (;;)
    {
      localQMSyncErrorManager.handleSyncError(i, paramQMNetworkError, bool);
      return;
      bool = false;
    }
  }
  
  public void process()
  {
    if (this.val$statusCallback != null) {
      this.val$statusCallback.process();
    }
  }
  
  public void success(long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramArrayOfLong != null) {}
    for (int i = paramArrayOfLong.length;; i = 0)
    {
      if (this.val$statusCallback != null) {
        this.val$statusCallback.success(true, i, i);
      }
      QMSyncErrorManager.sharedInstance().removeSyncError(this.val$accountId);
      QMSyncManager.sharedInstance().deleteFolderOverdueMail(this.val$accountId, this.val$folderId, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.10
 * JD-Core Version:    0.7.0.1
 */