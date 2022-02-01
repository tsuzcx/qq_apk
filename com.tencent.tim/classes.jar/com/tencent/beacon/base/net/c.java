package com.tencent.beacon.base.net;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.base.net.adapter.AbstractNetAdapter;
import com.tencent.beacon.base.net.adapter.f;
import com.tencent.beacon.base.net.b.e.a;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.base.net.call.j;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
  implements e.a, e, Closeable
{
  private static volatile c a;
  private final AtomicBoolean b = new AtomicBoolean(false);
  private final AtomicInteger c = new AtomicInteger();
  public com.tencent.beacon.base.net.a.a d;
  public com.tencent.beacon.base.net.a.b e;
  private Context f;
  private AbstractNetAdapter g;
  private AbstractNetAdapter h;
  
  public static c c()
  {
    try
    {
      if (a == null) {
        a = new c();
      }
      c localc = a;
      return localc;
    }
    finally {}
  }
  
  private void f()
  {
    com.tencent.beacon.base.util.c.a("[BeaconNet]", "current net connected num: %d", new Object[] { Integer.valueOf(this.c.decrementAndGet()) });
  }
  
  private void g()
  {
    com.tencent.beacon.base.util.c.a("[BeaconNet]", "current net connected num: %d", new Object[] { Integer.valueOf(this.c.incrementAndGet()) });
  }
  
  @NonNull
  public AbstractNetAdapter a(JceRequestEntity paramJceRequestEntity)
  {
    if (paramJceRequestEntity.getType() == RequestType.EVENT)
    {
      if (com.tencent.beacon.e.b.a().i()) {
        return this.g;
      }
      return this.h;
    }
    return this.g;
  }
  
  public com.tencent.beacon.base.net.call.c a(com.tencent.beacon.base.net.call.e parame)
  {
    return new com.tencent.beacon.base.net.call.c(parame);
  }
  
  public void a()
  {
    this.b.set(false);
    com.tencent.beacon.base.util.c.a("[BeaconNet]", "network recovery. open BeaconNet.", new Object[0]);
  }
  
  public void a(Context paramContext, AbstractNetAdapter paramAbstractNetAdapter)
  {
    this.f = paramContext;
    Object localObject = paramAbstractNetAdapter;
    if (paramAbstractNetAdapter == null) {
      localObject = new com.tencent.beacon.base.net.adapter.b();
    }
    this.g = f.a();
    this.h = ((AbstractNetAdapter)localObject);
    this.d = com.tencent.beacon.base.net.a.a.a();
    this.e = com.tencent.beacon.base.net.a.b.a();
    com.tencent.beacon.base.net.b.e.a(paramContext, this);
  }
  
  public void a(JceRequestEntity paramJceRequestEntity, Callback<byte[]> paramCallback)
  {
    boolean bool = false;
    if (this.b.get())
    {
      paramCallback.onFailure(new d(paramJceRequestEntity.getType().name(), null, 0, "BeaconNet close."));
      return;
    }
    AbstractNetAdapter localAbstractNetAdapter = a(paramJceRequestEntity);
    g();
    if (localAbstractNetAdapter == this.g) {
      bool = true;
    }
    localAbstractNetAdapter.request(paramJceRequestEntity, new a(this, paramJceRequestEntity, bool, paramCallback));
  }
  
  public void a(com.tencent.beacon.base.net.call.e parame, Callback<BResponse> paramCallback)
  {
    if (this.b.get())
    {
      paramCallback.onFailure(new d(parame.h(), null, 0, "BeaconNet close."));
      return;
    }
    g();
    this.h.request(parame, new b(this, parame, paramCallback));
  }
  
  public void a(@NonNull d paramd)
  {
    if ((paramd.a.equals("atta")) || (TextUtils.isEmpty(paramd.b))) {
      return;
    }
    com.tencent.beacon.a.b.d.b().a(paramd.b, paramd.toString(), paramd.e);
  }
  
  public j b(JceRequestEntity paramJceRequestEntity)
  {
    return new j(paramJceRequestEntity);
  }
  
  public void b()
  {
    this.b.set(true);
    com.tencent.beacon.base.util.c.a("[BeaconNet]", "network can't use. close BeaconNet.", new Object[0]);
  }
  
  public void close()
  {
    this.b.set(true);
    com.tencent.beacon.base.util.c.a("[BeaconNet]", "network can't use. close BeaconNet.", new Object[0]);
  }
  
  public boolean d()
  {
    return this.c.get() >= 5;
  }
  
  public void e()
  {
    this.b.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.c
 * JD-Core Version:    0.7.0.1
 */