package com.tencent.tpns.mqttchannel.core.common.c;

import com.tencent.tpns.baseapi.base.logger.TBaseLogger;

public class a
{
  public static void a(String paramString1, String paramString2)
  {
    TBaseLogger.d("Mqtt-TPush - " + paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    TBaseLogger.e("Mqtt-TPush - " + paramString1, paramString2, paramThrowable);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    TBaseLogger.i("Mqtt-TPush - " + paramString1, paramString2);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    TBaseLogger.ii("Mqtt-TPush - " + paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    TBaseLogger.w("Mqtt-TPush - " + paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    TBaseLogger.e("Mqtt-TPush - " + paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.common.c.a
 * JD-Core Version:    0.7.0.1
 */