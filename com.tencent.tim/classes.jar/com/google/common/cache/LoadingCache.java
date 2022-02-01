package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@GwtCompatible
public abstract interface LoadingCache<K, V>
  extends Function<K, V>, Cache<K, V>
{
  @Deprecated
  public abstract V apply(K paramK);
  
  public abstract ConcurrentMap<K, V> asMap();
  
  public abstract V get(K paramK)
    throws ExecutionException;
  
  public abstract ImmutableMap<K, V> getAll(Iterable<? extends K> paramIterable)
    throws ExecutionException;
  
  public abstract V getUnchecked(K paramK);
  
  public abstract void refresh(K paramK);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.LoadingCache
 * JD-Core Version:    0.7.0.1
 */