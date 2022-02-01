package net.openid.appauth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

class Logger
{
  @VisibleForTesting
  static final String LOG_TAG = "AppAuth";
  @Nullable
  private static Logger sInstance;
  @NonNull
  private final LogWrapper mLog;
  private final int mLogLevel;
  
  @VisibleForTesting
  Logger(LogWrapper paramLogWrapper)
  {
    this.mLog = ((LogWrapper)Preconditions.checkNotNull(paramLogWrapper));
    int i = 7;
    while ((i >= 2) && (this.mLog.isLoggable("AppAuth", i))) {
      i -= 1;
    }
    this.mLogLevel = (i + 1);
  }
  
  public static void debug(String paramString, Object... paramVarArgs)
  {
    getInstance().log(3, null, paramString, paramVarArgs);
  }
  
  public static void debugWithStack(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    getInstance().log(3, paramThrowable, paramString, paramVarArgs);
  }
  
  public static void error(String paramString, Object... paramVarArgs)
  {
    getInstance().log(6, null, paramString, paramVarArgs);
  }
  
  public static void errorWithStack(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    getInstance().log(6, paramThrowable, paramString, paramVarArgs);
  }
  
  public static Logger getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new Logger(AndroidLogWrapper.INSTANCE);
      }
      Logger localLogger = sInstance;
      return localLogger;
    }
    finally {}
  }
  
  public static void info(String paramString, Object... paramVarArgs)
  {
    getInstance().log(4, null, paramString, paramVarArgs);
  }
  
  public static void infoWithStack(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    getInstance().log(4, paramThrowable, paramString, paramVarArgs);
  }
  
  @VisibleForTesting
  static void setInstance(Logger paramLogger)
  {
    try
    {
      sInstance = paramLogger;
      return;
    }
    finally
    {
      paramLogger = finally;
      throw paramLogger;
    }
  }
  
  public static void verbose(String paramString, Object... paramVarArgs)
  {
    getInstance().log(2, null, paramString, paramVarArgs);
  }
  
  public static void verboseWithStack(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    getInstance().log(2, paramThrowable, paramString, paramVarArgs);
  }
  
  public static void warn(String paramString, Object... paramVarArgs)
  {
    getInstance().log(5, null, paramString, paramVarArgs);
  }
  
  public static void warnWithStack(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    getInstance().log(5, paramThrowable, paramString, paramVarArgs);
  }
  
  public void log(int paramInt, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (this.mLogLevel > paramInt) {
      return;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length < 1)) {}
    for (;;)
    {
      paramVarArgs = paramString;
      if (paramThrowable != null) {
        paramVarArgs = paramString + "\n" + this.mLog.getStackTraceString(paramThrowable);
      }
      this.mLog.println(paramInt, "AppAuth", paramVarArgs);
      return;
      paramString = String.format(paramString, paramVarArgs);
    }
  }
  
  static final class AndroidLogWrapper
    implements Logger.LogWrapper
  {
    private static final AndroidLogWrapper INSTANCE = new AndroidLogWrapper();
    
    public String getStackTraceString(Throwable paramThrowable)
    {
      return Log.getStackTraceString(paramThrowable);
    }
    
    public boolean isLoggable(String paramString, int paramInt)
    {
      return Log.isLoggable(paramString, paramInt);
    }
    
    public void println(int paramInt, String paramString1, String paramString2)
    {
      Log.println(paramInt, paramString1, paramString2);
    }
  }
  
  @VisibleForTesting
  static abstract interface LogWrapper
  {
    public abstract String getStackTraceString(Throwable paramThrowable);
    
    public abstract boolean isLoggable(String paramString, int paramInt);
    
    public abstract void println(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.Logger
 * JD-Core Version:    0.7.0.1
 */