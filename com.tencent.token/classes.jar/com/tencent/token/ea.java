package com.tencent.token;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

public class ea<K, V>
{
  private final LinkedHashMap<K, V> a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public ea(int paramInt)
  {
    if (paramInt > 0)
    {
      this.c = paramInt;
      this.a = new LinkedHashMap(0, 0.75F, true);
      return;
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.b >= 0) && ((!this.a.isEmpty()) || (this.b == 0)))
        {
          if ((this.b > paramInt) && (!this.a.isEmpty()))
          {
            localObject1 = (Map.Entry)this.a.entrySet().iterator().next();
            Object localObject3 = ((Map.Entry)localObject1).getKey();
            ((Map.Entry)localObject1).getValue();
            this.a.remove(localObject3);
            this.b -= 1;
            this.e += 1;
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
  
  public final V a(K paramK)
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
  
  public final V a(K paramK, V paramV)
  {
    if ((paramK != null) && (paramV != null)) {
      try
      {
        this.d += 1;
        this.b += 1;
        paramK = this.a.put(paramK, paramV);
        if (paramK != null) {
          this.b -= 1;
        }
        a(this.c);
        return paramK;
      }
      finally {}
    }
    throw new NullPointerException("key == null || value == null");
  }
  
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
          String str = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(i) });
          return str;
        }
      }
      finally {}
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ea
 * JD-Core Version:    0.7.0.1
 */