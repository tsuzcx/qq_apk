package com.tencent.qqmail.account.model;

import com.tencent.moai.mailsdk.util.LoginUtility;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.model.mail.callback.LoginCallback;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolInfo;
import com.tencent.qqmail.provider.MailServiceProvider;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.qmnetwork.login.QMLoginError;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class MailAccount$2
  implements LoginCallback
{
  MailAccount$2(MailAccount paramMailAccount, long paramLong, MailServiceProvider paramMailServiceProvider, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6) {}
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.log(5, "MailAccount", "login onError, errorCode: " + paramInt1 + ", detailCode: " + paramInt2 + ", detailMsg: " + paramString);
    QMLogStream.logWithoutUma(-40013, MailAccount.access$000(this.this$0) + ":" + paramInt1 + ":" + paramInt2 + ":" + paramString, "Event_Error");
    if (("ActiveSync".equals(this.val$provider.getDefaultRecvProtocol())) && (paramInt1 != 4))
    {
      if (paramInt2 == 177)
      {
        QMLog.log(4, "MailAccount", "ac protocol exceed can login device count:" + this.val$email);
        LoginManager.shareInstance().triggerLoginError(this.this$0.getId(), this.val$currentRequestId, new QMLoginError(0, paramInt1, paramInt2, QMApplicationContext.sharedInstance().getString(2131689508)), this.val$email, false, false, MailAccount.access$000(this.this$0).protocolType);
        return;
      }
      QMLog.log(4, "MailAccount", "go try exchange:" + this.val$email);
      this.val$provider.setDefaultRecvProtocol("Exchange");
      this.this$0.login(this.val$currentRequestId, this.val$email, this.val$receiveUsername, this.val$receivePassword, this.val$sendUserName, this.val$sendPassword, this.val$provider, this.val$verifySend, "", "", "", 0L, "", false);
      return;
    }
    if (MailAccount.access$300(this.this$0, paramInt1))
    {
      QMLog.log(4, "MailAccount", "login network err:" + paramInt1 + "," + paramString);
      LoginManager.shareInstance().triggerLoginError(this.this$0.getId(), this.val$currentRequestId, new QMLoginError(0, paramInt1, paramInt2, QMApplicationContext.sharedInstance().getString(2131695956)), this.val$email, false, false, MailAccount.access$000(this.this$0).protocolType);
      return;
    }
    if (MailAccount.access$400(this.this$0, paramInt1))
    {
      QMLog.log(4, "MailAccount", "login network err:" + paramInt1 + "," + paramString);
      LoginManager.shareInstance().triggerLoginError(this.this$0.getId(), this.val$currentRequestId, new QMLoginError(0, paramInt1, paramInt2, QMApplicationContext.sharedInstance().getString(2131697354)), this.val$email, false, false, MailAccount.access$000(this.this$0).protocolType);
      return;
    }
    String str3;
    String str2;
    String str1;
    if (!StringExtention.isNullOrEmpty(paramString))
    {
      str3 = paramString.toLowerCase();
      str2 = String.format(QMApplicationContext.sharedInstance().getString(2131689493), new Object[] { this.val$protocol });
      str1 = "";
      if (paramInt2 == 200005)
      {
        str1 = QMApplicationContext.sharedInstance().getString(2131689746);
        paramString = String.format(QMApplicationContext.sharedInstance().getString(2131689491), new Object[] { str1 });
        switch (LoginUtility.getProtocolLoginError(str3))
        {
        case 4: 
        default: 
          if (EmailDomainDefine.hasHelpPage(MailAccount.access$000(this.this$0).domain)) {
            paramInt1 = 5002;
          }
          break;
        }
      }
    }
    for (;;)
    {
      QMLog.log(4, "MailAccount", "login protocol err:" + paramInt1 + "," + paramInt2 + "," + str3);
      LoginManager.shareInstance().triggerLoginError(this.this$0.getId(), this.val$currentRequestId, new QMLoginError(0, paramInt1, paramInt2, paramString), this.val$email, false, false, MailAccount.access$000(this.this$0).protocolType);
      return;
      paramString = str2;
      if (paramInt2 != 200004) {
        break;
      }
      str1 = this.val$protocol;
      paramString = str2;
      break;
      paramString = String.format(QMApplicationContext.sharedInstance().getString(2131689492), new Object[] { this.val$protocol });
      paramInt1 = 1;
      continue;
      paramString = QMApplicationContext.sharedInstance().getString(2131695515);
      paramInt1 = 5003;
      continue;
      paramString = String.format(QMApplicationContext.sharedInstance().getString(2131697362), new Object[] { str1 });
      paramInt1 = 5;
      continue;
      if (this.this$0.getProfile().isOauth)
      {
        paramString = QMApplicationContext.sharedInstance().getString(2131689494);
        paramInt1 = 5003;
        continue;
        paramString = String.format(QMApplicationContext.sharedInstance().getString(2131689493), new Object[] { this.val$protocol });
        if (paramInt1 == 4)
        {
          paramString = QMApplicationContext.sharedInstance().getString(2131689490);
          paramInt1 = 4;
        }
        for (;;)
        {
          if (EmailDomainDefine.hasHelpPage(MailAccount.access$000(this.this$0).domain)) {
            paramInt1 = 5002;
          }
          LoginManager.shareInstance().triggerLoginError(this.this$0.getId(), this.val$currentRequestId, new QMLoginError(0, paramInt1, paramInt2, paramString), this.val$email, false, false, MailAccount.access$000(this.this$0).protocolType);
          return;
          if (paramInt1 == 5001)
          {
            paramString = String.format(QMApplicationContext.sharedInstance().getString(2131689492), new Object[] { this.val$protocol });
            paramInt1 = 1;
          }
          else if (this.this$0.getProfile().isOauth)
          {
            paramString = QMApplicationContext.sharedInstance().getString(2131694368);
          }
        }
      }
    }
  }
  
  public void onSuccess(ProtocolInfo[] paramArrayOfProtocolInfo)
  {
    QMLog.log(4, "MailAccount", "success");
    MailAccount.access$100(this.this$0, MailAccount.access$000(this.this$0), paramArrayOfProtocolInfo);
    MailAccount.access$200(this.this$0);
    LoginManager.shareInstance().triggerLoginSuccess(this.this$0.getId(), this.val$currentRequestId, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.model.MailAccount.2
 * JD-Core Version:    0.7.0.1
 */