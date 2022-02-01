package com.tencent.tpns.mqttchannel.api;

import android.content.Context;
import com.tencent.tpns.mqttchannel.core.a.c;
import org.json.JSONObject;

public class MqttChannel
  implements IMqttChannel
{
  private static MqttChannel a = null;
  private c b;
  
  private MqttChannel(Context paramContext)
  {
    this.b = new c(paramContext);
  }
  
  public static MqttChannel getInstance(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new MqttChannel(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public void bindAccount(String paramString, OnMqttCallback paramOnMqttCallback) {}
  
  public void getConnectState(OnMqttCallback paramOnMqttCallback)
  {
    this.b.getConnectState(paramOnMqttCallback);
  }
  
  public void ping(OnMqttCallback paramOnMqttCallback)
  {
    this.b.ping(paramOnMqttCallback);
  }
  
  public void sendPublishData(String paramString1, String paramString2, OnMqttCallback paramOnMqttCallback)
  {
    this.b.sendPublishData(paramString1, paramString2, paramOnMqttCallback);
  }
  
  public void sendRequest(String paramString, JSONObject paramJSONObject, OnMqttCallback paramOnMqttCallback)
  {
    this.b.sendRequest(paramString, paramJSONObject, paramOnMqttCallback);
  }
  
  public void startConnect(OnMqttCallback paramOnMqttCallback)
  {
    this.b.startConnect(paramOnMqttCallback);
  }
  
  public void stopConnect(OnMqttCallback paramOnMqttCallback)
  {
    this.b.stopConnect(paramOnMqttCallback);
  }
  
  public void subscrbie(String paramString, OnMqttCallback paramOnMqttCallback)
  {
    this.b.subscrbie(paramString, paramOnMqttCallback);
  }
  
  public void unBindAccount(OnMqttCallback paramOnMqttCallback) {}
  
  public void unSubscrbie(String paramString, OnMqttCallback paramOnMqttCallback)
  {
    this.b.unSubscrbie(paramString, paramOnMqttCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.api.MqttChannel
 * JD-Core Version:    0.7.0.1
 */