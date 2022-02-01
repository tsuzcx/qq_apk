package com.tencent.tbs.logger;

import android.content.Context;
import android.os.Environment;
import com.tencent.tbs.logger.file.FilePrinter;
import com.tencent.tbs.logger.file.backup.FileSizeBackupStrategy;
import com.tencent.tbs.logger.file.clean.FileLastModifiedCleanStrategy;
import com.tencent.tbs.logger.file.naming.DateLogNameGenerator;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class TBSLogger
{
  public static final String DEFAULT_TBS_LOG_KEY_OF_KEY = "tbslog.txt";
  private static volatile Boolean sInitialized = Boolean.valueOf(false);
  private static LogLevel sLogLevel = LogLevel.ALL;
  private static boolean sLogOpen;
  private static String sLogPath = "";
  private static List<LogPrinter> sLogPrinters;
  private static TBSLoggerInternal sLogger;
  
  public static void addPrinter(LogPrinter paramLogPrinter)
  {
    if (!checkInitialize()) {}
    while ((paramLogPrinter == null) || (sLogPrinters.contains(paramLogPrinter))) {
      return;
    }
    sLogPrinters.add(paramLogPrinter);
  }
  
  private static boolean checkInitialize()
  {
    if (!sInitialized.booleanValue()) {
      new Throwable("TBSLogger has not been initialized, please call TBSLogger.initialize() first.").printStackTrace();
    }
    return sInitialized.booleanValue();
  }
  
  public static void close()
  {
    if (!checkInitialize()) {
      return;
    }
    Iterator localIterator = sLogPrinters.iterator();
    while (localIterator.hasNext())
    {
      LogPrinter localLogPrinter = (LogPrinter)localIterator.next();
      localLogPrinter.close();
      removePrinter(localLogPrinter);
    }
    sLogger = null;
    sLogPrinters = null;
    sLogOpen = false;
    sInitialized = Boolean.valueOf(false);
  }
  
  public static LogPrinter createFilePrinter(Context paramContext, long paramLong1, long paramLong2)
  {
    return new FilePrinter(paramContext, true, true, new DateLogNameGenerator(), new FileLastModifiedCleanStrategy(paramLong1), new FileSizeBackupStrategy(paramLong2));
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (!checkInitialize()) {
      return;
    }
    sLogger.setTagName(paramString1);
    sLogger.d(paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!checkInitialize()) {
      return;
    }
    sLogger.setTagName(paramString1);
    sLogger.d(paramString2, paramVarArgs);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (!checkInitialize()) {
      return;
    }
    sLogger.setTagName(paramString1);
    sLogger.e(paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!checkInitialize()) {
      return;
    }
    sLogger.setTagName(paramString1);
    sLogger.e(paramString2, paramVarArgs);
  }
  
  public static String getLogPath()
  {
    return sLogPath;
  }
  
  public static Logger getLogger(Class<?> paramClass)
  {
    if (paramClass != null) {
      try
      {
        paramClass = getLogger(paramClass.getSimpleName());
        return paramClass;
      }
      finally {}
    }
    new Throwable("class not null!").printStackTrace();
    return null;
  }
  
  public static Logger getLogger(String paramString)
  {
    return new TBSLoggerInternal(paramString, null);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (!checkInitialize()) {
      return;
    }
    sLogger.setTagName(paramString1);
    sLogger.i(paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!checkInitialize()) {
      return;
    }
    sLogger.setTagName(paramString1);
    sLogger.i(paramString2, paramVarArgs);
  }
  
  public static void initialize(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    initialize(paramContext, paramString, paramLong1, paramLong2, false);
  }
  
  public static void initialize(Context paramContext, String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    File localFile = null;
    try
    {
      if (!sInitialized.booleanValue())
      {
        sLogger = new TBSLoggerInternal(null);
        sLogPrinters = new ArrayList();
        sLogPrinters.add(createFilePrinter(paramContext, paramLong1, paramLong2));
        if (paramBoolean) {
          sLogPrinters.add(new DefaultPrinter());
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
          localFile = paramContext.getExternalFilesDir(paramString);
        }
        if (localFile != null) {}
        for (sLogPath = localFile.getAbsolutePath();; sLogPath = paramContext.getFilesDir() + File.separator + paramString)
        {
          sLogLevel = LogLevel.ALL;
          sLogOpen = true;
          sInitialized = Boolean.valueOf(true);
          return;
        }
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void log(int paramInt, String paramString1, String paramString2)
  {
    if (!checkInitialize()) {
      return;
    }
    sLogger.setTagName(paramString1);
    sLogger.log(paramInt, paramString2);
  }
  
  public static void log(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!checkInitialize()) {
      return;
    }
    sLogger.setTagName(paramString1);
    sLogger.log(paramInt, paramString2, paramVarArgs);
  }
  
  public static void logSwitch(boolean paramBoolean)
  {
    if (!checkInitialize()) {
      return;
    }
    sLogOpen = paramBoolean;
  }
  
  public static void removePrinter(LogPrinter paramLogPrinter)
  {
    if (!checkInitialize()) {}
    while (paramLogPrinter == null) {
      return;
    }
    sLogPrinters.remove(paramLogPrinter);
  }
  
  public static void setLogLevel(LogLevel paramLogLevel)
  {
    if (!checkInitialize()) {
      return;
    }
    sLogLevel = paramLogLevel;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (!checkInitialize()) {
      return;
    }
    sLogger.setTagName(paramString1);
    sLogger.v(paramString2);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!checkInitialize()) {
      return;
    }
    sLogger.setTagName(paramString1);
    sLogger.v(paramString2, paramVarArgs);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (!checkInitialize()) {
      return;
    }
    sLogger.setTagName(paramString1);
    sLogger.w(paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!checkInitialize()) {
      return;
    }
    sLogger.setTagName(paramString1);
    sLogger.w(paramString2, paramVarArgs);
  }
  
  static class TBSLoggerInternal
    implements Logger
  {
    private String mTagName = getClass().getName();
    
    private TBSLoggerInternal() {}
    
    private TBSLoggerInternal(String paramString)
    {
      this.mTagName = paramString;
    }
    
    private String format(String paramString, Object... paramVarArgs)
    {
      paramString = formatMessage(paramString, paramVarArgs);
      Throwable localThrowable = getThrowableToLog(paramVarArgs);
      if ((paramString == null) || (paramString.length() == 0)) {
        return "";
      }
      paramVarArgs = new StringBuilder().append(paramString);
      if (localThrowable == null) {}
      for (paramString = "";; paramString = "\n" + Formatter.formatThrowable(localThrowable)) {
        return paramString;
      }
    }
    
    private String formatMessage(String paramString, Object... paramVarArgs)
    {
      String str = paramString;
      if (paramVarArgs != null)
      {
        str = paramString;
        if (paramVarArgs.length == 0) {}
      }
      try
      {
        str = String.format(Locale.US, paramString, paramVarArgs);
        return str;
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return paramString;
    }
    
    private Throwable getThrowableToLog(Object[] paramArrayOfObject)
    {
      if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
        return null;
      }
      paramArrayOfObject = paramArrayOfObject[(paramArrayOfObject.length - 1)];
      if (!(paramArrayOfObject instanceof Throwable)) {
        return null;
      }
      return (Throwable)paramArrayOfObject;
    }
    
    private void printlnInternal(LogLevel paramLogLevel, String paramString1, String paramString2)
    {
      try
      {
        if (!TBSLogger.access$300()) {
          return;
        }
        if (paramLogLevel.getValue() >= TBSLogger.sLogLevel.getValue())
        {
          paramLogLevel = new LogItem(System.currentTimeMillis(), paramLogLevel, paramString1, paramString2);
          if (TBSLogger.sLogOpen)
          {
            paramString1 = TBSLogger.sLogPrinters.iterator();
            while (paramString1.hasNext()) {
              ((LogPrinter)paramString1.next()).println(paramLogLevel);
            }
          }
        }
        return;
      }
      catch (Exception paramLogLevel)
      {
        paramLogLevel.printStackTrace();
      }
    }
    
    private void setTagName(String paramString)
    {
      this.mTagName = paramString;
    }
    
    public void d(String paramString)
    {
      printlnInternal(LogLevel.DEBUG, this.mTagName, paramString);
    }
    
    public void d(String paramString, Object... paramVarArgs)
    {
      printlnInternal(LogLevel.DEBUG, this.mTagName, format(paramString, paramVarArgs));
    }
    
    public void e(String paramString)
    {
      printlnInternal(LogLevel.ERROR, this.mTagName, paramString);
    }
    
    public void e(String paramString, Object... paramVarArgs)
    {
      printlnInternal(LogLevel.ERROR, this.mTagName, format(paramString, paramVarArgs));
    }
    
    public void i(String paramString)
    {
      printlnInternal(LogLevel.INFO, this.mTagName, paramString);
    }
    
    public void i(String paramString, Object... paramVarArgs)
    {
      printlnInternal(LogLevel.INFO, this.mTagName, format(paramString, paramVarArgs));
    }
    
    public void log(int paramInt, String paramString)
    {
      printlnInternal(LogLevel.valueOf(paramInt), this.mTagName, paramString);
    }
    
    public void log(int paramInt, String paramString, Object... paramVarArgs)
    {
      printlnInternal(LogLevel.valueOf(paramInt), this.mTagName, format(paramString, paramVarArgs));
    }
    
    public void v(String paramString)
    {
      printlnInternal(LogLevel.VERBOSE, this.mTagName, paramString);
    }
    
    public void v(String paramString, Object... paramVarArgs)
    {
      printlnInternal(LogLevel.VERBOSE, this.mTagName, format(paramString, paramVarArgs));
    }
    
    public void w(String paramString)
    {
      printlnInternal(LogLevel.WARN, this.mTagName, paramString);
    }
    
    public void w(String paramString, Object... paramVarArgs)
    {
      printlnInternal(LogLevel.WARN, this.mTagName, format(paramString, paramVarArgs));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.logger.TBSLogger
 * JD-Core Version:    0.7.0.1
 */