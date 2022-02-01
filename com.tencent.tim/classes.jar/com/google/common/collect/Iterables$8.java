package com.google.common.collect;

import java.util.Iterator;

final class Iterables$8
  extends FluentIterable<T>
{
  Iterables$8(Iterable paramIterable, int paramInt) {}
  
  public Iterator<T> iterator()
  {
    Iterator localIterator = this.val$iterable.iterator();
    Iterators.advance(localIterator, this.val$numberToSkip);
    return new Iterables.8.1(this, localIterator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterables.8
 * JD-Core Version:    0.7.0.1
 */