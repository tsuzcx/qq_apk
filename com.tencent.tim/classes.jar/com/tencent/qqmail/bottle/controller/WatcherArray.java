package com.tencent.qqmail.bottle.controller;

import java.lang.reflect.Array;
import java.util.Iterator;

final class WatcherArray<T>
  implements Iterable<T>, Iterator<T>
{
  private static final int COUNT = 4;
  private int iterableIndex;
  private int wacherIndex;
  private final T[] watchers;
  
  public WatcherArray(Class<T> paramClass)
  {
    this.watchers = ((Object[])Array.newInstance(paramClass, 4));
    this.wacherIndex = 0;
  }
  
  private int indexOf(T paramT)
  {
    int i = 0;
    while (i < 4)
    {
      if (this.watchers[i] == paramT) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void add(T paramT)
  {
    if (indexOf(paramT) < 0)
    {
      this.wacherIndex = (this.wacherIndex + 1 & 0x3);
      this.watchers[this.wacherIndex] = paramT;
    }
  }
  
  public boolean hasNext()
  {
    while ((this.iterableIndex < 4) && (this.watchers[this.iterableIndex] == null)) {
      this.iterableIndex += 1;
    }
    return this.iterableIndex < 4;
  }
  
  public Iterator<T> iterator()
  {
    this.iterableIndex = 0;
    return this;
  }
  
  public int length()
  {
    int j = 0;
    int i = 0;
    while (i < 4)
    {
      int k = j;
      if (this.watchers[i] != null) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public T next()
  {
    Object[] arrayOfObject = this.watchers;
    int i = this.iterableIndex;
    this.iterableIndex = (i + 1);
    return arrayOfObject[i];
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
  
  public void remove(T paramT)
  {
    int i = indexOf(paramT);
    if (i < 0) {
      return;
    }
    this.watchers[i] = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.WatcherArray
 * JD-Core Version:    0.7.0.1
 */