package com.google.common.collect;

import java.util.Iterator;

final class Iterators$9
  extends UnmodifiableIterator<T>
{
  Iterators$9(Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return this.val$iterator.hasNext();
  }
  
  public T next()
  {
    Object localObject = this.val$iterator.next();
    this.val$iterator.remove();
    return localObject;
  }
  
  public String toString()
  {
    return "Iterators.consumingIterator(...)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterators.9
 * JD-Core Version:    0.7.0.1
 */