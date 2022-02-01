package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class Maps$FilteredEntryMap$EntrySet$1
  extends TransformedIterator<Map.Entry<K, V>, Map.Entry<K, V>>
{
  Maps$FilteredEntryMap$EntrySet$1(Maps.FilteredEntryMap.EntrySet paramEntrySet, Iterator paramIterator)
  {
    super(paramIterator);
  }
  
  Map.Entry<K, V> transform(Map.Entry<K, V> paramEntry)
  {
    return new Maps.FilteredEntryMap.EntrySet.1.1(this, paramEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Maps.FilteredEntryMap.EntrySet.1
 * JD-Core Version:    0.7.0.1
 */