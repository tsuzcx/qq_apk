package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Map.Entry;

class FilteredEntryMultimap$Keys$1$1
  implements Predicate<Map.Entry<K, Collection<V>>>
{
  FilteredEntryMultimap$Keys$1$1(FilteredEntryMultimap.Keys.1 param1, Predicate paramPredicate) {}
  
  public boolean apply(Map.Entry<K, Collection<V>> paramEntry)
  {
    return this.val$predicate.apply(Multisets.immutableEntry(paramEntry.getKey(), ((Collection)paramEntry.getValue()).size()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.FilteredEntryMultimap.Keys.1.1
 * JD-Core Version:    0.7.0.1
 */