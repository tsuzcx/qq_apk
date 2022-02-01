package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
public abstract interface ListMultimap<K, V>
  extends Multimap<K, V>
{
  public abstract Map<K, Collection<V>> asMap();
  
  public abstract boolean equals(@Nullable Object paramObject);
  
  public abstract List<V> get(@Nullable K paramK);
  
  @CanIgnoreReturnValue
  public abstract List<V> removeAll(@Nullable Object paramObject);
  
  @CanIgnoreReturnValue
  public abstract List<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ListMultimap
 * JD-Core Version:    0.7.0.1
 */