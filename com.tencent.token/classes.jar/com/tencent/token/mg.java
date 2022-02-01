package com.tencent.token;

import com.tencent.halley.downloader.c.b;
import com.tencent.halley.downloader.c.b.a;
import java.util.Iterator;
import java.util.Vector;

public final class mg
  implements Runnable
{
  public mg(b paramb, b.a parama) {}
  
  public final void run()
  {
    lu locallu;
    switch (com.tencent.halley.downloader.c.b.1.b[this.a.ordinal()])
    {
    default: 
      return;
    case 7: 
      ly.b().e(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator1 = this.b.d.iterator();
        while (localIterator1.hasNext())
        {
          locallu = (lu)localIterator1.next();
          if (locallu != null) {
            locallu.e(this.b.a);
          }
        }
        return;
      }
    case 6: 
      ly.b().d(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator2 = this.b.d.iterator();
        while (localIterator2.hasNext())
        {
          locallu = (lu)localIterator2.next();
          if (locallu != null) {
            locallu.d(this.b.a);
          }
        }
        return;
      }
    case 5: 
      ly.b().c(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator3 = this.b.d.iterator();
        while (localIterator3.hasNext())
        {
          locallu = (lu)localIterator3.next();
          if (locallu != null) {
            locallu.c(this.b.a);
          }
        }
        return;
      }
    case 4: 
      ly.b().b(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator4 = this.b.d.iterator();
        while (localIterator4.hasNext())
        {
          locallu = (lu)localIterator4.next();
          if (locallu != null) {
            locallu.b(this.b.a);
          }
        }
        return;
      }
    case 3: 
      ly.b().a(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator5 = this.b.d.iterator();
        while (localIterator5.hasNext())
        {
          locallu = (lu)localIterator5.next();
          if (locallu != null) {
            locallu.a(this.b.a);
          }
        }
        return;
      }
    case 2: 
      ly.b().a();
      synchronized (this.b.d)
      {
        Iterator localIterator6 = this.b.d.iterator();
        while (localIterator6.hasNext())
        {
          locallu = (lu)localIterator6.next();
          if (locallu != null) {
            locallu.a();
          }
        }
        return;
      }
    }
    ly.b();
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
 * Qualified Name:     com.tencent.token.mg
 * JD-Core Version:    0.7.0.1
 */