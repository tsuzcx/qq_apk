package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.util.SPUtility;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.protocol.Mail;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.trd.guava.Ints;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCancelError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolNativeService$21
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$21(QMMailProtocolNativeService paramQMMailProtocolNativeService, MailManagerDelegate paramMailManagerDelegate, QMProtocolRequest paramQMProtocolRequest, Account paramAccount, Profile paramProfile, ComposeMailUI paramComposeMailUI) {}
  
  public void onBeforeSendMail(Mail paramMail)
  {
    this.val$callback.handleBeforeSend(null);
  }
  
  public void onSendMail(Mail paramMail, ProtocolResult paramProtocolResult)
  {
    QMLog.log(4, "QMMailProtocolNativeService", "send mail result.error_code_:" + paramProtocolResult.error_code_ + ",result.detail_code_:" + paramProtocolResult.detail_code_ + ",result.detail_msg_:" + paramProtocolResult.detail_msg_ + ",result.result_:" + paramProtocolResult.result_);
    Object localObject;
    if (paramProtocolResult.error_code_ != 0)
    {
      localObject = "send mail fail:" + paramProtocolResult.error_code_ + ":" + paramProtocolResult.detail_code_ + ":" + paramProtocolResult.detail_msg_ + ":" + paramProtocolResult.result_;
      DataCollector.logDetailEvent("DetailEvent_Protocol_NewMail_Fail", this.val$account.getId(), 1L, (String)localObject);
    }
    if (paramProtocolResult.error_code_ == 0)
    {
      if (this.val$profile.protocolType == 4) {
        this.this$0.saveActiveSync(this.val$account.getId(), paramProtocolResult);
      }
      this.val$callback.handleSuccess(null, null);
      this.val$callback.handleComplete(null);
      paramMail = this.this$0;
      localObject = this.val$profile;
      if (paramProtocolResult.error_code_ != 0) {
        break label707;
      }
    }
    label705:
    label707:
    for (boolean bool = true;; bool = false)
    {
      QMMailProtocolNativeService.access$100(paramMail, (Profile)localObject, "sendMail", bool);
      return;
      if ((paramProtocolResult.error_code_ == 4) || (paramProtocolResult.error_code_ == 5001) || (paramProtocolResult.error_code_ == 5002) || (paramProtocolResult.error_code_ == 5003))
      {
        QMLog.log(6, "QMMailProtocolNativeService", "send mail error auth error");
        SPUtility.setSmtpLoginError(this.val$account.getEmail());
        paramProtocolResult.error_code_ = 4;
        paramMail = new QMProtocolError(paramProtocolResult.error_code_, QMApplicationContext.sharedInstance().getString(2131697367));
        this.val$callback.handleError(paramMail);
        this.val$callback.handleComplete(null);
        break;
      }
      if ((paramProtocolResult.error_code_ == -2) && (this.val$request.isAbort()))
      {
        QMLog.log(6, "QMMailProtocolNativeService", "send mail error abort error");
        paramMail = new QMCancelError(true);
        this.val$callback.handleError(paramMail);
        this.val$callback.handleComplete(null);
        break;
      }
      if (paramProtocolResult.error_code_ == 3001)
      {
        QMLog.log(6, "QMMailProtocolNativeService", "send mail error token expired");
        if (!this.val$profile.isOauth) {
          break;
        }
        LoginManager.shareInstance().refreshGmailAccessToken(this.val$account.getId(), this.val$account.getRefreshToken(), new QMMailProtocolNativeService.21.1(this));
        return;
      }
      if (paramProtocolResult.error_code_ == 3000)
      {
        QMLog.log(6, "QMMailProtocolNativeService", "send mail error token revoked");
        break;
      }
      int i = paramProtocolResult.error_code_;
      if (Ints.contains(new int[] { 2, 3, 8, -2, 5, 10, 15 }, i))
      {
        i = this.val$account.getProtocolType();
        if (Ints.contains(new int[] { 1, 0 }, i)) {
          if (QMNetworkUtils.isNetworkConnected())
          {
            QMLog.log(6, "QMMailProtocolNativeService", "sendMail fail setting error:" + this.val$profile.smtpServer);
            paramMail = new QMProtocolError(paramProtocolResult.error_code_, QMApplicationContext.sharedInstance().getString(2131697375));
          }
        }
      }
      for (;;)
      {
        if (this.val$callback == null) {
          break label705;
        }
        this.val$callback.handleError(paramMail);
        this.val$callback.handleComplete(null);
        break;
        QMLog.log(6, "QMMailProtocolNativeService", "sendMail fail network fail");
        paramMail = new QMProtocolError(paramProtocolResult.error_code_);
        continue;
        paramMail = SendMailHelper.getSendMailSettingErrorMsg(paramProtocolResult.detail_code_, paramProtocolResult.detail_msg_, paramMail.fromEmail);
        QMLog.log(6, "QMMailProtocolNativeService", "sendMail fail error:" + paramMail);
        paramMail = new QMProtocolError(paramProtocolResult.error_code_, paramMail);
      }
      break;
    }
  }
  
  public boolean onSendMailProgress(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2) {
      this.val$request.setHasSendRequest(true);
    }
    this.val$callback.handleSendData(Long.valueOf(paramInt1), Long.valueOf(paramInt2));
    return (this.val$request.isAbort()) && (paramInt1 < paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.21
 * JD-Core Version:    0.7.0.1
 */