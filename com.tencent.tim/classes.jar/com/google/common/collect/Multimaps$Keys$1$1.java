package com.google.common.collect;

import java.util.Collection;
import java.util.Map.Entry;

class Multimaps$Keys$1$1
  extends Multisets.AbstractEntry<K>
{
  Multimaps$Keys$1$1(Multimaps.Keys.1 param1, Map.Entry paramEntry) {}
  
  public int getCount()
  {
    return ((Collection)this.val$backingEntry.getValue()).size();
  }
  
  public K getElement()
  {
    return this.val$backingEntry.getKey();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Multimaps.Keys.1.1
 * JD-Core Version:    0.7.0.1
 */