package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentMap;

@GwtCompatible
public abstract class ForwardingConcurrentMap<K, V>
  extends ForwardingMap<K, V>
  implements ConcurrentMap<K, V>
{
  protected abstract ConcurrentMap<K, V> delegate();
  
  @CanIgnoreReturnValue
  public V putIfAbsent(K paramK, V paramV)
  {
    return delegate().putIfAbsent(paramK, paramV);
  }
  
  @CanIgnoreReturnValue
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    return delegate().remove(paramObject1, paramObject2);
  }
  
  @CanIgnoreReturnValue
  public V replace(K paramK, V paramV)
  {
    return delegate().replace(paramK, paramV);
  }
  
  @CanIgnoreReturnValue
  public boolean replace(K paramK, V paramV1, V paramV2)
  {
    return delegate().replace(paramK, paramV1, paramV2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ForwardingConcurrentMap
 * JD-Core Version:    0.7.0.1
 */