package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class MapConstraints$ConstrainedEntries$1
  extends TransformedIterator<Map.Entry<K, V>, Map.Entry<K, V>>
{
  MapConstraints$ConstrainedEntries$1(MapConstraints.ConstrainedEntries paramConstrainedEntries, Iterator paramIterator)
  {
    super(paramIterator);
  }
  
  Map.Entry<K, V> transform(Map.Entry<K, V> paramEntry)
  {
    return MapConstraints.access$500(paramEntry, this.this$0.constraint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MapConstraints.ConstrainedEntries.1
 * JD-Core Version:    0.7.0.1
 */