package com.huawei.hms.support.api.push.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

class a$1
  implements ServiceConnection
{
  a$1(a parama, Bundle paramBundle, Context paramContext) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    HMSLog.i("RemoteService", "remote service onConnected");
    a.a(this.c, new Messenger(paramIBinder));
    paramComponentName = Message.obtain();
    paramComponentName.setData(this.a);
    try
    {
      a.a(this.c).send(paramComponentName);
      HMSLog.i("RemoteService", "remote service unbindservice");
      this.b.unbindService(a.b(this.c));
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
    a.a(this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.push.a.a.1
 * JD-Core Version:    0.7.0.1
 */