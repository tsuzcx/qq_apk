package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class ImmutableMap$MapViewOfValuesAsSingletonSets$1
  extends UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>>
{
  ImmutableMap$MapViewOfValuesAsSingletonSets$1(ImmutableMap.MapViewOfValuesAsSingletonSets paramMapViewOfValuesAsSingletonSets, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return this.val$backingIterator.hasNext();
  }
  
  public Map.Entry<K, ImmutableSet<V>> next()
  {
    return new ImmutableMap.MapViewOfValuesAsSingletonSets.1.1(this, (Map.Entry)this.val$backingIterator.next());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableMap.MapViewOfValuesAsSingletonSets.1
 * JD-Core Version:    0.7.0.1
 */