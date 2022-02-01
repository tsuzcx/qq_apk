package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zj
{
  public static boolean a = true;
  public static long b;
  public static long c;
  
  public static long a()
  {
    a = false;
    return c - b;
  }
  
  public static String a(Context paramContext)
  {
    String str = zk.a;
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        return paramContext.getDeviceId();
      }
      paramContext = zk.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return str;
  }
  
  public static String b()
  {
    String str = "";
    Object localObject1;
    try
    {
      Object localObject2 = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/class/power_supply/Battery/capacity" }).start().getInputStream();
      localObject1 = new byte[24];
      Object localObject3;
      while (((InputStream)localObject2).read((byte[])localObject1) != -1)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(str);
        ((StringBuilder)localObject3).append(new String((byte[])localObject1));
        str = ((StringBuilder)localObject3).toString();
      }
      localObject1 = str;
      if (str.length() == 0)
      {
        localObject3 = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/class/power_supply/battery/capacity" }).start().getInputStream();
        byte[] arrayOfByte = new byte[24];
        for (;;)
        {
          localObject1 = str;
          localObject2 = localObject3;
          if (((InputStream)localObject3).read(arrayOfByte) == -1) {
            break;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(new String(arrayOfByte));
          str = ((StringBuilder)localObject1).toString();
        }
      }
      ((InputStream)localObject2).close();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject1 = zk.a;
    }
    return ((String)localObject1).trim();
  }
  
  public static String b(Context paramContext)
  {
    String str = zk.a;
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        return paramContext.getSubscriberId();
      }
      paramContext = zk.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return str;
  }
  
  public static String c()
  {
    String str = zk.a;
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class }).invoke(localObject, new Object[] { "ro.serialno" });
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return str;
  }
  
  public static String c(Context paramContext)
  {
    String str = zk.a;
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        return paramContext.getLine1Number();
      }
      paramContext = zk.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return str;
  }
  
  /* Error */
  public static String d()
  {
    // Byte code:
    //   0: getstatic 28	com/tencent/token/zk:a	Ljava/lang/String;
    //   3: astore 5
    //   5: new 132	java/io/FileInputStream
    //   8: dup
    //   9: ldc 134
    //   11: invokespecial 137	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: new 139	java/io/BufferedReader
    //   18: dup
    //   19: new 141	java/io/InputStreamReader
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 144	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   27: sipush 8192
    //   30: invokespecial 147	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: astore 6
    //   35: ldc 47
    //   37: astore_3
    //   38: aload_0
    //   39: astore_1
    //   40: aload 6
    //   42: astore_2
    //   43: aload 6
    //   45: invokevirtual 150	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore 4
    //   50: aload 4
    //   52: ifnull +56 -> 108
    //   55: aload_0
    //   56: astore_1
    //   57: aload 6
    //   59: astore_2
    //   60: new 77	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   67: astore 7
    //   69: aload_0
    //   70: astore_1
    //   71: aload 6
    //   73: astore_2
    //   74: aload 7
    //   76: aload_3
    //   77: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_0
    //   82: astore_1
    //   83: aload 6
    //   85: astore_2
    //   86: aload 7
    //   88: aload 4
    //   90: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_0
    //   95: astore_1
    //   96: aload 6
    //   98: astore_2
    //   99: aload 7
    //   101: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore_3
    //   105: goto -67 -> 38
    //   108: aload 5
    //   110: astore_1
    //   111: aload_3
    //   112: ldc 47
    //   114: if_acmpeq +41 -> 155
    //   117: aload_0
    //   118: astore_1
    //   119: aload 6
    //   121: astore_2
    //   122: aload_3
    //   123: aload_3
    //   124: ldc 152
    //   126: invokevirtual 156	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   129: bipush 8
    //   131: iadd
    //   132: invokevirtual 160	java/lang/String:substring	(I)Ljava/lang/String;
    //   135: astore_3
    //   136: aload_0
    //   137: astore_1
    //   138: aload 6
    //   140: astore_2
    //   141: aload_3
    //   142: iconst_0
    //   143: aload_3
    //   144: ldc 162
    //   146: invokevirtual 156	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   149: invokevirtual 165	java/lang/String:substring	(II)Ljava/lang/String;
    //   152: astore_3
    //   153: aload_3
    //   154: astore_1
    //   155: aload_1
    //   156: astore_2
    //   157: aload 6
    //   159: invokevirtual 166	java/io/BufferedReader:close	()V
    //   162: aload_1
    //   163: astore_2
    //   164: aload_0
    //   165: invokevirtual 98	java/io/InputStream:close	()V
    //   168: aload_1
    //   169: areturn
    //   170: astore_0
    //   171: aload_0
    //   172: invokevirtual 45	java/lang/Exception:printStackTrace	()V
    //   175: aload_2
    //   176: areturn
    //   177: astore 4
    //   179: aload_0
    //   180: astore_3
    //   181: aload 6
    //   183: astore_0
    //   184: goto +34 -> 218
    //   187: astore_1
    //   188: aconst_null
    //   189: astore_2
    //   190: goto +67 -> 257
    //   193: astore 4
    //   195: aconst_null
    //   196: astore_1
    //   197: aload_0
    //   198: astore_3
    //   199: aload_1
    //   200: astore_0
    //   201: goto +17 -> 218
    //   204: astore_1
    //   205: aconst_null
    //   206: astore_0
    //   207: aload_0
    //   208: astore_2
    //   209: goto +48 -> 257
    //   212: astore 4
    //   214: aconst_null
    //   215: astore_0
    //   216: aload_0
    //   217: astore_3
    //   218: aload_3
    //   219: astore_1
    //   220: aload_0
    //   221: astore_2
    //   222: aload 4
    //   224: invokevirtual 45	java/lang/Exception:printStackTrace	()V
    //   227: aload_0
    //   228: ifnull +10 -> 238
    //   231: aload 5
    //   233: astore_2
    //   234: aload_0
    //   235: invokevirtual 166	java/io/BufferedReader:close	()V
    //   238: aload_3
    //   239: ifnull +10 -> 249
    //   242: aload 5
    //   244: astore_2
    //   245: aload_3
    //   246: invokevirtual 98	java/io/InputStream:close	()V
    //   249: aload 5
    //   251: areturn
    //   252: astore_3
    //   253: aload_1
    //   254: astore_0
    //   255: aload_3
    //   256: astore_1
    //   257: aload_2
    //   258: ifnull +10 -> 268
    //   261: aload_2
    //   262: invokevirtual 166	java/io/BufferedReader:close	()V
    //   265: goto +3 -> 268
    //   268: aload_0
    //   269: ifnull +14 -> 283
    //   272: aload_0
    //   273: invokevirtual 98	java/io/InputStream:close	()V
    //   276: goto +7 -> 283
    //   279: aload_0
    //   280: invokevirtual 45	java/lang/Exception:printStackTrace	()V
    //   283: aload_1
    //   284: athrow
    //   285: astore_0
    //   286: goto -7 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	151	0	localFileInputStream	java.io.FileInputStream
    //   170	10	0	localException1	Exception
    //   183	97	0	localObject1	Object
    //   285	1	0	localException2	Exception
    //   39	130	1	localObject2	Object
    //   187	1	1	localObject3	Object
    //   196	4	1	localObject4	Object
    //   204	1	1	localObject5	Object
    //   219	65	1	localObject6	Object
    //   42	220	2	localObject7	Object
    //   37	209	3	localObject8	Object
    //   252	4	3	localObject9	Object
    //   48	41	4	str1	String
    //   177	1	4	localException3	Exception
    //   193	1	4	localException4	Exception
    //   212	11	4	localException5	Exception
    //   3	247	5	str2	String
    //   33	149	6	localBufferedReader	java.io.BufferedReader
    //   67	33	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   157	162	170	java/lang/Exception
    //   164	168	170	java/lang/Exception
    //   234	238	170	java/lang/Exception
    //   245	249	170	java/lang/Exception
    //   43	50	177	java/lang/Exception
    //   60	69	177	java/lang/Exception
    //   74	81	177	java/lang/Exception
    //   86	94	177	java/lang/Exception
    //   99	105	177	java/lang/Exception
    //   122	136	177	java/lang/Exception
    //   141	153	177	java/lang/Exception
    //   15	35	187	finally
    //   15	35	193	java/lang/Exception
    //   5	15	204	finally
    //   5	15	212	java/lang/Exception
    //   43	50	252	finally
    //   60	69	252	finally
    //   74	81	252	finally
    //   86	94	252	finally
    //   99	105	252	finally
    //   122	136	252	finally
    //   141	153	252	finally
    //   222	227	252	finally
    //   261	265	285	java/lang/Exception
    //   272	276	285	java/lang/Exception
  }
  
  public static String d(Context paramContext)
  {
    String str = zk.a;
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext.getMacAddress() != null)
      {
        paramContext = paramContext.getMacAddress();
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return str;
  }
  
  public static long e()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = SystemClock.elapsedRealtime();
      return l1 - l2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return zk.b;
  }
  
  public static String e(Context paramContext)
  {
    try
    {
      paramContext = Settings.System.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return zk.a;
  }
  
  public static int f(Context paramContext)
  {
    int i;
    try
    {
      i = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1);
      if ((i != 1) && (i != 2)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      i = 0;
    }
    if (i != 0) {
      return 1;
    }
    return 0;
  }
  
  public static long f()
  {
    try
    {
      long l = SystemClock.elapsedRealtime();
      return l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return zk.b;
  }
  
  public static int g()
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j < 8) {
        try
        {
          String str = new String[] { "/system/bin/", "/system/xbin/", "/sbin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/xbin/", "/data/local/bin/", "/data/local/" }[j];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("su");
          boolean bool = new File(localStringBuilder.toString()).exists();
          if (bool) {
            i = 1;
          }
          j += 1;
        }
        catch (Exception localException)
        {
          break label126;
        }
      }
    }
  }
  
  public static String h()
  {
    String str = zk.a;
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class }).invoke(localObject, new Object[] { "ro.kernel.qemu" });
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return str;
  }
  
  public static int i()
  {
    int i;
    try
    {
      if ((!Build.FINGERPRINT.startsWith("generic")) && (!Build.FINGERPRINT.startsWith("unknown")) && (!Build.MODEL.contains("google_sdk")) && (!Build.MODEL.contains("Emulator")) && (!Build.MODEL.contains("Android SDK built for x86")) && (!Build.MANUFACTURER.contains("Genymotion")) && ((!Build.BRAND.startsWith("generic")) || (!Build.DEVICE.startsWith("generic"))))
      {
        boolean bool = "google_sdk".equals(Build.PRODUCT);
        if (!bool)
        {
          i = 0;
          break label130;
        }
      }
      i = 1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i = 0;
    }
    label130:
    if (i != 0) {
      return 1;
    }
    return 0;
  }
  
  public static String j()
  {
    try
    {
      String str = Locale.getDefault().getLanguage();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return zk.a;
  }
  
  public static String k()
  {
    try
    {
      String str = TimeZone.getDefault().getDisplayName();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return zk.a;
  }
  
  public static String l()
  {
    try
    {
      String str = System.getProperty("os.name");
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return zk.a;
  }
  
  public static String m()
  {
    return Build.VERSION.INCREMENTAL;
  }
  
  public static String n()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String o()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.VERSION.SDK_INT);
    return localStringBuilder.toString();
  }
  
  public static String p()
  {
    return Build.BOARD;
  }
  
  public static String q()
  {
    return Build.BRAND;
  }
  
  public static String r()
  {
    return Build.DEVICE;
  }
  
  public static String s()
  {
    return Build.MANUFACTURER;
  }
  
  public static String t()
  {
    return Build.MODEL;
  }
  
  public static String u()
  {
    return Build.PRODUCT;
  }
  
  public static String v()
  {
    return Build.DISPLAY;
  }
  
  public static String w()
  {
    return Build.ID;
  }
  
  public static String x()
  {
    return Build.TAGS;
  }
  
  public static JSONArray y()
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        String[] arrayOfString = Build.SUPPORTED_ABIS;
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            String str = arrayOfString[i];
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("name", str);
            localJSONArray.put(localJSONObject);
            i += 1;
          }
          return localJSONArray;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zj
 * JD-Core Version:    0.7.0.1
 */