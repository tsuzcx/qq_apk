package moai.daemon.utils;

public class Log
{
  private static int sLevel = 2;
  private static ILogger sLogger = new MoaiDaemonLogger(new LogcatLogger(null));
  
  public static void d(String paramString1, String paramString2)
  {
    if (sLevel <= 3) {
      sLogger.log(3, paramString1, paramString2, null);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (sLevel <= 6) {
      sLogger.log(6, paramString1, paramString2, null);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLevel <= 6) {
      sLogger.log(6, paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (sLevel <= 4) {
      sLogger.log(4, paramString1, paramString2, null);
    }
  }
  
  public static void setLevel(int paramInt)
  {
    sLevel = paramInt;
  }
  
  public static void setLogger(ILogger paramILogger)
  {
    if (paramILogger == null) {
      return;
    }
    sLogger = new MoaiDaemonLogger(paramILogger);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (sLevel <= 2) {
      sLogger.log(2, paramString1, paramString2, null);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (sLevel <= 5) {
      sLogger.log(5, paramString1, paramString2, null);
    }
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLevel <= 5) {
      sLogger.log(5, paramString1, paramString2, paramThrowable);
    }
  }
  
  public static abstract interface ILogger
  {
    public abstract void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable);
  }
  
  static class LogcatLogger
    implements Log.ILogger
  {
    public void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 2: 
        if (paramThrowable == null)
        {
          android.util.Log.v(paramString1, paramString2);
          return;
        }
        android.util.Log.v(paramString1, paramString2, paramThrowable);
        return;
      case 3: 
        if (paramThrowable == null)
        {
          android.util.Log.d(paramString1, paramString2);
          return;
        }
        android.util.Log.d(paramString1, paramString2, paramThrowable);
        return;
      case 4: 
        if (paramThrowable == null)
        {
          android.util.Log.i(paramString1, paramString2);
          return;
        }
        android.util.Log.i(paramString1, paramString2, paramThrowable);
        return;
      case 5: 
        if (paramThrowable == null)
        {
          android.util.Log.w(paramString1, paramString2);
          return;
        }
        android.util.Log.w(paramString1, paramString2, paramThrowable);
        return;
      }
      if (paramThrowable == null)
      {
        android.util.Log.e(paramString1, paramString2);
        return;
      }
      android.util.Log.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  static class MoaiDaemonLogger
    implements Log.ILogger
  {
    Log.ILogger logger;
    
    MoaiDaemonLogger(Log.ILogger paramILogger)
    {
      this.logger = paramILogger;
    }
    
    public void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
    {
      this.logger.log(paramInt, "moai-daemon-" + paramString1, paramString2, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.daemon.utils.Log
 * JD-Core Version:    0.7.0.1
 */