package com.google.common.collect;

import java.util.Iterator;

final class Iterables$5
  extends FluentIterable<T>
{
  Iterables$5(Iterable paramIterable, Class paramClass) {}
  
  public Iterator<T> iterator()
  {
    return Iterators.filter(this.val$unfiltered.iterator(), this.val$desiredType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterables.5
 * JD-Core Version:    0.7.0.1
 */