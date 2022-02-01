package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractSortedSetMultimap<K, V>
  extends AbstractSetMultimap<K, V>
  implements SortedSetMultimap<K, V>
{
  private static final long serialVersionUID = 430848587173315748L;
  
  protected AbstractSortedSetMultimap(Map<K, Collection<V>> paramMap)
  {
    super(paramMap);
  }
  
  public Map<K, Collection<V>> asMap()
  {
    return super.asMap();
  }
  
  abstract SortedSet<V> createCollection();
  
  SortedSet<V> createUnmodifiableEmptyCollection()
  {
    if (valueComparator() == null) {
      return Collections.unmodifiableSortedSet(createCollection());
    }
    return ImmutableSortedSet.emptySet(valueComparator());
  }
  
  public SortedSet<V> get(@Nullable K paramK)
  {
    return (SortedSet)super.get(paramK);
  }
  
  @CanIgnoreReturnValue
  public SortedSet<V> removeAll(@Nullable Object paramObject)
  {
    return (SortedSet)super.removeAll(paramObject);
  }
  
  @CanIgnoreReturnValue
  public SortedSet<V> replaceValues(@Nullable K paramK, Iterable<? extends V> paramIterable)
  {
    return (SortedSet)super.replaceValues(paramK, paramIterable);
  }
  
  public Collection<V> values()
  {
    return super.values();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.AbstractSortedSetMultimap
 * JD-Core Version:    0.7.0.1
 */