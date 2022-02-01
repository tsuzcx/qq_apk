package com.google.common.collect;

import java.util.Iterator;

final class Iterators$ConcatenatedIterator$1
  extends MultitransformedIterator<Iterator<? extends T>, Iterator<? extends T>>
{
  Iterators$ConcatenatedIterator$1(Iterator paramIterator)
  {
    super(paramIterator);
  }
  
  Iterator<? extends Iterator<? extends T>> transform(Iterator<? extends T> paramIterator)
  {
    if ((paramIterator instanceof Iterators.ConcatenatedIterator)) {
      return Iterators.ConcatenatedIterator.access$000(((Iterators.ConcatenatedIterator)paramIterator).backingIterator);
    }
    return Iterators.singletonIterator(paramIterator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterators.ConcatenatedIterator.1
 * JD-Core Version:    0.7.0.1
 */