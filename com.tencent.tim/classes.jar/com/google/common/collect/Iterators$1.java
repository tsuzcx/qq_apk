package com.google.common.collect;

import java.util.NoSuchElementException;

final class Iterators$1
  extends UnmodifiableListIterator<Object>
{
  public boolean hasNext()
  {
    return false;
  }
  
  public boolean hasPrevious()
  {
    return false;
  }
  
  public Object next()
  {
    throw new NoSuchElementException();
  }
  
  public int nextIndex()
  {
    return 0;
  }
  
  public Object previous()
  {
    throw new NoSuchElementException();
  }
  
  public int previousIndex()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterators.1
 * JD-Core Version:    0.7.0.1
 */