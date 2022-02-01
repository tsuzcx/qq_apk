package com.tencent.beacon.e;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.base.net.call.JceRequestEntity.a;
import com.tencent.beacon.module.StrategyModule;
import com.tencent.beacon.pack.CommonStrategy;
import com.tencent.beacon.pack.ModuleStrategy;
import com.tencent.beacon.qimei.Qimei;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class h
  implements Callback<byte[]>, Runnable
{
  private final Context a;
  private final StrategyModule b;
  private volatile boolean c = false;
  private boolean d;
  
  public h(StrategyModule paramStrategyModule)
  {
    this.b = paramStrategyModule;
    this.a = com.tencent.beacon.a.c.c.d().c();
  }
  
  private void a(d paramd, b paramb, ModuleStrategy paramModuleStrategy)
  {
    if (paramModuleStrategy.detail != null)
    {
      com.tencent.beacon.base.util.c.a("[strategy] mid: %d , detail changed...", new Object[] { Byte.valueOf(paramModuleStrategy.mId) });
      paramd.a(paramModuleStrategy.detail);
      paramb.a(paramModuleStrategy.detail);
      this.d = true;
    }
  }
  
  private void a(d paramd, ModuleStrategy paramModuleStrategy)
  {
    if (paramModuleStrategy.onOff == 1) {}
    for (boolean bool = true;; bool = false)
    {
      if (paramd.c() != bool)
      {
        com.tencent.beacon.base.util.c.a("[strategy] mid: %d , isUsable changed: %b ", new Object[] { Byte.valueOf(paramModuleStrategy.mId), Boolean.valueOf(bool) });
        paramd.a(bool);
        this.d = true;
      }
      return;
    }
  }
  
  private void a(ModuleStrategy paramModuleStrategy)
  {
    String str = com.tencent.beacon.base.net.b.b.a(paramModuleStrategy.url);
    if (!com.tencent.beacon.base.net.b.b.a(true).equals(str))
    {
      com.tencent.beacon.base.util.c.a("[strategy] mid: %d , url changed: %s", new Object[] { Byte.valueOf(paramModuleStrategy.mId), paramModuleStrategy.url });
      com.tencent.beacon.base.net.b.b.b(str);
      this.d = true;
    }
  }
  
  private boolean a(Map<String, String> paramMap, a parama)
  {
    if (parama == null) {}
    while (paramMap == null) {
      return false;
    }
    parama.a(paramMap);
    return true;
  }
  
  private void b(d paramd, b paramb, ModuleStrategy paramModuleStrategy)
  {
    ArrayList localArrayList = paramModuleStrategy.preventEventCode;
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      com.tencent.beacon.base.util.c.a("[strategy] mid: %d , PreventEventCode changed...", new Object[] { Byte.valueOf(paramModuleStrategy.mId) });
      this.d = true;
      paramd.a(com.tencent.beacon.base.util.b.a(paramModuleStrategy.preventEventCode));
      paramb.a(com.tencent.beacon.base.util.b.a(paramModuleStrategy.preventEventCode));
    }
  }
  
  private void c()
  {
    f();
    this.c = false;
  }
  
  private void c(d paramd, b paramb, ModuleStrategy paramModuleStrategy)
  {
    ArrayList localArrayList = paramModuleStrategy.sampleEvent;
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      com.tencent.beacon.base.util.c.a("[strategy] mid: %d , SampleEventSet changed...", new Object[] { Byte.valueOf(paramModuleStrategy.mId) });
      this.d = true;
      paramd.b(com.tencent.beacon.base.util.b.a(paramModuleStrategy.sampleEvent));
      paramb.b(com.tencent.beacon.base.util.b.a(paramModuleStrategy.sampleEvent));
    }
  }
  
  private void d()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("s_e_e", Boolean.valueOf(false));
    localObject = new com.tencent.beacon.a.a.c(7, (Map)localObject);
    com.tencent.beacon.a.a.b.a().a((com.tencent.beacon.a.a.c)localObject);
  }
  
  private void e()
  {
    com.tencent.beacon.base.util.c.a("local strategyQuery finish!", new Object[0]);
    com.tencent.beacon.a.a.b.a().a(new com.tencent.beacon.a.a.c(10));
  }
  
  private void f()
  {
    long l = this.b.a().b() * 60000L;
    com.tencent.beacon.a.b.a.a().a(l, this);
    com.tencent.beacon.base.util.c.a("[strategy] next time: %d", new Object[] { Long.valueOf(l) });
  }
  
  private void g()
  {
    if ((j.b()) || (j.c()))
    {
      com.tencent.beacon.base.util.c.e("[strategy] query times or query success times arrive max, return!", new Object[0]);
      this.b.a(true);
      return;
    }
    Object localObject1 = e.l();
    Object localObject2 = f.e();
    localObject2 = JceRequestEntity.builder().a(RequestType.STRATEGY).a(100).b(101).a(com.tencent.beacon.a.c.c.d().f()).b(com.tencent.beacon.base.net.b.b.b(false)).a(com.tencent.beacon.base.net.b.b.b(true), 8081).b("A1", com.tencent.beacon.a.c.c.d().k()).b("A2", ((f)localObject2).b()).b("A4", ((f)localObject2).d()).b("A6", ((f)localObject2).f()).b("A7", ((f)localObject2).a()).b("A23", com.tencent.beacon.a.c.c.d().a()).b("A31", ((e)localObject1).p()).b("A19", ((e)localObject1).q());
    if (com.tencent.beacon.a.c.b.e(this.a))
    {
      localObject1 = "F";
      localObject2 = ((JceRequestEntity.a)localObject2).b("A66", (String)localObject1).b("A67", com.tencent.beacon.a.c.b.c(this.a)).b("A68", String.valueOf(com.tencent.beacon.a.c.b.b(this.a)));
      if (!com.tencent.beacon.a.c.b.d) {
        break label273;
      }
    }
    label273:
    for (localObject1 = "Y";; localObject1 = "N")
    {
      localObject1 = ((JceRequestEntity.a)localObject2).b("A85", (String)localObject1).a(com.tencent.beacon.qimei.a.a().b().getQimeiMap()).a();
      com.tencent.beacon.base.net.c.c().b((JceRequestEntity)localObject1).b(this);
      return;
      localObject1 = "B";
      break;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, true);
    this.b.a(true);
    c();
  }
  
  public void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    try
    {
      Object localObject = new CommonStrategy();
      ((CommonStrategy)localObject).readFrom(new com.tencent.beacon.pack.a(paramArrayOfByte));
      com.tencent.beacon.base.util.c.a("[strategy] -> common strategy: %s", new Object[] { localObject });
      if ((a((CommonStrategy)localObject, a.a())) && (paramBoolean))
      {
        localObject = com.tencent.beacon.a.d.a.a().edit();
        boolean bool = com.tencent.beacon.base.util.b.a((SharedPreferences.Editor)localObject);
        if (bool) {
          ((SharedPreferences.Editor)localObject).putString("strategy_data", Base64.encodeToString(paramArrayOfByte, 0));
        }
      }
      if (paramBoolean) {
        j.d();
      }
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      com.tencent.beacon.base.util.c.a(paramArrayOfByte);
      com.tencent.beacon.base.util.c.b("[strategy] error to common strategy!", new Object[0]);
    }
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  protected boolean a(CommonStrategy paramCommonStrategy, a parama)
  {
    if ((paramCommonStrategy == null) || (parama == null)) {
      return false;
    }
    String str = com.tencent.beacon.base.net.b.b.a(paramCommonStrategy.url);
    if (!str.equals(com.tencent.beacon.base.net.b.b.b(true)))
    {
      com.tencent.beacon.base.util.c.a("[strategy] url changed to: %s", new Object[] { paramCommonStrategy.url });
      this.d = true;
      com.tencent.beacon.base.net.b.b.d(str);
    }
    if (paramCommonStrategy.queryInterval != parama.b())
    {
      com.tencent.beacon.base.util.c.a("[strategy] QueryPeriod changed to: %d", new Object[] { Integer.valueOf(paramCommonStrategy.queryInterval) });
      this.d = true;
      parama.a(paramCommonStrategy.queryInterval);
    }
    if (a(paramCommonStrategy.moduleList)) {
      this.d = true;
    }
    if (a(paramCommonStrategy.cloudParas, parama)) {
      this.d = true;
    }
    return this.d;
  }
  
  boolean a(ArrayList<ModuleStrategy> paramArrayList)
  {
    d locald = this.b.a().d();
    if (paramArrayList == null)
    {
      locald.a(false);
      d();
      return false;
    }
    b localb = this.b.b();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ModuleStrategy localModuleStrategy = (ModuleStrategy)paramArrayList.next();
      if (localModuleStrategy.mId == locald.b())
      {
        a(locald, localModuleStrategy);
        a(localModuleStrategy);
        a(locald, localb, localModuleStrategy);
        b(locald, localb, localModuleStrategy);
        c(locald, localb, localModuleStrategy);
      }
    }
    return this.d;
  }
  
  public void b()
  {
    byte[] arrayOfByte = null;
    for (;;)
    {
      try
      {
        localObject2 = com.tencent.beacon.a.d.a.a();
        localObject2 = ((com.tencent.beacon.a.d.a)localObject2).getString("strategy_data", "");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        arrayOfByte = Base64.decode((String)localObject2, 0);
        if (arrayOfByte == null) {
          continue;
        }
        a(arrayOfByte, false);
      }
      catch (Exception localException)
      {
        Object localObject2;
        com.tencent.beacon.base.util.c.a(localException);
        continue;
      }
      finally
      {
        e();
      }
      e();
      return;
      localObject2 = j.a(this.a, 101);
      if (localObject2 != null)
      {
        arrayOfByte = ((i)localObject2).c;
        continue;
        com.tencent.beacon.base.util.c.a("[strategy] local strategy is null!", new Object[0]);
      }
    }
  }
  
  public void onFailure(com.tencent.beacon.base.net.d paramd)
  {
    c();
  }
  
  public void run()
  {
    this.c = true;
    if (!this.b.a().e()) {
      g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.e.h
 * JD-Core Version:    0.7.0.1
 */