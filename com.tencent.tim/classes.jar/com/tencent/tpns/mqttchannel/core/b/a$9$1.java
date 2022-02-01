package com.tencent.tpns.mqttchannel.core.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.tpns.mqttchannel.core.common.b.b.a;

class a$9$1
  implements ServiceConnection
{
  a$9$1(a.9 param9) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.a.a = b.a.a(paramIBinder);
      if (this.a.a != null) {
        this.a.c.a(this.a.a);
      }
      return;
    }
    catch (Throwable paramComponentName)
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", this.a.d + "connectService Error: ", paramComponentName);
      return;
    }
    finally
    {
      a.g(this.a.e).unbindService(this);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    a.9.a(this.a, null);
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.b.a.9.1
 * JD-Core Version:    0.7.0.1
 */