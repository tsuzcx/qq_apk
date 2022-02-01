package com.tencent.tpns.baseapi.core;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.PushMd5Pref;
import com.tencent.tpns.baseapi.core.b.a.a;

public class a
{
  private static volatile long a = -1L;
  private static volatile String b = "";
  private static volatile long c = -1L;
  private static String d;
  private static String e;
  private static String f;
  private static String g;
  private static String h;
  private static String i;
  private static int j = -1;
  
  public static long a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      long l;
      try
      {
        l = a;
        return l;
      }
      finally {}
      if (a != -1L)
      {
        l = a;
        continue;
      }
      a = PushPreferences.getLong(paramContext, "XG_V2_ACCESS_ID", -1L);
      if (a == -1L)
      {
        paramContext = CommonHelper.getMetaData(paramContext, "XG_V2_ACCESS_ID", null);
        if (paramContext == null) {}
      }
      try
      {
        a = Long.valueOf(paramContext.toString()).longValue();
        if (a == -1L) {
          Logger.e("XGApiConfigImpl", "accessId没有初始化");
        }
        l = a;
      }
      catch (Throwable paramContext)
      {
        Logger.w("XGApiConfigImpl", "get accessId from getMetaData failed: ", paramContext);
        a = -1L;
      }
    }
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        Logger.e("XGApiConfigImpl", "null  context");
        return;
      }
      finally {}
      if (paramLong != a) {
        GuidInfoManager.clearGuidInfo(paramContext);
      }
      a = paramLong;
      CommonWorkingThread.getInstance().execute(new a.1(paramContext, paramLong));
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {}
    for (;;)
    {
      try
      {
        Logger.e("XGApiConfigImpl", "null context or null accessKey");
        return;
      }
      finally {}
      b = paramString;
      CommonWorkingThread.getInstance().execute(new a.2(paramContext, paramString));
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      PushPreferences.putBoolean(paramContext, "IS_POWER_SAVE_MODE", paramBoolean);
      return;
    }
    catch (Throwable paramContext)
    {
      Logger.w("XGApiConfigImpl", "setPowerSaveMode Throwable: " + paramContext);
    }
  }
  
  /* Error */
  public static String b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	com/tencent/tpns/baseapi/core/a:b	Ljava/lang/String;
    //   6: invokestatic 139	com/tencent/tpns/baseapi/base/util/Util:isNullOrEmptyString	(Ljava/lang/String;)Z
    //   9: ifne +12 -> 21
    //   12: getstatic 27	com/tencent/tpns/baseapi/core/a:b	Ljava/lang/String;
    //   15: astore_0
    //   16: ldc 2
    //   18: monitorexit
    //   19: aload_0
    //   20: areturn
    //   21: aload_0
    //   22: ldc 141
    //   24: aconst_null
    //   25: invokestatic 145	com/tencent/tpns/baseapi/base/PushPreferences:getString	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: putstatic 27	com/tencent/tpns/baseapi/core/a:b	Ljava/lang/String;
    //   31: getstatic 27	com/tencent/tpns/baseapi/core/a:b	Ljava/lang/String;
    //   34: invokestatic 139	com/tencent/tpns/baseapi/base/util/Util:isNullOrEmptyString	(Ljava/lang/String;)Z
    //   37: ifeq +22 -> 59
    //   40: aload_0
    //   41: ldc 141
    //   43: aconst_null
    //   44: invokestatic 49	com/tencent/tpns/baseapi/base/util/CommonHelper:getMetaData	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: astore_0
    //   48: aload_0
    //   49: ifnull +10 -> 59
    //   52: aload_0
    //   53: invokevirtual 53	java/lang/Object:toString	()Ljava/lang/String;
    //   56: putstatic 27	com/tencent/tpns/baseapi/core/a:b	Ljava/lang/String;
    //   59: getstatic 27	com/tencent/tpns/baseapi/core/a:b	Ljava/lang/String;
    //   62: invokestatic 139	com/tencent/tpns/baseapi/base/util/Util:isNullOrEmptyString	(Ljava/lang/String;)Z
    //   65: ifeq +10 -> 75
    //   68: ldc 65
    //   70: ldc 147
    //   72: invokestatic 72	com/tencent/tpns/baseapi/base/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: getstatic 27	com/tencent/tpns/baseapi/core/a:b	Ljava/lang/String;
    //   78: astore_0
    //   79: goto -63 -> 16
    //   82: astore_0
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_0
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	16	82	finally
    //   21	48	82	finally
    //   52	59	82	finally
    //   59	75	82	finally
    //   75	79	82	finally
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.equals(c(paramContext))) {
      return;
    }
    PushPreferences.putLong(paramContext, "XG_GUID_LAST_REFRESH_TIME", 0L);
    Logger.w("XGApiConfigImpl", "refresh Token");
    d = paramString;
    e = null;
    f = null;
    h = null;
    i = null;
    PushPreferences.putString(paramContext, "XG_SERVER_SUFFIX", d);
  }
  
  public static String c(Context paramContext)
  {
    if (TextUtils.isEmpty(d)) {
      d = PushPreferences.getString(paramContext, "XG_SERVER_SUFFIX", null);
    }
    if (TextUtils.isEmpty(d))
    {
      localObject = CommonHelper.getMetaData(paramContext, "XG_SERVER_SUFFIX", null);
      if (localObject != null) {
        d = localObject.toString();
      }
    }
    if (TextUtils.isEmpty(d)) {}
    for (;;)
    {
      try
      {
        String str = PushPreferences.getString(paramContext, "XG_GUID_SERVER", null);
        localObject = str;
        if (TextUtils.isEmpty(str))
        {
          paramContext = CommonHelper.getMetaData(paramContext, "XG_GUID_SERVER", null);
          localObject = str;
          if (paramContext != null) {
            localObject = paramContext.toString();
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (!((String)localObject).contains(a.a.b.a())) {
            continue;
          }
          d = a.a.b.b();
        }
      }
      catch (Throwable paramContext)
      {
        Logger.w("XGApiConfigImpl", "getServerSuffix from old version config error: " + paramContext.toString());
        continue;
        Logger.w("XGApiConfigImpl", "unexpected serverSuffix from old version config: " + (String)localObject);
        continue;
      }
      if (TextUtils.isEmpty(d)) {
        d = "tpns.tencent.com";
      }
      return d;
      if (!((String)localObject).contains(a.a.c.a())) {
        continue;
      }
      d = a.a.c.b();
    }
  }
  
  public static void c(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str = d(paramContext);
    if ((str != null) && (!str.equals(paramString)))
    {
      PushPreferences.putLong(paramContext, "XG_GUID_LAST_REFRESH_TIME", 0L);
      Logger.w("XGApiConfigImpl", "refresh Token");
    }
    PushPreferences.putString(paramContext, "XG_GUID_SERVER", paramString);
  }
  
  public static String d(Context paramContext)
  {
    Object localObject1 = "";
    Object localObject2 = CloudManager.getInstance(paramContext).getGuid();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://guid." + (String)localObject2 + "/guid/v4/guid_and_mqtt_info";
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = PushPreferences.getString(paramContext, "XG_GUID_SERVER", null);
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramContext = c(paramContext);
      localObject1 = "https://guid." + paramContext + "/guid/v4/guid_and_mqtt_info";
    }
    paramContext = (Context)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramContext = "https://api.tpns.tencent.com/guid/api/GetGuidAndMqttServer";
    }
    return paramContext;
  }
  
  public static void d(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.equals(e(paramContext))) {
      return;
    }
    e = paramString;
    PushPreferences.putString(paramContext, "XG_STAT_SERVER", paramString);
  }
  
  public static String e(Context paramContext)
  {
    if (TextUtils.isEmpty(e))
    {
      String str = CloudManager.getInstance(paramContext).getStat();
      if (!TextUtils.isEmpty(str)) {
        e = "https://stat." + str + "/log/statistics/push";
      }
    }
    if (TextUtils.isEmpty(e)) {
      e = PushPreferences.getString(paramContext, "XG_STAT_SERVER", null);
    }
    if (TextUtils.isEmpty(e))
    {
      paramContext = c(paramContext);
      e = "https://stat." + paramContext + "/log/statistics/push";
    }
    if (TextUtils.isEmpty(e)) {
      e = "https://stat.api.tpns.tencent.com/log/v4/statistics/push";
    }
    return e;
  }
  
  public static void e(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.equals(f(paramContext))) {
      return;
    }
    f = paramString;
    PushPreferences.putString(paramContext, "XG_ERRCODE_SERVER", paramString);
  }
  
  public static String f(Context paramContext)
  {
    if (TextUtils.isEmpty(f))
    {
      String str = CloudManager.getInstance(paramContext).getStat();
      if (!TextUtils.isEmpty(str)) {
        f = "https://log." + str + "/log/v4/statistics/push";
      }
    }
    if (TextUtils.isEmpty(f)) {
      f = PushPreferences.getString(paramContext, "XG_ERRCODE_SERVER", null);
    }
    if (TextUtils.isEmpty(f))
    {
      paramContext = c(paramContext);
      f = "https://log." + paramContext + "/log/v4/statistics/push";
    }
    if (TextUtils.isEmpty(f)) {
      f = "https://log.tpns.tencent.com/log/v4/statistics/push";
    }
    return f;
  }
  
  public static void f(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.equals(g(paramContext))) {
      return;
    }
    g = paramString;
    PushPreferences.putString(paramContext, "XG_CUSTOMEVEN_SERVER", paramString);
  }
  
  public static String g(Context paramContext)
  {
    if (TextUtils.isEmpty(g))
    {
      String str = CloudManager.getInstance(paramContext).getCustom();
      if (!TextUtils.isEmpty(str)) {
        g = "https://log." + str + "/log/v4/statistics/push";
      }
    }
    if (TextUtils.isEmpty(g)) {
      g = PushPreferences.getString(paramContext, "XG_CUSTOMEVEN_SERVER", null);
    }
    if (TextUtils.isEmpty(g))
    {
      paramContext = c(paramContext);
      g = "https://log." + paramContext + "/log/v4/statistics/push";
    }
    if (TextUtils.isEmpty(g)) {
      g = "https://stat.api.tpns.tencent.com/log/v4/statistics/push";
    }
    return g;
  }
  
  public static void g(Context paramContext, String paramString)
  {
    PushPreferences.putString(paramContext, "XG_GUID_SERVER", paramString);
  }
  
  public static String h(Context paramContext)
  {
    if (TextUtils.isEmpty(h))
    {
      String str = CloudManager.getInstance(paramContext).getLog();
      if (!TextUtils.isEmpty(str)) {
        h = "https://stat." + str + "/v3/mobile/log/upload";
      }
    }
    if (TextUtils.isEmpty(h))
    {
      paramContext = c(paramContext);
      h = "https://stat." + paramContext + "/v3/mobile/log/upload";
    }
    if (TextUtils.isEmpty(h)) {
      h = "https://stat.api.tpns.tencent.com/v3/mobile/log/upload";
    }
    return h;
  }
  
  public static String i(Context paramContext)
  {
    if (TextUtils.isEmpty(i))
    {
      paramContext = c(paramContext);
      i = "https://log." + paramContext + "/device/v4/get_offline_msg";
    }
    return i;
  }
  
  public static boolean j(Context paramContext)
  {
    try
    {
      boolean bool = PushPreferences.getBoolean(paramContext, "IS_POWER_SAVE_MODE", false);
      return bool;
    }
    catch (Throwable paramContext)
    {
      Logger.w("XGApiConfigImpl", "isPowerSaveMode Throwable: " + paramContext);
    }
    return false;
  }
  
  public static long k(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      long l;
      try
      {
        l = c;
        return l;
      }
      finally {}
      if (c != -1L)
      {
        l = c;
        continue;
      }
      if (c == -1L)
      {
        paramContext = CommonHelper.getMetaData(paramContext, "XG_OLD_ACCESS_ID", null);
        if (paramContext == null) {}
      }
      try
      {
        c = Long.valueOf(paramContext.toString().replace("L", "")).longValue();
        if (c == -1L) {
          Logger.d("XGApiConfigImpl", "Not set freeVersionAccessId");
        }
        l = c;
      }
      catch (Throwable paramContext)
      {
        Logger.w("XGApiConfigImpl", "get freeVersionAccessId from getMetaData failed: ", paramContext);
        c = -1L;
      }
    }
  }
  
  public static boolean l(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return true;
      try
      {
        j = PushMd5Pref.getInt(paramContext, paramContext.getPackageName() + ".enableService", j);
        int k = j;
        if (k == 0) {
          return false;
        }
      }
      catch (Throwable paramContext)
      {
        Logger.w("XGApiConfigImpl", "unexpected for isEnableService");
      }
    }
    return true;
  }
  
  public static void m(Context paramContext)
  {
    long l = System.currentTimeMillis();
    try
    {
      PushPreferences.putBoolean(paramContext, "IS_REGISTERED", true);
      PushPreferences.putLong(paramContext, "REGISTERED_TIME", l);
      return;
    }
    catch (Throwable paramContext)
    {
      Logger.w("XGApiConfigImpl", "unexpected for setRegisterSuccess: " + paramContext.getMessage());
    }
  }
  
  public static void n(Context paramContext)
  {
    try
    {
      PushPreferences.putBoolean(paramContext, "IS_REGISTERED", false);
      PushPreferences.putLong(paramContext, "REGISTERED_TIME", 0L);
      return;
    }
    catch (Throwable paramContext)
    {
      Logger.w("XGApiConfigImpl", "unexpected for clearRegistered: " + paramContext.getMessage());
    }
  }
  
  public static boolean o(Context paramContext)
  {
    if (p(paramContext)) {
      return false;
    }
    try
    {
      boolean bool = PushPreferences.getBoolean(paramContext, "IS_REGISTERED", false);
      return bool;
    }
    catch (Throwable paramContext)
    {
      Logger.w("XGApiConfigImpl", "unexpected for isRegistered: " + paramContext.getMessage());
    }
    return false;
  }
  
  private static boolean p(Context paramContext)
  {
    try
    {
      long l1 = PushPreferences.getLong(paramContext, "REGISTERED_TIME", 0L);
      long l2 = System.currentTimeMillis();
      return l2 - l1 > 3600000L;
    }
    catch (Throwable paramContext)
    {
      Logger.w("XGApiConfigImpl", "unexpected for isRegisterExpire: " + paramContext.getMessage());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.core.a
 * JD-Core Version:    0.7.0.1
 */