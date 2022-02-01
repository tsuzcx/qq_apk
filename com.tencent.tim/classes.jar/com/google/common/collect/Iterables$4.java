package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Iterator;

final class Iterables$4
  extends FluentIterable<T>
{
  Iterables$4(Iterable paramIterable, Predicate paramPredicate) {}
  
  public Iterator<T> iterator()
  {
    return Iterators.filter(this.val$unfiltered.iterator(), this.val$retainIfTrue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterables.4
 * JD-Core Version:    0.7.0.1
 */