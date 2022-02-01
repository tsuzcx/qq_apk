package com.tencent.android.tpns.mqtt.logging;

import java.util.ResourceBundle;

public class LoggerFactory
{
  private static final String CLASS_NAME = "LoggerFactory";
  public static final String MQTT_CLIENT_MSG_CAT = "com.tencent.android.tpns.mqtt.internal.nls.logcat";
  private static String jsr47LoggerClassName = JSR47Logger.class.getName();
  private static String overrideloggerClassName = null;
  
  public static Logger getLogger(String paramString1, String paramString2)
  {
    return new MLogger();
  }
  
  private static Logger getLogger(String paramString1, ResourceBundle paramResourceBundle, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        paramString1 = Class.forName(paramString1);
        if (paramString1 != null) {}
        paramString1 = null;
      }
      catch (NoClassDefFoundError paramString1)
      {
        try
        {
          paramString1 = (Logger)paramString1.newInstance();
          paramString1.initialise(paramResourceBundle, paramString2, paramString3);
          return paramString1;
        }
        catch (SecurityException paramString1)
        {
          return null;
        }
        catch (ExceptionInInitializerError paramString1)
        {
          return null;
        }
        catch (InstantiationException paramString1)
        {
          return null;
        }
        catch (IllegalAccessException paramString1)
        {
          return null;
        }
        paramString1 = paramString1;
        return null;
      }
      catch (ClassNotFoundException paramString1)
      {
        return null;
      }
    }
  }
  
  public static String getLoggingProperty(String paramString)
  {
    return null;
  }
  
  public static void setLogger(String paramString)
  {
    overrideloggerClassName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.logging.LoggerFactory
 * JD-Core Version:    0.7.0.1
 */