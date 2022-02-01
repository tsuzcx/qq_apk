package com.tencent.androidqqmail.tim;

import android.os.Bundle;
import com.tencent.qqmail.utilities.log.QMLog;
import mqq.app.AppRuntime;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.tools.util;

class TimMailLoginManager$1$2
  extends SSOAccountObserver
{
  TimMailLoginManager$1$2(TimMailLoginManager.1 param1) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    QMLog.log(4, "TimMailLoginManager", String.format("A2 ssoLogin onFailed: account[%s], ssoAccount[%s], action[%d], ret[%d]", new Object[] { this.this$0.val$account, paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    this.this$0.val$callback.onError(paramString, 64, paramInt2);
  }
  
  public void onLoginSuccess(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    paramArrayOfByte = util.buf_to_string(paramArrayOfByte);
    paramBundle = paramBundle.getString("uin");
    QMLog.log(4, "TimMailLoginManager", String.format("A2 ssoLogin onLoginSuccess: account[%s], ssoAccount[%s], a2[%s], uin[%s]", new Object[] { this.this$0.val$account, paramString, TimMailLoginManager.access$000(paramArrayOfByte, 10), paramBundle }));
    TimMailLoginManager.access$100(paramBundle, paramArrayOfByte);
    this.this$0.val$pluginRuntime.ssoLogin(paramString, this.this$0.val$fPwd, 4096, 756044602L, new TimMailLoginManager.1.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.TimMailLoginManager.1.2
 * JD-Core Version:    0.7.0.1
 */