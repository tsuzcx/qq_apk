package com.google.common.collect;

import java.util.ListIterator;
import java.util.Map.Entry;

class LinkedListMultimap$1ValuesImpl$1
  extends TransformedListIterator<Map.Entry<K, V>, V>
{
  LinkedListMultimap$1ValuesImpl$1(LinkedListMultimap.1ValuesImpl param1ValuesImpl, ListIterator paramListIterator, LinkedListMultimap.NodeIterator paramNodeIterator)
  {
    super(paramListIterator);
  }
  
  public void set(V paramV)
  {
    this.val$nodeItr.setValue(paramV);
  }
  
  V transform(Map.Entry<K, V> paramEntry)
  {
    return paramEntry.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.LinkedListMultimap.1ValuesImpl.1
 * JD-Core Version:    0.7.0.1
 */