package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.callback.LogoutCallBack;
import com.tencent.qqmail.model.mail.callback.LogoutCallback;
import com.tencent.qqmail.protocol.ProtocolResult;

class QMMailProtocolJavaService$6
  implements LogoutCallBack
{
  QMMailProtocolJavaService$6(QMMailProtocolJavaService paramQMMailProtocolJavaService, LogoutCallback paramLogoutCallback, com.tencent.qqmail.protocol.Profile paramProfile, com.tencent.moai.mailsdk.model.Profile paramProfile1) {}
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    paramInt1 = ProtocolResult.mapToProtocolResult(paramInt1);
    if (this.val$callback != null) {
      this.val$callback.onError(paramInt1, paramInt2, paramString);
    }
    QMMailProtocolJavaService.access$400(this.this$0, this.val$profile, this.val$protocolProfile.getProtocol(), "Logout", paramInt2, paramString);
  }
  
  public void onSuccess(com.tencent.moai.mailsdk.model.Profile paramProfile)
  {
    if (this.val$callback != null) {
      this.val$callback.onSuccess(this.val$profile);
    }
    QMMailProtocolJavaService.access$300(this.this$0, this.val$profile.mailAddress, paramProfile.getProtocol(), "Logout");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.6
 * JD-Core Version:    0.7.0.1
 */