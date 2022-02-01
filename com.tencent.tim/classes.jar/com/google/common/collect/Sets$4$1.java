package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;

class Sets$4$1
  extends AbstractIterator<E>
{
  Sets$4$1(Sets.4 param4, Iterator paramIterator1, Iterator paramIterator2) {}
  
  public E computeNext()
  {
    Object localObject;
    while (this.val$itr1.hasNext())
    {
      localObject = this.val$itr1.next();
      if (!this.this$0.val$set2.contains(localObject)) {
        return localObject;
      }
    }
    while (this.val$itr2.hasNext())
    {
      localObject = this.val$itr2.next();
      if (!this.this$0.val$set1.contains(localObject)) {
        return localObject;
      }
    }
    return endOfData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Sets.4.1
 * JD-Core Version:    0.7.0.1
 */