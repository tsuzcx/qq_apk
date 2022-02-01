package com.tencent.token;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class em<K, V>
  extends ex<K, V>
  implements Map<K, V>
{
  et<K, V> a;
  
  private et<K, V> a()
  {
    if (this.a == null) {
      this.a = new et()
      {
        protected final int a()
        {
          return em.this.h;
        }
        
        protected final int a(Object paramAnonymousObject)
        {
          return em.this.a(paramAnonymousObject);
        }
        
        protected final Object a(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return em.this.g[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }
        
        protected final V a(int paramAnonymousInt, V paramAnonymousV)
        {
          em localem = em.this;
          paramAnonymousInt = (paramAnonymousInt << 1) + 1;
          Object localObject = localem.g[paramAnonymousInt];
          localem.g[paramAnonymousInt] = paramAnonymousV;
          return localObject;
        }
        
        protected final void a(int paramAnonymousInt)
        {
          em.this.d(paramAnonymousInt);
        }
        
        protected final void a(K paramAnonymousK, V paramAnonymousV)
        {
          em.this.put(paramAnonymousK, paramAnonymousV);
        }
        
        protected final int b(Object paramAnonymousObject)
        {
          return em.this.b(paramAnonymousObject);
        }
        
        protected final Map<K, V> b()
        {
          return em.this;
        }
        
        protected final void c()
        {
          em.this.clear();
        }
      };
    }
    return this.a;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    et localet = a();
    if (localet.b == null) {
      localet.b = new et.b(localet);
    }
    return localet.b;
  }
  
  public Set<K> keySet()
  {
    return a().d();
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    int i = this.h + paramMap.size();
    int j = this.h;
    Object localObject;
    if (this.f.length < i)
    {
      localObject = this.f;
      Object[] arrayOfObject = this.g;
      super.a(i);
      if (this.h > 0)
      {
        System.arraycopy(localObject, 0, this.f, 0, j);
        System.arraycopy(arrayOfObject, 0, this.g, 0, j << 1);
      }
      ex.a((int[])localObject, arrayOfObject, j);
    }
    if (this.h == j)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        localObject = (Map.Entry)paramMap.next();
        put(((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      }
      return;
    }
    throw new ConcurrentModificationException();
  }
  
  public Collection<V> values()
  {
    et localet = a();
    if (localet.d == null) {
      localet.d = new et.e(localet);
    }
    return localet.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.em
 * JD-Core Version:    0.7.0.1
 */