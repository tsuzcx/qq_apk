package com.tencent.token;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class du<K, V>
  extends ef<K, V>
  implements Map<K, V>
{
  eb<K, V> a;
  
  private eb<K, V> a()
  {
    if (this.a == null) {
      this.a = new eb()
      {
        protected final int a()
        {
          return du.this.h;
        }
        
        protected final int a(Object paramAnonymousObject)
        {
          return du.this.a(paramAnonymousObject);
        }
        
        protected final Object a(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return du.this.g[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }
        
        protected final V a(int paramAnonymousInt, V paramAnonymousV)
        {
          du localdu = du.this;
          paramAnonymousInt = (paramAnonymousInt << 1) + 1;
          Object localObject = localdu.g[paramAnonymousInt];
          localdu.g[paramAnonymousInt] = paramAnonymousV;
          return localObject;
        }
        
        protected final void a(int paramAnonymousInt)
        {
          du.this.d(paramAnonymousInt);
        }
        
        protected final void a(K paramAnonymousK, V paramAnonymousV)
        {
          du.this.put(paramAnonymousK, paramAnonymousV);
        }
        
        protected final int b(Object paramAnonymousObject)
        {
          return du.this.b(paramAnonymousObject);
        }
        
        protected final Map<K, V> b()
        {
          return du.this;
        }
        
        protected final void c()
        {
          du.this.clear();
        }
      };
    }
    return this.a;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    eb localeb = a();
    if (localeb.b == null) {
      localeb.b = new eb.b(localeb);
    }
    return localeb.b;
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
      ef.a((int[])localObject, arrayOfObject, j);
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
    eb localeb = a();
    if (localeb.d == null) {
      localeb.d = new eb.e(localeb);
    }
    return localeb.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.du
 * JD-Core Version:    0.7.0.1
 */