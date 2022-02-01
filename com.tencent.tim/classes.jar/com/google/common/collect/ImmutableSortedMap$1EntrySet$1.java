package com.google.common.collect;

import java.util.Map.Entry;

class ImmutableSortedMap$1EntrySet$1
  extends ImmutableAsList<Map.Entry<K, V>>
{
  ImmutableSortedMap$1EntrySet$1(ImmutableSortedMap.1EntrySet param1EntrySet) {}
  
  ImmutableCollection<Map.Entry<K, V>> delegateCollection()
  {
    return this.this$1;
  }
  
  public Map.Entry<K, V> get(int paramInt)
  {
    return Maps.immutableEntry(ImmutableSortedMap.access$200(this.this$1.this$0).asList().get(paramInt), ImmutableSortedMap.access$300(this.this$1.this$0).get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap.1EntrySet.1
 * JD-Core Version:    0.7.0.1
 */