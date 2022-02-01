package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class Iterators$4
  implements Iterator<T>
{
  Iterator<T> iterator = Iterators.emptyModifiableIterator();
  
  Iterators$4(Iterable paramIterable) {}
  
  public boolean hasNext()
  {
    return (this.iterator.hasNext()) || (this.val$iterable.iterator().hasNext());
  }
  
  public T next()
  {
    if (!this.iterator.hasNext())
    {
      this.iterator = this.val$iterable.iterator();
      if (!this.iterator.hasNext()) {
        throw new NoSuchElementException();
      }
    }
    return this.iterator.next();
  }
  
  public void remove()
  {
    this.iterator.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterators.4
 * JD-Core Version:    0.7.0.1
 */