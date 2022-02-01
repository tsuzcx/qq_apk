package com.tencent.qqmail.model.protocol;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.SyncUpdateCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMPrivateProtocolManager$7
  implements SyncUpdateCallback
{
  QMPrivateProtocolManager$7(QMPrivateProtocolManager paramQMPrivateProtocolManager, Account paramAccount, int paramInt) {}
  
  public void onError(QMNetworkError paramQMNetworkError)
  {
    QMLog.log(5, "QMPrivateProtocolManager", "handleAccState, check error: " + paramQMNetworkError);
  }
  
  public void onSuccess(int paramInt)
  {
    QMLog.log(4, "QMPrivateProtocolManager", "handleAccState, check success, account: " + this.val$account.getEmail() + ", type: " + this.val$type);
    switch (this.val$type)
    {
    default: 
      return;
    case 1: 
      this.this$0.modAccount(this.val$account);
      return;
    }
    QMPrivateProtocolManager.access$1400(this.this$0, this.val$account);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.7
 * JD-Core Version:    0.7.0.1
 */