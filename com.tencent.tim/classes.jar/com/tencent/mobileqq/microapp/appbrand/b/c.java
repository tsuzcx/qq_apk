package com.tencent.mobileqq.microapp.appbrand.b;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.LruCache;
import aqhq;
import aqmr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedWriter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import mqq.app.AppRuntime;

public class c
{
  private static long a;
  private static StringBuilder b = new StringBuilder(10240);
  private static String c = "";
  private static final int d = Process.myPid();
  private static String e = "";
  private static a f = null;
  private static a g = null;
  private static RecyclablePool h;
  private static volatile b i;
  private static String j = "";
  private static HashMap k = new HashMap();
  private static Map l = new HashMap();
  private static final String m = Environment.getExternalStorageDirectory().getPath() + "/miniApp/files/miniprogramLog/";
  private static SimpleDateFormat n = new SimpleDateFormat("yy.MM.dd.HH");
  private static SimpleDateFormat o = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
  private static Map p = new HashMap();
  private static LinkedBlockingQueue q = new LinkedBlockingQueue(256);
  
  static
  {
    new LruCache(5);
  }
  
  public static Boolean a(String paramString)
  {
    if ((k.get(paramString) != null) && (((Boolean)k.get(paramString)).booleanValue())) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public static void a()
  {
    if ((h == null) && (BaseApplicationImpl.getApplication() != null))
    {
      j = AppSetting.nT();
      e = BaseApplicationImpl.getApplication().getProcessName();
      BaseApplicationImpl.getApplication().getPackageName();
      h = new RecyclablePool(a.class, 512);
    }
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    b(paramString1, paramInt, paramString2, paramString3, null);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if (a(paramString2).booleanValue()) {
      a(paramString2, paramString1, paramInt, paramString3, paramThrowable);
    }
    if (QLog.isColorLevel()) {
      QLog.e(paramString1, paramInt, paramString3, paramThrowable);
    }
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    int i2 = 0;
    int i3 = paramVarArgs.length;
    if (paramThrowable == null) {}
    StringBuilder localStringBuilder;
    for (int i1 = 0;; i1 = 128)
    {
      localStringBuilder = new StringBuilder(i1 + i3 * 30);
      i1 = i2;
      while (i1 < paramVarArgs.length)
      {
        localStringBuilder.append(paramVarArgs[i1]);
        i1 += 1;
      }
    }
    a(paramString1, paramInt, paramString2, localStringBuilder.toString(), paramThrowable);
  }
  
  private static void a(String arg0, String paramString2, int paramInt, String paramString3, Throwable paramThrowable)
  {
    if ((h == null) || (aqmr.isEmpty(???))) {}
    a locala;
    do
    {
      return;
      locala = (a)h.obtain(a.class);
    } while (locala == null);
    locala.a = System.currentTimeMillis();
    locala.b = Process.myTid();
    locala.c = paramInt;
    locala.d = paramString2;
    locala.e = paramString3;
    locala.f = paramThrowable;
    locala.g = ???;
    synchronized (e)
    {
      if (f == null)
      {
        f = locala;
        g = locala;
        g();
        i.removeMessages(1);
        i.sendEmptyMessageDelayed(1, 1000L);
        return;
      }
      g.changeNext(locala, true);
      g = locala;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    k.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public static void b(String paramString1, int paramInt, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if (a(paramString2).booleanValue()) {
      a(paramString2, paramString1, paramInt, paramString3, paramThrowable);
    }
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, paramInt, paramString3, paramThrowable);
    }
  }
  
  public static boolean b(String paramString)
  {
    return (a(paramString).booleanValue()) || (QLog.isColorLevel());
  }
  
  public static String c(String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return m + MD5.toMD5(paramString) + "/" + str + "/";
  }
  
  private static String d(String paramString)
  {
    return e.replace(":", "_") + "." + paramString + ".log";
  }
  
  private static void g()
  {
    if (i == null) {
      try
      {
        if (i == null) {
          i = new b(ThreadManager.getSubThreadLooper(), null);
        }
        return;
      }
      finally {}
    }
  }
  
  /* Error */
  private static void h()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 60	com/tencent/mobileqq/microapp/appbrand/b/c:e	Ljava/lang/String;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: getstatic 64	com/tencent/mobileqq/microapp/appbrand/b/c:g	Lcom/tencent/mobileqq/microapp/appbrand/b/c$a;
    //   12: astore 5
    //   14: getstatic 62	com/tencent/mobileqq/microapp/appbrand/b/c:f	Lcom/tencent/mobileqq/microapp/appbrand/b/c$a;
    //   17: astore_3
    //   18: aconst_null
    //   19: putstatic 64	com/tencent/mobileqq/microapp/appbrand/b/c:g	Lcom/tencent/mobileqq/microapp/appbrand/b/c$a;
    //   22: aconst_null
    //   23: putstatic 62	com/tencent/mobileqq/microapp/appbrand/b/c:f	Lcom/tencent/mobileqq/microapp/appbrand/b/c$a;
    //   26: aload_2
    //   27: monitorexit
    //   28: aload_3
    //   29: astore_2
    //   30: aload_3
    //   31: ifnonnull +52 -> 83
    //   34: invokestatic 293	com/tencent/mobileqq/microapp/appbrand/b/c:i	()V
    //   37: ldc 2
    //   39: monitorexit
    //   40: return
    //   41: astore_3
    //   42: aload_2
    //   43: monitorexit
    //   44: aload_3
    //   45: athrow
    //   46: astore_2
    //   47: aload_2
    //   48: invokevirtual 296	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   51: ifnull +20 -> 71
    //   54: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +14 -> 71
    //   60: ldc_w 298
    //   63: iconst_2
    //   64: aload_2
    //   65: invokevirtual 296	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   68: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: invokestatic 293	com/tencent/mobileqq/microapp/appbrand/b/c:i	()V
    //   74: goto -37 -> 37
    //   77: astore_2
    //   78: ldc 2
    //   80: monitorexit
    //   81: aload_2
    //   82: athrow
    //   83: aload_2
    //   84: astore_3
    //   85: aload_3
    //   86: getfield 203	com/tencent/mobileqq/microapp/appbrand/b/c$a:a	J
    //   89: lstore_0
    //   90: lload_0
    //   91: getstatic 302	com/tencent/mobileqq/microapp/appbrand/b/c:a	J
    //   94: ldc2_w 226
    //   97: ladd
    //   98: lcmp
    //   99: ifge +11 -> 110
    //   102: lload_0
    //   103: getstatic 302	com/tencent/mobileqq/microapp/appbrand/b/c:a	J
    //   106: lcmp
    //   107: ifge +50 -> 157
    //   110: getstatic 111	com/tencent/mobileqq/microapp/appbrand/b/c:o	Ljava/text/SimpleDateFormat;
    //   113: lload_0
    //   114: invokestatic 307	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   117: invokevirtual 311	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   120: putstatic 50	com/tencent/mobileqq/microapp/appbrand/b/c:c	Ljava/lang/String;
    //   123: lload_0
    //   124: getstatic 302	com/tencent/mobileqq/microapp/appbrand/b/c:a	J
    //   127: ldc2_w 226
    //   130: ladd
    //   131: lcmp
    //   132: iflt +346 -> 478
    //   135: lload_0
    //   136: getstatic 302	com/tencent/mobileqq/microapp/appbrand/b/c:a	J
    //   139: ldc2_w 312
    //   142: ladd
    //   143: lcmp
    //   144: ifge +334 -> 478
    //   147: getstatic 302	com/tencent/mobileqq/microapp/appbrand/b/c:a	J
    //   150: ldc2_w 226
    //   153: ladd
    //   154: putstatic 302	com/tencent/mobileqq/microapp/appbrand/b/c:a	J
    //   157: new 40	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   164: aload_3
    //   165: getfield 218	com/tencent/mobileqq/microapp/appbrand/b/c$a:g	Ljava/lang/String;
    //   168: invokestatic 315	com/tencent/mobileqq/microapp/appbrand/b/c:c	(Ljava/lang/String;)Ljava/lang/String;
    //   171: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: getstatic 107	com/tencent/mobileqq/microapp/appbrand/b/c:n	Ljava/text/SimpleDateFormat;
    //   177: invokestatic 201	java/lang/System:currentTimeMillis	()J
    //   180: invokestatic 307	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   183: invokevirtual 311	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   186: invokestatic 317	com/tencent/mobileqq/microapp/appbrand/b/c:d	(Ljava/lang/String;)Ljava/lang/String;
    //   189: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: astore 6
    //   197: new 83	java/io/File
    //   200: dup
    //   201: aload 6
    //   203: invokespecial 318	java/io/File:<init>	(Ljava/lang/String;)V
    //   206: astore 7
    //   208: aload 7
    //   210: invokevirtual 321	java/io/File:exists	()Z
    //   213: ifne +297 -> 510
    //   216: aload 6
    //   218: invokestatic 327	aqhq:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   221: pop
    //   222: new 329	java/io/BufferedWriter
    //   225: dup
    //   226: new 331	com/tencent/mobileqq/microapp/appbrand/b/g
    //   229: dup
    //   230: aload 7
    //   232: iconst_1
    //   233: invokespecial 334	com/tencent/mobileqq/microapp/appbrand/b/g:<init>	(Ljava/io/File;Z)V
    //   236: sipush 8192
    //   239: invokespecial 337	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   242: astore_2
    //   243: aload_2
    //   244: new 40	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   251: getstatic 50	com/tencent/mobileqq/microapp/appbrand/b/c:c	Ljava/lang/String;
    //   254: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc_w 339
    //   260: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: getstatic 60	com/tencent/mobileqq/microapp/appbrand/b/c:e	Ljava/lang/String;
    //   266: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc_w 341
    //   272: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: getstatic 66	com/tencent/mobileqq/microapp/appbrand/b/c:j	Ljava/lang/String;
    //   278: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc_w 343
    //   284: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokevirtual 346	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   293: getstatic 46	com/tencent/mobileqq/microapp/appbrand/b/c:b	Ljava/lang/StringBuilder;
    //   296: iconst_0
    //   297: getstatic 46	com/tencent/mobileqq/microapp/appbrand/b/c:b	Ljava/lang/StringBuilder;
    //   300: invokevirtual 349	java/lang/StringBuilder:length	()I
    //   303: invokevirtual 353	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   306: astore 4
    //   308: aload 4
    //   310: getstatic 50	com/tencent/mobileqq/microapp/appbrand/b/c:c	Ljava/lang/String;
    //   313: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: bipush 124
    //   318: invokevirtual 356	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   321: aload_3
    //   322: getfield 203	com/tencent/mobileqq/microapp/appbrand/b/c$a:a	J
    //   325: invokevirtual 359	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   328: aload_3
    //   329: getfield 218	com/tencent/mobileqq/microapp/appbrand/b/c$a:g	Ljava/lang/String;
    //   332: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: bipush 91
    //   337: invokevirtual 356	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   340: getstatic 58	com/tencent/mobileqq/microapp/appbrand/b/c:d	I
    //   343: invokevirtual 362	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   346: bipush 93
    //   348: invokevirtual 356	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   351: aload_3
    //   352: getfield 208	com/tencent/mobileqq/microapp/appbrand/b/c$a:b	I
    //   355: invokevirtual 362	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   358: bipush 124
    //   360: invokevirtual 356	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   363: aload_3
    //   364: getfield 210	com/tencent/mobileqq/microapp/appbrand/b/c$a:c	I
    //   367: invokestatic 366	com/tencent/qphone/base/util/QLog:getReportLevel	(I)Ljava/lang/String;
    //   370: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: bipush 124
    //   375: invokevirtual 356	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   378: aload_3
    //   379: getfield 212	com/tencent/mobileqq/microapp/appbrand/b/c$a:d	Ljava/lang/String;
    //   382: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: bipush 124
    //   387: invokevirtual 356	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   390: aload_3
    //   391: getfield 213	com/tencent/mobileqq/microapp/appbrand/b/c$a:e	Ljava/lang/String;
    //   394: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: bipush 10
    //   399: invokevirtual 356	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload_2
    //   404: aload 4
    //   406: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokevirtual 346	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   412: aload_3
    //   413: getfield 216	com/tencent/mobileqq/microapp/appbrand/b/c$a:f	Ljava/lang/Throwable;
    //   416: ifnull +20 -> 436
    //   419: aload_2
    //   420: aload_3
    //   421: getfield 216	com/tencent/mobileqq/microapp/appbrand/b/c$a:f	Ljava/lang/Throwable;
    //   424: invokestatic 372	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   427: invokevirtual 346	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   430: aload_2
    //   431: bipush 10
    //   433: invokevirtual 374	java/io/BufferedWriter:write	(I)V
    //   436: getstatic 74	com/tencent/mobileqq/microapp/appbrand/b/c:l	Ljava/util/Map;
    //   439: aload 6
    //   441: aload_2
    //   442: invokeinterface 377 3 0
    //   447: pop
    //   448: aload_3
    //   449: invokevirtual 381	com/tencent/mobileqq/microapp/appbrand/b/c$a:getNext	()Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   452: checkcast 6	com/tencent/mobileqq/microapp/appbrand/b/c$a
    //   455: astore_2
    //   456: getstatic 140	com/tencent/mobileqq/microapp/appbrand/b/c:h	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   459: aload_3
    //   460: invokevirtual 385	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   463: aload_3
    //   464: aload 5
    //   466: if_acmpne -383 -> 83
    //   469: invokestatic 293	com/tencent/mobileqq/microapp/appbrand/b/c:i	()V
    //   472: invokestatic 293	com/tencent/mobileqq/microapp/appbrand/b/c:i	()V
    //   475: goto -438 -> 37
    //   478: invokestatic 391	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   481: astore_2
    //   482: aload_2
    //   483: lload_0
    //   484: invokevirtual 395	java/util/Calendar:setTimeInMillis	(J)V
    //   487: aload_2
    //   488: bipush 14
    //   490: iconst_0
    //   491: invokevirtual 399	java/util/Calendar:set	(II)V
    //   494: aload_2
    //   495: invokevirtual 402	java/util/Calendar:getTimeInMillis	()J
    //   498: putstatic 302	com/tencent/mobileqq/microapp/appbrand/b/c:a	J
    //   501: goto -344 -> 157
    //   504: astore_2
    //   505: invokestatic 293	com/tencent/mobileqq/microapp/appbrand/b/c:i	()V
    //   508: aload_2
    //   509: athrow
    //   510: getstatic 74	com/tencent/mobileqq/microapp/appbrand/b/c:l	Ljava/util/Map;
    //   513: aload 6
    //   515: invokeinterface 403 2 0
    //   520: checkcast 329	java/io/BufferedWriter
    //   523: astore 4
    //   525: aload 4
    //   527: astore_2
    //   528: aload 4
    //   530: ifnonnull -237 -> 293
    //   533: new 329	java/io/BufferedWriter
    //   536: dup
    //   537: new 331	com/tencent/mobileqq/microapp/appbrand/b/g
    //   540: dup
    //   541: aload 7
    //   543: iconst_1
    //   544: invokespecial 334	com/tencent/mobileqq/microapp/appbrand/b/g:<init>	(Ljava/io/File;Z)V
    //   547: sipush 8192
    //   550: invokespecial 337	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   553: astore_2
    //   554: goto -261 -> 293
    // Local variable table:
    //   start	length	slot	name	signature
    //   89	395	0	l1	long
    //   46	19	2	localThrowable	Throwable
    //   77	7	2	localObject2	Object
    //   242	253	2	localObject3	Object
    //   504	5	2	localObject4	Object
    //   527	27	2	localObject5	Object
    //   17	14	3	locala1	a
    //   41	4	3	localObject6	Object
    //   84	380	3	localObject7	Object
    //   306	223	4	localObject8	Object
    //   12	453	5	locala2	a
    //   195	319	6	str	String
    //   206	336	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   9	28	41	finally
    //   42	44	41	finally
    //   3	9	46	java/lang/Throwable
    //   44	46	46	java/lang/Throwable
    //   85	110	46	java/lang/Throwable
    //   110	157	46	java/lang/Throwable
    //   157	293	46	java/lang/Throwable
    //   293	436	46	java/lang/Throwable
    //   436	463	46	java/lang/Throwable
    //   469	472	46	java/lang/Throwable
    //   478	501	46	java/lang/Throwable
    //   510	525	46	java/lang/Throwable
    //   533	554	46	java/lang/Throwable
    //   34	37	77	finally
    //   71	74	77	finally
    //   472	475	77	finally
    //   505	510	77	finally
    //   3	9	504	finally
    //   44	46	504	finally
    //   47	71	504	finally
    //   85	110	504	finally
    //   110	157	504	finally
    //   157	293	504	finally
    //   293	436	504	finally
    //   436	463	504	finally
    //   469	472	504	finally
    //   478	501	504	finally
    //   510	525	504	finally
    //   533	554	504	finally
  }
  
  private static void i()
  {
    Iterator localIterator = l.values().iterator();
    while (localIterator.hasNext())
    {
      BufferedWriter localBufferedWriter = (BufferedWriter)localIterator.next();
      if (localBufferedWriter != null) {
        try
        {
          localBufferedWriter.flush();
          localBufferedWriter.close();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    l.clear();
  }
  
  private static void j()
  {
    for (;;)
    {
      try
      {
        if (q.isEmpty()) {
          break label194;
        }
        locald = (d)q.poll();
        if ((locald == null) || (aqmr.isEmpty(locald.a))) {
          continue;
        }
        str = locald.a;
        localFile = new File(str);
        if (localFile.exists()) {
          continue;
        }
        aqhq.createFile(str);
        localBufferedWriter1 = new BufferedWriter(new g(localFile, true), 8192);
      }
      catch (Throwable localThrowable)
      {
        d locald;
        String str;
        File localFile;
        BufferedWriter localBufferedWriter1;
        if ((localThrowable.getMessage() == null) || (!QLog.isColorLevel())) {
          continue;
        }
        QLog.e("MiniLog", 2, localThrowable.getMessage());
        try
        {
          return;
        }
        finally {}
        localBufferedWriter2 = (BufferedWriter)p.get(str);
        localObject1 = localBufferedWriter2;
        if (localBufferedWriter2 != null) {
          continue;
        }
        localObject1 = new BufferedWriter(new g(localFile, true), 8192);
        continue;
      }
      finally
      {
        k();
      }
      localBufferedWriter1.write(locald.b);
      p.put(str, localBufferedWriter1);
    }
    for (;;)
    {
      BufferedWriter localBufferedWriter2;
      Object localObject1;
      label194:
      k();
    }
  }
  
  private static void k()
  {
    Iterator localIterator = p.values().iterator();
    while (localIterator.hasNext())
    {
      BufferedWriter localBufferedWriter = (BufferedWriter)localIterator.next();
      if (localBufferedWriter != null) {
        try
        {
          localBufferedWriter.flush();
          localBufferedWriter.close();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    p.clear();
  }
  
  public static class a
    extends RecyclablePool.Recyclable
  {
    public long a;
    public int b;
    public int c;
    public String d;
    public String e;
    public Throwable f;
    public String g;
    
    public void recycle()
    {
      super.recycle();
      this.a = 0L;
      this.b = 0;
      this.c = 0;
      this.d = "";
      this.e = "";
      this.f = null;
      this.g = "";
    }
  }
  
  static final class b
    extends Handler
  {
    private b(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          return;
        } while ((c.b() == null) || (c.c() == null));
        ThreadManager.excute(new e(this), 64, null, false);
        return;
      } while (c.e().isEmpty());
      ThreadManager.excute(new f(this), 64, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.b.c
 * JD-Core Version:    0.7.0.1
 */