package com.tencent.android.tpush.stat;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.stat.event.Event;
import com.tencent.android.tpush.stat.event.MQTTEvent;
import com.tencent.android.tpush.stat.event.c.a;
import com.tencent.android.tpush.stat.event.h;
import com.tencent.android.tpush.stat.lifecycle.MtaActivityLifeCycle;
import com.tencent.tpns.baseapi.base.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StatServiceImpl
{
  static volatile long a;
  private static Map<String, Long> b = new ConcurrentHashMap();
  private static volatile Handler c = null;
  private static volatile int d = 0;
  private static volatile String e = "";
  private static volatile String f = "";
  private static com.tencent.android.tpush.stat.b.c g = com.tencent.android.tpush.stat.b.b.b();
  private static volatile boolean h = false;
  private static volatile boolean i = true;
  private static Handler j = null;
  private static volatile Runnable k = null;
  private static long l = 0L;
  private static List<c> m = new CopyOnWriteArrayList();
  private static long n = 800L;
  private static volatile long o = -1L;
  private static Context p = null;
  private static String q;
  private static volatile SharedPreferences r;
  private static volatile SharedPreferences s;
  public static volatile boolean storedList = true;
  private static volatile SharedPreferences t;
  private static AtomicInteger u = new AtomicInteger(0);
  private static final Integer v = Integer.valueOf(3);
  
  static
  {
    a = 0L;
    q = null;
    r = null;
    s = null;
    t = null;
  }
  
  static JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      if (d.b.d != 0) {
        localJSONObject2.put("v", d.b.d);
      }
      localJSONObject1.put(Integer.toString(d.b.a), localJSONObject2);
      localJSONObject2 = new JSONObject();
      if (d.a.d != 0) {
        localJSONObject2.put("v", d.a.d);
      }
      localJSONObject1.put(Integer.toString(d.a.a), localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      g.b(localJSONException);
    }
    return localJSONObject1;
  }
  
  /* Error */
  private static void a(Application paramApplication, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +11 -> 12
    //   4: getstatic 167	android/os/Build$VERSION:SDK_INT	I
    //   7: bipush 14
    //   9: if_icmpge +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: invokestatic 172	com/tencent/android/tpush/stat/b/e:b	(Landroid/content/Context;)Landroid/content/Context;
    //   17: putstatic 93	com/tencent/android/tpush/stat/StatServiceImpl:p	Landroid/content/Context;
    //   20: getstatic 93	com/tencent/android/tpush/stat/StatServiceImpl:p	Landroid/content/Context;
    //   23: invokestatic 176	com/tencent/android/tpush/stat/StatServiceImpl:getHandler	(Landroid/content/Context;)Landroid/os/Handler;
    //   26: pop
    //   27: getstatic 74	com/tencent/android/tpush/stat/StatServiceImpl:j	Landroid/os/Handler;
    //   30: ifnonnull +13 -> 43
    //   33: new 178	android/os/Handler
    //   36: dup
    //   37: invokespecial 179	android/os/Handler:<init>	()V
    //   40: putstatic 74	com/tencent/android/tpush/stat/StatServiceImpl:j	Landroid/os/Handler;
    //   43: ldc 2
    //   45: monitorenter
    //   46: new 181	com/tencent/android/tpush/stat/StatServiceImpl$6
    //   49: dup
    //   50: lload_1
    //   51: invokespecial 184	com/tencent/android/tpush/stat/StatServiceImpl$6:<init>	(J)V
    //   54: astore_3
    //   55: new 186	com/tencent/android/tpush/stat/StatServiceImpl$7
    //   58: dup
    //   59: lload_1
    //   60: invokespecial 187	com/tencent/android/tpush/stat/StatServiceImpl$7:<init>	(J)V
    //   63: astore 4
    //   65: aload 4
    //   67: invokestatic 190	com/tencent/android/tpush/stat/StatServiceImpl:a	(Lcom/tencent/android/tpush/stat/c;)V
    //   70: aload_0
    //   71: aload_3
    //   72: invokestatic 196	com/tencent/android/tpush/stat/lifecycle/MtaActivityLifeCycle:registerActivityLifecycleCallbacks	(Landroid/app/Application;Lcom/tencent/android/tpush/stat/lifecycle/a;)Ljava/lang/Boolean;
    //   75: pop
    //   76: ldc 2
    //   78: monitorexit
    //   79: return
    //   80: astore_0
    //   81: ldc 2
    //   83: monitorexit
    //   84: aload_0
    //   85: athrow
    //   86: astore_0
    //   87: aload_0
    //   88: invokevirtual 199	java/lang/Throwable:printStackTrace	()V
    //   91: goto -15 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramApplication	Application
    //   0	94	1	paramLong	long
    //   54	18	3	local6	StatServiceImpl.6
    //   63	3	4	local7	StatServiceImpl.7
    // Exception table:
    //   from	to	target	type
    //   46	65	80	finally
    //   65	76	80	finally
    //   76	79	80	finally
    //   81	84	80	finally
    //   87	91	80	finally
    //   65	76	86	java/lang/Throwable
  }
  
  private static void a(Context paramContext, double paramDouble, long paramLong, boolean paramBoolean)
  {
    if (!d.c()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        g.e("The Context of StatService.trackBackground() can not be null!");
        return;
      }
    } while (getHandler(paramContext) == null);
    c.post(new StatServiceImpl.5(paramDouble, paramContext, paramLong));
  }
  
  private static void a(Context paramContext, int paramInt, String paramString, Throwable paramThrowable)
  {
    a(paramContext, paramInt, paramString, com.tencent.android.tpush.stat.b.b.a(paramThrowable));
  }
  
  private static void a(Context paramContext, int paramInt, String paramString, JSONArray paramJSONArray)
  {
    if (!d.c()) {
      return;
    }
    Context localContext = getContext(paramContext);
    if (localContext == null)
    {
      g.e("The Context of StatService.sendCrashEvent() can not be null!");
      return;
    }
    try
    {
      paramContext = new com.tencent.android.tpush.stat.event.d(localContext, 0, paramInt, paramJSONArray, XGPushConfig.getAccessId(paramContext));
      paramContext.a(paramString);
      if (!paramContext.a())
      {
        g.c("not contains sdk info.");
        g.c(paramJSONArray);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      g.b(paramContext);
      return;
    }
    paramString = new ArrayList();
    paramString.add(paramContext);
    b(paramString);
  }
  
  static void a(Context paramContext, long paramLong)
  {
    a(new h(paramContext, d, a(), paramLong));
  }
  
  static void a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    try
    {
      g.h("trackBackground lastForegroundTs:" + o);
      if (o > 0L)
      {
        double d2 = (System.currentTimeMillis() - o - n) / 1000.0D;
        double d1 = d2;
        if (d2 <= 0.0D) {
          d1 = 0.1D;
        }
        a(p, d1, paramLong, paramBoolean);
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        g.b(paramContext);
      }
    }
    o = -1L;
  }
  
  static void a(Context paramContext, Throwable paramThrowable)
  {
    a(paramContext, 2, null, paramThrowable);
  }
  
  static void a(SharedPreferences paramSharedPreferences)
  {
    try
    {
      Object localObject = paramSharedPreferences.getAll();
      if (localObject != null) {
        g.a("sendLocalEvent " + ((Map)localObject).size());
      }
      if ((localObject != null) && (((Map)localObject).size() > 0))
      {
        paramSharedPreferences = new ArrayList(10);
        localObject = ((Map)localObject).entrySet().iterator();
      }
      while (((Iterator)localObject).hasNext())
      {
        paramSharedPreferences.add(((Map.Entry)((Iterator)localObject).next()).getKey());
        if (paramSharedPreferences.size() == 10)
        {
          e(paramSharedPreferences);
          paramSharedPreferences.clear();
          continue;
          return;
        }
      }
    }
    catch (Throwable paramSharedPreferences)
    {
      g.f("sendLocalEvent error: " + paramSharedPreferences.toString());
    }
    e(paramSharedPreferences);
    paramSharedPreferences.clear();
  }
  
  private static void a(SharedPreferences paramSharedPreferences, List<?> paramList)
  {
    if (paramSharedPreferences == null) {
      return;
    }
    SharedPreferences.Editor localEditor;
    for (;;)
    {
      try
      {
        localEditor = paramSharedPreferences.edit();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        String str = paramList.next().toString();
        int i1 = paramSharedPreferences.getInt(str, 1);
        if ((i1 > 0) && (i1 <= d.e())) {
          localEditor.putInt(str, i1 + 1);
        } else {
          localEditor.remove(str);
        }
      }
      catch (Throwable paramSharedPreferences)
      {
        g.b(paramSharedPreferences);
        return;
      }
    }
    localEditor.commit();
  }
  
  private static void a(c paramc)
  {
    m.add(paramc);
  }
  
  static void a(Event paramEvent)
  {
    boolean bool = true;
    if (b.a(p).c())
    {
      if (storedList) {
        if (sendLocalMsg(p, 100)) {
          break label40;
        }
      }
      for (;;)
      {
        storedList = bool;
        b(paramEvent);
        return;
        label40:
        bool = false;
      }
    }
    b(Arrays.asList(new Event[] { paramEvent }));
  }
  
  static void a(List<Event> paramList)
  {
    if (b.a(p).c())
    {
      f.b(p).b(paramList, new StatServiceImpl.15(paramList));
      return;
    }
    b(paramList);
  }
  
  private static void a(List<?> paramList, SharedPreferences paramSharedPreferences)
  {
    try
    {
      paramSharedPreferences = paramSharedPreferences.edit();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramSharedPreferences.putInt(paramList.next().toString(), 1);
      }
      paramSharedPreferences.commit();
    }
    catch (Throwable paramList)
    {
      g.b(paramList);
      return;
    }
  }
  
  static boolean a(Context paramContext)
  {
    long l1 = com.tencent.android.tpush.stat.b.d.a(paramContext, d.c, 0L);
    long l2 = com.tencent.android.tpush.stat.b.b.b("2.0.6");
    boolean bool = true;
    if (l2 <= l1)
    {
      g.e("MTA is disable for current version:" + l2 + ",wakeup version:" + l1);
      bool = false;
    }
    d.b(bool);
    return bool;
  }
  
  static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  static int b(Context paramContext, long paramLong)
  {
    int i1 = 1;
    long l1 = System.currentTimeMillis();
    if (a == 0L) {
      a = com.tencent.android.tpush.stat.b.d.a(p, "_INTER_MTA_NEXT_DAY", 0L);
    }
    if (d == 0) {}
    for (;;)
    {
      if (i1 != 0)
      {
        d = com.tencent.android.tpush.stat.b.b.a();
        a = com.tencent.android.tpush.stat.b.b.c();
        com.tencent.android.tpush.stat.b.d.b(p, "_INTER_MTA_NEXT_DAY", a);
        a(paramContext, paramLong);
      }
      return d;
      if (l1 < a) {
        i1 = 0;
      }
    }
  }
  
  static void b()
  {
    try
    {
      if (r != null) {
        a(r);
      }
      if (s != null) {
        a(s);
      }
      if (t != null) {
        a(t);
      }
      return;
    }
    finally {}
  }
  
  private static void b(Context paramContext, String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramString == null) {}
    do
    {
      return;
      paramString = new String(paramString);
    } while (getHandler(paramContext) == null);
    c.post(new StatServiceImpl.4(paramString, paramContext, paramLong1, paramLong2, paramLong3));
  }
  
  static void b(Event paramEvent)
  {
    f.b(p).a(paramEvent, new StatServiceImpl.16(paramEvent));
  }
  
  static void b(List<?> paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        if ((r != null) && (s != null) && (t != null))
        {
          storedList = true;
          g.h("store event size:" + paramList.size());
          switch (f(paramList))
          {
          case 1: 
            a(paramList, s);
          }
        }
      }
      catch (Throwable paramList)
      {
        g.b(paramList);
        continue;
      }
      finally {}
      return;
      a(paramList, r);
      continue;
      a(paramList, t);
    }
  }
  
  private static void b(List<?> paramList, SharedPreferences paramSharedPreferences)
  {
    try
    {
      paramSharedPreferences = paramSharedPreferences.edit();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramSharedPreferences.remove(paramList.next().toString());
      }
      paramSharedPreferences.commit();
    }
    catch (Throwable paramList)
    {
      g.b(paramList);
      return;
    }
  }
  
  static void c(List<?> paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        if ((r != null) && (s != null) && (t != null))
        {
          g.h("delete event size:" + paramList.size());
          switch (f(paramList))
          {
          case 1: 
            b(paramList, s);
          }
        }
      }
      catch (Throwable paramList)
      {
        g.b(paramList);
        continue;
      }
      finally {}
      return;
      b(paramList, r);
      continue;
      b(paramList, t);
    }
  }
  
  public static void checkAppLunch(Context paramContext)
  {
    try
    {
      if ((paramContext instanceof Application)) {
        paramContext = (Application)paramContext;
      }
      for (;;)
      {
        boolean bool = Util.isMainProcess(paramContext);
        if ((paramContext == null) || (!bool)) {
          break;
        }
        MtaActivityLifeCycle.registerActivityLifecycleCallbacks(paramContext, new StatServiceImpl.8());
        return;
        if ((paramContext instanceof Activity)) {
          paramContext = ((Activity)paramContext).getApplication();
        } else {
          paramContext = (Application)paramContext;
        }
      }
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.d("stat", "unexpected for checkAppLunch");
    }
  }
  
  public static boolean commitEvents(Context paramContext, int paramInt)
  {
    if (!d.c()) {}
    do
    {
      return false;
      if (d.b()) {
        g.b("commitEvents, maxNumber=" + paramInt);
      }
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        g.e("The Context of StatService.commitEvents() can not be null!");
        return false;
      }
      if ((paramInt < -1) || (paramInt == 0))
      {
        g.e("The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
        return false;
      }
    } while ((!b.a(paramContext).c()) || (getHandler(paramContext) == null));
    c.post(new StatServiceImpl.13());
    return true;
  }
  
  static void d(List<?> paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        if ((r != null) && (s != null) && (t != null))
        {
          g.h("update event size:" + paramList.size());
          switch (f(paramList))
          {
          case 1: 
            a(s, paramList);
          }
        }
      }
      catch (Throwable paramList)
      {
        g.b(paramList);
        continue;
      }
      finally {}
      return;
      a(r, paramList);
      continue;
      a(t, paramList);
    }
  }
  
  static void e(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    f.b(p).b(paramList, new StatServiceImpl.2(paramList));
  }
  
  private static int f(List<?> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      try
      {
        paramList = paramList.get(0);
        if ((paramList instanceof Event))
        {
          if ((paramList instanceof MQTTEvent))
          {
            g.d("a stat instance MQTTEvent event");
            return 1;
          }
          if ((paramList instanceof com.tencent.android.tpush.stat.event.c))
          {
            g.d("a stat instance custom event");
            return 2;
          }
          g.d("other instance ErrorEvent or other");
          return 0;
        }
        paramList = new JSONObject((String)paramList);
        String str = paramList.optString("msgId", "");
        if ((str != null) && (str.length() > 0))
        {
          g.d("a stat string event msgId: " + str);
          return 1;
        }
        if (paramList.has("customEvent"))
        {
          g.d(" string customEvent");
          return 2;
        }
        g.d("other string ");
        return 0;
      }
      catch (Throwable paramList)
      {
        g.d("distinguish event error" + paramList.toString());
      }
    }
    return 0;
  }
  
  public static Context getContext(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext;
    }
    return p;
  }
  
  /* Error */
  public static Handler getHandler(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 53	com/tencent/android/tpush/stat/StatServiceImpl:c	Landroid/os/Handler;
    //   3: ifnonnull +21 -> 24
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 53	com/tencent/android/tpush/stat/StatServiceImpl:c	Landroid/os/Handler;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull +7 -> 21
    //   17: aload_0
    //   18: invokestatic 592	com/tencent/android/tpush/stat/StatServiceImpl:init	(Landroid/content/Context;)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: getstatic 53	com/tencent/android/tpush/stat/StatServiceImpl:c	Landroid/os/Handler;
    //   27: areturn
    //   28: astore_0
    //   29: getstatic 68	com/tencent/android/tpush/stat/StatServiceImpl:g	Lcom/tencent/android/tpush/stat/b/c;
    //   32: aload_0
    //   33: invokevirtual 594	com/tencent/android/tpush/stat/b/c:a	(Ljava/lang/Throwable;)V
    //   36: iconst_0
    //   37: invokestatic 448	com/tencent/android/tpush/stat/d:b	(Z)V
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
  
  public static void inerTrackBeginPage(Context paramContext, String paramString, long paramLong)
  {
    if (paramString == null) {}
    do
    {
      return;
      paramString = new String(paramString);
    } while (getHandler(paramContext) == null);
    c.post(new StatServiceImpl.3(paramString, paramContext, paramLong));
  }
  
  public static void init(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        checkAppLunch(paramContext);
        if ((c != null) || (!a(paramContext))) {
          continue;
        }
        paramContext = paramContext.getApplicationContext();
        p = paramContext;
        HandlerThread localHandlerThread = new HandlerThread("XgStat");
        localHandlerThread.start();
        c = new Handler(localHandlerThread.getLooper());
        c.post(new StatServiceImpl.1(paramContext));
      }
      finally {}
    }
  }
  
  public static void initAutoStats(Context paramContext, long paramLong)
  {
    try
    {
      if ((paramContext instanceof Application)) {
        paramContext = (Application)paramContext;
      }
      while (paramContext != null)
      {
        a(paramContext, paramLong);
        return;
        if ((paramContext instanceof Activity)) {
          paramContext = ((Activity)paramContext).getApplication();
        } else {
          try
          {
            paramContext = (Application)paramContext;
          }
          catch (Throwable paramContext)
          {
            paramContext.printStackTrace();
            paramContext = null;
          }
        }
      }
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void reportEvent(Context paramContext, Event paramEvent)
  {
    if (!d.c()) {}
    do
    {
      return;
      if (p == null) {
        init(paramContext);
      }
    } while (getHandler(getContext(paramContext)) == null);
    c.post(new StatServiceImpl.9(paramEvent));
  }
  
  public static void reportXGEvent(Context paramContext, Event paramEvent)
  {
    if (!d.c()) {
      TLogger.w("stat", "disable stat service");
    }
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        g.e("The Context of StatService.trackCustomEvent() can not be null!");
        return;
      }
    } while (getHandler(paramContext) == null);
    c.post(new StatServiceImpl.10(paramEvent));
  }
  
  public static void send3rdCaughtException(Context paramContext, String paramString, Throwable paramThrowable)
  {
    a(paramContext, 30, paramString, paramThrowable);
  }
  
  public static boolean sendLocalMsg(Context paramContext, int paramInt)
  {
    if (!d.c()) {}
    do
    {
      do
      {
        return false;
        if (d.b()) {
          g.b("commitEvents, maxNumber=" + paramInt);
        }
        paramContext = getContext(paramContext);
        if (paramContext == null)
        {
          g.e("The Context of StatService.commitEvents() can not be null!");
          return false;
        }
        if ((paramInt < -1) || (paramInt == 0))
        {
          g.e("The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
          return false;
        }
      } while (!b.a(paramContext).c());
      g.b("sendLocalMsg, maxNumber=" + paramInt);
    } while (getHandler(paramContext) == null);
    c.post(new StatServiceImpl.14());
    return true;
  }
  
  public static void sendTryCatchException(Context paramContext, String paramString, Throwable paramThrowable)
  {
    a(paramContext, 1, paramString, paramThrowable);
  }
  
  public static void setContext(Context paramContext)
  {
    if (paramContext != null) {
      p = paramContext.getApplicationContext();
    }
  }
  
  public static void setCrashMatchString(String paramString)
  {
    q = paramString;
  }
  
  public static void setupExceptionHandler(Context paramContext)
  {
    try
    {
      a.a(paramContext).a();
      return;
    }
    catch (Throwable paramContext)
    {
      g.b(paramContext);
    }
  }
  
  public static void trackBeginPage(Context paramContext, String paramString, long paramLong)
  {
    if (!d.c()) {
      return;
    }
    paramContext = getContext(paramContext);
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0))
    {
      g.e("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
      return;
    }
    inerTrackBeginPage(paramContext, paramString, paramLong);
  }
  
  public static void trackCustomKVEvent(Context paramContext, String paramString, Properties paramProperties)
  {
    if (!d.c()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        g.e("The Context of StatService.trackCustomEvent() can not be null!");
        return;
      }
      if (a(paramString))
      {
        g.e("The event_id of StatService.trackCustomEvent() can not be null or empty.");
        return;
      }
      paramProperties = new c.a(paramString, null, paramProperties);
    } while (getHandler(paramContext) == null);
    c.post(new StatServiceImpl.12(paramContext, paramString, paramProperties));
  }
  
  public static void trackEndPage(Context paramContext, String paramString, long paramLong)
  {
    if (!d.c()) {
      return;
    }
    paramContext = getContext(paramContext);
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0))
    {
      g.e("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
      return;
    }
    b(paramContext, paramString, paramLong, 0L, 0L);
  }
  
  public static void trackEndPage(Context paramContext, String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if (!d.c()) {
      return;
    }
    paramContext = getContext(paramContext);
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0))
    {
      g.e("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
      return;
    }
    b(paramContext, paramString, paramLong1, paramLong2, paramLong3);
  }
  
  public static void trackLaunchEvent(Context paramContext, int paramInt1, int paramInt2, long paramLong)
  {
    if (!d.c()) {}
    do
    {
      return;
      paramContext = getContext(paramContext);
      if (paramContext == null)
      {
        g.e("The Context of StatService.trackCustomEvent() can not be null!");
        return;
      }
    } while (getHandler(paramContext) == null);
    c.post(new StatServiceImpl.11(paramContext, paramInt1, paramInt2, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.StatServiceImpl
 * JD-Core Version:    0.7.0.1
 */