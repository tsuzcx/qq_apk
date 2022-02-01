package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class Iterators$8
  implements Iterator<T>
{
  private int count;
  
  Iterators$8(int paramInt, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return (this.count < this.val$limitSize) && (this.val$iterator.hasNext());
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    this.count += 1;
    return this.val$iterator.next();
  }
  
  public void remove()
  {
    this.val$iterator.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterators.8
 * JD-Core Version:    0.7.0.1
 */