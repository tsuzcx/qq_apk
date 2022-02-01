package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.callback.LoginCallBack;
import com.tencent.moai.mailsdk.util.LoginUtility;
import com.tencent.moai.mailsdk.util.SPUtility;
import com.tencent.qqmail.model.mail.callback.LoginCallback;
import com.tencent.qqmail.protocol.ProtocolInfo;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.utilities.log.QMLog;

class QMMailProtocolJavaService$5
  implements LoginCallBack
{
  QMMailProtocolJavaService$5(QMMailProtocolJavaService paramQMMailProtocolJavaService, com.tencent.qqmail.protocol.Profile paramProfile, boolean paramBoolean, String paramString, LoginCallback paramLoginCallback, com.tencent.moai.mailsdk.model.Profile paramProfile1) {}
  
  public void onLoginError(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.log(4, "QMMailProtocolJavaService", "login resultCode:" + paramInt1 + " detailCode:" + paramInt2 + " detailMessage:" + paramString);
    int i = this.val$protocolProfile.getProtocol();
    if (paramInt2 == 200005)
    {
      SPUtility.setSmtpLoginError(this.val$profile.mailAddress);
      QMMailProtocolJavaService.access$000(this.this$0, this.val$profile, 1, "Login", false, LoginUtility.getProtocolLoginError(paramString), paramString);
    }
    for (;;)
    {
      paramInt1 = ProtocolResult.mapToProtocolResult(paramInt1);
      if (this.val$callback != null) {
        this.val$callback.onError(paramInt1, paramInt2, paramString);
      }
      return;
      if (this.val$verifySend) {
        QMMailProtocolJavaService.access$000(this.this$0, this.val$profile, i, "verify_login", false, LoginUtility.getProtocolLoginError(paramString), paramString);
      } else {
        QMMailProtocolJavaService.access$000(this.this$0, this.val$profile, i, "Login", false, LoginUtility.getProtocolLoginError(paramString), paramString);
      }
    }
  }
  
  public void onLoginSuccess(com.tencent.moai.mailsdk.model.Profile paramProfile)
  {
    QMLog.log(4, "QMMailProtocolJavaService", "login success:" + this.val$profile.mailAddress);
    ProtocolInfo[] arrayOfProtocolInfo;
    if (this.val$verifySend)
    {
      QMMailProtocolJavaService.access$000(this.this$0, this.val$profile, 1, "Login", true, 0, "");
      QMMailProtocolJavaService.access$000(this.this$0, this.val$profile, paramProfile.getProtocol(), "verify_login", true, 0, "");
      SPUtility.removeSmtpLoginError(this.val$profile.mailAddress);
      paramProfile = QMMailProtocolJavaService.access$100(this.this$0, paramProfile);
      arrayOfProtocolInfo = new ProtocolInfo[2];
      switch (paramProfile.protocolType)
      {
      }
    }
    for (;;)
    {
      if (this.val$callback != null) {
        this.val$callback.onSuccess(arrayOfProtocolInfo);
      }
      return;
      QMMailProtocolJavaService.access$000(this.this$0, this.val$profile, paramProfile.getProtocol(), "Login", true, 0, "");
      break;
      ProtocolInfo localProtocolInfo = new ProtocolInfo();
      localProtocolInfo.type_ = 2;
      localProtocolInfo.server_addr_ = paramProfile.smtpServer;
      localProtocolInfo.username_ = paramProfile.smtpName;
      localProtocolInfo.ssl_support_ = paramProfile.smtpUsingSSL;
      arrayOfProtocolInfo[0] = localProtocolInfo;
      QMMailProtocolJavaService.access$200(this.this$0, this.val$domain, 1, paramProfile.smtpName, paramProfile.smtpServer);
      localProtocolInfo = new ProtocolInfo();
      localProtocolInfo.type_ = paramProfile.protocolType;
      localProtocolInfo.server_addr_ = paramProfile.imapServer;
      localProtocolInfo.username_ = paramProfile.imapName;
      localProtocolInfo.ssl_support_ = paramProfile.imapUsingSSL;
      QMMailProtocolJavaService.access$200(this.this$0, this.val$domain, 2, paramProfile.imapName, paramProfile.imapServer);
      arrayOfProtocolInfo[1] = localProtocolInfo;
      continue;
      localProtocolInfo = new ProtocolInfo();
      localProtocolInfo.type_ = 2;
      localProtocolInfo.server_addr_ = paramProfile.smtpServer;
      localProtocolInfo.username_ = paramProfile.smtpName;
      localProtocolInfo.ssl_support_ = paramProfile.smtpUsingSSL;
      arrayOfProtocolInfo[0] = localProtocolInfo;
      QMMailProtocolJavaService.access$200(this.this$0, this.val$domain, 1, paramProfile.smtpName, paramProfile.smtpServer);
      localProtocolInfo = new ProtocolInfo();
      localProtocolInfo.type_ = paramProfile.protocolType;
      localProtocolInfo.server_addr_ = paramProfile.pop3Server;
      localProtocolInfo.username_ = paramProfile.pop3Name;
      localProtocolInfo.ssl_support_ = paramProfile.pop3UsingSSL;
      QMMailProtocolJavaService.access$200(this.this$0, this.val$domain, 3, paramProfile.pop3Name, paramProfile.pop3Server);
      arrayOfProtocolInfo[1] = localProtocolInfo;
      continue;
      localProtocolInfo = new ProtocolInfo();
      localProtocolInfo.type_ = 2;
      localProtocolInfo.server_addr_ = paramProfile.smtpServer;
      localProtocolInfo.username_ = paramProfile.smtpName;
      localProtocolInfo.ssl_support_ = paramProfile.smtpUsingSSL;
      arrayOfProtocolInfo[0] = localProtocolInfo;
      localProtocolInfo = new ProtocolInfo();
      localProtocolInfo.type_ = paramProfile.protocolType;
      localProtocolInfo.server_addr_ = paramProfile.activeSyncServer;
      localProtocolInfo.username_ = paramProfile.activeSyncName;
      localProtocolInfo.ssl_support_ = paramProfile.activeSyncUsingSSL;
      localProtocolInfo.domain_ = paramProfile.activeSyncDomain;
      localProtocolInfo.activesync_version_ = paramProfile.activeSyncVersion;
      localProtocolInfo.activesync_policykey_ = paramProfile.activeSyncPolicyKey;
      arrayOfProtocolInfo[1] = localProtocolInfo;
      continue;
      localProtocolInfo = new ProtocolInfo();
      localProtocolInfo.type_ = 2;
      localProtocolInfo.server_addr_ = paramProfile.smtpServer;
      localProtocolInfo.username_ = paramProfile.smtpName;
      localProtocolInfo.ssl_support_ = paramProfile.smtpUsingSSL;
      arrayOfProtocolInfo[0] = localProtocolInfo;
      localProtocolInfo = new ProtocolInfo();
      localProtocolInfo.type_ = paramProfile.protocolType;
      localProtocolInfo.server_addr_ = paramProfile.exchangeServer;
      localProtocolInfo.username_ = paramProfile.exchangeName;
      localProtocolInfo.ssl_support_ = paramProfile.exchangeUsingSSL;
      localProtocolInfo.http_realm_ = paramProfile.exchangeHttpLM;
      localProtocolInfo.server_domain_ = paramProfile.exchangeDomain;
      localProtocolInfo.exchange_version_ = paramProfile.exchangeVersion;
      arrayOfProtocolInfo[1] = localProtocolInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.5
 * JD-Core Version:    0.7.0.1
 */