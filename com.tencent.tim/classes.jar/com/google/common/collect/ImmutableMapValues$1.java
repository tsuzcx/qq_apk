package com.google.common.collect;

import java.util.Map.Entry;

class ImmutableMapValues$1
  extends UnmodifiableIterator<V>
{
  final UnmodifiableIterator<Map.Entry<K, V>> entryItr = ImmutableMapValues.access$000(this.this$0).entrySet().iterator();
  
  ImmutableMapValues$1(ImmutableMapValues paramImmutableMapValues) {}
  
  public boolean hasNext()
  {
    return this.entryItr.hasNext();
  }
  
  public V next()
  {
    return ((Map.Entry)this.entryItr.next()).getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableMapValues.1
 * JD-Core Version:    0.7.0.1
 */