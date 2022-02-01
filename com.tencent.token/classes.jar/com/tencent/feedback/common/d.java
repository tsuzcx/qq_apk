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
import android.provider.Settings.Secure;
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
    if (paramContext != null)
    {
      Context localContext = paramContext.getApplicationContext();
      if (localContext != null) {
        paramContext = localContext;
      }
    }
    this.b = paramContext;
  }
  
  public static d a(Context paramContext)
  {
    for (;;)
    {
      Context localContext;
      try
      {
        if ((a == null) && (paramContext != null))
        {
          if (paramContext != null)
          {
            localContext = paramContext.getApplicationContext();
            if (localContext != null) {
              break label58;
            }
          }
          a = new d(paramContext);
        }
        else
        {
          paramContext = a;
          return paramContext;
        }
      }
      finally {}
      label58:
      paramContext = localContext;
    }
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
    Object localObject = "fail";
    if (paramContext == null)
    {
      e.d("rqdp{  getImei but context == null!}", new Object[0]);
      return "fail";
    }
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      if (paramContext == null)
      {
        paramContext = "null";
      }
      else
      {
        localObject = paramContext;
        paramContext = paramContext.toLowerCase();
      }
      localObject = paramContext;
      e.a("rqdp{  IMEI:}".concat(String.valueOf(paramContext)), new Object[0]);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      e.d("rqdp{  getImei error!}", new Object[0]);
      if (!e.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return localObject;
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
      return "fail";
    }
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
    catch (Throwable paramContext)
    {
      e.d("rqdp{  getImsi error!}", new Object[0]);
      if (!e.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return localObject;
  }
  
  public static String d()
  {
    try
    {
      localObject2 = Build.CPU_ABI;
    }
    catch (Throwable localThrowable)
    {
      e.c("rqdp{  ge cuabi fa!}", new Object[0]);
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
      localObject2 = null;
    }
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).trim().length() != 0) {}
    }
    else
    {
      localObject1 = System.getProperty("os.arch");
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "fail";
    }
    return localObject2;
  }
  
  public static String d(Context paramContext)
  {
    Object localObject = "fail";
    if (paramContext == null)
    {
      e.d("rqdp{  getAndroidId but context == null!}", new Object[0]);
      return "fail";
    }
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      if (paramContext == null) {
        return "null";
      }
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      e.d("rqdp{  getAndroidId error!}", new Object[0]);
      if (!e.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return localObject;
  }
  
  public static long e()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getBlockCount();
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      e.d("rqdp{  getDisplayMetrics error!}", new Object[0]);
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
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
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      e.d("rqdp{  getDisplayMetrics error!}", new Object[0]);
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
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
          case 1: 
            return "GPRS";
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      if (!e.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return "unknown";
    return "unknown";
    return "HSPA+";
    return "eHRPD";
    return "LTE";
    return "EVDO_B";
    return "iDen";
    return "HSPA";
    return "HSUPA";
    return "HSDPA";
    return "1xRTT";
    return "EVDO_A";
    return "EVDO_0";
    return "CDMA";
    return "UMTS";
    return "EDGE";
  }
  
  /* Error */
  public static long g()
  {
    // Byte code:
    //   0: new 249	java/io/FileReader
    //   3: dup
    //   4: ldc 251
    //   6: invokespecial 252	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   9: astore_3
    //   10: new 254	java/io/BufferedReader
    //   13: dup
    //   14: aload_3
    //   15: sipush 2048
    //   18: invokespecial 257	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   21: astore_2
    //   22: aload_2
    //   23: astore 4
    //   25: aload_3
    //   26: astore 5
    //   28: aload_2
    //   29: invokevirtual 260	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: ldc_w 262
    //   35: iconst_2
    //   36: invokevirtual 266	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   39: iconst_1
    //   40: aaload
    //   41: invokevirtual 80	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   44: ldc_w 268
    //   47: ldc_w 270
    //   50: invokevirtual 274	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   53: invokevirtual 117	java/lang/String:trim	()Ljava/lang/String;
    //   56: invokestatic 280	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   59: lstore_0
    //   60: lload_0
    //   61: ldc2_w 281
    //   64: lmul
    //   65: lstore_0
    //   66: aload_2
    //   67: invokevirtual 285	java/io/BufferedReader:close	()V
    //   70: goto +15 -> 85
    //   73: astore_2
    //   74: aload_2
    //   75: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   78: ifne +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   85: aload_3
    //   86: invokevirtual 287	java/io/FileReader:close	()V
    //   89: lload_0
    //   90: lreturn
    //   91: astore_2
    //   92: aload_2
    //   93: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   96: ifne +7 -> 103
    //   99: aload_2
    //   100: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   103: lload_0
    //   104: lreturn
    //   105: astore 6
    //   107: goto +32 -> 139
    //   110: astore_2
    //   111: aconst_null
    //   112: astore 4
    //   114: goto +121 -> 235
    //   117: astore 6
    //   119: aconst_null
    //   120: astore_2
    //   121: goto +18 -> 139
    //   124: astore_2
    //   125: aconst_null
    //   126: astore_3
    //   127: aload_3
    //   128: astore 4
    //   130: goto +105 -> 235
    //   133: astore 6
    //   135: aconst_null
    //   136: astore_3
    //   137: aload_3
    //   138: astore_2
    //   139: aload_2
    //   140: astore 4
    //   142: aload_3
    //   143: astore 5
    //   145: ldc_w 289
    //   148: iconst_0
    //   149: anewarray 4	java/lang/Object
    //   152: invokestatic 44	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   155: pop
    //   156: aload_2
    //   157: astore 4
    //   159: aload_3
    //   160: astore 5
    //   162: aload 6
    //   164: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   167: ifne +14 -> 181
    //   170: aload_2
    //   171: astore 4
    //   173: aload_3
    //   174: astore 5
    //   176: aload 6
    //   178: invokevirtual 50	java/lang/Throwable:printStackTrace	()V
    //   181: aload_2
    //   182: ifnull +22 -> 204
    //   185: aload_2
    //   186: invokevirtual 285	java/io/BufferedReader:close	()V
    //   189: goto +15 -> 204
    //   192: astore_2
    //   193: aload_2
    //   194: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   197: ifne +7 -> 204
    //   200: aload_2
    //   201: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   204: aload_3
    //   205: ifnull +22 -> 227
    //   208: aload_3
    //   209: invokevirtual 287	java/io/FileReader:close	()V
    //   212: goto +15 -> 227
    //   215: astore_2
    //   216: aload_2
    //   217: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   220: ifne +7 -> 227
    //   223: aload_2
    //   224: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   227: ldc2_w 290
    //   230: lreturn
    //   231: astore_2
    //   232: aload 5
    //   234: astore_3
    //   235: aload 4
    //   237: ifnull +26 -> 263
    //   240: aload 4
    //   242: invokevirtual 285	java/io/BufferedReader:close	()V
    //   245: goto +18 -> 263
    //   248: astore 4
    //   250: aload 4
    //   252: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   255: ifne +8 -> 263
    //   258: aload 4
    //   260: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   263: aload_3
    //   264: ifnull +22 -> 286
    //   267: aload_3
    //   268: invokevirtual 287	java/io/FileReader:close	()V
    //   271: goto +15 -> 286
    //   274: astore_3
    //   275: aload_3
    //   276: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   279: ifne +7 -> 286
    //   282: aload_3
    //   283: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   286: aload_2
    //   287: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   59	45	0	l	long
    //   21	46	2	localBufferedReader	java.io.BufferedReader
    //   73	9	2	localIOException1	java.io.IOException
    //   91	9	2	localIOException2	java.io.IOException
    //   110	1	2	localObject1	Object
    //   120	1	2	localObject2	Object
    //   124	1	2	localObject3	Object
    //   138	48	2	localObject4	Object
    //   192	9	2	localIOException3	java.io.IOException
    //   215	9	2	localIOException4	java.io.IOException
    //   231	56	2	localObject5	Object
    //   9	259	3	localObject6	Object
    //   274	9	3	localIOException5	java.io.IOException
    //   23	218	4	localObject7	Object
    //   248	11	4	localIOException6	java.io.IOException
    //   26	207	5	localObject8	Object
    //   105	1	6	localThrowable1	Throwable
    //   117	1	6	localThrowable2	Throwable
    //   133	44	6	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   66	70	73	java/io/IOException
    //   85	89	91	java/io/IOException
    //   28	60	105	java/lang/Throwable
    //   10	22	110	finally
    //   10	22	117	java/lang/Throwable
    //   0	10	124	finally
    //   0	10	133	java/lang/Throwable
    //   185	189	192	java/io/IOException
    //   208	212	215	java/io/IOException
    //   28	60	231	finally
    //   145	156	231	finally
    //   162	170	231	finally
    //   176	181	231	finally
    //   240	245	248	java/io/IOException
    //   267	271	274	java/io/IOException
  }
  
  /* Error */
  public static long h()
  {
    // Byte code:
    //   0: new 249	java/io/FileReader
    //   3: dup
    //   4: ldc 251
    //   6: invokespecial 252	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   9: astore_3
    //   10: new 254	java/io/BufferedReader
    //   13: dup
    //   14: aload_3
    //   15: sipush 2048
    //   18: invokespecial 257	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   21: astore_2
    //   22: aload_2
    //   23: astore 4
    //   25: aload_3
    //   26: astore 5
    //   28: aload_2
    //   29: invokevirtual 260	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: pop
    //   33: aload_2
    //   34: astore 4
    //   36: aload_3
    //   37: astore 5
    //   39: aload_2
    //   40: invokevirtual 260	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: ldc_w 262
    //   46: iconst_2
    //   47: invokevirtual 266	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   50: iconst_1
    //   51: aaload
    //   52: invokevirtual 80	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   55: ldc_w 268
    //   58: ldc_w 270
    //   61: invokevirtual 274	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   64: invokevirtual 117	java/lang/String:trim	()Ljava/lang/String;
    //   67: invokestatic 280	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   70: lstore_0
    //   71: lload_0
    //   72: ldc2_w 281
    //   75: lmul
    //   76: lstore_0
    //   77: aload_2
    //   78: invokevirtual 285	java/io/BufferedReader:close	()V
    //   81: goto +15 -> 96
    //   84: astore_2
    //   85: aload_2
    //   86: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   89: ifne +7 -> 96
    //   92: aload_2
    //   93: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   96: aload_3
    //   97: invokevirtual 287	java/io/FileReader:close	()V
    //   100: lload_0
    //   101: lreturn
    //   102: astore_2
    //   103: aload_2
    //   104: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   107: ifne +7 -> 114
    //   110: aload_2
    //   111: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   114: lload_0
    //   115: lreturn
    //   116: astore 6
    //   118: goto +32 -> 150
    //   121: astore_2
    //   122: aconst_null
    //   123: astore 4
    //   125: goto +121 -> 246
    //   128: astore 6
    //   130: aconst_null
    //   131: astore_2
    //   132: goto +18 -> 150
    //   135: astore_2
    //   136: aconst_null
    //   137: astore_3
    //   138: aload_3
    //   139: astore 4
    //   141: goto +105 -> 246
    //   144: astore 6
    //   146: aconst_null
    //   147: astore_3
    //   148: aload_3
    //   149: astore_2
    //   150: aload_2
    //   151: astore 4
    //   153: aload_3
    //   154: astore 5
    //   156: ldc_w 289
    //   159: iconst_0
    //   160: anewarray 4	java/lang/Object
    //   163: invokestatic 44	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   166: pop
    //   167: aload_2
    //   168: astore 4
    //   170: aload_3
    //   171: astore 5
    //   173: aload 6
    //   175: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   178: ifne +14 -> 192
    //   181: aload_2
    //   182: astore 4
    //   184: aload_3
    //   185: astore 5
    //   187: aload 6
    //   189: invokevirtual 50	java/lang/Throwable:printStackTrace	()V
    //   192: aload_2
    //   193: ifnull +22 -> 215
    //   196: aload_2
    //   197: invokevirtual 285	java/io/BufferedReader:close	()V
    //   200: goto +15 -> 215
    //   203: astore_2
    //   204: aload_2
    //   205: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   208: ifne +7 -> 215
    //   211: aload_2
    //   212: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   215: aload_3
    //   216: ifnull +22 -> 238
    //   219: aload_3
    //   220: invokevirtual 287	java/io/FileReader:close	()V
    //   223: goto +15 -> 238
    //   226: astore_2
    //   227: aload_2
    //   228: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   231: ifne +7 -> 238
    //   234: aload_2
    //   235: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   238: ldc2_w 290
    //   241: lreturn
    //   242: astore_2
    //   243: aload 5
    //   245: astore_3
    //   246: aload 4
    //   248: ifnull +26 -> 274
    //   251: aload 4
    //   253: invokevirtual 285	java/io/BufferedReader:close	()V
    //   256: goto +18 -> 274
    //   259: astore 4
    //   261: aload 4
    //   263: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   266: ifne +8 -> 274
    //   269: aload 4
    //   271: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   274: aload_3
    //   275: ifnull +22 -> 297
    //   278: aload_3
    //   279: invokevirtual 287	java/io/FileReader:close	()V
    //   282: goto +15 -> 297
    //   285: astore_3
    //   286: aload_3
    //   287: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   290: ifne +7 -> 297
    //   293: aload_3
    //   294: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   297: aload_2
    //   298: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   70	45	0	l	long
    //   21	57	2	localBufferedReader	java.io.BufferedReader
    //   84	9	2	localIOException1	java.io.IOException
    //   102	9	2	localIOException2	java.io.IOException
    //   121	1	2	localObject1	Object
    //   131	1	2	localObject2	Object
    //   135	1	2	localObject3	Object
    //   149	48	2	localObject4	Object
    //   203	9	2	localIOException3	java.io.IOException
    //   226	9	2	localIOException4	java.io.IOException
    //   242	56	2	localObject5	Object
    //   9	270	3	localObject6	Object
    //   285	9	3	localIOException5	java.io.IOException
    //   23	229	4	localObject7	Object
    //   259	11	4	localIOException6	java.io.IOException
    //   26	218	5	localObject8	Object
    //   116	1	6	localThrowable1	Throwable
    //   128	1	6	localThrowable2	Throwable
    //   144	44	6	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   77	81	84	java/io/IOException
    //   96	100	102	java/io/IOException
    //   28	33	116	java/lang/Throwable
    //   39	71	116	java/lang/Throwable
    //   10	22	121	finally
    //   10	22	128	java/lang/Throwable
    //   0	10	135	finally
    //   0	10	144	java/lang/Throwable
    //   196	200	203	java/io/IOException
    //   219	223	226	java/io/IOException
    //   28	33	242	finally
    //   39	71	242	finally
    //   156	167	242	finally
    //   173	181	242	finally
    //   187	192	242	finally
    //   251	256	259	java/io/IOException
    //   278	282	285	java/io/IOException
  }
  
  public static String k()
  {
    try
    {
      String str = Locale.getDefault().getCountry();
      return str;
    }
    catch (Throwable localThrowable)
    {
      e.d("rqdp{  getCountry error!}", new Object[0]);
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String l()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    catch (Throwable localThrowable)
    {
      e.d("rqdp{  getBrand error!}", new Object[0]);
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  /* Error */
  public static long n()
  {
    // Byte code:
    //   0: new 313	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 315
    //   7: invokespecial 316	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: astore_3
    //   11: aload_3
    //   12: invokestatic 321	android/os/Process:myPid	()I
    //   15: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload_3
    //   20: ldc_w 327
    //   23: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_3
    //   28: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: astore_3
    //   32: aconst_null
    //   33: astore 4
    //   35: aconst_null
    //   36: astore 5
    //   38: aconst_null
    //   39: astore 8
    //   41: ldc_w 335
    //   44: invokestatic 341	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   47: invokevirtual 344	java/lang/Thread:getName	()Ljava/lang/String;
    //   50: invokevirtual 348	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq +11 -> 64
    //   56: ldc_w 350
    //   59: astore 6
    //   61: goto +40 -> 101
    //   64: new 313	java/lang/StringBuilder
    //   67: dup
    //   68: ldc_w 352
    //   71: invokespecial 316	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   74: astore 6
    //   76: aload 6
    //   78: invokestatic 355	android/os/Process:myTid	()I
    //   81: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 6
    //   87: ldc_w 357
    //   90: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 6
    //   96: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore 6
    //   101: ldc_w 359
    //   104: iconst_1
    //   105: anewarray 4	java/lang/Object
    //   108: dup
    //   109: iconst_0
    //   110: aload 6
    //   112: aastore
    //   113: invokestatic 361	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   116: pop
    //   117: new 249	java/io/FileReader
    //   120: dup
    //   121: aload_3
    //   122: invokespecial 252	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   125: astore_3
    //   126: aload_3
    //   127: astore 5
    //   129: new 254	java/io/BufferedReader
    //   132: dup
    //   133: aload_3
    //   134: sipush 2048
    //   137: invokespecial 257	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   140: astore 7
    //   142: aload 7
    //   144: invokevirtual 260	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   147: astore 4
    //   149: aload 4
    //   151: ifnull +161 -> 312
    //   154: aload 4
    //   156: aload 6
    //   158: invokevirtual 365	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   161: ifeq -19 -> 142
    //   164: aload 4
    //   166: ldc_w 367
    //   169: invokevirtual 370	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   172: astore 4
    //   174: aload 4
    //   176: arraylength
    //   177: ifle -35 -> 142
    //   180: aload 4
    //   182: iconst_0
    //   183: aaload
    //   184: ldc_w 372
    //   187: invokevirtual 376	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   190: istore_0
    //   191: iload_0
    //   192: ifle -50 -> 142
    //   195: aload 4
    //   197: iconst_0
    //   198: aaload
    //   199: invokevirtual 121	java/lang/String:length	()I
    //   202: iload_0
    //   203: if_icmple -61 -> 142
    //   206: aload 4
    //   208: iconst_0
    //   209: aaload
    //   210: iconst_0
    //   211: iload_0
    //   212: invokevirtual 380	java/lang/String:substring	(II)Ljava/lang/String;
    //   215: bipush 16
    //   217: invokestatic 383	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   220: lstore_1
    //   221: aload 4
    //   223: iconst_0
    //   224: aaload
    //   225: iload_0
    //   226: iconst_1
    //   227: iadd
    //   228: invokevirtual 386	java/lang/String:substring	(I)Ljava/lang/String;
    //   231: bipush 16
    //   233: invokestatic 383	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   236: lload_1
    //   237: lsub
    //   238: lstore_1
    //   239: ldc_w 388
    //   242: iconst_1
    //   243: anewarray 4	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: lload_1
    //   249: invokestatic 391	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   252: aastore
    //   253: invokestatic 361	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   256: pop
    //   257: lload_1
    //   258: lconst_0
    //   259: lcmp
    //   260: ifle +6 -> 266
    //   263: goto +6 -> 269
    //   266: lload_1
    //   267: lneg
    //   268: lstore_1
    //   269: aload 7
    //   271: invokevirtual 285	java/io/BufferedReader:close	()V
    //   274: goto +18 -> 292
    //   277: astore 4
    //   279: aload 4
    //   281: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   284: ifne +8 -> 292
    //   287: aload 4
    //   289: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   292: aload_3
    //   293: invokevirtual 287	java/io/FileReader:close	()V
    //   296: lload_1
    //   297: lreturn
    //   298: astore_3
    //   299: aload_3
    //   300: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   303: ifne +7 -> 310
    //   306: aload_3
    //   307: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   310: lload_1
    //   311: lreturn
    //   312: aload 7
    //   314: invokevirtual 285	java/io/BufferedReader:close	()V
    //   317: goto +18 -> 335
    //   320: astore 4
    //   322: aload 4
    //   324: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   327: ifne +8 -> 335
    //   330: aload 4
    //   332: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   335: aload_3
    //   336: invokevirtual 287	java/io/FileReader:close	()V
    //   339: goto +15 -> 354
    //   342: astore_3
    //   343: aload_3
    //   344: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   347: ifne +7 -> 354
    //   350: aload_3
    //   351: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   354: ldc2_w 171
    //   357: lreturn
    //   358: astore 4
    //   360: aload 7
    //   362: astore 5
    //   364: goto +145 -> 509
    //   367: astore 6
    //   369: goto +27 -> 396
    //   372: astore 6
    //   374: aload 8
    //   376: astore 7
    //   378: goto +18 -> 396
    //   381: astore 4
    //   383: aconst_null
    //   384: astore_3
    //   385: goto +124 -> 509
    //   388: astore 6
    //   390: aconst_null
    //   391: astore_3
    //   392: aload 8
    //   394: astore 7
    //   396: aload 7
    //   398: astore 4
    //   400: aload_3
    //   401: astore 5
    //   403: ldc_w 289
    //   406: iconst_0
    //   407: anewarray 4	java/lang/Object
    //   410: invokestatic 44	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   413: pop
    //   414: aload 7
    //   416: astore 4
    //   418: aload_3
    //   419: astore 5
    //   421: aload 6
    //   423: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   426: ifne +15 -> 441
    //   429: aload 7
    //   431: astore 4
    //   433: aload_3
    //   434: astore 5
    //   436: aload 6
    //   438: invokevirtual 50	java/lang/Throwable:printStackTrace	()V
    //   441: aload 7
    //   443: ifnull +26 -> 469
    //   446: aload 7
    //   448: invokevirtual 285	java/io/BufferedReader:close	()V
    //   451: goto +18 -> 469
    //   454: astore 4
    //   456: aload 4
    //   458: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   461: ifne +8 -> 469
    //   464: aload 4
    //   466: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   469: aload_3
    //   470: ifnull +22 -> 492
    //   473: aload_3
    //   474: invokevirtual 287	java/io/FileReader:close	()V
    //   477: goto +15 -> 492
    //   480: astore_3
    //   481: aload_3
    //   482: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   485: ifne +7 -> 492
    //   488: aload_3
    //   489: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   492: ldc2_w 290
    //   495: lreturn
    //   496: astore 6
    //   498: aload 5
    //   500: astore_3
    //   501: aload 4
    //   503: astore 5
    //   505: aload 6
    //   507: astore 4
    //   509: aload 5
    //   511: ifnull +26 -> 537
    //   514: aload 5
    //   516: invokevirtual 285	java/io/BufferedReader:close	()V
    //   519: goto +18 -> 537
    //   522: astore 5
    //   524: aload 5
    //   526: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   529: ifne +8 -> 537
    //   532: aload 5
    //   534: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   537: aload_3
    //   538: ifnull +22 -> 560
    //   541: aload_3
    //   542: invokevirtual 287	java/io/FileReader:close	()V
    //   545: goto +15 -> 560
    //   548: astore_3
    //   549: aload_3
    //   550: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   553: ifne +7 -> 560
    //   556: aload_3
    //   557: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   560: aload 4
    //   562: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   190	38	0	i	int
    //   220	91	1	l	long
    //   10	283	3	localObject1	Object
    //   298	38	3	localIOException1	java.io.IOException
    //   342	9	3	localIOException2	java.io.IOException
    //   384	90	3	localObject2	Object
    //   480	9	3	localIOException3	java.io.IOException
    //   500	42	3	localObject3	Object
    //   548	9	3	localIOException4	java.io.IOException
    //   33	189	4	localObject4	Object
    //   277	11	4	localIOException5	java.io.IOException
    //   320	11	4	localIOException6	java.io.IOException
    //   358	1	4	localObject5	Object
    //   381	1	4	localObject6	Object
    //   398	34	4	localObject7	Object
    //   454	48	4	localIOException7	java.io.IOException
    //   507	54	4	localObject8	Object
    //   36	479	5	localObject9	Object
    //   522	11	5	localIOException8	java.io.IOException
    //   59	98	6	localObject10	Object
    //   367	1	6	localThrowable1	Throwable
    //   372	1	6	localThrowable2	Throwable
    //   388	49	6	localThrowable3	Throwable
    //   496	10	6	localObject11	Object
    //   140	307	7	localObject12	Object
    //   39	354	8	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   269	274	277	java/io/IOException
    //   292	296	298	java/io/IOException
    //   312	317	320	java/io/IOException
    //   335	339	342	java/io/IOException
    //   142	149	358	finally
    //   154	191	358	finally
    //   195	257	358	finally
    //   142	149	367	java/lang/Throwable
    //   154	191	367	java/lang/Throwable
    //   195	257	367	java/lang/Throwable
    //   129	142	372	java/lang/Throwable
    //   41	56	381	finally
    //   64	101	381	finally
    //   101	126	381	finally
    //   41	56	388	java/lang/Throwable
    //   64	101	388	java/lang/Throwable
    //   101	126	388	java/lang/Throwable
    //   446	451	454	java/io/IOException
    //   473	477	480	java/io/IOException
    //   129	142	496	finally
    //   403	414	496	finally
    //   421	429	496	finally
    //   436	441	496	finally
    //   514	519	522	java/io/IOException
    //   541	545	548	java/io/IOException
  }
  
  /* Error */
  public static long o()
  {
    // Byte code:
    //   0: new 313	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 315
    //   7: invokespecial 316	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: astore 5
    //   12: aload 5
    //   14: invokestatic 321	android/os/Process:myPid	()I
    //   17: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload 5
    //   23: ldc_w 327
    //   26: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 5
    //   32: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore 5
    //   37: new 249	java/io/FileReader
    //   40: dup
    //   41: aload 5
    //   43: invokespecial 252	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   46: astore 6
    //   48: new 254	java/io/BufferedReader
    //   51: dup
    //   52: aload 6
    //   54: sipush 2048
    //   57: invokespecial 257	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   60: astore 5
    //   62: lconst_0
    //   63: lstore_1
    //   64: aload 5
    //   66: astore 7
    //   68: aload 6
    //   70: astore 8
    //   72: aload 5
    //   74: invokevirtual 260	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   77: astore 9
    //   79: aload 9
    //   81: ifnull +190 -> 271
    //   84: aload 5
    //   86: astore 7
    //   88: aload 6
    //   90: astore 8
    //   92: aload 9
    //   94: ldc_w 394
    //   97: invokevirtual 365	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   100: ifeq -36 -> 64
    //   103: aload 5
    //   105: astore 7
    //   107: aload 6
    //   109: astore 8
    //   111: aload 9
    //   113: ldc_w 367
    //   116: invokevirtual 370	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   119: astore 9
    //   121: aload 5
    //   123: astore 7
    //   125: aload 6
    //   127: astore 8
    //   129: aload 9
    //   131: arraylength
    //   132: ifle -68 -> 64
    //   135: aload 5
    //   137: astore 7
    //   139: aload 6
    //   141: astore 8
    //   143: aload 9
    //   145: iconst_0
    //   146: aaload
    //   147: ldc_w 372
    //   150: invokevirtual 376	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   153: istore_0
    //   154: iload_0
    //   155: ifle -91 -> 64
    //   158: aload 5
    //   160: astore 7
    //   162: aload 6
    //   164: astore 8
    //   166: aload 9
    //   168: iconst_0
    //   169: aaload
    //   170: invokevirtual 121	java/lang/String:length	()I
    //   173: iload_0
    //   174: if_icmple -110 -> 64
    //   177: aload 5
    //   179: astore 7
    //   181: aload 6
    //   183: astore 8
    //   185: aload 9
    //   187: iconst_0
    //   188: aaload
    //   189: iconst_0
    //   190: iload_0
    //   191: invokevirtual 380	java/lang/String:substring	(II)Ljava/lang/String;
    //   194: bipush 16
    //   196: invokestatic 383	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   199: lstore_3
    //   200: aload 5
    //   202: astore 7
    //   204: aload 6
    //   206: astore 8
    //   208: aload 9
    //   210: iconst_0
    //   211: aaload
    //   212: iload_0
    //   213: iconst_1
    //   214: iadd
    //   215: invokevirtual 386	java/lang/String:substring	(I)Ljava/lang/String;
    //   218: bipush 16
    //   220: invokestatic 383	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   223: lload_3
    //   224: lsub
    //   225: lstore_3
    //   226: aload 5
    //   228: astore 7
    //   230: aload 6
    //   232: astore 8
    //   234: ldc_w 396
    //   237: iconst_1
    //   238: anewarray 4	java/lang/Object
    //   241: dup
    //   242: iconst_0
    //   243: lload_3
    //   244: invokestatic 391	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   247: aastore
    //   248: invokestatic 361	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   251: pop
    //   252: lload_3
    //   253: lconst_0
    //   254: lcmp
    //   255: ifle +6 -> 261
    //   258: goto +6 -> 264
    //   261: lload_3
    //   262: lneg
    //   263: lstore_3
    //   264: lload_1
    //   265: lload_3
    //   266: ladd
    //   267: lstore_1
    //   268: goto -204 -> 64
    //   271: aload 5
    //   273: invokevirtual 285	java/io/BufferedReader:close	()V
    //   276: goto +18 -> 294
    //   279: astore 5
    //   281: aload 5
    //   283: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   286: ifne +8 -> 294
    //   289: aload 5
    //   291: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   294: aload 6
    //   296: invokevirtual 287	java/io/FileReader:close	()V
    //   299: lload_1
    //   300: lreturn
    //   301: astore 5
    //   303: aload 5
    //   305: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   308: ifne +8 -> 316
    //   311: aload 5
    //   313: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   316: lload_1
    //   317: lreturn
    //   318: astore 9
    //   320: goto +40 -> 360
    //   323: astore 5
    //   325: aconst_null
    //   326: astore 7
    //   328: goto +146 -> 474
    //   331: astore 9
    //   333: aconst_null
    //   334: astore 5
    //   336: goto +24 -> 360
    //   339: astore 5
    //   341: aconst_null
    //   342: astore 6
    //   344: aload 6
    //   346: astore 7
    //   348: goto +126 -> 474
    //   351: astore 9
    //   353: aconst_null
    //   354: astore 6
    //   356: aload 6
    //   358: astore 5
    //   360: aload 5
    //   362: astore 7
    //   364: aload 6
    //   366: astore 8
    //   368: ldc_w 289
    //   371: iconst_0
    //   372: anewarray 4	java/lang/Object
    //   375: invokestatic 44	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   378: pop
    //   379: aload 5
    //   381: astore 7
    //   383: aload 6
    //   385: astore 8
    //   387: aload 9
    //   389: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   392: ifne +16 -> 408
    //   395: aload 5
    //   397: astore 7
    //   399: aload 6
    //   401: astore 8
    //   403: aload 9
    //   405: invokevirtual 50	java/lang/Throwable:printStackTrace	()V
    //   408: aload 5
    //   410: ifnull +26 -> 436
    //   413: aload 5
    //   415: invokevirtual 285	java/io/BufferedReader:close	()V
    //   418: goto +18 -> 436
    //   421: astore 5
    //   423: aload 5
    //   425: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   428: ifne +8 -> 436
    //   431: aload 5
    //   433: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   436: aload 6
    //   438: ifnull +26 -> 464
    //   441: aload 6
    //   443: invokevirtual 287	java/io/FileReader:close	()V
    //   446: goto +18 -> 464
    //   449: astore 5
    //   451: aload 5
    //   453: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   456: ifne +8 -> 464
    //   459: aload 5
    //   461: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   464: ldc2_w 290
    //   467: lreturn
    //   468: astore 5
    //   470: aload 8
    //   472: astore 6
    //   474: aload 7
    //   476: ifnull +26 -> 502
    //   479: aload 7
    //   481: invokevirtual 285	java/io/BufferedReader:close	()V
    //   484: goto +18 -> 502
    //   487: astore 7
    //   489: aload 7
    //   491: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   494: ifne +8 -> 502
    //   497: aload 7
    //   499: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   502: aload 6
    //   504: ifnull +26 -> 530
    //   507: aload 6
    //   509: invokevirtual 287	java/io/FileReader:close	()V
    //   512: goto +18 -> 530
    //   515: astore 6
    //   517: aload 6
    //   519: invokestatic 47	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   522: ifne +8 -> 530
    //   525: aload 6
    //   527: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   530: aload 5
    //   532: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   153	62	0	i	int
    //   63	254	1	l1	long
    //   199	67	3	l2	long
    //   10	262	5	localObject1	Object
    //   279	11	5	localIOException1	java.io.IOException
    //   301	11	5	localIOException2	java.io.IOException
    //   323	1	5	localObject2	Object
    //   334	1	5	localObject3	Object
    //   339	1	5	localObject4	Object
    //   358	56	5	localObject5	Object
    //   421	11	5	localIOException3	java.io.IOException
    //   449	11	5	localIOException4	java.io.IOException
    //   468	63	5	localObject6	Object
    //   46	462	6	localObject7	Object
    //   515	11	6	localIOException5	java.io.IOException
    //   66	414	7	localObject8	Object
    //   487	11	7	localIOException6	java.io.IOException
    //   70	401	8	localObject9	Object
    //   77	132	9	localObject10	Object
    //   318	1	9	localThrowable1	Throwable
    //   331	1	9	localThrowable2	Throwable
    //   351	53	9	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   271	276	279	java/io/IOException
    //   294	299	301	java/io/IOException
    //   72	79	318	java/lang/Throwable
    //   92	103	318	java/lang/Throwable
    //   111	121	318	java/lang/Throwable
    //   129	135	318	java/lang/Throwable
    //   143	154	318	java/lang/Throwable
    //   166	177	318	java/lang/Throwable
    //   185	200	318	java/lang/Throwable
    //   208	226	318	java/lang/Throwable
    //   234	252	318	java/lang/Throwable
    //   48	62	323	finally
    //   48	62	331	java/lang/Throwable
    //   37	48	339	finally
    //   37	48	351	java/lang/Throwable
    //   413	418	421	java/io/IOException
    //   441	446	449	java/io/IOException
    //   72	79	468	finally
    //   92	103	468	finally
    //   111	121	468	finally
    //   129	135	468	finally
    //   143	154	468	finally
    //   166	177	468	finally
    //   185	200	468	finally
    //   208	226	468	finally
    //   234	252	468	finally
    //   368	379	468	finally
    //   387	395	468	finally
    //   403	408	468	finally
    //   479	484	487	java/io/IOException
    //   507	512	515	java/io/IOException
  }
  
  public final long i()
  {
    if (!Environment.getExternalStorageState().equals("mounted")) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int i = localStatFs.getBlockSize();
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
    if (!Environment.getExternalStorageState().equals("mounted")) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int i = localStatFs.getBlockSize();
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