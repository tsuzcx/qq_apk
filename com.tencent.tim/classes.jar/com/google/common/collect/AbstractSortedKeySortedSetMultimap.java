package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
abstract class AbstractSortedKeySortedSetMultimap<K, V>
  extends AbstractSortedSetMultimap<K, V>
{
  AbstractSortedKeySortedSetMultimap(SortedMap<K, Collection<V>> paramSortedMap)
  {
    super(paramSortedMap);
  }
  
  public SortedMap<K, Collection<V>> asMap()
  {
    return (SortedMap)super.asMap();
  }
  
  SortedMap<K, Collection<V>> backingMap()
  {
    return (SortedMap)super.backingMap();
  }
  
  public SortedSet<K> keySet()
  {
    return (SortedSet)super.keySet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.AbstractSortedKeySortedSetMultimap
 * JD-Core Version:    0.7.0.1
 */