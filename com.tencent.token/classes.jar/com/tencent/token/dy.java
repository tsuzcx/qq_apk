package com.tencent.token;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class dy<K, V>
  extends ej<K, V>
  implements Map<K, V>
{
  ef<K, V> a;
  
  private ef<K, V> a()
  {
    if (this.a == null) {
      this.a = new ef()
      {
        protected final int a()
        {
          return dy.this.h;
        }
        
        protected final int a(Object paramAnonymousObject)
        {
          return dy.this.a(paramAnonymousObject);
        }
        
        protected final Object a(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return dy.this.g[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }
        
        protected final V a(int paramAnonymousInt, V paramAnonymousV)
        {
          dy localdy = dy.this;
          paramAnonymousInt = (paramAnonymousInt << 1) + 1;
          Object localObject = localdy.g[paramAnonymousInt];
          localdy.g[paramAnonymousInt] = paramAnonymousV;
          return localObject;
        }
        
        protected final void a(int paramAnonymousInt)
        {
          dy.this.d(paramAnonymousInt);
        }
        
        protected final void a(K paramAnonymousK, V paramAnonymousV)
        {
          dy.this.put(paramAnonymousK, paramAnonymousV);
        }
        
        protected final int b(Object paramAnonymousObject)
        {
          return dy.this.b(paramAnonymousObject);
        }
        
        protected final Map<K, V> b()
        {
          return dy.this;
        }
        
        protected final void c()
        {
          dy.this.clear();
        }
      };
    }
    return this.a;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    ef localef = a();
    if (localef.b == null) {
      localef.b = new ef.b(localef);
    }
    return localef.b;
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
      ej.a((int[])localObject, arrayOfObject, j);
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
    ef localef = a();
    if (localef.d == null) {
      localef.d = new ef.e(localef);
    }
    return localef.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dy
 * JD-Core Version:    0.7.0.1
 */