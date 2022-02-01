package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.halley.common.b;
import com.tencent.halley.common.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;

public final class an
  implements ak, av, Runnable
{
  private Map a;
  private Set b = null;
  private BlockingQueue c = null;
  private aw d;
  
  public an(String paramString1, String paramString2, String paramString3)
  {
    b.a("AccessSchedulerImpl", "new AccessSchedulerImpl...");
    this.b = new CopyOnWriteArraySet();
    this.b.add("dispatcher.3g.qq.com");
    this.c = new ArrayBlockingQueue(10);
    this.a = new HashMap();
    this.d = ax.a();
    try
    {
      if (b()) {
        a(true);
      }
      for (;;)
      {
        label86:
        as.a().a(this);
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
      SharedPreferences localSharedPreferences = f.a().getSharedPreferences("Access_Preferences", 0);
      boolean bool1 = bool2;
      if (localSharedPreferences != null)
      {
        long l = localSharedPreferences.getLong("lastScheduleTime", 0L);
        bool1 = bool2;
        if (System.currentTimeMillis() - l > 86400000L)
        {
          localSharedPreferences.edit().putLong("lastScheduleTime", System.currentTimeMillis()).commit();
          b.a("AccessSchedulerImpl", "force Schedule when init");
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
      localObject2 = new ao();
      ((ao)localObject2).b(f.b());
      ((ao)localObject2).c(f.c());
      ((ao)localObject2).a(f.d());
      ((ao)localObject2).a(f.f());
      f.g();
      ((ao)localObject2).d(f.e());
      ((ao)localObject2).a((Set)localObject1);
      ((ao)localObject2).e(bp.a());
      ((ao)localObject2).b(bp.d());
      ((ao)localObject2).c(bp.e());
      ((ao)localObject2).d(paramInt);
      if (paramLong > 0L) {
        ((ao)localObject2).a(paramLong);
      }
      ((ao)localObject2).b(paramBoolean);
      b.a("AccessSchedulerImpl", "request info:" + ((ao)localObject2).b() + "," + ((ao)localObject2).c() + "," + ((ao)localObject2).d() + "," + ((ao)localObject2).a() + "," + ((ao)localObject2).e() + "," + ((ao)localObject2).f() + "," + null + "," + ((ao)localObject2).g() + "," + ((ao)localObject2).h() + ",needHttps:" + paramBoolean);
      paramString = ((ao)localObject2).a(true);
      this.d = ax.a();
      this.d.b((ao)localObject2, paramString);
      b.b("AccessSchedulerImpl", "scheduler...end. apn:" + null + ", retCode:" + ((ao)localObject2).k() + ",failInfo:" + ((ao)localObject2).l());
    } while (paramString == null);
    b.b("AccessSchedulerImpl", "scheduler...response:" + paramString.d());
    bd.a().a(paramString.b());
    localObject1 = bd.a();
    Object localObject2 = paramString.c();
    if (localObject2 != null)
    {
      ((bd)localObject1).a = ((bf)localObject2);
      ((bd)localObject1).a.b();
    }
    return paramString.e();
  }
  
  public final void a()
  {
    b.b("AccessSchedulerImpl", "onAccessSchedulerTriggered... try to addTask");
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
      b.a("AccessSchedulerImpl", "before add, queue size:" + this.c.size());
      if ((this.c != null) && (this.c.size() == 0))
      {
        paramBoolean = this.c.add(new ar(paramBoolean));
        b.a("AccessSchedulerImpl", "addTask ret:" + paramBoolean);
      }
      b.a("AccessSchedulerImpl", "after add, queue size:" + this.c.size());
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        b.a("AccessSchedulerImpl", "addTask exception...", localThrowable);
      }
    }
  }
  
  public final void run()
  {
    b.b("AccessSchedulerImpl", "AccessSchedulerImpl run start...");
    for (;;)
    {
      try
      {
        ba.a();
        b.a("AccessSchedulerImpl", "try take a task...");
        localObject = (ar)this.c.take();
        b.a("AccessSchedulerImpl", "task taked, try scheduler...");
        bool1 = ((ar)localObject).a();
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          boolean bool1;
          b.b("AccessSchedulerImpl", "scheduler...begin");
          Object localObject = bp.a();
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equals("unknown")))
          {
            b.c("AccessSchedulerImpl", "can not get current apn, do not scheduler");
            continue;
          }
          if (!aq.a)
          {
            b.b("AccessSchedulerImpl", "schedulerOn is off. return");
            continue;
          }
          if (!bool1)
          {
            bool1 = ba.a().a(this.b);
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
              b.b("AccessSchedulerImpl", "scheduler...no need scheduler. return");
              continue;
            }
          }
          if ((this.a.get(localObject) != null) && (System.currentTimeMillis() - ((Long)this.a.get(localObject)).longValue() < 600000L)) {
            continue;
          }
          this.a.put(localObject, Long.valueOf(System.currentTimeMillis()));
          localObject = new ao();
          ((ao)localObject).b(f.b());
          ((ao)localObject).c(f.c());
          ((ao)localObject).a(f.d());
          ((ao)localObject).a(f.f());
          f.g();
          ((ao)localObject).d(f.e());
          ((ao)localObject).a(this.b);
          ((ao)localObject).e(bp.a());
          ((ao)localObject).b(bp.d());
          ((ao)localObject).c(bp.e());
          b.a("AccessSchedulerImpl", "request info:" + ((ao)localObject).b() + "," + ((ao)localObject).c() + "," + ((ao)localObject).d() + "," + ((ao)localObject).a() + "," + ((ao)localObject).e() + "," + ((ao)localObject).f() + "," + null + "," + ((ao)localObject).g() + "," + ((ao)localObject).h());
          ap localap = ((ao)localObject).a(false);
          if (localap != null)
          {
            b.b("AccessSchedulerImpl", "scheduler...response:" + localap.d());
            ba.a().a(localap.a());
            bd.a().a(localap.b());
            bd localbd = bd.a();
            bf localbf = localap.c();
            if (localbf != null)
            {
              localbd.a = localbf;
              localbd.a.b();
            }
          }
          b.b("AccessSchedulerImpl", "scheduler...end. apn:" + null + ", Domain:" + ((ao)localObject).f() + ", retCode:" + ((ao)localObject).k() + ",failInfo:" + ((ao)localObject).l());
          this.d.a((ao)localObject, localap);
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
 * Qualified Name:     com.tencent.token.an
 * JD-Core Version:    0.7.0.1
 */