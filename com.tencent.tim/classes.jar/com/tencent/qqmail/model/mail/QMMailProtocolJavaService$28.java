package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.callback.MailAbstractCallBack;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.qqmail.model.mail.callback.LoadMailAbstractCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolJavaService$28
  implements MailAbstractCallBack
{
  QMMailProtocolJavaService$28(QMMailProtocolJavaService paramQMMailProtocolJavaService, LoadMailAbstractCallback paramLoadMailAbstractCallback, com.tencent.qqmail.protocol.Profile paramProfile, com.tencent.moai.mailsdk.model.Profile paramProfile1, QMFolder paramQMFolder) {}
  
  public void onRetrieveMailAbstractError(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    QMLog.log(6, "QMMailProtocolJavaService", "downloadMailAbstract error : " + paramInt1 + ";" + paramInt2 + ";" + paramString);
    int i = ProtocolResult.mapToProtocolResult(paramInt1);
    if (paramInt1 == 4) {
      PasswordErrHandler.saveStateAndShowErr(this.val$folder.getAccountId(), -1);
    }
    if (this.val$callback != null) {
      this.val$callback.loadAbstractError(paramLong, new QMProtocolError(i));
    }
    if (paramInt1 != 11) {
      QMMailProtocolJavaService.access$400(this.this$0, this.val$profile, this.val$protocolProfile.getProtocol(), "downloadMailAbstract", paramInt2, paramString);
    }
  }
  
  public void onRetrieveMailAbstractSuccess(Mail paramMail)
  {
    if (this.val$callback != null) {
      this.val$callback.loadAbstractSuccess(paramMail.getId(), paramMail.getType(), QMMailProtocolJavaService.access$900(paramMail));
    }
    QMMailProtocolJavaService.access$300(this.this$0, this.val$profile.mailAddress, this.val$protocolProfile.getProtocol(), "downloadMailAbstract");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.28
 * JD-Core Version:    0.7.0.1
 */