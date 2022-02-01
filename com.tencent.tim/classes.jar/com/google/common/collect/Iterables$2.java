package com.google.common.collect;

import java.util.Iterator;
import java.util.List;

final class Iterables$2
  extends FluentIterable<List<T>>
{
  Iterables$2(Iterable paramIterable, int paramInt) {}
  
  public Iterator<List<T>> iterator()
  {
    return Iterators.partition(this.val$iterable.iterator(), this.val$size);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterables.2
 * JD-Core Version:    0.7.0.1
 */