package com.tencent.feedback.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import com.tencent.feedback.proguard.a;
import java.io.File;
import java.util.Locale;

public final class d
{
  private static d a;
  private Context b;
  
  private d(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      this.b = paramContext;
      return;
      Context localContext = paramContext.getApplicationContext();
      if (localContext != null) {
        paramContext = localContext;
      }
    }
  }
  
  /* Error */
  public static d a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 25	com/tencent/feedback/common/d:a	Lcom/tencent/feedback/common/d;
    //   6: ifnonnull +22 -> 28
    //   9: aload_0
    //   10: ifnull +18 -> 28
    //   13: aload_0
    //   14: ifnonnull +23 -> 37
    //   17: new 2	com/tencent/feedback/common/d
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 27	com/tencent/feedback/common/d:<init>	(Landroid/content/Context;)V
    //   25: putstatic 25	com/tencent/feedback/common/d:a	Lcom/tencent/feedback/common/d;
    //   28: getstatic 25	com/tencent/feedback/common/d:a	Lcom/tencent/feedback/common/d;
    //   31: astore_0
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload_0
    //   36: areturn
    //   37: aload_0
    //   38: invokevirtual 21	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull -26 -> 17
    //   46: aload_1
    //   47: astore_0
    //   48: goto -31 -> 17
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramContext	Context
    //   41	6	1	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	9	51	finally
    //   17	28	51	finally
    //   28	32	51	finally
    //   37	42	51	finally
  }
  
  public static String a()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Throwable localThrowable)
    {
      e.d("rqdp{  getDeviceName error}", new Object[0]);
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String b()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    catch (Throwable localThrowable)
    {
      e.d("rqdp{  getVersion error}", new Object[0]);
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String b(Context paramContext)
  {
    String str = "fail";
    Object localObject2;
    if (paramContext == null)
    {
      e.d("rqdp{  getImei but context == null!}", new Object[0]);
      localObject2 = "fail";
      return localObject2;
    }
    for (;;)
    {
      try
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
        if (paramContext != null) {
          continue;
        }
        paramContext = "null";
        try
        {
          e.a("rqdp{  IMEI:}" + paramContext, new Object[0]);
          return paramContext;
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        paramContext = (Context)localObject1;
        Object localObject1 = localThrowable2;
        continue;
      }
      e.d("rqdp{  getImei error!}", new Object[0]);
      localObject2 = paramContext;
      if (e.a(localThrowable1)) {
        break;
      }
      localThrowable1.printStackTrace();
      return paramContext;
      localObject1 = paramContext;
      paramContext = paramContext.toLowerCase();
    }
  }
  
  public static String c()
  {
    try
    {
      String str = Build.VERSION.SDK;
      return str;
    }
    catch (Throwable localThrowable)
    {
      e.d("rqdp{  getApiLevel error}", new Object[0]);
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String c(Context paramContext)
  {
    Object localObject = "fail";
    if (paramContext == null)
    {
      e.d("rqdp{  getImsi but context == null!}", new Object[0]);
      paramContext = "fail";
    }
    do
    {
      return paramContext;
      try
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
        if (paramContext == null) {
          return "null";
        }
        localObject = paramContext;
        paramContext = paramContext.toLowerCase();
        return paramContext;
      }
      catch (Throwable localThrowable)
      {
        e.d("rqdp{  getImsi error!}", new Object[0]);
        paramContext = (Context)localObject;
      }
    } while (e.a(localThrowable));
    localThrowable.printStackTrace();
    return localObject;
  }
  
  public static String d()
  {
    Object localObject2 = null;
    try
    {
      localObject1 = Build.CPU_ABI;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).trim().length() != 0) {}
      }
      else
      {
        localObject2 = System.getProperty("os.arch");
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "fail";
      }
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        e.c("rqdp{  ge cuabi fa!}", new Object[0]);
        Object localObject1 = localObject2;
        if (!e.a(localThrowable))
        {
          localThrowable.printStackTrace();
          localObject1 = localObject2;
        }
      }
    }
  }
  
  /* Error */
  public static String d(Context paramContext)
  {
    // Byte code:
    //   0: ldc 52
    //   2: astore_1
    //   3: aload_0
    //   4: ifnonnull +15 -> 19
    //   7: ldc 135
    //   9: iconst_0
    //   10: anewarray 4	java/lang/Object
    //   13: invokestatic 44	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   16: pop
    //   17: aload_1
    //   18: areturn
    //   19: aload_0
    //   20: invokevirtual 139	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   23: ldc 141
    //   25: invokestatic 147	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_0
    //   29: aload_0
    //   30: ifnonnull +6 -> 36
    //   33: ldc 75
    //   35: areturn
    //   36: aload_0
    //   37: invokevirtual 98	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   40: astore_1
    //   41: aload_1
    //   42: areturn
    //   43: astore_2
    //   44: aload_1
    //   45: astore_0
    //   46: ldc 149
    //   48: iconst_0
    //   49: anewarray 4	java/lang/Object
    //   52: invokestatic 44	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   55: pop
    //   56: aload_0
    //   57: astore_1
    //   58: aload_2
    //   59: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   62: ifne -45 -> 17
    //   65: aload_2
    //   66: invokevirtual 50	java/lang/Throwable:printStackTrace	()V
    //   69: aload_0
    //   70: areturn
    //   71: astore_2
    //   72: goto -26 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	paramContext	Context
    //   2	56	1	localObject	Object
    //   43	23	2	localThrowable1	Throwable
    //   71	1	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   19	29	43	java/lang/Throwable
    //   36	41	71	java/lang/Throwable
  }
  
  public static long e()
  {
    long l1 = -1L;
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l2 = localStatFs.getBlockSize();
      int i = localStatFs.getBlockCount();
      l1 = i * l2;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        e.d("rqdp{  getDisplayMetrics error!}", new Object[0]);
      } while (e.a(localThrowable));
      localThrowable.printStackTrace();
    }
    return l1;
    return -1L;
  }
  
  public static String e(Context paramContext)
  {
    Object localObject = "fail";
    if (paramContext == null)
    {
      e.d("rqdp{  getMacAddress but context == null!}", new Object[0]);
      return "fail";
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      if (paramContext == null) {
        return "null";
      }
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      if (!e.a(paramContext)) {
        paramContext.printStackTrace();
      }
      e.d("rqdp{  getMacAddress error!}", new Object[0]);
    }
    return localObject;
  }
  
  public static long f()
  {
    long l1 = -1L;
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l2 = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      l1 = i * l2;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        e.d("rqdp{  getDisplayMetrics error!}", new Object[0]);
      } while (e.a(localThrowable));
      localThrowable.printStackTrace();
    }
    return l1;
    return -1L;
  }
  
  public static String f(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return "unknown";
      }
      if (localNetworkInfo.getType() == 1) {
        return "wifi";
      }
      if (localNetworkInfo.getType() == 0)
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null) {
          switch (paramContext.getNetworkType())
          {
          case 15: 
            return "HSPA+";
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      if (!e.a(paramContext))
      {
        paramContext.printStackTrace();
        return "unknown";
      }
      else
      {
        return "unknown";
      }
    }
    return "unknown";
    return "GPRS";
    return "EDGE";
    return "UMTS";
    return "HSDPA";
    return "HSUPA";
    return "HSPA";
    return "CDMA";
    return "EVDO_0";
    return "EVDO_A";
    return "1xRTT";
    return "iDen";
    return "EVDO_B";
    return "LTE";
    return "eHRPD";
  }
  
  /* Error */
  public static long g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 252	java/io/FileReader
    //   6: dup
    //   7: ldc 254
    //   9: invokespecial 255	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   12: astore 4
    //   14: new 257	java/io/BufferedReader
    //   17: dup
    //   18: aload 4
    //   20: sipush 2048
    //   23: invokespecial 260	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   26: astore_3
    //   27: aload_3
    //   28: invokevirtual 263	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: ldc_w 265
    //   34: iconst_2
    //   35: invokevirtual 269	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   38: iconst_1
    //   39: aaload
    //   40: invokevirtual 98	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   43: ldc_w 271
    //   46: ldc_w 273
    //   49: invokevirtual 277	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   52: invokevirtual 117	java/lang/String:trim	()Ljava/lang/String;
    //   55: invokestatic 283	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   58: lstore_0
    //   59: lload_0
    //   60: ldc2_w 284
    //   63: lmul
    //   64: lstore_0
    //   65: aload_3
    //   66: invokevirtual 288	java/io/BufferedReader:close	()V
    //   69: aload 4
    //   71: invokevirtual 289	java/io/FileReader:close	()V
    //   74: lload_0
    //   75: lreturn
    //   76: astore_2
    //   77: aload_2
    //   78: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   81: ifne -12 -> 69
    //   84: aload_2
    //   85: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   88: goto -19 -> 69
    //   91: astore_2
    //   92: aload_2
    //   93: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   96: ifne -22 -> 74
    //   99: aload_2
    //   100: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   103: lload_0
    //   104: lreturn
    //   105: astore 4
    //   107: aconst_null
    //   108: astore_2
    //   109: aload 5
    //   111: astore_3
    //   112: ldc_w 292
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokestatic 44	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   122: pop
    //   123: aload 4
    //   125: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   128: ifne +8 -> 136
    //   131: aload 4
    //   133: invokevirtual 50	java/lang/Throwable:printStackTrace	()V
    //   136: aload_3
    //   137: ifnull +7 -> 144
    //   140: aload_3
    //   141: invokevirtual 288	java/io/BufferedReader:close	()V
    //   144: aload_2
    //   145: ifnull +7 -> 152
    //   148: aload_2
    //   149: invokevirtual 289	java/io/FileReader:close	()V
    //   152: ldc2_w 293
    //   155: lreturn
    //   156: astore_3
    //   157: aload_3
    //   158: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   161: ifne -17 -> 144
    //   164: aload_3
    //   165: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   168: goto -24 -> 144
    //   171: astore_2
    //   172: aload_2
    //   173: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   176: ifne -24 -> 152
    //   179: aload_2
    //   180: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   183: goto -31 -> 152
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_3
    //   189: aconst_null
    //   190: astore 4
    //   192: aload_3
    //   193: ifnull +7 -> 200
    //   196: aload_3
    //   197: invokevirtual 288	java/io/BufferedReader:close	()V
    //   200: aload 4
    //   202: ifnull +8 -> 210
    //   205: aload 4
    //   207: invokevirtual 289	java/io/FileReader:close	()V
    //   210: aload_2
    //   211: athrow
    //   212: astore_3
    //   213: aload_3
    //   214: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   217: ifne -17 -> 200
    //   220: aload_3
    //   221: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   224: goto -24 -> 200
    //   227: astore_3
    //   228: aload_3
    //   229: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   232: ifne -22 -> 210
    //   235: aload_3
    //   236: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   239: goto -29 -> 210
    //   242: astore_2
    //   243: aconst_null
    //   244: astore_3
    //   245: goto -53 -> 192
    //   248: astore_2
    //   249: goto -57 -> 192
    //   252: astore 5
    //   254: aload_2
    //   255: astore 4
    //   257: aload 5
    //   259: astore_2
    //   260: goto -68 -> 192
    //   263: astore_3
    //   264: aload 4
    //   266: astore_2
    //   267: aload_3
    //   268: astore 4
    //   270: aload 5
    //   272: astore_3
    //   273: goto -161 -> 112
    //   276: astore 5
    //   278: aload 4
    //   280: astore_2
    //   281: aload 5
    //   283: astore 4
    //   285: goto -173 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   58	46	0	l	long
    //   76	9	2	localIOException1	java.io.IOException
    //   91	9	2	localIOException2	java.io.IOException
    //   108	41	2	localObject1	Object
    //   171	9	2	localIOException3	java.io.IOException
    //   186	25	2	localObject2	Object
    //   242	1	2	localObject3	Object
    //   248	7	2	localObject4	Object
    //   259	22	2	localObject5	Object
    //   26	115	3	localObject6	Object
    //   156	9	3	localIOException4	java.io.IOException
    //   188	9	3	localObject7	Object
    //   212	9	3	localIOException5	java.io.IOException
    //   227	9	3	localIOException6	java.io.IOException
    //   244	1	3	localObject8	Object
    //   263	5	3	localThrowable1	Throwable
    //   272	1	3	localObject9	Object
    //   12	58	4	localFileReader	java.io.FileReader
    //   105	27	4	localThrowable2	Throwable
    //   190	94	4	localObject10	Object
    //   1	109	5	localObject11	Object
    //   252	19	5	localObject12	Object
    //   276	6	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   65	69	76	java/io/IOException
    //   69	74	91	java/io/IOException
    //   3	14	105	java/lang/Throwable
    //   140	144	156	java/io/IOException
    //   148	152	171	java/io/IOException
    //   3	14	186	finally
    //   196	200	212	java/io/IOException
    //   205	210	227	java/io/IOException
    //   14	27	242	finally
    //   27	59	248	finally
    //   112	136	252	finally
    //   14	27	263	java/lang/Throwable
    //   27	59	276	java/lang/Throwable
  }
  
  /* Error */
  public static long h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 252	java/io/FileReader
    //   6: dup
    //   7: ldc 254
    //   9: invokespecial 255	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   12: astore 4
    //   14: new 257	java/io/BufferedReader
    //   17: dup
    //   18: aload 4
    //   20: sipush 2048
    //   23: invokespecial 260	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   26: astore_3
    //   27: aload_3
    //   28: invokevirtual 263	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: pop
    //   32: aload_3
    //   33: invokevirtual 263	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: ldc_w 265
    //   39: iconst_2
    //   40: invokevirtual 269	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   43: iconst_1
    //   44: aaload
    //   45: invokevirtual 98	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   48: ldc_w 271
    //   51: ldc_w 273
    //   54: invokevirtual 277	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   57: invokevirtual 117	java/lang/String:trim	()Ljava/lang/String;
    //   60: invokestatic 283	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   63: lstore_0
    //   64: lload_0
    //   65: ldc2_w 284
    //   68: lmul
    //   69: lstore_0
    //   70: aload_3
    //   71: invokevirtual 288	java/io/BufferedReader:close	()V
    //   74: aload 4
    //   76: invokevirtual 289	java/io/FileReader:close	()V
    //   79: lload_0
    //   80: lreturn
    //   81: astore_2
    //   82: aload_2
    //   83: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   86: ifne -12 -> 74
    //   89: aload_2
    //   90: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   93: goto -19 -> 74
    //   96: astore_2
    //   97: aload_2
    //   98: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   101: ifne -22 -> 79
    //   104: aload_2
    //   105: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   108: lload_0
    //   109: lreturn
    //   110: astore 4
    //   112: aconst_null
    //   113: astore_2
    //   114: aload 5
    //   116: astore_3
    //   117: ldc_w 292
    //   120: iconst_0
    //   121: anewarray 4	java/lang/Object
    //   124: invokestatic 44	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   127: pop
    //   128: aload 4
    //   130: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   133: ifne +8 -> 141
    //   136: aload 4
    //   138: invokevirtual 50	java/lang/Throwable:printStackTrace	()V
    //   141: aload_3
    //   142: ifnull +7 -> 149
    //   145: aload_3
    //   146: invokevirtual 288	java/io/BufferedReader:close	()V
    //   149: aload_2
    //   150: ifnull +7 -> 157
    //   153: aload_2
    //   154: invokevirtual 289	java/io/FileReader:close	()V
    //   157: ldc2_w 293
    //   160: lreturn
    //   161: astore_3
    //   162: aload_3
    //   163: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   166: ifne -17 -> 149
    //   169: aload_3
    //   170: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   173: goto -24 -> 149
    //   176: astore_2
    //   177: aload_2
    //   178: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   181: ifne -24 -> 157
    //   184: aload_2
    //   185: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   188: goto -31 -> 157
    //   191: astore_2
    //   192: aconst_null
    //   193: astore_3
    //   194: aconst_null
    //   195: astore 4
    //   197: aload_3
    //   198: ifnull +7 -> 205
    //   201: aload_3
    //   202: invokevirtual 288	java/io/BufferedReader:close	()V
    //   205: aload 4
    //   207: ifnull +8 -> 215
    //   210: aload 4
    //   212: invokevirtual 289	java/io/FileReader:close	()V
    //   215: aload_2
    //   216: athrow
    //   217: astore_3
    //   218: aload_3
    //   219: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   222: ifne -17 -> 205
    //   225: aload_3
    //   226: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   229: goto -24 -> 205
    //   232: astore_3
    //   233: aload_3
    //   234: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   237: ifne -22 -> 215
    //   240: aload_3
    //   241: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   244: goto -29 -> 215
    //   247: astore_2
    //   248: aconst_null
    //   249: astore_3
    //   250: goto -53 -> 197
    //   253: astore_2
    //   254: goto -57 -> 197
    //   257: astore 5
    //   259: aload_2
    //   260: astore 4
    //   262: aload 5
    //   264: astore_2
    //   265: goto -68 -> 197
    //   268: astore_3
    //   269: aload 4
    //   271: astore_2
    //   272: aload_3
    //   273: astore 4
    //   275: aload 5
    //   277: astore_3
    //   278: goto -161 -> 117
    //   281: astore 5
    //   283: aload 4
    //   285: astore_2
    //   286: aload 5
    //   288: astore 4
    //   290: goto -173 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   63	46	0	l	long
    //   81	9	2	localIOException1	java.io.IOException
    //   96	9	2	localIOException2	java.io.IOException
    //   113	41	2	localObject1	Object
    //   176	9	2	localIOException3	java.io.IOException
    //   191	25	2	localObject2	Object
    //   247	1	2	localObject3	Object
    //   253	7	2	localObject4	Object
    //   264	22	2	localObject5	Object
    //   26	120	3	localObject6	Object
    //   161	9	3	localIOException4	java.io.IOException
    //   193	9	3	localObject7	Object
    //   217	9	3	localIOException5	java.io.IOException
    //   232	9	3	localIOException6	java.io.IOException
    //   249	1	3	localObject8	Object
    //   268	5	3	localThrowable1	Throwable
    //   277	1	3	localObject9	Object
    //   12	63	4	localFileReader	java.io.FileReader
    //   110	27	4	localThrowable2	Throwable
    //   195	94	4	localObject10	Object
    //   1	114	5	localObject11	Object
    //   257	19	5	localObject12	Object
    //   281	6	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   70	74	81	java/io/IOException
    //   74	79	96	java/io/IOException
    //   3	14	110	java/lang/Throwable
    //   145	149	161	java/io/IOException
    //   153	157	176	java/io/IOException
    //   3	14	191	finally
    //   201	205	217	java/io/IOException
    //   210	215	232	java/io/IOException
    //   14	27	247	finally
    //   27	64	253	finally
    //   117	141	257	finally
    //   14	27	268	java/lang/Throwable
    //   27	64	281	java/lang/Throwable
  }
  
  public static String k()
  {
    Object localObject = "fail";
    try
    {
      String str = Locale.getDefault().getCountry();
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        e.d("rqdp{  getCountry error!}", new Object[0]);
      } while (e.a(localThrowable));
      localThrowable.printStackTrace();
    }
    return localObject;
    return "fail";
  }
  
  public static String l()
  {
    Object localObject = "fail";
    try
    {
      String str = Build.BRAND;
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        e.d("rqdp{  getBrand error!}", new Object[0]);
      } while (e.a(localThrowable));
      localThrowable.printStackTrace();
    }
    return localObject;
    return "fail";
  }
  
  /* Error */
  public static long n()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: new 77	java/lang/StringBuilder
    //   9: dup
    //   10: ldc_w 316
    //   13: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: invokestatic 321	android/os/Process:myPid	()I
    //   19: invokevirtual 324	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc_w 326
    //   25: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: astore_3
    //   32: ldc_w 328
    //   35: invokestatic 334	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   38: invokevirtual 337	java/lang/Thread:getName	()Ljava/lang/String;
    //   41: invokevirtual 341	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   44: ifeq +178 -> 222
    //   47: ldc_w 343
    //   50: astore 5
    //   52: ldc_w 345
    //   55: iconst_1
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload 5
    //   63: aastore
    //   64: invokestatic 347	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   67: pop
    //   68: new 252	java/io/FileReader
    //   71: dup
    //   72: aload_3
    //   73: invokespecial 255	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   76: astore 4
    //   78: new 257	java/io/BufferedReader
    //   81: dup
    //   82: aload 4
    //   84: sipush 2048
    //   87: invokespecial 260	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   90: astore_3
    //   91: aload_3
    //   92: invokevirtual 263	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   95: astore 6
    //   97: aload 6
    //   99: ifnull +188 -> 287
    //   102: aload 6
    //   104: aload 5
    //   106: invokevirtual 351	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   109: ifeq -18 -> 91
    //   112: aload 6
    //   114: ldc_w 353
    //   117: invokevirtual 356	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   120: astore 6
    //   122: aload 6
    //   124: arraylength
    //   125: ifle -34 -> 91
    //   128: aload 6
    //   130: iconst_0
    //   131: aaload
    //   132: ldc_w 358
    //   135: invokevirtual 362	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   138: istore_0
    //   139: iload_0
    //   140: ifle -49 -> 91
    //   143: aload 6
    //   145: iconst_0
    //   146: aaload
    //   147: invokevirtual 121	java/lang/String:length	()I
    //   150: iload_0
    //   151: if_icmple -60 -> 91
    //   154: aload 6
    //   156: iconst_0
    //   157: aaload
    //   158: iconst_0
    //   159: iload_0
    //   160: invokevirtual 366	java/lang/String:substring	(II)Ljava/lang/String;
    //   163: bipush 16
    //   165: invokestatic 369	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   168: lstore_1
    //   169: aload 6
    //   171: iconst_0
    //   172: aaload
    //   173: iload_0
    //   174: iconst_1
    //   175: iadd
    //   176: invokevirtual 372	java/lang/String:substring	(I)Ljava/lang/String;
    //   179: bipush 16
    //   181: invokestatic 369	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   184: lload_1
    //   185: lsub
    //   186: lstore_1
    //   187: ldc_w 374
    //   190: iconst_1
    //   191: anewarray 4	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: lload_1
    //   197: invokestatic 378	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   200: aastore
    //   201: invokestatic 347	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   204: pop
    //   205: lload_1
    //   206: lconst_0
    //   207: lcmp
    //   208: ifle +44 -> 252
    //   211: aload_3
    //   212: invokevirtual 288	java/io/BufferedReader:close	()V
    //   215: aload 4
    //   217: invokevirtual 289	java/io/FileReader:close	()V
    //   220: lload_1
    //   221: lreturn
    //   222: new 77	java/lang/StringBuilder
    //   225: dup
    //   226: ldc_w 380
    //   229: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   232: invokestatic 383	android/os/Process:myTid	()I
    //   235: invokevirtual 324	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: ldc_w 385
    //   241: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: astore 5
    //   249: goto -197 -> 52
    //   252: lload_1
    //   253: lneg
    //   254: lstore_1
    //   255: goto -44 -> 211
    //   258: astore_3
    //   259: aload_3
    //   260: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   263: ifne -48 -> 215
    //   266: aload_3
    //   267: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   270: goto -55 -> 215
    //   273: astore_3
    //   274: aload_3
    //   275: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   278: ifne -58 -> 220
    //   281: aload_3
    //   282: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   285: lload_1
    //   286: lreturn
    //   287: aload_3
    //   288: invokevirtual 288	java/io/BufferedReader:close	()V
    //   291: aload 4
    //   293: invokevirtual 289	java/io/FileReader:close	()V
    //   296: ldc2_w 152
    //   299: lreturn
    //   300: astore_3
    //   301: aload_3
    //   302: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   305: ifne -14 -> 291
    //   308: aload_3
    //   309: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   312: goto -21 -> 291
    //   315: astore_3
    //   316: aload_3
    //   317: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   320: ifne -24 -> 296
    //   323: aload_3
    //   324: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   327: goto -31 -> 296
    //   330: astore 5
    //   332: aconst_null
    //   333: astore_3
    //   334: aload 6
    //   336: astore 4
    //   338: ldc_w 292
    //   341: iconst_0
    //   342: anewarray 4	java/lang/Object
    //   345: invokestatic 44	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   348: pop
    //   349: aload 5
    //   351: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   354: ifne +8 -> 362
    //   357: aload 5
    //   359: invokevirtual 50	java/lang/Throwable:printStackTrace	()V
    //   362: aload 4
    //   364: ifnull +8 -> 372
    //   367: aload 4
    //   369: invokevirtual 288	java/io/BufferedReader:close	()V
    //   372: aload_3
    //   373: ifnull +7 -> 380
    //   376: aload_3
    //   377: invokevirtual 289	java/io/FileReader:close	()V
    //   380: ldc2_w 293
    //   383: lreturn
    //   384: astore 4
    //   386: aload 4
    //   388: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   391: ifne -19 -> 372
    //   394: aload 4
    //   396: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   399: goto -27 -> 372
    //   402: astore_3
    //   403: aload_3
    //   404: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   407: ifne -27 -> 380
    //   410: aload_3
    //   411: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   414: goto -34 -> 380
    //   417: astore_3
    //   418: aconst_null
    //   419: astore 4
    //   421: aload 7
    //   423: astore 5
    //   425: aload 5
    //   427: ifnull +8 -> 435
    //   430: aload 5
    //   432: invokevirtual 288	java/io/BufferedReader:close	()V
    //   435: aload 4
    //   437: ifnull +8 -> 445
    //   440: aload 4
    //   442: invokevirtual 289	java/io/FileReader:close	()V
    //   445: aload_3
    //   446: athrow
    //   447: astore 5
    //   449: aload 5
    //   451: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   454: ifne -19 -> 435
    //   457: aload 5
    //   459: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   462: goto -27 -> 435
    //   465: astore 4
    //   467: aload 4
    //   469: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   472: ifne -27 -> 445
    //   475: aload 4
    //   477: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   480: goto -35 -> 445
    //   483: astore_3
    //   484: aload 7
    //   486: astore 5
    //   488: goto -63 -> 425
    //   491: astore 6
    //   493: aload_3
    //   494: astore 5
    //   496: aload 6
    //   498: astore_3
    //   499: goto -74 -> 425
    //   502: astore 5
    //   504: aload_3
    //   505: astore 6
    //   507: aload 5
    //   509: astore_3
    //   510: aload 4
    //   512: astore 5
    //   514: aload 6
    //   516: astore 4
    //   518: goto -93 -> 425
    //   521: astore 5
    //   523: aload 4
    //   525: astore_3
    //   526: aload 6
    //   528: astore 4
    //   530: goto -192 -> 338
    //   533: astore 5
    //   535: aload 4
    //   537: astore 6
    //   539: aload_3
    //   540: astore 4
    //   542: aload 6
    //   544: astore_3
    //   545: goto -207 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   138	38	0	i	int
    //   168	118	1	l	long
    //   31	181	3	localObject1	Object
    //   258	9	3	localIOException1	java.io.IOException
    //   273	15	3	localIOException2	java.io.IOException
    //   300	9	3	localIOException3	java.io.IOException
    //   315	9	3	localIOException4	java.io.IOException
    //   333	44	3	localObject2	Object
    //   402	9	3	localIOException5	java.io.IOException
    //   417	29	3	localObject3	Object
    //   483	11	3	localObject4	Object
    //   498	47	3	localObject5	Object
    //   76	292	4	localObject6	Object
    //   384	11	4	localIOException6	java.io.IOException
    //   419	22	4	localObject7	Object
    //   465	46	4	localIOException7	java.io.IOException
    //   516	25	4	localObject8	Object
    //   50	198	5	str	String
    //   330	28	5	localThrowable1	Throwable
    //   423	8	5	localObject9	Object
    //   447	11	5	localIOException8	java.io.IOException
    //   486	9	5	localObject10	Object
    //   502	6	5	localObject11	Object
    //   512	1	5	localObject12	Object
    //   521	1	5	localThrowable2	Throwable
    //   533	1	5	localThrowable3	Throwable
    //   4	331	6	localObject13	Object
    //   491	6	6	localObject14	Object
    //   505	38	6	localObject15	Object
    //   1	484	7	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   211	215	258	java/io/IOException
    //   215	220	273	java/io/IOException
    //   287	291	300	java/io/IOException
    //   291	296	315	java/io/IOException
    //   32	47	330	java/lang/Throwable
    //   52	78	330	java/lang/Throwable
    //   222	249	330	java/lang/Throwable
    //   367	372	384	java/io/IOException
    //   376	380	402	java/io/IOException
    //   32	47	417	finally
    //   52	78	417	finally
    //   222	249	417	finally
    //   430	435	447	java/io/IOException
    //   440	445	465	java/io/IOException
    //   78	91	483	finally
    //   91	97	491	finally
    //   102	139	491	finally
    //   143	205	491	finally
    //   338	362	502	finally
    //   78	91	521	java/lang/Throwable
    //   91	97	533	java/lang/Throwable
    //   102	139	533	java/lang/Throwable
    //   143	205	533	java/lang/Throwable
  }
  
  /* Error */
  public static long o()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 77	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 316
    //   10: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: invokestatic 321	android/os/Process:myPid	()I
    //   16: invokevirtual 324	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc_w 326
    //   22: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 5
    //   30: new 252	java/io/FileReader
    //   33: dup
    //   34: aload 5
    //   36: invokespecial 255	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   39: astore 7
    //   41: new 257	java/io/BufferedReader
    //   44: dup
    //   45: aload 7
    //   47: sipush 2048
    //   50: invokespecial 260	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   53: astore 6
    //   55: lconst_0
    //   56: lstore_1
    //   57: aload 6
    //   59: invokevirtual 263	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   62: astore 5
    //   64: aload 5
    //   66: ifnull +126 -> 192
    //   69: aload 5
    //   71: ldc_w 388
    //   74: invokevirtual 351	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   77: ifeq -20 -> 57
    //   80: aload 5
    //   82: ldc_w 353
    //   85: invokevirtual 356	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   88: astore 5
    //   90: aload 5
    //   92: arraylength
    //   93: ifle +374 -> 467
    //   96: aload 5
    //   98: iconst_0
    //   99: aaload
    //   100: ldc_w 358
    //   103: invokevirtual 362	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   106: istore_0
    //   107: iload_0
    //   108: ifle +359 -> 467
    //   111: aload 5
    //   113: iconst_0
    //   114: aaload
    //   115: invokevirtual 121	java/lang/String:length	()I
    //   118: iload_0
    //   119: if_icmple +348 -> 467
    //   122: aload 5
    //   124: iconst_0
    //   125: aaload
    //   126: iconst_0
    //   127: iload_0
    //   128: invokevirtual 366	java/lang/String:substring	(II)Ljava/lang/String;
    //   131: bipush 16
    //   133: invokestatic 369	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   136: lstore_3
    //   137: aload 5
    //   139: iconst_0
    //   140: aaload
    //   141: iload_0
    //   142: iconst_1
    //   143: iadd
    //   144: invokevirtual 372	java/lang/String:substring	(I)Ljava/lang/String;
    //   147: bipush 16
    //   149: invokestatic 369	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   152: lload_3
    //   153: lsub
    //   154: lstore_3
    //   155: ldc_w 390
    //   158: iconst_1
    //   159: anewarray 4	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: lload_3
    //   165: invokestatic 378	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   168: aastore
    //   169: invokestatic 347	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   172: pop
    //   173: lload_3
    //   174: lconst_0
    //   175: lcmp
    //   176: ifle +10 -> 186
    //   179: lload_3
    //   180: lload_1
    //   181: ladd
    //   182: lstore_1
    //   183: goto -126 -> 57
    //   186: lload_3
    //   187: lneg
    //   188: lstore_3
    //   189: goto -10 -> 179
    //   192: aload 6
    //   194: invokevirtual 288	java/io/BufferedReader:close	()V
    //   197: aload 7
    //   199: invokevirtual 289	java/io/FileReader:close	()V
    //   202: lload_1
    //   203: lreturn
    //   204: astore 5
    //   206: aload 5
    //   208: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   211: ifne -14 -> 197
    //   214: aload 5
    //   216: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   219: goto -22 -> 197
    //   222: astore 5
    //   224: aload 5
    //   226: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   229: ifne -27 -> 202
    //   232: aload 5
    //   234: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   237: lload_1
    //   238: lreturn
    //   239: astore 6
    //   241: aconst_null
    //   242: astore 5
    //   244: aload 8
    //   246: astore 7
    //   248: ldc_w 292
    //   251: iconst_0
    //   252: anewarray 4	java/lang/Object
    //   255: invokestatic 44	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   258: pop
    //   259: aload 6
    //   261: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   264: ifne +8 -> 272
    //   267: aload 6
    //   269: invokevirtual 50	java/lang/Throwable:printStackTrace	()V
    //   272: aload 7
    //   274: ifnull +8 -> 282
    //   277: aload 7
    //   279: invokevirtual 288	java/io/BufferedReader:close	()V
    //   282: aload 5
    //   284: ifnull +8 -> 292
    //   287: aload 5
    //   289: invokevirtual 289	java/io/FileReader:close	()V
    //   292: ldc2_w 293
    //   295: lreturn
    //   296: astore 6
    //   298: aload 6
    //   300: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   303: ifne -21 -> 282
    //   306: aload 6
    //   308: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   311: goto -29 -> 282
    //   314: astore 5
    //   316: aload 5
    //   318: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   321: ifne -29 -> 292
    //   324: aload 5
    //   326: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   329: goto -37 -> 292
    //   332: astore 5
    //   334: aconst_null
    //   335: astore 6
    //   337: aconst_null
    //   338: astore 7
    //   340: aload 6
    //   342: ifnull +8 -> 350
    //   345: aload 6
    //   347: invokevirtual 288	java/io/BufferedReader:close	()V
    //   350: aload 7
    //   352: ifnull +8 -> 360
    //   355: aload 7
    //   357: invokevirtual 289	java/io/FileReader:close	()V
    //   360: aload 5
    //   362: athrow
    //   363: astore 6
    //   365: aload 6
    //   367: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   370: ifne -20 -> 350
    //   373: aload 6
    //   375: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   378: goto -28 -> 350
    //   381: astore 6
    //   383: aload 6
    //   385: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   388: ifne -28 -> 360
    //   391: aload 6
    //   393: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   396: goto -36 -> 360
    //   399: astore 5
    //   401: aconst_null
    //   402: astore 6
    //   404: goto -64 -> 340
    //   407: astore 5
    //   409: goto -69 -> 340
    //   412: astore 8
    //   414: aload 7
    //   416: astore 6
    //   418: aload 5
    //   420: astore 7
    //   422: aload 8
    //   424: astore 5
    //   426: goto -86 -> 340
    //   429: astore 6
    //   431: aload 7
    //   433: astore 5
    //   435: aload 8
    //   437: astore 7
    //   439: goto -191 -> 248
    //   442: astore 9
    //   444: aload 6
    //   446: astore 5
    //   448: aload 7
    //   450: astore 8
    //   452: aload 9
    //   454: astore 6
    //   456: aload 5
    //   458: astore 7
    //   460: aload 8
    //   462: astore 5
    //   464: goto -216 -> 248
    //   467: goto -284 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   106	38	0	i	int
    //   56	182	1	l1	long
    //   136	53	3	l2	long
    //   28	110	5	localObject1	Object
    //   204	11	5	localIOException1	java.io.IOException
    //   222	11	5	localIOException2	java.io.IOException
    //   242	46	5	localObject2	Object
    //   314	11	5	localIOException3	java.io.IOException
    //   332	29	5	localObject3	Object
    //   399	1	5	localObject4	Object
    //   407	12	5	localObject5	Object
    //   424	39	5	localObject6	Object
    //   53	140	6	localBufferedReader	java.io.BufferedReader
    //   239	29	6	localThrowable1	Throwable
    //   296	11	6	localIOException4	java.io.IOException
    //   335	11	6	localObject7	Object
    //   363	11	6	localIOException5	java.io.IOException
    //   381	11	6	localIOException6	java.io.IOException
    //   402	15	6	localObject8	Object
    //   429	16	6	localThrowable2	Throwable
    //   454	1	6	localObject9	Object
    //   39	420	7	localObject10	Object
    //   1	244	8	localObject11	Object
    //   412	24	8	localObject12	Object
    //   450	11	8	localObject13	Object
    //   442	11	9	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   192	197	204	java/io/IOException
    //   197	202	222	java/io/IOException
    //   30	41	239	java/lang/Throwable
    //   277	282	296	java/io/IOException
    //   287	292	314	java/io/IOException
    //   30	41	332	finally
    //   345	350	363	java/io/IOException
    //   355	360	381	java/io/IOException
    //   41	55	399	finally
    //   57	64	407	finally
    //   69	107	407	finally
    //   111	173	407	finally
    //   248	272	412	finally
    //   41	55	429	java/lang/Throwable
    //   57	64	442	java/lang/Throwable
    //   69	107	442	java/lang/Throwable
    //   111	173	442	java/lang/Throwable
  }
  
  public final long i()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (int i = 1; i == 0; i = 0) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      i = localStatFs.getBlockSize();
      int j = localStatFs.getBlockCount();
      return j * i;
    }
    catch (Throwable localThrowable)
    {
      e.d("rqdp{  get total sd error %s}", new Object[] { localThrowable.toString() });
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -2L;
  }
  
  public final long j()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (int i = 1; i == 0; i = 0) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      i = localStatFs.getBlockSize();
      int j = localStatFs.getAvailableBlocks();
      return j * i;
    }
    catch (Throwable localThrowable)
    {
      e.d("rqdp{  get free sd error %s}", new Object[] { localThrowable.toString() });
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -2L;
  }
  
  public final String m()
  {
    return a.a(this.b, "ro.board.platform");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.common.d
 * JD-Core Version:    0.7.0.1
 */