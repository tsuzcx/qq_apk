package com.tencent.token;

import android.app.Activity;
import android.content.Context;
import com.tencent.turingfd.sdk.qps.Grapefruit;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class aeo
{
  public static add<aeq> a = new add(3);
  public static add<aeq> b = new add(3);
  public static List<aeq> c = new CopyOnWriteArrayList();
  public static long d = 0L;
  public static long e = 1000L;
  public static Context f;
  public static final ado g = new a();
  public static final adr h = new b();
  
  public static void a()
  {
    if (c.size() == 0) {
      return;
    }
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext())
    {
      aeq localaeq = (aeq)localIterator.next();
      int i = localaeq.b;
      if ((i != 2) && (i != 3))
      {
        if (a.b.size() != 0) {
          break label125;
        }
        synchronized (a)
        {
          a.a(localaeq);
        }
      }
      synchronized (b)
      {
        b.b.size();
        b.a(localaeq);
        b.b.size();
        label125:
        c.remove(localaeq);
      }
    }
  }
  
  public final class a
    implements ado
  {
    public final void a(String paramString, int paramInt1, int paramInt2, Grapefruit paramGrapefruit)
    {
      long l;
      if (paramGrapefruit != null) {
        l = Math.abs(paramGrapefruit.b - aeo.d);
      } else {
        l = aeo.e;
      }
      aeo.d = System.currentTimeMillis();
      if (l < aeo.e) {
        return;
      }
      if ((paramInt2 != 2) && (paramInt2 != 3)) {
        synchronized (aeo.a)
        {
          aeo.a.a(new aeq(paramString, paramInt2, paramGrapefruit));
          return;
        }
      }
      synchronized (aeo.b)
      {
        aeo.b.a(new aeq(paramString, paramInt2, paramGrapefruit));
        return;
      }
    }
  }
  
  public final class b
    implements adr
  {
    public final void a(Activity paramActivity)
    {
      adn localadn = adn.a();
      Context localContext = aeo.f;
      localadn.a(paramActivity.getClass().getName(), 997, aeo.g);
    }
    
    public final void b(Activity paramActivity)
    {
      adn localadn = adn.a();
      paramActivity.getApplicationContext();
      localadn.a(paramActivity.getClass().getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aeo
 * JD-Core Version:    0.7.0.1
 */