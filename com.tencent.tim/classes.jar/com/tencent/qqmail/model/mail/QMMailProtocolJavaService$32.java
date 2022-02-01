package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.callback.MailOperationCallback;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolJavaService$32
  implements MailOperationCallback
{
  QMMailProtocolJavaService$32(QMMailProtocolJavaService paramQMMailProtocolJavaService, com.tencent.qqmail.model.qmdomain.Mail paramMail, QMFolder paramQMFolder, MailManagerDelegate paramMailManagerDelegate, com.tencent.qqmail.protocol.Profile paramProfile, com.tencent.moai.mailsdk.model.Profile paramProfile1) {}
  
  public void onMailOperationError(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.log(6, "QMMailProtocolJavaService", "append fail:" + paramInt1 + "," + paramInt2 + "," + paramString);
    if (this.val$callback != null) {
      this.val$callback.handleError(new QMProtocolError(ProtocolResult.mapToProtocolResult(paramInt1)));
    }
    QMMailProtocolJavaService.access$400(this.this$0, this.val$profile, this.val$protocolProfile.getProtocol(), "append", paramInt1, paramString);
  }
  
  public void onMailOperationSuccess(com.tencent.moai.mailsdk.model.Mail[] paramArrayOfMail)
  {
    QMLog.log(4, "QMMailProtocolJavaService", "append success:" + this.val$mail.getInformation().getSubject() + ", folder:" + this.val$folder.getRemoteId());
    if (this.val$callback != null) {
      this.val$callback.handleSuccess(null, null);
    }
    QMMailProtocolJavaService.access$300(this.this$0, this.val$profile.mailAddress, this.val$protocolProfile.getProtocol(), "append");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.32
 * JD-Core Version:    0.7.0.1
 */