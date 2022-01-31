package com.tencent.smtt.utils;

import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class TbsLogClient
{
  static final String TBS_LOG_FILE = "tbslog.txt";
  static TbsLogClient intance = null;
  static File mLogFile = null;
  Vector<String> logMessage;
  TextView mView;
  private SimpleDateFormat time_formatter;
  
  /* Error */
  public TbsLogClient()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 36	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield 38	com/tencent/smtt/utils/TbsLogClient:time_formatter	Ljava/text/SimpleDateFormat;
    //   9: aload_0
    //   10: new 40	java/text/SimpleDateFormat
    //   13: dup
    //   14: ldc 42
    //   16: getstatic 48	java/util/Locale:US	Ljava/util/Locale;
    //   19: invokespecial 51	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   22: putfield 38	com/tencent/smtt/utils/TbsLogClient:time_formatter	Ljava/text/SimpleDateFormat;
    //   25: getstatic 28	com/tencent/smtt/utils/TbsLogClient:mLogFile	Ljava/io/File;
    //   28: ifnonnull +29 -> 57
    //   31: invokestatic 57	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   34: ldc 59
    //   36: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifeq +36 -> 75
    //   42: new 67	java/io/File
    //   45: dup
    //   46: getstatic 72	com/tencent/smtt/utils/FileUtil:TBSLOG_PATH	Ljava/lang/String;
    //   49: ldc 11
    //   51: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: putstatic 28	com/tencent/smtt/utils/TbsLogClient:mLogFile	Ljava/io/File;
    //   57: return
    //   58: astore_1
    //   59: aload_0
    //   60: new 40	java/text/SimpleDateFormat
    //   63: dup
    //   64: ldc 42
    //   66: invokespecial 78	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   69: putfield 38	com/tencent/smtt/utils/TbsLogClient:time_formatter	Ljava/text/SimpleDateFormat;
    //   72: goto -47 -> 25
    //   75: aconst_null
    //   76: putstatic 28	com/tencent/smtt/utils/TbsLogClient:mLogFile	Ljava/io/File;
    //   79: return
    //   80: astore_1
    //   81: aload_1
    //   82: invokevirtual 81	java/lang/SecurityException:printStackTrace	()V
    //   85: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	TbsLogClient
    //   58	1	1	localException	java.lang.Exception
    //   80	2	1	localSecurityException	java.lang.SecurityException
    // Exception table:
    //   from	to	target	type
    //   9	25	58	java/lang/Exception
    //   25	57	80	java/lang/SecurityException
    //   75	79	80	java/lang/SecurityException
  }
  
  public static TbsLogClient getIntance()
  {
    if (intance == null) {
      intance = new TbsLogClient();
    }
    return intance;
  }
  
  public void d(String paramString1, String paramString2) {}
  
  public void e(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2) {}
  
  public void setLogView(TextView paramTextView)
  {
    this.mView = paramTextView;
  }
  
  public void showLog(String paramString)
  {
    if (this.mView != null) {
      this.mView.post(new LogRunnable(paramString));
    }
  }
  
  public void v(String paramString1, String paramString2) {}
  
  public void w(String paramString1, String paramString2) {}
  
  public void writeLog(String paramString)
  {
    if (mLogFile != null)
    {
      String str = this.time_formatter.format(Long.valueOf(System.currentTimeMillis()));
      LogFileUtils.writeDataToStorage(mLogFile, str + " pid=" + Process.myPid() + " " + paramString + "\n", true);
    }
  }
  
  private class LogRunnable
    implements Runnable
  {
    String mLog = null;
    
    LogRunnable(String paramString)
    {
      this.mLog = paramString;
    }
    
    public void run()
    {
      if (TbsLogClient.this.mView != null) {
        TbsLogClient.this.mView.append(this.mLog + "\n");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsLogClient
 * JD-Core Version:    0.7.0.1
 */