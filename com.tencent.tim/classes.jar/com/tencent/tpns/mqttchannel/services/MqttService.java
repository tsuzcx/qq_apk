package com.tencent.tpns.mqttchannel.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.support.annotation.Nullable;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.mqttchannel.core.b.b;
import com.tencent.tpns.mqttchannel.core.common.c.a;

public class MqttService
  extends Service
{
  private b a;
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    a.b("MqttService", "onBind: ");
    return this.a.a();
  }
  
  public void onCreate()
  {
    super.onCreate();
    try
    {
      if (!XGApiConfig.isEnableService(this))
      {
        a.b("MqttService", "MqttService onCreate  ");
        stopSelf();
        Process.killProcess(Process.myPid());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      a.b("MqttService", "unexpected for MqttService");
      boolean bool = Security.checkTpnsSecurityLibSo(this);
      a.b("MqttService", "MqttService onCreate load lib: " + bool);
      this.a = new b(this);
    }
  }
  
  public void onDestroy()
  {
    a.b("MqttService", "onDestroy: ");
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.services.MqttService
 * JD-Core Version:    0.7.0.1
 */