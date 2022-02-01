package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class AbstractMapBasedMultimap$KeySet$1
  implements Iterator<K>
{
  Map.Entry<K, Collection<V>> entry;
  
  AbstractMapBasedMultimap$KeySet$1(AbstractMapBasedMultimap.KeySet paramKeySet, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return this.val$entryIterator.hasNext();
  }
  
  public K next()
  {
    this.entry = ((Map.Entry)this.val$entryIterator.next());
    return this.entry.getKey();
  }
  
  public void remove()
  {
    if (this.entry != null) {}
    for (boolean bool = true;; bool = false)
    {
      CollectPreconditions.checkRemove(bool);
      Collection localCollection = (Collection)this.entry.getValue();
      this.val$entryIterator.remove();
      AbstractMapBasedMultimap.access$220(this.this$1.this$0, localCollection.size());
      localCollection.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.AbstractMapBasedMultimap.KeySet.1
 * JD-Core Version:    0.7.0.1
 */