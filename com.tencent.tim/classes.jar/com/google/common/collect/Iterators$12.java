package com.google.common.collect;

import java.util.Enumeration;

final class Iterators$12
  extends UnmodifiableIterator<T>
{
  Iterators$12(Enumeration paramEnumeration) {}
  
  public boolean hasNext()
  {
    return this.val$enumeration.hasMoreElements();
  }
  
  public T next()
  {
    return this.val$enumeration.nextElement();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterators.12
 * JD-Core Version:    0.7.0.1
 */