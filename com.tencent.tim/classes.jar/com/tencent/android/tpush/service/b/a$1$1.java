package com.tencent.android.tpush.service.b;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.rpc.a;
import com.tencent.android.tpush.rpc.a.a;

class a$1$1
  implements ServiceConnection
{
  a$1$1(a.1 param1) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      a.1.a(this.a, a.a.a(paramIBinder));
      if (a.1.a(this.a) != null) {
        a.1.a(this.a).a(this.a.a.toURI(), a.1.b(this.a));
      }
      return;
    }
    catch (Throwable paramComponentName)
    {
      TLogger.e("SrvMessageManager", "SendBroadcastByRPC", paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    a.1.a(this.a, null);
    a.1.a(this.a, null);
    a.1.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.b.a.1.1
 * JD-Core Version:    0.7.0.1
 */