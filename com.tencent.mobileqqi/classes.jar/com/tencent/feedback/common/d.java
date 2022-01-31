package com.tencent.feedback.common;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
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
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Locale;

public final class d
{
  private static d a;
  
  private d(Context paramContext)
  {
    paramContext.getApplicationContext();
  }
  
  public static d a(Context paramContext)
  {
    try
    {
      if ((a == null) && (paramContext != null)) {
        a = new d(paramContext.getApplicationContext());
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
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
      localThrowable.printStackTrace();
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
      localThrowable.printStackTrace();
    }
    return "fail";
  }
  
  public static String b(Context paramContext)
  {
    String str = "fail";
    if (paramContext == null)
    {
      e.d("rqdp{  getImei but context == null!}", new Object[0]);
      return "fail";
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
        paramContext = (Context)localObject;
        Object localObject = localThrowable2;
        continue;
      }
      e.d("rqdp{  getImei error!}", new Object[0]);
      localThrowable1.printStackTrace();
      return paramContext;
      localObject = paramContext;
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
      localThrowable.printStackTrace();
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
      paramContext.printStackTrace();
    }
    return localObject;
  }
  
  public static String d()
  {
    try
    {
      String str = System.getProperty("os.arch");
      return str;
    }
    catch (Throwable localThrowable)
    {
      e.c("rqdp{  ge cuabi fa!}", new Object[0]);
      localThrowable.printStackTrace();
    }
    return "fail";
  }
  
  public static String d(Context paramContext)
  {
    String str2 = "fail";
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
      String str1;
      e.d("rqdp{  getAndroidId error!}", new Object[0]);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        str1 = paramContext.toLowerCase();
        return str1;
      }
      catch (Throwable localThrowable2)
      {
        break label46;
      }
      localThrowable1 = localThrowable1;
      paramContext = str2;
    }
    label46:
    localThrowable1.printStackTrace();
    return paramContext;
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
      paramContext.printStackTrace();
      e.d("rqdp{  getMacAddress error!}", new Object[0]);
    }
    return localObject;
  }
  
  /* Error */
  public static byte[] e()
  {
    // Byte code:
    //   0: new 156	java/io/File
    //   3: dup
    //   4: ldc 158
    //   6: invokespecial 159	java/io/File:<init>	(Ljava/lang/String;)V
    //   9: astore_3
    //   10: aload_3
    //   11: invokevirtual 163	java/io/File:exists	()Z
    //   14: ifeq +177 -> 191
    //   17: aload_3
    //   18: invokevirtual 166	java/io/File:canRead	()Z
    //   21: ifeq +170 -> 191
    //   24: new 168	java/io/FileInputStream
    //   27: dup
    //   28: aload_3
    //   29: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: astore 4
    //   34: aload 4
    //   36: astore_3
    //   37: new 173	java/io/ByteArrayOutputStream
    //   40: dup
    //   41: invokespecial 174	java/io/ByteArrayOutputStream:<init>	()V
    //   44: astore 5
    //   46: aload 4
    //   48: astore_3
    //   49: sipush 1000
    //   52: newarray byte
    //   54: astore 6
    //   56: lconst_0
    //   57: lstore_1
    //   58: aload 4
    //   60: astore_3
    //   61: aload 4
    //   63: aload 6
    //   65: invokevirtual 178	java/io/FileInputStream:read	([B)I
    //   68: istore_0
    //   69: iload_0
    //   70: ifle +31 -> 101
    //   73: aload 4
    //   75: astore_3
    //   76: aload 5
    //   78: aload 6
    //   80: iconst_0
    //   81: iload_0
    //   82: invokevirtual 182	java/io/ByteArrayOutputStream:write	([BII)V
    //   85: aload 4
    //   87: astore_3
    //   88: aload 5
    //   90: invokevirtual 185	java/io/ByteArrayOutputStream:flush	()V
    //   93: lload_1
    //   94: iload_0
    //   95: i2l
    //   96: ladd
    //   97: lstore_1
    //   98: goto -40 -> 58
    //   101: aload 4
    //   103: astore_3
    //   104: aload 5
    //   106: invokevirtual 188	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   109: astore 5
    //   111: aload 4
    //   113: astore_3
    //   114: ldc 190
    //   116: iconst_2
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: lload_1
    //   123: invokestatic 196	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   126: aastore
    //   127: dup
    //   128: iconst_1
    //   129: aload 5
    //   131: arraylength
    //   132: i2l
    //   133: invokestatic 196	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   136: aastore
    //   137: invokestatic 85	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload 4
    //   142: invokevirtual 199	java/io/FileInputStream:close	()V
    //   145: aload 5
    //   147: areturn
    //   148: astore_3
    //   149: aload_3
    //   150: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   153: aload 5
    //   155: areturn
    //   156: astore 5
    //   158: aconst_null
    //   159: astore 4
    //   161: aload 4
    //   163: astore_3
    //   164: ldc 115
    //   166: iconst_0
    //   167: anewarray 4	java/lang/Object
    //   170: invokestatic 117	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: aload 4
    //   175: astore_3
    //   176: aload 5
    //   178: invokevirtual 43	java/lang/Throwable:printStackTrace	()V
    //   181: aload 4
    //   183: ifnull +8 -> 191
    //   186: aload 4
    //   188: invokevirtual 199	java/io/FileInputStream:close	()V
    //   191: aconst_null
    //   192: areturn
    //   193: astore_3
    //   194: aload_3
    //   195: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   198: goto -7 -> 191
    //   201: astore 4
    //   203: aconst_null
    //   204: astore_3
    //   205: aload_3
    //   206: ifnull +7 -> 213
    //   209: aload_3
    //   210: invokevirtual 199	java/io/FileInputStream:close	()V
    //   213: aload 4
    //   215: athrow
    //   216: astore_3
    //   217: aload_3
    //   218: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   221: goto -8 -> 213
    //   224: astore 4
    //   226: goto -21 -> 205
    //   229: astore 5
    //   231: goto -70 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   68	27	0	i	int
    //   57	66	1	l	long
    //   9	105	3	localObject1	Object
    //   148	2	3	localIOException1	java.io.IOException
    //   163	13	3	localObject2	Object
    //   193	2	3	localIOException2	java.io.IOException
    //   204	6	3	localObject3	Object
    //   216	2	3	localIOException3	java.io.IOException
    //   32	155	4	localFileInputStream	java.io.FileInputStream
    //   201	13	4	localObject4	Object
    //   224	1	4	localObject5	Object
    //   44	110	5	localObject6	Object
    //   156	21	5	localThrowable1	Throwable
    //   229	1	5	localThrowable2	Throwable
    //   54	25	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   140	145	148	java/io/IOException
    //   0	34	156	java/lang/Throwable
    //   186	191	193	java/io/IOException
    //   0	34	201	finally
    //   209	213	216	java/io/IOException
    //   37	46	224	finally
    //   49	56	224	finally
    //   61	69	224	finally
    //   76	85	224	finally
    //   88	93	224	finally
    //   104	111	224	finally
    //   114	140	224	finally
    //   164	173	224	finally
    //   176	181	224	finally
    //   37	46	229	java/lang/Throwable
    //   49	56	229	java/lang/Throwable
    //   61	69	229	java/lang/Throwable
    //   76	85	229	java/lang/Throwable
    //   88	93	229	java/lang/Throwable
    //   104	111	229	java/lang/Throwable
    //   114	140	229	java/lang/Throwable
  }
  
  public static String f()
  {
    try
    {
      Object localObject = Build.class.getField("HARDWARE").get(null);
      if (localObject != null)
      {
        localObject = localObject.toString();
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      e.c("rqdp{getCpuProductorName error!}", new Object[0]);
    }
    return "fail";
  }
  
  public static String f(Context paramContext)
  {
    if (paramContext == null)
    {
      e.d("rqdp{  getMacAddress but context == null!}", new Object[0]);
      return "fail";
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getBSSID();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      e.d("rqdp{  getMacAddress error!}", new Object[0]);
    }
    return "fail";
  }
  
  public static DisplayMetrics g(Context paramContext)
  {
    if (paramContext == null)
    {
      e.d("rqdp{  getDisplayMetrics but context == null!}", new Object[0]);
      return null;
    }
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      return localDisplayMetrics;
    }
    catch (Throwable paramContext)
    {
      e.d("rqdp{  getDisplayMetrics error!}", new Object[0]);
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String g()
  {
    try
    {
      Object localObject = new StatFs(Environment.getDataDirectory().getPath());
      long l1 = ((StatFs)localObject).getBlockSize();
      long l2 = ((StatFs)localObject).getBlockCount();
      localObject = l2 * l1 / 1024L / 1024L;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      e.d("rqdp{  getDisplayMetrics error!}", new Object[0]);
      localThrowable.printStackTrace();
    }
    return "fail";
  }
  
  public static long h(Context paramContext)
  {
    if (paramContext == null)
    {
      e.d("rqdp{  getFreeMem but context == null!}", new Object[0]);
      return -2L;
    }
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      paramContext.getMemoryInfo(localMemoryInfo);
      long l = localMemoryInfo.availMem;
      return l;
    }
    catch (Throwable paramContext)
    {
      e.d("rqdp{  getFreeMem error!}", new Object[0]);
      paramContext.printStackTrace();
    }
    return -2L;
  }
  
  /* Error */
  public static String h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 294	java/io/FileReader
    //   5: dup
    //   6: ldc_w 296
    //   9: invokespecial 297	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   12: astore 4
    //   14: new 299	java/io/BufferedReader
    //   17: dup
    //   18: aload 4
    //   20: sipush 8192
    //   23: invokespecial 302	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   26: astore_2
    //   27: aload_2
    //   28: invokevirtual 305	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: ldc_w 307
    //   34: iconst_2
    //   35: invokevirtual 311	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   38: iconst_1
    //   39: aaload
    //   40: invokevirtual 92	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   43: ldc_w 313
    //   46: ldc_w 315
    //   49: invokevirtual 319	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   52: invokevirtual 322	java/lang/String:trim	()Ljava/lang/String;
    //   55: invokestatic 326	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   58: ldc2_w 265
    //   61: ldiv
    //   62: lstore_0
    //   63: new 71	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   70: lload_0
    //   71: invokevirtual 269	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   74: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore_3
    //   78: aload_2
    //   79: invokevirtual 327	java/io/BufferedReader:close	()V
    //   82: aload 4
    //   84: invokevirtual 328	java/io/FileReader:close	()V
    //   87: aload_3
    //   88: areturn
    //   89: astore_2
    //   90: ldc_w 292
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokestatic 40	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: aload_2
    //   101: invokevirtual 43	java/lang/Throwable:printStackTrace	()V
    //   104: aload_3
    //   105: areturn
    //   106: astore 4
    //   108: aconst_null
    //   109: astore_2
    //   110: ldc_w 292
    //   113: iconst_0
    //   114: anewarray 4	java/lang/Object
    //   117: invokestatic 40	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: aload 4
    //   122: invokevirtual 43	java/lang/Throwable:printStackTrace	()V
    //   125: aload_2
    //   126: ifnull +7 -> 133
    //   129: aload_2
    //   130: invokevirtual 327	java/io/BufferedReader:close	()V
    //   133: aload_3
    //   134: ifnull +7 -> 141
    //   137: aload_3
    //   138: invokevirtual 328	java/io/FileReader:close	()V
    //   141: ldc_w 330
    //   144: areturn
    //   145: astore_2
    //   146: ldc_w 292
    //   149: iconst_0
    //   150: anewarray 4	java/lang/Object
    //   153: invokestatic 40	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: aload_2
    //   157: invokevirtual 43	java/lang/Throwable:printStackTrace	()V
    //   160: goto -19 -> 141
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_2
    //   166: aconst_null
    //   167: astore 4
    //   169: aload_2
    //   170: ifnull +7 -> 177
    //   173: aload_2
    //   174: invokevirtual 327	java/io/BufferedReader:close	()V
    //   177: aload 4
    //   179: ifnull +8 -> 187
    //   182: aload 4
    //   184: invokevirtual 328	java/io/FileReader:close	()V
    //   187: aload_3
    //   188: athrow
    //   189: astore_2
    //   190: ldc_w 292
    //   193: iconst_0
    //   194: anewarray 4	java/lang/Object
    //   197: invokestatic 40	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: aload_2
    //   201: invokevirtual 43	java/lang/Throwable:printStackTrace	()V
    //   204: goto -17 -> 187
    //   207: astore_3
    //   208: aconst_null
    //   209: astore_2
    //   210: goto -41 -> 169
    //   213: astore_3
    //   214: goto -45 -> 169
    //   217: astore 5
    //   219: aload_3
    //   220: astore 4
    //   222: aload 5
    //   224: astore_3
    //   225: goto -56 -> 169
    //   228: astore 5
    //   230: aconst_null
    //   231: astore_2
    //   232: aload 4
    //   234: astore_3
    //   235: aload 5
    //   237: astore 4
    //   239: goto -129 -> 110
    //   242: astore 5
    //   244: aload 4
    //   246: astore_3
    //   247: aload 5
    //   249: astore 4
    //   251: goto -141 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   62	9	0	l	long
    //   26	53	2	localBufferedReader	java.io.BufferedReader
    //   89	12	2	localThrowable1	Throwable
    //   109	21	2	localObject1	Object
    //   145	12	2	localThrowable2	Throwable
    //   165	9	2	localObject2	Object
    //   189	12	2	localThrowable3	Throwable
    //   209	23	2	localObject3	Object
    //   1	137	3	str	String
    //   163	25	3	localObject4	Object
    //   207	1	3	localObject5	Object
    //   213	7	3	localObject6	Object
    //   224	23	3	localObject7	Object
    //   12	71	4	localFileReader	java.io.FileReader
    //   106	15	4	localThrowable4	Throwable
    //   167	83	4	localObject8	Object
    //   217	6	5	localObject9	Object
    //   228	8	5	localThrowable5	Throwable
    //   242	6	5	localThrowable6	Throwable
    // Exception table:
    //   from	to	target	type
    //   78	87	89	java/lang/Throwable
    //   2	14	106	java/lang/Throwable
    //   129	133	145	java/lang/Throwable
    //   137	141	145	java/lang/Throwable
    //   2	14	163	finally
    //   173	177	189	java/lang/Throwable
    //   182	187	189	java/lang/Throwable
    //   14	27	207	finally
    //   27	78	213	finally
    //   110	125	217	finally
    //   14	27	228	java/lang/Throwable
    //   27	78	242	java/lang/Throwable
  }
  
  public static long i()
  {
    try
    {
      StatFs localStatFs = new StatFs("/data");
      int i = localStatFs.getBlockSize();
      int j = localStatFs.getAvailableBlocks();
      long l = j;
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      e.d("rqdp{  getFreeStorage error!}", new Object[0]);
      localThrowable.printStackTrace();
    }
    return -2L;
  }
  
  public static String i(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return "unknown";
      }
      if (localNetworkInfo.getType() == 1)
      {
        paramContext = "wifi";
      }
      else if (localNetworkInfo.getType() == 0)
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null) {
          switch (paramContext.getNetworkType())
          {
          case 15: 
            paramContext = "HSPA+";
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramContext = "unknown";
    }
    for (;;)
    {
      return paramContext;
      paramContext = "unknown";
      continue;
      paramContext = "GPRS";
      continue;
      paramContext = "EDGE";
      continue;
      paramContext = "UMTS";
      continue;
      paramContext = "HSDPA";
      continue;
      paramContext = "HSUPA";
      continue;
      paramContext = "HSPA";
      continue;
      paramContext = "CDMA";
      continue;
      paramContext = "EVDO_0";
      continue;
      paramContext = "EVDO_A";
      continue;
      paramContext = "1xRTT";
      continue;
      paramContext = "iDen";
      continue;
      paramContext = "EVDO_B";
      continue;
      paramContext = "LTE";
      continue;
      paramContext = "eHRPD";
    }
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
      localThrowable.printStackTrace();
    }
    return "fail";
  }
  
  public static String l()
  {
    try
    {
      String str = Locale.getDefault().getLanguage();
      return str;
    }
    catch (Throwable localThrowable)
    {
      e.d("rqdp{  getLanguage error!}", new Object[0]);
      localThrowable.printStackTrace();
    }
    return "fail";
  }
  
  public static String m()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    catch (Throwable localThrowable)
    {
      e.d("rqdp{  getBrand error!}", new Object[0]);
      localThrowable.printStackTrace();
    }
    return "fail";
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
      localThrowable.printStackTrace();
    }
    return -2L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.common.d
 * JD-Core Version:    0.7.0.1
 */