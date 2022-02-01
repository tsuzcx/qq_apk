package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class Iterators$2
  implements Iterator<Object>
{
  public boolean hasNext()
  {
    return false;
  }
  
  public Object next()
  {
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    CollectPreconditions.checkRemove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterators.2
 * JD-Core Version:    0.7.0.1
 */