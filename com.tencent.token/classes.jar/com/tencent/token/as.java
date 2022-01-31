package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.halley.common.c;
import com.tencent.halley.common.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;

public final class as
  implements ap, bc, Runnable
{
  private Map a;
  private Set b = null;
  private BlockingQueue c = null;
  private bd d;
  
  public as(String paramString1, String paramString2, String paramString3)
  {
    c.a("AccessSchedulerImpl", "new AccessSchedulerImpl...");
    this.b = new CopyOnWriteArraySet();
    this.b.add("dispatcher.3g.qq.com");
    this.c = new ArrayBlockingQueue(10);
    this.a = new HashMap();
    this.d = be.a();
    try
    {
      if (b()) {
        a(true);
      }
      for (;;)
      {
        label86:
        ax.a().a(this);
        return;
        a(false);
      }
    }
    catch (Exception paramString1)
    {
      break label86;
    }
  }
  
  private static boolean b()
  {
    boolean bool2 = false;
    try
    {
      SharedPreferences localSharedPreferences = h.a().getSharedPreferences("Access_Preferences", 0);
      boolean bool1 = bool2;
      if (localSharedPreferences != null)
      {
        long l = localSharedPreferences.getLong("lastScheduleTime", 0L);
        bool1 = bool2;
        if (System.currentTimeMillis() - l > 86400000L)
        {
          localSharedPreferences.edit().putLong("lastScheduleTime", System.currentTimeMillis()).commit();
          c.a("AccessSchedulerImpl", "force Schedule when init");
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public final List a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject1 = new CopyOnWriteArraySet();
    ((Set)localObject1).add(paramString);
    if (((Set)localObject1).size() == 0) {}
    do
    {
      return null;
      localObject2 = new at();
      ((at)localObject2).b(h.b());
      ((at)localObject2).c(h.c());
      ((at)localObject2).a(h.d());
      ((at)localObject2).a(h.f());
      h.g();
      ((at)localObject2).d(h.e());
      ((at)localObject2).a((Set)localObject1);
      ((at)localObject2).e(cb.a());
      ((at)localObject2).b(cb.d());
      ((at)localObject2).c(cb.e());
      ((at)localObject2).d(paramInt);
      if (paramLong > 0L) {
        ((at)localObject2).a(paramLong);
      }
      ((at)localObject2).b(paramBoolean);
      c.a("AccessSchedulerImpl", "request info:" + ((at)localObject2).b() + "," + ((at)localObject2).c() + "," + ((at)localObject2).d() + "," + ((at)localObject2).a() + "," + ((at)localObject2).e() + "," + ((at)localObject2).f() + "," + null + "," + ((at)localObject2).g() + "," + ((at)localObject2).h() + ",needHttps:" + paramBoolean);
      paramString = ((at)localObject2).a(true);
      this.d = be.a();
      this.d.b((at)localObject2, paramString);
      c.b("AccessSchedulerImpl", "scheduler...end. apn:" + null + ", retCode:" + ((at)localObject2).k() + ",failInfo:" + ((at)localObject2).l());
    } while (paramString == null);
    c.b("AccessSchedulerImpl", "scheduler...response:" + paramString.d());
    bm.a().a(paramString.b());
    localObject1 = bm.a();
    Object localObject2 = paramString.c();
    if (localObject2 != null)
    {
      ((bm)localObject1).a = ((bo)localObject2);
      ((bm)localObject1).a.b();
    }
    return paramString.e();
  }
  
  public final void a()
  {
    c.b("AccessSchedulerImpl", "onAccessSchedulerTriggered... try to addTask");
    a(false);
  }
  
  public final void a(List paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          String str = (String)paramList.next();
          this.b.add(str);
        }
        return;
      }
      catch (Exception paramList) {}
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      c.a("AccessSchedulerImpl", "before add, queue size:" + this.c.size());
      if ((this.c != null) && (this.c.size() == 0))
      {
        paramBoolean = this.c.add(new aw(paramBoolean));
        c.a("AccessSchedulerImpl", "addTask ret:" + paramBoolean);
      }
      c.a("AccessSchedulerImpl", "after add, queue size:" + this.c.size());
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        c.a("AccessSchedulerImpl", "addTask exception...", localThrowable);
      }
    }
  }
  
  public final void run()
  {
    c.b("AccessSchedulerImpl", "AccessSchedulerImpl run start...");
    for (;;)
    {
      try
      {
        bj.a();
        c.a("AccessSchedulerImpl", "try take a task...");
        localObject = (aw)this.c.take();
        c.a("AccessSchedulerImpl", "task taked, try scheduler...");
        bool1 = ((aw)localObject).a();
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          boolean bool1;
          c.b("AccessSchedulerImpl", "scheduler...begin");
          Object localObject = cb.a();
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equals("unknown")))
          {
            c.c("AccessSchedulerImpl", "can not get current apn, do not scheduler");
            continue;
          }
          if (!av.a)
          {
            c.b("AccessSchedulerImpl", "schedulerOn is off. return");
            continue;
          }
          if (!bool1)
          {
            bool1 = bj.a().a(this.b);
            boolean bool2 = b();
            if (bool1) {
              break label606;
            }
            if (!bool2) {
              break label611;
            }
            break label606;
            if (i == 0)
            {
              c.b("AccessSchedulerImpl", "scheduler...no need scheduler. return");
              continue;
            }
          }
          if ((this.a.get(localObject) != null) && (System.currentTimeMillis() - ((Long)this.a.get(localObject)).longValue() < 600000L)) {
            continue;
          }
          this.a.put(localObject, Long.valueOf(System.currentTimeMillis()));
          localObject = new at();
          ((at)localObject).b(h.b());
          ((at)localObject).c(h.c());
          ((at)localObject).a(h.d());
          ((at)localObject).a(h.f());
          h.g();
          ((at)localObject).d(h.e());
          ((at)localObject).a(this.b);
          ((at)localObject).e(cb.a());
          ((at)localObject).b(cb.d());
          ((at)localObject).c(cb.e());
          c.a("AccessSchedulerImpl", "request info:" + ((at)localObject).b() + "," + ((at)localObject).c() + "," + ((at)localObject).d() + "," + ((at)localObject).a() + "," + ((at)localObject).e() + "," + ((at)localObject).f() + "," + null + "," + ((at)localObject).g() + "," + ((at)localObject).h());
          au localau = ((at)localObject).a(false);
          if (localau != null)
          {
            c.b("AccessSchedulerImpl", "scheduler...response:" + localau.d());
            bj.a().a(localau.a());
            bm.a().a(localau.b());
            bm localbm = bm.a();
            bo localbo = localau.c();
            if (localbo != null)
            {
              localbm.a = localbo;
              localbm.a.b();
            }
          }
          c.b("AccessSchedulerImpl", "scheduler...end. apn:" + null + ", Domain:" + ((at)localObject).f() + ", retCode:" + ((at)localObject).k() + ",failInfo:" + ((at)localObject).l());
          this.d.a((at)localObject, localau);
        }
        catch (Throwable localThrowable2) {}
        localThrowable1 = localThrowable1;
        localThrowable1.printStackTrace();
        return;
      }
      continue;
      label606:
      int i = 1;
      continue;
      label611:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.as
 * JD-Core Version:    0.7.0.1
 */