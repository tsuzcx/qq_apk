package com.google.common.collect;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

class LinkedListMultimap$1KeySetImpl
  extends Sets.ImprovedAbstractSet<K>
{
  LinkedListMultimap$1KeySetImpl(LinkedListMultimap paramLinkedListMultimap) {}
  
  public boolean contains(Object paramObject)
  {
    return this.this$0.containsKey(paramObject);
  }
  
  public Iterator<K> iterator()
  {
    return new LinkedListMultimap.DistinctKeyIterator(this.this$0, null);
  }
  
  public boolean remove(Object paramObject)
  {
    return !this.this$0.removeAll(paramObject).isEmpty();
  }
  
  public int size()
  {
    return LinkedListMultimap.access$600(this.this$0).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.LinkedListMultimap.1KeySetImpl
 * JD-Core Version:    0.7.0.1
 */