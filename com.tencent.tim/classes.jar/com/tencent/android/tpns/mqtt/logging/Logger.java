package com.tencent.android.tpns.mqtt.logging;

import java.util.ResourceBundle;

public abstract interface Logger
{
  public static final int CONFIG = 4;
  public static final int FINE = 5;
  public static final int FINER = 6;
  public static final int FINEST = 7;
  public static final int INFO = 3;
  public static final int SEVERE = 1;
  public static final int WARNING = 2;
  
  public abstract void config(String paramString1, String paramString2, String paramString3);
  
  public abstract void config(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject);
  
  public abstract void config(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable);
  
  public abstract void dumpTrace();
  
  public abstract void fine(String paramString1, String paramString2, String paramString3);
  
  public abstract void fine(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject);
  
  public abstract void fine(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable);
  
  public abstract void finer(String paramString1, String paramString2, String paramString3);
  
  public abstract void finer(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject);
  
  public abstract void finer(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable);
  
  public abstract void finest(String paramString1, String paramString2, String paramString3);
  
  public abstract void finest(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject);
  
  public abstract void finest(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable);
  
  public abstract String formatMessage(String paramString, Object[] paramArrayOfObject);
  
  public abstract void info(String paramString1, String paramString2, String paramString3);
  
  public abstract void info(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject);
  
  public abstract void info(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable);
  
  public abstract void initialise(ResourceBundle paramResourceBundle, String paramString1, String paramString2);
  
  public abstract boolean isLoggable(int paramInt);
  
  public abstract void log(int paramInt, String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable);
  
  public abstract void setResourceName(String paramString);
  
  public abstract void severe(String paramString1, String paramString2, String paramString3);
  
  public abstract void severe(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject);
  
  public abstract void severe(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable);
  
  public abstract void trace(int paramInt, String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable);
  
  public abstract void warning(String paramString1, String paramString2, String paramString3);
  
  public abstract void warning(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject);
  
  public abstract void warning(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.logging.Logger
 * JD-Core Version:    0.7.0.1
 */