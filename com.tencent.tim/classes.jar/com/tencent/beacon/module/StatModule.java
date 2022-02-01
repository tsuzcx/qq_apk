package com.tencent.beacon.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconEvent.Builder;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.beacon.event.open.EventType;
import java.util.HashMap;
import java.util.Map;

public class StatModule
  implements com.tencent.beacon.a.a.d, BeaconModule
{
  private Context a;
  private boolean b = true;
  private boolean c = true;
  private com.tencent.beacon.e.b d;
  private long e = 0L;
  
  private void c()
  {
    ((Application)this.a).registerActivityLifecycleCallbacks(new com.tencent.beacon.d.a.d(this));
  }
  
  private void d()
  {
    Object localObject1 = com.tencent.beacon.a.d.a.a();
    Object localObject2 = ((com.tencent.beacon.a.d.a)localObject1).getString("rqd_model", "");
    if (com.tencent.beacon.base.util.b.d().equals(localObject2)) {}
    do
    {
      return;
      localObject2 = new StatModule.1(this);
      com.tencent.beacon.a.b.a.a().a(50000L, (Runnable)localObject2);
      localObject1 = ((com.tencent.beacon.a.d.a)localObject1).edit();
    } while (!com.tencent.beacon.base.util.b.a((SharedPreferences.Editor)localObject1));
    ((SharedPreferences.Editor)localObject1).putString("rqd_model", com.tencent.beacon.base.util.b.d());
  }
  
  private void e()
  {
    if (this.d.f())
    {
      localObject = com.tencent.beacon.a.d.a.a().getString("LAUEVE_DENGTA", "");
      if (com.tencent.beacon.base.util.b.d().equals(localObject))
      {
        com.tencent.beacon.base.util.c.d("[event] APP_LAUNCHED_EVENT has been uploaded!", new Object[0]);
        return;
      }
    }
    e locale = e.l();
    f localf = f.e();
    HashMap localHashMap = new HashMap();
    localHashMap.put("A19", locale.q());
    localHashMap.put("A63", "Y");
    if (com.tencent.beacon.a.c.b.g())
    {
      localObject = "Y";
      label93:
      localHashMap.put("A21", localObject);
      if (!com.tencent.beacon.a.c.b.d(this.a)) {
        break label304;
      }
      localObject = "Y";
      label117:
      localHashMap.put("A45", localObject);
      if (!com.tencent.beacon.a.c.b.e(this.a)) {
        break label310;
      }
      localObject = "F";
      label141:
      localHashMap.put("A66", localObject);
      localHashMap.put("A68", "" + com.tencent.beacon.a.c.b.b(this.a));
      if (!com.tencent.beacon.a.c.b.d) {
        break label316;
      }
    }
    label304:
    label310:
    label316:
    for (Object localObject = "Y";; localObject = "N")
    {
      localHashMap.put("A85", localObject);
      localHashMap.put("A9", Build.BRAND);
      localHashMap.put("A14", locale.w());
      localHashMap.put("A20", localf.j());
      localHashMap.put("A69", localf.k());
      if (!b(localHashMap)) {
        break;
      }
      localObject = com.tencent.beacon.a.d.a.a().edit();
      if (!com.tencent.beacon.base.util.b.a((SharedPreferences.Editor)localObject)) {
        break;
      }
      ((SharedPreferences.Editor)localObject).putString("LAUEVE_DENGTA", com.tencent.beacon.base.util.b.d());
      return;
      localObject = "N";
      break label93;
      localObject = "N";
      break label117;
      localObject = "B";
      break label141;
    }
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    this.a = paramContext;
    if (!com.tencent.beacon.a.c.b.f(this.a))
    {
      com.tencent.beacon.base.util.c.a("non-main process. do not report rqd event", new Object[0]);
      return;
    }
    this.d = ((StrategyModule)BeaconModule.a.get(ModuleName.STRATEGY)).b();
    this.c = this.d.g();
    ((Application)this.a).registerActivityLifecycleCallbacks(new com.tencent.beacon.d.a.c(this));
    com.tencent.beacon.a.a.b.a().a(2, this);
    com.tencent.beacon.a.a.b.a().a(10, this);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    com.tencent.beacon.a.b.a.a().a(new StatModule.2(this, paramLong2, paramString, paramLong1));
  }
  
  public void a(Map<String, String> paramMap)
  {
    com.tencent.beacon.a.b.a.a().a(new StatModule.5(this, paramMap));
  }
  
  public void b() {}
  
  public void b(String paramString, long paramLong1, long paramLong2)
  {
    com.tencent.beacon.a.b.a.a().a(new StatModule.3(this, paramLong2, paramString, paramLong1));
  }
  
  public boolean b(Map<String, String> paramMap)
  {
    paramMap = BeaconEvent.builder().withCode("rqd_applaunched").withParams(paramMap).withType(EventType.REALTIME).build();
    return BeaconReport.getInstance().report(paramMap).isSuccess();
  }
  
  public boolean c(Map<String, String> paramMap)
  {
    paramMap = BeaconEvent.builder().withParams(paramMap).withCode("rqd_heartbeat").withType(EventType.REALTIME).build();
    return BeaconReport.getInstance().report(paramMap).isSuccess();
  }
  
  public void onEvent(com.tencent.beacon.a.a.c paramc)
  {
    int i = paramc.a;
    if (i != 2) {
      if (i == 10) {}
    }
    do
    {
      do
      {
        return;
        e();
        if (com.tencent.beacon.a.c.b.f(this.a)) {
          new com.tencent.beacon.d.c(this.a).a(this.d);
        }
        if (this.b) {
          d();
        }
      } while (!this.c);
      c();
      return;
      paramc = (Map)paramc.b.get("d_m");
    } while (paramc == null);
    this.b = com.tencent.beacon.base.util.b.a((String)paramc.get("modelEventUsable"), this.b);
    this.c = com.tencent.beacon.base.util.b.a((String)paramc.get("isPagePath"), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.module.StatModule
 * JD-Core Version:    0.7.0.1
 */