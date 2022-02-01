package com.google.common.collect;

import java.util.Iterator;

class Iterables$8$1
  implements Iterator<T>
{
  boolean atStart = true;
  
  Iterables$8$1(Iterables.8 param8, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return this.val$iterator.hasNext();
  }
  
  public T next()
  {
    Object localObject = this.val$iterator.next();
    this.atStart = false;
    return localObject;
  }
  
  public void remove()
  {
    if (!this.atStart) {}
    for (boolean bool = true;; bool = false)
    {
      CollectPreconditions.checkRemove(bool);
      this.val$iterator.remove();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterables.8.1
 * JD-Core Version:    0.7.0.1
 */