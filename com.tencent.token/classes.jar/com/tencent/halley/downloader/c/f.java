package com.tencent.halley.downloader.c;

import com.tencent.halley.downloader.c;
import com.tencent.token.y;
import java.util.Iterator;
import java.util.Vector;

final class f
  implements Runnable
{
  f(b paramb, b.a parama) {}
  
  public final void run()
  {
    c localc;
    switch (e.b[this.a.ordinal()])
    {
    default: 
      return;
    case 1: 
      y.a().a(b.a(this.b));
      synchronized (b.b(this.b))
      {
        Iterator localIterator1 = b.b(this.b).iterator();
        while (localIterator1.hasNext())
        {
          localc = (c)localIterator1.next();
          if (localc != null) {
            localc.a(b.a(this.b));
          }
        }
      }
      return;
    case 2: 
      y.a().b(b.a(this.b));
      synchronized (b.b(this.b))
      {
        Iterator localIterator2 = b.b(this.b).iterator();
        while (localIterator2.hasNext())
        {
          localc = (c)localIterator2.next();
          if (localc != null) {
            localc.b(b.a(this.b));
          }
        }
      }
      return;
    case 3: 
      y.a().c(b.a(this.b));
      synchronized (b.b(this.b))
      {
        Iterator localIterator3 = b.b(this.b).iterator();
        while (localIterator3.hasNext())
        {
          localc = (c)localIterator3.next();
          if (localc != null) {
            localc.c(b.a(this.b));
          }
        }
      }
      return;
    case 4: 
      y.a().d(b.a(this.b));
      synchronized (b.b(this.b))
      {
        Iterator localIterator4 = b.b(this.b).iterator();
        while (localIterator4.hasNext())
        {
          localc = (c)localIterator4.next();
          if (localc != null) {
            localc.d(b.a(this.b));
          }
        }
      }
      return;
    case 5: 
      y.a().e(b.a(this.b));
      synchronized (b.b(this.b))
      {
        Iterator localIterator5 = b.b(this.b).iterator();
        while (localIterator5.hasNext())
        {
          localc = (c)localIterator5.next();
          if (localc != null) {
            localc.e(b.a(this.b));
          }
        }
      }
      return;
    case 6: 
      y.a().f(b.a(this.b));
      synchronized (b.b(this.b))
      {
        Iterator localIterator6 = b.b(this.b).iterator();
        while (localIterator6.hasNext())
        {
          localc = (c)localIterator6.next();
          if (localc != null) {
            localc.f(b.a(this.b));
          }
        }
      }
      return;
    }
    y.a().g(b.a(this.b));
    synchronized (b.b(this.b))
    {
      Iterator localIterator7 = b.b(this.b).iterator();
      while (localIterator7.hasNext())
      {
        localc = (c)localIterator7.next();
        if (localc != null) {
          localc.g(b.a(this.b));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.c.f
 * JD-Core Version:    0.7.0.1
 */