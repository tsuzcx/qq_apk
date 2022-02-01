package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.MailManager;
import com.tencent.moai.mailsdk.callback.IdleCallback;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.service.QMAckIntervalDetector;
import moai.oss.OssHelper;

class QMMailProtocolJavaService$33
  implements IdleCallback
{
  QMMailProtocolJavaService$33(QMMailProtocolJavaService paramQMMailProtocolJavaService, IdleCallback paramIdleCallback, Account paramAccount, QMAckIntervalDetector paramQMAckIntervalDetector, QMFolder paramQMFolder, com.tencent.moai.mailsdk.model.Profile paramProfile) {}
  
  public void onIdleDetectNew()
  {
    OssHelper.idleDetectNew(new Object[] { this.val$account.getProfile().getDomain() });
  }
  
  public void onIdleError(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 15)
    {
      QMLog.log(6, "QMMailProtocolJavaService", "idle error:" + paramString);
      this.val$ackIntervalDetector.updateAckInterval(false);
      this.val$ackIntervalDetector.resetAckIntervalStatus();
    }
    for (;;)
    {
      MailManager.getInstance().setIdleAckInterval(this.val$protocolProfile, this.val$ackIntervalDetector.getAckInterval());
      return;
      if (paramInt1 == 8) {
        LoginManager.shareInstance().refreshGmailAccessToken(this.val$account.getId(), this.val$account.getRefreshToken(), new QMMailProtocolJavaService.33.1(this));
      }
    }
  }
  
  public void onIdleSuccess()
  {
    QMLog.log(4, "QMMailProtocolJavaService", "idle success:" + this.val$account.getEmail());
    this.val$ackIntervalDetector.updateAckInterval(true);
    MailManager.getInstance().setIdleAckInterval(this.val$protocolProfile, this.val$ackIntervalDetector.getAckInterval());
  }
  
  public void onSvrCountChange()
  {
    if (this.val$callback != null) {
      this.val$callback.onSvrCountChange();
    }
    OssHelper.selectDetectNew(new Object[] { this.val$account.getProfile().getDomain() });
  }
  
  public void reportDomain()
  {
    QMMailProtocolJavaService.access$1000(this.this$0, this.val$account);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.33
 * JD-Core Version:    0.7.0.1
 */