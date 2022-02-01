package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

@GwtCompatible
abstract class AbstractIndexedListIterator<E>
  extends UnmodifiableListIterator<E>
{
  private int position;
  private final int size;
  
  protected AbstractIndexedListIterator(int paramInt)
  {
    this(paramInt, 0);
  }
  
  protected AbstractIndexedListIterator(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndex(paramInt2, paramInt1);
    this.size = paramInt1;
    this.position = paramInt2;
  }
  
  protected abstract E get(int paramInt);
  
  public final boolean hasNext()
  {
    return this.position < this.size;
  }
  
  public final boolean hasPrevious()
  {
    return this.position > 0;
  }
  
  public final E next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    int i = this.position;
    this.position = (i + 1);
    return get(i);
  }
  
  public final int nextIndex()
  {
    return this.position;
  }
  
  public final E previous()
  {
    if (!hasPrevious()) {
      throw new NoSuchElementException();
    }
    int i = this.position - 1;
    this.position = i;
    return get(i);
  }
  
  public final int previousIndex()
  {
    return this.position - 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.AbstractIndexedListIterator
 * JD-Core Version:    0.7.0.1
 */