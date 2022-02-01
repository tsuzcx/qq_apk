package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

class LinkedHashMultimap$1
  implements Iterator<Map.Entry<K, V>>
{
  LinkedHashMultimap.ValueEntry<K, V> nextEntry = LinkedHashMultimap.access$300(this.this$0).successorInMultimap;
  LinkedHashMultimap.ValueEntry<K, V> toRemove;
  
  LinkedHashMultimap$1(LinkedHashMultimap paramLinkedHashMultimap) {}
  
  public boolean hasNext()
  {
    return this.nextEntry != LinkedHashMultimap.access$300(this.this$0);
  }
  
  public Map.Entry<K, V> next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    LinkedHashMultimap.ValueEntry localValueEntry = this.nextEntry;
    this.toRemove = localValueEntry;
    this.nextEntry = this.nextEntry.successorInMultimap;
    return localValueEntry;
  }
  
  public void remove()
  {
    if (this.toRemove != null) {}
    for (boolean bool = true;; bool = false)
    {
      CollectPreconditions.checkRemove(bool);
      this.this$0.remove(this.toRemove.getKey(), this.toRemove.getValue());
      this.toRemove = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.LinkedHashMultimap.1
 * JD-Core Version:    0.7.0.1
 */