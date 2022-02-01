package com.tencent.tpns.mqttchannel.api;

import android.content.Context;
import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;

public class MqttConfig
{
  public static long getAccessId(Context paramContext)
  {
    return MqttConfigImpl.getAccessId(paramContext);
  }
  
  public static String getAccessKey(Context paramContext)
  {
    return MqttConfigImpl.getAccessKey(paramContext);
  }
  
  public static int getKeepAliveInterval(Context paramContext)
  {
    return MqttConfigImpl.getKeepAliveInterval(paramContext);
  }
  
  public static void setAccessId(Context paramContext, long paramLong)
  {
    MqttConfigImpl.setAccessId(paramContext, paramLong);
  }
  
  public static void setAccessKey(Context paramContext, String paramString)
  {
    MqttConfigImpl.setAccessKey(paramContext, paramString);
  }
  
  public static void setForeignWeakAlarmMode(Context paramContext, boolean paramBoolean)
  {
    MqttConfigImpl.setForeignWeakAlarmMode(paramContext, paramBoolean);
  }
  
  public static void setKeepAliveInterval(Context paramContext, int paramInt)
  {
    MqttConfigImpl.setKeepAliveInterval(paramContext, paramInt);
  }
  
  public static void setServerAddr(Context paramContext, String paramString)
  {
    MqttConfigImpl.setServerAddr(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.api.MqttConfig
 * JD-Core Version:    0.7.0.1
 */