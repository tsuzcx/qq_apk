package com.tencent.beacon.module;

import android.content.Context;
import com.tencent.beacon.base.net.b.e;
import com.tencent.beacon.base.util.c;
import com.tencent.beacon.e.b;
import com.tencent.beacon.e.g;
import com.tencent.beacon.e.h;

public class StrategyModule
  implements BeaconModule
{
  private static final Object a = new Object();
  private com.tencent.beacon.e.a b = com.tencent.beacon.e.a.a();
  private h c;
  private b d = b.a();
  private boolean e = false;
  
  public StrategyModule()
  {
    g.b().a(this.b);
    this.c = new h(this);
  }
  
  private void d()
  {
    try
    {
      if (!this.c.a()) {
        com.tencent.beacon.a.b.a.a().a(this.c);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public com.tencent.beacon.e.a a()
  {
    return this.b;
  }
  
  public void a(Context paramContext)
  {
    c.a("[module] strategy module > TRUE", new Object[0]);
    this.c.b();
    d();
    e.a(paramContext, new StrategyModule.1(this));
  }
  
  public void a(boolean paramBoolean)
  {
    synchronized (a)
    {
      this.e = paramBoolean;
      return;
    }
  }
  
  public b b()
  {
    return this.d;
  }
  
  public boolean c()
  {
    synchronized (a)
    {
      boolean bool = this.e;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.module.StrategyModule
 * JD-Core Version:    0.7.0.1
 */