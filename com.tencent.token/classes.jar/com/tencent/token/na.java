package com.tencent.token;

import com.tencent.halley.downloader.c.b;
import com.tencent.halley.downloader.c.b.a;
import java.util.Iterator;
import java.util.Vector;

public final class na
  implements Runnable
{
  public na(b paramb, b.a parama) {}
  
  public final void run()
  {
    mo localmo;
    switch (com.tencent.halley.downloader.c.b.1.b[this.a.ordinal()])
    {
    default: 
      return;
    case 7: 
      ms.b().e(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator1 = this.b.d.iterator();
        while (localIterator1.hasNext())
        {
          localmo = (mo)localIterator1.next();
          if (localmo != null) {
            localmo.e(this.b.a);
          }
        }
        return;
      }
    case 6: 
      ms.b().d(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator2 = this.b.d.iterator();
        while (localIterator2.hasNext())
        {
          localmo = (mo)localIterator2.next();
          if (localmo != null) {
            localmo.d(this.b.a);
          }
        }
        return;
      }
    case 5: 
      ms.b().c(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator3 = this.b.d.iterator();
        while (localIterator3.hasNext())
        {
          localmo = (mo)localIterator3.next();
          if (localmo != null) {
            localmo.c(this.b.a);
          }
        }
        return;
      }
    case 4: 
      ms.b().b(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator4 = this.b.d.iterator();
        while (localIterator4.hasNext())
        {
          localmo = (mo)localIterator4.next();
          if (localmo != null) {
            localmo.b(this.b.a);
          }
        }
        return;
      }
    case 3: 
      ms.b().a(this.b.a);
      synchronized (this.b.d)
      {
        Iterator localIterator5 = this.b.d.iterator();
        while (localIterator5.hasNext())
        {
          localmo = (mo)localIterator5.next();
          if (localmo != null) {
            localmo.a(this.b.a);
          }
        }
        return;
      }
    case 2: 
      ms.b().a();
      synchronized (this.b.d)
      {
        Iterator localIterator6 = this.b.d.iterator();
        while (localIterator6.hasNext())
        {
          localmo = (mo)localIterator6.next();
          if (localmo != null) {
            localmo.a();
          }
        }
        return;
      }
    }
    ms.b();
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
 * Qualified Name:     com.tencent.token.na
 * JD-Core Version:    0.7.0.1
 */