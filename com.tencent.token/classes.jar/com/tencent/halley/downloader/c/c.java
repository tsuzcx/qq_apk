package com.tencent.halley.downloader.c;

import android.os.SystemClock;
import com.tencent.token.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class c
{
  private long a = 0L;
  private long b = 0L;
  private int c = 0;
  private List d = new LinkedList();
  
  private int b()
  {
    if (this.d.size() == 0) {
      return 0;
    }
    Iterator localIterator = this.d.iterator();
    long l1;
    for (long l2 = 0L; localIterator.hasNext(); l2 = l1)
    {
      d locald = (d)localIterator.next();
      l1 = l2;
      if (locald.b <= 2000)
      {
        l2 += locald.a;
        l1 = l2;
        if (l2 < 0L)
        {
          com.tencent.halley.common.c.c("CostTimeCounter", "sum:" + l2 + ",len:" + locald.a);
          l1 = l2;
        }
      }
    }
    return (int)(1000L * l2 / 2000L);
  }
  
  public final int a()
  {
    return this.c;
  }
  
  public final void a(int paramInt)
  {
    int k = 1;
    if (paramInt <= 0) {}
    for (int i = 1;; i = 0)
    {
      long l = SystemClock.elapsedRealtime();
      int j = (int)(l - this.a);
      this.a = l;
      if (this.d.size() == 0)
      {
        j = k;
        if (i == 0)
        {
          this.d.add(new d(paramInt));
          j = k;
        }
        if (j != 0)
        {
          this.c = b();
          this.b = l;
        }
        return;
      }
      Iterator localIterator = this.d.iterator();
      label99:
      if (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        locald.b += j;
        if ((i != 0) || (locald.b <= 2000)) {
          break label262;
        }
        locald.b = 0;
        locald.a = paramInt;
        i = 1;
      }
      label262:
      for (;;)
      {
        break label99;
        if (i == 0)
        {
          if (this.d.size() <= 2000 / h.f + 1) {
            break label241;
          }
          com.tencent.halley.common.c.d("CostTimeCounter", "records.size():" + this.d.size());
        }
        for (;;)
        {
          j = k;
          if (l - this.b > 200L) {
            break;
          }
          j = 0;
          break;
          label241:
          this.d.add(new d(paramInt));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.c.c
 * JD-Core Version:    0.7.0.1
 */