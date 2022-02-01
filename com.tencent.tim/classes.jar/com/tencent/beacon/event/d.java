package com.tencent.beacon.event;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.base.net.call.j;
import com.tencent.beacon.event.immediate.Beacon2MsfTransferArgs;
import com.tencent.beacon.event.immediate.Beacon2WnsTransferArgs;
import com.tencent.beacon.event.immediate.BeaconTransferArgs;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.beacon.event.open.EventResult.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class d
  implements com.tencent.beacon.a.a.d, h
{
  private final Handler a = com.tencent.beacon.a.b.a.a().a(3000);
  private final com.tencent.beacon.event.a.a b = new com.tencent.beacon.event.a.a();
  private final g c = new g(2000, this.b, true);
  private final g d = new g(1000, this.b, false);
  private long e = 2000L;
  private long f = 3000L;
  
  public d()
  {
    com.tencent.beacon.a.a.b.a().a(11, this);
    com.tencent.beacon.a.a.b.a().a(2, this);
  }
  
  private BeaconTransferArgs a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt == 3) {
      return new Beacon2MsfTransferArgs(paramArrayOfByte);
    }
    return new Beacon2WnsTransferArgs(paramArrayOfByte);
  }
  
  public EventResult a(String paramString, @NonNull EventBean paramEventBean)
  {
    com.tencent.beacon.base.util.c.a("[EventManager]", "eventName is %s, logID is %s", new Object[] { paramEventBean.getEventCode(), paramString });
    com.tencent.beacon.a.b.a.a().a(new b(this, paramEventBean, paramString));
    paramEventBean = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramEventBean = "-1";
    }
    return EventResult.a.a(Long.parseLong(paramEventBean));
  }
  
  public void a()
  {
    com.tencent.beacon.a.b.a.a().a(2000, 0L, this.e, this.c);
    com.tencent.beacon.a.b.a.a().a(1000, 0L, this.f, this.d);
  }
  
  public void a(EventBean paramEventBean, String paramString)
  {
    Object localObject = paramEventBean.getEventValue();
    ((Map)localObject).put("A156", "N");
    paramEventBean.setEventValue((Map)localObject);
    localObject = new ArrayList();
    ((List)localObject).add(paramEventBean);
    localObject = com.tencent.beacon.event.c.d.a((List)localObject, true);
    com.tencent.beacon.base.net.c.c().b((JceRequestEntity)localObject).a(new c(this, paramEventBean, paramString), com.tencent.beacon.a.b.a.b());
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.d.run();
      this.c.run();
      return;
    }
    com.tencent.beacon.a.b.a.a().a(this.d);
    com.tencent.beacon.a.b.a.a().a(this.c);
  }
  
  public boolean a(Runnable paramRunnable)
  {
    return this.a.post(paramRunnable);
  }
  
  public EventResult b(@Nullable String paramString, @NonNull EventBean paramEventBean)
  {
    boolean bool = a(new a(this, paramEventBean));
    com.tencent.beacon.base.util.c.a("[EventModule]", 1, "event: %s. go in EventManager(%s). offer: %s", new Object[] { paramEventBean.getEventCode(), paramEventBean.getAppKey(), Boolean.valueOf(bool) });
    if (bool)
    {
      paramEventBean = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramEventBean = "-1";
      }
      return EventResult.a.a(Long.parseLong(paramEventBean));
    }
    return EventResult.a.a(103);
  }
  
  public void b()
  {
    com.tencent.beacon.a.b.a.a().b(2000);
    com.tencent.beacon.a.b.a.a().b(1000);
  }
  
  public void c()
  {
    com.tencent.beacon.a.b.a.a().a(2000, false);
    com.tencent.beacon.a.b.a.a().a(1000, false);
  }
  
  public void onEvent(com.tencent.beacon.a.a.c paramc)
  {
    long l1 = 1000L;
    int i = paramc.a;
    if (i != 2) {
      if (i == 11) {}
    }
    for (;;)
    {
      com.tencent.beacon.base.util.c.a("[EventManager]", "pollingTime maybe change, realtime: %s normal: %s", new Object[] { Long.valueOf(this.e), Long.valueOf(this.f) });
      return;
      Object localObject = paramc.b.get("u_c_r_p");
      if (localObject != null)
      {
        long l2 = ((Long)localObject).longValue();
        if (l2 > 1000L) {
          l1 = l2;
        }
        this.e = l1;
      }
      paramc = paramc.b.get("u_c_n_p");
      if (paramc != null)
      {
        l1 = ((Long)paramc).longValue();
        if (l1 > 2000L) {}
        for (;;)
        {
          this.f = l1;
          break;
          l1 = 2000L;
        }
        paramc = (Map)paramc.b.get("d_m");
        if (paramc != null)
        {
          this.e = com.tencent.beacon.base.util.b.a((String)paramc.get("realtimePollingTime"), this.e, 1000L, 10000L);
          this.f = com.tencent.beacon.base.util.b.a((String)paramc.get("normalPollingTime"), this.f, 2000L, 3600000L);
        }
        com.tencent.beacon.base.util.c.a("normal polling time has changed to " + this.f, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.d
 * JD-Core Version:    0.7.0.1
 */