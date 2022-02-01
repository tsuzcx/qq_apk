package com.google.common.cache;

import java.util.concurrent.Callable;

class LocalCache$LocalManualCache$1
  extends CacheLoader<Object, V>
{
  LocalCache$LocalManualCache$1(LocalCache.LocalManualCache paramLocalManualCache, Callable paramCallable) {}
  
  public V load(Object paramObject)
    throws Exception
  {
    return this.val$valueLoader.call();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.LocalCache.LocalManualCache.1
 * JD-Core Version:    0.7.0.1
 */