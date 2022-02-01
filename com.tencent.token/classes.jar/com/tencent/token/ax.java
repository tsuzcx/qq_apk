package com.tencent.token;

import android.arch.lifecycle.GenericLifecycleObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class ax
  extends au
{
  private aq<av, a> a = new aq();
  private au.b b;
  private final WeakReference<aw> c;
  private int d = 0;
  private boolean e = false;
  private boolean f = false;
  private ArrayList<au.b> g = new ArrayList();
  
  public ax(aw paramaw)
  {
    this.c = new WeakReference(paramaw);
    this.b = au.b.b;
  }
  
  static au.b a(au.b paramb1, au.b paramb2)
  {
    if ((paramb2 != null) && (paramb2.compareTo(paramb1) < 0)) {
      return paramb2;
    }
    return paramb1;
  }
  
  private void a(aw paramaw)
  {
    ar.d locald = this.a.a();
    while ((locald.hasNext()) && (!this.f))
    {
      Map.Entry localEntry = (Map.Entry)locald.next();
      a locala = (a)localEntry.getValue();
      while ((locala.a.compareTo(this.b) < 0) && (!this.f) && (this.a.c(localEntry.getKey())))
      {
        b(locala.a);
        locala.a(paramaw, c(locala.a));
        c();
      }
    }
  }
  
  static au.b b(au.a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unexpected event value ".concat(String.valueOf(parama)));
    case 6: 
      return au.b.a;
    case 5: 
      return au.b.e;
    case 3: 
    case 4: 
      return au.b.d;
    }
    return au.b.c;
  }
  
  private void b(au.b paramb)
  {
    this.g.add(paramb);
  }
  
  private void b(aw paramaw)
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
          localObject = au.a.ON_PAUSE;
          break;
        case 3: 
          localObject = au.a.ON_STOP;
          break;
        case 2: 
          localObject = au.a.ON_DESTROY;
          b(b((au.a)localObject));
          locala.a(paramaw, (au.a)localObject);
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
    au.b localb1 = ((a)this.a.b.getValue()).a;
    au.b localb2 = ((a)this.a.c.getValue()).a;
    return (localb1 == localb2) && (this.b == localb2);
  }
  
  private static au.a c(au.b paramb)
  {
    switch (1.b[paramb.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value ".concat(String.valueOf(paramb)));
    case 4: 
      throw new IllegalArgumentException();
    case 3: 
      return au.a.ON_RESUME;
    case 2: 
      return au.a.ON_START;
    }
    return au.a.ON_CREATE;
  }
  
  private au.b c(av paramav)
  {
    aq localaq = this.a;
    boolean bool = localaq.c(paramav);
    Object localObject = null;
    if (bool) {
      paramav = ((ar.c)localaq.a.get(paramav)).d;
    } else {
      paramav = null;
    }
    if (paramav != null) {
      paramav = ((a)paramav.getValue()).a;
    } else {
      paramav = null;
    }
    if (!this.g.isEmpty())
    {
      localObject = this.g;
      localObject = (au.b)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    }
    return a(a(this.b, paramav), (au.b)localObject);
  }
  
  private void c()
  {
    ArrayList localArrayList = this.g;
    localArrayList.remove(localArrayList.size() - 1);
  }
  
  private void d()
  {
    aw localaw = (aw)this.c.get();
    if (localaw == null) {
      return;
    }
    while (!b())
    {
      this.f = false;
      if (this.b.compareTo(((a)this.a.b.getValue()).a) < 0) {
        b(localaw);
      }
      ar.c localc = this.a.c;
      if ((!this.f) && (localc != null) && (this.b.compareTo(((a)localc.getValue()).a) > 0)) {
        a(localaw);
      }
    }
    this.f = false;
  }
  
  public final au.b a()
  {
    return this.b;
  }
  
  public final void a(au.a parama)
  {
    a(b(parama));
  }
  
  public final void a(au.b paramb)
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
  
  public final void a(av paramav)
  {
    if (this.b == au.b.a) {
      localb = au.b.a;
    } else {
      localb = au.b.b;
    }
    a locala = new a(paramav, localb);
    if ((a)this.a.a(paramav, locala) != null) {
      return;
    }
    aw localaw = (aw)this.c.get();
    if (localaw == null) {
      return;
    }
    int i;
    if ((this.d == 0) && (!this.e)) {
      i = 0;
    } else {
      i = 1;
    }
    au.b localb = c(paramav);
    this.d += 1;
    while ((locala.a.compareTo(localb) < 0) && (this.a.c(paramav)))
    {
      b(locala.a);
      locala.a(localaw, c(locala.a));
      c();
      localb = c(paramav);
    }
    if (i == 0) {
      d();
    }
    this.d -= 1;
  }
  
  public final void b(av paramav)
  {
    this.a.b(paramav);
  }
  
  static final class a
  {
    au.b a;
    GenericLifecycleObserver b;
    
    a(av paramav, au.b paramb)
    {
      this.b = az.a(paramav);
      this.a = paramb;
    }
    
    final void a(aw paramaw, au.a parama)
    {
      au.b localb = ax.b(parama);
      this.a = ax.a(this.a, localb);
      this.b.a(paramaw, parama);
      this.a = localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ax
 * JD-Core Version:    0.7.0.1
 */