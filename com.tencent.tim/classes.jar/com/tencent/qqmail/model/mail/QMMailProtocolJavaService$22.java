package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.callback.MailOperationCallback;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolJavaService$22
  implements MailOperationCallback
{
  QMMailProtocolJavaService$22(QMMailProtocolJavaService paramQMMailProtocolJavaService, MailManagerDelegate paramMailManagerDelegate, com.tencent.qqmail.protocol.Profile paramProfile, com.tencent.moai.mailsdk.model.Profile paramProfile1, int paramInt) {}
  
  public void onMailOperationError(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.log(6, "QMMailProtocolJavaService", "moveMail error : " + paramInt1 + ";" + paramInt2 + ";" + paramString);
    int i = ProtocolResult.mapToProtocolResult(paramInt1);
    if (paramInt1 == 4) {
      PasswordErrHandler.saveStateAndShowErr(this.val$accountId, -1);
    }
    if (this.val$callback != null)
    {
      QMProtocolError localQMProtocolError = new QMProtocolError(i);
      this.val$callback.handleError(localQMProtocolError);
      this.val$callback.handleComplete(null);
    }
    QMMailProtocolJavaService.access$400(this.this$0, this.val$profile, this.val$protocolProfile.getProtocol(), "moveMails", paramInt2, paramString);
  }
  
  public void onMailOperationSuccess(Mail[] paramArrayOfMail)
  {
    QMLog.log(4, "QMMailProtocolJavaService", "moveMail success");
    if (this.val$callback != null)
    {
      this.val$callback.handleSuccess(null, null);
      this.val$callback.handleComplete(null);
    }
    QMMailProtocolJavaService.access$300(this.this$0, this.val$profile.mailAddress, this.val$protocolProfile.getProtocol(), "moveMails");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.22
 * JD-Core Version:    0.7.0.1
 */