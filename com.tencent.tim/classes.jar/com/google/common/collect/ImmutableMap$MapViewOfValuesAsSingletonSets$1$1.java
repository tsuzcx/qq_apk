package com.google.common.collect;

import java.util.Map.Entry;

class ImmutableMap$MapViewOfValuesAsSingletonSets$1$1
  extends AbstractMapEntry<K, ImmutableSet<V>>
{
  ImmutableMap$MapViewOfValuesAsSingletonSets$1$1(ImmutableMap.MapViewOfValuesAsSingletonSets.1 param1, Map.Entry paramEntry) {}
  
  public K getKey()
  {
    return this.val$backingEntry.getKey();
  }
  
  public ImmutableSet<V> getValue()
  {
    return ImmutableSet.of(this.val$backingEntry.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableMap.MapViewOfValuesAsSingletonSets.1.1
 * JD-Core Version:    0.7.0.1
 */