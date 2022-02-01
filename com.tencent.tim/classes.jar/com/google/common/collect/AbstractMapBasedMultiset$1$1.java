package com.google.common.collect;

import java.util.Map;
import java.util.Map.Entry;

class AbstractMapBasedMultiset$1$1
  extends Multisets.AbstractEntry<E>
{
  AbstractMapBasedMultiset$1$1(AbstractMapBasedMultiset.1 param1, Map.Entry paramEntry) {}
  
  public int getCount()
  {
    Count localCount1 = (Count)this.val$mapEntry.getValue();
    if ((localCount1 == null) || (localCount1.get() == 0))
    {
      Count localCount2 = (Count)AbstractMapBasedMultiset.access$000(this.this$1.this$0).get(getElement());
      if (localCount2 != null) {
        return localCount2.get();
      }
    }
    if (localCount1 == null) {
      return 0;
    }
    return localCount1.get();
  }
  
  public E getElement()
  {
    return this.val$mapEntry.getKey();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.AbstractMapBasedMultiset.1.1
 * JD-Core Version:    0.7.0.1
 */