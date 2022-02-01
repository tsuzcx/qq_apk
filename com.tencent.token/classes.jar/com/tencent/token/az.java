package com.tencent.token;

import android.arch.lifecycle.GenericLifecycleObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class az
  extends av
{
  private aq<ax, a> a = new aq();
  private av.b b;
  private final WeakReference<ay> c;
  private int d = 0;
  private boolean e = false;
  private boolean f = false;
  private ArrayList<av.b> g = new ArrayList();
  
  public az(ay paramay)
  {
    this.c = new WeakReference(paramay);
    this.b = av.b.b;
  }
  
  static av.b a(av.b paramb1, av.b paramb2)
  {
    if ((paramb2 != null) && (paramb2.compareTo(paramb1) < 0)) {
      return paramb2;
    }
    return paramb1;
  }
  
  private void a(ay paramay)
  {
    ar.d locald = this.a.a();
    while ((locald.hasNext()) && (!this.f))
    {
      Map.Entry localEntry = (Map.Entry)locald.next();
      a locala = (a)localEntry.getValue();
      while ((locala.a.compareTo(this.b) < 0) && (!this.f) && (this.a.c(localEntry.getKey())))
      {
        b(locala.a);
        locala.a(paramay, c(locala.a));
        c();
      }
    }
  }
  
  static av.b b(av.a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unexpected event value ".concat(String.valueOf(parama)));
    case 6: 
      return av.b.a;
    case 5: 
      return av.b.e;
    case 3: 
    case 4: 
      return av.b.d;
    }
    return av.b.c;
  }
  
  private void b(av.b paramb)
  {
    this.g.add(paramb);
  }
  
  private void b(ay paramay)
  {
    Object localObject = this.a;
    ar.b localb = new ar.b(((ar)localObject).c, ((ar)localObject).b);
    ((ar)localObject).d.put(localb, Boolean.FALSE);
    if ((localb.hasNext()) && (!this.f))
    {
      Map.Entry localEntry = (Map.Entry)localb.next();
      a locala = (a)localEntry.getValue();
      while ((locala.a.compareTo(this.b) > 0) && (!this.f) && (this.a.c(localEntry.getKey())))
      {
        localObject = locala.a;
        switch (1.b[localObject.ordinal()])
        {
        default: 
          throw new IllegalArgumentException("Unexpected state value ".concat(String.valueOf(localObject)));
        case 5: 
          throw new IllegalArgumentException();
        case 4: 
          localObject = av.a.ON_PAUSE;
          break;
        case 3: 
          localObject = av.a.ON_STOP;
          break;
        case 2: 
          localObject = av.a.ON_DESTROY;
          b(b((av.a)localObject));
          locala.a(paramay, (av.a)localObject);
          c();
        }
      }
      throw new IllegalArgumentException();
    }
  }
  
  private boolean b()
  {
    if (this.a.e == 0) {
      return true;
    }
    av.b localb1 = ((a)this.a.b.getValue()).a;
    av.b localb2 = ((a)this.a.c.getValue()).a;
    return (localb1 == localb2) && (this.b == localb2);
  }
  
  private static av.a c(av.b paramb)
  {
    switch (1.b[paramb.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value ".concat(String.valueOf(paramb)));
    case 4: 
      throw new IllegalArgumentException();
    case 3: 
      return av.a.ON_RESUME;
    case 2: 
      return av.a.ON_START;
    }
    return av.a.ON_CREATE;
  }
  
  private av.b c(ax paramax)
  {
    aq localaq = this.a;
    boolean bool = localaq.c(paramax);
    Object localObject = null;
    if (bool) {
      paramax = ((ar.c)localaq.a.get(paramax)).d;
    } else {
      paramax = null;
    }
    if (paramax != null) {
      paramax = ((a)paramax.getValue()).a;
    } else {
      paramax = null;
    }
    if (!this.g.isEmpty())
    {
      localObject = this.g;
      localObject = (av.b)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    }
    return a(a(this.b, paramax), (av.b)localObject);
  }
  
  private void c()
  {
    ArrayList localArrayList = this.g;
    localArrayList.remove(localArrayList.size() - 1);
  }
  
  private void d()
  {
    ay localay = (ay)this.c.get();
    if (localay == null) {
      return;
    }
    while (!b())
    {
      this.f = false;
      if (this.b.compareTo(((a)this.a.b.getValue()).a) < 0) {
        b(localay);
      }
      ar.c localc = this.a.c;
      if ((!this.f) && (localc != null) && (this.b.compareTo(((a)localc.getValue()).a) > 0)) {
        a(localay);
      }
    }
    this.f = false;
  }
  
  public final av.b a()
  {
    return this.b;
  }
  
  public final void a(av.a parama)
  {
    a(b(parama));
  }
  
  public final void a(av.b paramb)
  {
    if (this.b == paramb) {
      return;
    }
    this.b = paramb;
    if ((!this.e) && (this.d == 0))
    {
      this.e = true;
      d();
      this.e = false;
      return;
    }
    this.f = true;
  }
  
  public final void a(ax paramax)
  {
    if (this.b == av.b.a) {
      localb = av.b.a;
    } else {
      localb = av.b.b;
    }
    a locala = new a(paramax, localb);
    if ((a)this.a.a(paramax, locala) != null) {
      return;
    }
    ay localay = (ay)this.c.get();
    if (localay == null) {
      return;
    }
    int i;
    if ((this.d == 0) && (!this.e)) {
      i = 0;
    } else {
      i = 1;
    }
    av.b localb = c(paramax);
    this.d += 1;
    while ((locala.a.compareTo(localb) < 0) && (this.a.c(paramax)))
    {
      b(locala.a);
      locala.a(localay, c(locala.a));
      c();
      localb = c(paramax);
    }
    if (i == 0) {
      d();
    }
    this.d -= 1;
  }
  
  public final void b(ax paramax)
  {
    this.a.b(paramax);
  }
  
  static final class a
  {
    av.b a;
    GenericLifecycleObserver b;
    
    a(ax paramax, av.b paramb)
    {
      this.b = bb.a(paramax);
      this.a = paramb;
    }
    
    final void a(ay paramay, av.a parama)
    {
      av.b localb = az.b(parama);
      this.a = az.a(this.a, localb);
      this.b.a(paramay, parama);
      this.a = localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.az
 * JD-Core Version:    0.7.0.1
 */