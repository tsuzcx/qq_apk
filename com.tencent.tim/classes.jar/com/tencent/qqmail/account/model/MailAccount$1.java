package com.tencent.qqmail.account.model;

import com.tencent.moai.mailsdk.util.LoginUtility;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.model.mail.callback.LoginCallback;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolInfo;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.utilities.qmnetwork.login.QMLoginError;

class MailAccount$1
  implements LoginCallback
{
  MailAccount$1(MailAccount paramMailAccount, Profile paramProfile, long paramLong, int paramInt) {}
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    String str;
    if (LoginUtility.isProtocolLoginError(paramInt2))
    {
      str = "";
      if (paramInt2 == 200005) {
        str = "发件服务器";
      }
      if (paramInt2 == 200004) {
        str = "收件服务器";
      }
      if (LoginUtility.getProtocolLoginError(paramString) == 3)
      {
        paramString = String.format(QMApplicationContext.sharedInstance().getString(2131697362), new Object[] { str });
        paramInt1 = 5;
      }
    }
    for (paramString = new QMLoginError(0, paramInt1, paramInt2, paramString);; paramString = new QMLoginError(0, paramInt1, paramInt2, ProtocolResult.getErrorDesp(paramInt1)))
    {
      LoginManager.shareInstance().triggerLoginError(this.this$0.getId(), this.val$currentLoginId, paramString, this.val$profile.mailAddress, false, false, this.val$protocolType);
      return;
      paramString = String.format(QMApplicationContext.sharedInstance().getString(2131689491), new Object[] { str });
      break;
    }
  }
  
  public void onSuccess(ProtocolInfo[] paramArrayOfProtocolInfo)
  {
    MailAccount.access$002(this.this$0, this.val$profile);
    MailAccount.access$100(this.this$0, MailAccount.access$000(this.this$0), paramArrayOfProtocolInfo);
    MailAccount.access$200(this.this$0);
    LoginManager.shareInstance().triggerLoginSuccess(this.this$0.getId(), this.val$currentLoginId, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.model.MailAccount.1
 * JD-Core Version:    0.7.0.1
 */