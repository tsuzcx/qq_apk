package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class MapConstraints$ConstrainedAsMapEntries$1
  extends TransformedIterator<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>>
{
  MapConstraints$ConstrainedAsMapEntries$1(MapConstraints.ConstrainedAsMapEntries paramConstrainedAsMapEntries, Iterator paramIterator)
  {
    super(paramIterator);
  }
  
  Map.Entry<K, Collection<V>> transform(Map.Entry<K, Collection<V>> paramEntry)
  {
    return MapConstraints.access$700(paramEntry, MapConstraints.ConstrainedAsMapEntries.access$600(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MapConstraints.ConstrainedAsMapEntries.1
 * JD-Core Version:    0.7.0.1
 */