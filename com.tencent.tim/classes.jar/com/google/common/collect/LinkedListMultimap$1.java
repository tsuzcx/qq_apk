package com.google.common.collect;

import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.Map;

class LinkedListMultimap$1
  extends AbstractSequentialList<V>
{
  LinkedListMultimap$1(LinkedListMultimap paramLinkedListMultimap, Object paramObject) {}
  
  public ListIterator<V> listIterator(int paramInt)
  {
    return new LinkedListMultimap.ValueForKeyIterator(this.this$0, this.val$key, paramInt);
  }
  
  public int size()
  {
    LinkedListMultimap.KeyList localKeyList = (LinkedListMultimap.KeyList)LinkedListMultimap.access$600(this.this$0).get(this.val$key);
    if (localKeyList == null) {
      return 0;
    }
    return localKeyList.count;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.LinkedListMultimap.1
 * JD-Core Version:    0.7.0.1
 */