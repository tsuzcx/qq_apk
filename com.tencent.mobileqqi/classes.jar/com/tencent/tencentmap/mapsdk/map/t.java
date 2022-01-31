package com.tencent.tencentmap.mapsdk.map;

import java.util.concurrent.Semaphore;

final class t
{
  protected Semaphore a = new Semaphore(0, false);
  protected boolean b = true;
  protected volatile boolean c = true;
  Thread[] d = null;
  a e = null;
  private Runnable f = new Runnable()
  {
    public final void run()
    {
      while (t.this.c) {
        t.this.d();
      }
    }
  };
  
  public t(int paramInt, a parama)
  {
    if (paramInt <= 0) {
      return;
    }
    this.d = new Thread[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      this.d[i] = new Thread(this.f);
      this.d[i].setDaemon(true);
      i += 1;
    }
    this.e = parama;
  }
  
  private void e()
  {
    this.b = false;
    this.a.release(100);
  }
  
  public final void a()
  {
    if (this.d == null) {}
    for (;;)
    {
      return;
      int j = this.d.length;
      if (j != 0)
      {
        int i = 0;
        while (i < j)
        {
          if (this.d[i] != null) {
            this.d[i].start();
          }
          i += 1;
        }
      }
    }
  }
  
  protected final void a(int paramInt)
  {
    if ((!this.b) || (this.a == null) || (this.a.availablePermits() > 100)) {
      return;
    }
    this.a.release(paramInt);
  }
  
  public final void b()
  {
    this.c = false;
    if (this.d == null) {}
    do
    {
      return;
      e();
    } while (this.d.length != 0);
  }
  
  public final void c()
  {
    this.c = false;
    if (this.d == null) {}
    int j;
    do
    {
      return;
      e();
      j = this.d.length;
    } while (j == 0);
    int i = 0;
    for (;;)
    {
      if (i < j) {
        if (this.d[i] != null) {
          this.d[i].interrupt();
        }
      }
      try
      {
        this.d[i].join();
        label61:
        this.d[i] = null;
        i += 1;
        continue;
        this.d = null;
        this.a = null;
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label61;
      }
    }
  }
  
  final void d()
  {
    
    if (this.a == null) {}
    for (;;)
    {
      return;
      try
      {
        this.a.acquire();
        label18:
        if (this.e == null) {
          continue;
        }
        this.e.a();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label18;
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.t
 * JD-Core Version:    0.7.0.1
 */