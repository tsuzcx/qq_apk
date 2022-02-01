package com.google.common.collect;

import java.util.Iterator;

final class Iterators$3
  extends UnmodifiableIterator<T>
{
  Iterators$3(Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return this.val$iterator.hasNext();
  }
  
  public T next()
  {
    return this.val$iterator.next();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterators.3
 * JD-Core Version:    0.7.0.1
 */