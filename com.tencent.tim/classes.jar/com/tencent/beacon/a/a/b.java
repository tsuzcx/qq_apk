package com.tencent.beacon.a.a;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
{
  private static volatile b a;
  private final SparseArray<List<d>> b = new SparseArray();
  private final Object c = new Object();
  private final SparseArray<List<c>> d = new SparseArray();
  private final SparseArray<Object> e = new SparseArray();
  private AtomicBoolean f = new AtomicBoolean(false);
  
  public static b a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new b();
      }
      return a;
    }
    finally {}
  }
  
  private Object b(int paramInt)
  {
    synchronized (this.c)
    {
      Object localObject3 = this.e.get(paramInt);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new Object();
        this.e.put(paramInt, localObject1);
      }
      return localObject1;
    }
  }
  
  private List<d> c(int paramInt)
  {
    List localList2 = (List)this.b.get(paramInt);
    List localList1;
    if (localList2 != null)
    {
      localList1 = localList2;
      if (!localList2.isEmpty()) {}
    }
    else
    {
      localList1 = null;
    }
    return localList1;
  }
  
  private void c(c paramc)
  {
    d(paramc);
    synchronized (b(paramc.a))
    {
      Object localObject2 = c(paramc.a);
      if (localObject2 == null) {
        return;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        d locald = (d)((Iterator)localObject2).next();
        try
        {
          locald.onEvent(paramc);
        }
        catch (Throwable localThrowable)
        {
          com.tencent.beacon.base.util.c.a(localThrowable);
        }
        if (this.f.compareAndSet(false, true))
        {
          com.tencent.beacon.a.b.d locald1 = com.tencent.beacon.a.b.d.b();
          locald1.a("512", "dispatchEvent error", localThrowable);
        }
      }
    }
  }
  
  private void d(c paramc) {}
  
  public void a(int paramInt)
  {
    synchronized (b(paramInt))
    {
      this.d.remove(paramInt);
      return;
    }
  }
  
  public void a(int paramInt, d paramd)
  {
    synchronized (b(paramInt))
    {
      Object localObject2 = (List)this.b.get(paramInt);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        this.b.put(paramInt, localObject1);
      }
      if (((List)localObject1).contains(paramd)) {
        return;
      }
      ((List)localObject1).add(paramd);
      localObject1 = (List)this.d.get(paramInt);
      if (localObject1 == null) {
        break label157;
      }
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (c)((Iterator)localObject1).next();
          try
          {
            paramd.onEvent((c)localObject2);
          }
          catch (Throwable localThrowable)
          {
            com.tencent.beacon.base.util.c.a(localThrowable);
          }
        }
      }
    }
    if ((paramInt == 6) || (paramInt == 12)) {
      a(paramInt);
    }
    label157:
  }
  
  public void a(@NonNull c paramc)
  {
    com.tencent.beacon.a.b.a.a().a(new a(this, paramc));
  }
  
  public void b(@NonNull c paramc)
  {
    synchronized (b(paramc.a))
    {
      c localc = new c(paramc.a, paramc.b);
      List localList = (List)this.d.get(localc.a);
      Object localObject1 = localList;
      if (localList == null)
      {
        localObject1 = new ArrayList();
        this.d.put(localc.a, localObject1);
      }
      ((List)localObject1).add(localc);
      c(paramc);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.a.a.b
 * JD-Core Version:    0.7.0.1
 */