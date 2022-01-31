package com.tencent.mobileqq.msf.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.mobileqq.msf.core.f;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class n
{
  private static long A = 0L;
  private static String B;
  private static String C;
  private static FileWriter D;
  private static AtomicBoolean E;
  private static int F = 0;
  private static long G = 0L;
  private static AtomicBoolean H;
  private static final int[] I;
  private static AtomicInteger J;
  private static Handler K;
  private static volatile Context L;
  private static String M = "";
  private static final String N = "MSF.D.QLogImpl";
  private static final String O = "QLog";
  private static final String P = "";
  private static boolean Q = false;
  private static long R = 0L;
  protected static int a = 0;
  protected static final boolean b = false;
  protected static boolean c = false;
  protected static Object d;
  public static final String e = "LOGLEVEL_";
  public static final String f = "LOGLEVELTIME";
  public static final String g = "LOGSAVETIME";
  static k h;
  static final ReentrantLock i;
  public static Runnable j;
  static String k = "";
  static long l = 0L;
  static Thread m = new r();
  public static final String n = "D";
  public static final String o = "W";
  public static final String p = "E";
  static HashSet q = new HashSet();
  static long r = 0L;
  private static Field s;
  private static Boolean t = Boolean.valueOf(true);
  private static ThreadLocal u = new o();
  private static final String v = "appMemory";
  private static int w;
  private static String x;
  private static String y;
  private static long z;
  
  static
  {
    a = 1;
    w = a;
    c = true;
    d = new Object();
    x = "";
    y = "";
    B = "";
    C = "";
    h = new k(15000);
    i = new ReentrantLock();
    E = new AtomicBoolean(false);
    G = 0L;
    H = new AtomicBoolean(false);
    I = new int[] { 1, 2, 4, 8, 16, 29 };
    J = new AtomicInteger(0);
    K = new Handler(Looper.getMainLooper());
    L = null;
    j = new p();
  }
  
  public static String a()
  {
    int i1 = B.indexOf(":");
    if (i1 > 0) {
      return B.substring(0, i1);
    }
    return B;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return "E";
    case 2: 
      return "W";
    case 4: 
      return "D";
    }
    return "E";
  }
  
  public static String a(String paramString)
  {
    return B.replace(":", "_") + "." + paramString + ".log";
  }
  
  private static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = p();
    localStringBuilder.append("[");
    localStringBuilder.append(a(paramInt));
    localStringBuilder.append("]");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    int i1 = 0;
    Object localObject = BaseApplication.getContext().getSharedPreferences("QLog", 0);
    long l1 = ((SharedPreferences)localObject).getLong("", -1L);
    if ((l1 == -1L) || (System.currentTimeMillis() - l1 > 3600000L))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("", System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject).commit();
      i1 = 1;
    }
    if (i1 != 0)
    {
      paramString1 = new s(paramInt, paramString1, paramString2);
      paramString1.setName("doReportLogSelfThread");
      paramString1.start();
    }
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    String str = paramString1 + ".zip";
    File localFile = new File(str);
    localFile.delete();
    try
    {
      localFile.createNewFile();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new a(paramString1));
      f.a(localArrayList, str);
      f.a(paramInt, str, paramString2, paramString3);
      localFile.delete();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      QLog.d("MSF.D.QLogImpl", 1, "doReportLogSelf error " + paramString1);
    }
  }
  
  static void a(long paramLong)
    throws IOException
  {
    for (;;)
    {
      Object localObject3;
      File localFile;
      try
      {
        x = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + C.replace(".", "/") + "/";
        y = Environment.getExternalStorageDirectory().getPath() + "/tencent/" + C.replace(".", "/") + "/";
        localObject3 = new File(x);
        if (!((File)localObject3).exists()) {
          ((File)localObject3).mkdirs();
        }
        k = x + a(b(paramLong));
      }
      finally {}
      try
      {
        localFile = new File(k);
        try
        {
          if (!localFile.exists())
          {
            boolean bool = localFile.createNewFile();
            q();
            localObject3 = localFile;
            if (D != null)
            {
              D.write(M + "|" + B + "|D|" + "MSF.D.QLogImpl" + "|" + Build.MODEL + " " + Build.VERSION.RELEASE + " create newLogFile " + localFile.getName() + " " + bool + "\n");
              D.flush();
              localObject3 = localFile;
            }
            D = new FileWriter((File)localObject3, true);
            q();
            return;
          }
          q();
          localObject3 = localFile;
          if (D == null) {
            continue;
          }
          D.write(M + "|" + B + "|E|" + "MSF.D.QLogImpl" + "|" + Build.MODEL + " " + Build.VERSION.RELEASE + "|newLogFile " + localFile.getName() + " is existed.\n");
          D.flush();
          localObject3 = localFile;
          continue;
          localThrowable1.printStackTrace();
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        Object localObject2 = localObject4;
        localObject4 = localThrowable2;
        continue;
      }
      localObject4 = localFile;
    }
  }
  
  public static void a(Context paramContext)
  {
    L = paramContext.getApplicationContext();
    j.run();
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    a(paramString1, paramInt, paramString2, null);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if ((w >= paramInt) || (q.contains(paramString1)))
    {
      if (paramThrowable != null) {
        break label39;
      }
      Log.e(paramString1, a(paramString2, paramInt));
    }
    for (;;)
    {
      e(paramString1, paramInt, paramString2, paramThrowable);
      return;
      label39:
      Log.e(paramString1, a(paramString2, paramInt), paramThrowable);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Log.d("MSF.D.QLogImpl", "[s]" + paramString2);
  }
  
  private static void a(Calendar paramCalendar)
  {
    paramCalendar.add(11, 1);
    paramCalendar.set(12, 0);
    paramCalendar.set(13, 0);
    z = paramCalendar.getTimeInMillis();
  }
  
  public static void a(boolean paramBoolean)
  {
    c = paramBoolean;
    j.run();
  }
  
  public static void a(String[] paramArrayOfString)
  {
    r = System.currentTimeMillis();
    int i2 = paramArrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = paramArrayOfString[i1];
      q.add(str);
      i1 += 1;
    }
  }
  
  public static void a(String[] paramArrayOfString, int paramInt, boolean paramBoolean, String paramString)
  {
    int i2 = paramArrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = paramArrayOfString[i1];
      q.remove(str);
      i1 += 1;
    }
    if (paramBoolean) {
      a(paramInt, "mobileqq", paramString);
    }
  }
  
  public static String b()
  {
    return x;
  }
  
  private static String b(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    Object localObject = new SimpleDateFormat("yy.MM.dd.HH");
    M = new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(Long.valueOf(paramLong));
    localObject = ((SimpleDateFormat)localObject).format(localCalendar.getTime());
    b(localCalendar);
    a(localCalendar);
    return localObject;
  }
  
  public static void b(int paramInt)
  {
    w = paramInt;
    QLog.d("MSF.D.QLogImpl", 1, "set UIN_REPORTLOG_LEVEL " + e());
  }
  
  public static void b(String paramString1, int paramInt, String paramString2)
  {
    b(paramString1, paramInt, paramString2, null);
  }
  
  public static void b(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if ((w >= paramInt) || (q.contains(paramString1)))
    {
      if (paramThrowable != null) {
        break label39;
      }
      Log.w(paramString1, a(paramString2, paramInt));
    }
    for (;;)
    {
      e(paramString1, paramInt, paramString2, paramThrowable);
      return;
      label39:
      Log.w(paramString1, a(paramString2, paramInt), paramThrowable);
    }
  }
  
  private static void b(Calendar paramCalendar)
  {
    paramCalendar.set(14, 0);
    A = paramCalendar.getTimeInMillis() + 1000L;
  }
  
  public static String c()
  {
    return y;
  }
  
  /* Error */
  private static void c(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: lload_0
    //   4: getstatic 525	com/tencent/mobileqq/msf/sdk/n:A	J
    //   7: lcmp
    //   8: ifle +34 -> 42
    //   11: getstatic 116	com/tencent/mobileqq/msf/sdk/n:d	Ljava/lang/Object;
    //   14: astore_2
    //   15: aload_2
    //   16: monitorenter
    //   17: getstatic 534	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:timeFormatter	Ljava/text/SimpleDateFormat;
    //   20: lload_0
    //   21: invokestatic 492	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   24: invokevirtual 496	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   27: putstatic 176	com/tencent/mobileqq/msf/sdk/n:M	Ljava/lang/String;
    //   30: getstatic 525	com/tencent/mobileqq/msf/sdk/n:A	J
    //   33: ldc2_w 522
    //   36: ladd
    //   37: putstatic 525	com/tencent/mobileqq/msf/sdk/n:A	J
    //   40: aload_2
    //   41: monitorexit
    //   42: ldc 2
    //   44: monitorexit
    //   45: return
    //   46: astore_3
    //   47: aload_2
    //   48: monitorexit
    //   49: aload_3
    //   50: athrow
    //   51: astore_2
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramLong	long
    //   51	5	2	localObject2	Object
    //   46	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   17	42	46	finally
    //   47	49	46	finally
    //   3	17	51	finally
    //   49	51	51	finally
  }
  
  public static void c(String paramString1, int paramInt, String paramString2)
  {
    c(paramString1, paramInt, paramString2, null);
  }
  
  public static void c(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if ((w >= paramInt) || (q.contains(paramString1)))
    {
      if (paramThrowable != null) {
        break label39;
      }
      Log.i(paramString1, a(paramString2, paramInt));
    }
    for (;;)
    {
      e(paramString1, paramInt, paramString2, paramThrowable);
      return;
      label39:
      Log.i(paramString1, a(paramString2, paramInt), paramThrowable);
    }
  }
  
  public static SimpleDateFormat d()
  {
    return new SimpleDateFormat("yy.MM.dd.HH");
  }
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    d(paramString1, paramInt, paramString2, null);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if ((w >= paramInt) || (q.contains(paramString1)))
    {
      if (paramThrowable != null) {
        break label39;
      }
      Log.d(paramString1, a(paramString2, paramInt));
    }
    for (;;)
    {
      e(paramString1, paramInt, paramString2, paramThrowable);
      return;
      label39:
      Log.d(paramString1, a(paramString2, paramInt), paramThrowable);
    }
  }
  
  public static int e()
  {
    return w;
  }
  
  private static void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if (!c) {}
    do
    {
      return;
      long l1 = System.currentTimeMillis();
      if (l1 >= A) {
        c(l1);
      }
      if ((r != 0L) && (l1 - r > 1800000L))
      {
        r = 0L;
        q.clear();
      }
      String str = a(paramInt);
      l1 = Thread.currentThread().getId();
      StringBuilder localStringBuilder = p();
      localStringBuilder.append(M);
      localStringBuilder.append("|");
      localStringBuilder.append(B);
      localStringBuilder.append("[");
      localStringBuilder.append(F);
      localStringBuilder.append("]|");
      localStringBuilder.append(l1);
      localStringBuilder.append("|");
      localStringBuilder.append(str);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("\n");
      if (paramThrowable != null)
      {
        localStringBuilder.append("\n");
        localStringBuilder.append(Log.getStackTraceString(paramThrowable));
        localStringBuilder.append("\n");
      }
      if (!f(localStringBuilder.toString()))
      {
        Log.d("QLogImpl", "addLogToCache failed!");
        return;
      }
    } while ((BaseApplication.getContext() == null) || (System.currentTimeMillis() - G <= 180000L));
    G = System.currentTimeMillis();
    r();
  }
  
  public static String f()
  {
    return B;
  }
  
  private static boolean f(String paramString)
  {
    try
    {
      h.add(paramString);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static boolean g()
  {
    return w > 1;
  }
  
  private static boolean g(String paramString)
  {
    try
    {
      h.a(paramString);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private static void h(String paramString)
  {
    try
    {
      if (!c) {
        return;
      }
      if (!s()) {
        return;
      }
      if (D != null) {
        break label126;
      }
      System.out.println("can not write log.");
      l1 = System.currentTimeMillis();
      if (l != 0L) {
        break label91;
      }
      l = l1;
    }
    catch (Throwable paramString)
    {
      long l1;
      while (((paramString instanceof IOException)) && (paramString.getMessage().contains("ENOSPC")))
      {
        if (!H.compareAndSet(false, true)) {
          return;
        }
        paramString.printStackTrace();
        return;
        label91:
        long l2 = l;
        if (l1 - l2 > 60000L)
        {
          try
          {
            a(System.currentTimeMillis());
            l = l1;
          }
          catch (IOException paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
            }
          }
          label126:
          l1 = System.currentTimeMillis();
          if (l1 > z) {
            a(l1);
          }
          boolean bool = i.tryLock();
          if (bool) {}
          try
          {
            D.write(paramString);
            D.flush();
            i.unlock();
          }
          finally
          {
            i.unlock();
          }
          Log.d("QLogImpl", "insertLogToCacheHead failed!");
        }
      }
      H.compareAndSet(true, false);
      paramString.printStackTrace();
      try
      {
        a(System.currentTimeMillis());
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
    H.compareAndSet(true, false);
    return;
  }
  
  public static boolean h()
  {
    return w >= 4;
  }
  
  private static StringBuilder p()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      if (t.booleanValue())
      {
        s = StringBuilder.class.getSuperclass().getDeclaredField("value");
        s.setAccessible(true);
        t = Boolean.valueOf(false);
      }
      if (s != null) {
        s.set(localStringBuilder, u.get());
      }
      return localStringBuilder;
    }
    catch (Exception localException) {}
    return localStringBuilder;
  }
  
  private static void q()
    throws IOException
  {
    if ((D != null) && (!"".equals(QLog.sBuildNumber)))
    {
      D.write(M + "|" + B + "|D|" + "|QQ_Version: " + QLog.sBuildNumber + "\r\n");
      D.flush();
    }
  }
  
  private static void r()
  {
    try
    {
      ActivityManager localActivityManager = (ActivityManager)BaseApplication.getContext().getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      localActivityManager.getMemoryInfo(localMemoryInfo);
      if (QLog.isColorLevel()) {
        d("appMemory", 2, "availMem:" + localMemoryInfo.availMem / 1024L / 1024L + "M" + " lowThreshold:" + localMemoryInfo.threshold / 1024L / 1024L + "M");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      d("appMemory", 2, "printMemError " + localException, localException);
    }
  }
  
  private static boolean s()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - R > 2000L)
    {
      Q = "mounted".equals(Environment.getExternalStorageState());
      R = l1;
    }
    return Q;
  }
  
  public static class a
    extends File
  {
    public String a = "";
    
    public a(File paramFile, String paramString)
    {
      super(paramString);
    }
    
    public a(String paramString)
    {
      super();
    }
  }
  
  protected static class b
  {
    String a;
    String b;
    String c;
    Throwable d;
    
    public b(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.n
 * JD-Core Version:    0.7.0.1
 */