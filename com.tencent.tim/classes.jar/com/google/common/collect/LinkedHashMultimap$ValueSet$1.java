package com.google.common.collect;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedHashMultimap$ValueSet$1
  implements Iterator<V>
{
  int expectedModCount = LinkedHashMultimap.ValueSet.access$100(this.this$1);
  LinkedHashMultimap.ValueSetLink<K, V> nextEntry = LinkedHashMultimap.ValueSet.access$000(this.this$1);
  LinkedHashMultimap.ValueEntry<K, V> toRemove;
  
  LinkedHashMultimap$ValueSet$1(LinkedHashMultimap.ValueSet paramValueSet) {}
  
  private void checkForComodification()
  {
    if (LinkedHashMultimap.ValueSet.access$100(this.this$1) != this.expectedModCount) {
      throw new ConcurrentModificationException();
    }
  }
  
  public boolean hasNext()
  {
    checkForComodification();
    return this.nextEntry != this.this$1;
  }
  
  public V next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    LinkedHashMultimap.ValueEntry localValueEntry = (LinkedHashMultimap.ValueEntry)this.nextEntry;
    Object localObject = localValueEntry.getValue();
    this.toRemove = localValueEntry;
    this.nextEntry = localValueEntry.getSuccessorInValueSet();
    return localObject;
  }
  
  public void remove()
  {
    checkForComodification();
    if (this.toRemove != null) {}
    for (boolean bool = true;; bool = false)
    {
      CollectPreconditions.checkRemove(bool);
      this.this$1.remove(this.toRemove.getValue());
      this.expectedModCount = LinkedHashMultimap.ValueSet.access$100(this.this$1);
      this.toRemove = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.LinkedHashMultimap.ValueSet.1
 * JD-Core Version:    0.7.0.1
 */