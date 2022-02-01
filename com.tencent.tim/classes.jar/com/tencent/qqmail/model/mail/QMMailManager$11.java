package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.IListStatusCallback;
import com.tencent.qqmail.model.protocol.QMSyncManager;
import com.tencent.qqmail.utilities.QMSyncErrorManager;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMMailManager$11
  implements IListStatusCallback
{
  QMMailManager$11(QMMailManager paramQMMailManager, IListStatusCallback paramIListStatusCallback, int paramInt1, int paramInt2) {}
  
  public void error(QMNetworkError paramQMNetworkError)
  {
    if (this.val$statusCallback != null) {
      this.val$statusCallback.error(paramQMNetworkError);
    }
    QMSyncErrorManager.sharedInstance().handleSyncError(this.val$accountId, paramQMNetworkError, true);
  }
  
  public void process()
  {
    if (this.val$statusCallback != null) {
      this.val$statusCallback.process();
    }
  }
  
  public void success(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.val$statusCallback != null) {
      this.val$statusCallback.success(paramBoolean, paramInt1, paramInt2);
    }
    QMSyncErrorManager.sharedInstance().removeSyncError(this.val$accountId);
    QMSyncManager.sharedInstance().deleteFolderOverdueMail(this.val$accountId, this.val$folderId, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.11
 * JD-Core Version:    0.7.0.1
 */