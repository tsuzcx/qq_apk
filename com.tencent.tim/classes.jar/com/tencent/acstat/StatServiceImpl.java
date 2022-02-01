package com.tencent.acstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.acstat.common.DeviceInfo;
import com.tencent.acstat.common.StatCommonHelper;
import com.tencent.acstat.common.StatLogger;
import com.tencent.acstat.common.StatPreferences;
import com.tencent.acstat.event.c;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class StatServiceImpl
{
  private static volatile long A = -1L;
  private static StatSpecifyReportedInfo B = null;
  static volatile int a;
  static volatile long b;
  static volatile long c;
  private static Handler d;
  private static volatile Map<c, Long> e = new ConcurrentHashMap();
  private static volatile Map<String, Properties> f = new ConcurrentHashMap();
  private static volatile Map<Integer, Integer> g = new ConcurrentHashMap(10);
  private static volatile long h = 0L;
  private static volatile long i = 0L;
  private static volatile long j = 0L;
  private static String k = "";
  private static volatile int l = 0;
  private static volatile String m = "";
  private static volatile String n = "";
  private static Map<String, Long> o = new ConcurrentHashMap();
  private static Map<String, Long> p = new ConcurrentHashMap();
  private static StatLogger q = StatCommonHelper.getLogger();
  private static Thread.UncaughtExceptionHandler r = null;
  private static volatile boolean s = true;
  private static Context t;
  private static volatile boolean u;
  private static volatile boolean v;
  private static volatile boolean w;
  private static Handler x;
  private static List<StatActionListener> y;
  private static volatile Runnable z;
  
  static
  {
    a = 0;
    b = 0L;
    t = null;
    c = 0L;
    u = false;
    v = false;
    w = true;
    x = null;
    y = new CopyOnWriteArrayList();
    z = null;
  }
  
  static int a(Context paramContext, boolean paramBoolean, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    int i2 = 1;
    long l1 = System.currentTimeMillis();
    if ((paramBoolean) && (l1 - i >= StatConfig.getSessionTimoutMillis())) {}
    for (int i1 = 1;; i1 = 0)
    {
      i = l1;
      if (j == 0L) {
        j = StatCommonHelper.getTomorrowStartMilliseconds();
      }
      if (l1 >= j)
      {
        j = StatCommonHelper.getTomorrowStartMilliseconds();
        if (af.a(paramContext).b(paramContext).getUserType() != 1) {
          af.a(paramContext).b(paramContext).setUserType(1);
        }
        StatConfig.b(0);
        a = 0;
        k = StatCommonHelper.getDateString(0);
        i1 = 1;
      }
      String str = k;
      if (StatCommonHelper.isSpecifyReportedValid(paramStatSpecifyReportedInfo)) {
        str = paramStatSpecifyReportedInfo.getAppKey() + k;
      }
      if (!p.containsKey(str)) {
        i1 = i2;
      }
      for (;;)
      {
        if (i1 != 0)
        {
          if (StatCommonHelper.isSpecifyReportedValid(paramStatSpecifyReportedInfo)) {
            break label226;
          }
          if (StatConfig.c() >= StatConfig.getMaxDaySessionNumbers()) {
            break label215;
          }
          StatCommonHelper.checkFirstTimeActivate(paramContext);
          a(paramContext, null);
        }
        for (;;)
        {
          p.put(str, Long.valueOf(1L));
          paramBoolean = s;
          s = false;
          return l;
          label215:
          q.e("Exceed StatConfig.getMaxDaySessionNumbers().");
          continue;
          label226:
          a(paramContext, paramStatSpecifyReportedInfo);
        }
      }
    }
  }
  
  static void a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        paramContext = paramContext.getApplicationContext();
        if ((d != null) || (!b(paramContext))) {
          continue;
        }
        t = paramContext;
        HandlerThread localHandlerThread = new HandlerThread("StatService");
        localHandlerThread.start();
        d = new Handler(localHandlerThread.getLooper());
        k = StatCommonHelper.getDateString(0);
        h = System.currentTimeMillis() + StatConfig.i;
        d.post(new j(paramContext));
      }
      finally {}
    }
  }
  
  static void a(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (c(paramContext) != null)
    {
      if (StatConfig.isDebugEnable()) {
        q.d("start new session, specifyReport:" + paramStatSpecifyReportedInfo);
      }
      if ((paramStatSpecifyReportedInfo == null) || (l == 0)) {
        l = StatCommonHelper.getNextSessionID();
      }
      StatConfig.a(0);
      StatConfig.b();
      new ab(new com.tencent.acstat.event.g(paramContext, l, b(), paramStatSpecifyReportedInfo)).a();
    }
  }
  
  static boolean a()
  {
    if (a >= 2)
    {
      b = System.currentTimeMillis();
      return true;
    }
    return false;
  }
  
  static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static void addActionListener(StatActionListener paramStatActionListener)
  {
    y.add(paramStatActionListener);
  }
  
  static JSONObject b()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      if (StatConfig.b.d != 0) {
        localJSONObject2.put("v", StatConfig.b.d);
      }
      localJSONObject1.put(Integer.toString(StatConfig.b.a), localJSONObject2);
      localJSONObject2 = new JSONObject();
      if (StatConfig.a.d != 0) {
        localJSONObject2.put("v", StatConfig.a.d);
      }
      localJSONObject1.put(Integer.toString(StatConfig.a.a), localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      q.e(localJSONException);
    }
    return localJSONObject1;
  }
  
  private static void b(Context paramContext, StatAccount paramStatAccount, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    try
    {
      new ab(new com.tencent.acstat.event.a(paramContext, a(paramContext, false, paramStatSpecifyReportedInfo), paramStatAccount, paramStatSpecifyReportedInfo)).a();
      return;
    }
    catch (Throwable paramContext)
    {
      q.e(paramContext);
    }
  }
  
  static boolean b(Context paramContext)
  {
    boolean bool2 = false;
    long l1 = StatPreferences.getLong(paramContext, StatConfig.c, 0L);
    long l2 = StatCommonHelper.getSDKLongVersion("2.4.2");
    boolean bool1 = true;
    if (l2 <= l1)
    {
      q.error("MTA is disable for current version:" + l2 + ",wakeup version:" + l1);
      bool1 = false;
    }
    l1 = StatPreferences.getLong(paramContext, StatConfig.d, 0L);
    if (l1 > System.currentTimeMillis())
    {
      q.error("MTA is disable for current time:" + System.currentTimeMillis() + ",wakeup time:" + l1);
      bool1 = bool2;
    }
    for (;;)
    {
      StatConfig.setEnableStatService(bool1);
      return bool1;
    }
  }
  
  /* Error */
  static Handler c(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 231	com/tencent/acstat/StatServiceImpl:d	Landroid/os/Handler;
    //   3: ifnonnull +21 -> 24
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 231	com/tencent/acstat/StatServiceImpl:d	Landroid/os/Handler;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull +7 -> 21
    //   17: aload_0
    //   18: invokestatic 390	com/tencent/acstat/StatServiceImpl:a	(Landroid/content/Context;)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: getstatic 231	com/tencent/acstat/StatServiceImpl:d	Landroid/os/Handler;
    //   27: areturn
    //   28: astore_0
    //   29: getstatic 93	com/tencent/acstat/StatServiceImpl:q	Lcom/tencent/acstat/common/StatLogger;
    //   32: aload_0
    //   33: invokevirtual 392	com/tencent/acstat/common/StatLogger:error	(Ljava/lang/Throwable;)V
    //   36: iconst_0
    //   37: invokestatic 388	com/tencent/acstat/StatConfig:setEnableStatService	(Z)V
    //   40: goto -19 -> 21
    //   43: astore_0
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_0
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	paramContext	Context
    //   12	2	1	localHandler	Handler
    // Exception table:
    //   from	to	target	type
    //   17	21	28	java/lang/Throwable
    //   9	13	43	finally
    //   17	21	43	finally
    //   21	24	43	finally
    //   29	40	43	finally
    //   44	47	43	finally
  }
  
  static void c()
  {
    a = 0;
    b = 0L;
  }
  
  public static void commitEvents(Context paramContext, int paramInt)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      if (StatConfig.isDebugEnable()) {
        q.i("commitEvents, maxNumber=" + paramInt);
      }
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.commitEvents() can not be null!");
        return;
      }
      if ((paramInt < -1) || (paramInt == 0))
      {
        q.error("The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
        return;
      }
    } while ((!NetworkManager.getInstance(paramContext).isNetworkAvailable()) || (c(paramContext) == null));
    d.post(new p(paramContext, paramInt));
  }
  
  static void d()
  {
    a += 1;
    b = System.currentTimeMillis();
    flushDataToDB(t);
  }
  
  static void d(Context paramContext)
  {
    c = System.currentTimeMillis() + 60000 * StatConfig.getSendPeriodMinutes();
    StatPreferences.putLong(paramContext, "last_period_ts", c);
    commitEvents(paramContext, -1);
  }
  
  static void e(Context paramContext)
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    paramContext = getContext(paramContext);
    if (paramContext == null)
    {
      q.error("The Context of StatService.sendNetworkDetector() can not be null!");
      return;
    }
    try
    {
      com.tencent.acstat.event.e locale = new com.tencent.acstat.event.e(paramContext);
      g.b(paramContext).a(locale, new q());
      return;
    }
    catch (Throwable paramContext)
    {
      q.e(paramContext);
    }
  }
  
  public static void flushDataToDB(Context paramContext)
  {
    if (!StatConfig.isEnableStatService()) {}
    while (StatConfig.m <= 0) {
      return;
    }
    paramContext = getContext(paramContext);
    if (paramContext == null)
    {
      q.error("The Context of StatService.testSpeed() can not be null!");
      return;
    }
    af.a(paramContext).c();
  }
  
  public static Properties getCommonKeyValueForKVEvent(String paramString)
  {
    return (Properties)f.get(paramString);
  }
  
  public static Context getContext(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext;
    }
    return t;
  }
  
  public static boolean isBackground()
  {
    return v;
  }
  
  public static boolean isForeground()
  {
    return v;
  }
  
  public static void onLowMemory(Context paramContext)
  {
    if (!StatConfig.isEnableStatService()) {}
    while (c(getContext(paramContext)) == null) {
      return;
    }
    d.post(new z(paramContext));
  }
  
  public static void onStop(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
    } while (c(paramContext) == null);
    d.post(new y(paramContext));
  }
  
  public static void removeActionListener(StatActionListener paramStatActionListener)
  {
    y.remove(paramStatActionListener);
  }
  
  public static void reportQQ(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("context is null in reportQQ()");
        return;
      }
      StatConfig.f = paramString;
    } while (c(paramContext) == null);
    d.post(new w(paramString, paramContext, paramStatSpecifyReportedInfo));
  }
  
  public static void setCommonKeyValueForKVEvent(String paramString, Properties paramProperties)
  {
    if (StatCommonHelper.isStringValid(paramString))
    {
      if ((paramProperties != null) && (paramProperties.size() > 0))
      {
        f.put(paramString, (Properties)paramProperties.clone());
        return;
      }
      f.remove(paramString);
      return;
    }
    q.e("event_id or commonProp for setCommonKeyValueForKVEvent is invalid.");
  }
  
  public static void setContext(Context paramContext)
  {
    if (paramContext != null) {
      t = paramContext.getApplicationContext();
    }
  }
  
  public static void setEnvAttributes(Context paramContext, Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() > 512))
    {
      q.error("The map in setEnvAttributes can't be null or its size can't exceed 512.");
      return;
    }
    try
    {
      com.tencent.acstat.common.a.a(paramContext, paramMap);
      return;
    }
    catch (JSONException paramContext)
    {
      q.e(paramContext);
    }
  }
  
  public static void startNewSession(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.startNewSession() can not be null!");
        return;
      }
    } while (c(paramContext) == null);
    d.post(new v(paramContext, paramStatSpecifyReportedInfo));
  }
  
  public static boolean startStatService(Context paramContext, String paramString1, String paramString2, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
    throws Exception
  {
    for (;;)
    {
      try
      {
        if (!StatConfig.isEnableStatService())
        {
          q.error("MTA StatService is disable.");
          return false;
        }
        if (!StatConfig.isDebugEnable()) {
          break label198;
        }
        q.d("MTA SDK version, current: " + "2.4.2" + " ,required: " + paramString2);
      }
      catch (Throwable paramContext)
      {
        q.e(paramContext);
        return false;
      }
      q.error("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
      StatConfig.setEnableStatService(false);
      return false;
      label198:
      do
      {
        if (StatCommonHelper.getSDKLongVersion("2.4.2") < StatCommonHelper.getSDKLongVersion(paramString2))
        {
          paramContext = "MTA SDK version conflicted, current: " + "2.4.2" + ",required: " + paramString2;
          paramContext = paramContext + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/";
          q.error(paramContext);
          StatConfig.setEnableStatService(false);
          return false;
        }
        if (paramString1 != null) {
          StatConfig.setAppKey(paramContext, paramString1);
        }
        if (c(paramContext) != null) {
          d.post(new x(paramContext, paramStatSpecifyReportedInfo));
        }
        return true;
        if (paramContext == null) {
          break;
        }
      } while (paramString2 != null);
    }
  }
  
  public static void stopSession()
  {
    i = 0L;
  }
  
  public static void trackBeginPage(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if ((paramContext == null) || (paramString == null) || (paramString.length() == 0))
      {
        q.error("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
        return;
      }
      paramString = new String(paramString);
    } while (c(paramContext) == null);
    d.post(new t(paramString, paramContext, paramStatSpecifyReportedInfo));
  }
  
  public static void trackCustomBeginEvent(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo, String... paramVarArgs)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.trackCustomBeginEvent() can not be null!");
        return;
      }
      paramStatSpecifyReportedInfo = new c(paramString, paramVarArgs, null);
    } while (c(paramContext) == null);
    d.post(new l(paramString, paramStatSpecifyReportedInfo));
  }
  
  public static void trackCustomBeginKVEvent(Context paramContext, String paramString, Properties paramProperties, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.trackCustomBeginEvent() can not be null!");
        return;
      }
      paramProperties = new c(paramString, null, paramProperties);
    } while (c(paramContext) == null);
    d.post(new n(paramString, paramProperties));
  }
  
  public static void trackCustomEndEvent(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo, String... paramVarArgs)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.trackCustomEndEvent() can not be null!");
        return;
      }
      paramVarArgs = new c(paramString, paramVarArgs, null);
    } while (c(paramContext) == null);
    d.post(new m(paramString, paramVarArgs, paramContext, paramStatSpecifyReportedInfo));
  }
  
  public static void trackCustomEndKVEvent(Context paramContext, String paramString, Properties paramProperties, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.trackCustomEndEvent() can not be null!");
        return;
      }
      paramProperties = new c(paramString, null, paramProperties);
    } while (c(paramContext) == null);
    d.post(new o(paramString, paramProperties, paramContext, paramStatSpecifyReportedInfo));
  }
  
  public static void trackCustomEvent(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo, String... paramVarArgs)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.trackCustomEvent() can not be null!");
        return;
      }
      if (a(paramString))
      {
        q.error("The event_id of StatService.trackCustomEvent() can not be null or empty.");
        return;
      }
      paramString = new c(paramString, paramVarArgs, null);
    } while (c(paramContext) == null);
    d.post(new aa(paramContext, paramStatSpecifyReportedInfo, paramString));
  }
  
  public static void trackCustomKVEvent(Context paramContext, String paramString, Properties paramProperties, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.trackCustomEvent() can not be null!");
        return;
      }
      if (a(paramString))
      {
        q.error("The event_id of StatService.trackCustomEvent() can not be null or empty.");
        return;
      }
      paramString = new c(paramString, null, paramProperties);
    } while (c(paramContext) == null);
    d.post(new k(paramContext, paramStatSpecifyReportedInfo, paramString));
  }
  
  public static void trackCustomKVTimeIntervalEvent(Context paramContext, String paramString, Properties paramProperties, int paramInt, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        q.error("The Context of StatService.trackCustomEndEvent() can not be null!");
        return;
      }
      if (a(paramString))
      {
        q.error("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
        return;
      }
      paramString = new c(paramString, null, paramProperties);
    } while (c(paramContext) == null);
    d.post(new r(paramContext, paramStatSpecifyReportedInfo, paramString, paramInt));
  }
  
  public static void trackEndPage(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if ((paramContext == null) || (paramString == null) || (paramString.length() == 0))
      {
        q.error("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
        return;
      }
      paramString = new String(paramString);
    } while (c(paramContext) == null);
    d.post(new u(paramContext, paramString, paramStatSpecifyReportedInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.acstat.StatServiceImpl
 * JD-Core Version:    0.7.0.1
 */