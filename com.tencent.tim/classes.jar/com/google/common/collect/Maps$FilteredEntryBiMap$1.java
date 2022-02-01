package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Map.Entry;

final class Maps$FilteredEntryBiMap$1
  implements Predicate<Map.Entry<V, K>>
{
  Maps$FilteredEntryBiMap$1(Predicate paramPredicate) {}
  
  public boolean apply(Map.Entry<V, K> paramEntry)
  {
    return this.val$forwardPredicate.apply(Maps.immutableEntry(paramEntry.getValue(), paramEntry.getKey()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Maps.FilteredEntryBiMap.1
 * JD-Core Version:    0.7.0.1
 */