package com.google.common.collect;

import java.util.Map.Entry;

class ImmutableMap$IteratorBasedImmutableMap$1EntrySetImpl
  extends ImmutableMapEntrySet<K, V>
{
  ImmutableMap$IteratorBasedImmutableMap$1EntrySetImpl(ImmutableMap.IteratorBasedImmutableMap paramIteratorBasedImmutableMap) {}
  
  public UnmodifiableIterator<Map.Entry<K, V>> iterator()
  {
    return this.this$0.entryIterator();
  }
  
  ImmutableMap<K, V> map()
  {
    return this.this$0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.1EntrySetImpl
 * JD-Core Version:    0.7.0.1
 */