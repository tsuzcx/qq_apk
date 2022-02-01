package com.google.common.collect;

import java.util.Iterator;

class Multisets$3$1
  extends AbstractIterator<Multiset.Entry<E>>
{
  Multisets$3$1(Multisets.3 param3, Iterator paramIterator1, Iterator paramIterator2) {}
  
  protected Multiset.Entry<E> computeNext()
  {
    Multiset.Entry localEntry;
    Object localObject;
    if (this.val$iterator1.hasNext())
    {
      localEntry = (Multiset.Entry)this.val$iterator1.next();
      localObject = localEntry.getElement();
      return Multisets.immutableEntry(localObject, localEntry.getCount() + this.this$0.val$multiset2.count(localObject));
    }
    while (this.val$iterator2.hasNext())
    {
      localEntry = (Multiset.Entry)this.val$iterator2.next();
      localObject = localEntry.getElement();
      if (!this.this$0.val$multiset1.contains(localObject)) {
        return Multisets.immutableEntry(localObject, localEntry.getCount());
      }
    }
    return (Multiset.Entry)endOfData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Multisets.3.1
 * JD-Core Version:    0.7.0.1
 */