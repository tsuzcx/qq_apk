package com.tencent.tpns.mqttchannel.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;
import com.tencent.tpns.mqttchannel.core.common.b.c.a;
import com.tencent.tpns.mqttchannel.core.common.c.a;

class c$1$1
  implements ServiceConnection
{
  c$1$1(c.1 param1) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    a.a("MqttChannelImpl", "doConnect - onServiceConnected");
    this.a.a = c.a.a(paramIBinder);
    try
    {
      if (this.a.a != null) {
        CommonWorkingThread.getInstance().execute(new c.1.1.1(this));
      }
      return;
    }
    catch (Throwable paramComponentName)
    {
      a.a("MqttChannelImpl", this.a.c + " error:", paramComponentName);
      if (this.a.d != null) {
        this.a.d.handleCallback(-1, this.a.c + "onServiceConnected Error: " + paramComponentName);
      }
      return;
    }
    finally
    {
      c.a(this.a.e).unbindService(this);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.a = null;
    c.1.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.a.c.1.1
 * JD-Core Version:    0.7.0.1
 */