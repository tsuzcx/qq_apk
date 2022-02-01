package com.tencent.tpns.mqttchannel.api;

import android.content.Context;
import com.tencent.tpns.mqttchannel.core.common.c.b;

public class MqttTools
{
  public static String getMqttSdkVersion()
  {
    return "1.2.7.3";
  }
  
  public static boolean isAesPushMsgTopic(Context paramContext, String paramString)
  {
    return b.l(paramContext, paramString);
  }
  
  public static boolean isGZipAesPushMsgTopic(Context paramContext, String paramString)
  {
    return b.p(paramContext, paramString);
  }
  
  public static boolean isGZipPushMsgTopic(Context paramContext, String paramString)
  {
    return b.n(paramContext, paramString);
  }
  
  public static boolean isPushMsgTopic(Context paramContext, String paramString)
  {
    return b.j(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.api.MqttTools
 * JD-Core Version:    0.7.0.1
 */