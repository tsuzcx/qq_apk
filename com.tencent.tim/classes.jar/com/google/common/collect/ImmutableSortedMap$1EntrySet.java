package com.google.common.collect;

import java.util.Map.Entry;

class ImmutableSortedMap$1EntrySet
  extends ImmutableMapEntrySet<K, V>
{
  ImmutableSortedMap$1EntrySet(ImmutableSortedMap paramImmutableSortedMap) {}
  
  ImmutableList<Map.Entry<K, V>> createAsList()
  {
    return new ImmutableSortedMap.1EntrySet.1(this);
  }
  
  public UnmodifiableIterator<Map.Entry<K, V>> iterator()
  {
    return asList().iterator();
  }
  
  ImmutableMap<K, V> map()
  {
    return this.this$0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap.1EntrySet
 * JD-Core Version:    0.7.0.1
 */