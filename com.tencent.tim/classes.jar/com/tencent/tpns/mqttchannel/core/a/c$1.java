package com.tencent.tpns.mqttchannel.core.a;

import android.content.Context;
import android.content.ServiceConnection;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;
import com.tencent.tpns.mqttchannel.core.common.c.a;

class c$1
  implements Runnable
{
  com.tencent.tpns.mqttchannel.core.common.b.c a = null;
  private ServiceConnection f = new c.1.1(this);
  
  c$1(c paramc, c.a parama, String paramString, OnMqttCallback paramOnMqttCallback) {}
  
  public void run()
  {
    try
    {
      boolean bool = c.a(this.e).bindService(c.b(this.e), this.f, 1);
      a.a("MqttChannelImpl", "actionName:" + this.c + " bind MqttService:" + bool);
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        a.a("MqttChannelImpl", this.c + " -> bindService", localThrowable);
      } while (this.d == null);
      this.d.handleCallback(-1, this.c + " error: bindService Error: " + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.a.c.1
 * JD-Core Version:    0.7.0.1
 */