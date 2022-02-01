package com.google.common.collect;

import java.util.Iterator;
import java.util.Queue;

final class Iterables$10
  extends FluentIterable<T>
{
  Iterables$10(Iterable paramIterable) {}
  
  public Iterator<T> iterator()
  {
    return new ConsumingQueueIterator((Queue)this.val$iterable);
  }
  
  public String toString()
  {
    return "Iterables.consumingIterable(...)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterables.10
 * JD-Core Version:    0.7.0.1
 */