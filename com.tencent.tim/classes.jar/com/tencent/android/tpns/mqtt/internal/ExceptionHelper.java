package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttSecurityException;

public class ExceptionHelper
{
  public static MqttException createMqttException(int paramInt)
  {
    if ((paramInt == 4) || (paramInt == 5)) {
      return new MqttSecurityException(paramInt);
    }
    return new MqttException(paramInt);
  }
  
  public static MqttException createMqttException(Throwable paramThrowable)
  {
    if (paramThrowable.getClass().getName().equals("java.security.GeneralSecurityException")) {
      return new MqttSecurityException(paramThrowable);
    }
    return new MqttException(paramThrowable);
  }
  
  public static boolean isClassAvailable(String paramString)
  {
    try
    {
      Class.forName(paramString);
      return true;
    }
    catch (ClassNotFoundException paramString) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.ExceptionHelper
 * JD-Core Version:    0.7.0.1
 */