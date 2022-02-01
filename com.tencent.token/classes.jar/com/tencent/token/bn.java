package com.tencent.token;

import android.arch.lifecycle.GenericLifecycleObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class bn
  extends bj
{
  private be<bl, a> a = new be();
  private bj.b b;
  private final WeakReference<bm> c;
  private int d = 0;
  private boolean e = false;
  private boolean f = false;
  private ArrayList<bj.b> g = new ArrayList();
  
  public bn(bm parambm)
  {
    this.c = new WeakReference(parambm);
    this.b = bj.b.b;
  }
  
  static bj.b a(bj.b paramb1, bj.b paramb2)
  {
    if ((paramb2 != null) && (paramb2.compareTo(paramb1) < 0)) {
      return paramb2;
    }
    return paramb1;
  }
  
  private void a(bm parambm)
  {
    bf.d locald = this.a.a();
    while ((locald.hasNext()) && (!this.f))
    {
      Map.Entry localEntry = (Map.Entry)locald.next();
      a locala = (a)localEntry.getValue();
      while ((locala.a.compareTo(this.b) < 0) && (!this.f) && (this.a.c(localEntry.getKey())))
      {
        b(locala.a);
        locala.a(parambm, c(locala.a));
        c();
      }
    }
  }
  
  static bj.b b(bj.a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unexpected event value ".concat(String.valueOf(parama)));
    case 6: 
      return bj.b.a;
    case 5: 
      return bj.b.e;
    case 3: 
    case 4: 
      return bj.b.d;
    }
    return bj.b.c;
  }
  
  private void b(bj.b paramb)
  {
    this.g.add(paramb);
  }
  
  private void b(bm parambm)
  {
    Object localObject = this.a;
    bf.b localb = new bf.b(((bf)localObject).c, ((bf)localObject).b);
    ((bf)localObject).d.put(localb, Boolean.FALSE);
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
          localObject = bj.a.ON_PAUSE;
          break;
        case 3: 
          localObject = bj.a.ON_STOP;
          break;
        case 2: 
          localObject = bj.a.ON_DESTROY;
          b(b((bj.a)localObject));
          locala.a(parambm, (bj.a)localObject);
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
    bj.b localb1 = ((a)this.a.b.getValue()).a;
    bj.b localb2 = ((a)this.a.c.getValue()).a;
    return (localb1 == localb2) && (this.b == localb2);
  }
  
  private static bj.a c(bj.b paramb)
  {
    switch (1.b[paramb.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value ".concat(String.valueOf(paramb)));
    case 4: 
      throw new IllegalArgumentException();
    case 3: 
      return bj.a.ON_RESUME;
    case 2: 
      return bj.a.ON_START;
    }
    return bj.a.ON_CREATE;
  }
  
  private bj.b c(bl parambl)
  {
    be localbe = this.a;
    boolean bool = localbe.c(parambl);
    Object localObject = null;
    if (bool) {
      parambl = ((bf.c)localbe.a.get(parambl)).d;
    } else {
      parambl = null;
    }
    if (parambl != null) {
      parambl = ((a)parambl.getValue()).a;
    } else {
      parambl = null;
    }
    if (!this.g.isEmpty())
    {
      localObject = this.g;
      localObject = (bj.b)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    }
    return a(a(this.b, parambl), (bj.b)localObject);
  }
  
  private void c()
  {
    ArrayList localArrayList = this.g;
    localArrayList.remove(localArrayList.size() - 1);
  }
  
  private void d()
  {
    bm localbm = (bm)this.c.get();
    if (localbm == null) {
      return;
    }
    while (!b())
    {
      this.f = false;
      if (this.b.compareTo(((a)this.a.b.getValue()).a) < 0) {
        b(localbm);
      }
      bf.c localc = this.a.c;
      if ((!this.f) && (localc != null) && (this.b.compareTo(((a)localc.getValue()).a) > 0)) {
        a(localbm);
      }
    }
    this.f = false;
  }
  
  public final bj.b a()
  {
    return this.b;
  }
  
  public final void a(bj.a parama)
  {
    a(b(parama));
  }
  
  public final void a(bj.b paramb)
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
  
  public final void a(bl parambl)
  {
    if (this.b == bj.b.a) {
      localb = bj.b.a;
    } else {
      localb = bj.b.b;
    }
    a locala = new a(parambl, localb);
    if ((a)this.a.a(parambl, locala) != null) {
      return;
    }
    bm localbm = (bm)this.c.get();
    if (localbm == null) {
      return;
    }
    int i;
    if ((this.d == 0) && (!this.e)) {
      i = 0;
    } else {
      i = 1;
    }
    bj.b localb = c(parambl);
    this.d += 1;
    while ((locala.a.compareTo(localb) < 0) && (this.a.c(parambl)))
    {
      b(locala.a);
      locala.a(localbm, c(locala.a));
      c();
      localb = c(parambl);
    }
    if (i == 0) {
      d();
    }
    this.d -= 1;
  }
  
  public final void b(bl parambl)
  {
    this.a.b(parambl);
  }
  
  static final class a
  {
    bj.b a;
    GenericLifecycleObserver b;
    
    a(bl parambl, bj.b paramb)
    {
      this.b = bp.a(parambl);
      this.a = paramb;
    }
    
    final void a(bm parambm, bj.a parama)
    {
      bj.b localb = bn.b(parama);
      this.a = bn.a(this.a, localb);
      this.b.a(parambm, parama);
      this.a = localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bn
 * JD-Core Version:    0.7.0.1
 */