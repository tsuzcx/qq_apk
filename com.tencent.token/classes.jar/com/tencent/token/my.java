package com.tencent.token;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;

public final class my
  implements mv, ng, Runnable
{
  private Map a;
  private Set b = null;
  private BlockingQueue c = null;
  private nh d;
  
  public my()
  {
    li.a("AccessSchedulerImpl", "new AccessSchedulerImpl...");
    this.b = new CopyOnWriteArraySet();
    this.b.add("dispatcher.3g.qq.com");
    this.c = new ArrayBlockingQueue(10);
    this.a = new HashMap();
    this.d = ni.a();
    try
    {
      if (b()) {
        a(true);
      } else {
        a(false);
      }
    }
    catch (Exception localException)
    {
      label97:
      Object localObject1;
      Object localObject2;
      long l;
      break label97;
    }
    localObject1 = nd.a();
    ((nd)localObject1).a = this;
    localObject2 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    lp.a().registerReceiver(((nd)localObject1).b, (IntentFilter)localObject2);
    li.b("AccessSchedulerTrigger", "startListenNetworkChange...");
    li.b("AccessSchedulerTrigger", "try startAccessSchedulerTimer...");
    localObject2 = new IntentFilter("action.scheduler.access.trigger.timer");
    lp.a().registerReceiver(((nd)localObject1).c, (IntentFilter)localObject2);
    localObject1 = (AlarmManager)lp.a().getSystemService("alarm");
    if (localObject1 != null)
    {
      l = System.currentTimeMillis();
      localObject2 = new Intent("action.scheduler.access.trigger.timer");
      ((AlarmManager)localObject1).setRepeating(3, 1800000L + l, 1800000L, PendingIntent.getBroadcast(lp.a(), 0, (Intent)localObject2, 0));
      li.a("AccessSchedulerTrigger", "startAccessSchedulerTimer timer start...");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder("before add, queue size:");
      localStringBuilder1.append(this.c.size());
      li.a("AccessSchedulerImpl", localStringBuilder1.toString());
      if ((this.c != null) && (this.c.size() == 0)) {
        li.a("AccessSchedulerImpl", "addTask ret:".concat(String.valueOf(this.c.add(new nc(paramBoolean)))));
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      li.a("AccessSchedulerImpl", "addTask exception...", localThrowable);
    }
    StringBuilder localStringBuilder2 = new StringBuilder("after add, queue size:");
    localStringBuilder2.append(this.c.size());
    li.a("AccessSchedulerImpl", localStringBuilder2.toString());
  }
  
  private static boolean b()
  {
    boolean bool2 = false;
    try
    {
      SharedPreferences localSharedPreferences = lp.a().getSharedPreferences("Access_Preferences", 0);
      boolean bool1 = bool2;
      if (localSharedPreferences != null)
      {
        long l = localSharedPreferences.getLong("lastScheduleTime", 0L);
        bool1 = bool2;
        if (System.currentTimeMillis() - l > 86400000L)
        {
          localSharedPreferences.edit().putLong("lastScheduleTime", System.currentTimeMillis()).commit();
          li.a("AccessSchedulerImpl", "force Schedule when init");
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public final List a(String paramString, long paramLong)
  {
    Object localObject2 = new CopyOnWriteArraySet();
    ((Set)localObject2).add(paramString);
    if (((Set)localObject2).size() == 0) {
      return null;
    }
    Object localObject1 = new mz();
    ((mz)localObject1).b = lp.b();
    ((mz)localObject1).c = lp.c();
    ((mz)localObject1).d = lp.d();
    ((mz)localObject1).a = lp.f();
    lp.g();
    ((mz)localObject1).e = lp.e();
    ((mz)localObject1).a((Set)localObject2);
    ((mz)localObject1).g = oa.a();
    ((mz)localObject1).k = oa.d();
    ((mz)localObject1).l = oa.e();
    ((mz)localObject1).w = 10;
    if (paramLong > 0L) {
      ((mz)localObject1).h = paramLong;
    }
    ((mz)localObject1).i = true;
    paramString = new StringBuilder("request info:");
    paramString.append(((mz)localObject1).b);
    paramString.append(",");
    paramString.append(((mz)localObject1).c);
    paramString.append(",");
    paramString.append(((mz)localObject1).d);
    paramString.append(",");
    paramString.append(((mz)localObject1).a);
    paramString.append(",");
    paramString.append(((mz)localObject1).e);
    paramString.append(",");
    paramString.append(((mz)localObject1).j);
    paramString.append(",");
    paramString.append(null);
    paramString.append(",");
    paramString.append(((mz)localObject1).k);
    paramString.append(",");
    paramString.append(((mz)localObject1).l);
    paramString.append(",needHttps:true");
    li.a("AccessSchedulerImpl", paramString.toString());
    paramString = ((mz)localObject1).a(true);
    this.d = ni.a();
    this.d.b((mz)localObject1);
    localObject2 = new StringBuilder("scheduler...end. apn:");
    ((StringBuilder)localObject2).append(null);
    ((StringBuilder)localObject2).append(", retCode:");
    ((StringBuilder)localObject2).append(((mz)localObject1).m);
    ((StringBuilder)localObject2).append(",failInfo:");
    ((StringBuilder)localObject2).append(((mz)localObject1).n);
    li.b("AccessSchedulerImpl", ((StringBuilder)localObject2).toString());
    if (paramString != null)
    {
      localObject1 = new StringBuilder("scheduler...response:");
      ((StringBuilder)localObject1).append(paramString.a());
      li.b("AccessSchedulerImpl", ((StringBuilder)localObject1).toString());
      no.a().a(paramString.b);
      localObject1 = no.a();
      localObject2 = paramString.c;
      if (localObject2 != null)
      {
        ((no)localObject1).a = ((nq)localObject2);
        ((no)localObject1).a.b();
      }
      return paramString.d;
    }
    return null;
  }
  
  public final void a()
  {
    li.b("AccessSchedulerImpl", "onAccessSchedulerTriggered... try to addTask");
    a(false);
  }
  
  public final void run()
  {
    li.b("AccessSchedulerImpl", "AccessSchedulerImpl run start...");
    for (;;)
    {
      try
      {
        nl.a();
        li.a("AccessSchedulerImpl", "try take a task...");
        localObject1 = (nc)this.c.take();
        li.a("AccessSchedulerImpl", "task taked, try scheduler...");
        bool1 = ((nc)localObject1).a;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          boolean bool1;
          li.b("AccessSchedulerImpl", "scheduler...begin");
          Object localObject1 = oa.a();
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals("unknown")))
          {
            if (!nb.a)
            {
              localObject1 = "schedulerOn is off. return";
              li.b("AccessSchedulerImpl", (String)localObject1);
              continue;
            }
            if (!bool1)
            {
              bool1 = nl.a().a(this.b);
              boolean bool2 = b();
              if (bool1) {
                break label704;
              }
              if (!bool2) {
                break label699;
              }
              break label704;
            }
            if ((this.a.get(localObject1) != null) && (System.currentTimeMillis() - ((Long)this.a.get(localObject1)).longValue() < 600000L)) {
              continue;
            }
            this.a.put(localObject1, Long.valueOf(System.currentTimeMillis()));
            localObject1 = new mz();
            ((mz)localObject1).b = lp.b();
            ((mz)localObject1).c = lp.c();
            ((mz)localObject1).d = lp.d();
            ((mz)localObject1).a = lp.f();
            lp.g();
            ((mz)localObject1).e = lp.e();
            ((mz)localObject1).a(this.b);
            ((mz)localObject1).g = oa.a();
            ((mz)localObject1).k = oa.d();
            ((mz)localObject1).l = oa.e();
            Object localObject2 = new StringBuilder("request info:");
            ((StringBuilder)localObject2).append(((mz)localObject1).b);
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(((mz)localObject1).c);
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(((mz)localObject1).d);
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(((mz)localObject1).a);
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(((mz)localObject1).e);
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(((mz)localObject1).j);
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(null);
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(((mz)localObject1).k);
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(((mz)localObject1).l);
            li.a("AccessSchedulerImpl", ((StringBuilder)localObject2).toString());
            localObject2 = ((mz)localObject1).a(false);
            if (localObject2 != null)
            {
              Object localObject3 = new StringBuilder("scheduler...response:");
              ((StringBuilder)localObject3).append(((na)localObject2).a());
              li.b("AccessSchedulerImpl", ((StringBuilder)localObject3).toString());
              nl.a().a(((na)localObject2).a);
              no.a().a(((na)localObject2).b);
              localObject3 = no.a();
              localObject2 = ((na)localObject2).c;
              if (localObject2 != null)
              {
                ((no)localObject3).a = ((nq)localObject2);
                ((no)localObject3).a.b();
              }
            }
            localObject2 = new StringBuilder("scheduler...end. apn:");
            ((StringBuilder)localObject2).append(null);
            ((StringBuilder)localObject2).append(", Domain:");
            ((StringBuilder)localObject2).append(((mz)localObject1).j);
            ((StringBuilder)localObject2).append(", retCode:");
            ((StringBuilder)localObject2).append(((mz)localObject1).m);
            ((StringBuilder)localObject2).append(",failInfo:");
            ((StringBuilder)localObject2).append(((mz)localObject1).n);
            li.b("AccessSchedulerImpl", ((StringBuilder)localObject2).toString());
            this.d.a((mz)localObject1);
            continue;
          }
          li.c("AccessSchedulerImpl", "can not get current apn, do not scheduler");
        }
        catch (Throwable localThrowable2) {}
        localThrowable1 = localThrowable1;
        localThrowable1.printStackTrace();
        return;
      }
      continue;
      label699:
      int i = 0;
      break label706;
      label704:
      i = 1;
      label706:
      if (i == 0) {
        String str = "scheduler...no need scheduler. return";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.my
 * JD-Core Version:    0.7.0.1
 */