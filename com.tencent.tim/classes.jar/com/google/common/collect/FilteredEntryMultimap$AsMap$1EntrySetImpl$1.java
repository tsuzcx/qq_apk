package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class FilteredEntryMultimap$AsMap$1EntrySetImpl$1
  extends AbstractIterator<Map.Entry<K, Collection<V>>>
{
  final Iterator<Map.Entry<K, Collection<V>>> backingIterator = this.this$2.this$1.this$0.unfiltered.asMap().entrySet().iterator();
  
  FilteredEntryMultimap$AsMap$1EntrySetImpl$1(FilteredEntryMultimap.AsMap.1EntrySetImpl param1EntrySetImpl) {}
  
  protected Map.Entry<K, Collection<V>> computeNext()
  {
    while (this.backingIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)this.backingIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = FilteredEntryMultimap.filterCollection((Collection)((Map.Entry)localObject2).getValue(), new FilteredEntryMultimap.ValuePredicate(this.this$2.this$1.this$0, localObject1));
      if (!((Collection)localObject2).isEmpty()) {
        return Maps.immutableEntry(localObject1, localObject2);
      }
    }
    return (Map.Entry)endOfData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.FilteredEntryMultimap.AsMap.1EntrySetImpl.1
 * JD-Core Version:    0.7.0.1
 */