package com.tencent.tbs.one.impl.a.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class c
  implements Runnable
{
  AtomicBoolean a = new AtomicBoolean();
  d b;
  List<c> c = new ArrayList();
  private boolean d;
  private AtomicBoolean e = new AtomicBoolean();
  private List<Runnable> f = new ArrayList();
  
  final void a()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    if ((this.c == null) || (this.c.size() <= 0)) {
      b();
    }
    for (;;)
    {
      this.b.a();
      return;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        localc.b = this.b;
        c.1 local1 = new c.1(this);
        localc.f.add(local1);
        localc.a();
      }
    }
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    d locald = this.b;
    if (locald.a != null) {
      locald.a.a(paramInt, paramString, paramThrowable);
    }
  }
  
  final void b()
  {
    if (this.e.compareAndSet(false, true)) {
      this.b.b(this);
    }
  }
  
  public final void b(c paramc)
  {
    this.c.add(paramc);
  }
  
  public final void c()
  {
    if (this.a.compareAndSet(false, true))
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      this.b.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.a.c
 * JD-Core Version:    0.7.0.1
 */