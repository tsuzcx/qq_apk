package com.tencent.tbs.one.impl.e;

import com.tencent.tbs.one.impl.c.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class i$1
  implements Runnable
{
  i$1(i parami) {}
  
  public final void run()
  {
    String str = this.a.b;
    int i;
    if (this.a.r != null)
    {
      if (this.a.r.a != null) {}
      for (i = 1; i != 0; i = 0)
      {
        com.tencent.tbs.one.impl.a.f.a("[%s] %s in updating", new Object[] { str, "Early out for idle task," });
        this.a.k();
        return;
      }
    }
    Iterator localIterator = this.a.f.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.e) && (localb.k == null)) {}
      for (i = 1; i != 0; i = 0)
      {
        com.tencent.tbs.one.impl.a.f.a("[%s] %s in loading component", new Object[] { str, "Early out for idle task," });
        this.a.k();
        return;
      }
    }
    f.a(this.a.a);
    f.d(this.a.c);
    if (!this.a.i)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] %s disabled", new Object[] { str, "Early out for auto update," });
      return;
    }
    if (!this.a.b())
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] %s not use online service", new Object[] { str, "Early out for auto update," });
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.i.1
 * JD-Core Version:    0.7.0.1
 */