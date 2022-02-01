package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import rx.functions.Action1;

class SendMailManager$2
  implements Action1<QMNetworkRequest>
{
  SendMailManager$2(SendMailManager paramSendMailManager, SendMailRequest paramSendMailRequest) {}
  
  public void call(QMNetworkRequest paramQMNetworkRequest)
  {
    this.val$sendMailRequest.setCgiRequest(paramQMNetworkRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.2
 * JD-Core Version:    0.7.0.1
 */