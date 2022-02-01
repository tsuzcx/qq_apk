package com.google.common.collect;

import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.Map.Entry;

class LinkedListMultimap$1EntriesImpl
  extends AbstractSequentialList<Map.Entry<K, V>>
{
  LinkedListMultimap$1EntriesImpl(LinkedListMultimap paramLinkedListMultimap) {}
  
  public ListIterator<Map.Entry<K, V>> listIterator(int paramInt)
  {
    return new LinkedListMultimap.NodeIterator(this.this$0, paramInt);
  }
  
  public int size()
  {
    return LinkedListMultimap.access$900(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.LinkedListMultimap.1EntriesImpl
 * JD-Core Version:    0.7.0.1
 */