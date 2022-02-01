package com.tencent.tpns.baseapi.base.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.tpns.baseapi.core.b.c;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

public class Util
{
  private static PowerManager.WakeLock a;
  private static long b = -1L;
  private static String c = null;
  
  public static boolean checkAccessId(long paramLong)
  {
    if (((paramLong >= 1500000000L) && (paramLong < 1600000000L)) || ((paramLong >= 1800000000L) && (paramLong < 1900000000L))) {
      return true;
    }
    Logger.e("Util", "AccessId is Invalid!!, accessId: " + paramLong);
    return false;
  }
  
  public static boolean checkAccessKey(String paramString)
  {
    if ((paramString == null) || (paramString.length() != 12))
    {
      Logger.e("Util", "AccessKey is Invalid!!, accessKey: " + paramString);
      return false;
    }
    int i = 0;
    while (i < paramString.length())
    {
      if ((!Character.isUpperCase(paramString.charAt(i))) && (!Character.isDigit(paramString.charAt(i))))
      {
        Logger.e("Util", "AccessKey is Invalid!!, accessKey: " + paramString);
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean checkPermission(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      int i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramContext)
    {
      Logger.i("Util", "checkPermission error:" + paramString, paramContext);
    }
    return false;
  }
  
  public static String getCurAppVersion(Context paramContext)
  {
    if (!isNullOrEmptyString(c)) {
      return c;
    }
    try
    {
      c = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      if (c == null) {
        return "";
      }
    }
    catch (Throwable paramContext)
    {
      Logger.e("Util", "get app version error", paramContext);
    }
    return c;
  }
  
  public static String getCurProcessName(Context paramContext)
  {
    if (!TextUtils.isEmpty(TGlobalHelper.curProcessName)) {
      return TGlobalHelper.curProcessName;
    }
    Object localObject = getCurProcessNameByProcFile(paramContext);
    if ((!isNullOrEmptyString((String)localObject)) && (((String)localObject).contains(paramContext.getPackageName())) && (!((String)localObject).contains("SecurityException")))
    {
      TGlobalHelper.curProcessName = (String)localObject;
      return TGlobalHelper.curProcessName;
    }
    if (paramContext != null) {}
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext != null)
      {
        int i = Process.myPid();
        paramContext = paramContext.getRunningAppProcesses().iterator();
        while (paramContext.hasNext())
        {
          localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if (((ActivityManager.RunningAppProcessInfo)localObject).pid == i) {
            TGlobalHelper.curProcessName = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Logger.w("Util", "#unexcepted - getCurProcessName failed:" + paramContext.getMessage());
      }
    }
    return TGlobalHelper.curProcessName;
    return null;
  }
  
  /* Error */
  public static String getCurProcessNameByProcFile(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: new 195	java/io/BufferedReader
    //   5: dup
    //   6: new 197	java/io/FileReader
    //   9: dup
    //   10: new 36	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   17: ldc 199
    //   19: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokestatic 156	android/os/Process:myPid	()I
    //   25: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: ldc 204
    //   30: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 207	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   39: invokespecial 210	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 213	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore_3
    //   50: aload_3
    //   51: astore_2
    //   52: aload_1
    //   53: astore_0
    //   54: aload_3
    //   55: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifne +10 -> 68
    //   61: aload_1
    //   62: astore_0
    //   63: aload_3
    //   64: invokevirtual 216	java/lang/String:trim	()Ljava/lang/String;
    //   67: astore_2
    //   68: aload_1
    //   69: ifnull +7 -> 76
    //   72: aload_1
    //   73: invokevirtual 219	java/io/BufferedReader:close	()V
    //   76: aload_2
    //   77: areturn
    //   78: astore_0
    //   79: ldc 34
    //   81: new 36	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   88: ldc 119
    //   90: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_0
    //   94: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 56	com/tencent/tpns/baseapi/base/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_2
    //   104: areturn
    //   105: astore_2
    //   106: aconst_null
    //   107: astore_1
    //   108: aload_1
    //   109: astore_0
    //   110: ldc 34
    //   112: new 36	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   119: ldc 119
    //   121: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_2
    //   125: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 56	com/tencent/tpns/baseapi/base/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 219	java/io/BufferedReader:close	()V
    //   142: aconst_null
    //   143: areturn
    //   144: astore_0
    //   145: ldc 34
    //   147: new 36	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   154: ldc 119
    //   156: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_0
    //   160: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 56	com/tencent/tpns/baseapi/base/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: goto -27 -> 142
    //   172: astore_2
    //   173: aload_0
    //   174: astore_1
    //   175: aload_2
    //   176: astore_0
    //   177: aload_1
    //   178: ifnull +7 -> 185
    //   181: aload_1
    //   182: invokevirtual 219	java/io/BufferedReader:close	()V
    //   185: aload_0
    //   186: athrow
    //   187: astore_1
    //   188: ldc 34
    //   190: new 36	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   197: ldc 119
    //   199: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_1
    //   203: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 56	com/tencent/tpns/baseapi/base/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: goto -27 -> 185
    //   215: astore_2
    //   216: aload_0
    //   217: astore_1
    //   218: aload_2
    //   219: astore_0
    //   220: goto -43 -> 177
    //   223: astore_2
    //   224: goto -116 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	paramContext	Context
    //   42	140	1	localObject1	Object
    //   187	16	1	localThrowable1	Throwable
    //   217	1	1	localContext	Context
    //   51	53	2	str1	String
    //   105	20	2	localThrowable2	Throwable
    //   172	4	2	localObject2	Object
    //   215	4	2	localObject3	Object
    //   223	1	2	localThrowable3	Throwable
    //   49	15	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   72	76	78	java/lang/Throwable
    //   2	43	105	java/lang/Throwable
    //   138	142	144	java/lang/Throwable
    //   2	43	172	finally
    //   181	185	187	java/lang/Throwable
    //   45	50	215	finally
    //   54	61	215	finally
    //   63	68	215	finally
    //   110	134	215	finally
    //   45	50	223	java/lang/Throwable
    //   54	61	223	java/lang/Throwable
    //   63	68	223	java/lang/Throwable
  }
  
  public static long getCurVersionCode(Context paramContext)
  {
    if (b > 0L) {
      return b;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      b = localPackageManager.getPackageInfo(paramContext.getPackageName(), 16384).versionCode;
      return b;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        Logger.e("Util", "getCurVersionCode error: PackageManager.NameNotFoundException", paramContext);
        b = -1L;
      }
    }
  }
  
  public static String getKey(String paramString)
  {
    return Md5.md5(paramString);
  }
  
  public static String getNotifiedMsgIds(Context paramContext, long paramLong)
  {
    String str = "" + PushMd5Pref.getString(paramContext, new StringBuilder().append("tpush_msgId_").append(paramLong).toString(), true);
    paramContext = str;
    if (str != null)
    {
      paramContext = str;
      if (str.length() > 20480) {
        paramContext = str.substring(0, str.indexOf("@@", 5120));
      }
    }
    if (paramContext != null) {
      return paramContext;
    }
    return "";
  }
  
  public static String getThrowableToString(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public static void getWakeCpu(Context paramContext)
  {
    if (paramContext == null)
    {
      Logger.e("Util", "Util -> getWakeCpu error null context");
      return;
    }
    try
    {
      paramContext = (PowerManager)paramContext.getSystemService("power");
      if (a == null)
      {
        a = paramContext.newWakeLock(536870913, "TPNS:VIP");
        c.a().a(a);
      }
      if (!c.a().b().isHeld())
      {
        c.a().b().setReferenceCounted(false);
        c.a().b().acquire(10000L);
      }
      Logger.d("Util", "get Wake Cpu ");
      return;
    }
    catch (Throwable paramContext)
    {
      Logger.e("Util", "get Wake cpu", paramContext);
    }
  }
  
  public static boolean isMainProcess(Context paramContext)
  {
    if (paramContext == null) {}
    String str;
    do
    {
      return false;
      str = getCurProcessName(paramContext);
    } while (isNullOrEmptyString(str));
    return paramContext.getPackageName().equals(str);
  }
  
  public static boolean isNullOrEmptyString(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
  
  public static void stopWakeCpu()
  {
    try
    {
      PowerManager.WakeLock localWakeLock = c.a().b();
      if (localWakeLock != null)
      {
        boolean bool = localWakeLock.isHeld();
        if (bool) {}
        try
        {
          localWakeLock.release();
          Logger.d("Util", "stop WakeLock CPU");
          return;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            Logger.e("Util", "Wakelock exception", localThrowable1);
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable2)
    {
      Logger.e("Util", "stopWakeLock", localThrowable2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.util.Util
 * JD-Core Version:    0.7.0.1
 */