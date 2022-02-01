package com.tencent.token.upload;

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

public class e
{
  public static boolean a = true;
  public static long b = 0L;
  public static long c = 0L;
  
  public static long a()
  {
    a = false;
    return c - b;
  }
  
  public static String a(Context paramContext)
  {
    String str = f.a;
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        return paramContext.getDeviceId();
      }
      paramContext = f.a;
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
    try
    {
      Object localObject2 = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/class/power_supply/Battery/capacity" }).start().getInputStream();
      localObject1 = new byte[24];
      while (((InputStream)localObject2).read((byte[])localObject1) != -1) {
        str = str + new String((byte[])localObject1);
      }
      localObject1 = str;
      if (str.length() == 0)
      {
        InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/class/power_supply/battery/capacity" }).start().getInputStream();
        byte[] arrayOfByte = new byte[24];
        for (;;)
        {
          localObject2 = localInputStream;
          localObject1 = str;
          if (localInputStream.read(arrayOfByte) == -1) {
            break;
          }
          str = str + new String(arrayOfByte);
        }
      }
      ((InputStream)localObject2).close();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject1 = f.a;
      }
    }
    return ((String)localObject1).trim();
  }
  
  public static String b(Context paramContext)
  {
    String str = f.a;
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        return paramContext.getSubscriberId();
      }
      paramContext = f.a;
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
    String str = f.a;
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
    String str = f.a;
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        return paramContext.getLine1Number();
      }
      paramContext = f.a;
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
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 27	com/tencent/token/upload/f:a	Ljava/lang/String;
    //   5: astore 4
    //   7: new 131	java/io/FileInputStream
    //   10: dup
    //   11: ldc 133
    //   13: invokespecial 136	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: astore_3
    //   17: new 138	java/io/BufferedReader
    //   20: dup
    //   21: new 140	java/io/InputStreamReader
    //   24: dup
    //   25: aload_3
    //   26: invokespecial 143	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   29: sipush 8192
    //   32: invokespecial 146	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   35: astore 5
    //   37: ldc 46
    //   39: astore_2
    //   40: aload 5
    //   42: invokevirtual 149	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +25 -> 72
    //   50: new 76	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   57: aload_2
    //   58: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_1
    //   62: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore_2
    //   69: goto -29 -> 40
    //   72: aload 4
    //   74: astore_1
    //   75: aload_2
    //   76: ldc 46
    //   78: if_acmpeq +34 -> 112
    //   81: aload_2
    //   82: ldc 151
    //   84: invokevirtual 155	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   87: istore_0
    //   88: aload_2
    //   89: ldc 151
    //   91: invokevirtual 92	java/lang/String:length	()I
    //   94: iload_0
    //   95: iadd
    //   96: invokevirtual 159	java/lang/String:substring	(I)Ljava/lang/String;
    //   99: astore_1
    //   100: aload_1
    //   101: iconst_0
    //   102: aload_1
    //   103: ldc 161
    //   105: invokevirtual 155	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   108: invokevirtual 164	java/lang/String:substring	(II)Ljava/lang/String;
    //   111: astore_1
    //   112: aload 5
    //   114: ifnull +8 -> 122
    //   117: aload 5
    //   119: invokevirtual 165	java/io/BufferedReader:close	()V
    //   122: aload_1
    //   123: astore 5
    //   125: aload_3
    //   126: ifnull +10 -> 136
    //   129: aload_3
    //   130: invokevirtual 97	java/io/InputStream:close	()V
    //   133: aload_1
    //   134: astore 5
    //   136: aload 5
    //   138: areturn
    //   139: astore_2
    //   140: aload_2
    //   141: invokevirtual 44	java/lang/Exception:printStackTrace	()V
    //   144: aload_1
    //   145: areturn
    //   146: astore_3
    //   147: aconst_null
    //   148: astore_1
    //   149: aload_3
    //   150: invokevirtual 44	java/lang/Exception:printStackTrace	()V
    //   153: aload_1
    //   154: ifnull +7 -> 161
    //   157: aload_1
    //   158: invokevirtual 165	java/io/BufferedReader:close	()V
    //   161: aload 4
    //   163: astore 5
    //   165: aload_2
    //   166: ifnull -30 -> 136
    //   169: aload_2
    //   170: invokevirtual 97	java/io/InputStream:close	()V
    //   173: aload 4
    //   175: areturn
    //   176: astore_1
    //   177: aload_1
    //   178: invokevirtual 44	java/lang/Exception:printStackTrace	()V
    //   181: aload 4
    //   183: areturn
    //   184: astore_2
    //   185: aconst_null
    //   186: astore_1
    //   187: aconst_null
    //   188: astore_3
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 165	java/io/BufferedReader:close	()V
    //   197: aload_3
    //   198: ifnull +7 -> 205
    //   201: aload_3
    //   202: invokevirtual 97	java/io/InputStream:close	()V
    //   205: aload_2
    //   206: athrow
    //   207: astore_1
    //   208: aload_1
    //   209: invokevirtual 44	java/lang/Exception:printStackTrace	()V
    //   212: goto -7 -> 205
    //   215: astore_2
    //   216: aconst_null
    //   217: astore_1
    //   218: goto -29 -> 189
    //   221: astore_2
    //   222: aload 5
    //   224: astore_1
    //   225: goto -36 -> 189
    //   228: astore 4
    //   230: aload_2
    //   231: astore_3
    //   232: aload 4
    //   234: astore_2
    //   235: goto -46 -> 189
    //   238: astore 5
    //   240: aconst_null
    //   241: astore_1
    //   242: aload_3
    //   243: astore_2
    //   244: aload 5
    //   246: astore_3
    //   247: goto -98 -> 149
    //   250: astore_1
    //   251: aload_3
    //   252: astore_2
    //   253: aload_1
    //   254: astore_3
    //   255: aload 5
    //   257: astore_1
    //   258: goto -109 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   87	9	0	i	int
    //   45	113	1	str1	String
    //   176	2	1	localException1	Exception
    //   186	8	1	localObject1	Object
    //   207	2	1	localException2	Exception
    //   217	25	1	localObject2	Object
    //   250	4	1	localException3	Exception
    //   257	1	1	localException4	Exception
    //   1	88	2	str2	String
    //   139	31	2	localException5	Exception
    //   184	22	2	localObject3	Object
    //   215	1	2	localObject4	Object
    //   221	10	2	localObject5	Object
    //   234	19	2	localObject6	Object
    //   16	114	3	localFileInputStream	java.io.FileInputStream
    //   146	4	3	localException6	Exception
    //   188	67	3	localObject7	Object
    //   5	177	4	str3	String
    //   228	5	4	localObject8	Object
    //   35	188	5	localObject9	Object
    //   238	18	5	localException7	Exception
    // Exception table:
    //   from	to	target	type
    //   117	122	139	java/lang/Exception
    //   129	133	139	java/lang/Exception
    //   7	17	146	java/lang/Exception
    //   157	161	176	java/lang/Exception
    //   169	173	176	java/lang/Exception
    //   7	17	184	finally
    //   193	197	207	java/lang/Exception
    //   201	205	207	java/lang/Exception
    //   17	37	215	finally
    //   40	46	221	finally
    //   50	69	221	finally
    //   81	112	221	finally
    //   149	153	228	finally
    //   17	37	238	java/lang/Exception
    //   40	46	250	java/lang/Exception
    //   50	69	250	java/lang/Exception
    //   81	112	250	java/lang/Exception
  }
  
  public static String d(Context paramContext)
  {
    String str = f.a;
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
    return f.b;
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
    return f.a;
  }
  
  public static int f(Context paramContext)
  {
    for (;;)
    {
      try
      {
        i = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1);
        if ((i != 1) && (i != 2)) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        int i = 0;
        continue;
      }
      if (i == 0) {
        break label54;
      }
      return 1;
      i = 0;
    }
    label54:
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
    return f.b;
  }
  
  public static int g()
  {
    try
    {
      arrayOfString = new String[8];
      arrayOfString[0] = "/system/bin/";
      arrayOfString[1] = "/system/xbin/";
      arrayOfString[2] = "/sbin/";
      arrayOfString[3] = "/system/sd/xbin/";
      arrayOfString[4] = "/system/bin/failsafe/";
      arrayOfString[5] = "/data/local/xbin/";
      arrayOfString[6] = "/data/local/bin/";
      arrayOfString[7] = "/data/local/";
      m = arrayOfString.length;
      j = 0;
      i = 0;
    }
    catch (Exception localException1)
    {
      try
      {
        String[] arrayOfString;
        int m;
        int j;
        String str;
        boolean bool = new File(str + "su").exists();
        if (bool) {
          i = 1;
        }
        j += 1;
      }
      catch (Exception localException2)
      {
        int i;
        int k;
        break label128;
      }
      localException1 = localException1;
      i = 0;
    }
    k = i;
    if (j < m)
    {
      str = arrayOfString[j];
      label128:
      localException1.printStackTrace();
      k = i;
    }
    if (k != 0) {
      return 1;
    }
    return 0;
  }
  
  public static String h()
  {
    String str = f.a;
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
    for (;;)
    {
      try
      {
        if ((!Build.FINGERPRINT.startsWith("generic")) && (!Build.FINGERPRINT.startsWith("unknown")) && (!Build.MODEL.contains("google_sdk")) && (!Build.MODEL.contains("Emulator")) && (!Build.MODEL.contains("Android SDK built for x86")) && (!Build.MANUFACTURER.contains("Genymotion")) && ((!Build.BRAND.startsWith("generic")) || (!Build.DEVICE.startsWith("generic"))))
        {
          boolean bool = "google_sdk".equals(Build.PRODUCT);
          if (!bool) {
            continue;
          }
        }
        i = 1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        int i = 0;
        continue;
      }
      if (i == 0) {
        break label133;
      }
      return 1;
      i = 0;
    }
    label133:
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
    return f.a;
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
    return f.a;
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
    return f.a;
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
    return Build.VERSION.SDK_INT + "";
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
    localJSONArray = new JSONArray();
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
        }
      }
      return localJSONArray;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.upload.e
 * JD-Core Version:    0.7.0.1
 */