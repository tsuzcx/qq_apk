package com.tencent.tmassistantsdk.downloadservice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public final class h
{
  private static h g = null;
  final PriorityQueue a = new PriorityQueue(16, this.e);
  final ArrayList b = new ArrayList();
  final Object c = new Object();
  final Object d = new Object();
  private Comparator e = new i(this);
  private ArrayList f = new ArrayList();
  
  private h()
  {
    int j = f.a().c();
    int i = 0;
    while (i < j)
    {
      j localj = new j(this, i);
      this.f.add(localj);
      i += 1;
    }
  }
  
  public static h a()
  {
    if (g == null) {
      g = new h();
    }
    return g;
  }
  
  final int a(g paramg)
  {
    synchronized (this.d)
    {
      this.a.add(paramg);
      synchronized (this.c)
      {
        this.c.notifyAll();
        int i = paramg.a();
        return i;
      }
    }
  }
  
  public final g a(String paramString)
  {
    synchronized (this.d)
    {
      Iterator localIterator = this.b.iterator();
      g localg;
      while (localIterator.hasNext())
      {
        localg = (g)localIterator.next();
        if (localg.c().equals(paramString)) {
          return localg;
        }
      }
      localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        localg = (g)localIterator.next();
        if (localg.c().equals(paramString)) {
          return localg;
        }
      }
    }
    return null;
  }
  
  final void a(int paramInt)
  {
    synchronized (this.d)
    {
      Iterator localIterator = this.b.iterator();
      g localg;
      while (localIterator.hasNext())
      {
        localg = (g)localIterator.next();
        if (localg.a() == paramInt)
        {
          localg.b();
          this.b.remove(localg);
          return;
        }
      }
      localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        localg = (g)localIterator.next();
        if (localg.a() == paramInt)
        {
          localg.b();
          this.a.remove(localg);
          return;
        }
      }
    }
  }
  
  final boolean b()
  {
    synchronized (this.d)
    {
      if (this.a.size() > 0)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.h
 * JD-Core Version:    0.7.0.1
 */