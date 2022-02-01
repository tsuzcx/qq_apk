package tv.danmaku.ijk.media.player.pragma;

import com.tencent.oskplayer.support.log.ILogger;
import com.tencent.oskplayer.support.log.Logger;
import java.util.Locale;

public class DebugLog
{
  public static final boolean ENABLE_DEBUG = true;
  public static final boolean ENABLE_ERROR = true;
  public static final boolean ENABLE_INFO = true;
  public static final boolean ENABLE_VERBOSE = true;
  public static final boolean ENABLE_WARN = true;
  
  public static void d(String paramString1, String paramString2)
  {
    Logger.g().d(paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Logger.g().d(paramString1, paramString2, paramThrowable);
  }
  
  public static void dfmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    paramString2 = String.format(Locale.US, paramString2, paramVarArgs);
    Logger.g().d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    Logger.g().e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Logger.g().e(paramString1, paramString2, paramThrowable);
  }
  
  public static void efmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    paramString2 = String.format(Locale.US, paramString2, paramVarArgs);
    Logger.g().e(paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    Logger.g().i(paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Logger.g().i(paramString1, paramString2, paramThrowable);
  }
  
  public static void ifmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    paramString2 = String.format(Locale.US, paramString2, paramVarArgs);
    Logger.g().i(paramString1, paramString2);
  }
  
  public static void printCause(Throwable paramThrowable)
  {
    Throwable localThrowable = paramThrowable.getCause();
    if (localThrowable != null) {
      paramThrowable = localThrowable;
    }
    printStackTrace(paramThrowable);
  }
  
  public static void printStackTrace(Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
  }
  
  public static void v(String paramString1, String paramString2)
  {
    Logger.g().v(paramString1, paramString2);
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Logger.g().v(paramString1, paramString2, paramThrowable);
  }
  
  public static void vfmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    paramString2 = String.format(Locale.US, paramString2, paramVarArgs);
    Logger.g().v(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    Logger.g().w(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Logger.g().w(paramString1, paramString2, paramThrowable);
  }
  
  public static void wfmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    paramString2 = String.format(Locale.US, paramString2, paramVarArgs);
    Logger.g().w(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.pragma.DebugLog
 * JD-Core Version:    0.7.0.1
 */