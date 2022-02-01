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
      if (b()) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool);
        break;
      }
    }
    catch (Exception paramString1)
    {
      label99:
      break label99;
    }
    as.a().a(this);
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
    Object localObject2 = new CopyOnWriteArraySet();
    ((Set)localObject2).add(paramString);
    if (((Set)localObject2).size() == 0) {
      return null;
    }
    Object localObject1 = new ao();
    ((ao)localObject1).b(f.b());
    ((ao)localObject1).c(f.c());
    ((ao)localObject1).a(f.d());
    ((ao)localObject1).a(f.f());
    f.g();
    ((ao)localObject1).d(f.e());
    ((ao)localObject1).a((Set)localObject2);
    ((ao)localObject1).e(bp.a());
    ((ao)localObject1).b(bp.d());
    ((ao)localObject1).c(bp.e());
    ((ao)localObject1).d(paramInt);
    if (paramLong > 0L) {
      ((ao)localObject1).a(paramLong);
    }
    ((ao)localObject1).b(paramBoolean);
    paramString = new StringBuilder("request info:");
    paramString.append(((ao)localObject1).b());
    paramString.append(",");
    paramString.append(((ao)localObject1).c());
    paramString.append(",");
    paramString.append(((ao)localObject1).d());
    paramString.append(",");
    paramString.append(((ao)localObject1).a());
    paramString.append(",");
    paramString.append(((ao)localObject1).e());
    paramString.append(",");
    paramString.append(((ao)localObject1).f());
    paramString.append(",");
    paramString.append(null);
    paramString.append(",");
    paramString.append(((ao)localObject1).g());
    paramString.append(",");
    paramString.append(((ao)localObject1).h());
    paramString.append(",needHttps:");
    paramString.append(paramBoolean);
    b.a("AccessSchedulerImpl", paramString.toString());
    paramString = ((ao)localObject1).a(true);
    this.d = ax.a();
    this.d.b((ao)localObject1, paramString);
    localObject2 = new StringBuilder("scheduler...end. apn:");
    ((StringBuilder)localObject2).append(null);
    ((StringBuilder)localObject2).append(", retCode:");
    ((StringBuilder)localObject2).append(((ao)localObject1).k());
    ((StringBuilder)localObject2).append(",failInfo:");
    ((StringBuilder)localObject2).append(((ao)localObject1).l());
    b.b("AccessSchedulerImpl", ((StringBuilder)localObject2).toString());
    if (paramString != null)
    {
      localObject1 = new StringBuilder("scheduler...response:");
      ((StringBuilder)localObject1).append(paramString.d());
      b.b("AccessSchedulerImpl", ((StringBuilder)localObject1).toString());
      bd.a().a(paramString.b());
      localObject1 = bd.a();
      localObject2 = paramString.c();
      if (localObject2 != null)
      {
        ((bd)localObject1).a = ((bf)localObject2);
        ((bd)localObject1).a.b();
      }
      return paramString.e();
    }
    return null;
  }
  
  public final void a()
  {
    b.b("AccessSchedulerImpl", "onAccessSchedulerTriggered... try to addTask");
    a(false);
  }
  
  public final void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
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
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder("before add, queue size:");
      localStringBuilder1.append(this.c.size());
      b.a("AccessSchedulerImpl", localStringBuilder1.toString());
      if ((this.c != null) && (this.c.size() == 0))
      {
        paramBoolean = this.c.add(new ar(paramBoolean));
        localStringBuilder1 = new StringBuilder("addTask ret:");
        localStringBuilder1.append(paramBoolean);
        b.a("AccessSchedulerImpl", localStringBuilder1.toString());
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      b.a("AccessSchedulerImpl", "addTask exception...", localThrowable);
    }
    StringBuilder localStringBuilder2 = new StringBuilder("after add, queue size:");
    localStringBuilder2.append(this.c.size());
    b.a("AccessSchedulerImpl", localStringBuilder2.toString());
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
        localObject1 = (ar)this.c.take();
        b.a("AccessSchedulerImpl", "task taked, try scheduler...");
        bool1 = ((ar)localObject1).a();
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          boolean bool1;
          b.b("AccessSchedulerImpl", "scheduler...begin");
          Object localObject1 = bp.a();
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals("unknown")))
          {
            if (!aq.a)
            {
              localObject1 = "schedulerOn is off. return";
              b.b("AccessSchedulerImpl", (String)localObject1);
              continue;
            }
            if (!bool1)
            {
              bool1 = ba.a().a(this.b);
              boolean bool2 = b();
              if (bool1) {
                break label693;
              }
              if (!bool2) {
                break label688;
              }
              break label693;
            }
            if ((this.a.get(localObject1) != null) && (System.currentTimeMillis() - ((Long)this.a.get(localObject1)).longValue() < 600000L)) {
              continue;
            }
            this.a.put(localObject1, Long.valueOf(System.currentTimeMillis()));
            localObject1 = new ao();
            ((ao)localObject1).b(f.b());
            ((ao)localObject1).c(f.c());
            ((ao)localObject1).a(f.d());
            ((ao)localObject1).a(f.f());
            f.g();
            ((ao)localObject1).d(f.e());
            ((ao)localObject1).a(this.b);
            ((ao)localObject1).e(bp.a());
            ((ao)localObject1).b(bp.d());
            ((ao)localObject1).c(bp.e());
            Object localObject2 = new StringBuilder("request info:");
            ((StringBuilder)localObject2).append(((ao)localObject1).b());
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(((ao)localObject1).c());
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(((ao)localObject1).d());
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(((ao)localObject1).a());
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(((ao)localObject1).e());
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(((ao)localObject1).f());
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(null);
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(((ao)localObject1).g());
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(((ao)localObject1).h());
            b.a("AccessSchedulerImpl", ((StringBuilder)localObject2).toString());
            localObject2 = ((ao)localObject1).a(false);
            if (localObject2 != null)
            {
              localObject3 = new StringBuilder("scheduler...response:");
              ((StringBuilder)localObject3).append(((ap)localObject2).d());
              b.b("AccessSchedulerImpl", ((StringBuilder)localObject3).toString());
              ba.a().a(((ap)localObject2).a());
              bd.a().a(((ap)localObject2).b());
              localObject3 = bd.a();
              bf localbf = ((ap)localObject2).c();
              if (localbf != null)
              {
                ((bd)localObject3).a = localbf;
                ((bd)localObject3).a.b();
              }
            }
            Object localObject3 = new StringBuilder("scheduler...end. apn:");
            ((StringBuilder)localObject3).append(null);
            ((StringBuilder)localObject3).append(", Domain:");
            ((StringBuilder)localObject3).append(((ao)localObject1).f());
            ((StringBuilder)localObject3).append(", retCode:");
            ((StringBuilder)localObject3).append(((ao)localObject1).k());
            ((StringBuilder)localObject3).append(",failInfo:");
            ((StringBuilder)localObject3).append(((ao)localObject1).l());
            b.b("AccessSchedulerImpl", ((StringBuilder)localObject3).toString());
            this.d.a((ao)localObject1, (ap)localObject2);
            continue;
          }
          b.c("AccessSchedulerImpl", "can not get current apn, do not scheduler");
        }
        catch (Throwable localThrowable2) {}
        localThrowable1 = localThrowable1;
        localThrowable1.printStackTrace();
        return;
      }
      continue;
      label688:
      int i = 0;
      break label695;
      label693:
      i = 1;
      label695:
      if (i == 0) {
        String str = "scheduler...no need scheduler. return";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.an
 * JD-Core Version:    0.7.0.1
 */