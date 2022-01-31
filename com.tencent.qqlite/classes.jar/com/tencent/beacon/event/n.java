package com.tencent.beacon.event;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import com.tencent.beacon.a.b.e.a;
import com.tencent.beacon.a.i;
import com.tencent.beacon.b.a.b;
import com.tencent.beacon.upload.UploadHandleListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class n
  implements com.tencent.beacon.a.b.b, com.tencent.beacon.a.b.f, com.tencent.beacon.a.b.g
{
  public static boolean a;
  private static n c = null;
  private static int i = 100;
  public final Context b;
  private e d = null;
  private h e = null;
  private h f = null;
  private boolean g = true;
  private boolean h = false;
  private com.tencent.beacon.upload.g j;
  private boolean k;
  private int l = 0;
  
  private n(Context paramContext, boolean paramBoolean, com.tencent.beacon.upload.g paramg, UploadHandleListener paramUploadHandleListener, e parame)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.c(" the context is null! init UserActionRecord failed!", new Object[0]);
      this.b = null;
      return;
    }
    Context localContext = paramContext.getApplicationContext();
    if (localContext != null)
    {
      this.b = localContext;
      if (com.tencent.beacon.a.e.m() == null) {
        com.tencent.beacon.a.e.a(this.b);
      }
      this.j = paramg;
      if (paramg != null)
      {
        paramg.a(0, new o(paramContext));
        paramg.a(paramUploadHandleListener);
      }
      paramUploadHandleListener = com.tencent.beacon.a.b.c.a(this.b);
      paramUploadHandleListener.a(this);
      paramUploadHandleListener.a(this);
      paramUploadHandleListener.a(1, this);
      paramUploadHandleListener.a(0, paramg);
      paramUploadHandleListener.a(1, paramg);
      if (parame == null) {
        break label208;
      }
    }
    label208:
    for (this.d = parame;; this.d = new e())
    {
      this.e = new a(paramContext);
      this.f = new j(paramContext);
      this.g = paramBoolean;
      return;
      this.b = paramContext;
      break;
    }
  }
  
  public static n a(Context paramContext, boolean paramBoolean, com.tencent.beacon.upload.g paramg, UploadHandleListener paramUploadHandleListener, e parame)
  {
    try
    {
      if (c == null)
      {
        paramBoolean = a(paramContext);
        a = paramBoolean;
        if (!paramBoolean)
        {
          com.tencent.beacon.d.a.e(" ua create instance ", new Object[0]);
          paramContext = new n(paramContext, true, paramg, paramUploadHandleListener, null);
          c = paramContext;
          paramContext.a(true);
        }
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public static com.tencent.beacon.upload.g a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      paramContext = com.tencent.beacon.upload.h.a(paramContext, paramBoolean);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private void a(int paramInt)
  {
    try
    {
      this.l = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static boolean a(Context paramContext)
  {
    try
    {
      int m = Integer.parseInt(com.tencent.beacon.a.a.b(paramContext, "key_initsdktimes", "0"));
      String str = com.tencent.beacon.a.a.b(paramContext, "key_initsdkdate", "");
      if (!com.tencent.beacon.b.a.g().equals(str))
      {
        com.tencent.beacon.a.a.c(paramContext, com.tencent.beacon.b.a.g());
        m = 0;
      }
      if (m <= i)
      {
        com.tencent.beacon.a.a.b(paramContext, m + 1);
        return false;
      }
      bool = true;
      com.tencent.beacon.d.a.c(" set init times failed! ", new Object[0]);
    }
    catch (Exception paramContext)
    {
      try
      {
        com.tencent.beacon.d.a.e(" sdk init max times", new Object[0]);
        return true;
      }
      catch (Exception paramContext)
      {
        boolean bool;
        break label85;
      }
      paramContext = paramContext;
      bool = false;
    }
    label85:
    return bool;
  }
  
  public static boolean a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2)
  {
    com.tencent.beacon.d.a.e(" onUA: %s,%b,%d,%d,%b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2) });
    if (!m()) {
      return false;
    }
    n localn = d();
    if (localn.d.a(paramString))
    {
      com.tencent.beacon.d.a.c("onUserAction return false, because eventName:[%s] is not allowed in server strategy!", new Object[] { paramString });
      return false;
    }
    h localh;
    if ((!paramBoolean1) || ((paramBoolean1) && (localn.d.b(paramString)))) {
      if (paramBoolean2) {
        localh = localn.o();
      }
    }
    while (localh != null)
    {
      return localh.a(a.a(localn.b, paramString, paramBoolean1, paramLong1, paramLong2, paramMap));
      localh = localn.n();
      continue;
      com.tencent.beacon.d.a.c("onUserAction return false, because eventName:[%s] is sampled by svr rate!", new Object[] { paramString });
      return false;
    }
    return false;
  }
  
  protected static boolean a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, c... paramVarArgs)
  {
    com.tencent.beacon.d.a.a(" onMergeUserActionCommon start", new Object[0]);
    int m;
    if (paramVarArgs == null)
    {
      m = 0;
      com.tencent.beacon.d.a.e(" onMergeUserActionCommon:%s %b   elapase:%d  size:%d  isRealTime:%b  , items:%d", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2), Integer.valueOf(m) });
      if (m()) {
        break label87;
      }
    }
    for (;;)
    {
      return false;
      m = paramVarArgs.length;
      break;
      label87:
      Object localObject = d();
      if (((n)localObject).d.a(paramString))
      {
        com.tencent.beacon.d.a.c("onMergeUserAction return false, because eventName:[%s] is not allowed in server strategy!", new Object[] { paramString });
        return false;
      }
      if (paramBoolean2) {}
      for (localObject = ((n)localObject).o(); localObject != null; localObject = ((n)localObject).n()) {
        return ((h)localObject).a(paramString, paramBoolean1, paramLong1, paramLong2, paramVarArgs);
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    try
    {
      this.h = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static n d()
  {
    try
    {
      n localn = c;
      return localn;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    try
    {
      if (paramBoolean != h())
      {
        h localh = n();
        if (localh != null) {
          localh.a(paramBoolean);
        }
        localh = o();
        if (localh != null) {
          localh.a(paramBoolean);
        }
        this.k = paramBoolean;
      }
      return;
    }
    finally {}
  }
  
  public static void e()
  {
    n localn = d();
    if ((localn != null) && (localn.b != null))
    {
      com.tencent.beacon.upload.h.a(localn.b, false);
      a("rqd_appexited", true, 0L, 0L, null, false);
    }
    for (;;)
    {
      if (localn != null) {
        localn.d(false);
      }
      return;
      com.tencent.beacon.d.a.d("onAppExited:ua is null", new Object[0]);
    }
  }
  
  public static boolean g()
  {
    n localn = d();
    if (localn == null) {
      com.tencent.beacon.d.a.c(" ua module not ready!", new Object[0]);
    }
    while (!m()) {
      return false;
    }
    return localn.i();
  }
  
  private static boolean m()
  {
    Object localObject = d();
    if (localObject == null)
    {
      com.tencent.beacon.d.a.d("isModuleAble:not init ua", new Object[0]);
      return false;
    }
    boolean bool2 = ((n)localObject).h();
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (((n)localObject).p()) {
        bool1 = ((n)localObject).q();
      }
    }
    if (bool1)
    {
      e locale = ((n)localObject).d;
      if (locale != null)
      {
        localObject = com.tencent.beacon.a.h.f(((n)localObject).b);
        if (((com.tencent.beacon.a.a.d)localObject).k + ((com.tencent.beacon.a.a.d)localObject).j >= locale.f())
        {
          com.tencent.beacon.d.a.c(" reach daily consume limited! %d ", new Object[] { Integer.valueOf(locale.f()) });
          return false;
        }
      }
    }
    return bool1;
  }
  
  private h n()
  {
    try
    {
      h localh = this.e;
      return localh;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private h o()
  {
    try
    {
      h localh = this.f;
      return localh;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean p()
  {
    try
    {
      boolean bool = this.g;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean q()
  {
    try
    {
      boolean bool = this.h;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void r()
  {
    try
    {
      if ((!h()) && (!this.d.n())) {
        return;
      }
      Object localObject = com.tencent.beacon.a.b.c.a(this.b);
      if (localObject != null)
      {
        localObject = ((com.tencent.beacon.a.b.c)localObject).b().b(1);
        if (localObject != null)
        {
          localObject = ((e.a)localObject).b();
          if ((localObject != null) && (!"".equals(((String)localObject).trim())))
          {
            new g(this.b).a(false);
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      com.tencent.beacon.d.a.c(" startHeart failed! " + localException.getMessage(), new Object[0]);
    }
  }
  
  private void s()
  {
    if (com.tencent.beacon.a.g.a(this.b) == null)
    {
      com.tencent.beacon.d.a.c(" DeviceInfo == null?,return", new Object[0]);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("A33", com.tencent.beacon.a.g.k(this.b));
    localHashMap.put("A63", "Y");
    if (com.tencent.beacon.a.a.c(this.b))
    {
      localHashMap.put("A21", "Y");
      label82:
      if (!com.tencent.beacon.a.b.c.a(this.b).d()) {
        break label279;
      }
      localHashMap.put("A45", "Y");
      label108:
      if (!com.tencent.beacon.a.a.g(this.b)) {
        break label295;
      }
      localHashMap.put("A66", "F");
    }
    for (;;)
    {
      for (;;)
      {
        localHashMap.put("A68", com.tencent.beacon.a.a.h(this.b));
        a("rqd_applaunched", true, 0L, 0L, localHashMap, true);
        try
        {
          if (!this.d.m()) {
            break;
          }
          int m = this.d.l();
          com.tencent.beacon.a.d.a().a(106, new f(this.b, m), m * 1000, m * 1000);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.beacon.d.a.c(" startAutoLaunchEvent failed! ", new Object[0]);
          com.tencent.beacon.d.a.b(" startAutoLaunchEvent failed! " + localException.getMessage(), new Object[0]);
          return;
        }
      }
      localException.put("A21", "N");
      break label82;
      label279:
      localException.put("A45", "N");
      break label108;
      label295:
      localException.put("A66", "B");
    }
  }
  
  public final void a()
  {
    a(l() + 1);
  }
  
  public final void a(com.tencent.beacon.a.b.e parame)
  {
    if (parame != null)
    {
      parame = parame.b(1);
      if (parame != null)
      {
        boolean bool = parame.a();
        if (h() != bool)
        {
          com.tencent.beacon.d.a.f("UAR onCommonStrategyChange setUsable:%b ", new Object[] { Boolean.valueOf(bool) });
          d(bool);
        }
      }
    }
  }
  
  public final void a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0) && (this.d != null)) {
      this.d.a(paramMap);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = com.tencent.beacon.a.b.c.a(this.b);
    if (localObject != null)
    {
      localObject = ((com.tencent.beacon.a.b.c)localObject).b().b(1);
      if ((localObject != null) && (((e.a)localObject).a() != paramBoolean))
      {
        ((e.a)localObject).a(paramBoolean);
        if (paramBoolean != h()) {
          d(paramBoolean);
        }
      }
    }
  }
  
  public final boolean a(List<String> paramList)
  {
    com.tencent.beacon.d.a.a(" testSpeedIp start", new Object[0]);
    if (!m()) {
      return false;
    }
    if ((paramList == null) || (paramList.size() <= 0))
    {
      com.tencent.beacon.d.a.c(" ipList == null || ipList.size() <= 0", new Object[0]);
      return true;
    }
    paramList = new Runnable()
    {
      public final void run()
      {
        if (this.a != null)
        {
          com.tencent.beacon.d.a.b(" start to ip test:", new Object[0]);
          String[] arrayOfString = this.a;
          int j = arrayOfString.length;
          int i = 0;
          if (i < j)
          {
            String str = arrayOfString[i];
            com.tencent.beacon.d.a.b(" ip:" + str, new Object[0]);
            for (long l1 = -1L;; l1 = l2)
            {
              try
              {
                localObject = str.split(":");
                if ((localObject != null) && (localObject.length == 2)) {
                  break label186;
                }
                com.tencent.beacon.d.a.c(" ip wrong format ,not ip:port " + str, new Object[0]);
              }
              catch (Throwable localThrowable)
              {
                for (;;)
                {
                  Object localObject;
                  label186:
                  long l2;
                  localThrowable.printStackTrace();
                  continue;
                  boolean bool = false;
                }
              }
              com.tencent.beacon.d.a.b(" elapse:" + l1, new Object[0]);
              localObject = new HashMap(1);
              ((Map)localObject).put("A29", str);
              if (l1 <= 0L) {
                break label218;
              }
              bool = true;
              n.a("rqd_ipSpeed", bool, l1, 0L, (Map)localObject, true);
              i += 1;
              break;
              l2 = com.tencent.beacon.b.a.a(localObject[0], Integer.parseInt(localObject[1]));
            }
          }
        }
        label218:
      }
    };
    com.tencent.beacon.a.d.a().a(paramList);
    return true;
  }
  
  public final void b()
  {
    c(true);
    for (;;)
    {
      try
      {
        localObject = com.tencent.beacon.a.b.c.a(this.b).b();
        if (localObject != null) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int n;
        long l1;
        long l2;
        long l3;
        localThrowable.printStackTrace();
        com.tencent.beacon.d.a.d(" common query end error %s", new Object[] { localThrowable.toString() });
        continue;
        m = -1;
        break label758;
        m = 0;
        continue;
        com.tencent.beacon.d.a.b("event module is disable", new Object[0]);
        continue;
      }
      if ((l() < 2) && (com.tencent.beacon.upload.h.a(this.b).b()) && (i.a(this.b).a("sig_1")))
      {
        com.tencent.beacon.d.a.e(" get lock %s do singleton!", new Object[] { "sig_1" });
        if ((this.d.k()) || (this.d.r()))
        {
          m = this.d.j();
          n = this.d.i();
          if ((m > 0) && (n > 0))
          {
            localObject = new com.tencent.beacon.a.c(this.b, m, n, new m(this.b), this.d.k(), this.d.r(), this.d.q());
            com.tencent.beacon.a.d.a().a(104, (Runnable)localObject, m * 1000, m * 1000);
          }
        }
        if (com.tencent.beacon.upload.h.a(this.b).c())
        {
          r();
          s();
          localObject = com.tencent.beacon.a.h.b(this.b);
          if (localObject != null)
          {
            l1 = ((com.tencent.beacon.a.a.d)localObject).d;
            l2 = ((com.tencent.beacon.a.a.d)localObject).e;
            l3 = ((com.tencent.beacon.a.a.d)localObject).e;
            localObject = new HashMap();
            ((HashMap)localObject).put("A64", l1 + l2);
            ((HashMap)localObject).put("A65", l3);
            if (a("rqd_sdk_net_consumed", true, 0L, 0L, (Map)localObject, false)) {
              UserAction.clearSDKTotalConsume(this.b);
            }
          }
        }
      }
      try
      {
        localObject = com.tencent.beacon.a.a.b(this.b, "rqd_model", "");
        boolean bool = com.tencent.beacon.a.g.m().equals(localObject);
        if (!bool) {
          break label695;
        }
      }
      catch (Exception localException1)
      {
        Set localSet;
        com.tencent.beacon.d.a.c(" save modelEvent upload flag failed! ", new Object[0]);
        continue;
        Runnable local4 = new Runnable()
        {
          public final void run()
          {
            if (com.tencent.beacon.a.e.m() == null)
            {
              com.tencent.beacon.d.a.c(" model even common info == null?,return", new Object[0]);
              return;
            }
            Object localObject1 = l.a(n.this.b);
            if (localObject1 == null)
            {
              com.tencent.beacon.d.a.c(" UADeviceInfo == null?,return", new Object[0]);
              return;
            }
            Object localObject2 = com.tencent.beacon.a.g.a(n.this.b);
            HashMap localHashMap = new HashMap();
            localHashMap.put("A9", ((l)localObject1).j());
            localHashMap.put("A10", ((l)localObject1).a());
            localHashMap.put("A11", ((l)localObject1).g());
            localHashMap.put("A12", ((l)localObject1).h());
            localHashMap.put("A13", ((l)localObject1).i());
            localHashMap.put("A14", ((l)localObject1).e());
            localHashMap.put("A15", ((l)localObject1).f());
            localHashMap.put("A16", ((l)localObject1).c());
            localHashMap.put("A17", ((l)localObject1).b());
            localHashMap.put("A18", ((l)localObject1).d());
            localHashMap.put("A20", com.tencent.beacon.a.g.f(n.this.b));
            localHashMap.put("A22", l.b(n.this.b));
            localHashMap.put("A30", ((com.tencent.beacon.a.g)localObject2).i() + "m");
            localHashMap.put("A33", com.tencent.beacon.a.g.k(n.this.b));
            localHashMap.put("A52", ((l)localObject1).k());
            localHashMap.put("A53", ((l)localObject1).l());
            localHashMap.put("A54", ((l)localObject1).m());
            localHashMap.put("A55", ((l)localObject1).n());
            localHashMap.put("A56", ((l)localObject1).o());
            localHashMap.put("A57", ((l)localObject1).p());
            localHashMap.put("A58", ((l)localObject1).q());
            localObject2 = new StringBuilder();
            Context localContext = n.this.b;
            localObject1 = "0";
            long l = com.tencent.beacon.a.g.i(localContext);
            if (l > 0L) {
              localObject1 = l / 1024L / 1024L;
            }
            localHashMap.put("A59", (String)localObject1 + "m");
            localHashMap.put("A69", com.tencent.beacon.a.g.g(n.this.b));
            localObject1 = com.tencent.beacon.b.a.a(new String[] { "/system/bin/sh", "-c", "getprop ro.build.fingerprint" });
            if ((localObject1 != null) && (((List)localObject1).size() > 0)) {}
            for (localObject1 = (String)((List)localObject1).get(0);; localObject1 = "")
            {
              localHashMap.put("A82", localObject1);
              n.a("rqd_model", true, 0L, 0L, localHashMap, true);
              return;
            }
          }
        };
        com.tencent.beacon.a.d.a().a(local4, 50000L);
        try
        {
          com.tencent.beacon.a.a.a(this.b, "rqd_model", com.tencent.beacon.a.g.m());
        }
        catch (Exception localException2)
        {
          com.tencent.beacon.d.a.c(" save modelEvent upload flag failed! ", new Object[0]);
          localException2.printStackTrace();
        }
        continue;
        m = 0;
        continue;
        if (m <= 0) {
          continue;
        }
        m = 1;
        continue;
      }
      if (this.d.o())
      {
        m = Process.myUid();
        l1 = TrafficStats.getUidRxBytes(m);
        l2 = TrafficStats.getUidTxBytes(m);
        if ((l1 == -1L) || (l2 == -1L)) {
          break label753;
        }
        m = 1;
        if (m != 0)
        {
          localObject = new Runnable()
          {
            public final void run()
            {
              n.a(n.this);
            }
          };
          com.tencent.beacon.a.d.a().a((Runnable)localObject, 50000L);
          m = this.d.p();
          if (m > 0)
          {
            localObject = new com.tencent.beacon.a.b(this.b);
            com.tencent.beacon.a.d.a().a(107, (Runnable)localObject, 0L, m * 1000);
          }
          new com.tencent.beacon.a.f().a(this.b);
        }
      }
      return;
      localObject = ((com.tencent.beacon.a.b.e)localObject).b(1);
      if ((localObject != null) && (this.d != null))
      {
        localSet = ((e.a)localObject).d();
        if ((localSet != null) && (localSet.size() > 0)) {
          this.d.a(localSet);
        }
        localSet = ((e.a)localObject).g();
        if ((localSet != null) && (localSet.size() > 0)) {
          this.d.b(localSet);
        }
      }
      if ((!h()) || (localObject == null)) {
        continue;
      }
      if (!h()) {
        continue;
      }
      m = com.tencent.beacon.a.g.p(this.b);
      break label758;
      if (m != 0)
      {
        com.tencent.beacon.d.a.e(" asyn up module %d", new Object[] { Integer.valueOf(1) });
        com.tencent.beacon.a.d.a().a(new Runnable()
        {
          public final void run()
          {
            n.this.i();
          }
        });
      }
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    if ((com.tencent.beacon.upload.h.a(this.b) != null) && (paramBoolean != com.tencent.beacon.upload.h.a(this.b).c()))
    {
      if (paramBoolean)
      {
        com.tencent.beacon.upload.h.a(this.b).a(true);
        r();
        s();
      }
    }
    else {
      return;
    }
    com.tencent.beacon.upload.h.a(this.b).a(false);
    Context localContext = this.b;
    com.tencent.beacon.a.d.a().a(108, true);
    com.tencent.beacon.a.a.a(localContext, "HEART_DENGTA", com.tencent.beacon.b.a.g());
    com.tencent.beacon.d.a.a("heartbeat uploaded sucess!", new Object[0]);
  }
  
  public final boolean b(List<String> paramList)
  {
    if (!m()) {
      return false;
    }
    if ((paramList == null) || (paramList.size() <= 0))
    {
      com.tencent.beacon.d.a.c(" dnsList == null || dnsList.size() <= 0", new Object[0]);
      return true;
    }
    paramList = new Runnable()
    {
      public final void run()
      {
        int i;
        String str;
        a.b localb;
        if (this.a != null)
        {
          com.tencent.beacon.d.a.b(" start domain test:", new Object[0]);
          String[] arrayOfString = this.a;
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            str = arrayOfString[i];
            com.tencent.beacon.d.a.b(" dns:" + str, new Object[0]);
            localb = com.tencent.beacon.b.a.a(str, false);
            if (localb != null) {
              break label77;
            }
          }
        }
        return;
        label77:
        long l = localb.a + localb.b + localb.c + localb.d + localb.e;
        com.tencent.beacon.d.a.b(" elapse:" + l, new Object[0]);
        HashMap localHashMap = new HashMap(1);
        localHashMap.put("A34", str);
        localHashMap.put("A35", String.valueOf(localb.a));
        localHashMap.put("A36", String.valueOf(localb.c));
        localHashMap.put("A37", String.valueOf(localb.d));
        localHashMap.put("A38", String.valueOf(localb.e));
        localHashMap.put("A40", String.valueOf(localb.b));
        if (l > 0L) {}
        for (boolean bool = true;; bool = false)
        {
          n.a("rqd_domainSpeed", bool, l, 0L, localHashMap, true);
          i += 1;
          break;
        }
      }
    };
    com.tencent.beacon.d.a.a(" post the test task", new Object[0]);
    com.tencent.beacon.a.d.a().a(paramList);
    return true;
  }
  
  public final void c()
  {
    Context localContext = this.b;
    com.tencent.beacon.d.a.a(" RecordDAO.deleteRecords() start", new Object[0]);
    com.tencent.beacon.d.a.e(" ua first clean :%d", new Object[] { Integer.valueOf(com.tencent.beacon.a.a.a.a(localContext, new int[] { 1, 2, 3, 4 }, -1L, 9223372036854775807L)) });
    com.tencent.beacon.d.a.e(" ua remove strategy :%d", new Object[] { Integer.valueOf(com.tencent.beacon.a.g.b(this.b, 101)) });
  }
  
  public final void f()
  {
    com.tencent.beacon.d.a.a(" closeUseInfoEvent start", new Object[0]);
    try
    {
      this.d.a(false);
      com.tencent.beacon.a.d.a().a(104, true);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.d.a.d(" closeUseInfoEvent function error:" + localException.getMessage(), new Object[0]);
    }
  }
  
  public final boolean h()
  {
    try
    {
      boolean bool = this.k;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean i()
  {
    if (h()) {}
    for (int m = com.tencent.beacon.a.g.p(this.b);; m = -1)
    {
      if (m <= 0) {
        break label73;
      }
      try
      {
        if (this.j != null)
        {
          b localb = b.a(this.b);
          this.j.a(localb);
        }
        return true;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.d.a.c(" up common error: %s", new Object[] { localThrowable.toString() });
        localThrowable.printStackTrace();
      }
    }
    label73:
    return false;
  }
  
  public final com.tencent.beacon.upload.g j()
  {
    return this.j;
  }
  
  public final e k()
  {
    return this.d;
  }
  
  public final int l()
  {
    try
    {
      int m = this.l;
      return m;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.event.n
 * JD-Core Version:    0.7.0.1
 */