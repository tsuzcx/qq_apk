package com.google.common.collect;

import java.util.Iterator;

final class FluentIterable$2
  extends FluentIterable<T>
{
  FluentIterable$2(Iterable paramIterable) {}
  
  public Iterator<T> iterator()
  {
    return Iterators.concat(Iterables.transform(this.val$inputs, Iterables.toIterator()).iterator());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.FluentIterable.2
 * JD-Core Version:    0.7.0.1
 */