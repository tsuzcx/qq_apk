package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Iterator;

final class Iterables$6
  extends FluentIterable<T>
{
  Iterables$6(Iterable paramIterable, Function paramFunction) {}
  
  public Iterator<T> iterator()
  {
    return Iterators.transform(this.val$fromIterable.iterator(), this.val$function);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterables.6
 * JD-Core Version:    0.7.0.1
 */