package com.tencent.token;

import com.tencent.halley.downloader.c.b;
import com.tencent.halley.downloader.c.b.a;
import java.util.Iterator;
import java.util.Vector;

public final class mf
  implements Runnable
{
  public mf(b paramb, b.a parama) {}
  
  public final void run()
  {
    lt locallt;
    switch (com.tencent.halley.downloader.c.b.1.b[this.a.ordinal()])
    {
    default: 
      return;
    case 7: 
      lx.b().e(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator1 = this.b.d.iterator();
        while (localIterator1.hasNext())
        {
          locallt = (lt)localIterator1.next();
          if (locallt != null) {
            locallt.e(this.b.a);
          }
        }
        return;
      }
    case 6: 
      lx.b().d(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator2 = this.b.d.iterator();
        while (localIterator2.hasNext())
        {
          locallt = (lt)localIterator2.next();
          if (locallt != null) {
            locallt.d(this.b.a);
          }
        }
        return;
      }
    case 5: 
      lx.b().c(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator3 = this.b.d.iterator();
        while (localIterator3.hasNext())
        {
          locallt = (lt)localIterator3.next();
          if (locallt != null) {
            locallt.c(this.b.a);
          }
        }
        return;
      }
    case 4: 
      lx.b().b(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator4 = this.b.d.iterator();
        while (localIterator4.hasNext())
        {
          locallt = (lt)localIterator4.next();
          if (locallt != null) {
            locallt.b(this.b.a);
          }
        }
        return;
      }
    case 3: 
      lx.b().a(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator5 = this.b.d.iterator();
        while (localIterator5.hasNext())
        {
          locallt = (lt)localIterator5.next();
          if (locallt != null) {
            locallt.a(this.b.a);
          }
        }
        return;
      }
    case 2: 
      lx.b().a();
      synchronized (this.b.d)
      {
        Iterator localIterator6 = this.b.d.iterator();
        while (localIterator6.hasNext())
        {
          locallt = (lt)localIterator6.next();
          if (locallt != null) {
            locallt.a();
          }
        }
        return;
      }
    }
    lx.b();
    synchronized (this.b.d)
    {
      Iterator localIterator7 = this.b.d.iterator();
      while (localIterator7.hasNext()) {
        localIterator7.next();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.mf
 * JD-Core Version:    0.7.0.1
 */