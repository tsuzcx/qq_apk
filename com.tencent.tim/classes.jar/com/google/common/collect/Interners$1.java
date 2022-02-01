package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.concurrent.ConcurrentMap;

final class Interners$1
  implements Interner<E>
{
  Interners$1(ConcurrentMap paramConcurrentMap) {}
  
  public E intern(E paramE)
  {
    Object localObject = this.val$map.putIfAbsent(Preconditions.checkNotNull(paramE), paramE);
    if (localObject == null) {
      return paramE;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Interners.1
 * JD-Core Version:    0.7.0.1
 */