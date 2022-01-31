package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.tencent.mapsdk.net.NetContext;
import java.io.InputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class q
{
  public static a a = a.c;
  public static Date b = null;
  public static HashMap<String, String> c = new HashMap();
  public static boolean d = false;
  public static String e = null;
  private static float f = 1.0F;
  private static String g = null;
  private static String h = null;
  private static String i = null;
  private static String j = null;
  private static String k = null;
  private static String l = null;
  private static int m = 0;
  private static String n = null;
  private static String o = null;
  
  public static double a(double paramDouble, long paramLong)
  {
    double d1 = paramLong / 159.0D;
    d1 *= d1;
    return (1.0D - d1 * d1) * (paramDouble - 1.0D) + 1.0D;
  }
  
  public static final Bitmap a(Context paramContext, String paramString)
  {
    Object localObject2 = paramContext.getAssets();
    Object localObject1 = null;
    paramContext = localObject1;
    try
    {
      localObject2 = ((AssetManager)localObject2).open("tencentmap/mapsdk/" + paramString);
      paramContext = localObject1;
      paramString = BitmapFactory.decodeStream((InputStream)localObject2);
      paramContext = paramString;
      ((InputStream)localObject2).close();
      paramContext = paramString;
    }
    catch (OutOfMemoryError paramContext)
    {
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    return paramContext;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 66	com/tencent/tencentmap/mapsdk/map/q:c	Ljava/util/HashMap;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +10 -> 18
    //   11: aconst_null
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: getstatic 66	com/tencent/tencentmap/mapsdk/map/q:c	Ljava/util/HashMap;
    //   21: aload_0
    //   22: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 127	java/lang/String
    //   28: astore_0
    //   29: goto -16 -> 13
    //   32: astore_0
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	paramString	String
    //   6	2	1	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   3	7	32	finally
    //   18	29	32	finally
  }
  
  public static void a(Context paramContext)
  {
    if (n == null) {}
    try
    {
      Object localObject = Build.MODEL;
      n = (String)localObject;
      localObject = c((String)localObject);
      n = (String)localObject;
      n = URLEncoder.encode((String)localObject, "utf-8");
      label32:
      if (m == 0) {
        m = Build.VERSION.SDK_INT;
      }
      if (l == null) {}
      try
      {
        localObject = paramContext.getPackageName();
        l = (String)localObject;
        localObject = c((String)localObject);
        l = (String)localObject;
        l = URLEncoder.encode((String)localObject, "utf-8");
        label77:
        if (i == null) {}
        try
        {
          localObject = e(paramContext);
          i = (String)localObject;
          localObject = c((String)localObject);
          i = (String)localObject;
          i = URLEncoder.encode((String)localObject, "utf-8");
          label110:
          if (j == null)
          {
            if (paramContext != null) {
              break label388;
            }
            localObject = "";
          }
          try
          {
            for (;;)
            {
              j = (String)localObject;
              localObject = c((String)localObject);
              j = (String)localObject;
              j = URLEncoder.encode((String)localObject, "utf-8");
              label145:
              if (k == null) {}
              try
              {
                localObject = s.a(paramContext);
                k = (String)localObject;
                localObject = c((String)localObject);
                k = (String)localObject;
                k = URLEncoder.encode((String)localObject, "utf-8");
                label178:
                if (h == null) {}
                label271:
                label295:
                label425:
                label457:
                try
                {
                  localObject = (WifiManager)paramContext.getSystemService("wifi");
                  if (localObject != null) {
                    break label425;
                  }
                  localObject = "";
                  label201:
                  h = (String)localObject;
                  localObject = Pattern.compile("[^a-zA-Z0-9]").matcher((CharSequence)localObject).replaceAll("").trim();
                  h = (String)localObject;
                  h = URLEncoder.encode((String)localObject, "utf-8");
                }
                catch (Exception localException2)
                {
                  label236:
                  label249:
                  break label236;
                }
                if (g == null)
                {
                  if (paramContext != null) {
                    break label457;
                  }
                  localObject = "";
                }
                try
                {
                  g = (String)localObject;
                  localObject = c((String)localObject);
                  g = (String)localObject;
                  g = URLEncoder.encode((String)localObject, "utf-8");
                  if (e == null) {}
                  try
                  {
                    paramContext = d(paramContext);
                    e = paramContext;
                    e = URLEncoder.encode(paramContext, "utf-8");
                    if (o == null) {}
                    try
                    {
                      paramContext = b(String.format("key=%s&output=json&ref=%s&pf=%s&imei=%s&pid=%s&os=%s&hm=%s&imsc=%s&mac=%s", new Object[] { e, i, "Android_SDK", j, l, Integer.valueOf(m), n, g, h }));
                      o = paramContext;
                      o = URLEncoder.encode(paramContext, "utf-8");
                      return;
                    }
                    catch (Exception paramContext)
                    {
                      label388:
                      String str;
                      return;
                    }
                    localObject = (TelephonyManager)paramContext.getSystemService("phone");
                    if (localObject == null)
                    {
                      localObject = "";
                      continue;
                    }
                    str = ((TelephonyManager)localObject).getDeviceId();
                    localObject = str;
                    if (str != null) {
                      continue;
                    }
                    localObject = "";
                    continue;
                    localObject = ((WifiManager)localObject).getConnectionInfo();
                    if (localObject == null)
                    {
                      localObject = "";
                      break label201;
                    }
                    str = ((WifiInfo)localObject).getMacAddress();
                    localObject = str;
                    if (str != null) {
                      break label201;
                    }
                    localObject = "";
                    break label201;
                    localObject = (TelephonyManager)paramContext.getSystemService("phone");
                    if (localObject == null)
                    {
                      localObject = "";
                      break label249;
                    }
                    str = ((TelephonyManager)localObject).getSubscriberId();
                    localObject = str;
                    if (str != null) {
                      break label249;
                    }
                    localObject = "";
                  }
                  catch (Exception paramContext)
                  {
                    break label295;
                  }
                }
                catch (Exception localException1)
                {
                  break label271;
                }
              }
              catch (Exception localException3)
              {
                break label178;
              }
            }
          }
          catch (Exception localException4)
          {
            break label145;
          }
        }
        catch (Exception localException5)
        {
          break label110;
        }
      }
      catch (Exception localException6)
      {
        break label77;
      }
    }
    catch (Exception localException7)
    {
      break label32;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    try
    {
      if (c == null) {
        c = new HashMap();
      }
      if (c.containsKey(paramString1)) {
        c.remove(paramString1);
      }
      c.put(paramString1, paramString2);
      return;
    }
    finally {}
  }
  
  public static boolean a()
  {
    return f > 1.0F;
  }
  
  public static boolean a(f paramf)
  {
    Object localObject = paramf;
    if (paramf == null) {
      localObject = new f(c());
    }
    localObject = (Boolean)((f)localObject).b();
    paramf = (f)localObject;
    if (localObject == null) {
      paramf = Boolean.valueOf(false);
    }
    return paramf.booleanValue();
  }
  
  private static String b(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = ((MessageDigest)localObject).digest();
      StringBuilder localStringBuilder = new StringBuilder();
      int i2 = localObject.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localStringBuilder.append(Integer.toHexString(localObject[i1] & 0xFF)).append("");
        i1 += 1;
      }
      localObject = localStringBuilder.toString();
      return localObject;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  static Date b()
  {
    return Calendar.getInstance().getTime();
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        NetContext.getInstance().init(paramContext);
      }
      finally {}
    }
  }
  
  static String c()
  {
    return String.format("http://apikey.map.qq.com/mkey/index.php/mkey/check?key=%s&output=json&ref=%s&pf=%s&imei=%s&pid=%s&os=%s&hm=%s&imsc=%s&mac=%s&nt=%s&suid=%s&ver=%s", new Object[] { e, i, "Android_SDK", j, l, Integer.valueOf(m), n, g, h, k, o, "1.0.7" });
  }
  
  private static String c(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replace("&", "").replace("#", "").replace("?", "");
  }
  
  static void c(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    f = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private static String d(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    String str = paramContext.getPackageName();
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(str, 128);
      if (paramContext == null) {
        return "";
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = localObject;
      }
      if (paramContext.metaData == null) {
        return "";
      }
    }
    return paramContext.metaData.getString("TencentMapSDK");
  }
  
  private static String e(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject = null;
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
      return paramContext.loadLabel(localPackageManager).toString();
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = localObject;
      }
    }
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.q
 * JD-Core Version:    0.7.0.1
 */