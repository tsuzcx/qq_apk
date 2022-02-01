package com.tencent.qqmail.model.protocol;

import com.tencent.androidqqmail.tim.TimMailLoginManager.GetTicketCallback;
import com.tencent.qqmail.model.mail.PasswordErrHandler;
import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;

class QMPrivateProtocolManager$28
  implements TimMailLoginManager.GetTicketCallback
{
  QMPrivateProtocolManager$28(QMPrivateProtocolManager paramQMPrivateProtocolManager, QMGeneralCallback paramQMGeneralCallback, int paramInt) {}
  
  public void onError(String paramString, int paramInt1, int paramInt2)
  {
    PasswordErrHandler.saveStateAndShowErr(this.val$accountId, -1);
    if (this.val$callback != null) {
      this.val$callback.onError();
    }
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    if (this.val$callback != null) {
      this.val$callback.onSuccess();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.28
 * JD-Core Version:    0.7.0.1
 */