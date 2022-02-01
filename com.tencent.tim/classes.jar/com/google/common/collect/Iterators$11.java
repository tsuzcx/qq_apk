package com.google.common.collect;

import java.util.NoSuchElementException;

final class Iterators$11
  extends UnmodifiableIterator<T>
{
  boolean done;
  
  Iterators$11(Object paramObject) {}
  
  public boolean hasNext()
  {
    return !this.done;
  }
  
  public T next()
  {
    if (this.done) {
      throw new NoSuchElementException();
    }
    this.done = true;
    return this.val$value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterators.11
 * JD-Core Version:    0.7.0.1
 */