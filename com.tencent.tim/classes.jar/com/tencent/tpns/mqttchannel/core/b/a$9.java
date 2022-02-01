package com.tencent.tpns.mqttchannel.core.b;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.tpns.mqttchannel.core.common.b.b;

class a$9
  implements Runnable
{
  b a = null;
  b b = null;
  private ServiceConnection f = new a.9.1(this);
  private ServiceConnection g = new a.9.2(this);
  
  a$9(a parama, a.a parama1, String paramString) {}
  
  public void run()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(a.g(this.e).getPackageName());
      localIntent.setAction("com.tencent.tpns.mqttchannel.FEEDBACK");
      if (!a.g(this.e).bindService(localIntent, this.f, 1)) {
        com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", this.d + " bind mqttAsyncClientService not success");
      }
      if (a.r(this.e))
      {
        localIntent = new Intent(a.g(this.e), a.s(this.e));
        localIntent.setPackage(a.g(this.e).getPackageName());
        if (!a.g(this.e).bindService(localIntent, this.g, 1)) {
          com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", this.d + " [xg] bind XgmqttAsyncClientService not success");
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", this.d + " bind mqttAsyncClientService throwable: " + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.b.a.9
 * JD-Core Version:    0.7.0.1
 */