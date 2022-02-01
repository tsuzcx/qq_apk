package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;

final class Iterables$12
  extends FluentIterable<T>
{
  Iterables$12(Iterable paramIterable, Comparator paramComparator) {}
  
  public Iterator<T> iterator()
  {
    return Iterators.mergeSorted(Iterables.transform(this.val$iterables, Iterables.toIterator()), this.val$comparator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterables.12
 * JD-Core Version:    0.7.0.1
 */