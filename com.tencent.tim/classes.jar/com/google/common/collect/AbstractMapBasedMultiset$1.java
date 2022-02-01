package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class AbstractMapBasedMultiset$1
  implements Iterator<Multiset.Entry<E>>
{
  Map.Entry<E, Count> toRemove;
  
  AbstractMapBasedMultiset$1(AbstractMapBasedMultiset paramAbstractMapBasedMultiset, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return this.val$backingEntries.hasNext();
  }
  
  public Multiset.Entry<E> next()
  {
    Map.Entry localEntry = (Map.Entry)this.val$backingEntries.next();
    this.toRemove = localEntry;
    return new AbstractMapBasedMultiset.1.1(this, localEntry);
  }
  
  public void remove()
  {
    if (this.toRemove != null) {}
    for (boolean bool = true;; bool = false)
    {
      CollectPreconditions.checkRemove(bool);
      AbstractMapBasedMultiset.access$122(this.this$0, ((Count)this.toRemove.getValue()).getAndSet(0));
      this.val$backingEntries.remove();
      this.toRemove = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.AbstractMapBasedMultiset.1
 * JD-Core Version:    0.7.0.1
 */