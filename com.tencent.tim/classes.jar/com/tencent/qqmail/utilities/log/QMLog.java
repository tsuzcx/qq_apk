package com.tencent.qqmail.utilities.log;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDebug.Log;
import com.tencent.qphone.base.util.QLog;
import moai.log.FileHandler;
import moai.log.Handler;
import moai.log.MLog;
import moai.log.MLogManager;

public class QMLog
{
  private static final String TAG = "QMLog";
  private static FileHandler fileHandler;
  private static MLog logger = MLogManager.getLogger("qqmail");
  private static long traceTime = 0L;
  
  static
  {
    Object localObject = new QMLog.1();
    logger.addHandler((Handler)localObject);
    localObject = MLogConfiguration.getInstance();
    ((MLogConfiguration)localObject).update(logger);
    ((MLogConfiguration)localObject).monitor(logger);
  }
  
  public static void flush()
  {
    fileHandler.flush();
  }
  
  public static String getStackTrace(int paramInt)
  {
    return "";
  }
  
  public static String getStackTrace(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfStackTraceElement.length)
    {
      localStringBuilder.append("\tat ").append(paramArrayOfStackTraceElement[i]).append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String getTrace(String paramString)
  {
    return "";
  }
  
  public static void initSQLiteLogger()
  {
    SQLiteDebug.Log.setLevel(4);
    SQLiteDebug.Log.setLogger(new QMLog.2());
  }
  
  public static String limitLength(int paramInt, String paramString)
  {
    if ((paramString == null) || (paramString.length() < 4096)) {
      return paramString;
    }
    return paramString.substring(0, 4096);
  }
  
  public static void log(int paramInt, String paramString1, String paramString2)
  {
    logger.println(paramInt, paramString1, limitLength(paramInt, paramString2));
    QLog.d("QQmail-" + paramString1, 1, paramString2);
  }
  
  public static void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      log(paramInt, paramString1, limitLength(paramInt, paramString2 + "\n" + Log.getStackTraceString(paramThrowable)));
      return;
    }
    log(paramInt, paramString1, limitLength(paramInt, paramString2));
  }
  
  public static void log(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    log(paramInt, paramString1, limitLength(paramInt, String.format(paramString2, paramVarArgs)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.QMLog
 * JD-Core Version:    0.7.0.1
 */