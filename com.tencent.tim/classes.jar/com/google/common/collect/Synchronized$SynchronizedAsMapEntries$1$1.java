package com.google.common.collect;

import java.util.Collection;
import java.util.Map.Entry;

class Synchronized$SynchronizedAsMapEntries$1$1
  extends ForwardingMapEntry<K, Collection<V>>
{
  Synchronized$SynchronizedAsMapEntries$1$1(Synchronized.SynchronizedAsMapEntries.1 param1, Map.Entry paramEntry) {}
  
  protected Map.Entry<K, Collection<V>> delegate()
  {
    return this.val$entry;
  }
  
  public Collection<V> getValue()
  {
    return Synchronized.access$400((Collection)this.val$entry.getValue(), this.this$1.this$0.mutex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedAsMapEntries.1.1
 * JD-Core Version:    0.7.0.1
 */