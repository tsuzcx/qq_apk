package com.tencent.tpns.mqttchannel.core.common.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.mqttchannel.core.common.c.a;

public class MqttConfigImpl
{
  public static final int DEFAULT_KEEP_ALIVE_INTERVAL = 285;
  private static Integer a = null;
  
  private static boolean a(Context paramContext)
  {
    int i = PushPreferences.getInt(paramContext, "com.tencent.android.tpush.enable_FOREIGIN_XG_WEAK_ALARM," + paramContext.getPackageName(), -1);
    int j = i;
    if (i == -1)
    {
      paramContext = CommonHelper.getMetaData(paramContext, "XG_WEAK_ALARM", null);
      j = i;
      if (paramContext != null)
      {
        if (paramContext.toString().equals("true")) {
          i = 1;
        }
        a.e("MqttConfigImpl", "getMetaData key:" + i);
        j = i;
      }
    }
    return j == 1;
  }
  
  public static long getAccessId(Context paramContext)
  {
    return XGApiConfig.getAccessId(paramContext);
  }
  
  public static String getAccessKey(Context paramContext)
  {
    return XGApiConfig.getAccessKey(paramContext);
  }
  
  public static int getKeepAliveInterval(Context paramContext)
  {
    try
    {
      int i = CloudManager.getInstance(paramContext).getInterval() / 1000;
      if (i >= 60) {
        a = Integer.valueOf(i);
      }
      if (a == null)
      {
        if (a(paramContext))
        {
          a.b("MqttConfigImpl", "isForeignWeakAlarmMode KeepAlive set to : 3600");
          return 3600;
        }
        a = Integer.valueOf(PushPreferences.getInt(paramContext, "MQTT_KEEPALIVE_INTERVAL", 0));
        if (a.intValue() == 0) {
          a = Integer.valueOf(285);
        }
      }
      i = a.intValue();
      return i;
    }
    catch (Throwable paramContext) {}
    return 285;
  }
  
  public static String getServerAddr(Context paramContext)
  {
    String str = PushPreferences.getString(paramContext, "MQTT_HOST", null);
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = "tcp://127.0.0.1:1883";
    }
    return paramContext;
  }
  
  public static void setAccessId(Context paramContext, long paramLong)
  {
    XGApiConfig.setAccessId(paramContext, paramLong);
  }
  
  public static void setAccessKey(Context paramContext, String paramString)
  {
    XGApiConfig.setAccessKey(paramContext, paramString);
  }
  
  public static void setForeignWeakAlarmMode(Context paramContext, boolean paramBoolean)
  {
    String str = "com.tencent.android.tpush.enable_FOREIGIN_XG_WEAK_ALARM," + paramContext.getPackageName();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      PushPreferences.putInt(paramContext, str, i);
      return;
    }
  }
  
  public static boolean setKeepAliveInterval(Context paramContext, int paramInt)
  {
    if ((paramInt >= 10) && (paramInt <= 36000))
    {
      a = Integer.valueOf(paramInt);
      PushPreferences.putInt(paramContext, "MQTT_KEEPALIVE_INTERVAL", paramInt);
      return true;
    }
    return false;
  }
  
  public static void setServerAddr(Context paramContext, String paramString)
  {
    PushPreferences.putString(paramContext, "MQTT_HOST", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl
 * JD-Core Version:    0.7.0.1
 */