package com.tencent.android.tpns.mqtt.logging;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.MemoryHandler;

public class JSR47Logger
  implements Logger
{
  private String catalogID = null;
  private java.util.logging.Logger julLogger = null;
  private ResourceBundle logMessageCatalog = null;
  private String loggerName = null;
  private String resourceName = null;
  private ResourceBundle traceMessageCatalog = null;
  
  protected static void dumpMemoryTrace47(java.util.logging.Logger arg0)
  {
    if (??? != null)
    {
      Handler[] arrayOfHandler = ???.getHandlers();
      int i = 0;
      while (i < arrayOfHandler.length)
      {
        if ((arrayOfHandler[i] instanceof MemoryHandler)) {
          synchronized (arrayOfHandler[i])
          {
            ((MemoryHandler)arrayOfHandler[i]).push();
            return;
          }
        }
        i += 1;
      }
      dumpMemoryTrace47(???.getParent());
    }
  }
  
  private String getResourceMessage(ResourceBundle paramResourceBundle, String paramString)
  {
    try
    {
      paramResourceBundle = paramResourceBundle.getString(paramString);
      return paramResourceBundle;
    }
    catch (MissingResourceException paramResourceBundle) {}
    return paramString;
  }
  
  private void logToJsr47(Level paramLevel, String paramString1, String paramString2, String paramString3, ResourceBundle paramResourceBundle, String paramString4, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    paramString3 = paramString4;
    if (paramString4.indexOf("=====") == -1) {
      paramString3 = MessageFormat.format(getResourceMessage(paramResourceBundle, paramString4), paramArrayOfObject);
    }
    paramLevel = new LogRecord(paramLevel, this.resourceName + ": " + paramString3);
    paramLevel.setSourceClassName(paramString1);
    paramLevel.setSourceMethodName(paramString2);
    paramLevel.setLoggerName(this.loggerName);
    if (paramThrowable != null) {
      paramLevel.setThrown(paramThrowable);
    }
    this.julLogger.log(paramLevel);
  }
  
  private Level mapJULLevel(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return Level.SEVERE;
    case 2: 
      return Level.WARNING;
    case 3: 
      return Level.INFO;
    case 4: 
      return Level.CONFIG;
    case 5: 
      return Level.FINE;
    case 6: 
      return Level.FINER;
    }
    return Level.FINEST;
  }
  
  public void config(String paramString1, String paramString2, String paramString3)
  {
    log(4, paramString1, paramString2, paramString3, null, null);
  }
  
  public void config(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    log(4, paramString1, paramString2, paramString3, paramArrayOfObject, null);
  }
  
  public void config(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    log(4, paramString1, paramString2, paramString3, paramArrayOfObject, paramThrowable);
  }
  
  public void dumpTrace()
  {
    dumpMemoryTrace47(this.julLogger);
  }
  
  public void fine(String paramString1, String paramString2, String paramString3)
  {
    trace(5, paramString1, paramString2, paramString3, null, null);
  }
  
  public void fine(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    trace(5, paramString1, paramString2, paramString3, paramArrayOfObject, null);
  }
  
  public void fine(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    trace(5, paramString1, paramString2, paramString3, paramArrayOfObject, paramThrowable);
  }
  
  public void finer(String paramString1, String paramString2, String paramString3)
  {
    trace(6, paramString1, paramString2, paramString3, null, null);
  }
  
  public void finer(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    trace(6, paramString1, paramString2, paramString3, paramArrayOfObject, null);
  }
  
  public void finer(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    trace(6, paramString1, paramString2, paramString3, paramArrayOfObject, paramThrowable);
  }
  
  public void finest(String paramString1, String paramString2, String paramString3)
  {
    trace(7, paramString1, paramString2, paramString3, null, null);
  }
  
  public void finest(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    trace(7, paramString1, paramString2, paramString3, paramArrayOfObject, null);
  }
  
  public void finest(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    trace(7, paramString1, paramString2, paramString3, paramArrayOfObject, paramThrowable);
  }
  
  public String formatMessage(String paramString, Object[] paramArrayOfObject)
  {
    try
    {
      paramArrayOfObject = this.logMessageCatalog.getString(paramString);
      return paramArrayOfObject;
    }
    catch (MissingResourceException paramArrayOfObject) {}
    return paramString;
  }
  
  public void info(String paramString1, String paramString2, String paramString3)
  {
    log(3, paramString1, paramString2, paramString3, null, null);
  }
  
  public void info(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    log(3, paramString1, paramString2, paramString3, paramArrayOfObject, null);
  }
  
  public void info(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    log(3, paramString1, paramString2, paramString3, paramArrayOfObject, paramThrowable);
  }
  
  public void initialise(ResourceBundle paramResourceBundle, String paramString1, String paramString2)
  {
    this.traceMessageCatalog = this.logMessageCatalog;
    this.resourceName = paramString2;
    this.loggerName = paramString1;
    this.julLogger = java.util.logging.Logger.getLogger(this.loggerName);
    this.logMessageCatalog = paramResourceBundle;
    this.traceMessageCatalog = paramResourceBundle;
    this.catalogID = this.logMessageCatalog.getString("0");
  }
  
  public boolean isLoggable(int paramInt)
  {
    Level localLevel = mapJULLevel(paramInt);
    return (localLevel != null) && (this.julLogger.isLoggable(localLevel));
  }
  
  public void log(int paramInt, String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    Level localLevel = mapJULLevel(paramInt);
    if ((localLevel != null) && (this.julLogger.isLoggable(localLevel))) {
      logToJsr47(localLevel, paramString1, paramString2, this.catalogID, this.logMessageCatalog, paramString3, paramArrayOfObject, paramThrowable);
    }
  }
  
  public void setResourceName(String paramString)
  {
    this.resourceName = paramString;
  }
  
  public void severe(String paramString1, String paramString2, String paramString3)
  {
    log(1, paramString1, paramString2, paramString3, null, null);
  }
  
  public void severe(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    log(1, paramString1, paramString2, paramString3, paramArrayOfObject, null);
  }
  
  public void severe(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    log(1, paramString1, paramString2, paramString3, paramArrayOfObject, paramThrowable);
  }
  
  public void trace(int paramInt, String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    Level localLevel = mapJULLevel(paramInt);
    if ((localLevel != null) && (this.julLogger.isLoggable(localLevel))) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        logToJsr47(localLevel, paramString1, paramString2, this.catalogID, this.traceMessageCatalog, paramString3, paramArrayOfObject, paramThrowable);
      }
      return;
    }
  }
  
  public void warning(String paramString1, String paramString2, String paramString3)
  {
    log(2, paramString1, paramString2, paramString3, null, null);
  }
  
  public void warning(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    log(2, paramString1, paramString2, paramString3, paramArrayOfObject, null);
  }
  
  public void warning(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    log(2, paramString1, paramString2, paramString3, paramArrayOfObject, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.logging.JSR47Logger
 * JD-Core Version:    0.7.0.1
 */