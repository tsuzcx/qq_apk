package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class WellBehavedMap$EntrySet$1
  extends TransformedIterator<K, Map.Entry<K, V>>
{
  WellBehavedMap$EntrySet$1(WellBehavedMap.EntrySet paramEntrySet, Iterator paramIterator)
  {
    super(paramIterator);
  }
  
  Map.Entry<K, V> transform(K paramK)
  {
    return new WellBehavedMap.EntrySet.1.1(this, paramK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.WellBehavedMap.EntrySet.1
 * JD-Core Version:    0.7.0.1
 */