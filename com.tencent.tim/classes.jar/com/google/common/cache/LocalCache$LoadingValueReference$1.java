package com.google.common.cache;

import com.google.common.base.Function;

class LocalCache$LoadingValueReference$1
  implements Function<V, V>
{
  LocalCache$LoadingValueReference$1(LocalCache.LoadingValueReference paramLoadingValueReference) {}
  
  public V apply(V paramV)
  {
    this.this$0.set(paramV);
    return paramV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.LocalCache.LoadingValueReference.1
 * JD-Core Version:    0.7.0.1
 */