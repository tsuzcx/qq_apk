package com.tencent.turingfd.sdk.qps;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class Andromeda<K, V>
  extends AbstractMap<K, V>
  implements Serializable
{
  public static final Comparator<Comparable> a = new a();
  public Comparator<? super K> c;
  public e<K, V> d;
  public int e = 0;
  public int f = 0;
  public final e<K, V> g = new e();
  public Andromeda<K, V>.c h;
  public Andromeda<K, V>.b i;
  
  public Andromeda()
  {
    this(a);
  }
  
  public Andromeda(Comparator<? super K> paramComparator)
  {
    Object localObject = paramComparator;
    if (paramComparator == null) {
      localObject = a;
    }
    this.c = ((Comparator)localObject);
  }
  
  private void a(e<K, V> parame)
  {
    e locale1 = parame.b;
    e locale2 = parame.c;
    e locale3 = locale2.b;
    e locale4 = locale2.c;
    parame.c = locale3;
    if (locale3 != null) {
      locale3.a = parame;
    }
    a(parame, locale2);
    locale2.b = parame;
    parame.a = locale2;
    int m = 0;
    if (locale1 != null) {
      j = locale1.h;
    } else {
      j = 0;
    }
    if (locale3 != null) {
      k = locale3.h;
    } else {
      k = 0;
    }
    int k = Math.max(j, k) + 1;
    parame.h = k;
    int j = m;
    if (locale4 != null) {
      j = locale4.h;
    }
    locale2.h = (Math.max(k, j) + 1);
  }
  
  private void a(e<K, V> parame1, e<K, V> parame2)
  {
    e locale = parame1.a;
    parame1.a = null;
    if (parame2 != null) {
      parame2.a = locale;
    }
    if (locale != null)
    {
      if (locale.b == parame1)
      {
        locale.b = parame2;
        return;
      }
      if ((!b) && (locale.c != parame1)) {
        throw new AssertionError();
      }
      locale.c = parame2;
      return;
    }
    this.d = parame2;
  }
  
  private void b(e<K, V> parame)
  {
    e locale1 = parame.b;
    e locale2 = parame.c;
    e locale3 = locale1.b;
    e locale4 = locale1.c;
    parame.b = locale4;
    if (locale4 != null) {
      locale4.a = parame;
    }
    a(parame, locale1);
    locale1.c = parame;
    parame.a = locale1;
    int m = 0;
    if (locale2 != null) {
      j = locale2.h;
    } else {
      j = 0;
    }
    if (locale4 != null) {
      k = locale4.h;
    } else {
      k = 0;
    }
    int k = Math.max(j, k) + 1;
    parame.h = k;
    int j = m;
    if (locale3 != null) {
      j = locale3.h;
    }
    locale1.h = (Math.max(k, j) + 1);
  }
  
  private void b(e<K, V> parame, boolean paramBoolean)
  {
    while (parame != null)
    {
      e locale1 = parame.b;
      e locale2 = parame.c;
      int n = 0;
      int m = 0;
      int j;
      if (locale1 != null) {
        j = locale1.h;
      } else {
        j = 0;
      }
      int k;
      if (locale2 != null) {
        k = locale2.h;
      } else {
        k = 0;
      }
      int i1 = j - k;
      e locale3;
      if (i1 == -2)
      {
        locale1 = locale2.b;
        locale3 = locale2.c;
        if (locale3 != null) {
          j = locale3.h;
        } else {
          j = 0;
        }
        k = m;
        if (locale1 != null) {
          k = locale1.h;
        }
        j = k - j;
        if ((j != -1) && ((j != 0) || (paramBoolean)))
        {
          if ((!b) && (j != 1)) {
            throw new AssertionError();
          }
          b(locale2);
          a(parame);
        }
        else
        {
          a(parame);
        }
        if (!paramBoolean) {}
      }
      else if (i1 == 2)
      {
        locale2 = locale1.b;
        locale3 = locale1.c;
        if (locale3 != null) {
          j = locale3.h;
        } else {
          j = 0;
        }
        k = n;
        if (locale2 != null) {
          k = locale2.h;
        }
        j = k - j;
        if ((j != 1) && ((j != 0) || (paramBoolean)))
        {
          if ((!b) && (j != -1)) {
            throw new AssertionError();
          }
          a(locale1);
          b(parame);
        }
        else
        {
          b(parame);
        }
        if (!paramBoolean) {}
      }
      else if (i1 == 0)
      {
        parame.h = (j + 1);
        if (!paramBoolean) {}
      }
      else
      {
        if ((!b) && (i1 != -1) && (i1 != 1)) {
          throw new AssertionError();
        }
        parame.h = (Math.max(j, k) + 1);
        if (!paramBoolean) {
          break;
        }
      }
      parame = parame.a;
    }
  }
  
  public final e<K, V> a(Object paramObject)
  {
    e locale = null;
    if (paramObject != null) {}
    try
    {
      locale = a(paramObject, false);
      return locale;
    }
    catch (ClassCastException paramObject) {}
    return null;
  }
  
  public final e<K, V> a(K paramK, boolean paramBoolean)
  {
    Comparator localComparator = this.c;
    Object localObject = this.d;
    if (localObject != null)
    {
      Comparable localComparable;
      if (localComparator == a) {
        localComparable = (Comparable)paramK;
      } else {
        localComparable = null;
      }
      for (;;)
      {
        if (localComparable != null) {
          j = localComparable.compareTo(((e)localObject).f);
        } else {
          j = localComparator.compare(paramK, ((e)localObject).f);
        }
        if (j == 0) {
          return localObject;
        }
        if (j < 0) {
          locale = ((e)localObject).b;
        } else {
          locale = ((e)localObject).c;
        }
        if (locale == null) {
          break;
        }
        localObject = locale;
      }
    }
    int j = 0;
    if (!paramBoolean) {
      return null;
    }
    e locale = this.g;
    if (localObject == null)
    {
      if ((localComparator == a) && (!(paramK instanceof Comparable)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramK.getClass().getName());
        ((StringBuilder)localObject).append(" is not Comparable");
        throw new ClassCastException(((StringBuilder)localObject).toString());
      }
      paramK = new e((e)localObject, paramK, locale, locale.e);
      this.d = paramK;
    }
    else
    {
      paramK = new e((e)localObject, paramK, locale, locale.e);
      if (j < 0) {
        ((e)localObject).b = paramK;
      } else {
        ((e)localObject).c = paramK;
      }
      b((e)localObject, true);
    }
    this.e += 1;
    this.f += 1;
    return paramK;
  }
  
  public final e<K, V> a(Map.Entry<?, ?> paramEntry)
  {
    e locale = a(paramEntry.getKey());
    int k = 1;
    if (locale != null)
    {
      Object localObject = locale.g;
      paramEntry = paramEntry.getValue();
      if ((localObject != paramEntry) && ((localObject == null) || (!localObject.equals(paramEntry)))) {
        j = 0;
      } else {
        j = 1;
      }
      if (j != 0)
      {
        j = k;
        break label71;
      }
    }
    int j = 0;
    label71:
    paramEntry = locale;
    if (j == 0) {
      paramEntry = null;
    }
    return paramEntry;
  }
  
  public final void a(e<K, V> parame, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject1 = parame.e;
      ((e)localObject1).d = parame.d;
      parame.d.e = ((e)localObject1);
    }
    Object localObject2 = parame.b;
    Object localObject1 = parame.c;
    e locale = parame.a;
    int k = 0;
    if ((localObject2 != null) && (localObject1 != null))
    {
      if (((e)localObject2).h > ((e)localObject1).h)
      {
        for (localObject1 = ((e)localObject2).c; localObject1 != null; localObject1 = locale)
        {
          locale = ((e)localObject1).c;
          localObject2 = localObject1;
        }
        localObject1 = localObject2;
      }
      else
      {
        for (localObject2 = ((e)localObject1).b; localObject2 != null; localObject2 = locale)
        {
          locale = ((e)localObject2).b;
          localObject1 = localObject2;
        }
      }
      a((e)localObject1, false);
      localObject2 = parame.b;
      int j;
      if (localObject2 != null)
      {
        j = ((e)localObject2).h;
        ((e)localObject1).b = ((e)localObject2);
        ((e)localObject2).a = ((e)localObject1);
        parame.b = null;
      }
      else
      {
        j = 0;
      }
      localObject2 = parame.c;
      if (localObject2 != null)
      {
        k = ((e)localObject2).h;
        ((e)localObject1).c = ((e)localObject2);
        ((e)localObject2).a = ((e)localObject1);
        parame.c = null;
      }
      ((e)localObject1).h = (Math.max(j, k) + 1);
      a(parame, (e)localObject1);
      return;
    }
    if (localObject2 != null)
    {
      a(parame, (e)localObject2);
      parame.b = null;
    }
    else if (localObject1 != null)
    {
      a(parame, (e)localObject1);
      parame.c = null;
    }
    else
    {
      a(parame, null);
    }
    b(locale, false);
    this.e -= 1;
    this.f += 1;
  }
  
  public final void clear()
  {
    this.d = null;
    this.e = 0;
    this.f += 1;
    e locale = this.g;
    locale.e = locale;
    locale.d = locale;
  }
  
  public final boolean containsKey(Object paramObject)
  {
    return a(paramObject) != null;
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    c localc2 = this.h;
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      this.h = localc1;
    }
    return localc1;
  }
  
  public final V get(Object paramObject)
  {
    paramObject = a(paramObject);
    if (paramObject != null) {
      return paramObject.g;
    }
    return null;
  }
  
  public final Set<K> keySet()
  {
    b localb2 = this.i;
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      this.i = localb1;
    }
    return localb1;
  }
  
  public final V put(K paramK, V paramV)
  {
    if (paramK != null)
    {
      paramK = a(paramK, true);
      Object localObject = paramK.g;
      paramK.g = paramV;
      return localObject;
    }
    throw new NullPointerException("key == null");
  }
  
  public final V remove(Object paramObject)
  {
    paramObject = a(paramObject);
    if (paramObject != null) {
      a(paramObject, true);
    }
    if (paramObject != null) {
      return paramObject.g;
    }
    return null;
  }
  
  public final int size()
  {
    return this.e;
  }
  
  public final class a
    implements Comparator<Comparable>
  {
    public final int compare(Object paramObject1, Object paramObject2)
    {
      return ((Comparable)paramObject1).compareTo((Comparable)paramObject2);
    }
  }
  
  public final class b
    extends AbstractSet<K>
  {
    public b() {}
    
    public final void clear()
    {
      Andromeda.this.clear();
    }
    
    public final boolean contains(Object paramObject)
    {
      return Andromeda.this.a(paramObject) != null;
    }
    
    public final Iterator<K> iterator()
    {
      return new a();
    }
    
    public final boolean remove(Object paramObject)
    {
      Andromeda localAndromeda = Andromeda.this;
      paramObject = localAndromeda.a(paramObject);
      if (paramObject != null) {
        localAndromeda.a(paramObject, true);
      }
      return paramObject != null;
    }
    
    public final int size()
    {
      return Andromeda.this.e;
    }
    
    public final class a
      extends Andromeda<K, V>.d<K>
    {
      public a()
      {
        super();
      }
      
      public final K next()
      {
        return a().f;
      }
    }
  }
  
  public final class c
    extends AbstractSet<Map.Entry<K, V>>
  {
    public c() {}
    
    public final void clear()
    {
      Andromeda.this.clear();
    }
    
    public final boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Map.Entry)) && (Andromeda.this.a((Map.Entry)paramObject) != null);
    }
    
    public final Iterator<Map.Entry<K, V>> iterator()
    {
      return new a();
    }
    
    public final boolean remove(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry)) {
        return false;
      }
      paramObject = Andromeda.this.a((Map.Entry)paramObject);
      if (paramObject == null) {
        return false;
      }
      Andromeda.this.a(paramObject, true);
      return true;
    }
    
    public final int size()
    {
      return Andromeda.this.e;
    }
    
    public final class a
      extends Andromeda<K, V>.d<Map.Entry<K, V>>
    {
      public a()
      {
        super();
      }
      
      public final Object next()
      {
        return a();
      }
    }
  }
  
  public abstract class d<T>
    implements Iterator<T>
  {
    public Andromeda.e<K, V> a = Andromeda.this.g.d;
    public Andromeda.e<K, V> b = null;
    public int c = Andromeda.this.f;
    
    public d() {}
    
    public final Andromeda.e<K, V> a()
    {
      Andromeda.e locale = this.a;
      Andromeda localAndromeda = Andromeda.this;
      if (locale != localAndromeda.g)
      {
        if (localAndromeda.f == this.c)
        {
          this.a = locale.d;
          this.b = locale;
          return locale;
        }
        throw new ConcurrentModificationException();
      }
      throw new NoSuchElementException();
    }
    
    public final boolean hasNext()
    {
      return this.a != Andromeda.this.g;
    }
    
    public final void remove()
    {
      Andromeda.e locale = this.b;
      if (locale != null)
      {
        Andromeda.this.a(locale, true);
        this.b = null;
        this.c = Andromeda.this.f;
        return;
      }
      throw new IllegalStateException();
    }
  }
  
  public static final class e<K, V>
    implements Map.Entry<K, V>
  {
    public e<K, V> a;
    public e<K, V> b;
    public e<K, V> c;
    public e<K, V> d;
    public e<K, V> e;
    public final K f;
    public V g;
    public int h;
    
    public e()
    {
      this.f = null;
      this.e = this;
      this.d = this;
    }
    
    public e(e<K, V> parame1, K paramK, e<K, V> parame2, e<K, V> parame3)
    {
      this.a = parame1;
      this.f = paramK;
      this.h = 1;
      this.d = parame2;
      this.e = parame3;
      parame3.d = this;
      parame2.e = this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject instanceof Map.Entry))
      {
        paramObject = (Map.Entry)paramObject;
        Object localObject = this.f;
        if (localObject == null ? paramObject.getKey() == null : localObject.equals(paramObject.getKey()))
        {
          localObject = this.g;
          if (localObject == null ? paramObject.getValue() == null : localObject.equals(paramObject.getValue())) {
            return true;
          }
        }
      }
      return false;
    }
    
    public final K getKey()
    {
      return this.f;
    }
    
    public final V getValue()
    {
      return this.g;
    }
    
    public final int hashCode()
    {
      Object localObject = this.f;
      int j = 0;
      int i;
      if (localObject == null) {
        i = 0;
      } else {
        i = localObject.hashCode();
      }
      localObject = this.g;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      return i ^ j;
    }
    
    public final V setValue(V paramV)
    {
      Object localObject = this.g;
      this.g = paramV;
      return localObject;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.f);
      localStringBuilder.append("=");
      localStringBuilder.append(this.g);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Andromeda
 * JD-Core Version:    0.7.0.1
 */