package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Iterator;

final class Iterables$13
  implements Function<Iterable<? extends T>, Iterator<? extends T>>
{
  public Iterator<? extends T> apply(Iterable<? extends T> paramIterable)
  {
    return paramIterable.iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterables.13
 * JD-Core Version:    0.7.0.1
 */