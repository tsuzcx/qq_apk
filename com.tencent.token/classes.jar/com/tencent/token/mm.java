package com.tencent.token;

import com.tencent.halley.downloader.c.b;
import com.tencent.halley.downloader.c.b.a;
import java.util.Iterator;
import java.util.Vector;

public final class mm
  implements Runnable
{
  public mm(b paramb, b.a parama) {}
  
  public final void run()
  {
    ma localma;
    switch (com.tencent.halley.downloader.c.b.1.b[this.a.ordinal()])
    {
    default: 
      return;
    case 7: 
      me.b().e(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator1 = this.b.d.iterator();
        while (localIterator1.hasNext())
        {
          localma = (ma)localIterator1.next();
          if (localma != null) {
            localma.e(this.b.a);
          }
        }
        return;
      }
    case 6: 
      me.b().d(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator2 = this.b.d.iterator();
        while (localIterator2.hasNext())
        {
          localma = (ma)localIterator2.next();
          if (localma != null) {
            localma.d(this.b.a);
          }
        }
        return;
      }
    case 5: 
      me.b().c(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator3 = this.b.d.iterator();
        while (localIterator3.hasNext())
        {
          localma = (ma)localIterator3.next();
          if (localma != null) {
            localma.c(this.b.a);
          }
        }
        return;
      }
    case 4: 
      me.b().b(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator4 = this.b.d.iterator();
        while (localIterator4.hasNext())
        {
          localma = (ma)localIterator4.next();
          if (localma != null) {
            localma.b(this.b.a);
          }
        }
        return;
      }
    case 3: 
      me.b().a(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator5 = this.b.d.iterator();
        while (localIterator5.hasNext())
        {
          localma = (ma)localIterator5.next();
          if (localma != null) {
            localma.a(this.b.a);
          }
        }
        return;
      }
    case 2: 
      me.b().a();
      synchronized (this.b.d)
      {
        Iterator localIterator6 = this.b.d.iterator();
        while (localIterator6.hasNext())
        {
          localma = (ma)localIterator6.next();
          if (localma != null) {
            localma.a();
          }
        }
        return;
      }
    }
    me.b();
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
 * Qualified Name:     com.tencent.token.mm
 * JD-Core Version:    0.7.0.1
 */