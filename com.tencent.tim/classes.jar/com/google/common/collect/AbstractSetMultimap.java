package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractSetMultimap<K, V>
  extends AbstractMapBasedMultimap<K, V>
  implements SetMultimap<K, V>
{
  private static final long serialVersionUID = 7431625294878419160L;
  
  protected AbstractSetMultimap(Map<K, Collection<V>> paramMap)
  {
    super(paramMap);
  }
  
  public Map<K, Collection<V>> asMap()
  {
    return super.asMap();
  }
  
  abstract Set<V> createCollection();
  
  Set<V> createUnmodifiableEmptyCollection()
  {
    return ImmutableSet.of();
  }
  
  public Set<Map.Entry<K, V>> entries()
  {
    return (Set)super.entries();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public Set<V> get(@Nullable K paramK)
  {
    return (Set)super.get(paramK);
  }
  
  @CanIgnoreReturnValue
  public boolean put(@Nullable K paramK, @Nullable V paramV)
  {
    return super.put(paramK, paramV);
  }
  
  @CanIgnoreReturnValue
  public Set<V> removeAll(@Nullable Object paramObject)
  {
    return (Set)super.removeAll(paramObject);
  }
  
  @CanIgnoreReturnValue
  public Set<V> replaceValues(@Nullable K paramK, Iterable<? extends V> paramIterable)
  {
    return (Set)super.replaceValues(paramK, paramIterable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.AbstractSetMultimap
 * JD-Core Version:    0.7.0.1
 */