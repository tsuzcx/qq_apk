package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.callback.MailCallBack;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.LoadMailCallback;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.calendar.ICalendarResolver;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class QMMailProtocolJavaService$27
  implements MailCallBack
{
  QMMailProtocolJavaService$27(QMMailProtocolJavaService paramQMMailProtocolJavaService, int paramInt1, int paramInt2, int paramInt3, LoadMailCallback paramLoadMailCallback, long paramLong, com.tencent.qqmail.protocol.Profile paramProfile, com.tencent.moai.mailsdk.model.Profile paramProfile1, Account paramAccount, QMFolder paramQMFolder, com.tencent.qqmail.model.qmdomain.Mail paramMail, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onRetrieveMailError(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.log(6, "QMMailProtocolJavaService", "downloadMailText error : " + paramInt1 + ";" + paramInt2 + ";" + paramString);
    int i = ProtocolResult.mapToProtocolResult(paramInt1);
    if (paramInt1 == 4) {
      PasswordErrHandler.saveStateAndShowErr(this.val$accountId, -1);
    }
    while (paramInt1 != 8)
    {
      if (this.val$callback != null)
      {
        localObject = new QMProtocolError(i);
        this.val$callback.loadMailError((QMProtocolError)localObject);
      }
      if (paramInt1 != 11) {
        QMMailProtocolJavaService.access$400(this.this$0, this.val$profile, this.val$protocolProfile.getProtocol(), "downloadMailText", paramInt2, paramString);
      }
      return;
    }
    Object localObject = new StringBuilder().append("downloadMailText token expire ").append(this.val$accountId).append(" refresh token ");
    if (this.val$account.getRefreshToken() == null) {}
    for (boolean bool = true;; bool = false)
    {
      QMLog.log(4, "QMMailProtocolJavaService", bool);
      if (!this.val$profile.isOauth) {
        break;
      }
      LoginManager.shareInstance().refreshGmailAccessToken(this.val$account.getId(), this.val$account.getRefreshToken(), new QMMailProtocolJavaService.27.1(this));
      return;
    }
  }
  
  public void onRetrieveMailSuccess(com.tencent.moai.mailsdk.model.Mail paramMail)
  {
    com.tencent.qqmail.model.qmdomain.Mail localMail = QMMailProtocolJavaService.access$700(this.this$0, this.val$accountId, this.val$folderId, paramMail, this.val$protocol, false);
    if (!StringExtention.isNullOrEmpty(paramMail.getCalendarContent()))
    {
      QMMailManager.sharedInstance().saveIcsEvent(this.val$accountId, paramMail.getRemoteId(), ICalendarResolver.parseICS(paramMail.getCalendarContent()));
      localMail.getStatus().setIcs(true);
    }
    for (;;)
    {
      if (this.val$callback != null) {
        this.val$callback.loadMailSuccess(this.val$mailId, localMail);
      }
      QMMailProtocolJavaService.access$300(this.this$0, this.val$profile.mailAddress, this.val$protocolProfile.getProtocol(), "downloadMailText");
      return;
      if (paramMail.getCalendar() != null)
      {
        QMMailManager.sharedInstance().saveIcsEvent(this.val$accountId, paramMail.getRemoteId(), QMMailProtocolJavaService.access$800(this.this$0, paramMail.getCalendar()));
        localMail.getStatus().setIcs(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.27
 * JD-Core Version:    0.7.0.1
 */