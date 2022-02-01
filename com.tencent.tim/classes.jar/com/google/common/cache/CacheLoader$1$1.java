package com.google.common.cache;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

class CacheLoader$1$1
  implements Callable<V>
{
  CacheLoader$1$1(CacheLoader.1 param1, Object paramObject1, Object paramObject2) {}
  
  public V call()
    throws Exception
  {
    return this.this$0.val$loader.reload(this.val$key, this.val$oldValue).get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.CacheLoader.1.1
 * JD-Core Version:    0.7.0.1
 */