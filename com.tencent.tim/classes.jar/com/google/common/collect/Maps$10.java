package com.google.common.collect;

import java.util.Map.Entry;

final class Maps$10
  extends AbstractMapEntry<K, V2>
{
  Maps$10(Map.Entry paramEntry, Maps.EntryTransformer paramEntryTransformer) {}
  
  public K getKey()
  {
    return this.val$entry.getKey();
  }
  
  public V2 getValue()
  {
    return this.val$transformer.transformEntry(this.val$entry.getKey(), this.val$entry.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Maps.10
 * JD-Core Version:    0.7.0.1
 */