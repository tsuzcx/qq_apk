package com.tencent.androidqqmail.tim;

import android.os.Bundle;
import com.tencent.qqmail.utilities.log.QMLog;
import mqq.observer.SSOAccountObserver;

class TimMailLoginManager$1$2$1
  extends SSOAccountObserver
{
  TimMailLoginManager$1$2$1(TimMailLoginManager.1.2 param2) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    QMLog.log(4, "TimMailLoginManager", String.format("SKEY ssoLogin onFailed: account[%s], ssoAccount[%s], action[%d], ret[%d]", new Object[] { this.this$1.this$0.val$account, paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    this.this$1.this$0.val$callback.onError(paramString, 4096, paramInt2);
  }
  
  public void onLoginSuccess(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    paramBundle = paramBundle.getString("uin");
    TimMailLoginManager.access$200(paramBundle, paramArrayOfByte);
    QMLog.log(4, "TimMailLoginManager", String.format("SKEY ssoLogin onGetTicketNoPasswd: account[%s], ssoAccount[%s], skey[%s], uin[%s]", new Object[] { this.this$1.this$0.val$account, paramString, TimMailLoginManager.access$000(paramArrayOfByte, 5), paramBundle }));
    TimMailLoginManager.GetTicketCallback localGetTicketCallback = this.this$1.this$0.val$callback;
    paramArrayOfByte = paramString;
    if (paramString.indexOf('@') < 0) {
      paramArrayOfByte = paramString + "@qq.com";
    }
    localGetTicketCallback.onSuccess(paramArrayOfByte, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.TimMailLoginManager.1.2.1
 * JD-Core Version:    0.7.0.1
 */