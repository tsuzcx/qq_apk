package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Iterator;

final class Iterators$6
  extends AbstractIterator<T>
{
  Iterators$6(Iterator paramIterator, Predicate paramPredicate) {}
  
  protected T computeNext()
  {
    while (this.val$unfiltered.hasNext())
    {
      Object localObject = this.val$unfiltered.next();
      if (this.val$retainIfTrue.apply(localObject)) {
        return localObject;
      }
    }
    return endOfData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterators.6
 * JD-Core Version:    0.7.0.1
 */