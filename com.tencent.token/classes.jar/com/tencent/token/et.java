package com.tencent.token;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class et<K, V>
{
  et<K, V>.b b;
  et<K, V>.c c;
  et<K, V>.e d;
  
  public static <K, V> boolean a(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    int i = paramMap.size();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext()) {
      if (!paramCollection.contains(localIterator.next())) {
        localIterator.remove();
      }
    }
    return i != paramMap.size();
  }
  
  public static <T> boolean a(Set<T> paramSet, Object paramObject)
  {
    if (paramSet == paramObject) {
      return true;
    }
    if ((paramObject instanceof Set)) {
      paramObject = (Set)paramObject;
    }
    try
    {
      if (paramSet.size() == paramObject.size())
      {
        boolean bool = paramSet.containsAll(paramObject);
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (NullPointerException paramSet)
    {
      return false;
    }
    catch (ClassCastException paramSet) {}
    return false;
    return false;
  }
  
  protected abstract int a();
  
  protected abstract int a(Object paramObject);
  
  protected abstract Object a(int paramInt1, int paramInt2);
  
  protected abstract V a(int paramInt, V paramV);
  
  protected abstract void a(int paramInt);
  
  protected abstract void a(K paramK, V paramV);
  
  public final <T> T[] a(T[] paramArrayOfT, int paramInt)
  {
    int j = a();
    Object localObject = paramArrayOfT;
    if (paramArrayOfT.length < j) {
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
    }
    int i = 0;
    while (i < j)
    {
      localObject[i] = a(i, paramInt);
      i += 1;
    }
    if (localObject.length > j) {
      localObject[j] = null;
    }
    return localObject;
  }
  
  protected abstract int b(Object paramObject);
  
  protected abstract Map<K, V> b();
  
  public final Object[] b(int paramInt)
  {
    int j = a();
    Object[] arrayOfObject = new Object[j];
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = a(i, paramInt);
      i += 1;
    }
    return arrayOfObject;
  }
  
  protected abstract void c();
  
  public final Set<K> d()
  {
    if (this.c == null) {
      this.c = new c();
    }
    return this.c;
  }
  
  final class a<T>
    implements Iterator<T>
  {
    final int a;
    int b;
    int c;
    boolean d = false;
    
    a(int paramInt)
    {
      this.a = paramInt;
      this.b = et.this.a();
    }
    
    public final boolean hasNext()
    {
      return this.c < this.b;
    }
    
    public final T next()
    {
      if (hasNext())
      {
        Object localObject = et.this.a(this.c, this.a);
        this.c += 1;
        this.d = true;
        return localObject;
      }
      throw new NoSuchElementException();
    }
    
    public final void remove()
    {
      if (this.d)
      {
        this.c -= 1;
        this.b -= 1;
        this.d = false;
        et.this.a(this.c);
        return;
      }
      throw new IllegalStateException();
    }
  }
  
  final class b
    implements Set<Map.Entry<K, V>>
  {
    b() {}
    
    public final boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection)
    {
      int i = et.this.a();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramCollection.next();
        et.this.a(localEntry.getKey(), localEntry.getValue());
      }
      return i != et.this.a();
    }
    
    public final void clear()
    {
      et.this.c();
    }
    
    public final boolean contains(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry)) {
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      int i = et.this.a(paramObject.getKey());
      if (i < 0) {
        return false;
      }
      return eo.a(et.this.a(i, 1), paramObject.getValue());
    }
    
    public final boolean containsAll(Collection<?> paramCollection)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next())) {
          return false;
        }
      }
      return true;
    }
    
    public final boolean equals(Object paramObject)
    {
      return et.a(this, paramObject);
    }
    
    public final int hashCode()
    {
      int i = et.this.a() - 1;
      int j = 0;
      while (i >= 0)
      {
        Object localObject1 = et.this.a(i, 0);
        Object localObject2 = et.this.a(i, 1);
        int k;
        if (localObject1 == null) {
          k = 0;
        } else {
          k = localObject1.hashCode();
        }
        int m;
        if (localObject2 == null) {
          m = 0;
        } else {
          m = localObject2.hashCode();
        }
        j += (k ^ m);
        i -= 1;
      }
      return j;
    }
    
    public final boolean isEmpty()
    {
      return et.this.a() == 0;
    }
    
    public final Iterator<Map.Entry<K, V>> iterator()
    {
      return new et.d(et.this);
    }
    
    public final boolean remove(Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public final boolean removeAll(Collection<?> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public final boolean retainAll(Collection<?> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public final int size()
    {
      return et.this.a();
    }
    
    public final Object[] toArray()
    {
      throw new UnsupportedOperationException();
    }
    
    public final <T> T[] toArray(T[] paramArrayOfT)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  final class c
    implements Set<K>
  {
    c() {}
    
    public final boolean add(K paramK)
    {
      throw new UnsupportedOperationException();
    }
    
    public final boolean addAll(Collection<? extends K> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public final void clear()
    {
      et.this.c();
    }
    
    public final boolean contains(Object paramObject)
    {
      return et.this.a(paramObject) >= 0;
    }
    
    public final boolean containsAll(Collection<?> paramCollection)
    {
      Map localMap = et.this.b();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!localMap.containsKey(paramCollection.next())) {
          return false;
        }
      }
      return true;
    }
    
    public final boolean equals(Object paramObject)
    {
      return et.a(this, paramObject);
    }
    
    public final int hashCode()
    {
      int i = et.this.a() - 1;
      int j = 0;
      while (i >= 0)
      {
        Object localObject = et.this.a(i, 0);
        int k;
        if (localObject == null) {
          k = 0;
        } else {
          k = localObject.hashCode();
        }
        j += k;
        i -= 1;
      }
      return j;
    }
    
    public final boolean isEmpty()
    {
      return et.this.a() == 0;
    }
    
    public final Iterator<K> iterator()
    {
      return new et.a(et.this, 0);
    }
    
    public final boolean remove(Object paramObject)
    {
      int i = et.this.a(paramObject);
      if (i >= 0)
      {
        et.this.a(i);
        return true;
      }
      return false;
    }
    
    public final boolean removeAll(Collection<?> paramCollection)
    {
      Map localMap = et.this.b();
      int i = localMap.size();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        localMap.remove(paramCollection.next());
      }
      return i != localMap.size();
    }
    
    public final boolean retainAll(Collection<?> paramCollection)
    {
      return et.a(et.this.b(), paramCollection);
    }
    
    public final int size()
    {
      return et.this.a();
    }
    
    public final Object[] toArray()
    {
      return et.this.b(0);
    }
    
    public final <T> T[] toArray(T[] paramArrayOfT)
    {
      return et.this.a(paramArrayOfT, 0);
    }
  }
  
  final class d
    implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
  {
    int a = et.this.a() - 1;
    int b = -1;
    boolean c = false;
    
    d() {}
    
    public final boolean equals(Object paramObject)
    {
      if (this.c)
      {
        if (!(paramObject instanceof Map.Entry)) {
          return false;
        }
        paramObject = (Map.Entry)paramObject;
        return (eo.a(paramObject.getKey(), et.this.a(this.b, 0))) && (eo.a(paramObject.getValue(), et.this.a(this.b, 1)));
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public final K getKey()
    {
      if (this.c) {
        return et.this.a(this.b, 0);
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public final V getValue()
    {
      if (this.c) {
        return et.this.a(this.b, 1);
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public final boolean hasNext()
    {
      return this.b < this.a;
    }
    
    public final int hashCode()
    {
      if (this.c)
      {
        Object localObject1 = et.this;
        int i = this.b;
        int j = 0;
        localObject1 = ((et)localObject1).a(i, 0);
        Object localObject2 = et.this.a(this.b, 1);
        if (localObject1 == null) {
          i = 0;
        } else {
          i = localObject1.hashCode();
        }
        if (localObject2 != null) {
          j = localObject2.hashCode();
        }
        return i ^ j;
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public final void remove()
    {
      if (this.c)
      {
        et.this.a(this.b);
        this.b -= 1;
        this.a -= 1;
        this.c = false;
        return;
      }
      throw new IllegalStateException();
    }
    
    public final V setValue(V paramV)
    {
      if (this.c) {
        return et.this.a(this.b, paramV);
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getKey());
      localStringBuilder.append("=");
      localStringBuilder.append(getValue());
      return localStringBuilder.toString();
    }
  }
  
  final class e
    implements Collection<V>
  {
    e() {}
    
    public final boolean add(V paramV)
    {
      throw new UnsupportedOperationException();
    }
    
    public final boolean addAll(Collection<? extends V> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public final void clear()
    {
      et.this.c();
    }
    
    public final boolean contains(Object paramObject)
    {
      return et.this.b(paramObject) >= 0;
    }
    
    public final boolean containsAll(Collection<?> paramCollection)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next())) {
          return false;
        }
      }
      return true;
    }
    
    public final boolean isEmpty()
    {
      return et.this.a() == 0;
    }
    
    public final Iterator<V> iterator()
    {
      return new et.a(et.this, 1);
    }
    
    public final boolean remove(Object paramObject)
    {
      int i = et.this.b(paramObject);
      if (i >= 0)
      {
        et.this.a(i);
        return true;
      }
      return false;
    }
    
    public final boolean removeAll(Collection<?> paramCollection)
    {
      int j = et.this.a();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        int k = j;
        int m = i;
        if (paramCollection.contains(et.this.a(i, 1)))
        {
          et.this.a(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        }
        i = m + 1;
        j = k;
      }
      return bool;
    }
    
    public final boolean retainAll(Collection<?> paramCollection)
    {
      int j = et.this.a();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        int k = j;
        int m = i;
        if (!paramCollection.contains(et.this.a(i, 1)))
        {
          et.this.a(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        }
        i = m + 1;
        j = k;
      }
      return bool;
    }
    
    public final int size()
    {
      return et.this.a();
    }
    
    public final Object[] toArray()
    {
      return et.this.b(1);
    }
    
    public final <T> T[] toArray(T[] paramArrayOfT)
    {
      return et.this.a(paramArrayOfT, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.et
 * JD-Core Version:    0.7.0.1
 */