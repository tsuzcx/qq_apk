package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingListMultimap<K, V>
  extends ForwardingMultimap<K, V>
  implements ListMultimap<K, V>
{
  protected abstract ListMultimap<K, V> delegate();
  
  public List<V> get(@Nullable K paramK)
  {
    return delegate().get(paramK);
  }
  
  @CanIgnoreReturnValue
  public List<V> removeAll(@Nullable Object paramObject)
  {
    return delegate().removeAll(paramObject);
  }
  
  @CanIgnoreReturnValue
  public List<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
  {
    return delegate().replaceValues(paramK, paramIterable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ForwardingListMultimap
 * JD-Core Version:    0.7.0.1
 */