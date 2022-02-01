package com.google.common.collect;

import java.util.Iterator;

final class Iterables$9
  extends FluentIterable<T>
{
  Iterables$9(Iterable paramIterable, int paramInt) {}
  
  public Iterator<T> iterator()
  {
    return Iterators.limit(this.val$iterable.iterator(), this.val$limitSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterables.9
 * JD-Core Version:    0.7.0.1
 */