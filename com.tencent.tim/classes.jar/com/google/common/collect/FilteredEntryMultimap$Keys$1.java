package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class FilteredEntryMultimap$Keys$1
  extends Multisets.EntrySet<K>
{
  FilteredEntryMultimap$Keys$1(FilteredEntryMultimap.Keys paramKeys) {}
  
  private boolean removeEntriesIf(Predicate<? super Multiset.Entry<K>> paramPredicate)
  {
    return this.this$1.this$0.removeEntriesIf(new FilteredEntryMultimap.Keys.1.1(this, paramPredicate));
  }
  
  public Iterator<Multiset.Entry<K>> iterator()
  {
    return this.this$1.entryIterator();
  }
  
  Multiset<K> multiset()
  {
    return this.this$1;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return removeEntriesIf(Predicates.in(paramCollection));
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return removeEntriesIf(Predicates.not(Predicates.in(paramCollection)));
  }
  
  public int size()
  {
    return this.this$1.this$0.keySet().size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.FilteredEntryMultimap.Keys.1
 * JD-Core Version:    0.7.0.1
 */