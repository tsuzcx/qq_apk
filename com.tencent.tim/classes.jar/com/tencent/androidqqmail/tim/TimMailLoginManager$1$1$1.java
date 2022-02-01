package com.tencent.androidqqmail.tim;

import android.os.Bundle;
import com.tencent.qqmail.utilities.log.QMLog;
import mqq.observer.SSOAccountObserver;

class TimMailLoginManager$1$1$1
  extends SSOAccountObserver
{
  TimMailLoginManager$1$1$1(TimMailLoginManager.1.1 param1) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    QMLog.log(4, "TimMailLoginManager", String.format("SKEY ssoGetTicketNoPasswd onFailed: account[%s], ssoAccount[%s], action[%d], ret[%d]", new Object[] { this.this$1.this$0.val$account, paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    this.this$1.this$0.val$callback.onError(paramString, 4096, paramInt2);
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    TimMailLoginManager.access$200(this.this$1.val$uin, paramArrayOfByte);
    QMLog.log(4, "TimMailLoginManager", String.format("SKEY ssoGetTicketNoPasswd onGetTicketNoPasswd: account[%s], ssoAccount[%s], skey[%s]", new Object[] { this.this$1.this$0.val$account, paramString, TimMailLoginManager.access$000(paramArrayOfByte, 5) }));
    paramBundle = this.this$1.this$0.val$callback;
    paramArrayOfByte = paramString;
    if (paramString.indexOf('@') < 0) {
      paramArrayOfByte = paramString + "@qq.com";
    }
    paramBundle.onSuccess(paramArrayOfByte, this.this$1.val$uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.TimMailLoginManager.1.1.1
 * JD-Core Version:    0.7.0.1
 */