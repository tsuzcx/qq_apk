package com.tencent.android.tpush.service.b;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.MessageManager;
import com.tencent.android.tpush.rpc.c;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.util.Util;

class a$1
  implements Runnable
{
  private com.tencent.android.tpush.rpc.a c;
  private c d = new c();
  private ServiceConnection e = new a.1.1(this);
  
  a$1(a parama, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      this.a.setAction(this.a.getPackage() + ".XGVIP_PUSH_ACTION");
      this.d.a(this.e);
      if (!b.e().bindService(this.a, this.e, 1))
      {
        TLogger.e("SrvMessageManager", "Failed Send AIDL" + this.a + " failed  msgid = " + this.a.getLongExtra("msgId", -1L));
        MessageManager.getInstance().addCachedMsgIntentByPkgName(b.e(), this.a.getPackage(), this.a);
        ServiceStat.reportErrCode(b.e(), -104, "bind aidl remote service return false", 0L, "inner");
        return;
      }
      TLogger.d("SrvMessageManager", "Succeed Send AIDL" + this.a + " success  msgid = " + this.a.getLongExtra("msgId", -1L));
      this.b.a(b.e(), this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("SrvMessageManager", "SendBroadcastByRPC -> bindService", localThrowable);
      MessageManager.getInstance().addCachedMsgIntentByPkgName(b.e(), this.a.getPackage(), this.a);
      ServiceStat.reportErrCode(b.e(), -104, "bind aidl remote service err:" + Util.getThrowableToString(localThrowable), 0L, "inner");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.b.a.1
 * JD-Core Version:    0.7.0.1
 */