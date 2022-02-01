package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingObject;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

@GwtIncompatible
public abstract class ForwardingCache<K, V>
  extends ForwardingObject
  implements Cache<K, V>
{
  public ConcurrentMap<K, V> asMap()
  {
    return delegate().asMap();
  }
  
  public void cleanUp()
  {
    delegate().cleanUp();
  }
  
  protected abstract Cache<K, V> delegate();
  
  public V get(K paramK, Callable<? extends V> paramCallable)
    throws ExecutionException
  {
    return delegate().get(paramK, paramCallable);
  }
  
  public ImmutableMap<K, V> getAllPresent(Iterable<?> paramIterable)
  {
    return delegate().getAllPresent(paramIterable);
  }
  
  @Nullable
  public V getIfPresent(Object paramObject)
  {
    return delegate().getIfPresent(paramObject);
  }
  
  public void invalidate(Object paramObject)
  {
    delegate().invalidate(paramObject);
  }
  
  public void invalidateAll()
  {
    delegate().invalidateAll();
  }
  
  public void invalidateAll(Iterable<?> paramIterable)
  {
    delegate().invalidateAll(paramIterable);
  }
  
  public void put(K paramK, V paramV)
  {
    delegate().put(paramK, paramV);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    delegate().putAll(paramMap);
  }
  
  public long size()
  {
    return delegate().size();
  }
  
  public CacheStats stats()
  {
    return delegate().stats();
  }
  
  public static abstract class SimpleForwardingCache<K, V>
    extends ForwardingCache<K, V>
  {
    private final Cache<K, V> delegate;
    
    protected SimpleForwardingCache(Cache<K, V> paramCache)
    {
      this.delegate = ((Cache)Preconditions.checkNotNull(paramCache));
    }
    
    protected final Cache<K, V> delegate()
    {
      return this.delegate;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.ForwardingCache
 * JD-Core Version:    0.7.0.1
 */