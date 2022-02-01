package com.huawei.updatesdk.a.a.c.a;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.updatesdk.a.a.b.a.a.a;
import com.huawei.updatesdk.a.a.c.c;
import com.huawei.updatesdk.a.a.c.e;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class b
{
  private static b a = new b();
  private static String d = null;
  private int b = 0;
  private int c = 0;
  
  private b()
  {
    int i = a("ro.maple.enable", 0);
    int j = a("persist.mygote.disable", 0);
    if ((i == 1) && (j != 1)) {
      this.b = 1;
    }
    this.c = a("ro.build.version.ark", 0);
  }
  
  public static int a(String paramString, int paramInt)
  {
    try
    {
      int i = ((Integer)Class.forName("android.os.SystemProperties").getMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(null, new Object[] { paramString, Integer.valueOf(paramInt) })).intValue();
      return i;
    }
    catch (ClassNotFoundException paramString)
    {
      a.a("DeviceUtil", "Exception while getting system property: ", paramString);
      return paramInt;
    }
    catch (NoSuchMethodException paramString)
    {
      a.a("DeviceUtil", "Exception while getting system property: ", paramString);
      return paramInt;
    }
    catch (NoSuchMethodError paramString)
    {
      a.a("DeviceUtil", "Exception while getting system property: ", paramString);
      return paramInt;
    }
    catch (Exception paramString)
    {
      a.a("DeviceUtil", "Exception while getting system property: ", paramString);
      return paramInt;
    }
    catch (Throwable paramString)
    {
      a.a("DeviceUtil", "Exception while getting system property: ", paramString);
    }
    return paramInt;
  }
  
  public static String a()
  {
    try
    {
      Object localObject = Class.forName("com.huawei.system.BuildEx").getField("DISPLAY").get(null);
      if (localObject == null) {
        return Build.DISPLAY;
      }
      localObject = localObject.toString();
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      return Build.DISPLAY;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      return Build.DISPLAY;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return Build.DISPLAY;
    }
    catch (Throwable localThrowable) {}
    return Build.DISPLAY;
  }
  
  public static String a(Context paramContext)
  {
    String str = "";
    DisplayMetrics localDisplayMetrics = j(paramContext);
    paramContext = str;
    if (localDisplayMetrics != null) {
      paramContext = String.valueOf(localDisplayMetrics.densityDpi);
    }
    return paramContext;
  }
  
  public static String a(String paramString)
  {
    try
    {
      Object localObject1 = Class.forName("com.huawei.hms.framework.network.grs.GrsApi").getMethod("synGetGrsUrl", new Class[] { String.class, String.class }).invoke(null, new Object[] { "com.huawei.update", "ROOT" });
      if ((localObject1 instanceof String)) {
        localObject1 = (String)localObject1;
      }
      Object localObject2;
      return paramString;
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      try
      {
        Log.i("DeviceUtil", "UpdateSDK Get url from GRS_SDK Success!");
        return localObject1;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          paramString = localThrowable1;
          localObject2 = localThrowable2;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          paramString = localObject2;
          localObject2 = localException2;
        }
      }
      catch (NoSuchMethodError localNoSuchMethodError2)
      {
        for (;;)
        {
          paramString = localObject2;
          localObject2 = localNoSuchMethodError2;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        for (;;)
        {
          paramString = localObject2;
          localObject2 = localNoSuchMethodException2;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        for (;;)
        {
          paramString = localObject2;
          localObject2 = localClassNotFoundException2;
        }
      }
      localClassNotFoundException1 = localClassNotFoundException1;
      Log.w("DeviceUtil", "UpdateSDK Get url from GRS_SDK error: " + localClassNotFoundException1.toString());
      return paramString;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      Log.w("DeviceUtil", "UpdateSDK Get url from GRS_SDK error: " + localNoSuchMethodException1.toString());
      return paramString;
    }
    catch (NoSuchMethodError localNoSuchMethodError1)
    {
      Log.w("DeviceUtil", "UpdateSDK Get url from GRS_SDK error: " + localNoSuchMethodError1.toString());
      return paramString;
    }
    catch (Exception localException1)
    {
      Log.w("DeviceUtil", "UpdateSDK Get url from GRS_SDK error: " + localException1.toString());
      return paramString;
    }
    catch (Throwable localThrowable1)
    {
      Log.w("DeviceUtil", "UpdateSDK Get url from GRS_SDK error: " + localThrowable1.toString());
      return paramString;
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (ClassNotFoundException paramString1)
    {
      a.a("DeviceUtil", "Exception while getting system property: ", paramString1);
      return paramString2;
    }
    catch (NoSuchMethodException paramString1)
    {
      for (;;)
      {
        a.a("DeviceUtil", "Exception while getting system property: ", paramString1);
      }
    }
    catch (NoSuchMethodError paramString1)
    {
      for (;;)
      {
        a.a("DeviceUtil", "Exception while getting system property: ", paramString1);
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        a.a("DeviceUtil", "Exception while getting system property: ", paramString1);
      }
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        a.a("DeviceUtil", "Exception while getting system property: ", paramString1);
      }
    }
  }
  
  public static List<String> a(List<String> paramList, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!a(str, paramArrayOfString)) {
        localArrayList.add(str);
      }
    }
    return localArrayList;
  }
  
  static boolean a(String paramString, String[] paramArrayOfString)
  {
    int i3 = paramArrayOfString.length;
    int i = 0;
    int j = 0;
    int m = 0;
    int k = 0;
    if (i < i3)
    {
      String str = paramArrayOfString[i];
      int i1;
      int n;
      if (str.startsWith("config."))
      {
        i1 = 1;
        n = m;
      }
      for (;;)
      {
        int i2 = j;
        if (str.endsWith("config." + paramString)) {
          i2 = j + 1;
        }
        i += 1;
        m = n;
        k = i1;
        j = i2;
        break;
        n = m;
        i1 = k;
        if (!str.contains(".config."))
        {
          n = m + 1;
          i1 = k;
        }
      }
    }
    return m + k == j;
  }
  
  public static String b()
  {
    String str2 = "en";
    String str1 = "";
    Object localObject = Locale.getDefault();
    if (localObject != null)
    {
      str2 = ((Locale)localObject).getLanguage();
      if (Build.VERSION.SDK_INT >= 21) {
        str1 = ((Locale)localObject).getScript();
      }
    }
    for (localObject = ((Locale)localObject).getCountry();; localObject = "US")
    {
      if (TextUtils.isEmpty(str1)) {
        return str2 + "_" + (String)localObject;
      }
      return str2 + "_" + str1 + "_" + (String)localObject;
      str1 = "";
    }
  }
  
  static String b(Context paramContext)
  {
    if (d == null) {
      d = e.a(k(paramContext), ",");
    }
    return d;
  }
  
  public static List<String> c(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramContext = paramContext.getResources().getConfiguration().getLocales();
      int i = 0;
      while (i < paramContext.size())
      {
        String str = paramContext.get(i).getLanguage();
        if ((!TextUtils.isEmpty(str)) && (!localArrayList.contains(str))) {
          localArrayList.add(str);
        }
        i += 1;
      }
    }
    localArrayList.add(paramContext.getResources().getConfiguration().locale.getLanguage());
    return localArrayList;
  }
  
  public static String[] c()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (Build.SUPPORTED_ABIS == null) {
        return new String[0];
      }
      return Build.SUPPORTED_ABIS;
    }
    return new String[] { Build.CPU_ABI };
  }
  
  public static int d()
  {
    for (;;)
    {
      try
      {
        Object localObject = Class.forName("android.os.UserHandle");
        localObject = ((Class)localObject).getMethod("myUserId", new Class[0]).invoke(localObject, new Object[0]);
        if ((localObject instanceof Integer))
        {
          i = ((Integer)localObject).intValue();
          return i;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        a.d("DeviceUtil", "get current uid IllegalArgumentException! " + localIllegalArgumentException.toString());
        return 0;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        a.d("DeviceUtil", "get current uid ClassNotFoundException! " + localClassNotFoundException.toString());
        return 0;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        a.d("DeviceUtil", "get current uid NoSuchMethodException! " + localNoSuchMethodException.toString());
        return 0;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        a.d("DeviceUtil", "get current uid InvocationTargetException! " + localInvocationTargetException.toString());
        return 0;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        a.d("DeviceUtil", "get current uid IllegalAccessException! " + localIllegalAccessException.toString());
        return 0;
      }
      catch (Exception localException)
      {
        a.d("DeviceUtil", "get current uid IllegalAccessException! " + localException.toString());
        return 0;
      }
      catch (Throwable localThrowable)
      {
        a.d("DeviceUtil", "get current uid IllegalAccessException! " + localThrowable.toString());
        return 0;
      }
      int i = 0;
    }
  }
  
  public static String d(Context paramContext)
  {
    String str = "";
    DisplayMetrics localDisplayMetrics = j(paramContext);
    paramContext = str;
    if (localDisplayMetrics != null)
    {
      int i = localDisplayMetrics.widthPixels;
      int j = localDisplayMetrics.heightPixels;
      paramContext = String.valueOf(i) + "_" + String.valueOf(j);
    }
    return paramContext;
  }
  
  public static String e()
  {
    return Build.VERSION.RELEASE.trim();
  }
  
  /* Error */
  public static boolean e(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: invokevirtual 339	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   6: astore_0
    //   7: aload_0
    //   8: ldc_w 341
    //   11: bipush 16
    //   13: invokevirtual 347	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   16: pop
    //   17: aload_0
    //   18: ldc_w 349
    //   21: bipush 16
    //   23: invokevirtual 347	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   26: pop
    //   27: aload_0
    //   28: ldc_w 351
    //   31: bipush 16
    //   33: invokevirtual 347	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   36: getfield 357	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   39: getfield 362	android/content/pm/ApplicationInfo:flags	I
    //   42: istore_1
    //   43: iload_1
    //   44: iconst_1
    //   45: iand
    //   46: ifeq +5 -> 51
    //   49: iconst_1
    //   50: istore_2
    //   51: iload_2
    //   52: ireturn
    //   53: astore_0
    //   54: ldc 83
    //   56: aload_0
    //   57: invokevirtual 365	android/content/pm/PackageManager$NameNotFoundException:getMessage	()Ljava/lang/String;
    //   60: invokestatic 309	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: iconst_0
    //   64: ireturn
    //   65: astore_0
    //   66: ldc 83
    //   68: aload_0
    //   69: invokevirtual 365	android/content/pm/PackageManager$NameNotFoundException:getMessage	()Ljava/lang/String;
    //   72: invokestatic 309	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: iconst_0
    //   76: ireturn
    //   77: astore_0
    //   78: ldc 83
    //   80: aload_0
    //   81: invokevirtual 366	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   84: invokestatic 309	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: iconst_0
    //   88: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramContext	Context
    //   42	4	1	i	int
    //   1	51	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	17	53	android/content/pm/PackageManager$NameNotFoundException
    //   17	27	65	android/content/pm/PackageManager$NameNotFoundException
    //   27	43	77	java/lang/Exception
  }
  
  public static int f(Context paramContext)
  {
    try
    {
      int i = Integer.parseInt(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16).versionCode + "");
      return i;
    }
    catch (NumberFormatException paramContext)
    {
      return 1;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return 1;
  }
  
  public static b f()
  {
    return a;
  }
  
  public static String g(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.huawei.appmarket", 16).versionName + "";
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return "";
  }
  
  public static String h(Context paramContext)
  {
    paramContext = g(paramContext);
    int i = 0;
    int k;
    for (int j = 0; (i < paramContext.length()) && (j < 3); j = k)
    {
      k = j;
      if (paramContext.charAt(i) == '.') {
        k = j + 1;
      }
      i += 1;
    }
    if (3 == j) {
      return paramContext.substring(0, i - 1);
    }
    return paramContext;
  }
  
  public static String i(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16).versionName + "";
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  private static DisplayMetrics j(Context paramContext)
  {
    paramContext = paramContext.getSystemService("window");
    if ((paramContext instanceof WindowManager)) {}
    for (paramContext = (WindowManager)paramContext;; paramContext = null)
    {
      if (paramContext != null)
      {
        paramContext = paramContext.getDefaultDisplay();
        if (paramContext != null)
        {
          DisplayMetrics localDisplayMetrics = new DisplayMetrics();
          paramContext.getMetrics(localDisplayMetrics);
          return localDisplayMetrics;
        }
      }
      return null;
    }
  }
  
  private static List<String> k(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getPackageManager().getSystemAvailableFeatures();
    if (paramContext != null)
    {
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramContext[i];
        if (localObject.name != null) {
          localArrayList.add(c.a(localObject.name));
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public int g()
  {
    return this.b;
  }
  
  public int h()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.c.a.b
 * JD-Core Version:    0.7.0.1
 */