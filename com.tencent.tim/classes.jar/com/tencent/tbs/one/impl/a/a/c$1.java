package com.tencent.tbs.one.impl.a.a;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

final class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  public final void run()
  {
    c localc = this.a;
    Iterator localIterator = localc.c.iterator();
    while (localIterator.hasNext()) {
      if (!((c)localIterator.next()).a.get()) {
        return;
      }
    }
    localc.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.a.c.1
 * JD-Core Version:    0.7.0.1
 */