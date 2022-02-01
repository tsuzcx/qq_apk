package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.FolderListCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolManager$10
  implements FolderListCallback
{
  QMMailProtocolManager$10(QMMailProtocolManager paramQMMailProtocolManager, Account paramAccount, FolderListCallback paramFolderListCallback) {}
  
  public void onError(QMProtocolError paramQMProtocolError)
  {
    if (this.val$callback != null) {
      this.val$callback.onError(paramQMProtocolError);
    }
  }
  
  public void onSuccess(QMFolder[] paramArrayOfQMFolder1, QMFolder[] paramArrayOfQMFolder2, QMFolder[] paramArrayOfQMFolder3)
  {
    QMMailProtocolManager.access$300(this.this$0, this.val$account.getId(), paramArrayOfQMFolder1, paramArrayOfQMFolder2, paramArrayOfQMFolder3);
    if (this.val$callback != null) {
      this.val$callback.onSuccess(paramArrayOfQMFolder1, paramArrayOfQMFolder2, paramArrayOfQMFolder3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.10
 * JD-Core Version:    0.7.0.1
 */