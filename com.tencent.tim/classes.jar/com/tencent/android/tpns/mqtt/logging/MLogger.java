package com.tencent.android.tpns.mqtt.logging;

import java.util.ResourceBundle;

public class MLogger
  implements Logger
{
  private static final String TAG = "MLogger";
  
  private void log(String paramString) {}
  
  public void config(String paramString1, String paramString2, String paramString3)
  {
    log("config - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void config(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    log("config - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void config(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    log("config - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void dumpTrace() {}
  
  public void fine(String paramString1, String paramString2, String paramString3)
  {
    log("fine - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void fine(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    log("fine - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void fine(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    log("fine - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void finer(String paramString1, String paramString2, String paramString3)
  {
    log("finer - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void finer(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    log("finer - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void finer(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    log("finer - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void finest(String paramString1, String paramString2, String paramString3)
  {
    log("finest - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void finest(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    log("finest - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void finest(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    log("finest - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public String formatMessage(String paramString, Object[] paramArrayOfObject)
  {
    return "";
  }
  
  public void info(String paramString1, String paramString2, String paramString3)
  {
    log("info - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void info(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    log("info - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void info(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    log("info - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void initialise(ResourceBundle paramResourceBundle, String paramString1, String paramString2) {}
  
  public boolean isLoggable(int paramInt)
  {
    return false;
  }
  
  public void log(int paramInt, String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    log("log - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void setResourceName(String paramString) {}
  
  public void severe(String paramString1, String paramString2, String paramString3)
  {
    log("server - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void severe(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    log("server - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void severe(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    log("server - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void trace(int paramInt, String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    log("trace - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void warning(String paramString1, String paramString2, String paramString3)
  {
    log("warning - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void warning(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    log("warning - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
  
  public void warning(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    log("warning - sourceClass:" + paramString1 + ", sourceMethod:" + paramString2 + ", msg:" + paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.logging.MLogger
 * JD-Core Version:    0.7.0.1
 */