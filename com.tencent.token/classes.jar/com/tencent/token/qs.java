package com.tencent.token;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
final class qs
{
  private static final String[] a = { "com.coloros.safecenter", "com.coloros.oppoguardelf", "com.oppo.safe" };
  private static final String[] b = { "com.iqoo.secure", "com.vivo.abe" };
  private static final String[] c = { "com.huawei.systemmanager" };
  private static final String[] d = { "com.samsung.android.sm_cn", "com.samsung.android.sm" };
  private static final String[] e = { "com.gionee.softmanager" };
  private static final String[] f = { "com.meizu.safe" };
  private static final String[] g = { "com.miui.securitycenter" };
  private static String h = "";
  
  private static String a(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(h)) {
      return h;
    }
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = paramString.toLowerCase(Locale.ENGLISH);
    paramString = null;
    if (str.contains("oppo")) {
      paramString = a;
    } else if (str.contains("vivo")) {
      paramString = b;
    } else if (str.contains("huawei")) {
      paramString = c;
    } else if (str.contains("gionee")) {
      paramString = e;
    } else if (str.contains("meizu")) {
      paramString = f;
    } else if (str.contains("samsung")) {
      paramString = d;
    } else if (str.contains("xiaomi")) {
      paramString = g;
    }
    if (paramString != null)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        str = paramString[i];
        try
        {
          paramContext.getPackageManager().getPackageInfo(str, 0);
          h = str;
          return str;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          i += 1;
        }
      }
    }
    return h;
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
    Object localObject = aoa.a();
    localHashMap.put(Integer.valueOf(9800), localObject);
    localHashMap.put(Integer.valueOf(9801), a(Build.MODEL));
    localHashMap.put(Integer.valueOf(9803), a(aoa.b()));
    localHashMap.put(Integer.valueOf(9804), aoa.a("ro.build.fingerprint"));
    try
    {
      localHashMap.put(Integer.valueOf(9806), paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      localHashMap.put(Integer.valueOf(9806), "");
    }
    localHashMap.put(Integer.valueOf(9807), a("107022"));
    localHashMap.put(Integer.valueOf(9808), a("2.0.0"));
    if (!TextUtils.isEmpty(a(paramContext, (String)localObject))) {
      localHashMap.put(Integer.valueOf(9810), a(h));
    }
    paramContext = localHashMap.keySet().iterator();
    while (paramContext.hasNext())
    {
      int i = ((Integer)paramContext.next()).intValue();
      localObject = new StringBuilder("profile:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append((String)localHashMap.get(Integer.valueOf(i)));
      aoc.b();
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
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      localHashMap.put(Integer.valueOf(9805), Integer.valueOf(0));
    }
    localHashMap.put(Integer.valueOf(9809), Integer.valueOf(70));
    localHashMap.put(Integer.valueOf(9812), Integer.valueOf(2));
    if (!TextUtils.isEmpty(a(paramContext, aoa.a()))) {
      try
      {
        localHashMap.put(Integer.valueOf(9811), Integer.valueOf(paramContext.getPackageManager().getPackageInfo(h, 0).versionCode));
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    paramContext = localHashMap.keySet().iterator();
    while (paramContext.hasNext())
    {
      int i = ((Integer)paramContext.next()).intValue();
      StringBuilder localStringBuilder = new StringBuilder("profile:");
      localStringBuilder.append(i);
      localStringBuilder.append("|");
      localStringBuilder.append(localHashMap.get(Integer.valueOf(i)));
      aoc.b();
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qs
 * JD-Core Version:    0.7.0.1
 */