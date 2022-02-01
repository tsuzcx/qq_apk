package com.google.common.collect;

import java.util.Enumeration;
import java.util.Iterator;

final class Iterators$13
  implements Enumeration<T>
{
  Iterators$13(Iterator paramIterator) {}
  
  public boolean hasMoreElements()
  {
    return this.val$iterator.hasNext();
  }
  
  public T nextElement()
  {
    return this.val$iterator.next();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterators.13
 * JD-Core Version:    0.7.0.1
 */