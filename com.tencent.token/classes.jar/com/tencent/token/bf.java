package com.tencent.token;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class bf<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  public c<K, V> b;
  public c<K, V> c;
  public WeakHashMap<f<K, V>, Boolean> d = new WeakHashMap();
  public int e = 0;
  
  protected c<K, V> a(K paramK)
  {
    for (c localc = this.b; (localc != null) && (!localc.a.equals(paramK)); localc = localc.c) {}
    return localc;
  }
  
  public final bf<K, V>.d a()
  {
    d locald = new d((byte)0);
    this.d.put(locald, Boolean.FALSE);
    return locald;
  }
  
  public V a(K paramK, V paramV)
  {
    c localc = a(paramK);
    if (localc != null) {
      return localc.b;
    }
    b(paramK, paramV);
    return null;
  }
  
  protected final c<K, V> b(K paramK, V paramV)
  {
    paramK = new c(paramK, paramV);
    this.e += 1;
    paramV = this.c;
    if (paramV == null)
    {
      this.b = paramK;
      this.c = this.b;
      return paramK;
    }
    paramV.c = paramK;
    paramK.d = paramV;
    this.c = paramK;
    return paramK;
  }
  
  public V b(K paramK)
  {
    paramK = a(paramK);
    if (paramK == null) {
      return null;
    }
    this.e -= 1;
    if (!this.d.isEmpty())
    {
      Iterator localIterator = this.d.keySet().iterator();
      while (localIterator.hasNext()) {
        ((f)localIterator.next()).a_(paramK);
      }
    }
    if (paramK.d != null) {
      paramK.d.c = paramK.c;
    } else {
      this.b = paramK.c;
    }
    if (paramK.c != null) {
      paramK.c.d = paramK.d;
    } else {
      this.c = paramK.d;
    }
    paramK.c = null;
    paramK.d = null;
    return paramK.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof bf)) {
      return false;
    }
    Object localObject1 = (bf)paramObject;
    if (this.e != ((bf)localObject1).e) {
      return false;
    }
    paramObject = iterator();
    localObject1 = ((bf)localObject1).iterator();
    while ((paramObject.hasNext()) && (((Iterator)localObject1).hasNext()))
    {
      Map.Entry localEntry = (Map.Entry)paramObject.next();
      Object localObject2 = ((Iterator)localObject1).next();
      if (((localEntry == null) && (localObject2 != null)) || ((localEntry != null) && (!localEntry.equals(localObject2)))) {
        return false;
      }
    }
    return (!paramObject.hasNext()) && (!((Iterator)localObject1).hasNext());
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    a locala = new a(this.b, this.c);
    this.d.put(locala, Boolean.FALSE);
    return locala;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((Map.Entry)localIterator.next()).toString());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  static final class a<K, V>
    extends bf.e<K, V>
  {
    a(bf.c<K, V> paramc1, bf.c<K, V> paramc2)
    {
      super(paramc2);
    }
    
    final bf.c<K, V> a(bf.c<K, V> paramc)
    {
      return paramc.c;
    }
    
    final bf.c<K, V> b(bf.c<K, V> paramc)
    {
      return paramc.d;
    }
  }
  
  public static final class b<K, V>
    extends bf.e<K, V>
  {
    public b(bf.c<K, V> paramc1, bf.c<K, V> paramc2)
    {
      super(paramc2);
    }
    
    final bf.c<K, V> a(bf.c<K, V> paramc)
    {
      return paramc.d;
    }
    
    final bf.c<K, V> b(bf.c<K, V> paramc)
    {
      return paramc.c;
    }
  }
  
  public static final class c<K, V>
    implements Map.Entry<K, V>
  {
    final K a;
    final V b;
    c<K, V> c;
    public c<K, V> d;
    
    c(K paramK, V paramV)
    {
      this.a = paramK;
      this.b = paramV;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof c)) {
        return false;
      }
      paramObject = (c)paramObject;
      return (this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b));
    }
    
    public final K getKey()
    {
      return this.a;
    }
    
    public final V getValue()
    {
      return this.b;
    }
    
    public final V setValue(V paramV)
    {
      throw new UnsupportedOperationException("An entry modification is not supported");
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("=");
      localStringBuilder.append(this.b);
      return localStringBuilder.toString();
    }
  }
  
  public final class d
    implements bf.f<K, V>, Iterator<Map.Entry<K, V>>
  {
    private bf.c<K, V> b;
    private boolean c = true;
    
    private d() {}
    
    public final void a_(bf.c<K, V> paramc)
    {
      bf.c localc = this.b;
      if (paramc == localc)
      {
        this.b = localc.d;
        boolean bool;
        if (this.b == null) {
          bool = true;
        } else {
          bool = false;
        }
        this.c = bool;
      }
    }
    
    public final boolean hasNext()
    {
      if (this.c) {
        return bf.a(bf.this) != null;
      }
      bf.c localc = this.b;
      return (localc != null) && (localc.c != null);
    }
  }
  
  static abstract class e<K, V>
    implements bf.f<K, V>, Iterator<Map.Entry<K, V>>
  {
    bf.c<K, V> a;
    bf.c<K, V> b;
    
    e(bf.c<K, V> paramc1, bf.c<K, V> paramc2)
    {
      this.a = paramc2;
      this.b = paramc1;
    }
    
    private bf.c<K, V> a()
    {
      bf.c localc1 = this.b;
      bf.c localc2 = this.a;
      if ((localc1 != localc2) && (localc2 != null)) {
        return a(localc1);
      }
      return null;
    }
    
    abstract bf.c<K, V> a(bf.c<K, V> paramc);
    
    public final void a_(bf.c<K, V> paramc)
    {
      if ((this.a == paramc) && (paramc == this.b))
      {
        this.b = null;
        this.a = null;
      }
      bf.c localc = this.a;
      if (localc == paramc) {
        this.a = b(localc);
      }
      if (this.b == paramc) {
        this.b = a();
      }
    }
    
    abstract bf.c<K, V> b(bf.c<K, V> paramc);
    
    public boolean hasNext()
    {
      return this.b != null;
    }
  }
  
  static abstract interface f<K, V>
  {
    public abstract void a_(bf.c<K, V> paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bf
 * JD-Core Version:    0.7.0.1
 */