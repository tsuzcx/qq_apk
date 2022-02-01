package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSetMultimap<K, V>
  extends ForwardingMultimap<K, V>
  implements SetMultimap<K, V>
{
  protected abstract SetMultimap<K, V> delegate();
  
  public Set<Map.Entry<K, V>> entries()
  {
    return delegate().entries();
  }
  
  public Set<V> get(@Nullable K paramK)
  {
    return delegate().get(paramK);
  }
  
  @CanIgnoreReturnValue
  public Set<V> removeAll(@Nullable Object paramObject)
  {
    return delegate().removeAll(paramObject);
  }
  
  @CanIgnoreReturnValue
  public Set<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
  {
    return delegate().replaceValues(paramK, paramIterable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ForwardingSetMultimap
 * JD-Core Version:    0.7.0.1
 */