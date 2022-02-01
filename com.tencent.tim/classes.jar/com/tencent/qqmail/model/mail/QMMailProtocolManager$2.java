package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.FolderListCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.QMSyncErrorManager;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolManager$2
  implements FolderListCallback
{
  QMMailProtocolManager$2(QMMailProtocolManager paramQMMailProtocolManager, int paramInt) {}
  
  public void onError(QMProtocolError paramQMProtocolError)
  {
    QMSyncErrorManager.sharedInstance().handleSyncError(this.val$accountId, paramQMProtocolError, true);
  }
  
  public void onSuccess(QMFolder[] paramArrayOfQMFolder1, QMFolder[] paramArrayOfQMFolder2, QMFolder[] paramArrayOfQMFolder3)
  {
    QMSyncErrorManager.sharedInstance().removeSyncError(this.val$accountId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.2
 * JD-Core Version:    0.7.0.1
 */