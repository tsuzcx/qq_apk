package com.tencent.moai.mailsdk;

import com.tencent.moai.mailsdk.callback.LoginCallBack;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.protocol.SMTPProtocolManager;
import com.tencent.moai.mailsdk.util.log.Logger;

class MailManager$1$2
  implements LoginCallBack
{
  MailManager$1$2(MailManager.1 param1, LoginCallBack paramLoginCallBack) {}
  
  public void onLoginError(int paramInt1, int paramInt2, String paramString)
  {
    Logger.log(6, "MailManager", "auth reception error:" + paramInt1 + "," + paramInt2 + "," + paramString);
    if (this.this$1.val$loginCallBack != null) {
      this.this$1.val$loginCallBack.onLoginError(paramInt1, 200004, paramString);
    }
  }
  
  public void onLoginSuccess(Profile paramProfile)
  {
    Logger.log(6, "MailManager", "auth reception success, next to auth send");
    if (this.this$1.val$verifySend) {
      SMTPProtocolManager.getInstance().login(paramProfile, this.val$sendLoginCallback);
    }
    while (this.this$1.val$loginCallBack == null) {
      return;
    }
    this.this$1.val$loginCallBack.onLoginSuccess(paramProfile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.MailManager.1.2
 * JD-Core Version:    0.7.0.1
 */