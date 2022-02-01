package com.google.common.collect;

import java.util.Comparator;

class Iterators$MergingIterator$1
  implements Comparator<PeekingIterator<T>>
{
  Iterators$MergingIterator$1(Iterators.MergingIterator paramMergingIterator, Comparator paramComparator) {}
  
  public int compare(PeekingIterator<T> paramPeekingIterator1, PeekingIterator<T> paramPeekingIterator2)
  {
    return this.val$itemComparator.compare(paramPeekingIterator1.peek(), paramPeekingIterator2.peek());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterators.MergingIterator.1
 * JD-Core Version:    0.7.0.1
 */