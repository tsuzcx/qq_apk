package com.google.common.collect;

import java.util.AbstractSequentialList;
import java.util.ListIterator;

class LinkedListMultimap$1ValuesImpl
  extends AbstractSequentialList<V>
{
  LinkedListMultimap$1ValuesImpl(LinkedListMultimap paramLinkedListMultimap) {}
  
  public ListIterator<V> listIterator(int paramInt)
  {
    LinkedListMultimap.NodeIterator localNodeIterator = new LinkedListMultimap.NodeIterator(this.this$0, paramInt);
    return new LinkedListMultimap.1ValuesImpl.1(this, localNodeIterator, localNodeIterator);
  }
  
  public int size()
  {
    return LinkedListMultimap.access$900(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.LinkedListMultimap.1ValuesImpl
 * JD-Core Version:    0.7.0.1
 */