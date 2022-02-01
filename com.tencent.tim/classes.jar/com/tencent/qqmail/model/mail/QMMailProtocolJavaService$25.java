package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.callback.SendMailCallBack;
import com.tencent.moai.mailsdk.model.Contact;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.util.LoginUtility;
import com.tencent.moai.mailsdk.util.SPUtility;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.trd.guava.Ints;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCancelError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolJavaService$25
  implements SendMailCallBack
{
  QMMailProtocolJavaService$25(QMMailProtocolJavaService paramQMMailProtocolJavaService, MailManagerDelegate paramMailManagerDelegate, QMProtocolRequest paramQMProtocolRequest, com.tencent.qqmail.protocol.Profile paramProfile, com.tencent.moai.mailsdk.model.Profile paramProfile1, Account paramAccount, ComposeMailUI paramComposeMailUI, Mail paramMail) {}
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = true;
    QMLog.log(6, "QMMailProtocolJavaService", "sendMail error : " + paramInt1 + ";" + paramInt2 + ";" + paramString);
    int i = ProtocolResult.mapToProtocolResult(paramInt1);
    if (paramInt1 == 4)
    {
      SPUtility.setSmtpLoginError(this.val$account.getEmail());
      localObject = new QMProtocolError(i, QMApplicationContext.sharedInstance().getString(2131697367));
    }
    for (;;)
    {
      if (this.val$callback != null)
      {
        this.val$callback.handleError(localObject);
        this.val$callback.handleComplete(null);
      }
      QMMailProtocolJavaService.access$400(this.this$0, this.val$profile, this.val$protocolProfile.getProtocol(), "sendMail", LoginUtility.getProtocolLoginError(paramString), paramString);
      return;
      if (paramInt1 == 8)
      {
        localObject = new StringBuilder().append("send mail error token expired ").append(this.val$account.getId()).append(" refresh token ");
        if (this.val$account.getRefreshToken() == null) {}
        for (;;)
        {
          QMLog.log(6, "QMMailProtocolJavaService", bool);
          localObject = new QMProtocolError(i);
          if (!this.val$protocolProfile.isOauth()) {
            break;
          }
          LoginManager.shareInstance().refreshGmailAccessToken(this.val$account.getId(), this.val$account.getRefreshToken(), new QMMailProtocolJavaService.25.1(this));
          return;
          bool = false;
        }
      }
      if (this.val$request.isAbort())
      {
        QMLog.log(4, "QMMailProtocolJavaService", "sendMail Abort");
        localObject = new QMCancelError(true);
      }
      else
      {
        if (paramInt1 != 5) {
          break;
        }
        paramInt1 = this.val$protocolProfile.getProtocol();
        if (!Ints.contains(new int[] { 2, 3 }, paramInt1)) {
          break;
        }
        if (QMNetworkUtils.isNetworkConnected())
        {
          QMLog.log(6, "QMMailProtocolJavaService", "sendMail fail setting error:" + this.val$profile.smtpServer);
          localObject = new QMProtocolError(i, QMApplicationContext.sharedInstance().getString(2131697375));
        }
        else
        {
          QMLog.log(6, "QMMailProtocolJavaService", "sendMail fail network error");
          localObject = new QMProtocolError(i);
        }
      }
    }
    if (this.val$protocolMail.getFrom() == null) {}
    for (Object localObject = "";; localObject = this.val$protocolMail.getFrom().getEmail())
    {
      localObject = SendMailHelper.getSendMailSettingErrorMsg(paramInt2, paramString, (String)localObject);
      QMLog.log(6, "QMMailProtocolJavaService", "sendMail fail error:" + (String)localObject);
      localObject = new QMProtocolError(i, (String)localObject);
      break;
    }
  }
  
  public void onProgress(long paramLong1, long paramLong2)
  {
    if (paramLong1 >= paramLong2) {
      this.val$request.setHasSendRequest(true);
    }
    if (this.val$callback != null) {
      this.val$callback.handleSendData(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    }
  }
  
  public void onSendBefore(Mail paramMail)
  {
    if (this.val$callback != null) {
      this.val$callback.handleBeforeSend(paramMail);
    }
  }
  
  public void onSendSuccess(Mail paramMail)
  {
    QMLog.log(4, "QMMailProtocolJavaService", "sendMail success");
    if (this.val$callback != null)
    {
      this.val$callback.handleSuccess(null, null);
      this.val$callback.handleComplete(null);
    }
    QMMailProtocolJavaService.access$300(this.this$0, this.val$profile.mailAddress, this.val$protocolProfile.getProtocol(), "sendMail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.25
 * JD-Core Version:    0.7.0.1
 */