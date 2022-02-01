package com.google.common.collect;

import java.util.Iterator;

final class Iterables$11
  extends FluentIterable<T>
{
  Iterables$11(Iterable paramIterable) {}
  
  public Iterator<T> iterator()
  {
    return Iterators.consumingIterator(this.val$iterable.iterator());
  }
  
  public String toString()
  {
    return "Iterables.consumingIterable(...)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterables.11
 * JD-Core Version:    0.7.0.1
 */