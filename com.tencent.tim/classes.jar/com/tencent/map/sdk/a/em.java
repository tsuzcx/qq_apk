package com.tencent.map.sdk.a;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class em<K extends Comparable<K>, V>
  extends AbstractMap<K, V>
  implements Serializable
{
  int a = 0;
  c<K, V> b;
  c<K, V> c;
  c<K, V> d;
  
  private static <K extends Comparable<K>, V> void a(c<K, V> paramc, boolean paramBoolean)
  {
    if (paramc != null) {
      c.a(paramc, paramBoolean);
    }
  }
  
  private V b(K paramK, V paramV)
  {
    c localc;
    for (Object localObject = this.b;; localObject = localc)
    {
      int i = paramK.compareTo(c.a((c)localObject));
      if (i < 0)
      {
        localc = c.b((c)localObject);
        if (localc != null) {
          continue;
        }
        this.a += 1;
        paramK = new c((c)localObject, this.d, paramK, paramV);
        if (i >= 0) {
          break label121;
        }
        c.a((c)localObject, paramK);
      }
      for (;;)
      {
        c.c(this.d, paramK);
        this.d = paramK;
        b(paramK);
        return null;
        if (i > 0)
        {
          localc = c.c((c)localObject);
          break;
        }
        paramK = ((c)localObject).getValue();
        ((c)localObject).setValue(paramV);
        return paramK;
        label121:
        if (i > 0) {
          c.b((c)localObject, paramK);
        }
      }
    }
  }
  
  private void b(c<K, V> paramc)
  {
    c.a(paramc, true);
    while ((paramc != null) && (paramc != this.b) && (c.e(c.d(paramc)) == true))
    {
      Object localObject;
      if (c.d(paramc) == e(c(c(paramc))))
      {
        localObject = f(c(c(paramc)));
        if (d((c)localObject) == true)
        {
          a(c(paramc), false);
          a((c)localObject, false);
          a(c(c(paramc)), true);
          paramc = c(c(paramc));
        }
        else
        {
          localObject = paramc;
          if (paramc == f(c(paramc)))
          {
            localObject = c(paramc);
            g((c)localObject);
          }
          a(c((c)localObject), false);
          a(c(c((c)localObject)), true);
          h(c(c((c)localObject)));
          paramc = (c<K, V>)localObject;
        }
      }
      else
      {
        localObject = e(c(c(paramc)));
        if (d((c)localObject) == true)
        {
          a(c(paramc), false);
          a((c)localObject, false);
          a(c(c(paramc)), true);
          paramc = c(c(paramc));
        }
        else
        {
          localObject = paramc;
          if (paramc == e(c(paramc)))
          {
            localObject = c(paramc);
            h((c)localObject);
          }
          a(c((c)localObject), false);
          a(c(c((c)localObject)), true);
          g(c(c((c)localObject)));
          paramc = (c<K, V>)localObject;
        }
      }
    }
    c.a(this.b, false);
  }
  
  private static <K extends Comparable<K>, V> c<K, V> c(c<K, V> paramc)
  {
    if (paramc != null) {
      return c.d(paramc);
    }
    return null;
  }
  
  private static <K extends Comparable<K>, V> boolean d(c<K, V> paramc)
  {
    if (paramc != null) {
      return c.e(paramc);
    }
    return false;
  }
  
  private static <K extends Comparable<K>, V> c<K, V> e(c<K, V> paramc)
  {
    if (paramc != null) {
      return c.b(paramc);
    }
    return null;
  }
  
  private static <K extends Comparable<K>, V> c<K, V> f(c<K, V> paramc)
  {
    if (paramc != null) {
      return c.c(paramc);
    }
    return null;
  }
  
  private void g(c<K, V> paramc)
  {
    c localc;
    if (paramc != null)
    {
      localc = c.c(paramc);
      c.b(paramc, c.b(localc));
      if (c.b(localc) != null) {
        c.d(c.b(localc), paramc);
      }
      c.d(localc, c.d(paramc));
      if (c.d(paramc) != null) {
        break label68;
      }
      this.b = localc;
    }
    for (;;)
    {
      c.a(localc, paramc);
      c.d(paramc, localc);
      return;
      label68:
      if (c.b(c.d(paramc)) == paramc) {
        c.a(c.d(paramc), localc);
      } else {
        c.b(c.d(paramc), localc);
      }
    }
  }
  
  private void h(c<K, V> paramc)
  {
    c localc;
    if (paramc != null)
    {
      localc = c.b(paramc);
      c.a(paramc, c.c(localc));
      if (c.c(localc) != null) {
        c.d(c.c(localc), paramc);
      }
      c.d(localc, c.d(paramc));
      if (c.d(paramc) != null) {
        break label68;
      }
      this.b = localc;
    }
    for (;;)
    {
      c.b(localc, paramc);
      c.d(paramc, localc);
      return;
      label68:
      if (c.c(c.d(paramc)) == paramc) {
        c.b(c.d(paramc), localc);
      } else {
        c.a(c.d(paramc), localc);
      }
    }
  }
  
  public final c<K, V> a(K paramK)
  {
    if (paramK != null)
    {
      c localc1 = this.b;
      while (localc1 != null)
      {
        int i = paramK.compareTo(c.a(localc1));
        if (i < 0)
        {
          localc1 = c.b(localc1);
        }
        else
        {
          localc2 = localc1;
          if (i <= 0) {
            break label54;
          }
          localc1 = c.c(localc1);
        }
      }
    }
    c localc2 = null;
    label54:
    return localc2;
  }
  
  public final V a(K paramK, V paramV)
  {
    eg.a(paramK);
    if (this.b == null)
    {
      this.b = new c(null, null, paramK, paramV);
      this.c = this.b;
      this.d = this.b;
      this.a += 1;
      return null;
    }
    return b(paramK, paramV);
  }
  
  final void a(c<K, V> paramc)
  {
    while ((paramc != this.b) && (!d(paramc)))
    {
      Object localObject2;
      Object localObject1;
      if (paramc == e(c(paramc)))
      {
        localObject2 = f(c(paramc));
        localObject1 = localObject2;
        if (d((c)localObject2) == true)
        {
          a((c)localObject2, false);
          a(c(paramc), true);
          g(c(paramc));
          localObject1 = f(c(paramc));
        }
        if ((!d(e((c)localObject1))) && (!d(f((c)localObject1))))
        {
          a((c)localObject1, true);
          paramc = c(paramc);
        }
        else
        {
          localObject2 = localObject1;
          if (!d(f((c)localObject1)))
          {
            a(e((c)localObject1), false);
            a((c)localObject1, true);
            h((c)localObject1);
            localObject2 = f(c(paramc));
          }
          a((c)localObject2, d(c(paramc)));
          a(c(paramc), false);
          a(f((c)localObject2), false);
          g(c(paramc));
          paramc = this.b;
        }
      }
      else
      {
        localObject2 = e(c(paramc));
        localObject1 = localObject2;
        if (d((c)localObject2) == true)
        {
          a((c)localObject2, false);
          a(c(paramc), true);
          h(c(paramc));
          localObject1 = e(c(paramc));
        }
        if ((!d(f((c)localObject1))) && (!d(e((c)localObject1))))
        {
          a((c)localObject1, true);
          paramc = c(paramc);
        }
        else
        {
          localObject2 = localObject1;
          if (!d(e((c)localObject1)))
          {
            a(f((c)localObject1), false);
            a((c)localObject1, true);
            g((c)localObject1);
            localObject2 = e(c(paramc));
          }
          a((c)localObject2, d(c(paramc)));
          a(c(paramc), false);
          a(e((c)localObject2), false);
          h(c(paramc));
          paramc = this.b;
        }
      }
    }
    a(paramc, false);
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    return new a();
  }
  
  public final int size()
  {
    return this.a;
  }
  
  final class a
    extends AbstractSet<Map.Entry<K, V>>
  {
    a() {}
    
    public final Iterator<Map.Entry<K, V>> iterator()
    {
      return new em.b(em.this, em.a(em.this), (byte)0);
    }
    
    public final int size()
    {
      return em.this.size();
    }
  }
  
  final class b
    implements Iterator<Map.Entry<K, V>>
  {
    private em.c<K, V> b;
    
    private b()
    {
      Object localObject;
      this.b = localObject;
    }
    
    public final boolean hasNext()
    {
      return this.b != null;
    }
    
    public final void remove()
    {
      em localem = em.this;
      em.c localc = localem.a(this.b.a);
      Object localObject1;
      Object localObject2;
      if (localc != null)
      {
        localem.a -= 1;
        localc.getValue();
        if (localc == localem.c) {
          localem.c = em.c.g(localc);
        }
        if (localc == localem.d) {
          localem.d = em.c.h(localc);
        }
        localObject1 = em.c.h(localc);
        localObject2 = em.c.g(localc);
        if (localObject1 != null) {
          em.c.c((em.c)localObject1, (em.c)localObject2);
        }
        if (localObject2 != null) {
          em.c.e((em.c)localObject2, (em.c)localObject1);
        }
        if ((em.c.b(localc) == null) || (em.c.c(localc) == null)) {
          break label408;
        }
        if (localc != null) {
          break label214;
        }
        localObject1 = null;
        em.c.a(localc, em.c.a((em.c)localObject1));
        em.c.a(localc, em.c.f((em.c)localObject1));
      }
      for (;;)
      {
        if (em.c.b((em.c)localObject1) != null)
        {
          localObject2 = em.c.b((em.c)localObject1);
          label156:
          if (localObject2 == null) {
            break label324;
          }
          em.c.d((em.c)localObject2, em.c.d((em.c)localObject1));
          if (em.c.d((em.c)localObject1) != null) {
            break label289;
          }
          localem.b = ((em.c)localObject2);
          label182:
          em.c.a((em.c)localObject1, null);
          em.c.b((em.c)localObject1, null);
          em.c.d((em.c)localObject1, null);
          if (!em.c.e((em.c)localObject1)) {
            localem.a((em.c)localObject2);
          }
        }
        label214:
        do
        {
          return;
          if (em.c.c(localc) != null) {
            for (localObject2 = em.c.c(localc);; localObject2 = em.c.b((em.c)localObject2))
            {
              localObject1 = localObject2;
              if (em.c.b((em.c)localObject2) == null) {
                break;
              }
            }
          }
          localObject2 = em.c.d(localc);
          Object localObject3 = localc;
          for (;;)
          {
            localObject1 = localObject2;
            if (localObject2 == null) {
              break;
            }
            localObject1 = localObject2;
            if (localObject3 != em.c.c((em.c)localObject2)) {
              break;
            }
            localObject1 = em.c.d((em.c)localObject2);
            localObject3 = localObject2;
            localObject2 = localObject1;
          }
          localObject2 = em.c.c((em.c)localObject1);
          break label156;
          if (localObject1 == em.c.b(em.c.d((em.c)localObject1)))
          {
            em.c.a(em.c.d((em.c)localObject1), (em.c)localObject2);
            break label182;
          }
          em.c.b(em.c.d((em.c)localObject1), (em.c)localObject2);
          break label182;
          if (em.c.d((em.c)localObject1) == null)
          {
            localem.b = null;
            return;
          }
          if (!em.c.e((em.c)localObject1)) {
            localem.a((em.c)localObject1);
          }
        } while (em.c.d((em.c)localObject1) == null);
        label289:
        label324:
        if (localObject1 == em.c.b(em.c.d((em.c)localObject1))) {
          em.c.a(em.c.d((em.c)localObject1), null);
        }
        for (;;)
        {
          em.c.d((em.c)localObject1, null);
          return;
          if (localObject1 == em.c.c(em.c.d((em.c)localObject1))) {
            em.c.b(em.c.d((em.c)localObject1), null);
          }
        }
        label408:
        localObject1 = localc;
      }
    }
  }
  
  public static final class c<K extends Comparable<K>, V>
    implements Map.Entry<K, V>
  {
    K a;
    private V b;
    private c<K, V> c;
    private c<K, V> d;
    private c<K, V> e;
    private boolean f = false;
    private c<K, V> g;
    private c<K, V> h;
    
    c(c<K, V> paramc1, c<K, V> paramc2, K paramK, V paramV)
    {
      this.c = paramc1;
      this.h = paramc2;
      this.a = paramK;
      this.b = paramV;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry)) {}
      Object localObject;
      do
      {
        do
        {
          return false;
          paramObject = (Map.Entry)paramObject;
          localObject = paramObject.getValue();
        } while (!this.a.equals(paramObject.getKey()));
        if (this.b != null) {
          break;
        }
      } while (localObject != null);
      for (;;)
      {
        return true;
        if (!this.b.equals(localObject)) {
          break;
        }
      }
    }
    
    public final V getValue()
    {
      return this.b;
    }
    
    public final int hashCode()
    {
      int j = this.a.hashCode();
      if (this.b == null) {}
      for (int i = 0;; i = this.b.hashCode()) {
        return i ^ j;
      }
    }
    
    public final V setValue(V paramV)
    {
      Object localObject = this.b;
      this.b = paramV;
      return localObject;
    }
    
    public final String toString()
    {
      return this.a + "=" + this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.em
 * JD-Core Version:    0.7.0.1
 */