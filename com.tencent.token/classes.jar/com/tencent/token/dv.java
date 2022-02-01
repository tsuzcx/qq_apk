package com.tencent.token;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class dv<K, V>
  extends eg<K, V>
  implements Map<K, V>
{
  ec<K, V> a;
  
  private ec<K, V> a()
  {
    if (this.a == null) {
      this.a = new ec()
      {
        protected final int a()
        {
          return dv.this.h;
        }
        
        protected final int a(Object paramAnonymousObject)
        {
          return dv.this.a(paramAnonymousObject);
        }
        
        protected final Object a(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return dv.this.g[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }
        
        protected final V a(int paramAnonymousInt, V paramAnonymousV)
        {
          dv localdv = dv.this;
          paramAnonymousInt = (paramAnonymousInt << 1) + 1;
          Object localObject = localdv.g[paramAnonymousInt];
          localdv.g[paramAnonymousInt] = paramAnonymousV;
          return localObject;
        }
        
        protected final void a(int paramAnonymousInt)
        {
          dv.this.d(paramAnonymousInt);
        }
        
        protected final void a(K paramAnonymousK, V paramAnonymousV)
        {
          dv.this.put(paramAnonymousK, paramAnonymousV);
        }
        
        protected final int b(Object paramAnonymousObject)
        {
          return dv.this.b(paramAnonymousObject);
        }
        
        protected final Map<K, V> b()
        {
          return dv.this;
        }
        
        protected final void c()
        {
          dv.this.clear();
        }
      };
    }
    return this.a;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    ec localec = a();
    if (localec.b == null) {
      localec.b = new ec.b(localec);
    }
    return localec.b;
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
      eg.a((int[])localObject, arrayOfObject, j);
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
    ec localec = a();
    if (localec.d == null) {
      localec.d = new ec.e(localec);
    }
    return localec.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dv
 * JD-Core Version:    0.7.0.1
 */