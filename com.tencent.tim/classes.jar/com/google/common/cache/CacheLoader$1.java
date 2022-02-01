package com.google.common.cache;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.Map;
import java.util.concurrent.Executor;

final class CacheLoader$1
  extends CacheLoader<K, V>
{
  CacheLoader$1(CacheLoader paramCacheLoader, Executor paramExecutor) {}
  
  public V load(K paramK)
    throws Exception
  {
    return this.val$loader.load(paramK);
  }
  
  public Map<K, V> loadAll(Iterable<? extends K> paramIterable)
    throws Exception
  {
    return this.val$loader.loadAll(paramIterable);
  }
  
  public ListenableFuture<V> reload(K paramK, V paramV)
    throws Exception
  {
    paramK = ListenableFutureTask.create(new CacheLoader.1.1(this, paramK, paramV));
    this.val$executor.execute(paramK);
    return paramK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.CacheLoader.1
 * JD-Core Version:    0.7.0.1
 */