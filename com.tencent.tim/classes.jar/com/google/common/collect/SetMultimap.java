package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract interface SetMultimap<K, V>
  extends Multimap<K, V>
{
  public abstract Map<K, Collection<V>> asMap();
  
  public abstract Set<Map.Entry<K, V>> entries();
  
  public abstract boolean equals(@Nullable Object paramObject);
  
  public abstract Set<V> get(@Nullable K paramK);
  
  @CanIgnoreReturnValue
  public abstract Set<V> removeAll(@Nullable Object paramObject);
  
  @CanIgnoreReturnValue
  public abstract Set<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.SetMultimap
 * JD-Core Version:    0.7.0.1
 */