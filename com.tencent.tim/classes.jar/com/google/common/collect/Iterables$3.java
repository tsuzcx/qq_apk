package com.google.common.collect;

import java.util.Iterator;
import java.util.List;

final class Iterables$3
  extends FluentIterable<List<T>>
{
  Iterables$3(Iterable paramIterable, int paramInt) {}
  
  public Iterator<List<T>> iterator()
  {
    return Iterators.paddedPartition(this.val$iterable.iterator(), this.val$size);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterables.3
 * JD-Core Version:    0.7.0.1
 */