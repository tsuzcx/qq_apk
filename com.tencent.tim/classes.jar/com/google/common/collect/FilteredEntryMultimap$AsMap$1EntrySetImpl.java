package com.google.common.collect;

import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class FilteredEntryMultimap$AsMap$1EntrySetImpl
  extends Maps.EntrySet<K, Collection<V>>
{
  FilteredEntryMultimap$AsMap$1EntrySetImpl(FilteredEntryMultimap.AsMap paramAsMap) {}
  
  public Iterator<Map.Entry<K, Collection<V>>> iterator()
  {
    return new FilteredEntryMultimap.AsMap.1EntrySetImpl.1(this);
  }
  
  Map<K, Collection<V>> map()
  {
    return this.this$1;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return this.this$1.this$0.removeEntriesIf(Predicates.in(paramCollection));
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return this.this$1.this$0.removeEntriesIf(Predicates.not(Predicates.in(paramCollection)));
  }
  
  public int size()
  {
    return Iterators.size(iterator());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.FilteredEntryMultimap.AsMap.1EntrySetImpl
 * JD-Core Version:    0.7.0.1
 */