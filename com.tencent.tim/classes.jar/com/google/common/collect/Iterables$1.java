package com.google.common.collect;

import java.util.Iterator;

final class Iterables$1
  extends FluentIterable<T>
{
  Iterables$1(Iterable paramIterable) {}
  
  public Iterator<T> iterator()
  {
    return Iterators.cycle(this.val$iterable);
  }
  
  public String toString()
  {
    return this.val$iterable.toString() + " (cycled)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterables.1
 * JD-Core Version:    0.7.0.1
 */