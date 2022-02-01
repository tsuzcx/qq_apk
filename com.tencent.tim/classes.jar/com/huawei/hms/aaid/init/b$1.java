package com.huawei.hms.aaid.init;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

class b$1
  implements ServiceConnection
{
  b$1(b paramb, Bundle paramBundle, Context paramContext) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    HMSLog.i("RemoteService", "remote service onConnected");
    b.a(this.c, new Messenger(paramIBinder));
    paramComponentName = Message.obtain();
    paramComponentName.setData(this.a);
    try
    {
      b.a(this.c).send(paramComponentName);
      HMSLog.i("RemoteService", "remote service unbindservice");
      this.b.unbindService(b.b(this.c));
      return;
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        HMSLog.i("RemoteService", "remote service message send failed");
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    HMSLog.i("RemoteService", "remote service onDisconnected");
    b.a(this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.aaid.init.b.1
 * JD-Core Version:    0.7.0.1
 */