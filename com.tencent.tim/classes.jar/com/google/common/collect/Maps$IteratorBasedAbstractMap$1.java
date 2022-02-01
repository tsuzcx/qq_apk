package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class Maps$IteratorBasedAbstractMap$1
  extends Maps.EntrySet<K, V>
{
  Maps$IteratorBasedAbstractMap$1(Maps.IteratorBasedAbstractMap paramIteratorBasedAbstractMap) {}
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return this.this$0.entryIterator();
  }
  
  Map<K, V> map()
  {
    return this.this$0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Maps.IteratorBasedAbstractMap.1
 * JD-Core Version:    0.7.0.1
 */