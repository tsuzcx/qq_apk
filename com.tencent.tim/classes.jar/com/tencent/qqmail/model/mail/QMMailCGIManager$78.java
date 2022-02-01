package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IBeforeSendCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;

class QMMailCGIManager$78
  implements QMCallback.IBeforeSendCallback
{
  QMMailCGIManager$78(QMMailCGIManager paramQMMailCGIManager, MailManagerDelegate paramMailManagerDelegate, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest)
  {
    if (this.val$callback != null) {
      this.val$callback.handleBeforeSend(this.val$email);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.78
 * JD-Core Version:    0.7.0.1
 */