package com.google.common.collect;

import java.util.Map.Entry;

class ImmutableMap$1
  extends UnmodifiableIterator<K>
{
  ImmutableMap$1(ImmutableMap paramImmutableMap, UnmodifiableIterator paramUnmodifiableIterator) {}
  
  public boolean hasNext()
  {
    return this.val$entryIterator.hasNext();
  }
  
  public K next()
  {
    return ((Map.Entry)this.val$entryIterator.next()).getKey();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableMap.1
 * JD-Core Version:    0.7.0.1
 */