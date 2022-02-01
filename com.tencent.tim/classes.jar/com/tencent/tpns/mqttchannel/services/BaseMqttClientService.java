package com.tencent.tpns.mqttchannel.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.tencent.tpns.mqttchannel.core.a.a;
import com.tencent.tpns.mqttchannel.core.common.b.b.a;

public abstract class BaseMqttClientService
  extends Service
{
  private b.a a;
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    return this.a;
  }
  
  public abstract void onConnectComplete(boolean paramBoolean);
  
  public abstract void onConnectionLost();
  
  public void onCreate()
  {
    super.onCreate();
    this.a = new a(this);
  }
  
  public void onDestroy()
  {
    this.a = null;
    super.onDestroy();
  }
  
  public abstract void onHeartBeat();
  
  public abstract void onMessageArrived(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.services.BaseMqttClientService
 * JD-Core Version:    0.7.0.1
 */