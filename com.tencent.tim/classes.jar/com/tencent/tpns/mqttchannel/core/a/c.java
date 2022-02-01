package com.tencent.tpns.mqttchannel.core.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Process;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.IMqttChannel;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;
import com.tencent.tpns.mqttchannel.services.MqttService;
import org.json.JSONObject;

public class c
  implements IMqttChannel
{
  private Context a;
  private Intent b = null;
  private Boolean c = Boolean.valueOf(false);
  private volatile long d = a();
  private ServiceConnection e = null;
  
  public c(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = new Intent(this.a, MqttService.class);
  }
  
  private long a()
  {
    int i = Process.myPid();
    long l = System.currentTimeMillis();
    return (i % 1000 + l % 100000000000L * 1000L) * 1000L;
  }
  
  private void a(a parama, String paramString, OnMqttCallback paramOnMqttCallback)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("MqttChannelImpl", "action - doConnect, actionName:" + paramString);
    CommonWorkingThread.getInstance().execute(new c.1(this, parama, paramString, paramOnMqttCallback));
  }
  
  public void bindAccount(String paramString, OnMqttCallback paramOnMqttCallback) {}
  
  public void getConnectState(OnMqttCallback paramOnMqttCallback)
  {
    a(new c.9(this, paramOnMqttCallback), "getConnectState", paramOnMqttCallback);
  }
  
  public void ping(OnMqttCallback paramOnMqttCallback)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("MqttChannelImpl", "action - ping");
    try
    {
      this.a.startService(this.b);
      if (this.c.booleanValue()) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        this.e = new c.6(this);
        this.c = Boolean.valueOf(this.a.bindService(this.b, this.e, 1));
        a(new c.7(this, paramOnMqttCallback), "ping", paramOnMqttCallback);
        return;
        localThrowable1 = localThrowable1;
        com.tencent.tpns.mqttchannel.core.common.c.a.e("MqttChannelImpl", "MqttChannel startService failed, ex:" + localThrowable1);
        Util.stopWakeCpu();
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          com.tencent.tpns.mqttchannel.core.common.c.a.e("MqttChannelImpl", "MqttChannel bindService failed, ex:" + localThrowable2);
          Util.stopWakeCpu();
        }
      }
    }
  }
  
  public void sendPublishData(String paramString1, String paramString2, OnMqttCallback paramOnMqttCallback)
  {
    if (paramString2 == null)
    {
      if (paramOnMqttCallback != null) {
        paramOnMqttCallback.handleCallback(-101, "sendPublishData content not alow to null");
      }
      return;
    }
    long l = this.d + 1L;
    this.d = l;
    paramString1 = new com.tencent.tpns.mqttchannel.core.common.a.a(l, paramString1, paramString2);
    paramString1.a = 5;
    a(new c.11(this, paramString1, paramOnMqttCallback), "sendPublishData", paramOnMqttCallback);
  }
  
  public void sendRequest(String paramString, JSONObject paramJSONObject, OnMqttCallback paramOnMqttCallback)
  {
    if (paramJSONObject == null)
    {
      if (paramOnMqttCallback != null) {
        paramOnMqttCallback.handleCallback(-101, "sendRequest jsonParm not alow to null");
      }
      return;
    }
    long l = this.d + 1L;
    this.d = l;
    paramOnMqttCallback.requestId = l;
    paramString = new com.tencent.tpns.mqttchannel.core.common.a.a(l, paramString, paramJSONObject.toString());
    paramString.a = 6;
    a(new c.10(this, paramString, paramOnMqttCallback), "sendRequest", paramOnMqttCallback);
  }
  
  public void startConnect(OnMqttCallback paramOnMqttCallback)
  {
    try
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.a("MqttChannelImpl", "action - startConnect, start MqttService");
      this.a.startService(this.b);
      if (this.c.booleanValue()) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        this.e = new c.4(this);
        this.c = Boolean.valueOf(this.a.bindService(this.b, this.e, 1));
        a(new c.5(this, paramOnMqttCallback), "startConnect", paramOnMqttCallback);
        return;
        localThrowable1 = localThrowable1;
        com.tencent.tpns.mqttchannel.core.common.c.a.e("MqttChannelImpl", "MqttChannel startService failed, ex:" + localThrowable1);
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          com.tencent.tpns.mqttchannel.core.common.c.a.e("MqttChannelImpl", "MqttChannel bindService failed, ex:" + localThrowable2);
        }
      }
    }
  }
  
  public void stopConnect(OnMqttCallback paramOnMqttCallback)
  {
    a(new c.8(this, paramOnMqttCallback), "stopConnect", paramOnMqttCallback);
  }
  
  public void subscrbie(String paramString, OnMqttCallback paramOnMqttCallback)
  {
    long l = this.d + 1L;
    this.d = l;
    paramString = new com.tencent.tpns.mqttchannel.core.common.a.a(l, paramString, null);
    paramString.a = 1;
    a(new c.2(this, paramString, paramOnMqttCallback), "subscrbie", paramOnMqttCallback);
  }
  
  public void unBindAccount(OnMqttCallback paramOnMqttCallback) {}
  
  public void unSubscrbie(String paramString, OnMqttCallback paramOnMqttCallback)
  {
    long l = this.d + 1L;
    this.d = l;
    paramString = new com.tencent.tpns.mqttchannel.core.common.a.a(l, paramString, null);
    paramString.a = 3;
    a(new c.3(this, paramString, paramOnMqttCallback), "unSubscrbie", paramOnMqttCallback);
  }
  
  static abstract interface a
  {
    public abstract void a(com.tencent.tpns.mqttchannel.core.common.b.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.a.c
 * JD-Core Version:    0.7.0.1
 */