package com.tencent.androidqqmail.tim;

import android.os.Bundle;
import com.tencent.qqmail.utilities.log.QMLog;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.tools.util;

class TimMailLoginManager$1$1
  extends SSOAccountObserver
{
  TimMailLoginManager$1$1(TimMailLoginManager.1 param1, String paramString, int paramInt1, int paramInt2) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    QMLog.log(4, "TimMailLoginManager", String.format("A2 ssoGetTicketNoPasswd onFailed: account[%s], ssoAccount[%s], action[%d], ret[%d]", new Object[] { this.this$0.val$account, paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    this.this$0.val$callback.onError(paramString, 64, paramInt2);
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    paramArrayOfByte = util.buf_to_string(paramArrayOfByte);
    QMLog.log(4, "TimMailLoginManager", String.format("A2 ssoGetTicketNoPasswd onGetTicketNoPasswd: account[%s], ssoAccount[%s], a2[%s]", new Object[] { this.this$0.val$account, paramString, TimMailLoginManager.access$000(paramArrayOfByte, 10) }));
    TimMailLoginManager.access$100(this.val$uin, paramArrayOfByte);
    QMAppInterface.sharedInstance().ssoGetTicketNoPasswd(this.val$uin, 4096, this.val$dwSrcAppid, this.val$dwDstAppid, new TimMailLoginManager.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.TimMailLoginManager.1.1
 * JD-Core Version:    0.7.0.1
 */