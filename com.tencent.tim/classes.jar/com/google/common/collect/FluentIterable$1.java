package com.google.common.collect;

import java.util.Iterator;

final class FluentIterable$1
  extends FluentIterable<E>
{
  FluentIterable$1(Iterable paramIterable1, Iterable paramIterable2)
  {
    super(paramIterable1);
  }
  
  public Iterator<E> iterator()
  {
    return this.val$iterable.iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.FluentIterable.1
 * JD-Core Version:    0.7.0.1
 */