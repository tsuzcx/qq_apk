package com.google.common.collect;

import com.google.common.base.Predicates;
import java.util.Collection;
import javax.annotation.Nullable;

class FilteredEntryMultimap$AsMap$1KeySetImpl
  extends Maps.KeySet<K, Collection<V>>
{
  FilteredEntryMultimap$AsMap$1KeySetImpl(FilteredEntryMultimap.AsMap paramAsMap)
  {
    super(paramAsMap);
  }
  
  public boolean remove(@Nullable Object paramObject)
  {
    return this.this$1.remove(paramObject) != null;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return this.this$1.this$0.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.in(paramCollection)));
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return this.this$1.this$0.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(paramCollection))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.FilteredEntryMultimap.AsMap.1KeySetImpl
 * JD-Core Version:    0.7.0.1
 */