package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.b.e.a;
import com.tencent.beacon.b.a.b;
import com.tencent.beacon.upload.UploadHandleListener;
import com.tencent.beacon.upload.h;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class m
  implements com.tencent.beacon.a.b.b, com.tencent.beacon.a.b.f, com.tencent.beacon.a.b.g
{
  public static boolean a;
  private static m c = null;
  private static int i = 100;
  protected final Context b;
  private d d = null;
  private g e = null;
  private g f = null;
  private final boolean g;
  private boolean h = false;
  private boolean j = false;
  private com.tencent.beacon.upload.g k;
  private boolean l;
  private int m = 0;
  
  private m(Context paramContext, boolean paramBoolean, com.tencent.beacon.upload.g paramg, UploadHandleListener paramUploadHandleListener, d paramd)
  {
    this.b = paramContext.getApplicationContext();
    if (com.tencent.beacon.a.d.m() == null) {
      com.tencent.beacon.a.d.a(this.b);
    }
    this.k = paramg;
    if (paramg != null)
    {
      paramg.a(0, new n(paramContext));
      paramg.a(paramUploadHandleListener);
    }
    paramUploadHandleListener = com.tencent.beacon.a.b.c.a(this.b);
    paramUploadHandleListener.a(this);
    paramUploadHandleListener.a(this);
    paramUploadHandleListener.a(1, this);
    paramUploadHandleListener.a(0, paramg);
    paramUploadHandleListener.a(1, paramg);
    if (paramd != null) {}
    for (this.d = paramd;; this.d = new d())
    {
      this.e = new a(paramContext);
      this.f = new i(paramContext);
      this.g = paramBoolean;
      return;
    }
  }
  
  public static m a(Context paramContext, boolean paramBoolean, com.tencent.beacon.upload.g paramg, UploadHandleListener paramUploadHandleListener, d paramd)
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
          paramContext = new m(paramContext, true, paramg, paramUploadHandleListener, null);
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
      paramContext = h.a(paramContext, paramBoolean);
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
      this.m = paramInt;
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
      int n = Integer.parseInt(com.tencent.beacon.a.a.b(paramContext, "key_initsdktimes", "0"));
      String str = com.tencent.beacon.a.a.b(paramContext, "key_initsdkdate", "");
      if (!com.tencent.beacon.b.a.g().equals(str))
      {
        com.tencent.beacon.a.a.c(paramContext, com.tencent.beacon.b.a.g());
        n = 0;
      }
      if (n <= i)
      {
        com.tencent.beacon.a.a.b(paramContext, n + 1);
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
    m localm = d();
    if (localm.d.a(paramString))
    {
      com.tencent.beacon.d.a.c("onUserAction return false, because eventName:[%s] is not allowed in server strategy!", new Object[] { paramString });
      return false;
    }
    if (paramBoolean2) {}
    for (g localg = localm.o(); localg != null; localg = localm.n()) {
      return localg.a(com.tencent.beacon.a.e.a(localm.b, paramString, paramBoolean1, paramLong1, paramLong2, paramMap));
    }
    return false;
  }
  
  protected static boolean a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, CountItem... paramVarArgs)
  {
    com.tencent.beacon.d.a.a(" onMergeUserActionCommon start", new Object[0]);
    int n;
    if (paramVarArgs == null)
    {
      n = 0;
      com.tencent.beacon.d.a.e(" onMergeUserActionCommon:%s %b   elapase:%d  size:%d  isRealTime:%b  , items:%d", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2), Integer.valueOf(n) });
      if (m()) {
        break label85;
      }
    }
    for (;;)
    {
      return false;
      n = paramVarArgs.length;
      break;
      label85:
      Object localObject = d();
      if (((m)localObject).d.a(paramString))
      {
        com.tencent.beacon.d.a.c("onMergeUserAction return false, because eventName:[%s] is not allowed in server strategy!", new Object[] { paramString });
        return false;
      }
      if (paramBoolean2) {}
      for (localObject = ((m)localObject).o(); localObject != null; localObject = ((m)localObject).n()) {
        return ((g)localObject).a(paramString, paramBoolean1, paramLong1, paramLong2, paramVarArgs);
      }
    }
  }
  
  private void b(boolean paramBoolean)
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
  
  private void c(boolean paramBoolean)
  {
    try
    {
      if (paramBoolean != h())
      {
        g localg = n();
        if (localg != null) {
          localg.a(paramBoolean);
        }
        localg = o();
        if (localg != null) {
          localg.a(paramBoolean);
        }
        this.l = paramBoolean;
      }
      return;
    }
    finally {}
  }
  
  public static m d()
  {
    try
    {
      m localm = c;
      return localm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void e()
  {
    m localm = d();
    if (localm != null) {
      localm.c(false);
    }
  }
  
  public static boolean g()
  {
    m localm = d();
    if (localm == null) {
      com.tencent.beacon.d.a.c(" ua module not ready!", new Object[0]);
    }
    while (!m()) {
      return false;
    }
    return localm.i();
  }
  
  private static boolean m()
  {
    Object localObject = d();
    if (localObject == null)
    {
      com.tencent.beacon.d.a.d("isModuleAble:not init ua", new Object[0]);
      return false;
    }
    boolean bool2 = ((m)localObject).h();
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (((m)localObject).p()) {
        bool1 = ((m)localObject).q();
      }
    }
    if (bool1)
    {
      d locald = ((m)localObject).d;
      if (locald != null)
      {
        localObject = com.tencent.beacon.a.f.d(((m)localObject).b);
        if (((com.tencent.beacon.a.a.d)localObject).g + ((com.tencent.beacon.a.a.d)localObject).f >= locald.f())
        {
          com.tencent.beacon.d.a.c(" reach daily consume limited! %d ", new Object[] { Integer.valueOf(locald.f()) });
          return false;
        }
      }
    }
    return bool1;
  }
  
  private g n()
  {
    try
    {
      g localg = this.e;
      return localg;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private g o()
  {
    try
    {
      g localg = this.f;
      return localg;
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
      if (!this.d.m()) {
        return;
      }
      int n = this.d.l();
      com.tencent.beacon.a.c.a().a(106, new e(this.b, n), n * 1000, n * 1000);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.d.a.c(" startAutoLaunchEvent failed! ", new Object[0]);
      com.tencent.beacon.d.a.b(" startAutoLaunchEvent failed! " + localException.getMessage(), new Object[0]);
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
          c(bool);
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
    try
    {
      if (c != null)
      {
        Object localObject1 = com.tencent.beacon.a.b.c.a(this.b);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.beacon.a.b.c)localObject1).b().b(1);
          if ((localObject1 != null) && (((e.a)localObject1).a() != paramBoolean))
          {
            ((e.a)localObject1).a(paramBoolean);
            if (paramBoolean != h()) {
              c(paramBoolean);
            }
          }
        }
      }
      return;
    }
    finally {}
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
              m.a("rqd_ipSpeed", bool, l1, 0L, (Map)localObject, true);
              i += 1;
              break;
              l2 = com.tencent.beacon.b.a.a(localObject[0], Integer.parseInt(localObject[1]));
            }
          }
        }
        label218:
      }
    };
    com.tencent.beacon.a.c.a().a(paramList);
    return true;
  }
  
  public final void b()
  {
    b(true);
    for (;;)
    {
      try
      {
        localObject1 = com.tencent.beacon.a.b.c.a(this.b).b();
        if (localObject1 != null) {
          continue;
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject1;
        localThrowable1.printStackTrace();
        com.tencent.beacon.d.a.d(" common query end error %s", new Object[] { localThrowable1.toString() });
        continue;
        n = -1;
        break label897;
        n = 0;
        continue;
        com.tencent.beacon.d.a.b("event module is disable", new Object[0]);
        continue;
        localObject2 = com.tencent.beacon.a.b.c.a(this.b);
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((com.tencent.beacon.a.b.c)localObject2).b().b(1);
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((e.a)localObject2).b();
        if ((localObject2 == null) || ("".equals(((String)localObject2).trim()))) {
          continue;
        }
        new f(this.b).a(false);
        continue;
      }
      if ((l() < 2) && (h.a(this.b).b()) && (com.tencent.beacon.a.g.a(this.b).a("sig_1"))) {
        com.tencent.beacon.d.a.e(" get lock %s do singleton!", new Object[] { "sig_1" });
      }
      for (;;)
      {
        try
        {
          if (!h())
          {
            bool = this.d.n();
            if (bool) {}
          }
        }
        catch (Exception localException1)
        {
          boolean bool;
          long l1;
          long l2;
          long l3;
          Object localObject2;
          com.tencent.beacon.d.a.c(" startHeart failed! " + localException1.getMessage(), new Object[0]);
          continue;
          int n = this.d.j();
          int i1;
          com.tencent.beacon.a.b localb;
          HashMap localHashMap;
          Runnable local4 = new Runnable()
          {
            public final void run()
            {
              if (com.tencent.beacon.a.d.m() == null)
              {
                com.tencent.beacon.d.a.c(" model even common info == null?,return", new Object[0]);
                return;
              }
              Object localObject = k.a(m.this.b);
              if (localObject == null)
              {
                com.tencent.beacon.d.a.c(" UADeviceInfo == null?,return", new Object[0]);
                return;
              }
              HashMap localHashMap = new HashMap();
              localHashMap.put("A9", ((k)localObject).j());
              localHashMap.put("A10", ((k)localObject).a());
              localHashMap.put("A11", ((k)localObject).g());
              localHashMap.put("A12", ((k)localObject).h());
              localHashMap.put("A13", ((k)localObject).i());
              localHashMap.put("A14", ((k)localObject).e());
              localHashMap.put("A15", ((k)localObject).f());
              localHashMap.put("A16", ((k)localObject).c());
              localHashMap.put("A17", ((k)localObject).b());
              localHashMap.put("A18", ((k)localObject).d());
              com.tencent.beacon.a.e.a(m.this.b);
              localHashMap.put("A20", com.tencent.beacon.a.e.f(m.this.b));
              localHashMap.put("A22", k.b(m.this.b));
              com.tencent.beacon.a.e.a(m.this.b);
              localHashMap.put("A33", com.tencent.beacon.a.e.j(m.this.b));
              localHashMap.put("A52", ((k)localObject).k());
              localHashMap.put("A53", ((k)localObject).l());
              localHashMap.put("A54", ((k)localObject).m());
              localHashMap.put("A55", ((k)localObject).n());
              localHashMap.put("A56", ((k)localObject).o());
              localHashMap.put("A57", ((k)localObject).p());
              localHashMap.put("A58", ((k)localObject).q());
              StringBuilder localStringBuilder = new StringBuilder();
              com.tencent.beacon.a.e.a(m.this.b);
              Context localContext = m.this.b;
              localObject = "0";
              long l = com.tencent.beacon.a.e.h(localContext);
              if (l > 0L) {
                localObject = l / 1024L / 1024L;
              }
              localHashMap.put("A59", (String)localObject + "m");
              m.a("rqd_model", true, 0L, 0L, localHashMap, true);
            }
          };
          com.tencent.beacon.a.c.a().a(local4, 50000L);
          try
          {
            com.tencent.beacon.a.a.a(this.b, "rqd_model", com.tencent.beacon.a.e.j());
            return;
          }
          catch (Exception localException3)
          {
            com.tencent.beacon.d.a.c(" save modelEvent upload flag failed! ", new Object[0]);
            localException3.printStackTrace();
            return;
          }
          if (n <= 0) {
            continue;
          }
          n = 1;
          continue;
        }
        try
        {
          bool = this.d.k();
          if (bool) {
            continue;
          }
        }
        catch (Throwable localThrowable2)
        {
          try
          {
            i1 = this.d.i();
            if ((n <= 0) || (i1 <= 0)) {
              continue;
            }
            localb = new com.tencent.beacon.a.b(this.b, n, i1, new l(this.b));
            com.tencent.beacon.a.c.a().a(104, localb, n * 1000, n * 1000);
          }
          catch (Throwable localThrowable3)
          {
            continue;
          }
          localThrowable2 = localThrowable2;
          n = -1;
          localThrowable2.printStackTrace();
          i1 = -1;
          continue;
          localHashMap = new HashMap();
          localHashMap.put("A33", com.tencent.beacon.a.e.j(this.b));
          localHashMap.put("A63", "Y");
          if (!com.tencent.beacon.a.a.c(this.b)) {
            continue;
          }
          localHashMap.put("A21", "Y");
          if (!com.tencent.beacon.a.b.c.a(this.b).d()) {
            continue;
          }
          localHashMap.put("A45", "Y");
          if (!com.tencent.beacon.a.a.g(this.b)) {
            continue;
          }
          localHashMap.put("A66", "F");
          a("rqd_applaunched", true, 0L, 0L, localHashMap, true);
          r();
          continue;
          localHashMap.put("A21", "N");
          continue;
          localHashMap.put("A45", "N");
          continue;
          localHashMap.put("A66", "B");
        }
      }
      if (com.tencent.beacon.a.e.a(this.b) != null) {
        break label638;
      }
      com.tencent.beacon.d.a.c(" DeviceInfo == null?,return", new Object[0]);
      localObject1 = com.tencent.beacon.a.f.b(this.b);
      if (localObject1 != null)
      {
        l1 = ((com.tencent.beacon.a.a.d)localObject1).d;
        l2 = ((com.tencent.beacon.a.a.d)localObject1).e;
        l3 = ((com.tencent.beacon.a.a.d)localObject1).e;
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("A64", l1 + l2);
        ((HashMap)localObject1).put("A65", l3);
        if (a("rqd_sdk_net_consumed", true, 0L, 0L, (Map)localObject1, true)) {
          UserAction.clearSDKTotalConsume(this.b);
        }
      }
      try
      {
        localObject1 = com.tencent.beacon.a.a.b(this.b, "rqd_model", "");
        bool = com.tencent.beacon.a.e.j().equals(localObject1);
        if (!bool) {
          break label838;
        }
        return;
      }
      catch (Exception localException2)
      {
        com.tencent.beacon.d.a.c(" save modelEvent upload flag failed! ", new Object[0]);
        return;
      }
      localObject1 = ((com.tencent.beacon.a.b.e)localObject1).b(1);
      if ((localObject1 != null) && (((e.a)localObject1).d() != null) && (((e.a)localObject1).d().size() > 0) && (this.d != null)) {
        this.d.a(((e.a)localObject1).d());
      }
      if ((!h()) || (localObject1 == null)) {
        continue;
      }
      if (!h()) {
        continue;
      }
      n = com.tencent.beacon.a.e.m(this.b);
      break label897;
      if (n != 0)
      {
        com.tencent.beacon.d.a.e(" asyn up module %d", new Object[] { Integer.valueOf(1) });
        com.tencent.beacon.a.c.a().a(new Runnable()
        {
          public final void run()
          {
            m.this.i();
          }
        });
      }
    }
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
            localb = com.tencent.beacon.b.a.a(str);
            if (localb != null) {
              break label76;
            }
          }
        }
        return;
        label76:
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
          m.a("rqd_domainSpeed", bool, l, 0L, localHashMap, true);
          i += 1;
          break;
        }
      }
    };
    com.tencent.beacon.d.a.a(" post the test task", new Object[0]);
    com.tencent.beacon.a.c.a().a(paramList);
    return true;
  }
  
  public final void c()
  {
    Context localContext = this.b;
    com.tencent.beacon.d.a.a(" RecordDAO.deleteRecords() start", new Object[0]);
    com.tencent.beacon.d.a.e(" ua first clean :%d", new Object[] { Integer.valueOf(com.tencent.beacon.a.a.a.a(localContext, new int[] { 1, 2, 3, 4 }, -1L, 9223372036854775807L)) });
    com.tencent.beacon.d.a.e(" ua remove strategy :%d", new Object[] { Integer.valueOf(com.tencent.beacon.a.e.b(this.b, 101)) });
  }
  
  public final void f()
  {
    com.tencent.beacon.d.a.a(" closeUseInfoEvent start", new Object[0]);
    try
    {
      this.d.a(false);
      com.tencent.beacon.a.c.a().a(104, true);
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
      boolean bool = this.l;
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
    for (int n = com.tencent.beacon.a.e.m(this.b);; n = -1)
    {
      if (n <= 0) {
        break label73;
      }
      try
      {
        if (this.k != null)
        {
          b localb = b.a(this.b);
          this.k.a(localb);
        }
        return true;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.d.a.c(" up common error }%s", new Object[] { localThrowable.toString() });
        localThrowable.printStackTrace();
      }
    }
    label73:
    return false;
  }
  
  public final com.tencent.beacon.upload.g j()
  {
    return this.k;
  }
  
  public final d k()
  {
    return this.d;
  }
  
  public final int l()
  {
    try
    {
      int n = this.m;
      return n;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.event.m
 * JD-Core Version:    0.7.0.1
 */