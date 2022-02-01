package com.google.common.collect;

import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2
  extends Maps.EntrySet<Range<K>, V>
{
  TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2(TreeRangeMap.SubRangeMap.SubRangeMapAsMap paramSubRangeMapAsMap) {}
  
  public boolean isEmpty()
  {
    return !iterator().hasNext();
  }
  
  public Iterator<Map.Entry<Range<K>, V>> iterator()
  {
    return this.this$2.entryIterator();
  }
  
  Map<Range<K>, V> map()
  {
    return this.this$2;
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.access$300(this.this$2, Predicates.not(Predicates.in(paramCollection)));
  }
  
  public int size()
  {
    return Iterators.size(iterator());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.2
 * JD-Core Version:    0.7.0.1
 */