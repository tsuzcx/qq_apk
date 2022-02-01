package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.LoginCallback;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolInfo;
import com.tencent.qqmail.utilities.qmnetwork.QMProxyUtil;

class QMMailProtocolService$1
  implements LoginCallback
{
  QMMailProtocolService$1(QMMailProtocolService paramQMMailProtocolService, Profile paramProfile, LoginCallback paramLoginCallback, boolean paramBoolean) {}
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    if (QMMailProtocolService.access$000(this.this$0, this.val$profile, paramInt1)) {
      this.this$0.login(this.val$profile, this.val$callback, this.val$verifySend);
    }
    while (this.val$callback == null) {
      return;
    }
    this.val$callback.onError(paramInt1, paramInt2, paramString);
  }
  
  public void onSuccess(ProtocolInfo[] paramArrayOfProtocolInfo)
  {
    QMProxyUtil.noNeedProxy(this.val$profile);
    if (this.val$callback != null) {
      this.val$callback.onSuccess(paramArrayOfProtocolInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolService.1
 * JD-Core Version:    0.7.0.1
 */