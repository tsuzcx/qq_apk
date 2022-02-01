package com.google.common.collect;

import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class FilteredEntryMultimap$AsMap$1ValuesImpl
  extends Maps.Values<K, Collection<V>>
{
  FilteredEntryMultimap$AsMap$1ValuesImpl(FilteredEntryMultimap.AsMap paramAsMap)
  {
    super(paramAsMap);
  }
  
  public boolean remove(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Collection))
    {
      paramObject = (Collection)paramObject;
      Iterator localIterator = this.this$1.this$0.unfiltered.asMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Object localObject = localEntry.getKey();
        localObject = FilteredEntryMultimap.filterCollection((Collection)localEntry.getValue(), new FilteredEntryMultimap.ValuePredicate(this.this$1.this$0, localObject));
        if ((!((Collection)localObject).isEmpty()) && (paramObject.equals(localObject)))
        {
          if (((Collection)localObject).size() == ((Collection)localEntry.getValue()).size()) {
            localIterator.remove();
          }
          for (;;)
          {
            return true;
            ((Collection)localObject).clear();
          }
        }
      }
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return this.this$1.this$0.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.in(paramCollection)));
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return this.this$1.this$0.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(paramCollection))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.FilteredEntryMultimap.AsMap.1ValuesImpl
 * JD-Core Version:    0.7.0.1
 */