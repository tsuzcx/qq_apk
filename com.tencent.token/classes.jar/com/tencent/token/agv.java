package com.tencent.token;

import android.annotation.SuppressLint;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class agv<K, V>
{
  private final LinkedHashMap<K, V> a;
  public int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public agv(int paramInt)
  {
    if (paramInt > 0)
    {
      this.b = paramInt;
      this.a = new LinkedHashMap(0, 0.75F, true);
      return;
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  public final V a(K paramK, V paramV)
  {
    if ((paramK != null) && (paramV != null)) {
      try
      {
        this.d += 1;
        this.c += 1;
        paramK = this.a.put(paramK, paramV);
        if (paramK != null) {
          this.c -= 1;
        }
        if (paramK != null) {
          a(paramK);
        }
        a(this.b);
        return paramK;
      }
      finally {}
    }
    throw new NullPointerException("key == null || value == null");
  }
  
  public final void a()
  {
    a(-1);
  }
  
  public final void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.c >= 0) && ((!this.a.isEmpty()) || (this.c == 0)))
        {
          if ((this.c > paramInt) && (!this.a.isEmpty()))
          {
            localObject1 = null;
            if (this.a.entrySet().iterator().hasNext()) {
              localObject1 = (Map.Entry)this.a.entrySet().iterator().next();
            }
            if (localObject1 == null) {
              return;
            }
            Object localObject3 = ((Map.Entry)localObject1).getKey();
            localObject1 = ((Map.Entry)localObject1).getValue();
            this.a.remove(localObject3);
            this.c -= 1;
            this.e += 1;
            a(localObject1);
            continue;
          }
          return;
        }
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getClass().getName());
        ((StringBuilder)localObject1).append(".sizeOf() is reporting inconsistent results!");
        throw new IllegalStateException(((StringBuilder)localObject1).toString());
      }
      finally {}
    }
  }
  
  protected void a(V paramV) {}
  
  public final V b(K paramK)
  {
    if (paramK != null) {
      try
      {
        paramK = this.a.get(paramK);
        if (paramK != null)
        {
          this.f += 1;
          return paramK;
        }
        this.g += 1;
        return null;
      }
      finally {}
    }
    throw new NullPointerException("key == null");
  }
  
  public final V c(K paramK)
  {
    if (paramK != null) {
      try
      {
        paramK = this.a.remove(paramK);
        if (paramK != null) {
          this.c -= 1;
        }
        if (paramK != null) {
          a(paramK);
        }
        return paramK;
      }
      finally {}
    }
    throw new NullPointerException("key == null");
  }
  
  @SuppressLint({"DefaultLocale"})
  public final String toString()
  {
    for (;;)
    {
      try
      {
        i = this.f + this.g;
        if (i != 0)
        {
          i = this.f * 100 / i;
          String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(i) });
          return str;
        }
      }
      finally {}
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.agv
 * JD-Core Version:    0.7.0.1
 */