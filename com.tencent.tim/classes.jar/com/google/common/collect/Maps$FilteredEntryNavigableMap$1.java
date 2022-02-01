package com.google.common.collect;

import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.NavigableMap;
import java.util.Set;

class Maps$FilteredEntryNavigableMap$1
  extends Maps.NavigableKeySet<K, V>
{
  Maps$FilteredEntryNavigableMap$1(Maps.FilteredEntryNavigableMap paramFilteredEntryNavigableMap, NavigableMap paramNavigableMap)
  {
    super(paramNavigableMap);
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return Iterators.removeIf(Maps.FilteredEntryNavigableMap.access$700(this.this$0).entrySet().iterator(), Predicates.and(Maps.FilteredEntryNavigableMap.access$600(this.this$0), Maps.keyPredicateOnEntries(Predicates.in(paramCollection))));
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return Iterators.removeIf(Maps.FilteredEntryNavigableMap.access$700(this.this$0).entrySet().iterator(), Predicates.and(Maps.FilteredEntryNavigableMap.access$600(this.this$0), Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(paramCollection)))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Maps.FilteredEntryNavigableMap.1
 * JD-Core Version:    0.7.0.1
 */