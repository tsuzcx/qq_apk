package com.tencent.qqpimsecure.taiji;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import taiji.bl;
import taiji.bn;

@SuppressLint({"UseSparseArrays"})
class f
{
  private static final String[] a = { "com.coloros.safecenter", "com.coloros.oppoguardelf", "com.oppo.safe" };
  private static final String[] b = { "com.iqoo.secure", "com.vivo.abe" };
  private static final String[] c = { "com.huawei.systemmanager" };
  private static final String[] d = { "com.samsung.android.sm_cn", "com.samsung.android.sm" };
  private static final String[] e = { "com.gionee.softmanager" };
  private static final String[] f = { "com.meizu.safe" };
  private static final String[] g = { "com.miui.securitycenter" };
  private static String h = "";
  
  static String a(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(h)) {
      return h;
    }
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.toLowerCase(Locale.ENGLISH);
    if (paramString.contains("oppo")) {
      paramString = a;
    }
    for (;;)
    {
      if (paramString != null)
      {
        int j = paramString.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label197;
          }
          String str = paramString[i];
          try
          {
            paramContext.getPackageManager().getPackageInfo(str, 0);
            h = str;
            str = h;
            return str;
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            i += 1;
          }
          if (paramString.contains("vivo"))
          {
            paramString = b;
            break;
          }
          if (paramString.contains("huawei"))
          {
            paramString = c;
            break;
          }
          if (paramString.contains("gionee"))
          {
            paramString = e;
            break;
          }
          if (paramString.contains("meizu"))
          {
            paramString = f;
            break;
          }
          if (paramString.contains("samsung"))
          {
            paramString = d;
            break;
          }
          if (!paramString.contains("xiaomi")) {
            break label201;
          }
          paramString = g;
          break;
        }
      }
      label197:
      return h;
      label201:
      paramString = null;
    }
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  static HashMap<Integer, String> a(Context paramContext)
  {
    HashMap localHashMap = new HashMap(7);
    String str = bl.b();
    localHashMap.put(Integer.valueOf(9800), str);
    localHashMap.put(Integer.valueOf(9801), a(bl.a()));
    localHashMap.put(Integer.valueOf(9803), a(bl.d()));
    localHashMap.put(Integer.valueOf(9804), bl.a("ro.build.fingerprint"));
    try
    {
      localHashMap.put(Integer.valueOf(9806), paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName);
      localHashMap.put(Integer.valueOf(9807), a("107022"));
      localHashMap.put(Integer.valueOf(9808), a("2.0.0"));
      if (!TextUtils.isEmpty(a(paramContext, str))) {
        localHashMap.put(Integer.valueOf(9810), a(h));
      }
      paramContext = localHashMap.keySet().iterator();
      while (paramContext.hasNext())
      {
        int i = ((Integer)paramContext.next()).intValue();
        bn.b("TaijiProfile", "profile:" + i + "|" + (String)localHashMap.get(Integer.valueOf(i)));
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        localHashMap.put(Integer.valueOf(9806), "");
      }
    }
    return localHashMap;
  }
  
  static HashMap<Integer, Integer> b(Context paramContext)
  {
    HashMap localHashMap = new HashMap(3);
    localHashMap.put(Integer.valueOf(9802), Integer.valueOf(Build.VERSION.SDK_INT));
    try
    {
      localHashMap.put(Integer.valueOf(9805), Integer.valueOf(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode));
      localHashMap.put(Integer.valueOf(9809), Integer.valueOf(70));
      localHashMap.put(Integer.valueOf(9812), Integer.valueOf(2));
      if (TextUtils.isEmpty(a(paramContext, bl.b()))) {}
    }
    catch (Throwable localThrowable)
    {
      try
      {
        localHashMap.put(Integer.valueOf(9811), Integer.valueOf(paramContext.getPackageManager().getPackageInfo(h, 0).versionCode));
        paramContext = localHashMap.keySet().iterator();
        while (paramContext.hasNext())
        {
          int i = ((Integer)paramContext.next()).intValue();
          bn.b("TaijiProfile", "profile:" + i + "|" + localHashMap.get(Integer.valueOf(i)));
          continue;
          localThrowable = localThrowable;
          localThrowable.printStackTrace();
          localHashMap.put(Integer.valueOf(9805), Integer.valueOf(0));
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.f
 * JD-Core Version:    0.7.0.1
 */