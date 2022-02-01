package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@GwtCompatible
public final class AtomicLongMap<K>
{
  private transient Map<K, Long> asMap;
  private final ConcurrentHashMap<K, AtomicLong> map;
  
  private AtomicLongMap(ConcurrentHashMap<K, AtomicLong> paramConcurrentHashMap)
  {
    this.map = ((ConcurrentHashMap)Preconditions.checkNotNull(paramConcurrentHashMap));
  }
  
  public static <K> AtomicLongMap<K> create()
  {
    return new AtomicLongMap(new ConcurrentHashMap());
  }
  
  public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> paramMap)
  {
    AtomicLongMap localAtomicLongMap = create();
    localAtomicLongMap.putAll(paramMap);
    return localAtomicLongMap;
  }
  
  private Map<K, Long> createAsMap()
  {
    return Collections.unmodifiableMap(Maps.transformValues(this.map, new AtomicLongMap.1(this)));
  }
  
  @CanIgnoreReturnValue
  public long addAndGet(K paramK, long paramLong)
  {
    AtomicLong localAtomicLong2 = (AtomicLong)this.map.get(paramK);
    AtomicLong localAtomicLong1 = localAtomicLong2;
    if (localAtomicLong2 == null)
    {
      localAtomicLong2 = (AtomicLong)this.map.putIfAbsent(paramK, new AtomicLong(paramLong));
      localAtomicLong1 = localAtomicLong2;
      if (localAtomicLong2 == null) {
        return paramLong;
      }
    }
    long l1;
    long l2;
    do
    {
      l1 = localAtomicLong1.get();
      if (l1 == 0L)
      {
        if (!this.map.replace(paramK, localAtomicLong1, new AtomicLong(paramLong))) {
          break;
        }
        return paramLong;
      }
      l2 = l1 + paramLong;
    } while (!localAtomicLong1.compareAndSet(l1, l2));
    return l2;
  }
  
  public Map<K, Long> asMap()
  {
    Map localMap2 = this.asMap;
    Map localMap1 = localMap2;
    if (localMap2 == null)
    {
      localMap1 = createAsMap();
      this.asMap = localMap1;
    }
    return localMap1;
  }
  
  public void clear()
  {
    this.map.clear();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.map.containsKey(paramObject);
  }
  
  @CanIgnoreReturnValue
  public long decrementAndGet(K paramK)
  {
    return addAndGet(paramK, -1L);
  }
  
  public long get(K paramK)
  {
    paramK = (AtomicLong)this.map.get(paramK);
    if (paramK == null) {
      return 0L;
    }
    return paramK.get();
  }
  
  @CanIgnoreReturnValue
  public long getAndAdd(K paramK, long paramLong)
  {
    AtomicLong localAtomicLong2 = (AtomicLong)this.map.get(paramK);
    AtomicLong localAtomicLong1 = localAtomicLong2;
    if (localAtomicLong2 == null)
    {
      localAtomicLong2 = (AtomicLong)this.map.putIfAbsent(paramK, new AtomicLong(paramLong));
      localAtomicLong1 = localAtomicLong2;
      if (localAtomicLong2 == null) {
        return 0L;
      }
    }
    long l;
    do
    {
      l = localAtomicLong1.get();
      if (l == 0L)
      {
        if (!this.map.replace(paramK, localAtomicLong1, new AtomicLong(paramLong))) {
          break;
        }
        return 0L;
      }
    } while (!localAtomicLong1.compareAndSet(l, l + paramLong));
    return l;
  }
  
  @CanIgnoreReturnValue
  public long getAndDecrement(K paramK)
  {
    return getAndAdd(paramK, -1L);
  }
  
  @CanIgnoreReturnValue
  public long getAndIncrement(K paramK)
  {
    return getAndAdd(paramK, 1L);
  }
  
  @CanIgnoreReturnValue
  public long incrementAndGet(K paramK)
  {
    return addAndGet(paramK, 1L);
  }
  
  public boolean isEmpty()
  {
    return this.map.isEmpty();
  }
  
  @CanIgnoreReturnValue
  public long put(K paramK, long paramLong)
  {
    AtomicLong localAtomicLong2 = (AtomicLong)this.map.get(paramK);
    AtomicLong localAtomicLong1 = localAtomicLong2;
    if (localAtomicLong2 == null)
    {
      localAtomicLong2 = (AtomicLong)this.map.putIfAbsent(paramK, new AtomicLong(paramLong));
      localAtomicLong1 = localAtomicLong2;
      if (localAtomicLong2 == null) {
        return 0L;
      }
    }
    long l;
    do
    {
      l = localAtomicLong1.get();
      if (l == 0L)
      {
        if (!this.map.replace(paramK, localAtomicLong1, new AtomicLong(paramLong))) {
          break;
        }
        return 0L;
      }
    } while (!localAtomicLong1.compareAndSet(l, paramLong));
    return l;
  }
  
  public void putAll(Map<? extends K, ? extends Long> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
    }
  }
  
  long putIfAbsent(K paramK, long paramLong)
  {
    AtomicLong localAtomicLong1;
    long l;
    do
    {
      AtomicLong localAtomicLong2 = (AtomicLong)this.map.get(paramK);
      localAtomicLong1 = localAtomicLong2;
      if (localAtomicLong2 == null)
      {
        localAtomicLong2 = (AtomicLong)this.map.putIfAbsent(paramK, new AtomicLong(paramLong));
        localAtomicLong1 = localAtomicLong2;
        if (localAtomicLong2 == null) {
          return 0L;
        }
      }
      l = localAtomicLong1.get();
      if (l != 0L) {
        break;
      }
    } while (!this.map.replace(paramK, localAtomicLong1, new AtomicLong(paramLong)));
    return 0L;
    return l;
  }
  
  @CanIgnoreReturnValue
  public long remove(K paramK)
  {
    AtomicLong localAtomicLong = (AtomicLong)this.map.get(paramK);
    if (localAtomicLong == null) {
      return 0L;
    }
    long l;
    do
    {
      l = localAtomicLong.get();
    } while ((l != 0L) && (!localAtomicLong.compareAndSet(l, 0L)));
    this.map.remove(paramK, localAtomicLong);
    return l;
  }
  
  boolean remove(K paramK, long paramLong)
  {
    AtomicLong localAtomicLong = (AtomicLong)this.map.get(paramK);
    if (localAtomicLong == null) {
      return false;
    }
    long l = localAtomicLong.get();
    if (l != paramLong) {
      return false;
    }
    if ((l == 0L) || (localAtomicLong.compareAndSet(l, 0L)))
    {
      this.map.remove(paramK, localAtomicLong);
      return true;
    }
    return false;
  }
  
  public void removeAllZeros()
  {
    Iterator localIterator = this.map.entrySet().iterator();
    while (localIterator.hasNext())
    {
      AtomicLong localAtomicLong = (AtomicLong)((Map.Entry)localIterator.next()).getValue();
      if ((localAtomicLong != null) && (localAtomicLong.get() == 0L)) {
        localIterator.remove();
      }
    }
  }
  
  @Beta
  @CanIgnoreReturnValue
  public boolean removeIfZero(K paramK)
  {
    return remove(paramK, 0L);
  }
  
  boolean replace(K paramK, long paramLong1, long paramLong2)
  {
    boolean bool = false;
    if (paramLong1 == 0L) {
      return putIfAbsent(paramK, paramLong2) == 0L;
    }
    paramK = (AtomicLong)this.map.get(paramK);
    if (paramK == null) {}
    for (;;)
    {
      return bool;
      bool = paramK.compareAndSet(paramLong1, paramLong2);
    }
  }
  
  public int size()
  {
    return this.map.size();
  }
  
  public long sum()
  {
    Iterator localIterator = this.map.values().iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((AtomicLong)localIterator.next()).get() + l) {}
    return l;
  }
  
  public String toString()
  {
    return this.map.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AtomicLongMap
 * JD-Core Version:    0.7.0.1
 */